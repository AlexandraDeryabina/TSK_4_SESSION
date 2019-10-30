package ru.lanit.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class SessionLocaleFilter implements Filter {
    public final static String SESSION_LOCALE = "sessionLocale";

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        if (req.getParameter(SESSION_LOCALE) != null) {
            req.getSession().setAttribute("lang", req.getParameter(SESSION_LOCALE));
        }
        chain.doFilter(request, response);
    }
    public void destroy() {}
    public void init(FilterConfig arg0) throws ServletException {}
}
