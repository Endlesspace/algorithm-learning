package 排序;

import java.util.Random;

/**
 * 数组中第k大的数
 */
public class leetcode215 {
    /**
     * 使用快排的思想解决，只要找到一个分界点是数组的倒数第k个，则返回这个索引的数。
     */
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;//随机选一个数作为pivot
        swap(a, i, r);//把pivot和最右边的数交换，然后进行分治
        return partition(a, l, r);
    }
    //找pivot的另一种方法！！
    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
