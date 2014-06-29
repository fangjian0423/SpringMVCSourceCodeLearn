package org.format.demo.dao;

import java.util.List;

public interface IBaseDao {

    public List<?> list(Class clazz);

    public List<?> listAll(Class clazz);

    public void saveOrUpdate(Object entity);

    public void delete(Object entity);

    public Object getById(Integer id, Class clazz);

}
