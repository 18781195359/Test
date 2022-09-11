package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * this class is the program's entry
 * @author LJY
 * @time 2021-11-15
 * @version 1.0
 * @see java.util.ArrayList
 */
public class DinnerTest {

    public static void main(String[] args) throws InterruptedException {
        //RunView.run();
//        int[] temp = {2,/*12,103,74,34,45,11,9,25,55,100,87,23*/3,4,5,6,7,8,9,10,11,12,14};
//        for (int i = 0; i < temp.length - 1; i++) {
//            int mindex = i;
//            for(int j = i+1;j<temp.length;j++){
//                if(temp[j]<temp[mindex]){
//                    mindex = j;
//                }
//            }
//            if(mindex != i){
//                int temp1 = temp[i];
//                temp[i] = temp[mindex];
//                temp[mindex] = temp1;
//            }
//        }
        /*long start =  System.nanoTime();
        for (int i = 0;i<temp.length-1;i++){
            boolean flag = true;
            for(int j = 0;j<temp.length-i-1;j++){
                if(temp[j]>temp[j+1]){
                    flag = false;
                    int mintemp = temp[j];
                    temp[j] = temp[j+1];
                    temp[j+1] = mintemp;
                }
            }
            if(flag == true){
                break;
            }
        }
        long end =  System.nanoTime();
        System.out.println(Arrays.toString(temp));
        System.out.println(end-start);*/

        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));

        System.out.println(uniquePaths(3, 7));
    }

    public static int minPathSum(int[][] grid) {
        for (int i = 0;i<grid.length;i++){
            for (int j = 0;j<grid[0].length;j++){
                int ansLeft = 0,ansUp = 0;
                if (i-1<0&&j-1<0){
                    continue;
                }
                if (i-1>=0 && j-1<0){
                    ansUp += grid[i-1][j];
                    grid[i][j] += ansUp;
                    continue;
                }
                if(j-1>=0 && i-1<0){
                    ansLeft += grid[i][j-1];
                    grid[i][j] += ansLeft;
                    continue;
                }
                ansUp += grid[i-1][j];
                ansLeft += grid[i][j-1];
                grid[i][j] += Math.min(ansLeft,ansUp);
            }
        }
        return grid[grid.length-1][grid[0].length -1];
    }

    @Test
    public static int uniquePaths(int m, int n){
        int[][] function = new int[m][n];
        for (int i = 0;i<m;i++){
            function[i][0] = 1;
        }
        for (int j = 0;j<n;j++){
            function[0][j] = 1;
        }
        for (int i = 1;i<m;i++){
            for (int j = 1;j<n;j++){
                function[i][j] = function[i][j-1]+function[i-1][j];
            }
        }
        return function[m-1][n-1];
    }
}
