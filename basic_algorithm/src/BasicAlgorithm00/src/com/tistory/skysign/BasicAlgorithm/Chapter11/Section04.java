package com.tistory.skysign.BasicAlgorithm.Chapter11;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Section04 {
    static public class MyPair {
        public int left;
        public int right;
    }

    public static void run11_04() {
        String strInputFile = "resources/chapter11/section04/input.txt";

        File fInput = new File(strInputFile);
        System.out.println("Readable " + strInputFile + " " + fInput.canRead());
        InputStream isInput;
        int nMinRunningMS = -1;

        try {
            isInput = new FileInputStream(fInput);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Scanner scanner = new Scanner(isInput);
        int num = scanner.nextInt();
        final int COLUMN = 5;
        final int ROW = 6;
        int[][] map = new int[COLUMN][ROW];

        for (int i=0; i<COLUMN; ++i) {
            for (int j=0; j<ROW; ++j) {
                map[i][j] = scanner.nextInt();
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        ArrayList<MyPair> listPair = new ArrayList<MyPair>();

        for (int i = 1; i <= num; ++i) {
            for (int j = 5; j > 0; --j) {

            }
        }
        MyPair pair = new MyPair();
    }
}
