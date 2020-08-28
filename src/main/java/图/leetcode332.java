package 图;

/**重新安排行程
 * 欧拉通路。
 * Hierholzer 算法用于在连通图中寻找欧拉路径，其流程如下：
 *
 * 从起点出发，进行深度优先搜索。
 *
 * 每次沿着某条边从某个顶点移动到另外一个顶点的时候，都需要删除这条边。
 *
 * 如果没有可移动的路径，则将所在节点加入到栈中，并返回。
 *
 *

 */
import java.util.*;
public class leetcode332 {
    Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();//保存每个节点和对应的优先队列
    List<String> itinerary = new LinkedList<String>();

    public List<String> findItinerary(List<List<String>> tickets) {
        //初始化map，遍历列表
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<String>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }

    public void dfs(String curr) {
        //不满足条件时就是死胡同，也就是最后一个点，此时把节点添加进去，会形成一个逆序的路径。
        while (map.containsKey(curr) && map.get(curr).size() > 0) {
            String tmp = map.get(curr).poll();//取到目的地，作为新的出发地，删除对应的边
            dfs(tmp);//递归遍历
        }
        itinerary.add(curr);
    }
}
