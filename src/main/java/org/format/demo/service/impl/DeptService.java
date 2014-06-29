package org.format.demo.service.impl;

import org.format.demo.dao.BaseDao;
import org.format.demo.model.Dept;
import org.format.demo.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService implements IDeptService {

    @Autowired
    private BaseDao baseDao;

    @Override
    public List<Dept> listAll() {
        return (List<Dept>)baseDao.listAll(Dept.class);
    }

    @Override
    public void saveOrUpdate(Dept dept) {
        baseDao.saveOrUpdate(dept);
    }

}
