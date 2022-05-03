package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Soru8 {
    /*
		 TASK :
		 $ ve  £  isareti olanlarin toplamlarini ayri ayri bulup yazdıran java code create ediniz.
        String str = "$1 $23 $134 $2 $7 $24 £32 £40 £2 £65 £4 ";
        */
    public static void main(String[] args) {
        String str[] = {"$1 $23 $134 $2 $7 $24 £32 £40 £2 £65 £4 "};
        List<Integer> newArr = new ArrayList<>();
        dolarTOpla(str);
        euroTOpla(str);

    }

    private static void euroTOpla(String str[]) {
        Arrays.stream(str)
                .map(s->s.replace("$",""))
                .collect(Collectors.toList());
    }



    private static void dolarTOpla(String str[]) {
    }


}
