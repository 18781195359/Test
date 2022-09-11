package tt;

/**
 * Created with IntelliJ IDEA.
 * User: LJY
 * Date: 2022/3/19
 * Time: 15:48
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Person implements Comparable<Person>{
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person e) {
        return age - e.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}
