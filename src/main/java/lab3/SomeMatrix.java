package lab3;

public abstract class SomeMatrix implements IMatrix {
    private int colsCount, rowsCount;
    protected IVector[] vectors;
    IDrawer drawer;
    protected void drawBorder(int n, int m, int rowCount)
    {
        drawer.drawBorder(n, m, rowCount);
    }

    protected void drawValues(int val, int n, int m, int rowsCount)
    {
       drawer.drawValues(val, n, m, rowsCount);
    }
    public void draw(){

        for (int i = 0; i < rowsCount; i++)
        {
            for (int j = 0; j < colsCount; j++)
            {
                if(DrawPlace.lineIsSelected()){
                    drawBorder( i, j, this.getRowsCount());
                }

                drawValues( this.getElementFromVector(i, j), i, j,this.getRowsCount());
            }
        }
    }
    public int getColsCount(){
        return colsCount;
    }
    public int getRowsCount(){
        return rowsCount;
    }

    public int getElementFromVector(int row, int col){
        return vectors[row].getValue(col);
    }
    public void setElementInVector(int row, int col, int value){
        vectors[row].setValue(col, value);
    }

    public SomeMatrix( IDrawer drawer){
        this.drawer = drawer;
    }
    public SomeMatrix(int rows, int cols)
    {
        this.colsCount = cols;
        this.rowsCount = rows;
        vectors = new IVector[rows];
        for (int i = 0; i < rows; i++)
        {
            vectors[i]= create(cols);
        }
    }
    public SomeMatrix(int rows, int cols, IDrawer drawer)
    {
        this.colsCount = cols;
        this.rowsCount = rows;
        this.drawer = drawer;
        vectors = new IVector[rows];
        for (int i = 0; i < rows; i++)
        {
            vectors[i]= create(cols);
        }
    }
    public abstract IVector create(int size);
}
class RegularMatrix extends SomeMatrix {
    public RegularMatrix(int rows, int cols)  {super(rows, cols); }
    public RegularMatrix( IDrawer drawer)  {super( drawer); }
    public RegularMatrix(int rows, int cols, IDrawer drawer){super(rows, cols, drawer);}
    public IVector create(int size){ return new RegularVector(size);}


}
class SparseMatrix extends SomeMatrix {

    public SparseMatrix(int rows, int cols)  { super(rows, cols);}
    public SparseMatrix(int rows, int cols, IDrawer drawer){super(rows, cols, drawer);}
    public SparseMatrix(IDrawer drawer)  { super(drawer);}
    public IVector create(int size) {return new SparseVector(size);}
}

