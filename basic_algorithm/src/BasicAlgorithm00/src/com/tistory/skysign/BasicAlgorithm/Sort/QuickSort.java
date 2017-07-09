package com.tistory.skysign.BasicAlgorithm.Sort;

/**
 * Created by skysi on 2017-07-09.
 */
public class QuickSort extends SortBase{
    public static void QuickSort() {
        myQuickSort(mBuf, 0, MAX - 1);
    }

    public static void swap(int d[], int idxa, int idxb) {
        int nTmp = d[idxa];
        d[idxa] = d[idxb];
        d[idxb] = nTmp;
    }

    public static void myQuickSort(int d[], int idxLeft, int idxRight) {
        if (idxLeft < idxRight) {
            int i, pivot, j;

            i = idxLeft;
            pivot = d[idxRight];
            j = idxRight - 1;

            do {
                while ((d[i] < pivot) && (i < idxRight))
                    i++;
                while ((0 < j) && (pivot < d[j]))
                    j--;

                if (i < j) {
                    swap(d, i, j);
                }
            } while (i < j);

            int tmp = d[i];
            d[i] = pivot;
            d[idxRight] = tmp;

            DisplayBuffer();

            System.out.println("left part " + idxLeft + " " + (i-1));
            myQuickSort(d, idxLeft, i-1);
            System.out.println("right part " + (i+1) + " " + idxRight);
            myQuickSort(d, i+1, idxRight);
        }
    }

    public static void myCornerCaseNumber() {
        mBuf[0] = 13;
        mBuf[1] = 19;
        mBuf[2] = 12;
        mBuf[3] = 14;
        mBuf[4] = 11;
        mBuf[5] = 7;
        mBuf[6] = 5;
        mBuf[7] = 18;
        mBuf[8] = 16;
        mBuf[9] = 17;
        mBuf[10] = 10;
        mBuf[11] = 9;
        mBuf[12] = 15;
        mBuf[13] = 2;
        mBuf[14] = 6;
        mBuf[15] = 1;
        mBuf[16] = 4;
        mBuf[17] = 8;
        mBuf[18] = 3;
        mBuf[19] = 0;

//        [0]13 [1]19 [2]12 [3]14 [4]11 [5]7 [6]5 [7]18 [8]16 [9]17 [10]10 [11]9 [12]15 [13]2 [14]6 [15]1 [16]4 [17]8 [18]3 [19]0
    }


    public static void run() {
//        makeRandomNumber();
        myCornerCaseNumber();
        System.out.println("Input");
        DisplayBuffer();
        QuickSort();
        System.out.println("Result");
        DisplayBuffer();
    }
}
