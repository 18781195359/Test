package test;

import meal.Meal;
import meal.MealMeanu;
import service.Cook;
import service.Waiter;
import service.WaiterList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * the program is runned here
 * @author LJY
 * @time 2021-11-15
 * @version 1.0
 * @see java.io
 * @see java.util
 * @see service.WaiterList
 * @see service.Waiter
 * @see service.Cook
 * @see meal.Meal
 * @see meal.MealMeanu
 */
public class RunView {
    /** stdIn is uesed for reading data from console equipment*/
    private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    /**
     * stdOut is used for putting data in console equipment
     */
    private static PrintWriter stdOut = new PrintWriter(System.out);
    /**
     * static varible newMeaulist has only one constructor and a ArrayList collection
     */
    private static MealMeanu newMeauList = MealMeanu.getMealMeaun();
    /**
     * static varible newMeauList has only one constructor and a ArrayList collection
     */
    private static WaiterList newWaiterList = WaiterList.getSingleWaiterList();
    /**
     *  only one cooker(diligent)
     */
    private static Cook cooker = new Cook("李家源");

    /**
     * my program's running page
     *
     * @throws InterruptedException
     */
    public static void run() throws InterruptedException {
        while (true){
            TimeUnit.MILLISECONDS.sleep(100);
            System.err.println("------------------按0退出------------------");
            stdOut.println("顾客来了......");
            stdOut.flush();
            TimeUnit.MILLISECONDS.sleep(1000);
            Waiter waiter = newWaiterList.randNumWaiter();
            stdOut.println(waiter);
            stdOut.flush();
            TimeUnit.MILLISECONDS.sleep(800);
            newMeauList.displayAll();
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.print("输入序号>");
            int key = readInteger();
            if(key == 0){
                return;
            }
            cooker.cookMeal(newMeauList.getMeal(key - 1));
            System.out.println(waiter.sayGoodbye(newMeauList.getMeal(key - 1)));
            TimeUnit.SECONDS.sleep(2);
        }
    }

    /**
     * This function is used to read an integer as the user's choice
     * @return key(int) a choice which customer will have dinner
     */
    public static int readInteger(){
        String key;
        do {
            try {
                key = stdIn.readLine();
                if(key.equals("")){
                    stdOut.print("输入序号>");
                    stdOut.flush();
                    continue;
                }
                if(Integer.parseInt(key)<0 || Integer.parseInt(key)>newMeauList.numberOfMeal()){
                    System.err.print("无效输入，请重新输入");
                    continue;
                }
                return Integer.parseInt(key);
            }catch (IOException e){
                e.printStackTrace();
            }catch (NumberFormatException e){
                System.err.print("无效输入，请重新输入");
            }
        }while (true);
    }
}
