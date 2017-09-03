package com.tistory.skysign.BasicAlgorithm.Search;

import com.tistory.skysign.BasicAlgorithm.Sort.QuickSort;

public class BinarySearch extends QuickSort {
    static int CompareCount = 0;

    static int BinarySearch(int num) {
        int left = 0, right = MAX;
        int mid;

        while (left <= right) {
            CompareCount++;
            mid = (left + right) / 2;

            System.out.println("left " + left + " right " + right + " mid " + mid);

            if (num == mBuf[mid])
                return mid;

            if (num < mBuf[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }

    static public void run() {
        int ret;

        makeRandomNumber();
        System.out.println("Input");
        DisplayBuffer();
        QuickSort();
        System.out.println("Result");
        DisplayBuffer();

        ret = BinarySearch.BinarySearch(4);
        System.out.println("CompareCount" + CompareCount);
        System.out.println("ret" + ret);
    }
}
