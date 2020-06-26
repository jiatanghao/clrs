package com.jiatanghao.chapter2;

import java.util.Arrays;

public class BasicAlgorithm {
    /**
     * 插入排序
     * @param array 待排序的数组
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    /**
     * 线性查找算法
     * @param array 待查找的数组
     * @param key 待查找的值
     * @return 所在的第一个索引
     */
    public static int linearSearch(int[] array, int key) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (key == array[i]) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 两个二进制正整数的加法
     * @param a 加数
     * @param b 被加数
     * @return 和
     */
    public static int[] binaryAdd(int[] a, int[] b) {
        if (a.length < b.length) {
            return binaryAdd(b, a);
        }
        int[] result = new int[a.length + 1];
        int carry = 0;
        for (int i = 0; i < b.length; i++) {
            int tmp = carry + a[a.length - i - 1] + b[b.length - i - 1];
            result[result.length - i - 1] = tmp % 2;
            carry = tmp / 2;
        }
        for (int i = 0; i < a.length - b.length; i++) {
            int tmp = carry + a[a.length - b.length - i - 1];
            result[result.length - b.length - i - 1] = tmp % 2;
            carry = tmp / 2;
        }
        if (carry == 0) {
            return Arrays.copyOfRange(result, 1, result.length);
        }
        result[0] = 1;
        return result;
    }

    /**
     * 选择排序
     * @param array 待排序的数组
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }

    private static void swap(int[] array, int i, int min) {
        if (min != i) {
            int tmp = array[i];
            array[i] = array[min];
            array[min] = tmp;
        }
    }
}
