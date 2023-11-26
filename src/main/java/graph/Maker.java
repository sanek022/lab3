package graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Maker {
    private int square;
    private ArrayList<Vertex> vertices = new ArrayList<>();
    private ArrayList<Rib> ribs = new ArrayList<>();
    private Map<Integer,ArrayList<Integer>> matrix = new HashMap<>();
    private int number;
    private Graph graph;

    public int getSquare() {
        return square;
    }

    public Vertex getVertices(int index) {
        return vertices.get(index);
    }

    public ArrayList<Rib> getRibs() {
        return ribs;
    }

    public int getMatrix(int key, int index) {
        return matrix.get(key).get(index);
    }

    public int getNumber() {
        return number;
    }

    public Graph getGraph() {
        return graph;
    }

    public Maker() throws FileNotFoundException {
        graphMaker();
    }
    private Graph graphMaker() throws FileNotFoundException {
        vertexMaker();
        ribMaker();
        graph = new Graph(vertices,ribs);
        return graph ;
    }
    public void vertexMaker() throws FileNotFoundException {

        FileReader fileReader = new FileReader("Data.txt");
        Scanner scanner = new Scanner(fileReader);
        number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            vertices.add(new Vertex(i,scanner.nextInt(), scanner.nextInt()));
        }
        //System.out.println(vertices);
        square = scanner.nextInt();
        //System.out.println(square);
        for (int i = 0; i < number; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            matrix.put(i,list);
            for (int j = 0; j < number; j++) {
                    matrix.get(i).add(j);
            }
        }
        //System.out.println(matrix);
        scanner.close();
      /*  for (int i = 0; i < number; i++) {
            vertices.add(new Vertex(i,random.nextInt(20), random.nextInt(20)));
        }*/
       /* vertices.add(new Vertex(0,4, 5));
        vertices.add(new Vertex(1,4, 8));
        vertices.add(new Vertex(2,8, 3));
        vertices.add(new Vertex(3,8, 6));
        vertices.add(new Vertex(4,2, 8));*/
        }

    public void out(){
        System.out.println(vertices);
    }
    public void ribMaker(){
        for (int i = 0; i < vertices.size()-1; i++) {
           ribs.add(new Rib(vertices.get(i), vertices.get(i+1)));
        }
    }
}
