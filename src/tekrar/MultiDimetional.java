package tekrar;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.IntStream.range;

public class MultiDimetional {
    /*
int arr [][]={{7,12,97,23},{543,23,675},{2},{2,33,6,3,7}};
verilen Array icinde
--> kac tane eleman oldugunu return eden methodu yazdiriniz //cevap : 13 donsun
*/
    public static void main(String[] args) {


        int arr [][]={{7,12,97,23},{543,23,675},{2},{2,33,6,3,7}};

        System.out.println("eleman sayisi " + elemanSayisi(arr)); //eleman sayisi 13




    }

    private static int elemanSayisi(int[][] arr) {
        int sayac = 0;
        for (int i = 0; i < arr.length; i++) { //outer for loop
            for (int j = 0; j < arr[i].length; j++) { //inner loop
                sayac++;
            }
        }
        return sayac;
    }


    }

