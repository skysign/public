package com.tistory.skysign.BasicAlgorithm.Sort;

public class MergeSort2 extends SortBase{
    static public int nTmps[] = new int[MAX];

    static public void MergeSort(int data[], int idxLeft, int idxRight) {
        if (idxLeft < idxRight) {
            int i, j, k, idxMiddle;

            idxMiddle = (idxLeft + idxRight) / 2;
            System.out.println("idxLeft " + idxLeft + " idxMiddle " + idxMiddle + " idxRight " + idxRight);

            MergeSort(data, idxLeft, idxMiddle);
            MergeSort(data, idxMiddle+1, idxRight);

            for (i = idxLeft; i <= idxMiddle; ++i) {
                nTmps[i] = data[i];
            }

            for (j = idxMiddle +1; j <= idxRight; ++j) {
                nTmps[j] = data[j];
            }

            i = idxLeft;
            j = idxMiddle +1;

            for(k = idxLeft; k <= idxRight; ++k) {
                if (nTmps[i] < nTmps[j]) {
                    data[k] = nTmps[i];
                    i++;

                    if (i > idxMiddle) {
                        break;
                    }
                }
                else {
                    data[k] = nTmps[j];
                    j++;

                    if (j > idxRight) {
                        break;
                    }
                }
            }

            ++k;

            for ( ; i <= idxMiddle; ++i, ++k) {
                data[k] = nTmps[i];
            }

            for ( ; j <= idxRight; ++j, ++k) {
                data[k] = nTmps[j];
            }

            DisplayBuffer();
        }
    }

    static public void mergeSort() {
        MergeSort(mBuf, 0, MAX -1);
    }

    static public void run() {
        System.out.println("MergeSort2");
        makeRandomNumber();
        System.out.println("Input");
        DisplayBuffer();
        mergeSort();
        System.out.println("Result");
        DisplayBuffer();
    }
}
