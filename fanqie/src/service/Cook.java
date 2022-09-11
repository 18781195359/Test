package service;

import meal.Meal;

import java.util.concurrent.TimeUnit;

/**
 * This class is used to define a cook
 * @author LJY
 * @time 2021-11-15
 * @version 1.0
 * @see meal.Meal
 * @see java.util.concurrent.TimeUnit
 */
public class Cook {
    private String name;

    /**
     * This is the construction method
     * @param name cook's name
     */
    public Cook(String name) {
        this.name = name;
    }

    /**
     * get cook's name
     * @return cook's name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param meal This parameter indicates the dish to be cooked
     * @throws InterruptedException
     */
    public void cookMeal(Meal meal) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.err.println(meal.getName()+"的材料准备中");
        TimeUnit.SECONDS.sleep(2);
        System.err.println(getName()+"大厨在洗菜...");
        TimeUnit.SECONDS.sleep(1);
        System.err.println(getName()+"大厨在炒菜...");
        TimeUnit.SECONDS.sleep(2);
        System.err.println(getName()+"大厨在把"+meal.getName()+"装盘...");
        TimeUnit.SECONDS.sleep(1);
    }

}
