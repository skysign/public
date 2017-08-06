package com.tistory.skysign.BasicAlgorithm.Sort;

public class MergeSort extends SortBase {
    static public int temp[] = new int[MAX];

    static public void MergeSort2(int data[], int left, int right) {
        int i, j, k, middle;

        if (right > left) {
            middle = (left + right) / 2;

            MergeSort2(data, left, middle);
            MergeSort2(data, middle +1, right);

            for (i = middle +1; i > left; i--)
                temp[i -1] = data[i -1];

            for (j = middle; j < right; ++j)
                temp[right + middle -j] = data[j +1];

            for (k = left; k <= right; k++)
                data[k] = (temp[i] < temp[j])? temp[i++]: temp[j--];
        }
    }

    static public void mergeSort2() {
        MergeSort2(mBuf, 0, MAX -1);
    }

    static public void run() {
        System.out.println("MergeSort");
        makeRandomNumber();
        System.out.println("Input");
        DisplayBuffer();
        mergeSort2();
        System.out.println("Result");
        DisplayBuffer();
    }
}
