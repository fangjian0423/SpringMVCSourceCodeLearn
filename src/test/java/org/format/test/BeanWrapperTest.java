package org.format.test;

import org.format.test.model.TestModel;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BeanWrapperTest {

    @Test
    public void test01() {
        TestModel tm = new TestModel();
        BeanWrapper bw = new BeanWrapperImpl(tm);
//        bw.setPropertyValue("good", "on");
//        bw.setPropertyValue("good", "1");
//        bw.setPropertyValue("good", "true");
//        bw.setPropertyValue("good", "yes1");
        System.out.println(tm);
    }

    @Test
    public void test02() {
        TestModel tm = new TestModel();
        BeanWrapperImpl bw = new BeanWrapperImpl(false);
        bw.setWrappedInstance(tm);
        bw.setPropertyValue("good", "1");
        System.out.println(tm);
    }

    @Test
    public void test03() {
        TestModel tm = new TestModel();
        BeanWrapper bw = new BeanWrapperImpl(tm);
        bw.setPropertyValue("age", 1);
        System.out.println(tm);
    }

    @Test
    public void test04() {
        TestModel tm = new TestModel();
        BeanWrapper bw = new BeanWrapperImpl(tm);
        bw.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
        bw.setPropertyValue("birth", "1990-01-01");
        System.out.println(tm);
    }


}
