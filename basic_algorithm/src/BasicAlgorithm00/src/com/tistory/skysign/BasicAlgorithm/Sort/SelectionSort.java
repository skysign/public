package com.tistory.skysign.BasicAlgorithm.Sort;

public class SelectionSort extends SortBase{
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
        System.out.println("SelectionSort");
        makeRandomNumber();
        System.out.println("Input");
        DisplayBuffer();
        selectionSort();
        System.out.println("Result");
        DisplayBuffer();
    }
}
