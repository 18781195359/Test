package com.jy;

/**
 * Created with IntelliJ IDEA.
 * User: LJY
 * Date: 2022/3/5
 * Time: 9:49
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Cat extends Animals{
    private String food;

    public Cat(String name, String age) {
        super(name, age);
    }

    public Cat(String name, String age, String food) {
        super(name, age);
        this.food = food;
    }

    public Cat(String food) {
        this.food = food;
    }

    public Cat() {
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Cat{" + super.toString() +
                "food='" + food + '\'' +
                '}';
    }
}
