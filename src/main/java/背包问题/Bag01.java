package 背包问题;

import java.util.Scanner;

public class Bag01 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        int[][] bag=new int[n+1][2];
//        for(int i=1;i<=n;i++){
//            bag[i][0]=sc.nextInt();
//            bag[i][1]=sc.nextInt();
//
//        }
        bag=new int[][]{{0,0},{1,2},{2,4},{3,4},{4,5}};
        //dp矩阵
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                //不拿，则可以用前i-1个中选，空间为j
                dp[i][j]=dp[i-1][j];
                //拿，选前i-1个时的背包空间减小，但价值增加
                if(j>=bag[i][0]){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-bag[i][0]]+bag[i][1]);
                }
            }
        }
        //
        System.out.println(dp[n][m]);

    }
}
