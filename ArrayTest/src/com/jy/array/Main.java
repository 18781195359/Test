package com.jy.array;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: LJY
 * Date: 2022/3/4
 * Time: 10:10
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Main {
    public static void main(String[] args) {

        ArrayListTest<Person> persons1 = new ArrayListTest<>();

        persons1.add(new Person("hhs","34"));
        persons1.add(new Person("Tina","55"));
        persons1.add(new Person("Tom","21"));
        persons1.add(new Person("Cindy","18"));

        persons1.remove(0);
        System.gc();
    }
}
