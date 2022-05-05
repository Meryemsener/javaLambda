import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lambda06 {
    public static void main(String[] args) throws IOException {
        //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a yazdiriniz)

        System.out.println("\n*** notlar.txt dosyasini okuyunuz -->  ");
        try {
            Files.lines(Paths.get("src/notlar.txt")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** notlar.txt dosyasini buyuk harflerle okuyunuz -->  ");
        try {
            Files.lines(Paths.get("src/notlar.tx")).map(String::toUpperCase).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** notlar.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");


        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz yazdiriniz
        System.out.println("\n*** notlar.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");


        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz.
        System.out.println("\n*** notlar.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");


        //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.
        System.out.println("\n*** notlar.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");


        //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız yaziniz.
        System.out.println("\n*** notlar.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");


        //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz
        System.out.println("\n*** notlar.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");


        //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
        System.out.println("\n*** notlar.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");


        //TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini yazdiriniz
        System.out.println("\n*** notlar.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");


        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\n*** notlar.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
    }

    }
