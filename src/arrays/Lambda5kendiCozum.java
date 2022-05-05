package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lambda5kendiCozum {
    static Scanner scan = new Scanner(System.in);

//Structured(AMELE) Programming
    //Functional(cincix Programming
    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.

    public static void main(String[] args) {

        System.out.print("Sayi giriniz : ");

        int sayi = scan.nextInt();
        int arr[] = new int[sayi];
        arr[0] = 1;
        for (int i = 1; i < sayi; i++) {
            arr[i] = i + 1;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);

        }


        //System.out.println(list);
        System.out.println(toplam2(list));
        System.out.println("\n------------");
        System.out.println(ciftToplam(list));
        System.out.println("\n------------");
        ciftToplam1(list);
        System.out.println("\n------------");
        tekToplam1(list);
        carpim(list);
    }

    public static int toplamKod(int x) {
        int toplam = 0;
        for (int i = 1; i <= x; i++) {
            toplam += i;
        }
        return toplam;
    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil) tamsayilari toplayan bir program create ediniz.
    public static int toplaCincix(int x) {
        return IntStream.
                range(1, x + 1).//1 den x'e kadar(x dahil) int degerler akısa alındı
                        sum();//akısdakş int degerler toplandı
    }


    public static int toplam2(List<Integer> list) {
        return list.stream().reduce(0, (a, b) -> a + b);
        //return list.stream().filter(t-> t>5).reduce(0,(a,b)->a+b);
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int ciftToplam(List<Integer> list) {
        return list.stream().filter(t -> t % 2 == 0).reduce(0, (a, b) -> a + b);
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz. //1 2 3 4 5 6 7 8 9 10
    public static void ciftToplam1(List<Integer> list) {
        System.out.print("Sinir : ");
        int sinir = scan.nextInt();
        System.out.println(list.stream().filter(t -> t % 2 == 0).limit(sinir).reduce(0, (a, b) -> a + b));
        //System.out.println(list.stream().filter(t -> t % 2 == 0).limit(10).reduce(0, (a, b) -> a + b));
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static void tekToplam1(List<Integer> list) {
        System.out.print("Sinir : ");
        int sinir = scan.nextInt();
        System.out.println(list.stream().filter(t -> t % 2 != 0).limit(sinir).reduce(0, (a, b) -> a + b));
        //System.out.println(list.stream().filter(t -> t % 2 == 0).limit(10).reduce(0, (a, b) -> a + b));
    }

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void carpim(List<Integer> list) {
        System.out.print("Sinir : ");
        int sinir = scan.nextInt();
        System.out.println(list.stream().map(t -> Math.pow(2, sinir)).collect(Collectors.toList()));
    }

}

//TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.

//Structured(AMELE) Programming


//Functional(cincix Programming


//TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.


//TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.


//TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.


//TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.


//TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.


//TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.


//TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.


