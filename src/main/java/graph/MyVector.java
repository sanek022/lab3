package graph;

public class MyVector {
    Vertex vertex1;
    Vertex vertex2;
    private double x;
    private double length;
    private double y;

    public double getLength() {
        return length;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }



    @Override
    public String toString() {
        return "Rib{" +
                "vertex1=" + vertex1 +
                ", vertex2=" + vertex2 +
                '}';
    }

    public MyVector(Vertex vertex1, Vertex vertex2){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        x = vertex2.getX() - vertex1.getX();
        y = vertex2.getY() - vertex1.getY();
        length =  Math.sqrt((x*x) + (y*y));
    }
    public MyVector(){

    }
    public void coordinates(){
        x = vertex2.getX() - vertex1.getX();
        y = vertex2.getY() - vertex1.getY();
        length =  Math.sqrt((x*x) + (y*y));
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
    public void setVertex2XYValue(double value1, double value2) {
        vertex2.setX(value1);
        vertex2.setY(value2);
        coordinates();
    }

    public void setVertex2(Vertex vertex2) {
        this.vertex2 = vertex2;
    }
}
