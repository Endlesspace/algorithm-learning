package 双指针;

import java.util.Arrays;

/**
 * 长度最小的子数组
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */
public class leetcode209 {
    //前缀和+二分查找
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;//目标不在数组中但在范围内，返回负的插入索引值（从1开始），反向求边界
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    /**双指针法
     * public int minSubArrayLen(int s, int[] nums) {
     *         int n = nums.length;
     *         if (n == 0) {
     *             return 0;
     *         }
     *         int ans = Integer.MAX_VALUE;
     *         int start = 0, end = 0;
     *         int sum = 0;
     *         while (end < n) {
     *             sum += nums[end];
     *             while (sum >= s) {     注意这里，等和小于s的时候再end++
     *                 ans = Math.min(ans, end - start + 1);
     *                 sum -= nums[start];
     *                 start++;
     *             }
     *             end++;
     *         }
     *         return ans == Integer.MAX_VALUE ? 0 : ans;
     *     }
     *
     */


}
