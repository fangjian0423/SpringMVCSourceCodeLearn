package org.format.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/wildcard")
public class TestWildcardController {

    @RequestMapping("/test/**")
    public ModelAndView test1(ModelAndView view) {
        view.setViewName("/test/test");
        view.addObject("attr", "TestWildcardController -> /test/**");
        return view;
    }

    @RequestMapping("/test*")
    public ModelAndView test2(ModelAndView view) {
        view.setViewName("/test/test");
        view.addObject("attr", "TestWildcardController -> /test*");
        return view;
    }

    @RequestMapping("test?")
    public ModelAndView test3(ModelAndView view) {
        view.setViewName("/test/test");
        view.addObject("attr", "TestWildcardController -> test?");
        return view;
    }

    @RequestMapping("test/*")
    public ModelAndView test4(ModelAndView view) {
        view.setViewName("/test/test");
        view.addObject("attr", "TestWildcardController -> test/*");
        return view;
    }


}