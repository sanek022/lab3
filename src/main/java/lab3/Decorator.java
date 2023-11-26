package lab3;

import java.util.ArrayList;

public abstract class Decorator implements IMatrix {
    IMatrix matrix;
    ArrayList <Integer>list = new ArrayList<>();
    public Decorator(IMatrix matrix){
        this.matrix = matrix;
    }
    @Override
    public void draw() {
        matrix.draw();
    }

    @Override
    public int getColsCount() {
        return matrix.getColsCount();
    }

    @Override
    public int getRowsCount() {
        return matrix.getRowsCount();
    }

    @Override
    public int getElementFromVector(int row, int col) {
        return matrix.getElementFromVector(row, col);
    }

    @Override
    public void setElementInVector(int row, int col, int value) {
        matrix.setElementInVector(row, col, value);
    }

    public void change(){
        /*ColChangerDecorator colChangerDecorator = new ColChangerDecorator(matrix);
        RawChangerDecorator rawChangerDecorator = new RawChangerDecorator(colChangerDecorator);
        list.add(colChangerDecorator.getCol1());list.add(colChangerDecorator.getCol2());
        list.add(rawChangerDecorator.getRow1());list.add(rawChangerDecorator.getRow2());*/
        matrix.change();

    }

    public void back(){
        /*new ColChangerDecorator(new RawChangerDecorator(matrix, list.get(2), list.get(3)),
                list.get(0), list.get(1));*/
        matrix.back();
    }
}
