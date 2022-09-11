package tree;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: LJY
 * Date: 2022/2/5
 * Time: 15:36
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class BinarySearchTree<E> implements tree.printer.BinaryTreeInfo {
    private int size;
    protected Node<E> rootNode;
    private Comparator<E> eComparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator){
        this.eComparator = comparator;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0 ?true:false;
    }

    public void clear(){

    }

    public int getHight(Node<E> node){
        if(node == null) return 0;
        return Math.max(getHight(node.leftNode),getHight(node.rightNode)) + 1;
    }

    protected void afterAdd(Node<E> node){

    }

    protected Node<E> createNode(E element,Node<E> parentNode){
        return new Node<>(element, parentNode);
    }

    public void add(E element){
        elementNotNullCheck(element);
        //根节点为空
        if(rootNode == null){
            rootNode = createNode(element,null);
            size++;

            afterAdd(rootNode);

            return;
        }

        //添加的不是根节点
        Node<E> node = rootNode;
        Node<E> parent = null;
        int cmp = 0;
        while (node != null){
            cmp = compare(element,node.element);
            parent = node;
            if(cmp>0){
                node = node.rightNode;
            }else if(cmp<0){
                node = node.leftNode;
            }else {
                return;
            }
        }

        Node<E> newNode = createNode(element,parent);
        if(cmp>0){
            parent.rightNode = newNode;
        }else {
            parent.leftNode = newNode;
        }
        size++;
        afterAdd(newNode);
    }

    private int compare(E e1,E e2){
        if(eComparator != null){
            return eComparator.compare(e1,e2);
        }
        return ((Comparable<E>)e1).compareTo(e2);
    }

    public void remove(E element){

    }

    public boolean contains(E element){
        return  false;
    }

    private void elementNotNullCheck(E element){
        if(element == null){
            throw new IllegalArgumentException("element must not null!");
        }
    }

    @Override
    public Object root() {
        return rootNode;
    }

    @Override
    public Object left(Object node) {
        return ((Node)node).leftNode;
    }

    @Override
    public Object right(Object node) {
        return ((Node)node).rightNode;
    }

    @Override
    public Object string(Object node) {
        return ((Node)node).element;
    }

    protected static class Node<E>{
        E element;
        Node<E> leftNode;
        Node<E> rightNode;
        Node<E> parentNode;

        int balanceFactor;


        public Node(E element,Node<E> parentNode) {
            this.element = element;
            this.parentNode = parentNode;
        }

        public boolean isLeaf(){
            return leftNode != null && rightNode != null;
        }

        public boolean isLeafChild(){
            return parentNode != null && this == parentNode.leftNode;
        }

        public boolean isRightChild(){
            return parentNode != null && this == parentNode.rightNode;
        }
    }
}
