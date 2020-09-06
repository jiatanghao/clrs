package com.jiatanghao.chapter6;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
    private final List<Integer> list = new ArrayList<>();
    private int maximum = -1;

    public void insert(int data) {
        if (maximum < 0) {
            maximum = 0;
        }
        if (data > list.get(maximum)) {
            maximum = list.size();
        }
        list.add(data);
    }

    public int maximum() {
        return maximum;
    }

    public int extractMax() {
        int result = list.remove(maximum);
        int newMax = Integer.MIN_VALUE;
        for (int data : list) {
            if (data > newMax) {
                newMax = data;
            }
        }
        maximum = newMax;
        return result;
    }

    public void increaseKey(int index, int k) {
        if (k < list.get(index)) {
            return;
        }
        if (k > list.get(maximum)) {
            maximum = index;
        }
        list.set(index, k);
    }
}
