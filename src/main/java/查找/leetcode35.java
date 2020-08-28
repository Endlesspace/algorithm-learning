package 查找;

public class leetcode35 {
    public static int searchInsert(int[] nums, int target) {
        int l=0,r=nums.length-1;
        int ans=nums.length;
        while(l<=r){
            int mid=l+(r-l)>>1;
            if(target<=nums[mid]){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;



    }

    public static void main(String[] args) {
        int[] a =new int[]{1,3,5,6};
        System.out.println(searchInsert(a,5));
    }
}
