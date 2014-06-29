package org.format.demo.controller;

import org.format.demo.model.Dept;
import org.format.demo.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private IDeptService deptService;

    @RequestMapping("/update")
    @ResponseBody
    public String update(Dept dept) {
        deptService.saveOrUpdate(dept);
        return "success";
    }

}
