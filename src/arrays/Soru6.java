package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Soru6 {
    /*TASK :
	write a java program to find the second largest number in the array?
	Maximum and minimum number in the array?
	(Dizideki en büyük ikinci sayyiyi, maksimum ve minimum sayiyi
	bulmak için bir java programi yazin)
	int[] arr = { 100, 10001, -90, 845, 8787, 898, 0, 1, -90 };
	*/
    public static void main(String[] args) {
        int[] arr = { 100, 10001, -90, 845, 8787, 898, 0, 1, -90 };
        enBuyukIkinci(arr);

    }
        public static void enBuyukIkinci(int[] arr){
            System.out.println(Arrays.stream(arr).sorted().findFirst());
            System.out.println(Arrays.stream(arr).reduce(Math::max).orElseThrow());
            System.out.println(Arrays.stream(arr).reduce(Math::min).orElseThrow());


        }

}
