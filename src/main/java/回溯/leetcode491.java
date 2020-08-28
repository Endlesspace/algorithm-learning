package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 求数组所有的递增子序列，注意是序列。
 */
public class leetcode491 {
    List<Integer> temp = new ArrayList<Integer>(); //临时列表
    List<List<Integer>> ans = new ArrayList<List<Integer>>(); //最终答案

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums); //第一个数字没有前一个数字，所以用整数最小值代替。
        return ans;
    }

    public void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) { //如果到达数组结尾，则返回。
            if (temp.size() >= 2) { //只选择长度大于2的子序列
                ans.add(new ArrayList<Integer>(temp)); //要复制一遍再加入，否则后面回溯后都为空了。
            }
            return;
        }
        //当前元素有两种情况，选择与不选。
        if (nums[cur] >= last) { //当前元素大于前一个元素
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[cur] != last) { //不选择的情况，需要考虑去重。当当前元素等于上一个元素时，必须选择，否则乎有重复的子序列。
            dfs(cur + 1, last, nums);
        }
    }
}
