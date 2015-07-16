//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.common;


public class Test {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                new UserContext(1, 1);
                UserContextRetriver.setUserContext(1,1);
                //here we call a method where the thread context is not passed as parameter
              printThreadContextValues();
            }

           
        }).start();
        new Thread(new Runnable() {
            public void run() {
                new UserContext(2, 2);
                UserContextRetriver.setUserContext(2,2);
                //here we call a method where the thread context is not passed as parameter
               printThreadContextValues();
            }
        }).start();
    }
    private static void printThreadContextValues() {
        // TODO Auto-generated method stub
        UserContext threadContext=UserContextRetriver.getUserContext();
        
            UserContextRetriver.remove();
      
        System.out.println(threadContext.getUserId()+" "+threadContext.getOrgId());
        
        
    }
}
