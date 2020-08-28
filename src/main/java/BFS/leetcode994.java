package BFS;
import java.util.*;
/**
 * 腐烂的橘子
 */
public class leetcode994 {
    /**
     * 多源广度优先搜索
     */
    int rows,cols;
    int[][] directions ={{0,1},{0,-1},{1,0},{-1,0}};//四个方向
    public int orangesRotting(int[][] grid) {
        int ret=0;//结果
        rows=grid.length;
        cols=grid[0].length;
        Queue<int[]> queue =new LinkedList<>();
        int count=0;//记录新鲜的橘子的个数
        for(int i=0;i<rows;i++){  //先把多个腐烂的橘子入队
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    int[] temp=new int[2];
                    temp[0]=i;
                    temp[1]=j;
                    queue.offer(temp);
                }
                if(grid[i][j]==1)count++;
            }
        }
        while(count>0&&!queue.isEmpty()){ //注意这里的count需要大于0，当==0时可以提前结束，否则结果会多一次
            ret++;
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] now =queue.poll();
                for(int[] t:directions){
                    int x=now[0]+t[0];
                    int y=now[1]+t[1];
                    if(isin(x,y)&&grid[x][y]==1){
                        int[] temp=new int[2];
                        temp[0]=x;
                        temp[1]=y;
                        queue.offer(temp);
                        grid[x][y]=2;
                        count--;
                    }
                }
            }

        }
        if(count>0)return -1;
        else{
            return ret;
        }
    }
    public boolean isin (int x,int y){
        return x>=0&&x<rows&&y>=0&&y<cols;
    }

}
