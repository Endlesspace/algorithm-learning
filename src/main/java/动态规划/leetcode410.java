package 动态规划;
import java.util.*;
public class leetcode410 {
    public int splitArray(int[] nums, int m) {
        int[][] dp=new int[nums.length+1][m+1];
        int[] sub =new int[nums.length+1];
        for(int i=0;i<=nums.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);  //让不符合条件的地方都为最大值，例如j>i 的情况
        }
        for(int i=0;i<nums.length;i++){ //求前缀和，方便计算子数组的和，注意下标和数组长度
            sub[i+1]=sub[i]+nums[i];
        }
        dp[0][0]=0; //给0，0赋值0.特殊的情况
        for(int i=1;i<=nums.length;i++){  //i和j都是从1开始
            for(int j=1;j<=m;j++){
                for(int k=0;k<i;k++){ //k的终止条件是小于i，注意理解子数组和为什么是sub[i]-sub[k]
                    dp[i][j]=Math.min(dp[i][j],(Math.max(dp[k][j-1],sub[i]-sub[k])));
                }
            }
        }
        return dp[nums.length][m];

    }
}
