package lab3;

import java.util.ArrayList;
import java.util.Random;

public class RawChangerDecorator extends Decorator{
    private int row1;
    private int row2 = 0;
    public RawChangerDecorator(IMatrix matrix) {
        super(matrix);
        Random random = new Random();
        row1 = random.nextInt(matrix.getColsCount()-1);
        while (row1 == row2){
            row2 = random.nextInt(matrix.getColsCount()-1);
        }
        ArrayList<Integer> row1List = new ArrayList<>();
        for (int i = 0; i < matrix.getColsCount(); i++) {
            row1List.add(matrix.getElementFromVector(row1,i));
            matrix.setElementInVector(row1,i,matrix.getElementFromVector(row2,i));
            matrix.setElementInVector(row2,i,row1List.get(i));
        }
    }

    public int getRow1() {
        return row1;
    }

    public int getRow2() {
        return row2;
    }

    public RawChangerDecorator(IMatrix matrix, int row1, int row2) {
        super(matrix);
        ArrayList<Integer> row1List = new ArrayList<>();
        for (int i = 0; i < matrix.getColsCount(); i++) {
            row1List.add(matrix.getElementFromVector(row1,i));
            matrix.setElementInVector(row1,i,matrix.getElementFromVector(row2,i));
            matrix.setElementInVector(row2,i,row1List.get(i));
        }
    }
    /*public void change(){
        Random random = new Random();
        row1 = random.nextInt(matrix.getColsCount()-1);
        while (row1 == row2){
            row2 = random.nextInt(matrix.getColsCount()-1);
        }
        ArrayList<Integer> row1List = new ArrayList<>();
        for (int i = 0; i < matrix.getColsCount(); i++) {
            row1List.add(matrix.getElementFromVector(row1,i));
            matrix.setElementInVector(row1,i,matrix.getElementFromVector(row2,i));
            matrix.setElementInVector(row2,i,row1List.get(i));
        }
    }
    public void back() {
        ArrayList<Integer> row1List = new ArrayList<>();
        for (int i = 0; i < matrix.getColsCount(); i++) {
            row1List.add(matrix.getElementFromVector(row1, i));
            matrix.setElementInVector(row1, i, matrix.getElementFromVector(row2, i));
            matrix.setElementInVector(row2, i, row1List.get(i));
        }
    }*/
}
