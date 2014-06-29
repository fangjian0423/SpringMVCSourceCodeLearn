package org.format.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BaseDao implements IBaseDao {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public List<?> list(Class clazz) {
        String simpleName = clazz.getSimpleName();
        String hql = "from " + clazz.getName() + " " + simpleName;
        return getSession().createQuery(hql).list();
    }

    public List<?> listAll(Class clazz) {
        String simpleName = clazz.getSimpleName();
        String hql = "from " + clazz.getName() + " " + simpleName;
        return getSession().createQuery(hql).list();
    }

    public void saveOrUpdate(Object entity) {
        getSession().saveOrUpdate(entity);
    }

    public void delete(Object entity) {
        getSession().delete(entity);
    }

    public Object getById(Integer id, Class clazz) {
        return getSession().get(clazz, id);
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
