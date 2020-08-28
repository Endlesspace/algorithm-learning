package 数组;

/**
 * 构建乘积数组
 * 使用一个数组保存所有位置左边的乘积，然后反向遍历数组，用一个temp保存右边的乘积。可以把复杂度降维o（n）
 */
public class jz51 {
    public int[] multiply(int[] A) {
        int[] left=new int[A.length];
        left[0]=1;
        for(int i=1;i<A.length;i++){
            left[i]=left[i-1]*A[i-1];
        }
        int temp=1;
        for(int i=A.length-1;i>=0;i--){
            int t=A[i];
            A[i]=left[i]*temp;
            temp*=t;
        }
        return A;
    }
}
