//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.query;



/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Mar 24, 2015
 */
public class OrganisationQueryImpl extends BaseQueryImpl {

    private static final String ORG_QUERY = "SELECT org FROM OrganisationImpl org";

    private static final String ORG_COUNR_QUERY = "SELECT count(*) FROM OrganisationImpl org";

    public OrganisationQueryImpl() {
        super(ORG_QUERY, ORG_COUNR_QUERY);
        // TODO Auto-generated constructor stub
    }

    public void filterByOrganisationType(int organisationTypeId) {
        filterBy("org.organisationType=" + organisationTypeId);
    }

    public void filterByParentOrgId(long parentId) {
        filterBy("org.parentOrganisation.orgId=" + parentId);
    }

    public void filterByOrgId(long orgId) {
        filterBy("org.orgId=" + orgId);

    }
    public void filterByStatus(int statusId) {
        filterBy("org.auditData.status=" + statusId);
    }
    


}
