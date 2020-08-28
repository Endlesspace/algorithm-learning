package 动态规划;

import java.util.Arrays;

/**地下城游戏
 * 反向动态规划。从前往后的话，会有两个参数影响后续的决策，不满足“无后效性”，所以从终点向起点走
 * dp[i][j]代表i，j这个带你到终点的最小需要的健康值
 */
public class leetcode174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int rows=dungeon.length,cols=dungeon[0].length;
        int[][] dp=new int[rows+1][cols+1];
        for(int i=0;i<=rows;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);//其他都设置为最大整数
        }
        dp[rows][cols-1]=1;dp[rows-1][cols]=1;//把终点的右边和下边设置为1
        for(int i=rows-1;i>=0;i--){
            for(int j =cols-1;j>=0;j--){
                int min=Math.min(dp[i+1][j],dp[i][j+1]);//比较右边和下面
                dp[i][j]=Math.max(min-dungeon[i][j],1);//算上当前点的值，最小初始值为1，所以和1比较
            }
        }
        return dp[0][0];
    }
}
