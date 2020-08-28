package 树;
import java.util.*;

/**
 * 创建二叉树
 */
public class CreateTree {
    public static TreeNode toTree(Integer[] nums){
        if(nums.length==0||nums[0]==null) return null;
        TreeNode head = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        int index = 1;  //当前的数组下标
        while(index<nums.length){
            TreeNode cur = queue.poll();
            if(nums[index]!=null) { //第一个节点不为null则放到左节点并入队
                TreeNode temp = new TreeNode(nums[index]);
                cur.left = temp;
                queue.offer(temp);
            }
            if(index++>=nums.length) break;
            if(index < nums.length && nums[index]!=null) {
                TreeNode temp = new TreeNode(nums[index]);
                cur.right = temp;
                queue.offer(temp);
            }
            index++;
        }
        return head;
    }
}
