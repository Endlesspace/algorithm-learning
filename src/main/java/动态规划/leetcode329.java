package 动态规划;

/**
 * 矩阵最长递增路径
 */
public class leetcode329 {
    int rows,cols,max;
    int[][] direction =new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0)return 0;
        rows=matrix.length;cols=matrix[0].length;

        int[][] mem =new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                max=Math.max(max,dfs(matrix,i,j,mem));
            }
        }
        return max;

    }
    public int dfs(int[][] matrix,int x,int y,int[][] mem){

        if(mem[x][y]!=0)return mem[x][y];
        ++mem[x][y];
        for(int[] t:direction){
            int m=x+t[0];int n=y+t[1];
            if(isin(m,n)&&matrix[m][n]>matrix[x][y]){
                mem[x][y]=Math.max(mem[x][y],dfs(matrix,m,n,mem)+1);
            }

        }

        return mem[x][y];
    }
    public boolean isin(int x,int y){
        return x>=0&&x<rows&&y>=0&&y<cols;
    }
}

