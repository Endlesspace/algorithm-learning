package 动态规划;

import java.util.List;

/**
 * 三角形最小路径和
 * 自底向上的动态规划
 * f[i][j]=min(f[i−1][j−1],f[i−1][j])+c[i][j] 转移方程
 */
public class leetcode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0)return 0;
         int n= triangle.size();
         int[][] dp=new int[n+1][n+1];
         for(int i=n-1;i>=0;i--){
             for(int j=0;j<=i;j++){
                 dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
             }
         }
         return dp[0][0];

    }
}
