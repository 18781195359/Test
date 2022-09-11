package com.jy;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: LJY
 * Date: 2022/3/5
 * Time: 9:52
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class TestOne {
    public static void main(String[] args) {
        Animals animal = new Animals();
        Cat catty = new Cat();
        catty = (Cat)new Animals();

        animal.setName("Mini");
        animal.setAge("23");

        catty.setName("Mama");
        catty.setAge("32");
        catty.setFood("鱼");
    }
}
