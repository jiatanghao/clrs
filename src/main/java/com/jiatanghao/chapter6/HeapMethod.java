package com.jiatanghao.chapter6;

import static com.jiatanghao.chapter2.BasicAlgorithm.swap;

public class HeapMethod {

    private HeapMethod() {
    }

    public static int parent(int i) {
        if (i <= 0) {
            return 0;
        }
        return (i - 1) >> 1;
    }

    public static int left(int i) {
        return i * 2 + 1;
    }

    public static int right(int i) {
        return 2 * i + 2;
    }

    public static void maxHeapify(int[] array, int i, int n) {
        int l = left(i);
        int r = right(i);
        int largest;
        if (l < n && array[i] < array[l]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r < n && array[largest] < array[r]) {
            largest = r;
        }
        if (i != largest) {
            swap(array, i, largest);
            maxHeapify(array, largest, n);
        }
    }

    public static void buildMaxHeap(int[] array) {
        for (int i = array.length / 2; i >= 0; i--) {
            maxHeapify(array, i, array.length);
        }
    }

    public static void heapSort(int[] array) {
        buildMaxHeap(array);
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, i, 0);
            maxHeapify(array, 0, i);
        }
    }
}
