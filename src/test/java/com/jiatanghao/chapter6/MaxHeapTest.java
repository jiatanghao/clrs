package com.jiatanghao.chapter6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class MaxHeapTest {

    @Test
    void getElementData() {
        List<Integer> list = Arrays.asList(2, 5, 1, 3, 6, 4);
        List<Integer> result = List.of(1, 2, 3, 4, 5, 6);
        final MaxHeap<Integer> maxHeap = new MaxHeap<>(list);
        Assertions.assertEquals(result, maxHeap.getElementData());
    }
}