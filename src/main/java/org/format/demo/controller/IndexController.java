package org.format.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("index");
        return view;
    }

}