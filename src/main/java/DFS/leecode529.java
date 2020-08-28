package DFS;

/**
 * 扫雷游戏;
 */
public class leecode529 {
    int rows,cols;
    int[][] directions=new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        rows=board.length;cols=board[0].length;
        dfs(board,click[0],click[1]);
        return board;
    }
    public void dfs(char[][] board,int x,int y){
        if(!isin(x,y))return;
        if(board[x][y]=='M'){   //如果是点击的是隐藏的地雷，那么直接改成X，退出
            board[x][y]='X';
            return;
        }
        int num=0;  //寻找当前位置相邻格子里雷的个数
        for(int[] t:directions){
            int nx=x+t[0],ny=y+t[1];
            if(isin(nx,ny)&&board[nx][ny]=='M')num++;
        }

        if(num==0){         //如果没有雷，则向周围扩展进行dfs，并且把当前位置改成B
            board[x][y]='B';
            for(int[] t:directions){
                int nx=x+t[0],ny=y+t[1];
                if(isin(nx,ny)&&board[nx][ny]=='E')dfs(board,nx,ny);
            }

        }else{//如果有雷，则改为具体的数字。

            board[x][y]=(char)('0'+num);
        }
    }
    public boolean isin(int x,int y){//超出边界。
        return x>=0&&x<rows&&y>=0&&y<cols;
    }
}
