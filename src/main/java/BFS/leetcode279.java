package BFS;
// 可以用动态规划或者广度优先搜索。求一个数可以分解成平方数之和的最小个数。
public class leetcode279 {
    public int numSquares(int n) {
        if(n<=0)return -1;
        int[] dp =new int[n+1];
        dp[0]=0;
        for(int i=0;i<=n;i++){
            dp[i]=i;
            for(int j=1;i-j*j>=0;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
