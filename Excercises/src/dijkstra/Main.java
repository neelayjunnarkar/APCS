package dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Stack;

/**
 * This program implements Dijkstra's algorithm in Java
 */
public class Main {

    /**
     * Calculates the shortest distance from source to destination in an adjacency list
     * @param graph the adjacency list
     * @param source the beggining node in the adjacency list
     * @param destination the destination node in the adjacency list
     * @return Returns the shortest path from source to destination, in terms of nodes in the adjacency list
     */
    static ArrayList<String> dijkstra(AdjacencyList graph, String source, String destination) {

        ArrayList<String> selectedNodes = new ArrayList<>();

        graph.get(source).dist = 0;
        graph.get(source).linked = true;
        selectedNodes.add(source);

        while (graph.size() != selectedNodes.size()) {
            int min_dist = Integer.MAX_VALUE;
            String min_dist_node = "";

            for (String node : selectedNodes) {
                for (String adjacent : graph.get(node).adjacents.keySet()) {
                    if (graph.get(adjacent).linked == true) //if the node is selected, skip it
                        continue;
                    if (graph.get(node).dist+graph.get(node).getDistTo(adjacent) < graph.get(adjacent).dist) { //if the distance from source to adjacent is reducable with a
                                                                                                               //newly-found path, update the path
                        graph.get(adjacent).parent = node;
                        graph.get(adjacent).dist = graph.get(node).dist+graph.get(node).getDistTo(adjacent);
                    }
                    if (graph.get(adjacent).dist < min_dist) {
                        min_dist = graph.get(adjacent).dist;
                        min_dist_node = adjacent;
                    }

                }
            }

            if (min_dist_node != "") {
                graph.get(min_dist_node).linked = true;
                selectedNodes.add(min_dist_node);
            }

        }

        //Create the string of nodes which is a path from source to destination
        Stack<String> path = new Stack<>();
        path.add(destination);
        while (graph.get(destination).parent != null) { //adds the path into the stack in the order destination -> source
            path.add(graph.get(destination).parent);
            destination = (graph.get(destination).parent);
        }
        ArrayList<String> ret = new ArrayList<>();
        for (int i = 0; i < path.size(); ) {
            ret.add(path.pop()); //pop out of the stack and add the popped values into an arraylist to reverse the order
                                 //so the order of the returned arraylist is source -> destination
        }

        return ret; //returns the correctly ordered, shortest path from source to destination
    }

    public static void main(String[] args) {

        AdjacencyList nodes = new AdjacencyList();

        nodes.put("A", new Node(new String[]{"B", "F"}, new Integer[]{8, 10}));
        nodes.put("B", new Node(new String[]{"C", "E"}, new Integer[]{4, 10}));
        nodes.put("C", new Node(new String[]{"D"}, new Integer[]{3}));
        nodes.put("D", new Node(new String[]{"E", "F"}, new Integer[]{25, 18}));
        nodes.put("E", new Node(new String[]{"D", "G"}, new Integer[]{9, 7}));
        nodes.put("F", new Node(new String[]{"A", "B", "C", "E"}, new Integer[]{5, 7, 3, 2}));
        nodes.put("G", new Node(new String[]{"D", "H"}, new Integer[]{2, 3}));
        nodes.put("H", new Node(new String[]{"A", "B"}, new Integer[]{4, 9}));


        String begin = "G", end = "F";
        System.out.println(dijkstra(nodes, begin, end));
        //prints "[G, H, A, F]"


        System.out.println("parent: "+nodes.get(end).parent + "   dist from "+begin+": " + nodes.get(end).dist);
        //prints "parent: A   dist from G: 17"

    }
}
