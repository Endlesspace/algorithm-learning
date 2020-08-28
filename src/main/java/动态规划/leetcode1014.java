package 动态规划;

/**
 * 最佳观光组合
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 */
public class leetcode1014 {
    class Solution {
        public int maxScoreSightseeingPair(int[] A) {
            int ans = 0, mx = A[0] + 0;
            for (int j = 1; j < A.length; ++j) {
                ans = Math.max(ans, mx + A[j] - j);
                // 边遍历边维护
                mx = Math.max(mx, A[j] + j);
            }
            return ans;
        }
    }

}
