import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    /*
   1) Lambda "Functional Programming"-->mathod(action) kullanma pr dili.
      Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
      Lambda  kendi başına tanımlanabilen parametre alıp gönderebilen fonksiyonlardır.
      Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      Java 8 ile gelen bu özellik, Java 8’in en önemli özelliğidir.

      "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
   2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
   3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
       ve hatasiz code yazma acilarindan cok faydalidir.
   4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
      Lambda kullanmak hatasız code kullanmaktır.

          Collections Nedir?
          Çoğu yazılım tek tek öğeler yerine öğelerden oluşan toplulukları depolar ve onlar üzerinde işlem
          yapar. Array'ler onlardan birisidir. Java Collections Framework, arraylerle yapılan işleri daha kolay
          yaptığı gibi, daha fazlasını da yapar.
          Java'da bir koleksiyon (collection - bazen container, ambar diye adlandırılır) nesnelerden oluşan bir
          topluluğu bir arada tutan bir yapıdır. 'Collections Framework' ise arayüzler ve onların kurgularından
          (implementations) oluşur.
*/


    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38));
        printElStructured(sayi);
        System.out.println("\n    1-      ***          ");
        printElFunctional(sayi);
        System.out.println("\n  2-        ***          ");
        printElFunctional1(sayi);
        System.out.println("\n    3-      ***          ");
        printCiftElStructured1(sayi);
        System.out.println("\n    4-      ***          ");
        printCiftElStructured(sayi);
        System.out.println("\n     5-     ***          ");
        printTekElStructured(sayi);
        System.out.println("\n   6-       ***          ");
        printCiftElStructured2(sayi);
        System.out.println("\n   7-       ***          ");
        printElOtuzdorttenKucuk(sayi);
        System.out.println("\n   8-       ***          ");
        printElOtuzdorttenKucuk2(sayi);
        System.out.println("\n   9-       ***          ");
        printElOtuzdorttenBuyukVeyaCift(sayi);

    }

    //structured programming  kullanarak list elemanlarinin aralarina bosluk koyarak yazdirin
    public static void printElStructured(List<Integer> sayi) {
        for (Integer w : sayi) {
            System.out.print(w + "  ");
        }
    }

    //"functional programming" kullanarak list elemanlarinin aralarina bosluk koyarak yazdirin
    public static void printElFunctional(List<Integer> sayi) {
        //once aksiyon yapacagin elemani yaz. Strem methodunu call et. Nokta ekleyerek
        //forEach i seciyoruz. Icine aksiyon icin bir parametre yaziyoruz.
        //parametremiz t-> =bu ifade foreach'te t w nin yaptigi isi gorur.
        //lambda methodlarla calisir, extra method create etmezsiniz
        sayi.stream().forEach(t -> System.out.print(t + "  "));
        //sayiyi al akisa sok her birini yazdir.

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
   TRIC=> Lambda Expression  yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir.Yani kendin create etmeyeceksin hazir
   olanlari kullanacksin. Eger kutuphanede bir sey yoksa o zaman kendi create edilebilir. Referance etme
   ile call etme ayni anlama gelir


      */
    public static void printElFunctional1(List<Integer> sayi) {
        sayi.stream().forEach(System.out::print);//
        //Sana sayilar gelecek akisa sun ve her biri icin system out yapisina git print methodu refere et
        //buna method referance denir.Buradaki system de class'tir.
        //burda araya bosluk konulamayacagi icin yukarida istenilen task calismaz. Bu yuzden bu
        // bkullanilmaz ve kendin yazmak zorunda kalacaksin. Mumkun oldugunca hazir kutuphane kullanilmali
        // mecbur kalininca elle yazilmali
        //bu action task'teki ayni satira ve b osluk ile yazmayi karsilamaz
        //bu yuzden seed(tohum) method create edilip refere edilmelidir


    }

    public static void yazdir(int a) {//verilen int degeri ayni satirda bosluk birakarak
        // yazdirma islemi yapan seed(tohum) method create edildi
        System.out.print(a + "  ");

    }

    public static void printElFunctional2(List<Integer> sayi) {
        sayi.stream().forEach(Lambda01::yazdir);
    }

    //structured programming ile list elemanlarinin sift olanlarini
    //ayni satirda aralarina bosluk birakarak prin et
    public static void printCiftElStructured(List<Integer> sayi) {
        for (Integer w : sayi) {
            if (w % 2 == 0) {
                System.out.print(w + "  ");
            }

        }
    }

    public static void printCiftElStructured1(List<Integer> sayi) {
        sayi.stream().filter(t -> t % 2 == 0).forEach(Lambda01::yazdir);
        //(sayi)sayi lari al.(stream) Akisa sun. (filter)Akistan sonra ciftleri filtrele.
        //        (forEach) Onlari da Lambda1 methodundaki yazdir methodu ile yazdir.
    }

    //tek sayilari yazdir
    public static void printTekElStructured(List<Integer> sayi) {
        sayi.stream().filter(t -> t % 2 != 0).forEach(Lambda01::yazdir);
        //tek sayilari filtrele
    }

    public static boolean ciftBul(int a) {
        return a % 2 == 0;
    }

    //ciftBul methodu ile birlestirerek cift sayilari yazdir
    public static void printCiftElStructured2(List<Integer> sayi) {
        sayi.stream().filter(Lambda01::ciftBul).forEach(Lambda01::yazdir);
    }

    //cift ve 34 'ten kucuk sayilari yazdirin
    public static void printElOtuzdorttenKucuk(List<Integer> sayi) {
        sayi.stream().filter(t -> t % 2 == 0 && t < 34).forEach(Lambda01::yazdir);
    }

    public static void printElOtuzdorttenKucuk2(List<Integer> sayi) {
        sayi.
                stream().filter(Lambda01::ciftBul).
                filter(t -> t < 34).
                forEach(Lambda01::yazdir);
    }
    //34'Ten buyuk veya cift
    public static void printElOtuzdorttenBuyukVeyaCift(List<Integer> sayi) {
        sayi.stream().filter(t -> t % 2 == 0 || t > 34).forEach(Lambda01::yazdir);
    }

}
