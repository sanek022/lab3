package lab3;

public class ConsoleDraw  implements IDrawer {
    public ConsoleDraw(){
        System.out.println();
        System.out.println();
    }

    @Override
    public void drawBorder( int row, int col, int rowCount) {
        System.out.print("|");
        if(col == 0 && row !=0){
            System.out.println();
            System.out.print("|");
        }

    }

    @Override
    public void drawValues(int val, int row, int col, int rowCount) {
        if(DrawPlace.getSpMatrix() && (val == 0)){
            System.out.print(String.format("%3s ", " "));
        }else {
            System.out.print(String.format("%3d ", val));
        }
        if (!DrawPlace.lineIsSelected() && (rowCount - 1 == col)) {
            System.out.println();
        }
        if(col == rowCount-1 && row == rowCount-1)
            System.out.println();
    }

}


