package 回溯;
import java.util.*;

/**
 * N皇后问题。
 * 以三个set存储出现过的列和两种对角线。
 */
public class leetcode51 {
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> solutions = new ArrayList<List<String>>();//结果集
            int[] queens = new int[n];//数组，queens【x】代表第x行放置皇后的位置
            Arrays.fill(queens, -1);
            //三个set存放不能在放置皇后的位置
            Set<Integer> columns = new HashSet<Integer>();
            Set<Integer> diagonals1 = new HashSet<Integer>();
            Set<Integer> diagonals2 = new HashSet<Integer>();
            backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);//回溯
            return solutions;
        }

        public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
            if (row == n) {
                List<String> board = generateBoard(queens, n);//生成棋盘
                solutions.add(board);
            } else {
                for (int i = 0; i < n; i++) {
                    if (columns.contains(i)) {  //该列已经有皇后
                        continue;
                    }
                    int diagonal1 = row - i;
                    if (diagonals1.contains(diagonal1)) { //该斜对角已经有皇后
                        continue;
                    }
                    int diagonal2 = row + i;
                    if (diagonals2.contains(diagonal2)) {//该斜对角已经有皇后
                        continue;
                    }
                    queens[row] = i;//如果都没有皇后，则这一行在这个位置放置皇后
                    //将这个位置放入三个集合
                    columns.add(i);
                    diagonals1.add(diagonal1);
                    diagonals2.add(diagonal2);
                    backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);//递归，每一次row加一
                    //撤销之前的操作，回溯
                    queens[row] = -1;
                    columns.remove(i);
                    diagonals1.remove(diagonal1);
                    diagonals2.remove(diagonal2);
                }
            }
        }

        public List<String> generateBoard(int[] queens, int n) {
            List<String> board = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[queens[i]] = 'Q';
                board.add(new String(row));
            }
            return board;
        }
    }

}
