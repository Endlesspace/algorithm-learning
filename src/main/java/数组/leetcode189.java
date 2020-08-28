package 数组;

/**
 * 旋转数组
 * 解法：1.环形替换， 2反转 ，先整体反转，再反转前n-k个，再反转后k个
 */
public class leetcode189 {
    public void rotate(int[] nums, int k) {
        if(k>=nums.length)k=k%nums.length;
        int count=0;
        for(int start=0;count<nums.length;start++){
            int current=start;//定义当前指针
            int pre=nums[start];//用pre变量保存上一个被替换的数
            do{
                int next =(start+k)%nums.length;//如果超过数组长度就求余数
                int t=nums[next];//临时变量保存
                nums[next]=pre;//替换
                pre=t;
                count++;//交换次数，交换n次就结束
                start=next;//当前指针前移
            }while(start!=current);//当指针回到初始地方表示这一轮交换结束，start指针前移
        }
    }
    /**
     * 反转法
     * public void rotate(int[] nums, int k) {
     *         k %= nums.length;
     *         reverse(nums, 0, nums.length - 1);
     *         reverse(nums, 0, k - 1);
     *         reverse(nums, k, nums.length - 1);
     *     }
     *     public void reverse(int[] nums, int start, int end) {
     *         while (start < end) {
     *             int temp = nums[start];
     *             nums[start] = nums[end];
     *             nums[end] = temp;
     *             start++;
     *             end--;
     *         }
     *     }
     *
     */
}
