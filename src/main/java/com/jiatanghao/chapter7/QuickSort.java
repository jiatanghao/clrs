package com.jiatanghao.chapter7;

import static com.jiatanghao.chapter2.BasicAlgorithm.swap;

public class QuickSort {
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }

    private static int partition(int[] arr, int p, int r) {
        int x = arr[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (arr[j] <= x) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    private static int randomPartition(int[] arr, int p, int r) {
        int i = (int) (Math.random() * (r - p + 1) + p);
        swap(arr, r, i);
        return partition(arr, p, r);
    }

    private static void randomQuickSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = randomPartition(arr, p, r);
            randomQuickSort(arr, p, q - 1);
            randomQuickSort(arr, q + 1, r);
        }
    }

    public static void randomQuickSort(int[] arr) {
        randomQuickSort(arr, 0, arr.length - 1);
    }
}
