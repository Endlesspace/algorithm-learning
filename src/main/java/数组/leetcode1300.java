package 数组;
//给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
//
//        如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
//
//        请注意，答案不一定是 arr 中的数字。

public class leetcode1300 {
    public int findBestValue(int[] arr, int target) {

        int sum = 0;
        int bigElement = arr[0];
        //初始化求和数,和最大元素值
        for (int i : arr) {
            sum += i;
            if (bigElement < i) {
                bigElement = i;
            }
        }
        //如果总和比目标值小,直接返回元素最大值
        if (sum <= target) {
            return bigElement;
        }

        int value = target / arr.length;
        //sum = value; 原来这里有,不知道有啥用,删除不影响
        while (true) { //从平分后的目标值起手
            //一次算两个相邻的值
            int next_sum = getSum(arr, value + 1);
            sum = getSum(arr, value);
            //判断何时结束循环,如果目标值target在sum和next_sum之中,就...
            if (next_sum > target && sum <= target) {
                if(next_sum - target < target - sum){ //还是不要用内部的math方法了
                    value++;
                }
                break;
            }
            value++;
        }
        return value;
    }
    //求和方法,比value小的原封不动加,比value大的按照value加
    public int getSum(int[] arr, int value) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > value) {
                sum += value;
            } else {
                sum += arr[i];
            }
        }
        return sum;
    }
}
