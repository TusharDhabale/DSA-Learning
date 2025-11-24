import java.util.*;

public class HeapSort {

    //heapify
    public static void heapify(int arr[], int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int minIdx = i;

        if (left < n && arr[minIdx] > arr[left]) {
            minIdx = left;
        }
        if (right < n && arr[minIdx] > arr[right]) {
            minIdx = right;
        }

        if (minIdx != i) {
            //swap
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;

            heapify(arr, minIdx, n);
        }
    }

    public static void heappsort(int arr[]) {
        //step1 : build heap
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        //step2: remove element one by one from heap
        for (int i = n - 1; i > 0; i--) {
            //step1: swap first and last
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            //step2: heapify root element
            heapify(arr, 0, i);
        }
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5, 3};
        heappsort(arr);

        //print sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

