package 回溯;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class leetcode124 {
    int max=Integer.MIN_VALUE;;
    public int maxPathSum(TreeNode root) {
        if(root==null)return 0;
        help(root);
        return max;

    }
    public int help(TreeNode node){
        if(node==null)return 0;
        int left =Math.max(help(node.left),0);
        int right =Math.max(help(node.right),0);
        int cost = left+right+node.val ;
        if(cost>max)max=cost;
        //关键地方，返回时加上本身，防止0比负数大破坏了max
        return node.val+Math.max(left,right);

    }
}
