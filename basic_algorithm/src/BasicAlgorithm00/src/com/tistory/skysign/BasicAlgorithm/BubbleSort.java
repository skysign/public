package com.tistory.skysign.BasicAlgorithm;

/**
 * Created by skysign on 6/25/2017.
 */
public class BubbleSort extends SelectionSort {
    public static void BubbleSort() {
        for(int cnt = MAX-1; cnt > 0 ; --cnt) {
            for(int idx = 0; idx < cnt; ++idx) {
                if (mBuf[idx] > mBuf[idx+1]) {
                    swap(idx, idx+1);
                }
            }

            DisplayBuffer();
        }
    }

    public static void run() {
        makeRandomNumber();
        System.out.println("Input");
        DisplayBuffer();
        BubbleSort();
        System.out.println("Result");
        DisplayBuffer();

    }
}
