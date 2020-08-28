package 动态规划;

/**
 * 交错字符串 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的
 * dp[i][j]表示s1前i个和s2前j个字符能否交叉组成s3的前i+j个元素
 */
public class leetcode97 {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length()!=(s1.length()+s2.length()))return false;
        boolean[][] dp =new boolean[s1.length()+1][s2.length()+1];
        dp[0][0]=true;
        for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                int p =i+j-1;
                if(i>0){
                    dp[i][j]=dp[i][j]||(dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(p));//两种情况，第一种是s1的第i-1个等于s3的i+j-1个字符
                }
                if(j>0){
                    dp[i][j]=dp[i][j]||(dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(p));//第儿种是s2的第j-1个等于s3的i+j-1个字符
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
