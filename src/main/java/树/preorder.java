package 树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static 树.CreateTree.toTree;

//迭代的先序遍历
public class preorder {
    public List<Integer> preoderTranversal(TreeNode root){
        List<Integer> ret =new ArrayList<>();
        if(root==null) return ret;
        Deque<TreeNode> stack= new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur =stack.pop();
            ret.add(cur.val);
            if(cur.right!=null)stack.push(cur.right);//注意是push
            if(cur.left!=null)stack.push(cur.left);
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode test = toTree(new Integer[]{1,2,3,4,5});
        System.out.println(new preorder().preoderTranversal(test));
    }
}
