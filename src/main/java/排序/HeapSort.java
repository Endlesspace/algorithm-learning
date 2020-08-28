package 排序;

import java.util.Arrays;

public class HeapSort {
    int[] arr ;
    public HeapSort(int[] arr){
        this.arr=arr;
    }
    public void sort(int[] arr){
        int len=arr.length;
        buildheap(arr,len);
        while(len>1){
            swap(arr,0,len-1);
            len--;
            heapfy(arr,0,len);
        }

    }
    //建堆
    public void buildheap(int[] arr,int len){
        //不考虑叶子节点，因为叶子节点不会对下面的节点产生影响，所以从
        for(int i=(int)Math.floor(len/2);i>=0;i--){
            heapfy(arr,i,len);
        }
    }
    //下滤
    public void heapfy(int[] arr,int i,int len){
        int left=2*i+1;
        int right=2*i+2;
        int largest=i;
        if(left<len&&arr[left]>arr[largest]){
            largest=left;
        }
        if(right<len&&arr[right]>arr[largest]){
            largest=right;
        }
        if(largest!=i){
            swap(arr,largest,i);
            heapfy(arr,largest,len);
        }
    }
    // 交换
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;

    }

    public static void main(String[] args) {
        int[] a=new int[]{3,5,7,1,0,3,4,9,8,6};
        new HeapSort(a).sort(a);
        System.out.println(Arrays.toString(a));
    }
}
