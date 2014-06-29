package org.format.test.model;

import java.util.Date;

public class TestModel {

    private int age;
    private Date birth;
    private String name;
    private boolean good;
    private long times;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGood() {
        return good;
    }

    public void setGood(boolean good) {
        this.good = good;
    }

    public long getTimes() {
        return times;
    }

    public void setTimes(long times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "age: " + this.age + ", name: " + this.name + ", times: " + this.times + ", good: " + this.good + ", birth: " + birth;
    }
}
