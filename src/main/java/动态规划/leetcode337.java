package 动态规划;
import 树.CreateTree;
import 树.TreeNode;

import java.util.*;

/**
 * 树形dp，任何一个节点能偷到的最大钱的状态可以定义为
 *
 * 当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
 * 当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
 *
 * 也可以用记忆化的递归，用一个hashmap保存每个节点和对应能偷的最大的钱数。
 */

public class leetcode337 {
    public int rob(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robInternal(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }


    public static void main(String[] args) {
        Integer[] a ={3,2,3,null,3,null,1};
        TreeNode root = CreateTree.toTree(a);
        System.out.println(new leetcode337().rob(root));

    }
}
