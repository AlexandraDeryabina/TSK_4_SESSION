package ru.lanit.filter;

import ru.lanit.service.ContentCaptureResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.logging.Logger;

@WebFilter("/*")
public class LogFilter implements Filter {
    private static Logger log = Logger.getLogger(LogFilter.class.getName());

    public void init(FilterConfig filterConfig) {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        ContentCaptureResponse contentCaptureResponse = new ContentCaptureResponse(resp);

        chain.doFilter(request, contentCaptureResponse);
        String content = contentCaptureResponse.getContent();
        // content.length();
        // оригинальный response у нас будет пуст, так как в doFilter() мы подменили объект, поэтому пишем в outputStream оригинального response контент, который получили в ответе
        response.getOutputStream().write(content.getBytes(StandardCharsets.UTF_8));

        log.info("LogFilter. " + "\n REQUEST INFO: \n" + getRequestParams(req)
                + "\n RESPONSE INFO: \n status: " + resp.getStatus()
                + "\n - contentLength: " + contentCaptureResponse.getContentLength()
                + "\n - content: " + contentCaptureResponse.getContent());
    }

    public void destroy() {}

    private String getRequestParams(HttpServletRequest request) {
        String method = request.getMethod();
        String scheme = request.getScheme();
        StringBuffer url = request.getRequestURL();

        Map<String, String[]> allMap = request.getParameterMap();
        StringBuilder params = new StringBuilder();
        for (String key : allMap.keySet()) {
            String[] strArr = allMap.get(key);
            for (String val : strArr) {
                params.append("param: ").append(key).append(", value: ").append(val).append("; ");
            }
        }

        return "\n Method: " + method + "\n - scheme: " + scheme + "\n - url: " + url + "\n - params: " + params;
    }
}
