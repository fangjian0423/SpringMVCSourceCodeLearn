package org.format.demo.support.exceptionResolver;

import org.springframework.web.bind.support.DefaultDataBinderFactory;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.ServletRequestDataBinderFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class MyExceptionHandlerExceptionResolver extends ExceptionHandlerExceptionResolver {

    public MyExceptionHandlerExceptionResolver() {
        List<HandlerMethodArgumentResolver> list = new ArrayList<HandlerMethodArgumentResolver>();
        list.add(new ServletModelAttributeMethodProcessor(true));
        this.setCustomArgumentResolvers(list);
    }

    @Override
    protected ModelAndView doResolveHandlerMethodException(HttpServletRequest request,
                                                           HttpServletResponse response, HandlerMethod handlerMethod, Exception exception) {

        ServletInvocableHandlerMethod exceptionHandlerMethod = getExceptionHandlerMethod(handlerMethod, exception);
        if (exceptionHandlerMethod == null) {
            return null;
        }

        //ServletModelAttributeMethodProcessor 内部会使用传递进来的WebDataBinderFactory参数，该参数由ServletInvocableHandlerMethod提供
        exceptionHandlerMethod.setDataBinderFactory(new ServletRequestDataBinderFactory(null, null));

        exceptionHandlerMethod.setHandlerMethodArgumentResolvers(getArgumentResolvers());
        exceptionHandlerMethod.setHandlerMethodReturnValueHandlers(getReturnValueHandlers());

        ServletWebRequest webRequest = new ServletWebRequest(request, response);
        ModelAndViewContainer mavContainer = new ModelAndViewContainer();

        try {
            if (logger.isDebugEnabled()) {
                logger.debug("Invoking @ExceptionHandler method: " + exceptionHandlerMethod);
            }
            exceptionHandlerMethod.invokeAndHandle(webRequest, mavContainer, exception);
        }
        catch (Exception invocationEx) {
            logger.error("Failed to invoke @ExceptionHandler method: " + exceptionHandlerMethod, invocationEx);
            return null;
        }

        if (mavContainer.isRequestHandled()) {
            return new ModelAndView();
        }
        else {
            ModelAndView mav = new ModelAndView().addAllObjects(mavContainer.getModel());
            mav.setViewName(mavContainer.getViewName());
            if (!mavContainer.isViewReference()) {
                mav.setView((View) mavContainer.getView());
            }
            return mav;
        }
    }

}
