package com.tistory.skysign.BasicAlgorithm.Extra.ChineseRemainderTheorem;

public class ChineseRemainderTheorem {
    static public void run() {
        for (long l = 1; l < Long.MAX_VALUE; ++l) {
            long digits = (long)(Math.log10(l)+1);

//            System.out.println(l);
            long l10 = (long) Math.pow(10, digits);

            if ( (l*l % l10) == l) {
                System.out.println(" " + l + " " + (l*l));
            }
        }
    }
}
