package org.format.demo.service;


import org.format.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmployeeService {

    public Employee getById(Integer id);

    public void saveOrUpdate(Employee employee);

    public void delete(Employee user);

    public void delete(Integer id);

    public List<Employee> list();

}
