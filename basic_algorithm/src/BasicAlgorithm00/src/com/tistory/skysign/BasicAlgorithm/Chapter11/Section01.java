package com.tistory.skysign.BasicAlgorithm.Chapter11;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/*
그리드 알고리즘을 기반으로한, 다이다믹 프로그래밍으로 풀어야 하는 문제입니다.
 */
public class Section01 {
    public static void run11_01() {
        String strInputFile;
        strInputFile = "resources/chapter11/section01/input.txt";

        File fInput = new File(strInputFile);
        System.out.println("Readable " + strInputFile + " " + fInput.canRead());
        InputStream isInput;
        int nMinRunningMS = -1;

        try {
            isInput = new FileInputStream(fInput);
        } catch (Exception e){
            e.printStackTrace();
            return;
        }

        Scanner scanner = new Scanner(isInput);
        int cntTestCases = scanner.nextInt();

        while (scanner.hasNext()) {
            int nOS = scanner.nextInt();
            int nMem = scanner.nextInt();

            int cntApps = scanner.nextInt();

            int[] nAppsMS = new int[cntApps];
            int[] nAppsMem = new int[cntApps];

            for (int i=0; i<cntApps; ++i) {
                nAppsMS[i] = scanner.nextInt();
                nAppsMem[i] = scanner.nextInt();
            }
            nMinRunningMS = my(nOS, nMem, nAppsMS, nAppsMem);
            System.out.println("스마트폰의 최소 실행 시간 : " + nMinRunningMS);

//            String strIn = scanner.next();
//            System.out.println(strIn);
        }
    }

    private static int my(int nOS, int nMem, int[] nAppsMS, int[] nAppsMem) {
        final int MAX = 1024 * 1024;
        int nFreeMem = nMem - nOS;
        int rtnnMinRunningMS = 0;

        int[] S = new int[nFreeMem +1];

        for (int i=0; i<S.length; ++ i)
            S[i] = MAX;

        S[0] = 0;

        for (int i = 0; i < nAppsMS.length; ++i) {
            for (int j = 0; j <= nFreeMem - nAppsMem[i]; ++j) {
                if (S[j] + nAppsMS[i] < S[j + nAppsMem[i]] ) {
                    S[j + nAppsMem[i]] = S[j] + nAppsMS[i];
                }
            }
        }

        rtnnMinRunningMS = S[S.length-1];


        return rtnnMinRunningMS;
    }
//
//        class App implements Comparable<App>{
//            public int mnMS;
//            public int mnMem;
//
////          debugging
//            public int mnCnt;
//
//            public App(int nAppsMS, int nAppsMem) {
//                mnMS = nAppsMS;
//                mnMem = nAppsMem;
//                mnCnt = 0;
//            }
//
//            @Override
//            public int compareTo(App o) {
//                if (this.mnMS > o.mnMS)
//                    return -1;
//                else if (this.mnMS == o.mnMS) {
//                    if (this.mnMem > o.mnMem)
//                        return -1;
//
//                    return 0;
//                }
//                return 1;
//            }
//
//            public String toString() {
//                return "MS " + this.mnMS + " Mem " + this.mnMem + " 사용됨 " + this.mnCnt;
//            }
//        }
//
//        LinkedList<App> lApp = new LinkedList<App>();
//        LinkedList<App> lAppUsed = new LinkedList<App>();
//
//        for (int i = 0; i< nAppsMS.length; ++i) {
//            lApp.add(new App(nAppsMS[i], nAppsMem[i]));
//        }
//
//        Collections.sort(lApp);
////        Collections.sort(lApp, (Comparable)new App(0, 0));
//
//        System.out.println("Not sorted " + lApp.toString());
//
//        Collections.sort(lApp, Collections.reverseOrder());
////        Collections.sort(lApp, (Comparable)new App(0, 0));
//        System.out.println("Sorted " + lApp.toString());
//
//
//        while (nFreeMem > 0 && (lApp.size() > 0 || lAppUsed.size() > 0)) {
//            if (lApp.size() > 0) {
//                App myApp = lApp.get(0);
//                if (nFreeMem - myApp.mnMem >= 0) {
//                    nFreeMem -= myApp.mnMem;
//                    rtnnMinRunningMS += myApp.mnMS;
//                    myApp.mnCnt++;
//                    lApp.remove(0);
//                    lAppUsed.add(myApp);
//                }
//                else {
//                    lApp.remove(0);
//                    lAppUsed.add(myApp);
//                }
//            }
//            else if (lApp.size() <= 0 && lAppUsed.size() > 0) {
//                App myUsedApp = lAppUsed.get(0);
//                if (nFreeMem - myUsedApp.mnMem >= 0) {
//                    nFreeMem -= myUsedApp.mnMem;
//                    rtnnMinRunningMS += myUsedApp.mnMS;
//                    myUsedApp.mnCnt ++;
//                }
//                else {
//                    lAppUsed.remove(0);
//                }
//            }
//            else {
//                break;
//            }
}