//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.controller.organisation;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drona.common.Constants;
import com.drona.common.exception.EnityNotFoundException;
import com.drona.common.json.AuditeJson;
import com.drona.common.json.JsonResponse;
import com.drona.controller.BaseController;

/**
 * Organization API which handles get ,create and updating of organization related data.
 * 
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Mar 23, 2015
 */
@Controller
@RequestMapping(value = "/organisation")
public class OrganisationController extends BaseController {

    private static final Logger logger = Logger.getLogger(OrganisationController.class);

    @Autowired
    private OrganisationService organisationService;

    /**
     * @param orgId
     * @param orgType
     * @param status
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody OrganisationJsonResponse getCollection(
            @RequestParam(value = "orgId", required=false) Long orgId,
            @RequestParam(value = "orgType", required = true) Integer orgType,
            @RequestParam(value = "status", defaultValue = "Active") String status) {
        validateRequest(orgType, orgId);

        return organisationService.getAllOrganization(orgId, orgType, status);

    }

    private void validateRequest(Integer orgType, Long orgId) {
        // validate here

    }

    /**
     * @param request
     * @param session
     * @return
     * @throws EnityNotFoundException
     */
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody JsonResponse createEntity(@RequestBody OrganisationJsonRequest request,
            HttpSession session) {
        // TODO: request validation
        logger.info("Creating organisation with name:" + request.getOrgnaistaionName());
        long userId = Long.parseLong((String) session.getAttribute(Constants.USERID));

        // Create organization.
        long orgId = 0;
        try {
            orgId =
                organisationService.createOrganizationAndUser(request.getOrgnaistaionName(),
                    request.getUsers(), userId, request.getParentOrgId());
        } catch (EnityNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return buildResponse(orgId, userId, request.getOrgnaistaionName());
    }


    private OrganisationJsonResponse buildResponse(long orgId, long userId, String organisationName) {
        OrganisationJsonResponse response = new OrganisationJsonResponse();
        AuditeJson auditJson = new AuditeJson();
        auditJson.setCreatedBy(userId);
        auditJson.setCreatedDate(new Date().toString());
        return response;


    }



}
