package tree;

import tree.printer.BinaryTreeInfo;
import tree.printer.BinaryTrees;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: LJY
 * Date: 2022/2/5
 * Time: 16:42
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Main {
    private static class PersonComparator implements Comparator<Person> {
        @Override
        public int compare(Person e1, Person e2) {
            return e1.getAge() - e2.getAge();
        }
    }
    public static void main(String[] args) {
        test3();
        test1();
       /*Integer[] integerData = new Integer[]{
               7,4,9,2,5,8,11,3
       };
       BinarySearchTree<Integer> bsTree = new BinarySearchTree<>();
       for (int i = 0;i<integerData.length;i++){
           bsTree.add(integerData[i]);
       }
        BinaryTrees.print((BinaryTreeInfo) bsTree);*/
    }

    static void test3(){
        AVLTree<Integer> integerAVLTree = new AVLTree<>();

        for (int i = 0;i < 20; i++){
            integerAVLTree.add(i);
        }

        BinaryTrees.print(integerAVLTree);
    }

    static void test1(){
        BinarySearchTree<Integer> integertree = new BinarySearchTree<>();

        for (int i = 0;i < 20 ; i++){
            integertree.add(i);
        }

        BinaryTrees.print(integertree);
    }

    static void test2(){
        BinarySearchTree<Person> bsTreePerson = new BinarySearchTree<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }
        });

        bsTreePerson.add(new Person(23));
        bsTreePerson.add(new Person(12));
        bsTreePerson.add(new Person(45));
        bsTreePerson.add(new Person(6));
        bsTreePerson.add(new Person(98));
        bsTreePerson.add(new Person(34));
        bsTreePerson.add(new Person(65));

        BinaryTrees.println(bsTreePerson);

    }
}
