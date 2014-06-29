package org.format.demo.controller;

import org.format.demo.model.Employee;
import org.format.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/json")
public class JsonController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping()
    @ResponseBody
    public Map<String, Object> responseToJson() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", employeeService.list());
        return map;
    }

}
