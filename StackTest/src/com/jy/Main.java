package com.jy;

/**
 * Created with IntelliJ IDEA.
 * User: LJY
 * Date: 2022/3/14
 * Time: 15:48
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(isValid("{{{}}}"));
    }

    public static boolean isValid(String s){

        while (s.contains("[]")||s.contains("{}")||s.contains("()")){
            s = s.replace("[]","");
            s = s.replace("{}","");
            s = s.replace("()","");
        }

        return s.isEmpty();
    }
}
