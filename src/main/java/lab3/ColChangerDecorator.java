package lab3;

import java.util.ArrayList;
import java.util.Random;

public class ColChangerDecorator extends Decorator{
    int col1;
    int col2 = 0;

    public int getCol1() {
        return col1;
    }

    public int getCol2() {
        return col2;
    }

    public ColChangerDecorator(IMatrix matrix) {
        super(matrix);
        Random random = new Random();
        col1 = random.nextInt(matrix.getColsCount()-1);
        while (col1 == col2){
            col2 = random.nextInt(matrix.getColsCount()-1);
        }
        ArrayList<Integer> col1List = new ArrayList<>();
        for (int i = 0; i < matrix.getColsCount(); i++) {
            col1List.add(matrix.getElementFromVector(i,col1));
            matrix.setElementInVector(i,col1,matrix.getElementFromVector(i,col2));
            matrix.setElementInVector(i,col2,col1List.get(i));
        }

    }
    public ColChangerDecorator(IMatrix matrix, int col1, int col2) {
        super(matrix);
        ArrayList<Integer> col1List = new ArrayList<>();
        for (int i = 0; i < matrix.getColsCount(); i++) {
            col1List.add(matrix.getElementFromVector(i,col1));
            matrix.setElementInVector(i,col1,matrix.getElementFromVector(i,col2));
            matrix.setElementInVector(i,col2,col1List.get(i));
        }
    }
}
