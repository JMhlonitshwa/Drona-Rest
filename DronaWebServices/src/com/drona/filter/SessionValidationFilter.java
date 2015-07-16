package com.drona.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.drona.common.GenericRepository;
import com.drona.common.StringUtil;
import com.drona.common.UserContextRetriver;
import com.drona.common.exception.ApplicationException;
import com.drona.entity.SessionImpl;
import com.drona.query.SessionQueryImpl;

/**
 * Servlet Filter implementation class SessionValidationFilter
 */
public class SessionValidationFilter implements Filter {

    private String excludeUrl;

    @Autowired
    private GenericRepository genericRepository;

    /**
     * Default constructor.
     */
    public SessionValidationFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        // place your code here
        try {
            if (!((HttpServletRequest) request).getRequestURI().contains(excludeUrl)) {
                // validate the session
                long userId = Long.parseLong(request.getParameter("userId"));
                String token = request.getParameter("token");
                validateSession(userId, token, request);

                long orgId = 0L;
                if (!StringUtil.isEmptyOrBlank(request.getParameter("orgId"))) {
                    orgId = Long.parseLong(request.getParameter("orgId"));
                }
                // set context
                UserContextRetriver.setUserContext(userId, orgId);
            }

            // pass the request along the filter chain
            chain.doFilter(request, response);
        } catch (Exception e) {

        } finally {
            UserContextRetriver.remove();
        }
    }

    private void validateSession(long userId, String token, ServletRequest request)
            throws ApplicationException {
        // TODO Auto-generated method stub
        SessionQueryImpl query = new SessionQueryImpl();
        query.filterByUserId(userId);
        SessionImpl session = (SessionImpl) genericRepository.findSingle(query.getQuery());
        HttpSession httpSession = ((HttpServletRequest) request).getSession(false);
        if (!session.getToken().equals(token) && httpSession != null
            && session.getSessionId().equals(httpSession.getId())) {
            throw new ApplicationException("Invalid Token");
        }

    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        excludeUrl = fConfig.getInitParameter("excludeUrl");
    }

}
