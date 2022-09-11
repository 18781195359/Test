package com.jy.listtest;

/**
 * Created with IntelliJ IDEA.
 * User: LJY
 * Date: 2022/3/6
 * Time: 14:00
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public abstract class AbstractList<E> implements List<E>{

    /**
     * 元素的数量
     */
    protected int size;
    /**
     * 元素的数量
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素到尾部
     * @param element
     */
    public void add(E element) {
        add(size, element);
    }


    protected void outOfBiunds(int index){
        throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
    }

    protected void rangeCheck(int index){
        if(index<0||index>=size){
            outOfBiunds(index);
        }
    }

    protected void rangeCheckForAdd(int index){
        if(index < 0||index > size){
            outOfBiunds(index);
        }
    }
}
