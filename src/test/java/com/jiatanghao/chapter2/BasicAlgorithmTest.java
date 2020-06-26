package com.jiatanghao.chapter2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasicAlgorithmTest {

    private final int[] array = {5, 2, 4, 6, 1, 3};

    @Test
    void insertSort() {
        BasicAlgorithm.insertSort(array);
        Assertions.assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6}, array);
    }

    @Test
    void linearSearch() {
        Assertions.assertEquals(0, BasicAlgorithm.linearSearch(array, 5));
        Assertions.assertEquals(1, BasicAlgorithm.linearSearch(array, 2));
        Assertions.assertEquals(2, BasicAlgorithm.linearSearch(array, 4));
        Assertions.assertEquals(3, BasicAlgorithm.linearSearch(array, 6));
        Assertions.assertEquals(4, BasicAlgorithm.linearSearch(array, 1));
        Assertions.assertEquals(5, BasicAlgorithm.linearSearch(array, 3));
        Assertions.assertEquals(-1, BasicAlgorithm.linearSearch(array, 7));
    }

    @Test
    void binaryAdd() {
        int[] a = {1, 0, 1, 1};
        int[] b = {1, 1};
        int[] c = {1, 1, 1};
        Assertions.assertArrayEquals(new int[] {1, 1, 1, 0}, BasicAlgorithm.binaryAdd(a, b));
        Assertions.assertArrayEquals(new int[] {1, 0, 0, 1, 0}, BasicAlgorithm.binaryAdd(a, c));
        Assertions.assertArrayEquals(new int[] {1, 0, 0, 1, 0}, BasicAlgorithm.binaryAdd(c, a));
    }
}