package 栈和单调栈;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode155 {
    Deque<Integer> sdata=new LinkedList<>();
    Deque<Integer> smin=new LinkedList<>();
    /** initialize your data structure here. */
    public leetcode155() {

    }


    public void push(int x) {
        if(smin.isEmpty()){
            smin.push(x);
        }else if(x<=smin.peek()){
            smin.push(x);
        }
        sdata.push(x);
    }

    public void pop() {

        int value =sdata.pop();
        if(value==smin.peek()){
            smin.pop();
        }
    }

    public int top() {
        return sdata.peek();
    }

    public int getMin() {
        return smin.peek();
    }
}
