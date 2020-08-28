package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//中序迭代遍历
public class Inoder {
    public List < Integer > inorderTraversal(TreeNode root) {
        List< Integer > res = new ArrayList< >();
        Stack< TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) { //cur!==null这个条件保证刚开始的时候不会直接跳出
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;//左边都遍历过了，找到右子树。
        }
        return res;
    }

}
