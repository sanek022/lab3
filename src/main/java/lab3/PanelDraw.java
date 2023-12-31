package lab3;

import javax.swing.*;
import java.util.ArrayList;

public class PanelDraw implements IDrawer {
    private static int changer = 5;
    private int counter = 0;
    private int bCounter = 0;
    private ArrayList<JLabel> valueLabels = new ArrayList<>();
    private ArrayList<JLabel> borderLabels = new ArrayList<>();
    static MatrixPanel matrixPanel = new MatrixPanel();

    public static MatrixPanel getMatrixPanel() {
        return matrixPanel;
    }

    public PanelDraw(){
      DrawPlace.panelMaker(matrixPanel);
      PanelDraw.getMatrixPanel().removeAll();
    }
    public static int getChanger(){
        return changer;
    }

    @Override
    public void drawBorder(int row, int col, int rowCount) {
        borderLabels.add(new JLabel("|"));
        borderLabels.add(new JLabel("|"));
        borderLabels.get(bCounter*2).setBounds(100+col*10*changer+ 2*col,(200+row*12),4,10);
        borderLabels.get(bCounter*2+1).setBounds
                (100+col*10*changer+ 2*col + 70,(200+row*12),4,10);
        matrixPanel.add(borderLabels.get(bCounter*2));
        matrixPanel.add(borderLabels.get(bCounter*2 + 1));
        bCounter++;
        matrixPanel.repaint();
    }

    @Override
    public void drawValues(int val, int row, int col, int rowCount) {
        if(DrawPlace.getSpMatrix() && (val == 0)){
            valueLabels.add(new JLabel( "   "));
        }else {
            valueLabels.add(new JLabel(String.valueOf(val)));
        }
        valueLabels.get(counter).setBounds
                (100 + col * 11 * changer + 25, (200 + row * 12), 50, 10);

        matrixPanel.add(valueLabels.get(counter));
        counter++;
        matrixPanel.repaint();
    }
}
class MatrixPanel extends JPanel{

}