package com.jiatanghao.chapter8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountSortTest {

    @Test
    void countSort() {
        int[] arr = {2, 5, 3, 0, 2, 3, 0, 3};
        int[] result = {0, 0, 2, 2, 3, 3, 3, 5};
        CountSort.countSort(arr, 5);
        Assertions.assertArrayEquals(result, arr);
    }
}