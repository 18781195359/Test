package com.jy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LJY
 * Date: 2022/3/14
 * Time: 15:39
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Stack<E>{

    private List<E> list = new ArrayList<>();

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void push(E element){
        list.add(element);
    }

    public E pop(){
        return list.remove(size() - 1);
    }

    public E top(){
        return list.get(size() - 1);
    }

}
