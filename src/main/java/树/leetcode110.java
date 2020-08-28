package 树;

/**
 * 平衡二叉树，自底向上的递归，复杂度o（n），不用重复计算子树的高度
 * 类似后序遍历
 */
public class leetcode110 {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) { //子树平衡返回0，不平衡返回-1
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        //任意子树不平衡返回-1，否则返回子树的最大高度+1
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }


}
