import java.util.*;

public class Lambda02 {

    public static void main(String[] args) {
        List<Integer> liste = new ArrayList<>(Arrays.asList(3, 2, 6, 11, -5, 7, 3, 15));
        System.out.println("\n    1-      ***          ");
        ciftKarePrint(liste);
        System.out.println("\n    2-      ***          ");
        tekSayiPrint(liste);
        System.out.println("\n    3-      ***          ");
        ciftKarelerinKArekoku(liste);
        System.out.println("\n    4-      ***          ");
        enBuyukEleman(liste);
        System.out.println("\n    5-      ***          ");
        enKucukEleman(liste);
        System.out.println("\n    6-      ***          ");
        ciftlerinKarelerininEnBuyugu(liste);
        System.out.println("\n    7-      ***          ");
        elemanlariTopla(liste);
        System.out.println("\n   8-      ***   ");
        ciftCarp(liste);


    }

    /*
        cift elamanlarinin karelerini ayni satirda yazirin
        => bu task map ile cozulur.Collectionlardaki ile karistirma :)
         */
    public static void ciftKarePrint(List<Integer> liste) {
        liste.
                stream().
                filter(Lambda01::ciftBul).//onceki class'ta bulunan cift elemanlari bulma methodu cagrilarak ciftler bulundu
                map(t -> t * t).//ciftler kareleri ile update edildi
                forEach(Lambda01::yazdir);

        //map ()-> stream icerisindeki elemanlari baska tiplere donusturmek
        //veya uzerinde islem yapmak(update etmek) icin kullanilir.Yukaridaki taskte de cift
        //sayilar kareleri ile update edildigi icin kullanilmisir
    }

    /*
    tek elemanlarin kuplerine 1 arttir
     */
    public static void tekSayiPrint(List<Integer> liste) {
        liste.
                stream().//sayilar akisa alindi
                filter(t -> t % 2 != 0).//tek elemanlar filtrelendi
                map(t -> (t * t * t) + 1).//tek elemanlarin kuplerinin 1 fazlasina update edildi
                forEach(Lambda01::yazdir);//yazdirildi
        System.out.println(liste.stream().reduce(Math::max));

    }

    /*
    cift elemanlarin karekoklerini ayni satirda aralarinda bosluk birakarak yazdir
     */
    public static void ciftKarelerinKArekoku(List<Integer> liste) {
        liste.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).//double return eder
                forEach(t -> System.out.print(t + " "));//yazdir methodunun parametresinin data tipi int oldugu icin kendimiz yazdik,
    }

    /*
    listin en buyuk elemanini yazdir
     */
    public static void enBuyukEleman(List<Integer> liste) {
        System.out.println(liste.stream().reduce(Math::max));//akisa giren elemanlari action sonrasi tek eleman haline getirir


    }

    /*
    listin en kucuk elemanini yazdir
     */
    public static void enKucukEleman(List<Integer> liste) {
        System.out.println(liste.stream().reduce(Math::min));//en kucuk elemani bul getir
    }

    /*
    Listin cift elemanlarinin karelerinin en buyugunu print ediniz
     */
    public static void ciftlerinKarelerininEnBuyugu(List<Integer> liste) {
        System.out.println(liste.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Math::max));//burda Math:: yerine Integer:: kullanilabilir. Daha hizlidir ancak alani daha dardir

    }

    /*
    Listteki tum elemanlarin toplamini yazdirin. Lambda expression ile yap
     */
    public static void elemanlariTopla(List<Integer> liste) {
        //System.out.println(liste.stream().reduce(Integer::sum));bunun adi method referans

        System.out.println(liste.stream().reduce(0, (a, b) -> a + b));//Lambda expression
                    /*
                    a ilk degerini her zaman atanan degerden alir(identity)
                    b her zaman degerini akistan (stream) alir
                    a ilk degerinden sonraki her degeri aksiyondan alir
                    */


    }// Task : List'teki cift elemanlarin carpimini  yazdiriniz.

    public static void ciftCarp(List<Integer> sayi) {
//Method Ref...
        System.out.println("method ref :" + sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact));
//Lambda Expression...
        System.out.println("Lambda exp. : " + sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1, (a, b) -> (a * b)));
    }

        // Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.
        public static void minBul(List<Integer> sayi) {
            //1. yontem Method Reference --> Integer class
         sayi.stream().reduce(Integer::min).orElseThrow();
            //System.out.println(minSayiInteger);
            //2. yontem Method Reference --> Math class
            Optional<Integer> minSayiMath = sayi.stream().reduce(Math::min);
            System.out.println(minSayiMath);
            //3. yontem Lambda Expression
            int minSayiLJambda = (sayi.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y));
            System.out.println(minSayiLJambda);
            //4. yontem Method Reference --> Haluk class
            Optional<Integer> minSayiHaluk = sayi.stream().reduce(Lambda02::byHalukMin);
            System.out.println(minSayiHaluk);
        }

        public static int byHalukMin(int a, int b) {//bu method kendisine verilen iki int degerin en kücügunu return eder
            return a < b ? a : b;
        }

// Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
        public static void bestenBykEnKck(List<Integer> sayi) {

            System.out.println(sayi.stream().filter(t -> t > 5 && t % 2 == 1).reduce(Lambda02::byHalukMin));
        }

// Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
        public static void ciftKareKbPrint(List<Integer> sayi) {
            sayi.
                    stream().//akısa alındı
                    filter(Lambda01::ciftBul).//cift elemnlar fitrlenedi
                    map(t->t*t).//fitrelenen cift sayı karesi alındı
                    sorted().//karesi alınan elemanlar dogal(k->b) sıralandı
                    forEach(Lambda01::yazdir);//print edildi

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
                    forEach(Lambda01::yazdir);//print edildi


        }
    }
