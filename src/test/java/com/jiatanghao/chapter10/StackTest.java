package com.jiatanghao.chapter10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StackTest {

    @Test
    void test_stack_operation() {
        Stack stack = new Stack();
        Assertions.assertTrue(stack.isEmpty());
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Stack(-1));
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, stack::pop);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, stack::top);
        Assertions.assertEquals(0, stack.size());
        stack.push(1);
        Assertions.assertEquals(1, stack.top());
        Assertions.assertEquals(1, stack.size());
        stack.push(2);
        Assertions.assertEquals(2, stack.top());
        Assertions.assertEquals(2, stack.size());
        int res = stack.pop();
        Assertions.assertEquals(2, res);
        Assertions.assertEquals(1, stack.top());
        Assertions.assertEquals(1, stack.size());
        Stack stack1 = new Stack(0);
        Assertions.assertEquals(0, stack1.size());
        Stack stack2 = new Stack(2);
        Assertions.assertEquals(0, stack2.size());
    }

}