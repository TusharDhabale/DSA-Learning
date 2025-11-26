import java.util.*;

public class LargestSubarray0sum {
    public static void main(String[] args) {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};

        HashMap<Integer, Integer> map = new HashMap<>();
        //(sum, index)

        int sum = 0;
        int Len = 0;

        for(int j=0; j < arr.length; j++){
            sum += arr[j];

            if(map.containsKey(sum)){
                Len = Math.max(Len, j - map.get(sum));
            } else {
                map.put(sum, j);
            }
        }
        System.out.println("Length of the largest subarray with 0 sum: " + Len);
    }
}
