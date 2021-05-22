package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert mass size: ");
        int n = scanner.nextInt();
        init(n);
    }

    private static void init(int n) {
        int[] mas = new int[n];
        for (int i = 0; i < n; i++) {
            mas[i] = (int) (Math.random() * 20);
        }
        System.out.println(Arrays.toString(mas));
        System.out.println("Shake sort: " + Arrays.toString(shakeSort(mas)));
        System.out.println("Brash sort: " + Arrays.toString(brashSort(mas, n)));
    }

    private static int[] brashSort(int[] mas, int n) {
        int i = n, k, cur;
        while (n > 1) {
           i /= 1.247f;
           if (i < 1)
               i = 1;
           k = 0;
            for (int j = 0; j + i < n; ++j) {
                if(mas[j] > mas[j+i]) {
                    cur=mas[j];
                    mas[j]=mas[j+i];
                    mas[j+i]=cur;
                    k=i;
                }
            }
            if (i==1)
                n=k+1;
        }
        return mas;
    }

    private static int[] shakeSort(int[] mas) {
        int cur, first = 0, second = mas.length - 1;
        while (first < second) {
            for (int i = first; i < second; i++) {
                if (mas[i] > mas[i + 1]) {
                    cur = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = cur;
                }
            }
            second--;
            for (int i = second; i > first; i--) {
                if (mas[i] < mas[i - 1]) {
                    cur = mas[i];
                    mas[i] = mas[i - 1];
                    mas[i - 1] = cur;
                }
            }
            first++;
        }
        return mas;
    }
}