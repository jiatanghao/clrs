package com.jiatanghao.chapter6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class PriorityQueueTest {

    @Test
    public void test() {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.insert(10);
        priorityQueue.insert(20);
        priorityQueue.insert(15);
        Assertions.assertEquals(20, priorityQueue.maximum());
        Assertions.assertEquals(20, priorityQueue.extractMax());
        priorityQueue.increaseKey(0, -10);
        priorityQueue.increaseKey(0, 30);
        Assertions.assertEquals(30, priorityQueue.maximum());
    }

}