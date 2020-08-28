package DFS;

public class leetcode547 {
    //深度优先搜索
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}
//并查集方法
//int rows,cols;
//    public int findCircleNum(int[][] M) {
//        if(M==null||M.length==0)return 0;
//        rows=M.length;
//        cols=M[0].length;
//        int[] parent=new int[rows];
//        for(int i=0;i<rows;i++){
//            parent[i]=i;
//        }
//        for(int i=0;i<rows;i++){
//            for(int j=i+1;j<cols;j++){
//                if(M[i][j]==1){
//                    parent[find(i,parent)]=find(j,parent);
//                }
//            }
//        }
//        HashSet<Integer> set =new HashSet<>();
//        for(int i:parent){
//            set.add(find(i,parent));
//        }
//        return set.size();
//    }
//    public int find(int x,int[] parent){
//        while(parent[x]!=x){
//            parent[x]=parent[parent[x]];
//            x=parent[x];
//        }
//        return x;
//    }
