import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] val = { 60, 100, 120 };
        int[] weights = { 10, 20, 30 };
        int w = 50;

     double ratios[][] = new double[val.length][2];
     //0th col => idx; 1st col => ratio

     for (int i = 0; i < val.length; i++) {
         ratios[i][0] = i;
         ratios[i][1] = val[i] * 1.0 / weights[i];
     }

     //ascending order
        Arrays.sort(ratios, Comparator.comparingDouble(o -> o[1]));
        
        int capacity = w;
        int finalValue = 0;

        for (int i = ratios.length - 1; i >= 0; i--) {
            int idx = (int) ratios[i][0];
            if (capacity >= weights[idx]) {
                finalValue += val[idx];
                 capacity -= weights[idx];
            } else {
                finalValue += ratios[i][1] * capacity;
                capacity = 0;
                break;
            }
        }
        System.out.println("Maximum value in Knapsack = " + finalValue);
    }
}
