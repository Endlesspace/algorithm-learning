package 查找;
//魔术索引; nums[i]=i;不一定单调递增。可以使用跳跃的遍历。  另一种方法是使用二分剪枝。
public class magicindex {
    public int findMagicIndex(int[] nums) {
        for(int i=0;i<nums.length;){
            if(nums[i]==i)return i;
            i=Math.max(nums[i],i+1);//跳跃遍历
        }
        return -1;
    }
}
