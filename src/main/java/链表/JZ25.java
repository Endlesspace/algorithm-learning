package 链表;
public class JZ25 {
    /**
     * 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        else if(l2==null)return l1;
        ListNode head =new ListNode(0);//虚拟头结点
        ListNode cur=head;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                cur.next=l1;
                l1=l1.next;

            }else{
                cur.next=l2;
                l2=l2.next;

            }
            cur=cur.next;
        }
        cur.next= (l1!=null)? l1:l2;  //直接把剩下的加在cur后面就行了
        return head.next;

    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
