package 动态规划;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
/**
 * 递归解法超时,思考如何剪枝
 * class Solution {
 *     boolean flag=false;
 *     public boolean wordBreak(String s, List<String> wordDict) {
 *         Collections.sort(wordDict);
 *         Collections.reverse(wordDict);
 *         help(s,wordDict);
 *         return flag;
 *     }
 *     public void help(String now,List<String> wordDict){
 *         if(flag==true)return;
 *         if(now.length()==0){flag=true;return;}
 *         for(int i=0;i<wordDict.size();i++){
 *             String t=wordDict.get(i);
 *             if(now.length()<t.length())continue;
 *             if(now.substring(0,t.length()).equals(t)){
 *                 help(now.substring(t.length()),wordDict);
 *             }
 *         }
 *         return;
 *     }
 * }
 */
