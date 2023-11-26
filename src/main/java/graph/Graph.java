package graph;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> vertices;
    private ArrayList<Rib> ribs;
    public Graph(ArrayList<Vertex> vertices, ArrayList<Rib> ribs){
        this.vertices = vertices;
        this.ribs = ribs;
    }


    @Override
    public String toString() {
        return "Graph{" +
                "ribs=" + ribs +
                '}';
    }
}
