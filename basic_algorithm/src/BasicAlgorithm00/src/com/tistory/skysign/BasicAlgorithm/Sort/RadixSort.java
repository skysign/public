package com.tistory.skysign.BasicAlgorithm.Sort;

import com.sun.org.apache.xml.internal.security.Init;

import java.util.ArrayList;

public class RadixSort extends SortBase {
    public static final int DECIMAL_NUMBER = 10;
    public static ArrayList<ArrayList<Integer>> mList;

    public static void InitializeQueue() {
        mList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < DECIMAL_NUMBER; ++i) {
            mList.add(new ArrayList<Integer>());
        }
    }

    public static void run() {
        makeRandomNumber();
        System.out.println("Input");
        DisplayBuffer();
        InitializeQueue();
        RadixSort();
        System.out.println("Result");
        DisplayBuffer();
    }

    public static void RadixSort() {
        int i, num, digit, j;



        for (i = 0; i < MAX; ++i) {
            num = mBuf[i];
            digit = num % 10;
            Put(digit, num);
        }

        j = 0;
        for (i = 0; i < DECIMAL_NUMBER; ++i) {
            while (true) {
                num = Get(i);

                if (num != -1) {
                    System.out.println(num);
                    mBuf[j] = num;
                    j++;
                } else {
                    break;
                }
            }
        }
        System.out.println("sort by 1 digit");
        DisplayBuffer();

        for (i = 0; i < MAX; ++i) {
            num = mBuf[i];
            digit = num / 10;
            Put(digit, num);
        }

        j = 0;
        for (i = 0; i < DECIMAL_NUMBER; ++i) {
            while (true) {
                num = Get(i);

                if (num != -1) {
                    mBuf[j] = num;
                    j++;
                }
                else {
                    break;
                }
            }
        }

        System.out.println("sort by 10 digit");
        DisplayBuffer();
    }

    public static void Put(int digit, int num) {
        ArrayList<Integer> list = mList.get(digit);
        list.add(new Integer(num));
    }

    public static int Get(int i) {
        ArrayList<Integer> list = mList.get(i);
        if (list.size() > 0) {
            int rtn =  list.get(0).intValue();
            list.remove(0);
            return rtn;
        }

        return -1;
    }
}