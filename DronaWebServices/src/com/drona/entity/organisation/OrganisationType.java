//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.entity.organisation;


public enum OrganisationType {
    ORGANISATION(1,"Organisation"),
    INSTITUTE(2,"Institute");
    
    private OrganisationType(int organisationTypeId, String typeName) {
        this.organisationTypeId = organisationTypeId;
        this.typeName = typeName;
    }
    private int organisationTypeId;
    private String typeName;
    
    public int getOrganisationTypeId() {
        return organisationTypeId;
    }
    
    public String getTypeName() {
        return typeName;
    }
    public static OrganisationType getOrganisationType(int organisationTypeId ){
    for(OrganisationType orgType:OrganisationType.values()){
        if(orgType.getOrganisationTypeId()==organisationTypeId){
            return orgType;
        }
    }
    return null;
    }
    

}
