package com.tistory.skysign.BasicAlgorithm.Chapter11;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Section03 {
    public static void run11_03() {
        String strInputFile = "resources/chapter11/section03/input.txt";
//        String strInputFile = "resources/chapter11/section03/input2.txt";

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
        int column = scanner.nextInt();
        int row = scanner.nextInt();
        int steps = scanner.nextInt();
        char[][] _map = new char[column][row];
        int[][] map = new int[column][row];
        int[][] mapFire = new int[column][row];

        int beginI = 0, beginJ = 0, endI = 0, endJ = 0;

        for (int i=0; i<column; ++i) {
            String str = scanner.next();
            for (int j=0; j<row; ++j) {
                _map[i][j] = str.charAt(j);
                map[i][j] = 0;
                if ('Y' == str.charAt(j)){
                    beginI = i;
                    beginJ = j;
                }
                if ('E' == str.charAt(j)){
                    endI = i;
                    endJ = j;
                }
                if ('F' == str.charAt(j)){
                    mapFire[i][j] = 1;
                }
            }
        }

//        System.out.println("beginI " + String.valueOf(beginI));
//        System.out.println("beginJ " + String.valueOf(beginJ));
//        System.out.println("endI " + String.valueOf(endI));
//        System.out.println("endJ " + String.valueOf(endJ));
//
//        printFire(mapFire);


//        System.out.println("input==============================================>");
//        for (int i=0; i<column; ++i) {
//            for (int j=0; j<row; ++j) {
//                System.out.print(_map[i][j]);
//            }
//            System.out.println();
//        }

        int cnt = 1;
        floodfill(map, beginI, beginJ, endI, endJ, "", cnt, mapFire);

        // to know all of path
//        System.out.println("END==============================================>");
//        for (int i=0; i<column; ++i) {
//            for (int j=0; j<row; ++j) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
    }

    public static boolean IsNear(int oldI, int oldJ, int i, int j, int endI, int endJ) {
        int oldLength = Math.abs(endI - oldI) + Math.abs(endJ - oldJ);
        int newLength = Math.abs(endI - i) + Math.abs(endJ - j);

        if (newLength < oldLength) {
            return true;
        }
        return false;
    }


    public static boolean IsIn(int[][] map, int i, int j) {
        if ((0 <= i) && (i < map.length))
            if((0 <=j) && (j < map[0].length))
                return true;

        return false;
    }

    public static boolean WorthTomove(int[][] map,
                                      int oldI, int oldJ,
                                      int i, int j,
                                      int endI, int endJ,
                                      int[][] mapFire) {
        if (false == IsIn(map, i, j))
            return false;

//        if (false == IsNear(oldI, oldJ, i, j, endI, endJ)){
//            return false;
//        }

        if (1 == mapFire[i][j]) {
            return false;
        }

        if (map[i][j] > 0){
            if (map[i][j] != map[oldI][oldJ] + 1) {
                return false;
            }
        }

        map[i][j] = map[oldI][oldJ] + 1;

//        printFire(mapFire);
//        printMap(map);

        return true;
    }

    public static void floodfill(int[][] map,
                                 int beginI, int beginJ, int endI, int endJ,
                                 String strResult, int cnt,
                                 int[][] mapFire) {
        int nextUpI = beginI-1, nextUpJ = beginJ;
        int nextDownI = beginI+1, nextDownJ = beginJ;
        int nextLeftI = beginI, nextLeftJ = beginJ-1;
        int nextRightI = beginI, nextRightJ = beginJ+1;

//        System.out.println(cnt);

        if (beginI == endI) {
            if (beginJ == endJ) {
//                System.out.println("<==============================================>");
                System.out.println(cnt-1);
                System.out.println(strResult);

//                for (int i=0; i<map.length; ++i) {
//                    for (int j=0; j<map[0].length; ++j) {
//                        System.out.print(map[i][j]);
//                    }
//                    System.out.println();
//                }
//                System.out.println("<==============================================>");
                return;
            }
        }


        int[][] newMapFire = cloneArray(mapFire);
        if (0 == cnt % 2){
            floodFire(newMapFire);
        }

        if(WorthTomove(map, beginI, beginJ, nextUpI, nextUpJ, endI, endJ, mapFire)){
            floodfill(map, nextUpI, nextUpJ, endI, endJ, strResult+"U", cnt+1, newMapFire);
        }

        if(WorthTomove(map, beginI, beginJ, nextDownI, nextDownJ, endI, endJ, mapFire)){
            floodfill(map, nextDownI, nextDownJ, endI, endJ, strResult+"D", cnt+1, newMapFire);
        }

        if(WorthTomove(map, beginI, beginJ, nextLeftI, nextLeftJ, endI, endJ, mapFire)){
            floodfill(map, nextLeftI, nextLeftJ, endI, endJ, strResult+"L", cnt+1, newMapFire);
        }

        if(WorthTomove(map, beginI, beginJ, nextRightI, nextRightJ, endI, endJ, mapFire)){
            floodfill(map, nextRightI, nextRightJ, endI, endJ, strResult+"R", cnt+1, newMapFire);
        }
    }

    public static void floodFire(int[][] mapFire) {
        for (int i=0; i<mapFire.length; ++i) {
            for (int j=0; j<mapFire[0].length; ++j) {
                if (1 == mapFire[i][j]) {
                    int nextUpI = i-1, nextUpJ = j;
                    int nextDownI = i+1, nextDownJ = j;
                    int nextLeftI = i, nextLeftJ = j-1;
                    int nextRightI = i, nextRightJ = j+1;

                    int[] Is = {nextUpI, nextDownI, nextLeftI, nextRightI};
                    int[] Js = {nextUpJ, nextDownJ, nextLeftJ, nextRightJ};

                    for (int idxUDLR = 0; idxUDLR < Is.length; ++idxUDLR) {
                        int x = Is[idxUDLR];
                        int y = Js[idxUDLR];
                        if ((0 <= x) && (x < mapFire.length)){
                            if((0 <=y) && (y < mapFire[0].length)){
                                if (0 == mapFire[x][y]) {
                                    mapFire[x][y] = 2;
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i=0; i<mapFire.length; ++i) {
            for (int j = 0; j < mapFire[0].length; ++j) {
                if (2 == mapFire[i][j]) {
                    mapFire[i][j] = 1;
                }
            }
        }
    }

    public static void printMap(int[][] map) {
        System.out.println("Map---------------------------------------------");
        for (int i=0; i<map.length; ++i) {
            for (int j=0; j<map[0].length; ++j) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------------");
    }

    public static void printFire(int[][] mapFire) {
        System.out.println("Fire---------------------------------------------");
        for (int i=0; i<mapFire.length; ++i) {
            for (int j=0; j<mapFire[0].length; ++j) {
                System.out.print(mapFire[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------------");
    }

    public static int[][] cloneArray(int[][] src) {
        int length = src.length;
        int[][] target = new int[length][src[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(src[i], 0, target[i], 0, src[i].length);
        }
        return target;
    }
}
