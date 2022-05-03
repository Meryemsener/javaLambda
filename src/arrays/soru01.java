package arrays;

import java.util.*;
import java.util.stream.Stream;

public class soru01 {


    /* TASK :
	 kullanicin girdigi sayi kadar int array olusturan ve array elemanlarini kullanicidan alan
	 ve girilen array elemanlarinin en buyuk ile en kucuk elemaninin arasinki farki gosteren
	 java code create ediniz.
	 */

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        System.out.print("bir sayi giriniz : ");
        int sayi = scan.nextInt();

        Integer arr[] = new Integer[sayi];

        List<Integer> arrayList = new ArrayList<>();


        for (int i = 0; i < sayi; i++) {

            System.out.println("Arrayin " + (i + 1) + " . elemanini giriniz : ");
            arr[i] = scan.nextInt();
            arrayList.add(arr[i]);
        }

        Arrays.sort(arr);
        System.out.println(arr[sayi - 1] - arr[0]);

        //System.out.println(arrayList);
        //minMaxFarkiBulma(arrayList);


        minMAxFark(arrayList);
        minMAxFark2(arr);


    }

    public static void minMAxFark(List<Integer> arrayList) {


        Integer max = arrayList
                .stream()
                .mapToInt(v -> v)
                .max().orElseThrow();
        Integer min = arrayList
                .stream()
                .mapToInt(v -> v)
                .min().orElseThrow();
        System.out.println(max - min);


        // arrayList.stream().sorted(Comparator.reverseOrder()).findFirst();



    }
    public static void minMAxFark2(Integer arr[]){

        Integer max = Arrays
                .stream(arr)
                .mapToInt(v -> v)
                .max().orElseThrow();

        Integer min = Arrays
                .stream(arr)
                .mapToInt(v -> v)
                .min().orElseThrow();
        System.out.println(max - min);


    }

}

