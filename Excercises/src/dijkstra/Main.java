package dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;

/**
 * This program implements Dijkstra's algorithm in Java
 *  
 */
public class Main {
    
    static String[] dijkstra(HashMap<String, Node> graph, String source, String destination) {

        ArrayList<String> selectedNodes = new ArrayList<>();
        
        graph.get(source).dist = 0;
        graph.get(source).linked = true;
        selectedNodes.add(source);
        
        while (graph.size() != selectedNodes.size()) {
            
            int min_dist = Integer.MAX_VALUE;
            String min_dist_node = null;
            
            for (String node : selectedNodes) {

                for (String adjacent : graph.get(node).adjacents.keySet()) {
                    graph.get(adjacent).parent = node;
                    if (graph.get(graph.get(adjacent).parent).getDistTo(adjacent) + graph.get(graph.get(adjacent).parent).dist < graph.get(adjacent).dist)
                        graph.get(adjacent).dist = graph.get(graph.get(adjacent).parent).getDistTo(adjacent) + graph.get(graph.get(adjacent).parent).dist;
                    
                    if (graph.get(adjacent).dist < min_dist) {
                        min_dist = graph.get(adjacent).dist;
                        min_dist_node = adjacent;
                    }
                }
 
            }
            if (min_dist_node != null)
                selectedNodes.add(min_dist_node);
            graph.get(min_dist_node).linked = true;

        }
        
        
        return new String[]{"A"};
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
