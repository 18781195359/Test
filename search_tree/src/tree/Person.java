package tree;

/**
 * Created with IntelliJ IDEA.
 * User: LJY
 * Date: 2022/2/6
 * Time: 15:00
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Person implements Comparable<Person>{
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person e2) {
        return this.age - e2.getAge();
    }

    @Override
    public String toString() {
        return
               age+"" ;
    }
}
