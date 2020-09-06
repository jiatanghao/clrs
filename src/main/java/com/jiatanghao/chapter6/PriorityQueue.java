package com.jiatanghao.chapter6;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
    private final List<Integer> list = new ArrayList<>();
    private int maximum = -1;

    public void insert(int data) {
        if (maximum < 0) {
            maximum = 0;
            list.add(data);
            return;
        }
        if (data > list.get(maximum)) {
            maximum = list.size();
        }
        list.add(data);
    }

    public int maximum() {
        return list.get(maximum);
    }

    public int extractMax() {
        int result = list.remove(maximum);
        int newMax = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(newMax) < list.get(i)) {
                newMax = i;
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
