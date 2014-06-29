package org.format.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Callable;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(value = {"/", ""})
    public String index() {
        return "login";
    }

    @RequestMapping("/auth")
    public String auth(@RequestParam String username, HttpServletRequest req) {
        req.getSession().setAttribute("loginUser", username);
        return "redirect:/index";
    }

    @RequestMapping("/out")
    public String out(HttpServletRequest req) {
        req.getSession().removeAttribute("loginUser");
        return "redirect:/login";
    }

    @RequestMapping("/async")
    @ResponseBody
    public Callable<String> callable() {

        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000l);
                return "Callable result";
            }
        };
    }

}
