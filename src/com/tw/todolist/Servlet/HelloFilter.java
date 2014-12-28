package com.tw.todolist.Servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by minchina on 14-12-26.
 */
public class HelloFilter implements Filter {

    @Override
    public void init(FilterConfig arg0){
        System.out.println("Filter init");
    }

    @Override
    public void doFilter(ServletRequest request,ServletResponse response,FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println();
        System.out.println("拦截 URI="+req.getRequestURI());
        filterChain.doFilter(req, response);
        request.getRequestDispatcher("usertodolist.jsp").forward(request, response);
    }
    @Override
    public void destroy(){
        System.out.println("filter done");
    }
}
