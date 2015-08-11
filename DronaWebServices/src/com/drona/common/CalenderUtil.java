//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Mar 31, 2015
 */
public class CalenderUtil {

    public static String getDate(Calendar createdDate) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
      
            return format.format(createdDate.getTime());    
      

    }

}
