package org.format.demo.controller;

import org.format.demo.annotation.FormModel;
import org.format.demo.model.Dept;
import org.format.demo.model.Employee;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping
    public String index(HttpServletRequest request) {
        request.setAttribute("test", "test");
        return "forward: /index";
    }

    @RequestMapping("/testRb")
    @ResponseBody
    public Employee testRb(@RequestBody Employee e) {
        return e;
    }

    @RequestMapping("/testCustomObj")
    @ResponseBody
    public Employee testCustomObj(Employee e) {
        return e;
    }

    @RequestMapping("/testCustomObjWithRp")
    @ResponseBody
    public Employee testCustomObjWithRp(@RequestParam Employee e) {
        return e;
    }

    @RequestMapping("/testDate")
    @ResponseBody
    public Date testDate(Date date) {
        return date;
    }

    @RequestMapping("/save")
    public ModelAndView saveAll(@FormModel("employee") Employee employee, @FormModel("dept")Dept dept, ModelAndView view) {
        view.setViewName("test/success");
        view.addObject("employee", employee);
        view.addObject("dept", dept);
        return view;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

}