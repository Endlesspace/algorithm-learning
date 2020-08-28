package 树;
import 树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 中序遍历，迭代
 */
public class InorderTraversal {

    public static void inorder1(TreeNode root){
        if(root==null)return ;
        inorder1(root.left);
        System.out.printf(""+root.val);
        inorder1(root.right);
    }
    //迭代
    public  static void inorder2(TreeNode root){
        Deque<TreeNode> stack=new LinkedList<>();
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
        while(!stack.isEmpty()){
            TreeNode cur =stack.pop();
            System.out.printf(""+cur.val);
            if(cur.right!=null){
                cur=cur.right;
                while(cur!=null){
                    stack.push(cur);
                    cur=cur.left;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] list = new Integer[]{1,3,8,7,2,5,4,null,null,1,3,null,null,2,3};
        TreeNode root =CreateTree.toTree(list);
        inorder1(root);
        System.out.println("\n");
        inorder2(root);
    }
}
