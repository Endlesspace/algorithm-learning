package 回溯;

import java.util.*;
class leetcode93 {
    List<String> ret =new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs("",s,0);
        return ret;

    }
    public void dfs(String cur,String remain,int n){
        if(n==4&&remain.length()!=0)return;
//        if(remain.length()>(4-n)*3)return;
        if(n==4&&remain.length()==0){
            StringBuilder sb=new StringBuilder(cur);
            sb.delete(cur.length()-1,cur.length());
            ret.add(sb.toString());
            return;
        }
        //0是特殊情况，只能单独出现。
        if(remain.length()>0&&remain.charAt(0)=='0'){
            dfs(cur+"0"+'.',remain.substring(1),n+1);
        }
        //normal
        int addr=0;
        //遍历剩下的字符串
        for(int i=0;i<remain.length();i++){
            addr=addr*10+remain.charAt(i)-'0';
            //判断是否合法，不合法退出循环，合法就继续回溯
            if(addr>0&&addr<=0xFF){
                dfs(cur+remain.substring(0,i+1)+".",remain.substring(i+1),n+1);
            }else break;
        }

    }

    public static void main(String[] args) {
        System.out.println(new leetcode93().restoreIpAddresses("25525511135"));
    }
}
/**
 * 更优解法：不用字符串，用下标
 * class Solution {
 *     static final int SEG_COUNT = 4;
 *     List<String> ans = new ArrayList<String>();
 *     int[] segments = new int[SEG_COUNT];
 *
 *     public List<String> restoreIpAddresses(String s) {
 *         segments = new int[SEG_COUNT];
 *         dfs(s, 0, 0);
 *         return ans;
 *     }
 *
 *     public void dfs(String s, int segId, int segStart) {
 *         // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
 *         if (segId == SEG_COUNT) {
 *             if (segStart == s.length()) {
 *                 StringBuffer ipAddr = new StringBuffer();
 *                 for (int i = 0; i < SEG_COUNT; ++i) {
 *                     ipAddr.append(segments[i]);
 *                     if (i != SEG_COUNT - 1) {
 *                         ipAddr.append('.');
 *                     }
 *                 }
 *                 ans.add(ipAddr.toString());
 *             }
 *             return;
 *         }
 *
 *         // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
 *         if (segStart == s.length()) {
 *             return;
 *         }
 *
 *         // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
 *         if (s.charAt(segStart) == '0') {
 *             segments[segId] = 0;
 *             dfs(s, segId + 1, segStart + 1);
 *         }
 *
 *         // 一般情况，枚举每一种可能性并递归
 *         int addr = 0;
 *         for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
 *             addr = addr * 10 + (s.charAt(segEnd) - '0');
 *             if (addr > 0 && addr <= 0xFF) {
 *                 segments[segId] = addr;
 *                 dfs(s, segId + 1, segEnd + 1);
 *             } else {
 *                 break;
 *             }
 *         }
 *     }
 * }
 *
 */
