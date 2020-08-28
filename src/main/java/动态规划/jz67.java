package 动态规划;

/**
 * 剪绳子
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class jz67 {
    public int cutRope(int target) {
        if(target<=1)return 0;
        int[] dp=new int[target+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        dp[4]=4;
        if(target<=4)return target;
        for(int i=5;i<=target;i++){
            int ret=0;
            for(int j=1;j<i;j++){
                ret=Math.max(j*dp[i-j],ret);
            }
            dp[i]=ret;
        }
        return dp[target];

    }
}
