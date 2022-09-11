package service;

import meal.Meal;

/**
 * this class is used to define a waiter
 * @author LJY
 * @version 1.0
 * @time 2021-11-15
 * @see meal.Meal
 */
public class Waiter {
    private String name;

    private String code;

    /**
     * this is the class's construction method
     * @param name waiter's name
     * @param code waiter's code
     */
    public Waiter(String name, String code) {
        this.name = name;
        this.code = code;
    }

    /**
     * get waiter's name
     * @return waiter's name
     */
    public String getName() {
        return name;
    }

    /**
     * set waiter's name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return waiter's code
     */
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * What to say at the end of the service
     * @param meal
     * @return
     */
    public String sayGoodbye(Meal meal){
        return "您的"+meal.getName()+"好了,"+getCode()+getName()+"竭诚为您服务";
    }

    @Override
    public String toString(){
        return this.getCode()+"号"+this.getName()+"为您服务,请点餐";
    }
}
