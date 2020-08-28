package 动态规划;

/**
 * 最小路径和
 * 注意第一行和第一列的数
 */
public class leetcode64 {
    public static int minPathSum(int[][] grid) {
        int rows=grid.length,cols=grid[0].length;
        int[][] dp=new int[rows][cols];

        dp[0][0]=grid[0][0];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i==0&&j==0)continue;//第一个数不动
                if(i==0)dp[i][j]=dp[i][j-1]+grid[i][j];
                else if(j==0) dp[i][j]=dp[i-1][j]+grid[i][j];
                else {
                    dp[i][j]=Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);

                }
            }
        }
        return dp[rows-1][cols-1];
    }

    public static void main(String[] args) {
        int[][] a  =new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(a));
    }
}
