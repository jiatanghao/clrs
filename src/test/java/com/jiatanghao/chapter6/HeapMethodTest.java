package com.jiatanghao.chapter6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HeapMethodTest {

    @Test
    void parent() {
        Assertions.assertEquals(0, HeapMethod.parent(0));
        Assertions.assertEquals(0, HeapMethod.parent(1));
        Assertions.assertEquals(0, HeapMethod.parent(2));
    }

    @Test
    void left() {
        Assertions.assertEquals(1, HeapMethod.left(0));
    }

    @Test
    void right() {
        Assertions.assertEquals(2, HeapMethod.right(0));
    }

    @Test
    void maxHeapify() {
        int[] array = new int[] {1, 2, 3};
        int[] array2 = new int[] {3, 2, 1};
        HeapMethod.maxHeapify(array, 0, 3);
        Assertions.assertArrayEquals(array, array2);
    }

    @Test
    void buildMaxHeap() {
        int[] array = new int[] {1, 2, 3};
        int[] array2 = new int[] {3, 2, 1};
        HeapMethod.buildMaxHeap(array);
        Assertions.assertArrayEquals(array, array2);
    }

    @Test
    void heapSort() {
        int[] array = new int[] {1, 3, 4, 2, 5};
        int[] array2 = new int[] {1, 2, 3, 4, 5};
        HeapMethod.heapSort(array);
        Assertions.assertArrayEquals(array2, array);
    }
}