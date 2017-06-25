package com.tistory.skysign.BasicAlgorithm;

import java.util.Random;

/**
 * Created by skysign on 6/25/2017.
 */
public class SelectionSort {
    public static int MAX = 10;
    public static int mBuf[] = new int[MAX];

    public static void swap(int idxa, int idxb) {
        int nTmp = mBuf[idxa];
        mBuf[idxa] = mBuf[idxb];
        mBuf[idxb] = nTmp;
    }

    public static void makeRandomNumber() {
        Random random = new Random();

        for (int idx = 0; idx < MAX; ++idx) {
            mBuf[idx] = random.nextInt(1000);
        }
    }

    public static void DisplayBuffer() {
        for (int idx = 0; idx < MAX; ++idx) {
            System.out.print(mBuf[idx] + " ");
        }

        System.out.println();
    }

    /*
    SelectionSort는 idx가 가리키는 자리에 mBuf 배열중에
    어떤 값이 들어와야 정렬이 되는지는 값을 찾는 알고리즘입니다
     */
    public static void selectionSort() {
        for (int idx = 0; idx < MAX; ++idx) {
            int idxMin = idx;

            for (int idxCompare = idxMin + 1; idxCompare < MAX; ++idxCompare) {
                if (mBuf[idxCompare] < mBuf[idxMin]) {
                    idxMin = idxCompare;
                }
            }
            swap(idx, idxMin);
            DisplayBuffer();
        }
    }

    static public void run() {
        makeRandomNumber();
        System.out.println("Input");
        DisplayBuffer();
        selectionSort();
        System.out.println("Result");
        DisplayBuffer();
    }
}
