package tree;

import org.omg.CORBA.NO_IMPLEMENT;
import sun.java2d.pipe.SpanClipRenderer;
import tree.printer.BinaryTrees;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: LJY
 * Date: 2022/8/16
 * Time: 9:23
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class AVLTree<E> extends BinarySearchTree<E> {

    public AVLTree(){
        this(null);
    }

    public AVLTree(Comparator<E> comparator){
        super(comparator);
    }

    @Override
    protected void afterAdd(Node<E> node) {
        while ((node = node.parentNode) != null){
            if(isBalanced(node)){
                updateHeight(node);
            }else {
                rebalance(node);
                break;
            }
        }
    }

    /**
     *
     * @param grand
     */
    private void rebalance(Node<E> grand){
        Node<E> parent = ((AVLNod)grand).tallerChild();
        Node<E> node = ((AVLNod)parent).tallerChild();

        if(parent.isLeafChild()){
            if(node.isLeafChild()){//LL
                rotateRight(grand);
            }else {//LR
                rotateLeft(parent);
                rotateRight(grand);
            }
        }else{//
            if (node.isLeafChild()){//RL
                rotateRight(parent);
                rotateLeft(grand);
            }else{//RR
                rotateLeft(grand);
            }
        }
    }

    private void rotateLeft(Node<E> node){
        Node<E> tallerNode = ((AVLNod)node).tallerChild();
        Node<E> tallerNodeChild = tallerNode.leftNode;
        node.rightNode = tallerNodeChild;
        tallerNode.leftNode = node;

        tallerNode.parentNode = node.parentNode;
        if(node.isLeafChild()){
            node.parentNode.leftNode = tallerNode;
        }else if(node.isRightChild()){
            node.parentNode.rightNode = tallerNode;
        }else{
            rootNode = tallerNode;
        }

        //更新child的parent
        if(tallerNodeChild != null){
            tallerNodeChild.parentNode = node;
        }

        node.parentNode = tallerNode;
        updateHeight(node);
        updateHeight(tallerNode);
        //更新高度

    }

    private void rotateRight(Node<E> node){
        Node<E> tallerNode = ((AVLNod)node).tallerChild();
        Node<E> tallerNodeChild = tallerNode.rightNode;
        node.leftNode = tallerNodeChild;
        tallerNode.rightNode = node;

        tallerNode.parentNode = node.parentNode;
        if(node.isLeafChild()){
            node.parentNode.leftNode = tallerNode;
        }else if(node.isRightChild()){
            node.parentNode.rightNode = tallerNode;
        }else{
            rootNode = tallerNode;
        }

        if(tallerNodeChild != null){
            tallerNodeChild.parentNode = node;
        }

        node.parentNode = tallerNode;
        updateHeight(node);
        updateHeight(tallerNode);
    }

    private void rotate(
            Node<E> root,
            Node<E> a,Node<E> b, Node<E> c,
            Node<E> d,
            Node<E> e, Node<E> f,Node<E> g
    ){
        d.parentNode = root.parentNode;
        if(root.isLeafChild()){
            root.parentNode.leftNode = d;
        }else if(root.isRightChild()){
            root.parentNode.rightNode = d;
        }else {
            rootNode = d;
        }

        b.leftNode = a;
        if (a != null){
            a.parentNode = b;
        }
        b.rightNode = c;
        if(c != null){
            c.parentNode = b;
        }
        updateHeight(b);

        f.leftNode = e;
        if(e != null){
            e.parentNode = f;
        }
        f.rightNode = g;
        if(g != null){
            g.parentNode = f;
        }
        updateHeight(f);

        d.leftNode = b;
        d.rightNode = f;
        b.parentNode = d;
        f.parentNode = d;
        updateHeight(d);
    }

    private void updateHeight(Node<E> node){
        AVLNod<E> avlNod = ((AVLNod)node);
        avlNod.updateHeight();
    }

    private boolean isBalanced(Node<E> node){
        return Math.abs(((AVLNod)node).balanceFactor()) <= 1;
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parentNode) {
        return new AVLNod<>(element,parentNode);
    }

    private class AVLNod<E> extends Node<E>{
        int height = 1;
        public AVLNod(E element, Node<E> parentNode) {
            super(element, parentNode);
        }

        public int balanceFactor(){
            int leftHeight = leftNode == null ? 0 : ((AVLNod)leftNode).height;
            int rightHeight = rightNode == null ? 0 : ((AVLNod)rightNode).height;

            return  leftHeight - rightHeight;
        }

        public void updateHeight(){
            int leftHeight = leftNode == null ? 0 : ((AVLNod)leftNode).height;
            int rightHeight = rightNode == null ? 0 : ((AVLNod)rightNode).height;

            height = 1 + Math.max(leftHeight,rightHeight);
        }

        public AVLNod<E> tallerChild(){
            int leftHeight = leftNode == null ? 0 : ((AVLNod)leftNode).height;
            int rightHeight = rightNode == null ? 0 : ((AVLNod)rightNode).height;

            if (leftHeight > rightHeight){
                return ((AVLNod) leftNode);
            } else  if (rightHeight > leftHeight){
                return ((AVLNod) rightNode);
            }
            else{
                return isLeafChild() ? ((AVLNod)leftNode) : ((AVLNod)rightNode);
            }
        }
    }
}
