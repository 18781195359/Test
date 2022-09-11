package meal;


import java.util.HashSet;
import java.util.Set;

/**
 * this class is used to define a meal
 * @author LJY
 * @time 2021-11-15
 * @version 1.0
 */
public class Meal {
    private String name;

    private double cost;

    /**
     * this is a construction method
     * @param name meadl's name
     * @param cost meals's cost
     */
    public Meal(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    /**
     *
     * @return meals's name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return meal's cost
     */
    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "_"+getName()+"_"+getCost()+"元";
    }

    public boolean reverseString(String s, int start, int end){
        int endPoint = end,startPoint = start;9
        while (startPoint<=endPoint){
            if(s.charAt(startPoint) != s.charAt(endPoint)){
                return false;
            }
            startPoint++;
            endPoint--;
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        if(s.length()<2){
            return s;
        }
        int ans = 0; 
        return null;
    }

    public static void main(String[] args) {
        String s = "bavebbb";
        longestPalindrome(s);
    }
}
