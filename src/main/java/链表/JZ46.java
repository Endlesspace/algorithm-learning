package 链表;


/**
 * 孩子们的游戏，用链表模拟
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class JZ46 {
    public int LastRemaining_Solution(int n, int m) {
        List<Integer> list =new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int p=0;
        while(list.size()>1){
            int cnt=0;
            while(cnt<m-1){
                p++;
                if(p>list.size()-1)p=0;
                cnt++;
            }

            System.out.print("删除了"+list.get(p));
            list.remove(p);
            if(p>list.size()-1)p=0;
            System.out.println(Arrays.toString(list.toArray()));



        }
        return list.get(0);
    }

    public static void main(String[] args) {
        new JZ46().LastRemaining_Solution(5,3);
    }
}
