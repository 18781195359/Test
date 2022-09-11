package com.jy.listtest;

/**
 * Created with IntelliJ IDEA.
 * User: LJY
 * Date: 2022/3/5
 * Time: 22:24
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LinkedList<E> extends AbstractList<E>{

    Node<E> firstNode;

    @Override
    public void clear() {
        size = 0;
        firstNode = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E remove(int index) {
        Node<E> pNode = firstNode;
        if(index == 0){
            firstNode = firstNode.next;
        }else {
            Node<E> prev = node(index - 1);
            pNode = prev.next;
            prev.next = pNode.next;
        }
        size--;
        return pNode.element;
    }

    @Override
    public E set(int index, E element) {
        return element;
    }

    @Override
    public void add(int index, E element) {
        rangeCheck(index);
        if (index == 0){
            firstNode = new Node<>(element,firstNode);
        }else {
            Node<E> prevNode = node(index - 1);
            prevNode.next = new Node<>(element,prevNode.next);
        }
        size++;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    /**
     *
     * @param index
     * @return
     */
    private Node<E> node(int index){
        rangeCheck(index);
        Node<E> pNode = firstNode;

        for (int i = 0;i<index;i++){
            pNode = pNode.next;
        }
        return pNode;
    }

    private static class Node<E>{
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
