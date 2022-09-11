package tt;

import tt.printer.BinaryTrees;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: LJY
 * Date: 2022/3/19
 * Time: 15:46
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Main {

    private static class PersonComparator implements Comparator<Person>{
        @Override
        public int compare(Person e1, Person e2) {
            return e1.getAge() - e2.getAge();
        }
    }

    private static class PersonComparator1 implements Comparator<Person> {
        @Override
        public int compare(Person e1, Person e2) {
            return e2.getAge() - e1.getAge();
        }
    }

    public static void main(String[] args) {
        Integer data[] = new Integer[]{
                7,4,9,2,5
        };
        BinarySearchTree<Integer> bstree1 = new BinarySearchTree<>();
        for (int i = 0;i<data.length;i++){
            bstree1.add(data[i]);
        }
        test02();
    }

    static void test02(){
        Integer data[] = new Integer[]{
                7,4,9,2,5
        };
        BinarySearchTree<Integer> bstInt = new BinarySearchTree<>();

        for (int i = 0;i<data.length;i++){
            bstInt.add(data[i]);
        }
        BinaryTrees.println(bstInt);
        System.out.println(bstInt.isCompleteTree());
    }

    static void test01(){
        BinarySearchTree<Person> bst2 = new BinarySearchTree<>();

        bst2.add(new Person(23));
        bst2.add(new Person(13));
        bst2.add(new Person(45));
        bst2.add(new Person(68));
        bst2.add(new Person(45));
        bst2.add(new Person(3));
        bst2.add(new Person(58));
        bst2.add(new Person(28));
        bst2.add(new Person(18));

        BinaryTrees.println(bst2);
        /*bst2.levelorderTraversal(new BinarySearchTree.Visit<Person>() {
            @Override
            public void vistor(Person element) {
                System.out.print("*"+element+"*");
            }
        });
*/
        System.out.println(bst2.heightOfTree());
        System.out.println(bst2.isCompleteTree());
    }
}
