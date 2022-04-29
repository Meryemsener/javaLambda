import java.util.*;
import java.util.stream.Stream;

public class Lambda03 {

    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("küşleme", "adana", "trileçe", "havucDilim", "buryan", "yaglama", "kokareç", "arabAşı", "güveç", "trileçe", "trileçe", "trileçe", "waffle"));

        alfBykTekrrsz(menu);
        System.out.println("\n   ***   ");
        chrSayisiTersSirali(menu);
        System.out.println("\n   ***   ");
        chrSayisiBkSirala(menu);
        System.out.println("\n   ***   ");
        sonHrfBkSirala(menu);
        System.out.println("\n   ***   ");
        charKaresiCiftElemanSiralaTekrarsiz(menu);//100 36
        System.out.println("\n   ***   ");
        harfSayisi7denAzKontrol(menu);
        System.out.println("\n   ***   ");
        wIleBaslayan(menu);
        System.out.println("\n   ***   ");
        xIleBiten(menu);
        System.out.println("\n   ***   ");
        karakterSayisiBykElYazdir(menu);
        System.out.println("\n   ***   ");
        ilkElHrcDigerElYazdiral(menu);
    }

    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfBykTekrrsz(List<String> yemek) {
        yemek.//akıs kaynagı
                stream().//akısa girdi
                //map(t->t.toUpperCase()).//Jamb.Ex  elemanlar buyuk harf update edildi
                        map(String::toUpperCase).//Meth.Ref elemanlar buyuk harf update edildi
                sorted().//alafabetik(natural dogal) sıra yapıldı
                distinct().// benzersiz: tekrarsız hale getirildi
                forEach(t -> System.out.print(t + " "));//print

        //distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.
        // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
        // Sıralı akışlar için, farklı elemanın seçimi sabittir
        // (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
        // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.
    }

    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void chrSayisiTersSirali(List<String> menü) {
        menü.stream().//akısa alındı
                // map(t->t.length()).
                        map(String::length).//elemanlar karakter sayısına update edildi
                sorted(Comparator.reverseOrder()).//ter sıra yapıldı
                distinct().//benzersiz yapıldı
                //forEach(t->System.out.print(t+" "));
                        forEach(Lambda01::yazdir);//print edildi


    }

    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void chrSayisiBkSirala(List<String> menü) {
        menü.stream().sorted(Comparator.comparing(String::length)).forEach(t -> System.out.print(t + " "));
    }

    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHrfBkSirala(List<String> menü) {
        menü.stream().sorted(Comparator.comparing(t -> t.toString().charAt(t.toString().length() - 1)).//elemanin length()-1)-->son inedx'inin karakterini alir
                reversed()).//elemanin length()-1)-->son inedx'inin karakterini ters siralar z->a
                forEach(t -> System.out.print(t + " "));

    }

    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..

    public static void charKaresiCiftElemanSiralaTekrarsiz(List<String> menu) {
        menu.stream().map(t -> t.length() * t.length()).//karesini aldik
                filter(Lambda01::ciftBul).//akisdaki string elemanlari boyutlarinin karesine update edildi
                distinct().//tekrarsiz yapildi
                sorted(Comparator.reverseOrder()).//ters siralandi(buyukten kucuge)
                forEach(Lambda01::yazdir);//yadirdik

    }

    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void harfSayisi7denAzKontrol(List<String> menu) {
        boolean control = menu.stream().allMatch(t -> t.length() <= 7);
        if (control) {
            System.out.println("List elemanlari 7 ve daha fazla harften olusuyor");
        } else System.out.println("List elemanlari 7 harften kucukler");
        System.out.println();
        // ya da
        System.out.println(menu.stream().allMatch(t -> t.length() <= 7) ? "List elemanlari 7 ve daha fazla harften olusuyor" : "List elemanlari 7 harften kucukler");


    }

    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void wIleBaslayan(List<String> menu) {

        System.out.println(menu.stream().noneMatch(t -> t.startsWith("w")) ? "w ile baslayan kelime yok" : "w ile baslayan kelimeler var");


    }


    // Task : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.
    public static void xIleBiten(List<String> menu) {
        System.out.println(menu.stream().
                map(String::toUpperCase).
                anyMatch(t -> t.endsWith("x")) ? "x ile biten kelime yok" : "x ile biten kelimeler var");
    }

    // Task : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void karakterSayisiBykElYazdir(List<String> menu) {
        Optional<String> eBE = menu.stream().
                sorted(Comparator.comparing(t -> t.toString().
                                length()).
                        reversed()).
                findFirst();//ilk eleman alindi

        Stream<String> sonIsim = menu.stream().
                sorted(Comparator.comparing(t -> t.toString().
                                length()).
                        reversed()).
                limit(1);//findFirst ila ayni seyi verir. 2 yazarsaniz 2'yi verecegi unutulmamali

        System.out.println(Arrays.toString((sonIsim.toArray())));//limit method'dan dolayi stream type olan sonIsim
        //toArray() method ile array type'a convert(cevrildi) edildi ve yazdirildi


    }

    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void ilkElHrcDigerElYazdiral(List<String> menu) {
        menu.
                stream().//akisa alindi
                sorted(Comparator.comparing(t -> t.charAt(t.length() - 1))).//son harfe gore sirlandi
                skip(1).//ilk eleman atlandi
                forEach(t -> System.out.print(t + " "));//yazdirildi
    }
}


