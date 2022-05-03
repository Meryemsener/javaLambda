package arrays;

import java.util.Arrays;

public class MulDimArrToplmai {
    public static void main(String[] args) {
        int arr[][] = {{10, 20, 30}, {4}, {6, 7, 20}};





        int total = Arrays.stream(arr)
                .mapToInt(arrayList -> Arrays.stream(arrayList).sum())
                .sum();
        System.out.println(total);
    }
}
