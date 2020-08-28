package 动态规划;

/**
 * 最长有效括号长度
 */
public class leetcode32 {

}

//栈储存坐标解法，先压一个-1.遇到做扩括号就压入，遇到右括号先弹出，如果为空就把这个右括号的坐标压入。不为空就计算当前索引和栈顶元素之间的差值
//    public int longestValidParentheses(String s) {
//        int maxans = 0;
//        Stack<Integer> stack = new Stack<>();
//        stack.push(-1);
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                stack.push(i);
//            } else {
//                stack.pop();
//                if (stack.empty()) {
//                    stack.push(i);
//                } else {
//                    maxans = Math.max(maxans, i - stack.peek());
//                }
//            }
//        }
//        return maxans;
//    }






//用左右两个计数器计数，左右括号数相等时计算最大长度，如果右括号数大于左括号数，就把计数器置零。从两边分别遍历一次
//public int longestValidParentheses(String s) {
//    int left = 0, right = 0, maxlength = 0;
//    for (int i = 0; i < s.length(); i++) {
//        if (s.charAt(i) == '(') {
//            left++;
//        } else {
//            right++;
//        }
//        if (left == right) {
//            maxlength = Math.max(maxlength, 2 * right);
//        } else if (right > left) {
//            left = right = 0;
//        }
//    }
//    left = right = 0;
//    for (int i = s.length() - 1; i >= 0; i--) {
//        if (s.charAt(i) == '(') {
//            left++;
//        } else {
//            right++;
//        }
//        if (left == right) {
//            maxlength = Math.max(maxlength, 2 * left);
//        } else if (left > right) {
//            left = right = 0;
//        }
//    }
//    return maxlength;
//}


