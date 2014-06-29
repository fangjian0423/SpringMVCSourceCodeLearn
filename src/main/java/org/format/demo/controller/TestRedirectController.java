package org.format.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(value = "/redirect")
public class TestRedirectController {

    @RequestMapping("/test1")
    public ModelAndView test1(ModelAndView view) {
        view.setViewName("redirect:index");
        return view;
    }

    @RequestMapping("/test2")
    public ModelAndView test2(ModelAndView view) {
        view.setViewName("redirect:login");
        return view;
    }

    @RequestMapping("/test3")
    public ModelAndView test3(ModelAndView view) {
        view.setViewName("redirect:/index");
        return view;
    }

    @RequestMapping("/test4")
    public ModelAndView test4(ModelAndView view) {
        view.setView(new RedirectView("/index", false));
        return view;
    }

    @RequestMapping("/test5")
    public ModelAndView test5(ModelAndView view) {
        view.setView(new RedirectView("index", false));
        return view;
    }

    @RequestMapping("/test6/{id}")
    public ModelAndView test6(ModelAndView view, @PathVariable("id") int id) {
        view.setViewName("redirect:/index{id}");
        view.addObject("test", "test");
        return view;
    }

    @RequestMapping("/test7/{id}")
    public ModelAndView test7(ModelAndView view, @PathVariable("id") int id) {
        RedirectView redirectView = new RedirectView("/index{id}");
        redirectView.setExpandUriTemplateVariables(false);
        redirectView.setExposeModelAttributes(false);
        view.setView(redirectView);
        view.addObject("test", "test");
        return view;
    }

}
