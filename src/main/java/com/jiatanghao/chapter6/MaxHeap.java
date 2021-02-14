package com.jiatanghao.chapter6;

import java.util.List;

public class MaxHeap<T extends Comparable<T>> {
    private final List<T> elementData;

    public MaxHeap(List<T> elementData) {
        this.elementData = elementData;
        heapSort();
    }

    public List<T> getElementData() {
        return elementData;
    }

    private static int left(int i) {
        return i * 2 + 1;
    }

    private static int right(int i) {
        return 2 * i + 2;
    }

    public void buildMaxHeap() {
        for (int i = elementData.size() / 2; i >= 0; i--) {
            maxHeapify(i, elementData.size());
        }
    }

    public void heapSort() {
        buildMaxHeap();
        for (int i = elementData.size() - 1; i > 0; i--) {
            swap(i, 0);
            maxHeapify(0, i);
        }
    }

    public void maxHeapify(int i, int n) {
        while (true) {
            int l = left(i);
            int r = right(i);
            int largest;
            if (l < n && elementData.get(i).compareTo(elementData.get(l)) < 0) {
                largest = l;
            } else {
                largest = i;
            }
            if (r < n && elementData.get(largest).compareTo(elementData.get(r)) < 0) {
                largest = r;
            }
            if (i == largest) {
                return;
            } else {
                swap(i, largest);
                i = largest;
            }
        }
    }

    public void swap(int i, int j) {
        if (j != i) {
            T tmp = this.elementData.get(i);
            this.elementData.set(i, this.elementData.get(j));
            this.elementData.set(j, tmp);
        }
    }
}
