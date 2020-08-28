package 动态规划;

/**
 * 最长重复子数组（公共子串）  另一个方法是滑动数组
 */
public class leetcode718 {
    public int findLength(int[] A, int[] B) {
        if(A.length==0||B.length==0)return 0;
        int ret=0;
        int[][] dp=new int[A.length+1][B.length+1];//声明二维数组，长度+1，不用单独处理初始值
        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=B.length;j++){
                if(A[i-1]==B[j-1]){ //这里要写成i-1与j-1，才能和数组对应
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=0;
                }
                if(dp[i][j]>ret)ret=dp[i][j];
            }
        }
        return ret;
    }
}
