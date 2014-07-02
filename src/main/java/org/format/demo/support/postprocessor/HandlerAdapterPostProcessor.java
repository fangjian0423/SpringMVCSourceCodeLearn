package org.format.demo.support.postprocessor;

import org.format.demo.support.resolve.FormObjArgumentResolver;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class HandlerAdapterPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //初始化之前不改变，原bean返回
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof RequestMappingHandlerAdapter) {
            RequestMappingHandlerAdapter adapter = (RequestMappingHandlerAdapter) bean;
            List<HandlerMethodArgumentResolver> resolvers = adapter.getArgumentResolvers();
            //这里的resolvers是一个UnmodifiableList, 因此需要重新new一个其他类型的List
            List<HandlerMethodArgumentResolver> newList = new ArrayList<HandlerMethodArgumentResolver>(resolvers);
            newList.add(0, new FormObjArgumentResolver());
            adapter.setArgumentResolvers(Collections.unmodifiableList(newList));
        }
        return bean;
    }

}
