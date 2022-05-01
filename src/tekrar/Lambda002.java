package tekrar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Lambda002 {
    public static void main(String[] args) {


        List<String> menu = new ArrayList<>(Arrays.asList("küşleme", "adana", "trileçe", "havucDilim", "buryan", "yaglama", "kokareç", "arabAşı", "güveç", "trileçe", "trileçe", "trileçe", "waffle"));
        System.out.println("\n          ***          ");
        alfabetikBuyukHarf(menu);
        System.out.println("\n          ***          ");
        karakterSayisiniTersSirali(menu);
        System.out.println("\n          ***          ");
        buyuktenKucugeDogruSirala(menu);
        System.out.println("\n          ***          ");
        elemSonHarfGorTersSirala(menu);
        System.out.println("\n          ***          ");

        System.out.println("\n          ***          ");

        System.out.println("\n          ***          ");

    }

    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfabetikBuyukHarf(List<String> menu) {
        menu.//akis kaynagi
                stream().//akisa al
                //map(t->t.toUpperCase()).//elemanlar buyuk harfe update edildi
                        map(String::toUpperCase).//ust satiri method refere ederek aldik
                sorted().//alfabetik sirala
                distinct().//tekrarli elemanlari sadece 1 kere akisa sokar, yazdirmaz
                forEach(t -> System.out.print(t + " "));//print edildi

    }
    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..

    public static void karakterSayisiniTersSirali(List<String> menu) {
        menu.
                stream().//akisa alindi
                //map(t->t.length()).
                        map(String::length).//elemanlar karakter sayisina update edildi
                sorted(Comparator.reverseOrder()).//ters sira yapildi
                distinct().
                // forEach(t-> System.out.println(t +" "));
                        forEach(Lambda001::yazdir);

    }

    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void buyuktenKucugeDogruSirala(List<String> menu) {
        menu.
                stream().
                sorted(Comparator.comparing(String::length)).
                forEach(t -> System.out.println(t + " "));

    }

    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void elemSonHarfGorTersSirala(List<String> menu) {
        menu.
                stream().
                sorted(Comparator.
                        comparing(t -> t.toString().charAt(t.toString().length() - 1)).
                        reversed()).
                forEach(t -> System.out.print(t + " "));
    }

    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
    public static void karCiftSayiliKarakterHespTekrarsizBuyuktenKc(List<String> menu) {
        menu.
                stream().
                map(t -> t.length() * t.length()).
                filter(Lambda001::ciftBul).
                distinct().//tekrarsiz
                sorted(Comparator.reverseOrder()).
                forEach(Lambda001::yazdir);

    }

    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void kar7veAzMi(List<String> menu) {
       boolean kontrol= menu.
                stream().
                allMatch(t -> t.length() <= 7);
       if(kontrol){
           System.out.println("Elemanlar 7 ve 7 harften buyuk");
       }else System.out.println("elemanlar 7 harften kucuk ");
        System.out.println(kontrol);
    }

}