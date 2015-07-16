//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.common;


/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Mar 25, 2015
 */
public class StringUtil {

    /**
     * returns true if string is null, empty and blank;
     * 
     * @param string
     * @return
     */
    public static boolean isEmptyOrBlank(String string) {
        if (string != null && !string.isEmpty() && string != "") {
            return false;
        }
        return true;
    }
}
