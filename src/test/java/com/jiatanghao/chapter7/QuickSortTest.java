package com.jiatanghao.chapter7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuickSortTest {

    @Test
    void quickSort() {
        int[] arr = {2, 8, 7, 1, 3, 5, 6, 4};
        int[] result = {1, 2, 3, 4, 5, 6, 7, 8};
        QuickSort.quickSort(arr);
        Assertions.assertArrayEquals(result, arr);
    }

    @Test
    void randomQuickSort() {
        int[] arr = {2, 8, 7, 1, 3, 5, 6, 4};
        int[] result = {1, 2, 3, 4, 5, 6, 7, 8};
        QuickSort.randomQuickSort(arr);
        Assertions.assertArrayEquals(result, arr);
    }

    @Test
    void quickSortForSameValue() {
        int[] arr = {2, 8, 7, 1, 2, 2, 6, 2};
        int[] result = {1, 2, 2, 2, 2, 6, 7, 8};
        QuickSort.quickSortForSameValue(arr);
        Assertions.assertArrayEquals(result, arr);
    }

    @Test
    void tailRecursiveQuickSort() {
        int[] arr = {2, 8, 7, 1, 2, 2, 6, 2};
        int[] result = {1, 2, 2, 2, 2, 6, 7, 8};
        QuickSort.tailRecursiveQuickSort(arr);
        Assertions.assertArrayEquals(result, arr);
    }
}