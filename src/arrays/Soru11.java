package arrays;

import java.util.Arrays;

public class Soru11 {
     /* TASK :
        arr1 = { {1,2}, {3,4,5}, {6} }  ve  arr2 = { {7,8,9}, {10,11}, {12} }  veriliyor.
        Bu iki array'in tum elemanlarinin toplamini bulan programi yaziniz.
         */
     public static void main(String[] args) {


    int arr1 [][] = { {1,2}, {3,4,5}, {6} };
    int arr2 [][]={ {7,8,9}, {10,11}, {12} };

         int a1 = Arrays.stream(arr1)
                 .mapToInt(t -> Arrays.stream(t).sum())
                 .sum();
         int a2 = Arrays.stream(arr2)
                 .mapToInt(t -> Arrays.stream(t).sum())
                 .sum();

         System.out.println(a1+a2);
     }
}
