package com.drona.common;



/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com>
 * Created on Mar 25, 2015
 */
public class UserContextRetriver {

    private static  ThreadLocal<UserContext> userContext = new ThreadLocal<UserContext>();

    /**
     * @return
     */
    public static UserContext getUserContext() {
        return userContext.get();
    }

    /**
     * @param u
     */
    public static void setUserContext(long userId ,long orgId) {
        userContext.set(new UserContext(userId, orgId));
    }

    /**
     * 
     */
    public static void remove() {
        userContext.remove();
    }

}
