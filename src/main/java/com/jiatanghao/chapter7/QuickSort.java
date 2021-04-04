package com.jiatanghao.chapter7;

import java.security.SecureRandom;

import static com.jiatanghao.chapter2.BasicAlgorithm.swap;

public class QuickSort {

    private QuickSort() {
    }

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
        int i = new SecureRandom().nextInt(r - p + 1) + p;
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
        quickSortForSameValue(arr, arr.length - 1);
    }

    private static void quickSortForSameValue(int[] arr, int r) {
        if (0 < r) {
            int[] partition = partitionForSameValue(arr, 0, r);
            partitionForSameValue(arr, 0, partition[0] - 1);
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

    public static void tailRecursiveQuickSort(int[] arr) {
        tailRecursiveQuickSort(arr, 0, arr.length - 1);
    }

    private static void tailRecursiveQuickSort(int[] arr, int p, int r) {
        while (p < r) {
            int q = randomPartition(arr, p, r);
            tailRecursiveQuickSort(arr, p, q - 1);
            p = q + 1;
        }
    }

    public static void doubleEndQuickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = doubleEndPartition(array, left, right);
        doubleEndQuickSort(array, left, mid - 1);
        doubleEndQuickSort(array, mid + 1, right);
    }

    public static int doubleEndPartition(int[] array,int leftBound, int rightBound) {
        int key = array[rightBound];
        int left = leftBound;
        int right = rightBound - 1;

        while (left <= right) {
            while (left <= right && array[left] <= key) {
                left++;
            }
            while (left <= right && array[right] > key) {
                right--;
            }
            if (left < right) {
                swap(array, left, right);
            }
        }
        swap(array, left, rightBound);
        return left;
    }
}
