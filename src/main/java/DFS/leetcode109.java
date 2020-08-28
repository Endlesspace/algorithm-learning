package DFS;

/**
 * 利用分治的思想递归的寻找中间节点。中间节点的寻找方法是快慢指针
 */
public class leetcode109 {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid); //区间是左闭右开，所以取到mid
        root.right = buildTree(mid.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) { //当快指针为目标点或者快指针的下一个节点是目标节点时退出
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
