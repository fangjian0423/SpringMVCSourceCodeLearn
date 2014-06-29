package org.format.demo.interceptor;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class TestInterceptor implements WebRequestInterceptor {


    @Override
    public void preHandle(WebRequest request) throws Exception {
        System.out.println(1);
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {
        System.out.println(2);
    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
        System.out.println(3);
    }
}
