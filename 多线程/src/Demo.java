/**
 * Created with IntelliJ IDEA.
 * User: LJY
 * Date: 2022/9/10
 * Time: 14:50
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Demo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("线程一");
        t2.setName("线程二");
        t1.start();
        t2.start();
    }
}
