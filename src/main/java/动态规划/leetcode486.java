package 动态规划;

/**
 * 预测赢家。dp矩阵代表当数组剩下的部分为下标i到下标j时，当前玩家与另一玩家的分数之差的最大值。
 */
public class leetcode486 {
    public boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);//!!
            }
        }
        return dp[0][length - 1] >= 0;
    }

    public static void main(String[] args) {
        new leetcode486().PredictTheWinner(new int[]{1,5,2});
    }
}
