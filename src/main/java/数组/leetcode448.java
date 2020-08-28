package 数组;
import  java.util.*;

/**
 * 找到数组中消失的数字
 */
public class leetcode448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret =new ArrayList<>();
        //原地hash，然后把出现过的数字对应的下标-1位置的数字设置为负数
        for(int i=0;i<nums.length;i++){
            int newIndex = Math.abs(nums[i]) - 1;

            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }

        //第二次遍历，找出不为负数的位置
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                ret.add(i+1);

            }
        }
        return ret;

    }
}
