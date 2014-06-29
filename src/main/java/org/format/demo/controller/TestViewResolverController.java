package org.format.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/tvrc")
public class TestViewResolverController {

    @RequestMapping("jsp")
    public ModelAndView jsp(ModelAndView view) {
        view.setViewName("jsp:trvc/index");
        return view;
    }

    @RequestMapping("ftl")
    public ModelAndView freemarker(ModelAndView view) {
        view.setViewName("freemarker:trvc/index");
        return view;
    }

    @RequestMapping("redirect")
    public ModelAndView redirect(ModelAndView view) {
        view.setViewName("redirect:freemarker:trvc/index");
        return view;
    }

}
