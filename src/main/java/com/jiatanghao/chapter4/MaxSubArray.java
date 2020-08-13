package com.jiatanghao.chapter4;

public class MaxSubArray {
    public static SubBody solve(int[] array) {
        int sum = 0;
        int current_sum = 0;
        int start = 0;
        int current_start = 0;
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            current_sum += array[i];
            if (current_sum < 0) {
                current_sum = 0;
                current_start = i + 1;
            } else if (current_sum > sum) {
                sum = current_sum;
                start = current_start;
                end = i;
            }
        }
        return new SubBody(start, end, sum);
    }
}
