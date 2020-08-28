package 树;
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

/**
 * 二叉树的下一结点 两种思路：1，还原二叉树，再中序遍历   2， 分析法，判断是否有右子树，判断是否是父亲节点的右子树
 */
public class JZ57 {
    /**
     * 分析法
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null)return null;
        if(pNode.right!=null){
            TreeLinkNode cur=pNode.right;
            if(cur.left==null)return cur;
            else{
                while(cur.left!=null)cur=cur.left;
                return cur;
            }
        }else if(pNode.next!=null){
            TreeLinkNode father = pNode.next;
            if(pNode==father.left)return father;
            else if(pNode==father.right){
                while(pNode==father.right){
                    pNode=father;
                    father=pNode.next;
                    if(father==null)return null;
                }
                return pNode.next;
            }
        }
        return null;
    }
}

//重建法 ，找到根节点，中序遍历，加入list
//        import java.util.*;
//public class Solution {
//    static ArrayList<TreeLinkNode> list = new ArrayList<>();
//    public TreeLinkNode GetNext(TreeLinkNode pNode){
//        TreeLinkNode par = pNode;
//        while(par.next != null){
//            par = par.next;
//        }
//        InOrder(par);
//        for(int i=0;i<list.size();i++){
//            if(pNode == list.get(i)){
//                return i == list.size()-1?null:list.get(i+1);
//            }
//        }
//        return null;
//    }
//    void InOrder(TreeLinkNode pNode){
//        if(pNode!=null){
//            InOrder(pNode.left);
//            list.add(pNode);
//            InOrder(pNode.right);
//        }
//    }
//}
