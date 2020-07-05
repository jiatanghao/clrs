package com.jiatanghao.chapter4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideAndConquerTest {

    @Test
    void findMaxSubArray() {
        int[] array = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        System.out.println();
        DivideAndConquer.SubBody expected = new DivideAndConquer.SubBody(7, 10, 43);
        DivideAndConquer.SubBody actual = DivideAndConquer.findMaxSubArray(array);
        System.out.println(expected.hashCode());
        assertEquals(actual, expected);
    }
}