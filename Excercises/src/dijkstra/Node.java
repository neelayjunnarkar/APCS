package dijkstra;

import java.util.HashMap;

/**
 * A Node class that represents a node in an Adjacency List
 */
public class Node {

    public HashMap<String, Integer> adjacents;
    public String parent;
    public int dist;
    public Boolean linked = false;

    public Node() {
        dist = Integer.MAX_VALUE;
        parent = null;
        linked = false;
    }

    /**
     *  Creates a node with a HashMap of it's adjacent nodes, and the distances to each of them
     * @param nodes The adjacent nodes, represented as a string
     * @param dists The distances to the adjacent nodes
     */
    public Node(String[] nodes, Integer[] dists) {
        adjacents = new HashMap<>();
        for (int i = 0; i < ((nodes.length < dists.length) ? nodes.length : dists.length); ++i) {
            adjacents.put(nodes[i], dists[i]);
        }
        dist = Integer.MAX_VALUE;
        parent = null;
        linked = false;
    }

    /**
     * *
     * @param adjacentNode the adjacent node, to which the distance will be found
     * @return Returns the distance from this node to the adjacent node
     */
    public int getDistTo(String adjacentNode) {
        return adjacents.get(adjacentNode);
    }
}
