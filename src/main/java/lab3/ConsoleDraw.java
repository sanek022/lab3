package lab3;

public class ConsoleDraw  implements IDrawer {
    public ConsoleDraw(){
        System.out.println();
        System.out.println();
    }

    @Override
    public void drawBorder( int n, int m, int rowCount) {
        System.out.print("|");
        if(m == 0 && n !=0){
            System.out.println();
            System.out.print("|");
        }
    }

    @Override
    public void drawValues(int val, int n, int m, int rowCount) {
        if(DrawPlace.getSpMatrix() && (val == 0)){
            System.out.print(String.format("%3s ", " "));
        }else {
            System.out.print(String.format("%3d ", val));
            if (!DrawPlace.lineIsSelected()) {
                if (rowCount - 1 == m)
                    System.out.println();
            }
        }
    }

}


