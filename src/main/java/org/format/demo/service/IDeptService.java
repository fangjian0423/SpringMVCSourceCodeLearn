package org.format.demo.service;


import org.format.demo.model.Dept;

import java.util.List;

public interface IDeptService {

    public List<Dept> listAll();

    public void saveOrUpdate(Dept dept);

}
