//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.controller.organisation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.drona.common.AbstractBaseService;
import com.drona.common.GenericRepository;
import com.drona.common.StatusEnum;
import com.drona.common.StringUtil;
import com.drona.common.UserRoleType;
import com.drona.common.exception.ApplicationException;
import com.drona.common.exception.EnityNotFoundException;
import com.drona.common.json.UserJson;
import com.drona.controller.UserService;
import com.drona.entity.organisation.OrganisationImpl;
import com.drona.entity.organisation.OrganisationType;
import com.drona.query.OrganisationQueryImpl;

/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Apr 7, 2015
 */
@Component
public class OrganisationService extends AbstractBaseService {

    @Autowired
    private UserService userService;

    @Autowired
    private GenericRepository genericRepository;

    /**
     * @param orgnaistaionName
     * @param users
     * @param createdBy
     * @param parentOrgId
     * @return
     * @throws EnityNotFoundException
     */
    @Transactional
    public long createOrganizationAndUser(String orgnaistaionName, List<UserJson> users,
            long createdBy, String parentOrgId) throws EnityNotFoundException {
        OrganisationImpl organisation = null;
        boolean isOrg = StringUtil.isEmptyOrBlank(parentOrgId) ? true : false;
        if (!isOrg) {
            // Create institute
            organisation =
                createOrganistion(orgnaistaionName, OrganisationType.INSTITUTE, parentOrgId);
            // create Principal user.
            if (users != null && !users.isEmpty()) {
                // checking for role only one user can be principal for institute.
                List<UserJson> pricipalUser = checkForRole(users, UserRoleType.PRINCIPAL);
                userService.createUsers(pricipalUser, organisation.getOrgId());
            }

        } else {
            organisation =
                createOrganistion(orgnaistaionName, OrganisationType.ORGANISATION, parentOrgId);
        }

        return organisation.getOrgId();
    }

    private List<UserJson> checkForRole(List<UserJson> users, UserRoleType roleType) {
        // TODO Auto-generated method stub
        List<UserJson> validUser = new ArrayList<UserJson>();
        for (UserJson user : users) {
            if (roleType.getRoleType().equalsIgnoreCase(user.getUserRole())) {
                validUser.add(user);
                return validUser;
            }
        }
        return null;
    }

    private OrganisationImpl createOrganistion(String orgName, OrganisationType orgType,
            String parentorgId) throws EnityNotFoundException {
        OrganisationImpl organisation = new OrganisationImpl();
        organisation.setOrgName(orgName);
        if (!StringUtil.isEmptyOrBlank(parentorgId)) {
            OrganisationQueryImpl query = new OrganisationQueryImpl();
            query.filterByOrgId(Long.parseLong(parentorgId));
            OrganisationImpl parentOrganisation =
                (OrganisationImpl) genericRepository.findSingle(query.getQuery());
            organisation.setParentOrganisation(parentOrganisation);

        }
        return organisation;

    }

    public OrganisationJsonResponse getAllOrganization(long orgId, int orgTypeId, String status) {
        OrganisationJsonResponse response = new OrganisationJsonResponse();
        OrganisationQueryImpl query = new OrganisationQueryImpl();
        query.filterByOrganisationType(orgTypeId);
        query.filterByStatus(StatusEnum.valueOf(status.toUpperCase()).getId());
        try {
            OrganisationImpl organisation =
                (OrganisationImpl) genericRepository.findSingle(query.getQuery());
            response = new OrganisationJsonResponse();

            if (organisation.getOrganisationType().equals(
                OrganisationType.ORGANISATION.getOrganisationTypeId())) {
                OrganisationQueryImpl instituteQuery = new OrganisationQueryImpl();
                instituteQuery.filterByParentOrgId(organisation.getParentOrganisation().getOrgId());
                List<OrganisationImpl> institutes =
                    genericRepository.find(instituteQuery.getQuery());
                response.setInstitutes(convertToJsonInstitute(institutes));

            }

        } catch (EnityNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return response;
    }

    private List<InstituteJson> convertToJsonInstitute(List<OrganisationImpl> institutes) {
        List<InstituteJson> institutesList = new ArrayList<InstituteJson>();
        for (OrganisationImpl institute : institutes) {
            InstituteJson instituteJson;
            try {
                instituteJson =
                    new InstituteJson(institute.getOrgId(), institute.getOrgName(), StatusEnum
                            .getStatusEnum(institute.getAuditData().getStatus()).getStatus(), null);
                instituteJson.setAuditData(convertAuditDataTOJAuditJsonData(institute
                        .getAuditData()));
                instituteJson.setAddress(convertAddressTOJAddressJsonData(institute.getAddress()));
                institutesList.add(instituteJson);

            } catch (ApplicationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return institutesList;
    }




}
