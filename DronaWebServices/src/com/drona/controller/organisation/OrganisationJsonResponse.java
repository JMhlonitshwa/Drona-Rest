//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.controller.organisation;

import java.util.List;

import com.drona.common.json.JsonResponse;


public class OrganisationJsonResponse extends JsonResponse {

    private InstituteJson organisation;

    private List<InstituteJson> institutes;

    
    public InstituteJson getOrganisation() {
        return organisation;
    }

    
    public void setOrganisation(InstituteJson organisation) {
        this.organisation = organisation;
    }

    
    public List<InstituteJson> getInstitutes() {
        return institutes;
    }

    
    public void setInstitutes(List<InstituteJson> institutes) {
        this.institutes = institutes;
    }

   

}
