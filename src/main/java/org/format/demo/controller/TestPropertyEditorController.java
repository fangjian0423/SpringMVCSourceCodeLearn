package org.format.demo.controller;

import org.format.demo.model.Dept;
import org.format.demo.model.Employee;
import org.format.demo.support.binder.CustomDeptEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/tpec")
public class TestPropertyEditorController {

    @RequestMapping("/testboolean")
    public ModelAndView testboolean(boolean b, ModelAndView view) {
        view.setViewName("test/test");
        if(b) {
            view.addObject("attr", "b is true");
        } else {
            view.addObject("attr", "b is false");
        }
        return view;
    }


    @RequestMapping("/testObj")
    public ModelAndView testObj(Employee e, ModelAndView view) {
        view.setViewName("test/test");
        view.addObject("attr", e.toString());
        return view;
    }

    //@InitBinder
    //public void initBinder(WebDataBinder binder) {
    //    binder.registerCustomEditor(Dept.class, new CustomDeptEditor());
    //}

}

