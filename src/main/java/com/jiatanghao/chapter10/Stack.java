package com.jiatanghao.chapter10;

public class Stack {

    private int[] data;

    private int top;

    private static final int[] EMPTY_DATA = {};

    public Stack() {
        top = -1;
        data = EMPTY_DATA;
    }

    public Stack(int size) {
        if (size < 0) {
            throw new IllegalArgumentException();
        }
        top = -1;
        if (size == 0) {
            data = EMPTY_DATA;
        } else {
            data = new int[size];
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int x) {
        grow();
        data[++top] = x;
    }

    public int pop() {
        int result = top();
        top--;
        return result;
    }

    public int top() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[top];
    }

    public int size() {
        return top + 1;
    }

    private void grow() {
        if (top == data.length - 1) {
            int[] newData = new int[data.length * 2 + 1];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }
}
