package graph;

public class Vertex implements Cloneable {
    private double x;
    private double y;
    private int number;
    public Vertex(int number,double x, double y){
        this.x = x;
        this.y = y;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "x=" + x +
                ", y=" + y +
                ", number=" + number +
                '}';
    }

    public Vertex(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public Vertex clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return (Vertex) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
