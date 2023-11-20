package lab3;

public interface IMatrix {
    public void draw();
    public int getColsCount();
    public int getRowsCount();

    public int getElementFromVector(int row, int col);
    public void setElementInVector(int row, int col, int value);

}
