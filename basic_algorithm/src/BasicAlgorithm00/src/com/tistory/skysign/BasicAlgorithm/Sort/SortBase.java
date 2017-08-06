package com.tistory.skysign.BasicAlgorithm.Sort;

import java.util.Random;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class SortBase {
    public static int MAX = 20;
    public static int mBuf[] = new int[MAX];

    public static void swap(int idxa, int idxb) {
        int nTmp = mBuf[idxa];
        mBuf[idxa] = mBuf[idxb];
        mBuf[idxb] = nTmp;
    }

    public static void swap(int data[], int idxa, int idxb) {
        int nTmp = data[idxa];
        data[idxa] = data[idxb];
        data[idxb] = nTmp;
    }

    public static void makeRandomNumber() {
        Random random = new Random();
        int i = 0;

        while (i < MAX) {
            int n = random.nextInt(MAX);

            if (!IsNumberExisted(n, i)) {
                mBuf[i] = n;
                i++;
            }
        }
    }

    public static boolean IsNumberExisted(int n, int cnt) {

        for (int idx = 0; idx < cnt; ++idx) {
            if (mBuf[idx] == n)
                return TRUE;
        }

        return FALSE;
    }

    public static void DisplayBuffer() {
        for (int idx = 0; idx < MAX; ++idx) {
            System.out.print("["+ idx +"]"+mBuf[idx] + " ");
        }

        System.out.println();
    }
}
