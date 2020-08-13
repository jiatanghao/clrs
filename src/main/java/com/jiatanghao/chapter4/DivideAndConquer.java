package com.jiatanghao.chapter4;

public class DivideAndConquer {

    /**
     * 对外提供的查找最大子数组的方法
     * @param array 待查找的数组
     * @return 最大子数组的上下界,最大值
     */
    public static SubBody findMaxSubArray(int[] array) {
        return findMaxSubArray(array, 0, array.length - 1);
    }

    /**
     * 寻找数组指定范围内的最大子数组
     * @param array 待查找的数组
     * @param low 下界
     * @param high 上界
     * @return 最大子数组的上下界,最大值
     */
    private static SubBody findMaxSubArray(int[] array, int low, int high) {
        if (low == high) {
            return new SubBody(low, low, array[low]);
        }
        int mid = low + ((high - low) >> 1);
        SubBody leftBody = findMaxSubArray(array, low, mid);
        SubBody rightBody = findMaxSubArray(array, mid + 1, high);
        SubBody crossBody = findMaxCrossSubArray(array, low, mid, high);
        SubBody maxBody;
        if (leftBody.value > rightBody.value) {
            maxBody = leftBody;
        } else {
            maxBody = rightBody;
        }
        if (maxBody.value < crossBody.value) {
            maxBody = crossBody;
        }
        return maxBody;
    }

    /**
     * 寻找 跨过mid的子数组中和最大子数组
     * @param array 待寻找的数组
     * @param low 左边界
     * @param mid 中间分割点
     * @param high 右边界
     * @return 左边界,右边界,跨过中间点最大子数组
     */
    private static SubBody findMaxCrossSubArray(int[] array, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int leftIndex = mid;
        int sum = 0;
        for (int i = mid; i >= low; i--)  {
            sum += array[i];
            if (sum > leftSum) {
                leftSum = sum;
                leftIndex = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        int rightIndex = mid + 1;
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += array[i];
            if (sum > rightSum) {
                rightSum = sum;
                rightIndex = i;
            }
        }
        return new SubBody(leftIndex, rightIndex, leftSum + rightSum);
    }
}
