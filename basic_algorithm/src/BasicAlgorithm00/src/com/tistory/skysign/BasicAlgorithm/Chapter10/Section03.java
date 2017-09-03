package com.tistory.skysign.BasicAlgorithm.Chapter10;

import java.io.IOException;
import java.util.Scanner;

public class Section03 {
    public static void run10_3() {
        int data = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("type number : ");
        data = scanner.nextInt();

        System.out.println(data);

        for (int i = 1; i <= data; ++i) {
            if (data % i == 0) {
                System.out.println(i);
            }
        }
    }

    public static void run10_4() {
        int data1, data2;
        int num;

        Scanner scanner = new Scanner(System.in);

        System.out.println("type number#1 : ");
        data1 = scanner.nextInt();

        System.out.println("type number#2 : ");
        data2 = scanner.nextInt();

        if (data1 < data2) {
            num = data1;
        } else {
            num = data2;
        }

        for (int i = 1; i <= num; ++i) {
            if ((data1 % i == 0) && (data2 % i == 0))
                System.out.println(i);
        }
    }

    public static void run10_6() {
        int fn_1, fn_2;
        int fn;

        fn_1 = 1;
        fn_2 = 0;

        for (int i = 1; i <= 24; ++i) {
            fn = fn_1 + fn_2;

            System.out.println(i + " " + fn);

            fn_2 = fn_1;
            fn_1 = fn;
        }
    }

    public static void run10_7() {
        int num = 0;
        int sum = 0;
        int cnt = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("type number : ");
        num = scanner.nextInt();

        for (int i = 1; i <= 1000; ++i) {
            if (i % num == 0) {
                cnt++;
                sum += i;
            }
        }

        System.out.println("count " + cnt);
        System.out.println("sum " + sum);
    }

    public static void run10_8() {
        int i, j;
        int cnt = 1; // 1도 소수임으로, cnt를 1부터 시작하고, i는 2부터 시작한다

        for (i = 2; i <= 1000; ++i) {
            for (j = 2; j < i; ++j) {
                if (i % j == 0) {
                    break;
                }
            }

            if (i == j) {
                System.out.println(i);
                cnt++;
            }
        }

        System.out.print("numbers : ");
        System.out.println(cnt);
    }

    public static void run10_9() {
        for (int i = 1; i <= 5; ++i) {
            int num = i * 5;

            for (int j = 1; j <= 5; ++j) {
                if (i % 2 == 0) {
                    System.out.print(num - j +1);
                } else {
                    System.out.print(num + j -5);
                }
                System.out.print('\t');
            }

            System.out.println();
        }
    }

    public static int findCommonDiviser(int data1, int data2) {
        int min = Math.min(data1, data2);

        for (int i=2; i<=min; ++i) {
            if ((data1 % i == 0) && (data2 % i == 0)) {
                return i;
            }
        }

        return -1;
    }

    public static void run10_10() {
        Scanner scanner = new Scanner(System.in);
        int data1, data2, min;
        int gcd = 1;
        int commonDiviser = 0;

        System.out.print("type number 1: ");
        data1 = scanner.nextInt();
        System.out.print("type number 2: ");
        data2 = scanner.nextInt();

        min = Math.min(data1, data2);

        do {
            commonDiviser = findCommonDiviser(data1, data2);
            System.out.println("common diviser : " + commonDiviser);
            if (commonDiviser > 0) {
                gcd *= commonDiviser;
                System.out.println("current GCD " + gcd);
                data1 /= commonDiviser;
                data2 /= commonDiviser;
            }
        } while (commonDiviser > 0);

        System.out.println("GCD is " + gcd);
    }
}
