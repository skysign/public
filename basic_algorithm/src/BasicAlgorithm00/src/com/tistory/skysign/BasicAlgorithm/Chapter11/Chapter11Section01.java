package com.tistory.skysign.BasicAlgorithm.Chapter11;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Chapter11Section01 {
    public static void run11_01() {
        String strInputFile;
        strInputFile = "resources/chapter11/section01/input.txt";

        File fInput = new File(strInputFile);
        System.out.println("Readable " + strInputFile + " " + fInput.canRead());
        InputStream isInput;

        try {
            isInput = new FileInputStream(fInput);
        } catch (Exception e){
            e.printStackTrace();
            return;
        }

        Scanner scanner = new Scanner(isInput);

        int cntTestCases = scanner.nextInt();
        int nOS = scanner.nextInt();
        int nMem = scanner.nextInt();

        while (scanner.hasNext()) {
            int cntApps = scanner.nextInt();

            int[] nAppsMS = new int[cntApps];
            int[] nAppsMem = new int[cntApps];

            for (int i=0; i<cntApps; ++i) {
                nAppsMS[i] = scanner.nextInt();
                nAppsMem[i] = scanner.nextInt();
            }
            my(nOS, nMem, nAppsMS, nAppsMem);
//
//            String strIn = scanner.next();
//
//            System.out.println(strIn);
        }
    }

    private static void my(int nOS, int nMem, int[] nAppsMS, int[] nAppsMem) {
        int nFreeMem = nMem - nOS;
        class App implements Comparable<App>{
            public int mnMS;
            public int mnMem;

            public App(int nAppsMS, int nAppsMem) {
                mnMS = nAppsMS;
                mnMem = nAppsMem;
            }

            @Override
            public int compareTo(App o) {
                if (this.mnMS > o.mnMS)
                    return -1;
                else if (this.mnMS == o.mnMS) {
                    return 0;
                }
                return 1;
            }

            public String toString() {
                return "MS " + this.mnMS + " Mem " + this.mnMem + "\n";
            }
        }

        LinkedList<App> lApp = new LinkedList<App>();

        for (int i = 0; i< nAppsMS.length; ++i) {
            lApp.add(new App(nAppsMS[i], nAppsMem[i]));
        }

        Collections.sort(lApp);
//        Collections.sort(lApp, (Comparable)new App(0, 0));
        System.out.println(lApp.toString());

        Collections.sort(lApp, Collections.reverseOrder());
//        Collections.sort(lApp, (Comparable)new App(0, 0));
        System.out.println(lApp.toString());


        while (nFreeMem > 0) {

        }
    }
}