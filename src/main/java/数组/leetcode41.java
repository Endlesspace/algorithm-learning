package 数组;

/**
 * 缺失的第一个正数
 * 思路：通过原地hash的方法，遍历数组三次.缺失的数一定在1到n+1的范围内
 */
public class leetcode41 {
    public int firstMissingPositive(int[] nums) {
        if(nums==null)return 1;
        boolean flag=false;
        for(int i=0;i<nums.length;i++){
            if(!flag&&nums[i]==1)flag=true;//如果数组中没有1，那么直接返回1
            if(nums[i]<=0||nums[i]>nums.length)nums[i]=1;//第一次遍历，如果出现小于等于0的数以及大于数组长度的数，就设置为1

        }
        if(!flag)return 1;
        for(int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i])-1;
            nums[index]=-(Math.abs(nums[index]));//第二次遍历，把当前数对应的序号的值设置为负，表示该输出现过
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)return i+1;//第三次遍历，找到第一个正数，返回代表的数
        }
        return nums.length+1;//如果数组中没有正数，表示1到n都出现过，则返回数组长度+1
    }
}
