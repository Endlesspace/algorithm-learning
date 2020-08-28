package 双指针;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */
public class leetcode16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if(nums.length<=3){
            int sum=0;
            for(int i:nums){
                sum+=i;
            }
            return sum;
        }

        int ret=nums[0]+nums[1]+nums[2];
        int min =Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            int p2=i+1,p3=nums.length-1;
            while(p2<p3){
                int sum =nums[i]+nums[p2]+nums[p3];
                int dis = Math.abs(sum-target);
                if(dis==0)return sum;
                if(dis<min){min=dis;ret=sum;}
                if(sum<target)p2++;
                else p3--;
            }


        }
        return ret;
    }
}
