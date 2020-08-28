package DFS;

/**
 * 把二叉搜索树转为累加树
 * 反向中序遍历
 */
public class leetcode538 {
    private int sum = 0;//存储右边的和

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
