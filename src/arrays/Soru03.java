package arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Soru03 {/* TASK :
        bir int Array elemanlarinin işaretini(+-)degistiren  bir method yaziniz.
        input : 1,2,-3,4,-5,-6
        output :-1,-2,3,-4,5,6
         */

    public static void main(String[] args) {
        int arr[] = {1,2,-3,4,-5,-6};
        int yeniArr[]=new int[arr.length];

        isaretleriCevir(arr);
    }

    private static void isaretleriCevir(int[] arr) {
        Arrays.stream(arr).map(t->t*(-1)).forEach(t-> System.out.print(t+" ,"));

    }

}
