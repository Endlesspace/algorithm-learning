package 动态规划;
//正则表达式匹配
//用 dp[i][j]dp[i][j] 表示字符串 ss 的前 ii 个字符和模式 pp 的前 jj 个字符是否能匹配
class leetcode10 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                }
                else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}

/**
 * 回溯解法
 * public boolean isMatch(String s, String p) {
 *     //如果正则串p为空字符串s也为空这匹配成功，如果正则串p为空但是s不是空则说明匹配失败
 *     if (p.isEmpty())return s.isEmpty();
 *     //判断s和p的首字符是否匹配，注意要先判断s不为空
 *     boolean headMatched=!s.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.');
 *     if (p.length()>=2&&p.charAt(1)=='*'){//如果p的第一个元素的下一个元素是*
 *         //则分别对两种情况进行判断
 *         return isMatch(s,p.substring(2))||
 *             (headMatched&&isMatch(s.substring(1),p));
 *     }else if (headMatched){//否则，如果s和p的首字符相等
 *         return isMatch(s.substring(1),p.substring(1));
 *     }else {
 *         return false;
 *     }
 * }
 *
 */

