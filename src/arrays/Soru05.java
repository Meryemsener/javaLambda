package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Soru05 {
    /*  TASK :
     * write a java program that calculates the average value of array elements
     * Print elements that are greater than avarage
     * (dizi elemanlarinin ortalama degerini hesaplayan ve
     * ortalamadan büyük olan elemanlari yazdıran bir java programi yazin)
     * input[]= {1,2,3,4,5,6,7}
     * Output : 4
     */
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        List<Integer> newArr = new ArrayList<>();

        int toplam = 0;

        for (int i = 0; i < arr.length; i++) {
            newArr.add(arr[i]);
            toplam += arr[i];
        }

        //int ortalama = toplam / newArr.size();

        //newArr.stream().filter(t->t>ortalama).forEach(t-> System.out.print(t + " "));


            Double ort = Arrays.stream(arr).mapToDouble(t -> t).average().orElseThrow();
            newArr.stream().filter(t -> t > ort).forEach(t -> System.out.print(t + " "));




    }
}