package tree;

/**
 * Created with IntelliJ IDEA.
 * User: LJY
 * Date: 2022/2/6
 * Time: 16:25
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Car {
    private double cost;

    public Car(double cost) {
        this.cost = cost;
    }

    public Car() {
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
