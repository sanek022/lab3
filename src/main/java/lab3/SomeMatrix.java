package lab3;

import java.util.ArrayList;

public abstract class SomeMatrix implements IMatrix {
    private int colsCount, rowsCount;
    ArrayList<Integer> list;
    protected IVector[] vectors;
    IDrawer drawer;
    protected void drawBorder(int row, int col, int rowCount)
    {
        drawer.drawBorder(row, col, rowCount);
    }

    protected void drawValues(int val, int row, int col, int rowsCount)
    {
       drawer.drawValues(val, row, col, rowsCount);
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
    public void change(){
        list = new ArrayList<>();
        ColChangerDecorator colChangerDecorator = new ColChangerDecorator(this);
        RawChangerDecorator rawChangerDecorator = new RawChangerDecorator(colChangerDecorator);
        list.add(colChangerDecorator.getCol1());list.add(colChangerDecorator.getCol2());
        list.add(rawChangerDecorator.getRow1());list.add(rawChangerDecorator.getRow2());
    }

    public void back(){
        new ColChangerDecorator(new RawChangerDecorator(this, list.get(2), list.get(3)),
                list.get(0), list.get(1));
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
    public SparseMatrix(int rows, int cols, IDrawer drawer){
        super(rows, cols, drawer);
    }
    public SparseMatrix(IDrawer drawer)  { super(drawer);}
    public IVector create(int size) {return new SparseVector(size);}

}

