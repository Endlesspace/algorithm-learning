package 回溯;
/**
 * 全排列Ⅰ 和Ⅱ
 */

import java.util.*;
public class leetcode46 {
    static List<List<Integer>> ret;
    public static List<List<Integer>> permute(int[] nums) {
        ret =new ArrayList<>();
        if(nums.length==0)return ret;
        // 排序（升序或者降序都可以），排序是剪枝的前提.适用于全排列 Ⅱ
        Arrays.sort(nums);
        boolean[] used=new boolean[nums.length];
        help(0,nums,new ArrayList<>(),used);
        return ret;

    }
    public static void help(int count,int[] nums,List<Integer> list,boolean[] used){
        if(count==nums.length){
            ret.add(new ArrayList<>(list));//注意，这里如果直接加list，加的只是引用，到最后回溯回去只是一个空数组，所以必须拷贝
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i])continue;
            if (i > 0 && nums[i] == nums[i - 1]&& !used[i - 1] ) {//全排列2，变形，可以有重复数字的不重复排列，使用这句剪枝，// 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
                continue;
            }
            list.add(nums[i]);
            used[i]=true;
            help(count+1,nums,list,used);
            list.remove(list.size()-1);
            used[i]=false;
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,1,3}));
    }
}
