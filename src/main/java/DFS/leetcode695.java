package DFS;
//最大岛屿面积
//利用沉岛思想可以不用mark矩阵
public class leetcode695 {
    int rows,cols;
    int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        rows=grid.length;
        cols=grid[0].length;
        boolean[][] mark=new boolean[rows][cols];
        int max=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                max=Math.max(max,help(i,j,grid,mark));
                mark[i][j]=true;
            }
        }
        return max;

    }
    public boolean isin(int x,int y){
        return x>=0&&x<rows&&y>=0&&y<cols;
    }
    public int help(int x,int y,int[][] grid,boolean[][] mark){
        if(!isin(x,y)||mark[x][y]||grid[x][y]==0)return 0;
        mark[x][y]=true;// grid[x][y]=0;
        int count=1;
        for(int[] t:directions){
            count+=help(x+t[0],y+t[1],grid,mark);
        }
        return count;

    }
}
