package com.jiatanghao.chapter8;

public class CountSort {

    public static void countSort(int[] a, int k) {
        int[] c = new int[k + 1];
        for (int i = 1; i < a.length; i++) {
            c[a[i]]++;
        }
        for (int i = 1; i <= k; i++) {
            c[i] += c[i - 1];
        }
        int[] b = new int[a.length];
        for (int j = a.length - 1; j >= 0; j--) {
            b[c[a[j]]] = a[j];
            c[a[j]]--;
        }
        System.arraycopy(b, 0, a, 0, a.length);
    }
}
