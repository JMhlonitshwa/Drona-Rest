//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.entity.organisation;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.drona.entity.AddressImpl;
import com.drona.entity.AuditData;

/**
 * it is entity class for Organisation
 * 
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Mar 18, 2015
 */
@Entity
@Table(name = "ORGANISATION")
public class OrganisationImpl {

    @Id
    @Column(name = "ORGANISATION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orgId;

    @Column(name = "ORGANISATION_NAME", length = 50, nullable = false)
    private String orgName;

    @Column(name = "LOGO_FILE_PATH", length = 100)
    private String logoFilePath;

    @Column(name = "Org_Type", length = 1, nullable = false)
    private Integer organisationType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Parent_Org_Id")
    private OrganisationImpl parentOrganisation;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ADDRESS_ID_FK")
    private AddressImpl address;

    @Column(name = "STATUS", length = 1, nullable = false)
    private int status;

    @Embedded
    private AuditData auditData;


    public Long getOrgId() {
        return orgId;
    }


    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }


    public String getOrgName() {
        return orgName;
    }


    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }


    public String getLogoFilePath() {
        return logoFilePath;
    }


    public void setLogoFilePath(String logoFilePath) {
        this.logoFilePath = logoFilePath;
    }


    public AddressImpl getAddress() {
        return address;
    }


    public void setAddress(AddressImpl address) {
        this.address = address;
    }




    public Integer getOrganisationType() {
        return organisationType;
    }



    public void setOrganisationType(Integer organisationType) {
        this.organisationType = organisationType;
    }



    public OrganisationImpl getParentOrganisation() {
        return parentOrganisation;
    }



    public void setParentOrganisation(OrganisationImpl parentOrganisation) {
        this.parentOrganisation = parentOrganisation;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public AuditData getAuditData() {
        return auditData;
    }


    public void setAuditData(AuditData auditData) {
        this.auditData = auditData;
    }


}
