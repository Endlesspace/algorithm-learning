package 树;

public class leetcode108 {
    /**
     * 有序数组转为平衡二叉树
     */

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)return null;
        return help(nums,0,nums.length-1);
    }
    public TreeNode help(int[] nums,int l,int r){
        if(l>r)return null;
        int mid=(l+r)>>1;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=help(nums,l,mid-1);
        root.right=help(nums,mid+1,r);
        return root;
    }

}
