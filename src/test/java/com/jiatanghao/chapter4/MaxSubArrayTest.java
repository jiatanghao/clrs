package com.jiatanghao.chapter4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSubArrayTest {

    @Test
    void solve() {
        int[] array = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        SubBody expected = new SubBody(7, 10, 43);
        SubBody actual = MaxSubArray.solve(array);
        assertEquals(actual, expected);
    }
}