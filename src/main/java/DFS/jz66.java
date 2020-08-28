package DFS;

public class jz66 {
    int threshold, rows, cols;
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int count;

    public int movingCount(int threshold, int rows, int cols) {
        this.threshold = threshold;
        this.rows = rows;
        this.cols = cols;
        boolean[][] mark = new boolean[rows][cols];
        help(0, 0, mark);
        return count;

    }

    public void help(int x, int y, boolean[][] mark) {
        if (!isin(x, y) || mark[x][y] == true) return;
        if (canstay(x, y)) count++;
        else {
            mark[x][y] = true;
            return;
        }
        mark[x][y] = true;
        for (int[] t : directions) {
            help(x + t[0], y + t[1], mark);
        }
    }

    public boolean isin(int m, int n) {
        return m >= 0 && m <= rows-1 && n >= 0 && n <= cols-1;
    }

    public boolean canstay(int m, int n) {
        int sum = 0;
        while (m > 0) {
            sum += m % 10;
            m /= 10;
        }
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        if (sum > threshold) return false;
        else return true;
    }

    public static void main(String[] args) {
        System.out.println(new jz66().movingCount(15,20,20));
    }
}
