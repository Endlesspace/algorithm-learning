package 树;


/**
 * 二叉树中的列表，查看二叉树中是否存在一个链表序列
 */
public class leetcode1255 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head==null)return true;
        if(root==null)return false;
        return dfs(head,root)||isSubPath(head,root.left)||isSubPath(head,root.right);

    }
    //注意这个函数，需要这个函数来判断当前层是否满足要求。如果把if(head.val!=root.val)写在isSubPath中，会导致不连续的序列也被判断为真。
    //比如1，2，3，4，5 用1，2，4，5匹配也会返回真
    public boolean dfs(ListNode head, TreeNode root){
        if(head==null)return true;
        if(root==null)return false;
        if(head.val!=root.val)return false;
        return dfs(head.next,root.left)||dfs(head.next,root.right);

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}




