import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Lambda05 {
    static Scanner scan = new Scanner(System.in);

//Structured(AMELE) Programming
    //Functional(cincix Programming
    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.

    public static void main(String[] args) {
        System.out.println("TASK 01 manuel topla-->" + toplamKodManuel(10));
        System.out.println("TASK 01 lambda topla-->" + toplaLambdaIle(10));
        System.out.println("   ***   ");

        System.out.println("TASK 02 -->"+toplaIlkXCift(10));
        System.out.println("   ***   ");

        System.out.println("TASK 03 -->"+toplaIlkXCift(10));
        System.out.println("   ***   ");

        System.out.println("TASK 04 -->");
        ilkXPozitifTekTopla(6);
        System.out.println("   ***   ");

        System.out.println("TASK 05 -->");
        ikininIlkXKuvvetiniYazdir(4);
        System.out.println("   ***   ");

        System.out.println("TASK 06 -->");
        birSayininXKuvveti(4,5);
        System.out.println("   ***   ");

        System.out.println("TASK 07 -->"+birSayininFaktoriyeli(5));

        System.out.println("   ***   ");

        System.out.println("TASK 08 -->"+xInciKuvvetiYadir(3,5));
        System.out.println("   ***   ");


    }

    public static int toplamKodManuel(int x) {
        int toplam = 0;
        for (int i = 1; i <= x; i++) {
            toplam += i;
        }
        return toplam;
    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil) tamsayilari toplayan bir program create ediniz.
    public static int toplaLambdaIle(int x) {
        return IntStream.
                range(1, x + 1).//1 den x'e kadar(x dahil) int degerler akısa alındı
                        sum();//akısdakş int degerler toplandı
    }


    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int toplaCift(int x) {
        return IntStream.//kaynak yoksa kaynagi kendimiz olusturuyoruz. Yani
                rangeClosed(1, x).//1'den X'e kadar(x dahil) int degerler akisa alind
                filter(Lambda01::ciftBul).
                sum();
    }


    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz. //1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
    public static int toplaIlkXCift(int x) {
        return IntStream.
                iterate(0,t->t+2).//akistaki aralik degil de bizim istedigimiz sartlara gore akitiyor
                        //x'i 10 olarak girersen, ilk 10 tane cift sayiyi alacaktir.
                limit(x).//akistaki ilk x integer degeri akisa alir,
                sum();//toplar
    }
    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int ilkXPozitifTekTopla(int x){
        return IntStream.
                iterate(0, t -> t + 1).limit(x).sum();

        //akistaki aralik degil de bizim istedigimiz sartlara gore akitiyor
                //x'i 10 olarak girersen, ilk 10 tane cift sayiyi alacaktir.
                        //akistaki ilk x integer degeri akisa alir,
                        //toplar

    }

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkXKuvvetiniYazdir(int x){
        IntStream.iterate(2,t->t*2).limit(x).forEach(Lambda01::yazdir);

    }



//TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void birSayininXKuvveti(int istenenSayi, int x){
       IntStream.iterate(istenenSayi,t->t*x).limit(x).forEach(Lambda01::yazdir);


    }


//TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static int birSayininFaktoriyeli(int x){
       return IntStream.rangeClosed(1,x).reduce(1,(t,u)->t*u);
    }


//TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.
    public static double xInciKuvvetiYadir(int istenenSayi, int x){
        //return Math.pow(istenenSayi,x); bu lambda degil ancak cooook iyi ve daha kisa
        return IntStream.iterate(istenenSayi,t->t*istenenSayi).limit(x).skip(x-1).findFirst().orElseThrow();
        //return IntStream.iterate(istenenSayi, t -> t * istenenSayi). limit(x).reduce(0, (t, u) -> u);


    }

}








