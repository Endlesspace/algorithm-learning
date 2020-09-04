package 双指针;

/**
 * 盛水最多的容器。双指针从两端向中间靠拢，每次移动两者中小的一方
 */
public class leetcode11 {
    public int maxArea(int[] height) {
        int max=0,start=0,end=height.length-1;
        while(start<end){
            max=Math.max(max,getnum(start,end,height));
            if(height[start]<=height[end]){
                start++;
            }else end--;
        }
        return max;
    }
    public int getnum(int x,int y,int[] height){
        return (y-x)*Math.min(height[x],height[y]);
    }
}
