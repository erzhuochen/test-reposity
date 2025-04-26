package com.itheima.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;


//@WebFilter(urlPatterns = "/*")
@Slf4j
public class DemoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init 初始化方法。。。。");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("拦截到了请求。。。");
        //放行
        filterChain.doFilter(servletRequest, servletResponse);

        log.info("放行后");




    }

    @Override
    public void destroy() {
        log.info("destroy 销毁方法。。。");
    }
}
