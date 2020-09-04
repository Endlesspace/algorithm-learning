package 树;

/**
 * 二叉树的所有路径。可以用回溯，递归或者迭代
 */
import java.util.*;
public class leetcode257 {
    //回溯
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret =new LinkedList<>();
        if(root==null)return ret;
        List<Integer> temp =new LinkedList<>();
        backtrack(root,temp,ret);
        return ret;

    }
    public void backtrack(TreeNode root,List<Integer> temp,List<String> ret){
        if(root==null)return;
        if(root.left==null&&root.right==null){
            temp.add(root.val);
            ret.add(transform(temp));
            temp.remove(temp.size()-1);
            return;
        }
        temp.add(root.val);
        backtrack(root.left,temp,ret);
        backtrack(root.right,temp,ret);
        temp.remove(temp.size()-1);
    }
    public String transform(List<Integer> list){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<list.size();i++){
            if(i!=list.size()-1){
                sb.append(list.get(i));
                sb.append("->");
            }else sb.append(list.get(i));
        }
        return sb.toString();
    }
}
/**
 * 迭代
 * class Solution {
 *     public List<String> binaryTreePaths(TreeNode root) {
 *         List<String> paths = new ArrayList<String>();
 *         if (root == null) {
 *             return paths;
 *         }
 *         Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
 *         Queue<String> pathQueue = new LinkedList<String>();
 *
 *         nodeQueue.offer(root);
 *         pathQueue.offer(Integer.toString(root.val));
 *
 *         while (!nodeQueue.isEmpty()) {
 *             TreeNode node = nodeQueue.poll();
 *             String path = pathQueue.poll();
 *
 *             if (node.left == null && node.right == null) {
 *                 paths.add(path);
 *             } else {
 *                 if (node.left != null) {
 *                     nodeQueue.offer(node.left);
 *                     pathQueue.offer(new StringBuffer(path).append("->").append(node.left.val).toString());
 *                 }
 *
 *                 if (node.right != null) {
 *                     nodeQueue.offer(node.right);
 *                     pathQueue.offer(new StringBuffer(path).append("->").append(node.right.val).toString());
 *                 }
 *             }
 *         }
 *         return paths;
 *     }
 * }
 *

 */
