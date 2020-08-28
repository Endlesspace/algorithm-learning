package 双指针;
import java.util.*;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class JZ42 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> ret =new ArrayList<>();
        if(array==null)return ret;
        int p1=0,p2=array.length-1,m=Integer.MAX_VALUE;
        while(p1<p2){
            int target=array[p1]+array[p2];
            if(sum==target){
                if(array[p1]*array[p2]<m){
                    m=array[p1]*array[p2];
                    ret.clear();
                    ret.add(array[p1]);
                    ret.add(array[p2]);
                    p1++;

                }else p1++; //注意这里， 不然会死循环
            }else if(sum<target)p2--;
            else p1++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] a=new int[]{1,2,3,4,5,6,7};
        System.out.println(new JZ42().FindNumbersWithSum(a,7));
    }
}
