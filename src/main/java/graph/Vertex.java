package graph;

public class Vertex {
    private int x;
    private int y;
    private int number;
    public Vertex(int number,int x, int y){
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

    public Vertex(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
