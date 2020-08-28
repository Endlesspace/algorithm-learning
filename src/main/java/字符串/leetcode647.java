package 字符串;

/**
 * 回文子串数目。枚举子串还可以使用中心枚举法。枚举回文中心，然后向两边拓展。
 * 注意，回文中心要分奇偶。长度为n的字符串可以枚举出2n-1个回文中心
 */
public class leetcode647 {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;//计算长度
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;//通过回文中心的编号，计算左右边界。左边界直接为i/2，右边界为左边界加上i%2。
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {//向两边拓展，如果是回文串结果就自增。
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }
}
