package com.jy.array;

/**
 * Created with IntelliJ IDEA.
 * User: LJY
 * Date: 2022/3/5
 * Time: 11:38
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Person {
    private String name;
    private String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("haaa");
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
