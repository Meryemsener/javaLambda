package arrays;

import java.util.Arrays;

public class Soru04 {
    /*  TASK :
     *  verilen bir int  Arrayde toplamlari istenen degere esit olan sayi ciftlerini
     * yazdiran bir method yaziniz int[] arr= {5,7,-6,4,2,15,3,8,1};
     * int istenenToplam=9;
     */
    public static void main(String[] args) {
        int[] arr= {5,7,-6,4,2,15,3,8,1};
       // int yeniArr[]=new int[arr.length];
        int istenenToplam=9;

        instenenToplam(arr);
    }

    private static void instenenToplam(int[] arr) {

        Arrays.stream(arr).map(t->(t+t)==9 ? t:(-1));
    }
}
