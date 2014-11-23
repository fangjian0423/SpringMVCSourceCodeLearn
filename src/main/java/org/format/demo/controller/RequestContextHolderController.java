package org.format.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
@RequestMapping("/rch")
public class RequestContextHolderController {

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest().getParameter("name");
    }

}
