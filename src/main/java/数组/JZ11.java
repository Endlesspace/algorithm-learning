package 数组;

/**
 * 旋转数组的最小值
 * 使用二分查找，不断与nums【high】作比较
 */
public class JZ11 {
    public static int minArray(int[] numbers) {
        int low=0,high=numbers.length-1;
        while(low<high){
            int pivot =((high-low)/2)+low;
            if(numbers[pivot]<numbers[high]){//说明枢纽在最小值右边
                high=pivot;
            }else if(numbers[pivot]>numbers[high]){//枢纽在最小值左边
                low=pivot+1;
            }else{
                high--;
            }
        }
        return numbers[low];

    }

    public static void main(String[] args) {
        int[] a =new int[]{3,4,5,1,2};
        System.out.println(minArray(a));
    }
}
