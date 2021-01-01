package com.jiatanghao.chapter4;

public class MaxSubArray {

    private MaxSubArray() {
    }
    public static SubBody solve(int[] array) {
        int sum = 0;
        int currentSum = 0;
        int start = 0;
        int currentStart = 0;
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            currentSum += array[i];
            if (currentSum < 0) {
                currentSum = 0;
                currentStart = i + 1;
            } else if (currentSum > sum) {
                sum = currentSum;
                start = currentStart;
                end = i;
            }
        }
        return new SubBody(start, end, sum);
    }
}
