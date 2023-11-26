package graph;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Powers {
    Graph graph;
    double length = -1;
    double evkDist;
    public Powers() throws FileNotFoundException {
        Maker maker = new Maker();
        graph = maker.getGraph();
        length = ribLength(maker.getSquare(), maker.getNumber());
        for (int i = 0; i < 30; i++) {
            ArrayList<Integer> xList = new ArrayList<>();
            ArrayList<Integer> yList = new ArrayList<>();
            for (int j = 0; j < maker.getNumber(); j++) {
                double changeX = 0;
                double changeY = 0;
                Vertex vertex1 = maker.getVertices(j);
                for (int k = 0; k < maker.getNumber(); k++) {
                    if(j == k)
                        continue;
                    Vertex vertex2 = maker.getVertices(k);
                    evkDist = evkDistance(vertex1,vertex2);
                    if(maker.getMatrix(j,k) == 1){
                        double a = fSpring();
                        changeX += a * (vertex2.getX() - vertex1.getX());
                        changeY += a * (vertex2.getY() - vertex1.getY());
                    }
                    double a = fRep();
                    changeX += a * (vertex2.getX() - vertex1.getX());
                    changeY += a * (vertex2.getY() - vertex1.getY());
                }
                xList.add((int) changeX);
                yList.add((int) changeY);
            }
            for (int j = 0; j < maker.getNumber(); j++) {
                maker.getVertices(j).setX(maker.getVertices(j).getX() + xList.get(j));
                maker.getVertices(j).setY(maker.getVertices(j).getY() + yList.get(j));
            }
            maker.out();
        }
    }
    public double ribLength(int area, int vertexNumber){
        return Math.sqrt(area/ vertexNumber);
    }
    public double evkDistance(Vertex vertex1, Vertex vertex2){
        return  Math.sqrt(Math.pow(vertex1.getX() - vertex2.getX(), 2) + Math.pow(vertex1.getY() - vertex2.getY(),2));
    }
    private double fSpring(){
        if(length!=0)
            return Math.pow(evkDist,2)/length;
        else return 0;
    }
    private double fRep(){
        if(evkDist!=0)
            return Math.pow(length,2)/ evkDist;
        else return 0;
    }
}
