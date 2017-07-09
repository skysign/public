package com.tistory.skysign.BasicAlgorithm.Sort;

public class BubbleSort extends SortBase {
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
