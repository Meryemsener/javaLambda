package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Soru15 {
     /*  TASK :
        check your array's first and last elements are same
        (dizinizin ilk ve son elemanlarının ayni olup olmadığını kontrol eden kod yaziniz
        int []arr={2,6,4,8,2,6,2};
         */
     public static void main(String[] args) {
         int []arr={2,6,4,8,2,6,2};
         Integer ilk= Arrays.stream(arr).findFirst().orElseThrow();
         Integer son= Arrays.stream(arr).skip(arr.length - 1).findFirst().orElseThrow();
         System.out.println(ilk);
         System.out.println(son);

         System.out.println(Arrays.stream(arr).anyMatch(t -> ilk == son ? true : false));

     }
}
