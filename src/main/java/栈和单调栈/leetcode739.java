package 栈和单调栈;

import java.util.Deque;
import java.util.LinkedList;

//天气预报温度
//单调栈一般用于找某个数左边或者右边第一比他大或者小的数。
public class leetcode739 {
    public int[] dailyTemperatures(int[] T) {
        if(T==null||T.length==0)return new int[]{};
        int len=T.length;
        Deque<Integer> stack =new LinkedList<>();  //栈用Deque声明
        for(int i=0;i<len;i++){
            while(!stack.isEmpty()&&T[i]>T[stack.peek()]){
                int t=stack.pop();
                T[t]=i-t;
            }
            stack.push(i);

        }
        while(!stack.isEmpty()){
            int t=stack.pop();
            T[t]=0;
        }
        return T;

    }
}
