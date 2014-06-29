package org.format.demo.controller.advice;

import org.format.demo.model.Dept;
import org.format.demo.support.binder.CustomDeptEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

//@ControllerAdvice
public class InitBinderControllerAdvice {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Dept.class, new CustomDeptEditor());
    }

}
