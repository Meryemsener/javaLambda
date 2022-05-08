package arrays.mayis8;

import java.util.stream.IntStream;

public class C6_Lambdada_ForLoop_Aralik_Kontrolu {
    public static void main(String[] args) {
        sirala(30);
        System.out.println();
        ikiDEgerArasiniTopla(3,5);
        System.out.println();
        ortalamaAlma(30,40);
        System.out.println();
        sekizeBolunebilen(325,468);
        System.out.println();
        sekizeBolunebilenYazdir(325,468);
        System.out.println();
        sekizeBolunebilenTopla(325,468);
        System.out.println();
        tekSayilarinToplami(7,15);
        System.out.println();
        ilkOnEleman(1,20);
        System.out.println();
        yirmibirdenOnEleman(21);
        System.out.println();
        yirmibirdenOnElemanTopla(21);



    }

    // S1:1 den 30 kadar olan sayilari (30 dahil degil) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //range(int startInclusive, int endExclusive)
public static void sirala(int x){
   IntStream.range(1, 30).sorted().forEach(t -> System.out.print(t + " "));
}

    //S2 1 den 30 kadar olan sayilari (30 dahil ) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //rangeClosed(int startInclusive, int endInclusive)
    public static void sirala30Dahil(int x){
        IntStream.rangeClosed(1, 30).sorted().forEach(t -> System.out.print(t + " "));
    }

    //S3 Istenen iki deger(dahi) arasindaki sayilari toplayalim
    public static void ikiDEgerArasiniTopla(int x, int t){
        System.out.println(IntStream.rangeClosed(x, t).reduce(0, (a, b) -> a + b));

    }

    //S4: 30 ile 40 arasindaki sayilarin (dahi) ortalamasini bulalim
    public static void ortalamaAlma(int x, int t){
        System.out.println(IntStream.rangeClosed(30, 40).average().orElseThrow());

    }


    //S5: 325 ile 468 arasinda 8 e bolunen kac sayi vardir?
    public static void sekizeBolunebilen(int x, int a){
        System.out.println(IntStream.rangeClosed(x, a).filter(t -> t % 8 == 0).count());

    }

    //S6: 325 ile 468 arasinda 8 bolunen sayilari yazdiralim
    public static void sekizeBolunebilenYazdir(int x, int a){
        IntStream.rangeClosed(x, a).filter(t -> t % 8 == 0).forEach(t-> System.out.print(t+" "));

    }

    // S7:325 ile 468 arasinda 8 bolunen sayilarin toplamini bulalim

    public static void sekizeBolunebilenTopla(int x, int a){
        System.out.println(IntStream.rangeClosed(x, a).filter(t -> t % 8 == 0).sum());

    }


    // S8: 7ile 15 arasindaki tek sayilarin carpimini bulalim
    public static void tekSayilarinToplami(int a,int b){
        System.out.println(IntStream.range(a+1, b).filter(t->t%2!=0).reduce(1, (x, y) -> x * y));
    }


    //S9: pozitif tek sayilarin ilk 10 elemanin yazdiralim
    public static void ilkOnEleman(int a,int b){
        IntStream.rangeClosed(a,b).filter(t->t%2!=0).limit(20).forEach(t-> System.out.print(t+" "));
    }

    //S10: 21 den baslayan 7 nin katlarinin tek olanlari ilk 10 teriminin yaziralim
    public static void yirmibirdenOnEleman(int a){
        IntStream.iterate(21, t -> t + 7).filter(t->t%7==0 && t%2!=0).limit(10).forEach(t-> System.out.print(t+" "));
    }


    //S11: 21 den baslayan 7 nin katlarinin ilk 20 teriminin toplayalim
    public static void yirmibirdenOnElemanTopla(int a){
        System.out.println(IntStream.iterate(21, t -> t + 7).filter(t -> t % 7 == 0).limit(20).reduce(Math::addExact));
    }

//iterate bize sayilari istedigimiz sekilde yineletmeyi saglar yani buradaki ornekte 7ser7ser artmayi saglar
//iterate icin bir baslangic degeri girilmeli ve artisin nasil olacagi belirtilmeli nerede biteceginide
// limit() ile belilioruz
}
