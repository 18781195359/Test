package service;

import load.DataLoad;
import meal.Meal;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * This class is used to maintain a collection of waiters(Singleton Pattern)
 * @author LJY
 * @time 2021-11-15
 * @version 1.0
 * @see java.lang.Iterable
 */
public class WaiterList implements java.lang.Iterable<Waiter>{
    private ArrayList<Waiter> waitersArryList = new ArrayList<>();

    private static WaiterList singleWaiterList;

    /**
     * this is a private construction method(singleton pattern)
     */
    private WaiterList(){

    }

    /**
     *
     * @return object of meal
     */
    public static synchronized WaiterList getSingleWaiterList(){
        if(singleWaiterList == null){
            singleWaiterList = new WaiterList();
            DataLoad.loadWaiter(singleWaiterList);
        }
        return singleWaiterList;
    }

    /**
     * this method is uesd to delete the waiter with the specified ID
     * @param id waiter's id
     */
    public void removeWaiter(String id){
        for (Waiter waiter : waitersArryList) {
            if(waiter.getCode().equals(id)){
                waitersArryList.remove(waiter);
                return;
            }
        }
        System.err.println("查无此人");
    }

    /**
     * this method is used to add a writer into waiterArrayList
     * @param waiter
     */
    public void addWaiter(Waiter waiter){
        if(!waitersArryList.contains(waiter)){
            waitersArryList.add(waiter);
        }
    }

    /**
     *
     * @return waiter's number
     */
    public int numberOfWaiter(){
        return waitersArryList.size();
    }

    /**
     * This method is used to randomly generate a waiter
     * @return
     */
    public Waiter randNumWaiter(){
        int key = (int)(Math.random()*numberOfWaiter());
        return waitersArryList.get(key);
    }

    @Override
    public Iterator<Waiter> iterator() {
        return waitersArryList.iterator();
    }
}
