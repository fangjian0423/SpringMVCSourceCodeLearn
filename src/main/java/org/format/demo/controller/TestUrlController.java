package org.format.demo.controller;

import org.format.demo.annotation.FormModel;
import org.format.demo.model.Dept;
import org.format.demo.model.Employee;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/url")
public class TestUrlController {

    @RequestMapping
    public ModelAndView index(ModelAndView view) {
        view.setViewName("/test/test");
        view.addObject("attr", "TestUrlController");
        return view;
    }

    @RequestMapping("/test1")
    public ModelAndView test1(ModelAndView view) {
        view.setViewName("/test/test");
        view.addObject("attr", "TestUrlController -> test1");
        return view;
    }

    @RequestMapping("test2")
    public ModelAndView test2(ModelAndView view) {
        view.setViewName("/test/test");
        view.addObject("attr", "TestUrlController -> test2");
        return view;
    }



}