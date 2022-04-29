package tekrar;

import java.util.*;

public class Lambda001 {
    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));


        printElStuructured(sayi);
        System.out.println("\n   ***   ");
        printElFunctional(sayi);
        System.out.println("\n   ***   ");
        printElFunctional1(sayi);
        System.out.println("\n   ***   ");
        printElFunctional2(sayi);
        System.out.println("\n   ***   ");
        printCiftElSturctured(sayi);
        System.out.println("\n   ***   ");
        printCiftElFunctional(sayi);
        System.out.println("\n   ***   ");
        printCiftElFunctional1(sayi);
        System.out.println("\n   ***   ");
        printCiftOtzKckFunctional(sayi);
        System.out.println("\n   ***   ");
        printCiftOtzBykFunctional(sayi);
        System.out.println("\n   ***   ");
        ciftKarePrint(sayi);//16 4 36
        System.out.println("\n   ***   ");
        tekKupBirFazlaPrint(sayi);//1332 -124 344 28 3376
        System.out.println("\n   ***   ");
        ciftKarekokPrint(sayi);
        System.out.println("\n   ***   ");
        maxElBul(sayi);
        System.out.println("\n   ***   ");
        ciftKarteMaxBul(sayi);
        System.out.println("\n   ***   ");
        elTopla(sayi);
        System.out.println("\n   ***   ");
        ciftCarp(sayi);
        System.out.println("\n   ***   ");
        minBul(sayi);
        System.out.println("\n   ***   ");
        bestenBykEnKck(sayi);
        System.out.println("\n   ***   ");
        tekKareBkPrint( sayi);
        System.out.println("\n   ***   ");
        ciftKareKbPrint(sayi);
        System.out.println("\n   ***   ");

        List<String> menü=new ArrayList<>(Arrays.asList("küşleme","adana","trileçe","havucDilim","buryan",
                "yaglama","kokareç","arabAşı","güveç","trileçe","trileçe","trileçe"));

        alfBykTekrrsz(menü);
        System.out.println("\n   ***   ");
        chrSayisiTersSirali( menü);
        System.out.println("\n   ***   ");
        chrSayisiBkSirala(menü);
        System.out.println("\n   ***   ");
        sonHrfBkSirala( menü);


    }

    //Task : "Structured Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.
    public static void printElStuructured(List<Integer> sayi) {
        for (Integer w : sayi) {
            System.out.print(w + " ");
        }
    }
    //Task : "functional Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.

    public static void printElFunctional(List<Integer> sayi) {
        sayi.stream().forEach((t) -> System.out.print(t + " "));
    }

    /*
        stream() : datalari yukaridan asagiya akis sekline getirir. Stream bir interface olduğundan dolayı doğrudan nesne almaz.
        forEach() :datanin parametresine gore her bir elemanı isler
        t-> : Lambda operatoru
         Lambda Expression-->(parameter list) -> {action body}
             Parameter list: Fonksiyonun parametreleri tanımlanır. Hiç parametre geçirmeden boşta olabilir.
             -> Arrow-token: Argüman listesi ile expression gövdesini birbirine bağlamak için kullanılır.
             Body: Expressionları ve statementları içerir.
            Bir kod bloğundan oluşan bir body...
            Bu tip lambda body, block body olarak bilinir. Blok gövdesi, lambda gövdesinin birden çok ifade içermesine izin verir.
            Bu ifadeler parantez içine alınır ve parantezlerden sonra noktalı virgül eklemeniz gerekir.
                () -> {
                 double pi = 3.1415;
                    return pi;
                };
       ahanda trick köşeşinde bugun :   Lambda Expression  yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir
        */
    public static void printElFunctional1(List<Integer> sayi) {
        sayi.stream().forEach(System.out::print);//method reference--> System.out yapısında prin methodu refere et
        // bu action task'deki aynı satıra  ve bosluk ile yazmayı karşılmaz bubun için
        // seed(tohum) method create edilip refere edilmeli
    }

    public static void yazdir(int a) {// verilen int degeri aynı satırda bosluk bırakarak yazdırma action yapan seed(tohum) method create edildi
        System.out.print(a + " ");
    }

    public static void printElFunctional2(List<Integer> sayi) {
        sayi.stream().forEach(Lambda001::yazdir);//method reference--> System.out yapısında prin methodu refere et
    }

    // Task : structured Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftElSturctured(List<Integer> sayi) {
        for (Integer w : sayi) {
            if (w % 2 == 0) {
                System.out.print(w + " ");
            }
        }
    }

    //Task : functional Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftElFunctional(List<Integer> sayi) {

        sayi.
                stream().
                filter(t -> t % 2 == 0).//filter() --> ile icersindeki elemanlari istenen sarta göre filtreleme (secim) yapar
                forEach(Lambda001::yazdir);

    }

    public static boolean ciftBul(int a) {//seed(tohum) method kendisine verile int degerin cift olmasını kontrol eder

        return a % 2 == 0;
    }

    public static void printCiftElFunctional1(List<Integer> sayi) {

        sayi.
                stream().//list elemanlrı akısa alındı
                filter(Lambda001::ciftBul).//cift bul method refere edilerek akısdaki elemalar filtrelendi(cift sayı)
                forEach(Lambda001::yazdir);//fitre den gelen elemanlar yazdır() method refer edilerek print edildi

    }

    //Task :functional Programming ile list elemanlarinin 34 den kucuk cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftOtzKckFunctional(List<Integer> sayi) {
        sayi.
                stream().
                // filter(t -> t % 2 == 0 && t < 34).
                        filter(Lambda001::ciftBul).//method ref.
                filter(t -> t < 34).//lambda exp.
                forEach(Lambda001::yazdir);
    }

