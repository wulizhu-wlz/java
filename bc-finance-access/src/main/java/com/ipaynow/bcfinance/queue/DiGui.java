package com.ipaynow.bcfinance.queue;

import java.util.Scanner;

public class DiGui {
    static int fun(int n, int k) {
        //n,行，k:列
        if (k == 1 || n == k)
            return 1;
        else
            return fun(n - 1, k - 1) + fun(n - 1, k);
    }

    public static void main(String[] args) {
        int lines;
        System.out.println("请输入行数：");
        Scanner input = new Scanner(System.in);
        lines = input.nextInt();

        int[][] array = new int[lines+1][lines+1];

        for (int i = 1; i <= lines; i++) {
            for (int k = 1; k < lines - i + 1; k++) {
                System.out.print(" ");
               // array[i][k] = "";
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(fun(i, j) + " ");
                array[i][j] = fun(i,j);
            }
            System.out.println();
        }
        System.out.println("请输入查找行数：");
        Scanner input1 = new Scanner(System.in);
        int inputLine = input1.nextInt();
        System.out.println("请输入查找列数：");
        Scanner input2 = new Scanner(System.in);
        int column = input2.nextInt();
        System.out.println("result:"+array[inputLine][column]);

    }
}