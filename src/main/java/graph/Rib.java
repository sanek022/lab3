package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Rib {
    Vertex vertex1;
    Vertex vertex2;

    @Override
    public String toString() {
        return "Rib{" +
                "vertex1=" + vertex1 +
                ", vertex2=" + vertex2 +
                '}';
    }

    public Rib(Vertex vertex1, Vertex vertex2){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    public Vertex getVertex1() {
        return vertex1;
    }

    public Vertex getVertex2() {
        return vertex2;
    }

    public void setVertex1(Vertex vertex1) {
        this.vertex1 = vertex1;
    }

    public void setVertex2(Vertex vertex2) {
        this.vertex2 = vertex2;
    }
}
