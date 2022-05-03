package arrays;

import java.util.Arrays;

public class Soru10 {
    /*
         TASK:
         you have a string "GayetBasarılı"
         with arrays change it to "CoookBasarılı" and write changing array
         (String iniz: "GayetBasarılı"  Diziyi "CoookBasarılı" ye cevirin )
         */
    public static void main(String[] args) {


    String[] str={"GayetBasarılı"};

    yerDegis(str);
}

    private static void yerDegis(String[] str) {
       Arrays.stream(str).
               map(t->t.substring(0,5).replace("Gayet","cook")+t.substring(5)).
               forEach(t -> System.out.print(t));
    }
}