package 动态规划;

/**
 * 整数拆分
 * 至少分两个数。把i分为j和i-j，固定j，其中的i-j可以分，也可以不分。比较这两者，选择较大的存入dp数组。
 */
public class leetcode343 {
    public int integerBreak(int n) {
        int[] dp =new int[n+1];
        if(n<4)return n-1;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            for(int j=1;j<i;j++){
                dp[i]=Math.max(dp[i],j*(Math.max(i-j,dp[i-j])));

            }
        }
        return dp[n];
    }
}
