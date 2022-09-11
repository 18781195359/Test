/**
 * Created with IntelliJ IDEA.
 * User: LJY
 * Date: 2022/9/10
 * Time: 14:48
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println(getName()+"hello");
        }
    }
}
