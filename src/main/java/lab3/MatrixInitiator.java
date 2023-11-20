package lab3;

import java.util.Random;

public  class MatrixInitiator {
    public static void FillMatrix(IMatrix matrix, int nonZeroCount, int maxValue) throws Exception {
        Random rnd = new Random();
        int curCount = 0;
        if (nonZeroCount > matrix.getRowsCount() * matrix.getColsCount())
        {
            throw new Exception("Число элементов больше числа элементов в матрице!");
        }
        for (int i = 0; i < matrix.getRowsCount(); i++)
        {
            for (int j = 0; j < matrix.getColsCount(); j++)
            {
                curCount++;
                if (curCount > nonZeroCount) { return; }
                matrix.setElementInVector(i,j,rnd.nextInt( maxValue-1)+1);
            }
        }
    }
}
