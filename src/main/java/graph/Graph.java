package graph;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> vertices;
    private ArrayList<MyVector> myVectors;
    public Graph(ArrayList<Vertex> vertices, ArrayList<MyVector> myVectors){
        this.vertices = vertices;
        this.myVectors = myVectors;
    }


    @Override
    public String toString() {
        return "Graph{" +
                "ribs=" + myVectors +
                '}';
    }
}
