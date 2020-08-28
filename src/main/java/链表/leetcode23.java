package 链表;
import java.util.*;
public class leetcode23 {
    /**
     * 合并k个有序数组。两种思想：1，用k个指针 2，两两合并
     * @param lists
     * @return
     */
    //使用小根堆优化k指针
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode node: lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;//尾节点
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = minNode;
            if (minNode.next != null) {
                pq.offer(minNode.next);//如果当前链表还有节点，则把下一个节点加入堆中。
            }
        }

        return dummyHead.next;
    }

}
