package com.tistory.skysign.BasicAlgorithm.Sort;

public class ShellSort extends SortBase{

    public static void ShellSort() {
        int gaps[] = {MAX / 5, MAX / 10, MAX / MAX };

        for (int idxGap = 0; idxGap < gaps.length; ++idxGap) {
            int gap = gaps[idxGap];

            System.out.println("gap " + String.valueOf(gap));

            for (int i = gap; i < MAX; ++i) {
                int nTmp = mBuf[i];
                int idxCompare = i;

                while (idxCompare >= gap && mBuf[idxCompare-gap] > nTmp) {
                    mBuf[idxCompare] = mBuf[idxCompare-gap];
                    idxCompare -= gap;
                }

                mBuf[idxCompare] = nTmp;
            }

            DisplayBuffer();
        }
    }

    public static void run() {
        makeRandomNumber();
        System.out.println("Input");
        DisplayBuffer();
        ShellSort();
        System.out.println("Result");
        DisplayBuffer();
    }
}
