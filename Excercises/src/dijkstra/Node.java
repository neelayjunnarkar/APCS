package dijkstra;

import java.util.HashMap;

/**
 * Created by 95028672 on 2/3/2015.
 */
public class Node {

    public HashMap<String, Integer> adjacents;
    public String parent;
    public int dist;
    Boolean linked = false;

    public Node() {
        dist = Integer.MAX_VALUE;
        parent = null;
        linked = false;
    }
    
    public Node(String[] nodes, Integer[] dists) {
        adjacents = new HashMap<>();
        for (int i = 0; i < ((nodes.length < dists.length) ? nodes.length : dists.length); ++i) {
            adjacents.put(nodes[i], dists[i]);
        }
        dist = Integer.MAX_VALUE;
        parent = null;
        linked = false;
    }
    
    public int getDistTo(String adjacentNode) {
        return adjacents.get(adjacentNode);
        
    }
}
