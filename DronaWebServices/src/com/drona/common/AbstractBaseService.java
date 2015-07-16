//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.common;

import com.drona.common.json.AddressJson;
import com.drona.common.json.AuditeJson;
import com.drona.entity.AddressImpl;
import com.drona.entity.AuditData;


/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Mar 31, 2015
 */
public class AbstractBaseService {

    /**
     * @param auditData
     * @return
     */
    protected AuditeJson convertAuditDataTOJAuditJsonData(AuditData auditData) {
        AuditeJson auditJson = new AuditeJson();
        auditJson.setCreatedBy(auditData.getCreatedBy());
        auditJson.setCreatedDate(CalenderUtil.getDate(auditData.getCreatedDate()));
        if (auditData.getLastModifiedBy() != null) {
            auditJson.setLastModifiedBy(auditData.getLastModifiedBy());
            auditJson.setLastModifiedDate(auditData.getLastModifiedDate().toString());
        }
        return auditJson;
    }

    protected AddressJson convertAddressTOJAddressJsonData(AddressImpl address) {
        AddressJson addressJson = new AddressJson();
        addressJson.setAddressId(address.getAddressId());
        addressJson.setCity(address.getCity());
        addressJson.setState(address.getState());
        addressJson.setStree1(address.getStreet1());
        addressJson.setStree2(address.getStreet2());
        return addressJson;
    }
}
