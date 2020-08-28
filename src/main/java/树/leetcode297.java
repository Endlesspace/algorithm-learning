package 树;

import java.util.*;


/**
 * 二叉树的序列化与反序列化
 */
public class leetcode297 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    // Encodes a tree to a single string.
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res=mySeri(root,new StringBuilder());
        return res.toString();
    }

    StringBuilder mySeri(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("null,");
            return sb;
        }
        else if(root!=null){
            sb.append(root.val);
            sb.append(",");

            mySeri(root.left,sb);
            mySeri(root.right,sb);
        }
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String []temp=data.split(","); // 将序列化的结果转为字符串数组
        List<String> list=new LinkedList<>(Arrays.asList(temp)); // 字符串数组转为集合类 便于操作
        return myDeSeri(list);
    }
    public TreeNode myDeSeri(List<String> list){
        TreeNode root;
        if(list.get(0).equals("null")){
            list.remove(0); // 删除第一个元素 则第二个元素成为新的首部 便于递归
            return null;
        }
        else{
            root=new TreeNode(Integer.valueOf(list.get(0)));
            list.remove(0);
            root.left=myDeSeri(list);
            root.right=myDeSeri(list);
        }
        return root;
    }

    public static void main(String[] args) {
        leetcode297 cur=new leetcode297();
        TreeNode n1=cur.new TreeNode(1);
        n1.left=cur.new TreeNode(2);
        TreeNode n3 =cur.new TreeNode(3);
        n3.left=cur.new TreeNode(4);
        n3.right=cur.new TreeNode(5);
        n1.right=n3;
        System.out.println(cur.serialize(n1));
        TreeNode test=cur.deserialize(cur.serialize(n1));
        System.out.println(cur.serialize(test));
        String []temp=cur.serialize(n1).split(",");
        List<String> list=new LinkedList<>(Arrays.asList(temp) );
        System.out.println(temp.length);
        System.out.println(list.size());
//        for(String i:list){
//            System.out.println(i);
//        }

    }

}
