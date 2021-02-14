package com.jiatanghao.chapter4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplexTest {

    @Test
    void multiply() {
        Complex c1 = new Complex(1.0, 2.0);
        Complex c2 = new Complex(2.0, 3.0);
        Complex result = new Complex(-4.0, 7.0);
        Assertions.assertEquals(result, c1.multiply(c2));
    }
}