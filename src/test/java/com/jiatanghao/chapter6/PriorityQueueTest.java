package com.jiatanghao.chapter6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PriorityQueueTest {

    @Test
    void test() {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.insert(10);
        priorityQueue.insert(20);
        priorityQueue.insert(15);
        assertEquals(20, priorityQueue.maximum());
        assertEquals(20, priorityQueue.extractMax());
        priorityQueue.increaseKey(0, -10);
        priorityQueue.increaseKey(0, 30);
        assertEquals(30, priorityQueue.maximum());
    }

}