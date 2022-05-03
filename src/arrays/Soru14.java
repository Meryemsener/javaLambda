package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Soru14 {
    /*  TASK :
     * Congratulations kelimesini Array yontemlerini kullanarak asagidaki outputu
     * alin.
     * input : Congratulations
     * output: [C, o, n, g, r, a, t, u, l, a, t, i, o, n, s]    sniitilitirgniC --> o ,a ve u harfini i ye donusturun.
     */
    public static void main(String[] args) {
        String str[] ={"Congratulations"};
        Arrays.stream(str).
                map(t-> Arrays.stream(t.split(" ")).
                        sorted(Comparator.reverseOrder())).
                collect(Collectors.toList()).forEach(t-> System.out.println(t));
    }

    }

