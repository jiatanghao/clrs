package com.jiatanghao.chapter7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void quickSort() {
        int[] arr = {2, 8, 7, 1, 3, 5, 6, 4};
        int[] result = {1, 2, 3, 4, 5, 6, 7, 8};
        QuickSort.quickSort(arr);
        Assertions.assertArrayEquals(result, arr);
    }
}