package com.jiatanghao.chapter2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicAlgorithmTest {

    private final int[] sortedArray = {1, 2, 3, 4, 5, 6};

    @Test
    void insertSort() {
        final int[] array = {5, 2, 4, 6, 1, 3};
        BasicAlgorithm.insertSort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void linearSearch() {
        final int[] array = {5, 2, 4, 6, 1, 3};
        assertEquals(0, BasicAlgorithm.linearSearch(array, 5));
        assertEquals(1, BasicAlgorithm.linearSearch(array, 2));
        assertEquals(2, BasicAlgorithm.linearSearch(array, 4));
        assertEquals(3, BasicAlgorithm.linearSearch(array, 6));
        assertEquals(4, BasicAlgorithm.linearSearch(array, 1));
        assertEquals(5, BasicAlgorithm.linearSearch(array, 3));
        assertEquals(-1, BasicAlgorithm.linearSearch(array, 7));
    }

    @Test
    void binaryAdd() {
        int[] a = {1, 0, 1, 1};
        int[] b = {0, 0, 1, 1};
        int[] c = {0, 1, 1, 1};
        int[] d = {1};
        assertArrayEquals(new int[]{0, 1, 1, 1, 0}, BasicAlgorithm.binaryAdd(a, b));
        assertArrayEquals(new int[]{1, 0, 0, 1, 0}, BasicAlgorithm.binaryAdd(a, c));
        assertArrayEquals(new int[]{1, 0, 0, 1, 0}, BasicAlgorithm.binaryAdd(c, a));
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> BasicAlgorithm.binaryAdd(a, d), "数组长度不一致");
        assertEquals("数组长度不一致", exception.getMessage());
    }

    @Test
    void selectSort() {
        final int[] array = {5, 2, 4, 6, 1, 3};
        BasicAlgorithm.selectSort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void mergeSort() {
        final int[] array = {5, 2, 4, 6, 1, 3};
        BasicAlgorithm.mergeSort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void mergeSortWithoutSentry() {
        final int[] array = {5, 2, 4, 6, 1, 3};
        BasicAlgorithm.mergeSortWithoutSentry(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void insertSortRecursively() {
        final int[] array = {5, 2, 4, 6, 1, 3};
        BasicAlgorithm.insertSortRecursively(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void binarySearch() {
        final int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        assertEquals(0, BasicAlgorithm.binarySearch(array, 1));
        assertEquals(1, BasicAlgorithm.binarySearch(array, 2));
        assertEquals(2, BasicAlgorithm.binarySearch(array, 3));
        assertEquals(3, BasicAlgorithm.binarySearch(array, 4));
        assertEquals(4, BasicAlgorithm.binarySearch(array, 5));
        assertEquals(5, BasicAlgorithm.binarySearch(array, 6));
        assertEquals(6, BasicAlgorithm.binarySearch(array, 7));
        assertEquals(7, BasicAlgorithm.binarySearch(array, 8));
        assertEquals(-1, BasicAlgorithm.linearSearch(array, 9));
    }

    @Test
    void inversion() {
        final int[] array = {5, 2, 4, 6, 1, 3};
        assertEquals(7, BasicAlgorithm.inversion(array, 0, 5));
    }

    @Test
    void bubbleSort() {
        final int[] array = {5, 2, 4, 6, 1, 3};
        BasicAlgorithm.bubbleSort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void hasTwoSumInArray() {
        final int[] array = {5, 2, 4, 6, 1, 3};
        assertFalse(BasicAlgorithm.hasTwoSumInArray(array, 2));
        assertTrue(BasicAlgorithm.hasTwoSumInArray(array, 3));
        assertTrue(BasicAlgorithm.hasTwoSumInArray(array, 4));
        assertTrue(BasicAlgorithm.hasTwoSumInArray(array, 5));
        assertTrue(BasicAlgorithm.hasTwoSumInArray(array, 6));
        assertTrue(BasicAlgorithm.hasTwoSumInArray(array, 7));
        assertTrue(BasicAlgorithm.hasTwoSumInArray(array, 8));
        assertTrue(BasicAlgorithm.hasTwoSumInArray(array, 9));
        assertTrue(BasicAlgorithm.hasTwoSumInArray(array, 10));
        assertTrue(BasicAlgorithm.hasTwoSumInArray(array, 11));
        assertFalse(BasicAlgorithm.hasTwoSumInArray(array, 12));
    }

    @Test
    void reversedOrderedCount() {
        final int[] array = {5, 2, 4, 6, 1, 3};
        assertEquals(9, BasicAlgorithm.reversedOrderedCount(array));
    }
}