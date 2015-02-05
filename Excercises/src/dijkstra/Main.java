package dijkstra;

import java.util.HashMap;
import java.util.InputMismatchException;

/**
 * This program implements Dijkstra's algorithm in Java
 *  
 */
public class Main {
    
    static String[] dijkstra(HashMap<String, Node> graph, String source, String destination) {
        if (source.equals(destination))
            return new String[]{"A"};

        int dist = Integer.MAX_VALUE;
        String node = null;

        if (graph.get(source).parent != null)
            graph.get(source).dist = graph.get(graph.get(source).parent).dist + graph.get(graph.get(source).parent).getDistTo(source);

        for (String adjacent : graph.get(source).adjacents.keySet()) {

            graph.get(adjacent).parent = source;

            if (graph.get(source).adjacents.get(adjacent) < dist) {
                dist = graph.get(source).adjacents.get(adjacent);
                node = adjacent;
            }

            if (graph.get(source).getDistTo(adjacent)+graph.get(graph.get(adjacent).parent).dist < graph.get(adjacent).dist)
                graph.get(adjacent).dist = graph.get(graph.get(adjacent).parent).dist + graph.get(source).getDistTo(adjacent);

        }
        System.out.println("dist: "+dist);
        System.out.println("node: "+node);

        return dijkstra(graph, node, destination);
    }
    
    static HashMap<String, Node> nodes = new HashMap<>();
    
    public static void main(String[] args) {
        nodes.put("A", new Node(new String[]{"B", "F"}, new Integer[]{8, 10}));
        nodes.put("B", new Node(new String[]{"C", "E"}, new Integer[]{4, 10}));
        nodes.put("C", new Node(new String[]{"D"}, new Integer[]{3}));
        nodes.put("D", new Node(new String[]{"E", "F"}, new Integer[]{25, 18}));
        nodes.put("E", new Node(new String[]{"D", "G"}, new Integer[]{9, 7}));
        nodes.put("F", new Node(new String[]{"A", "B", "C", "E"}, new Integer[]{5, 7, 3, 2}));
        nodes.put("G", new Node(new String[]{"D", "H"}, new Integer[]{2, 3}));
        nodes.put("H", new Node(new String[]{"A", "B"}, new Integer[]{4, 9}));
        
        dijkstra(nodes, "G", "F");

        System.out.println(nodes.get("F").parent);


//        for ( String node : nodes.keySet()) {
//            System.out.println(node+":");
//            for (String adjacent : nodes.get(node).adjacents.keySet()) {
//                System.out.println("    "+adjacent + " "+nodes.get(node).adjacents.get(adjacent));
//            }
//        }
        
    }
}
