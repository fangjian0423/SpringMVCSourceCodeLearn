package org.format.demo.support.binder;

import org.format.demo.model.Dept;

import java.beans.PropertyEditorSupport;

public class CustomDeptEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(text.indexOf(",") > 0) {
            Dept dept = new Dept();
            String[] arr = text.split(",");
            dept.setId(Integer.parseInt(arr[0]));
            dept.setName(arr[1]);
            setValue(dept);
        } else {
            throw new IllegalArgumentException("dept param is error");
        }
    }

}
