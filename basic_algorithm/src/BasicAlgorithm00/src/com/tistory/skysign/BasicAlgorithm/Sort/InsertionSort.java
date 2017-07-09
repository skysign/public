package com.tistory.skysign.BasicAlgorithm.Sort;

public class InsertionSort extends  SortBase {
    public static void InsertionSort() {
        /*
        Insertion Sort는 idx 이전까지는 모두 정렬되어 있다고 가정합니다.
        (여기서는 구현에서는, 오름차순으로 정렬했습니다.)
        idx의 값이, 0~idx-1중에 어디에 넣어야, 0~idx까지 정렬된 상태를 유지 하는지,
        찾는 알고리즘 입니다.
         */
        for(int idx = 1; idx < MAX; ++idx) {
            int nTmp = mBuf[idx];

            for(int idxCompare = 0; idxCompare < idx; ++idxCompare) {
                if (nTmp < mBuf[idxCompare]) {
                    /* 0~idx-1 중에 idxCompare위치에 idx를 넣어야 합니다. */
                    /* 넣기 위해서, 하나씩 뒤로 밀어 냅니다. */
                    for (int i = idx-1; i >= idxCompare; --i) {
                        mBuf[i+1] = mBuf[i];
                    }

                    mBuf[idxCompare] = nTmp;
                    break;
                }
            }
            DisplayBuffer();
        }
    }

    public static void run() {
        makeRandomNumber();
        System.out.println("Input");
        DisplayBuffer();
        InsertionSort();
        System.out.println("Result");
        DisplayBuffer();
    }
}
