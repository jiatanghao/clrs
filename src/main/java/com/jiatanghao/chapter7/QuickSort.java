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

    public static void quickSortForSameValue(int[] arr) {
        quickSortForSameValue(arr, 0, arr.length - 1);
    }

    private static void quickSortForSameValue(int[] arr, int p, int r) {
        if (p < r) {
            int[] partition = partitionForSameValue(arr, p, r);
            partitionForSameValue(arr, p, partition[0] - 1);
            partitionForSameValue(arr, partition[1], r);
        }
    }

    private static int[] partitionForSameValue(int[] arr, int p, int r) {
        int[] result = new int[2];
        int i = p - 1;
        int k = p - 1;
        int x = arr[r];
        for (int j = p; j < r; j++) {
            if (arr[j] < x) {
                i++;
                k++;
                swap(arr, k, j);
                if (i < k) {
                    swap(arr, i, k);
                }
            } else if (arr[j] == x) {
                k++;
                swap(arr, k, j);
            }
        }
        swap(arr, k + 1, r);
        result[0] = i + 1;
        result[1] = k + 1;
        return result;
    }
}
