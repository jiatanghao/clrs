package com.jiatanghao.chapter2;

import java.util.Arrays;

public class BasicAlgorithm {
    /**
     * 插入排序
     * 使用二分查找优化了部分效率，但实际复杂度仍为O(n^2)
     *
     * @param array 待排序的数组
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertLocation = binarySearchForInsertSort(array, i - 1, array[i]);
            if (insertLocation != i) {
                int current = array[i];
                System.arraycopy(array, insertLocation, array, insertLocation + 1, i - insertLocation);
                array[insertLocation] = current;
            }
        }
    }

    private static int binarySearchForInsertSort(int[] array, int hi, int key) {
        int left = 0, right = hi;
        if (array[right] < key) {
            return right + 1;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 线性查找算法
     *
     * @param array 待查找的数组
     * @param key   待查找的值
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
     *
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
     *
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

    private static void swap(int[] array, int i, int j) {
        if (j != i) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }

    /**
     * 对外提供的归并排序的接口
     *
     * @param array 待排序数组
     */
    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    /**
     * 对数组某一段进行归并排序
     *
     * @param array 待排序数组
     * @param p     起始点
     * @param r     结束点
     */
    private static void mergeSort(int[] array, int p, int r) {
        if (p < r) {
            int q = p + ((r - p) >> 1);
            mergeSort(array, p, q);
            mergeSort(array, q + 1, r);
            merge(array, p, q, r);
        }
    }

    /**
     * 两段归并 A[p, q] 和 A[q + 1, r]，两段已经分别排好序
     * 使用哨兵
     *
     * @param array 前后两段排好序的数组
     * @param p     起始点
     * @param q     分割点
     * @param r     结束点
     */
    private static void merge(int[] array, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];
        System.arraycopy(array, p, left, 0, n1);
        System.arraycopy(array, q + 1, right, 0, n2);
        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (left[i] < right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
        }
    }

    /**
     * 对外提供的归并排序的接口
     * 无哨兵
     *
     * @param array 待排序数组
     */
    public static void mergeSortWithoutSentry(int[] array) {
        mergeSortWithoutSentry(array, 0, array.length - 1);
    }

    /**
     * 对数组某一段进行归并排序
     * 无哨兵
     *
     * @param array 待排序数组
     * @param p     起始点
     * @param r     结束点
     */
    private static void mergeSortWithoutSentry(int[] array, int p, int r) {
        if (p < r) {
            int q = p + ((r - p) >> 1);
            mergeSortWithoutSentry(array, p, q);
            mergeSortWithoutSentry(array, q + 1, r);
            mergeWithoutSentry(array, p, q, r);
        }
    }

    /**
     * 两段归并 A[p, q] 和 A[q + 1, r]，两段已经分别排好序
     * 不使用哨兵
     *
     * @param array 前后两段排好序的数组
     * @param p     起始点
     * @param q     分割点
     * @param r     结束点
     */
    private static void mergeWithoutSentry(int[] array, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] left = new int[n1];
        int[] right = new int[n2];
        System.arraycopy(array, p, left, 0, n1);
        System.arraycopy(array, q + 1, right, 0, n2);
        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (i < n1 && j < n2) {
                if (left[i] < right[j]) {
                    array[k] = left[i];
                    i++;
                } else {
                    array[k] = right[j];
                    j++;
                }
            } else if (i == n1) {
                System.arraycopy(right, j, array, k, n2 - j);
                break;
            } else if (j == n2) {
                System.arraycopy(left, i, array, k, n1 - i);
                break;
            }
        }
    }

    private static void insertSortRecursively(int[] array, int n) {
        if (n > 1) {
            insertSortRecursively(array, n - 1);
            int key = array[n - 1];
            int index = n - 2;
            while (index >= 0 && key < array[index]) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = key;
        }
    }

    /**
     * 插入排序递归版
     *
     * @param array 待排序的数组
     */
    public static void insertSortRecursively(int[] array) {
        insertSortRecursively(array, array.length);
    }

    /**
     * 二分查找
     *
     * @param array 要查找的数组
     * @param key   要找到的值
     * @return 值所在的索引
     */
    public static int binarySearch(int[] array, int key) {
        int lo = 0, hi = array.length - 1;
        int result = -1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (array[mid] == key) {
                result = mid;
                break;
            } else if (array[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return result;
    }

    /**
     * 冒泡排序
     *
     * @param array 待排序数组
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                }
            }
        }
    }

    /**
     * 查找数组中是否有两个数之和等给定值
     *
     * @param array 待查找的数组
     * @param x     给定值
     * @return 是否找到
     */
    public static boolean hasTwoSumInArray(int[] array, int x) {
        mergeSort(array);
        for (int i = 0; i < array.length; i++) {
            int find = binarySearch(array, x - array[i]);
            if (find > -1 && find != i) {
                return true;
            }
        }
        return false;
    }

    /**
     * 使用归并思想求逆序对
     *
     * @param array 待求的数组
     * @return 逆序对个数
     */
    public static int reversedOrderedCount(int[] array) {
        int length = array.length;
        int[] copy = new int[length];
        System.arraycopy(array, 0, copy, 0, length);
        return reversedOrderedCount(array, copy, 0, length - 1);
    }

    private static int reversedOrderedCount(int[] array, int[] copy, int begin, int end) {
        if (begin == end)
            return 0;
        int mid = begin + ((end - begin) >> 1);
        // 递归调用
        int left = reversedOrderedCount(copy, array, begin, mid);
        int right = reversedOrderedCount(copy, array, mid + 1, end);
        // 归并
        int i = mid, j = end, pos = end;
        int count = 0;
        while (i >= begin && j >= mid + 1) {
            if (array[i] > array[j]) {
                copy[pos--] = array[i--];
                count += j - mid;
            } else {
                copy[pos--] = array[j--];
            }
        }
        while (i >= begin) {
            copy[pos--] = array[i--];
        }
        while (j >= mid + 1) {
            copy[pos--] = array[j--];
        }
        return left + right + count;
    }
}
