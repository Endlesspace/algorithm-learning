package 图;

/**
 * 无向图，判断二分图，二着色问题
 * 深度优先搜索
 */
public class leetcode785 {
    int[] color;
    boolean flag=true;
    public boolean isBipartite(int[][] graph) {
        //定义0为未染色，1为红，-1为绿
        //定义访问数组
        int n=graph.length;
        color=new int[n];
        //遍历节点，并进行深度优先搜索
        for(int i=0;i<n;i++){
            if(color[i]==0){
                dfs(i,1,graph);//默认给每个没着色的点染红
            }
        }
        return flag;
    }
    public void dfs(int i,int c,int[][] graph) {
        color[i] = c;
        for (int nei : graph[i]) {
            if (color[nei] == 0) {
                dfs(nei, -1 * c, graph);//给相邻点染相反的颜色
                if (!flag) return;//提前结束，如果已经不满足条件
            } else if (color[nei] != (-1 * c)) {
                flag = false;
                return;
            }
        }
    }
}
/**
 * 广度优先方法：
 * private static final int UNCOLORED = 0;
 *     private static final int RED = 1;
 *     private static final int GREEN = 2;
 *     private int[] color;
 *
 *     public boolean isBipartite(int[][] graph) {
 *         int n = graph.length;
 *         color = new int[n];
 *         Arrays.fill(color, UNCOLORED);
 *         for (int i = 0; i < n; ++i) {
 *             if (color[i] == UNCOLORED) {    //
 *                 Queue<Integer> queue = new LinkedList<Integer>();
 *                 queue.offer(i);//
 *                 color[i] = RED;
 *                 while (!queue.isEmpty()) {
 *                     int node = queue.poll();
 *                     int cNei = color[node] == RED ? GREEN : RED;
 *                     for (int neighbor : graph[node]) {
 *                         if (color[neighbor] == UNCOLORED) {
 *                             queue.offer(neighbor);//
 *                             color[neighbor] = cNei;
 *                         } else if (color[neighbor] != cNei) {
 *                             return false;
 *                         }
 *                     }
 *                 }
 *             }
 *         }
 *         return true;
 *     }
 *
 */
