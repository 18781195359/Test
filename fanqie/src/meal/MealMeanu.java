package meal;

import load.DataLoad;
import meal.Meal;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * this class is used to maintain a collection of meals(Singleton Pattern)
 * @author LJY
 * @time 2021-11-15
 * @version 1.0
 * @see java.lang.Iterable
 * @see load.DataLoad
 * @see java.util.Iterator
 */
public class MealMeanu implements java.lang.Iterable<Meal>{
    private ArrayList<Meal> mealArrayList = new ArrayList<>();
    /**
     * static MealMeanu single (only object can be created)
     */
    private static MealMeanu single;

    /**
     * private construction method
     */
    private MealMeanu(){
    }

    /**
     *
     * @return meal's number
     */
    public int numberOfMeal(){
        return mealArrayList.size();
    }

    /**
     * get a meal by index
     * @param index
     * @return
     */
    public Meal getMeal(int index){
        if(index<0||index>=mealArrayList.size()){
            System.err.println("抱歉没有那么多菜");
            return null;
        }

        return mealArrayList.get(index);

    }

    /**
     * This method is used to instantiate a unique object
     * @return MealMeanu
     */
    public static MealMeanu getMealMeaun(){
        if(single == null){
            single = new MealMeanu();
            DataLoad.loadMeals(single);
        }
        return single;
    }

    /**
     * this method is used to show all dishes
     *
     */
    public void displayAll(){
        for(int i = 0;i<mealArrayList.size();i++){
            System.err.println(String.valueOf(i+1)+mealArrayList.get(i));
        }
    }

    /**
     * add a meal into mealArrayList.
     * @param meal
     */
    public void addMeal(Meal meal){
        if(!mealArrayList.contains(meal)){
            mealArrayList.add(meal);
        }
    }

    /**
     * this method is used to remove meal by meal's name
     * @param name meal's name
     */
    public void removeMeal(String name){
        for (Meal meal : mealArrayList) {
            if(meal.getName().equals(name)){
                mealArrayList.remove(meal);
                return;
            }
        }
        System.err.println("查无此菜");
    }

    @Override
    public Iterator<Meal> iterator() {
        return mealArrayList.iterator();
    }
}
