package 查找;

import java.io.IOException;

public class BInarySearch {
    //标准二分
    public static int binarySearch(int[] nums,int t){
        if(nums==null||nums.length==0)return -1;
        int low=0,high=nums.length-1;
        while (low<=high){
            int mid =low+(high-low)/2;
            if(nums[mid]==t)return mid;
            else if(nums[mid]<t){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return -1;
    }
    //左边界
    public static int leftBorder(int[] nums,int t){
        if(nums==null||nums.length==0)return -1;
        int low=0,high=nums.length;
        while (low<high){
            int mid =low+(high-low)/2;
            if(nums[mid]>=t){
                high=mid;
            }else {
                low=mid+1;
            }
        }
        return low;
    }
    //右边界
    public static int rightBorder(int[] nums,int t){
        if(nums==null||nums.length==0)return -1;
        int low=0,high=nums.length;
        while (low<high){
            int mid =low+(high-low)/2;
            if(nums[mid]<=t){
                low=mid+1;
            }else {
                high=mid;
            }
        }
        return low-1; //注意减1
    }

    public static void main(String[] args)  {
        int[] a =new int[]{1,4,5,5,5,9};
        System.out.println(rightBorder(a,5));
    }
}
