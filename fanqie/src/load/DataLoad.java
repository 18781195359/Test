package load;

import meal.Meal;
import meal.MealMeanu;
import service.Waiter;
import service.WaiterList;

/**
 * This class is used to load some data of the program
 * @author LJY
 * @time 2021-11-15
 * @version 1.0
 * @see service.Waiter
 * @see service.WaiterList
 * @see meal.Meal
 * @see meal.MealMeanu
 */
public class DataLoad {
    /**
     * this method is uesd to load Waiters information
     * @param waiterList it contains has may waiters
     */
    public static void loadWaiter(WaiterList waiterList){
        Waiter waiter1 = new Waiter("小美","110");
        Waiter waiter2 = new Waiter("小丽","111");
        Waiter waiter3 = new Waiter("小花","112");
        Waiter waiter4 = new Waiter("小芳","113");
        Waiter waiter5 = new Waiter("小可","114");

        waiterList.addWaiter(waiter1);
        waiterList.addWaiter(waiter2);
        waiterList.addWaiter(waiter3);
        waiterList.addWaiter(waiter4);
        waiterList.addWaiter(waiter5);

    }

    /**
     * this method is used to load meal's information
     * @param meals it has many meals
     */
    public static void loadMeals(MealMeanu meals){
        Meal meal = new Meal("番茄炒蛋",12);
        Meal meal1 = new Meal("牛舌炒猪肝",110);
        Meal meal2 = new Meal("虾仁猪心",23.7);
        Meal meal3 = new Meal("菠萝派",11.7);
        Meal meal4 = new Meal("东兴派",9.7);
        Meal meal5 = new Meal("番茄炒西红柿",25.7);
        Meal meal6 = new Meal("冬瓜炒肉",32.7);
        meals.addMeal(meal);
        meals.addMeal(meal1);
        meals.addMeal(meal2);
        meals.addMeal(meal3);
        meals.addMeal(meal4);
        meals.addMeal(meal5);
        meals.addMeal(meal6);
    }
}
