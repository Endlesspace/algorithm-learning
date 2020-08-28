package 排序;

import java.util.Arrays;

public class Quicksort {
    public static void partion(int[] nums, int l, int r) {
        if (l >= r) return;
        int pivot = nums[l];
        int p1 = l, p2 = r;
        while (p1 < p2) {
            while (p1 < p2 && nums[p2] >= pivot) { //注意等号
                p2--;
            }
            while (p1 < p2 && nums[p1] <= pivot) {
                p1++;
            }
            if (p1 < p2) swap(nums, p1, p2);

        }
        nums[l] = nums[p1]; //把p1的值赋给最左
        nums[p1] = pivot;//把枢纽值赋给p1指的地方
        partion(nums, l, p1 - 1);//递归调用
        partion(nums, p1 + 1, r);


    }

    public static void swap(int[] nums, int x, int y) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 4, 5, 6, 6, 7};
        partion(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
