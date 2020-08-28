package 动态规划;

import java.util.ArrayList;
import java.util.Collections;

//数字转为字符串的可能
/*
*示例 1:

输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class leetcode46 {
    public int translateNum(int num) {
        if(num<0)return 0;
        if(num<10)return 1;
        ArrayList<Integer> arr=new ArrayList<>();
        while(num>0){
            int t=num%10;
            arr.add(t);
            num=num/10;
        }
        Collections.reverse(arr);
        int[] dp=new int[arr.size()+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<arr.size()+1;i++){
            if(arr.get(i-2)!=0&&arr.get(i-2)*10+arr.get(i-1)<=25){
                dp[i]=dp[i-1]+dp[i-2];
            }else{
                dp[i]=dp[i-1];
            }
        }
        return dp[arr.size()];


    }
}
