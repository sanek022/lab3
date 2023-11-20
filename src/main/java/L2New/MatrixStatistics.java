package L2New;

public class MatrixStatistics {
    IMatrix matrix;
    public MatrixStatistics(IMatrix matrix)
    {
        this.matrix = matrix;
    }
    public void showMatrix()
    {
        System.out.print("Матрица:");
        System.out.print("\n");
        for (int i = 0; i < matrix.getRowsCount(); i++) {
            for (int j = 0; j < matrix.getColsCount(); j++) {
                System.out.print(matrix.getElementFromVector(i,j) + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    public int sumValues()
    {
        int sum = 0;
        for (int i = 0; i < matrix.getRowsCount(); i++)
        {
            for (int j = 0; j < matrix.getColsCount(); j++)
            {
                sum += matrix.getElementFromVector(i,j);
            }
        }
        return sum;
    }
    public double avgValue()
    {
        int sum = 0;
        for (int i = 0; i < matrix.getRowsCount(); i++)
        {
            for (int j = 0; j < matrix.getColsCount(); j++)
            {
                sum += matrix.getElementFromVector(i,j);
            }
        }
        return sum/matrix.getRowsCount()*matrix.getColsCount();
    }
    public int maxValue()
    {
        int max = 0;
        for (int i = 0; i < matrix.getRowsCount(); i++)
        {
            for (int j = 0; j < matrix.getColsCount(); j++)
            {
                if(matrix.getElementFromVector(i,j) > max)
                {
                    max = matrix.getElementFromVector(i,j);
                }
            }
        }
        return max;
    }
    public int nonZeroCount()
    {
        int count = 0;
        for (int i = 0; i < matrix.getRowsCount(); i++)
        {
            for (int j = 0; j < matrix.getColsCount(); j++)
            {
                if (matrix.getElementFromVector(i,j) != 0)
                {
                    count++;
                }
            }
        }
        return count;
    }
    public void fullStat(){
        System.out.println("Макс. начение: " + maxValue());
        System.out.println("Сумма всех элементов: " + sumValues());
        System.out.println("Среднее арифметическое по элементам: " + avgValue());
        System.out.println("Число ненулевых элементов: " + nonZeroCount());
    }
}
