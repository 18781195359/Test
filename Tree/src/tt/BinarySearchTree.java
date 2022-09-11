package tt;

import tt.printer.BinaryTreeInfo;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: LJY
 * Date: 2022/3/19
 * Time: 15:18
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class BinarySearchTree<E> implements BinaryTreeInfo {
    private int size;
    private Node<E> root;
    private Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){

    }

    public int height(){
        return height(root);
    }

    public int heightOfTree(){
        if(root == null){
            return 0;
        }

        Queue<Node<E>> treeQueue = new LinkedList<>();
        treeQueue.add(root);
        int levelSize = 1;
        int height = 0;
        while (!treeQueue.isEmpty()){
            Node<E> pNode = treeQueue.poll();
            levelSize--;
            if(pNode.left != null){
                treeQueue.add(pNode.left);
            }
            if(pNode.right != null){
                treeQueue.add(pNode.right);
            }
            if(levelSize == 0){
                levelSize = treeQueue.size();
                height++;
            }
        }

        return height;
    }

    private int height(Node<E> node){
        if(node == null){
            return 0;
        }
        return 1+Math.max(height(node.left),height(node.right));
    }

    private boolean isLeaf(Node<E> node){
        if(node.left == null&& node.right == null){
            return true;
        }
        return false;
    }

    private boolean hasTwoChldren(Node<E> node){
        if(node.left != null && node.right != null)
            return true;
        return false;
    }

    public boolean isCompleteTree(){
        if(root == null){
            return false;
        }
        Queue<Node<E>> treeQueue = new LinkedList<>();
        boolean leafTag = false;
        treeQueue.offer(root);

        while (!treeQueue.isEmpty()){

            Node<E> pNode = treeQueue.poll();

            if(leafTag && !isLeaf(pNode)){
                return false;
            }

            if(hasTwoChldren(pNode)){
                treeQueue.offer(pNode.left);
                treeQueue.offer(pNode.right);
            }else if(pNode.left == null && pNode.right != null){
                return false;
            }else{
                leafTag = true;
                if(pNode.left != null){
                    treeQueue.offer(pNode.left);
                }
            }

        }
        return true;
    }

    public static interface Visit<E>{
        void vistor(E element);
    }

    public void levelorderTraversal(Visit<E> visit) {
        if(root == null || visit == null){
            return;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node<E> pNode = queue.poll();
            visit.vistor(pNode.element);

            if (pNode.left != null){
                queue.offer(pNode.left);
            }
            if (pNode.right != null){
                queue.offer(pNode.right);
            }
        }
    }

    public void postorderTraversal(Visit<E> visit){
        if(visit == null) return;
        postorderTraversal(root,visit);
    }

    private void postorderTraversal(Node<E> node,Visit<E> visit){
        if(node == null){
            return;
        }
        postorderTraversal(node.left,visit);
        postorderTraversal(node.right,visit);
        visit.vistor(node.element);
    }

    public void inorderTraversal(Visit<E> visit){
        if(visit == null) return;
        inorderTraversal(root,visit);
    }

    private void inorderTraversal(Node<E> node,Visit<E> visit){
        if(node == null){
            return;
        }
        inorderTraversal(node.left,visit);
        visit.vistor(node.element);
        inorderTraversal(node.right,visit);
    }

    public void preorderTraversal(Visit<E> visit){
        if(visit == null) return;
        preorderTraversal(root,visit);
    }

    private void preorderTraversal(Node<E> node,Visit<E> visit){

        if(node == null){
            return;
        }
        visit.vistor(node.element);
        preorderTraversal(node.left,visit);
        preorderTraversal(node.right,visit);
    }

    public void add(E element){
        elementNotNullCheck(element);

        if(root == null){
            root = new Node<>(element,null);
            size++;
            return;
        }
        //找到父节点
        Node<E> node = root;
        Node<E> parent = root;
        int cmp = 0;
        while (node != null){
            cmp = compare(element,node.element);
            parent = node;

            if(cmp>0){
                node = node.right;
            }else if(cmp<0){
                node = node.left;
            }else{
                return;
            }
        }
        Node<E> newNode = new Node<>(element,parent);
        if(cmp>0){
            parent.right = newNode;
        }else{
            parent.left = newNode;
        }
        size++;
    }

    /**
     *
     * @param e1
     * @param e2
     * @return 返回值等于0代表e1 = e2，返回值大于零 代表e1>e2,返回值小于0，代表e1<e2
     */
    private int compare(E e1,E e2){
        if(comparator != null){
            return comparator.compare(e1,e2);
        }
        return ((Comparable<E>)e1).compareTo(e2);
    }

    public boolean contains(E element){
        return false;
    }

    private void elementNotNullCheck(E element){
        if(element == null){
            throw new IllegalArgumentException("其值不能为空");
        }
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node<E>)node).element;
    }

    private static class Node<E>{
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }
}
