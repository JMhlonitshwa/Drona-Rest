//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Mar 31, 2015
 */
public class CalenderUtil {

    public static String getDate(Calendar createdDate) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return format.parse(createdDate.getTime().toString()).toString();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;


    }

}
