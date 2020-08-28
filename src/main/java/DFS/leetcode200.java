package DFS;
//岛屿数量
public class leetcode200 {
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        int rows,cols;

        public int numIslands(char[][] grid) {
            if(grid==null||grid.length==0)return 0;
            rows=grid.length;cols=grid[0].length;
            int ret=0;
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    if(grid[i][j]=='1'){
                        help(i,j,grid);
                        ret++;
                    }
                }
            }
            return ret;

        }
        public void help(int x,int y,char[][] grid){
            if(!isin(x,y)||grid[x][y]=='0')return;
            grid[x][y]='0';
            for(int[] t:directions){
                help(x+t[0],y+t[1],grid);
            }


        }
        public boolean isin(int x ,int y){
            return x>=0&&x<rows&&y>=0&&y<cols;
        }
}
