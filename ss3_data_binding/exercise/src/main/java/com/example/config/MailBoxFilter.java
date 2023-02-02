package com.example.config;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//khắc phục lỗi phông chữ
@WebFilter(filterName = "MailBoxFilter", value = "/*")
public class MailBoxFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
