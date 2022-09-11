package com.jy;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

/**
 * Created with IntelliJ IDEA.
 * User: LJY
 * Date: 2022/3/5
 * Time: 9:48
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Animals {
    private String name;
    private String age;

    public Animals(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Animals() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
