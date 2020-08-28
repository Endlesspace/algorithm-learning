package BFS;
import java.util.*;
//矩阵中带障碍的最短路径
class Leetcode1091 {
    int[][] directions={{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
    int rows,cols;
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length==0||grid==null)return -1;
        rows=grid.length;
        cols=grid[0].length;
        if(grid[0][0]==1||grid[rows-1][cols-1]==1)return -1;
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{0,0});
        grid[0][0]=1; //这道题使用原来的矩阵来记录路径的长度，同时也满足走过的路不会再走。其他情况需要一个辅助矩阵来记录走过的路。
        while(!queue.isEmpty()&&grid[rows-1][cols-1]==0){
            int[] t = queue.poll();
            int length=grid[t[0]][t[1]];
            for(int[] cur:directions){
                int nx=t[0]+cur[0];
                int ny=t[1]+cur[1];
                if(isin(nx,ny)&&grid[nx][ny]==0){
                    grid[nx][ny]=length+1;
                    queue.offer(new int[]{nx,ny});
                }
            }
        }
        return grid[rows-1][cols-1]==0? -1:grid[rows-1][cols-1];


    }
    public boolean isin(int x,int y){
        return x>=0&&x<=cols-1&&y>=0&&y<=rows-1;
    }
}