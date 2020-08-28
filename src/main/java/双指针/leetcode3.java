package 双指针;

import java.util.HashMap;
import java.util.Map;

public class leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> dict =new HashMap<>();
        int p1=0,p2=0,max=0;
        while(p2<s.length()){
            if(dict.isEmpty()){
                dict.put(s.charAt(p2),p2);
                p2++;
            }else if(dict.containsKey(s.charAt(p2))){
                int index =dict.get(s.charAt(p2));
                if(index>=p1)p1=index+1;
                dict.put(s.charAt(p2),p2);
                p2++;
            }else{
                dict.put(s.charAt(p2),p2++);
            }
            if(p2-p1>max)max=(p2-p1);
        }
        return max;
    }

    public static void main(String[] args) {
        new leetcode3().lengthOfLongestSubstring("abba");
    }
}
/**
 * 滑动窗口
 *  public int lengthOfLongestSubstring(String s) {
 *         // 哈希集合，记录每个字符是否出现过
 *         Set<Character> occ = new HashSet<Character>();
 *         int n = s.length();
 *         // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
 *         int rk = -1, ans = 0;
 *         for (int i = 0; i < n; ++i) {
 *             if (i != 0) {
 *                 // 左指针向右移动一格，移除一个字符
 *                 occ.remove(s.charAt(i - 1));
 *             }
 *             while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
 *                 // 不断地移动右指针
 *                 occ.add(s.charAt(rk + 1));
 *                 ++rk;
 *             }
 *             // 第 i 到 rk 个字符是一个极长的无重复字符子串
 *             ans = Math.max(ans, rk - i + 1);
 *         }
 *         return ans;
 *     }

 */
