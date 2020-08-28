package 并查集;
//冗余连接
public class leetcode684 {
    public int[] findRedundantConnection(int[][] edges) {
        int[] ret =new int[2];
        if(edges==null||edges.length==0)return ret;
        int[] parent =new int[edges.length+1];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
        for(int[] item:edges){
            if(!isconnected(item[0],item[1],parent)){
                union(item[0],item[1],parent);
            }else{
                return item;
            }
        }
        return ret;

    }
    public boolean isconnected(int i,int j,int[] parent){
        return find(i,parent)==find(j,parent);
    }
    public void union(int x,int y,int[] parent){
        parent[find(x,parent)]=find(y,parent);

    }
    public int find(int x,int[] parent){
        while(parent[x]!=x){
            parent[x]=parent[parent[x]];
            x=parent[x];
        }
        return x;
    }
}
