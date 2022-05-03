package arrays;

import java.util.Arrays;

public class soru09 {
    public static void main(String[] args) {
        /* TASK :
        given an int array and find the squares of the elements
        (Verilen bir int dizisi icin elemanlarin karelerini bulun )
        Example:{2,6,4,5,8,9}
        output:{4,36,16,25,64,81}
        */
        int array[]={2,6,4,5,8,9};
        kareleriToplta(array);

    }

    private static void kareleriToplta(int[] array) {
        Arrays.stream(array).map(t->t*t).forEach(t-> System.out.print(t+ " "));
    }

}