//Task : functional Programming ile list elemanlarinin 34 den buyk veya cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.


    public static void printCiftOtzBykFunctional(List<Integer> sayi) {
        sayi.
                stream().
                filter(t -> t % 2 == 0 || t > 34).//çift veya 34'den buyuk elemanları filtreler 44 63 65 38
                // filter(lambdaTutorial.Lambda01::ciftBul).//method ref.
                // filter(t -> t > 34).//lambda exp.
                        forEach(Lambda001::yazdir);
    }
    // Task : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftKarePrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda001::ciftBul).
                map(t -> t * t).//map()--> Stream içerisindeki elemanları başka tiplere dönüştürmek veya üzerlerinde işlem yapmak (update) için Map kullanılmaktadır.
                forEach(Lambda001::yazdir);


    }
    // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edi

    public static void tekKupBirFazlaPrint(List<Integer> sayi) {
        sayi.
                stream().//sayilar akısa  alındı
                filter(t -> t % 2 != 0).//tek elemnalr fitrelendi
                map(t -> (t * t * t) + 1).//tek elemanları küplerinin 1 fazlasına udate edildi
                forEach(Lambda001::yazdir);//print edildi

    }

    // Task : Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKarekokPrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda001::ciftBul).
                map(Math::sqrt).//meth ref--> double deger return eder
                //forEach(lambdaTutorial.Lambda01::yazdir)--> yazdir() method int.  çalıştığı için map den çıkan dataları çalıştırmaz
                        forEach(t -> System.out.print(t + " "));
    }
    // Task : list'in en buyuk elemanini yazdiriniz

    public static void maxElBul(List<Integer> sayi) {
        Optional<Integer> maxSayi = sayi.
                stream().
                reduce(Math::max);//akısa giren elemnalrın action sonrası tek eleman haline getirir

        System.out.println(maxSayi);// 15
        System.out.println("halukca :" + sayi.stream().reduce(Math::max));//halukca : 15
        /*
        reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
        kullanımı yaygındır pratiktir.
        Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
        bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
        reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
        reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
        İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.
        */
    }

    // Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKarteMaxBul(List<Integer> sayi) {

        System.out.println(sayi.
                stream().
                filter(Lambda001::ciftBul).
                map(t -> t * t).
                reduce(Math::max));//36

        System.out.println("daha hızlı specific ınteger class : " + sayi.
                stream().
                filter(Lambda001::ciftBul).
                map(t -> t * t).
                reduce(Integer::max));//36 specific class daha hızlı run olur
    }

    // Task : List'teki tum elemanlarin toplamini yazdiriniz.
    //Lambda Expression...
    public static void elTopla(List<Integer> sayi) {
        int toplam = sayi.stream().reduce(0, (a, b) -> a + b);//Lambda Expression...
        /*
        a ilk degerini her zaman atanan degerden (identity) alır
        b degerini her zamana  stream()'dan akısdan alır
        a ilk degerinden sonraki her değeri action(işlem)'dan alır
               */
        System.out.println("Lambda exp. : " + toplam);
        //Method Ref...
        Optional<Integer> topla = sayi.stream().reduce(Integer::sum);
        System.out.println("method ref :" + sayi.stream().reduce(Integer::sum));//method ref

    }
    // Task : List'teki cift elemanlarin carpimini  yazdiriniz.

    public static void ciftCarp(List<Integer> sayi) {
//Method Ref...
        System.out.println("method ref :" + sayi.
                stream().
                filter(Lambda001::ciftBul).
                reduce(Math::multiplyExact));
//Lambda Expression...

        System.out.println("Lambda exp. : " + sayi.
                stream().
                filter(Lambda001::ciftBul).
                reduce(1, (a, b) -> (a * b)));
    }

    // Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.
    public static void minBul(List<Integer> sayi) {
        //1. yontem Method Reference --> Integer class
        Optional<Integer> minSayiInteger = sayi.stream().reduce(Integer::min);
        System.out.println(minSayiInteger);
        //2. yontem Method Reference --> Math class
        Optional<Integer> minSayiMath = sayi.stream().reduce(Math::min);
        System.out.println(minSayiMath);
        //3. yontem Lambda Expression
        int minSayiLJambda = (sayi.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y));
        int minSayiLJambda1 = (sayi.stream().reduce(0, (x, y) -> x < y ? x : y));//yukarıaki ile aynı sonucu vermez
        System.out.println("xxxx"+minSayiLJambda);
        System.out.println("aaaa"+minSayiLJambda1);
        //4. yontem Method Reference --> Haluk class
        Optional<Integer> minSayiHaluk = sayi.stream().reduce(Lambda001::byHalukMin);
        System.out.println(minSayiHaluk);
    }

    public static int byHalukMin(int a, int b) {//bu method kendisine verilen iki int degerin en kücügunu return eder
        return a < b ? a : b;
    }

    // Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void bestenBykEnKck(List<Integer> sayi) {

        System.out.println(sayi.stream().filter(t -> t > 5 && t % 2 == 1).reduce(Lambda001::byHalukMin));
    }

    // Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftKareKbPrint(List<Integer> sayi) {
        sayi.
                stream().//akısa alındı
                filter(Lambda001::ciftBul).//cift elemnlar fitrlenedi
                map(t->t*t).//fitrelenen cift sayı karesi alındı
                sorted().//karesi alınan elemanlar dogal(k->b) sıralandı
                forEach(Lambda001::yazdir);//print edildi

        //sorted() => Doğal düzene göre sıralanmış, bu akışın elemanlarında oluşan bir akış döndürür.
        //Sorted() methodu tekrarlı kullanılırsa en son kullanılan aktif olur.
    }

    // Task : list'in tek  elemanlarinin kareleri ni buykten kucuge  print ediniz.

    public static void tekKareBkPrint(List<Integer> sayi) {
        sayi.//akıs kaynagı
                stream().//akısa alındı
                filter(t->t%2!=0).//tek elemnlar fitrlenedi
                map(t->t*t).//fitrelenen cift sayı karesi alındı
                sorted(Comparator.reverseOrder()).//karesi alınan elemanlar ters(b->k) sıralandı
                forEach(Lambda001::yazdir);//print edildi
//reverseOrder() => Comparator Class’ının bir methodudur. Doğal sıralamanın tersini (büyükten küçüğe) uygulayan
// bir Comparator (karşılaştırıcı) return eder.

        //reversed() => Bu karşılaştırıcının (comparator) ters sıralanmasını uygulayan bir karşılaştırıcı
        //(comparator) return eder.

    }
    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfBykTekrrsz(List<String> yemek){
        yemek.//akıs kaynagı
                stream().//akısa girdi
                //map(t->t.toUpperCase()).//Jamb.Ex  elemanlar buyuk harf update edildi
                        map(String::toUpperCase).//Meth.Ref elemanlar buyuk harf update edildi
                sorted().//alafabetik(natural dogal) sıra yapıldı
                distinct().// benzersiz: tekrarsız hale getirildi
                forEach(t->System.out.print(t+" "));//print

        //distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.
        // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
        // Sıralı akışlar için, farklı elemanın seçimi sabittir
        // (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
        // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.
    }

    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void chrSayisiTersSirali(List<String> menü){
        menü.
                stream().//akısa alındı
                // map(t->t.length()).
                        map(String::length).//elemanlar karakter sayısına update edildi
                sorted(Comparator.reverseOrder()).//ter sıra yapıldı
                distinct().//benzersiz yapıldı
                //forEach(t->System.out.print(t+" "));
                        forEach(Lambda001::yazdir);//print edildi


    }
    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void chrSayisiBkSirala(List<String> menü){
        menü.
                stream().
                sorted(Comparator.
                        comparing(String::length)).
                forEach(t->System.out.print(t+" "));
    }
    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHrfBkSirala(List<String> menü){
        menü.
                stream().
                sorted(Comparator.
                        comparing(t->t.toString().
                                charAt(t.toString().length()-1)).//elemanin length()-1)-->son inedx'inin karakterini alir
                                reversed()).//elemanin length()-1)-->son inedx'inin karakterini ters siralar z->a
                forEach(t->System.out.print(t+" "));

    }

    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    // Task : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.
    // Task : Karakter sayisi en buyuk elemani yazdiriniz.
    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.


    /*
        TASK :
        fields --> Universite (String)
                   bolum (String)
                   ogrcSayisi (int)
                   notOrt (int)
                   olan POJO clas craete edip main method içinde 5 arklı obj'den List create ediniz.
         */

    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.


    //task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.


    //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.


    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.


    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.


    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.


    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz


    //task 08--> Ogrenci sayisi 130'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.


    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.


    //task 10-->Ogrenci sayilari 130'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz


    //task 11-->Ogrenci sayilari 150'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.


}



