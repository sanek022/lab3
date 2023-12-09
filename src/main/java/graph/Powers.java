package graph;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Powers {
    Graph graph;
    double lengthRib = -1.0;
    double evkDist;
    double cos;
    public Powers() throws FileNotFoundException {
        Maker maker = new Maker();
        graph = maker.getGraph();
        lengthRib = ribLength(maker.getSquare(), maker.getNumber());
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < maker.getNumber(); j++) {
                double changeX;
                double changeY;
                ArrayList<MyVector> myVectors = new ArrayList<>();
                Vertex vertex1 = maker.getVertices(j);
                int counter = 0;
                for (int k = 0; k < maker.getNumber(); k++) {
                    if(j == k)
                        continue;
                    Vertex vertex2 = maker.getVertices(k);
                    evkDist = evkDistance(vertex1,vertex2);
                    if(maker.getMatrix(j,k) == 1){
                        double a = fSpring();
                        changeX = a * (vertex1.getX() - vertex2.getX());
                        changeY = a * (vertex1.getY() - vertex2.getY());
                        myVectors.add(new MyVector(vertex1.clone(),vertex2.clone()));
                        myVectors.get(counter).setVertex2XYValue( (vertex2.getX() + changeX),(vertex2.getY() + (changeY)));
                        counter++;
                    }
                    double a = fRep();
                    changeX = a * (vertex2.getX() - vertex1.getX());
                    changeY = a * (vertex2.getY() - vertex1.getY());
                    myVectors.add(new MyVector(vertex1.clone(),vertex2.clone()));
                    myVectors.get(counter).setVertex2XYValue( (vertex2.getX() + changeX), (vertex2.getY() + changeY));
                    counter++;
                }
                double length;
                for (int e = 0; e < myVectors.size()-1; e++) {
                    cosMaker( myVectors.get(e), myVectors.get(e+1));
                    System.out.println(cos);
                    double x1 = myVectors.get(e).getX(); double x2 = myVectors.get(e+1).getX(); double y1 = myVectors.get(e).getY(); double y2 = myVectors.get(e+1).getY();
                    length = Math.sqrt(Math.pow(myVectors.get(e).getLength(),2) +  Math.pow(myVectors.get(e+1).getLength(),2) +
                            (2*myVectors.get(e).getLength()* myVectors.get(e+1).getLength())*cos);
                    System.out.println("j " + j + "  i " + i + "  =  " + length);
                }
            }
        }
    }
    public double ribLength(int area, int vertexNumber){
        return Math.sqrt(area/ vertexNumber);
    }
    public double evkDistance(Vertex vertex1, Vertex vertex2){
        return  Math.sqrt(Math.pow(vertex1.getX() - vertex2.getX(), 2) + Math.pow(vertex1.getY() - vertex2.getY(),2));
    }
    private double fSpring(){
        if(lengthRib !=0)
            return Math.pow(evkDist,2)/ lengthRib;
        else return -200;
    }
    private double fRep(){
        if(evkDist!=0)
            return Math.pow(lengthRib,2)/ evkDist;
        else return -100;
    }
    public void cosMaker(MyVector myVector1, MyVector myVector2){
        double a = ((myVector1.getX() * myVector2.getX()) + (myVector1.getY() * myVector2.getY()));
        double b = Math.sqrt(Math.pow(myVector1.getX(),2) + Math.pow(myVector1.getY(),2)) * Math.sqrt(Math.pow(myVector2.getX(),2)+Math.pow(myVector2.getY(),2));
        cos = a /b;

        cos = Math.acos(cos);
    }
}
