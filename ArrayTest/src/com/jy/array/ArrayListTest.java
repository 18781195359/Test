package com.jy.array;

import org.omg.CORBA.Object;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: LJY
 * Date: 2022/3/4
 * Time: 10:31
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class ArrayListTest<E> {
    /**
     * 动态数组容量
     */
    private int size;

    /**
     * 动态数组
     */
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    public ArrayListTest(int initialCapacity){
        initialCapacity = (initialCapacity < DEFAULT_CAPACITY)?DEFAULT_CAPACITY:initialCapacity;
        //elements = (E[])new Object[initialCapacity];
        elements = (E [])new java.lang.Object[initialCapacity];
    }

    public ArrayListTest(){
        this(DEFAULT_CAPACITY);
    }

    public void clear(){
        for (int i = 0;i<size;i++){
            elements[i] = null;
        }
        size = 0;
    }
    /**
     * 元素的数量
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 添加元素
     * @param element
     */
    public void add(E element){
//        ensureCapacity(size+1);
//        elements[size++] = element;
        add(size,element);
    }

    public void add(int index,E element){
        if(element == null)return;
        rangeCheckForAdd(index);
        ensureCapacity(size+1);
        for (int i = size - 1;i >= index;i--){
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    private void outOfBounds(int index){
        throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
    }

    private void rangeCheck(int index){
        if(index<0 || index >= size){
            outOfBounds(index);
        }
    }

    private void rangeCheckForAdd(int index){
        if(index<0 || index > size){
            outOfBounds(index);
        }
    }

    /**
     * 删除指定index的元素
     * @param index
     */
    public void remove(int index){

        rangeCheck(index);

        for (int i = index + 1;i < size; i++){
            elements[i - 1] = elements[i];
        }

        size--;
        elements[size] = null;
    }

    private void ensureCapacity(int capacity){
        int oldCapacity = elements.length;

        if(oldCapacity >= capacity){
            return;
        }

        //x新容量为旧容量的1.5倍
        int newCapacity = (oldCapacity + (oldCapacity>>1));
        E[] newElements = (E[])new Object[newCapacity];

        for (int i = 0;i < size;i++){
            newElements[i] = elements[i];
        }

        elements = newElements;
        System.out.println("扩容1.5倍");
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 判断是否包含某个元素
     */
    public boolean contains(E element){
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 获取index位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return 原来的元素ֵ
     */
    public E set(int index,E element){
        rangeCheck(index);
        E oldElements = elements[index];
        elements[index] = element;
        return oldElements;
    }

    /**
     * 查看元素在数组中的索引
     * @param element
     * @return
     */
    public int indexOf(E element){
        if(element == null){
            for (int i = 0;i<size;i++){
                if(elements[i] == null){
                    return i;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(element)) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size = ").append(size).append(", [");
        for (int i = 0;i<size;i++){
            stringBuilder.append(elements[i]);

            if(i != size - 1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
