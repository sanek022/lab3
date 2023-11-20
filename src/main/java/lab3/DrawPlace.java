package lab3;

import javax.swing.*;
import java.awt.*;

public class DrawPlace {
    private static final JFrame frame = new JFrame("Matrix");
    private static JCheckBox lineCheckBox = new JCheckBox("Draw line");
    private static JCheckBox consoleCheck = new JCheckBox("Console");
    private static JCheckBox panelCheck = new JCheckBox("Panel");
    private static JButton regMatrix = new JButton("RegMatrix");
    private static JButton spMatrix = new JButton("SpMatrix");
    private static JButton changeMatrix = new JButton("Change");
    private static JButton backMatrix = new JButton("Back");
    private static boolean sp = false;


    DrawPlace(){
        frame.setSize(500,600);
        regMatrix.setBounds(10,30,100,30);
        spMatrix.setBounds(10,70,100,30);
        backMatrix.setBounds(130,30,100,30);
        changeMatrix.setBounds(130,70,100,30);
        lineCheckBox.setBounds(10,110,100,30);
        consoleCheck.setBounds(150,110,100,30);
        panelCheck.setBounds(300,110,100,30);
        frame.setLayout(null);
        frame.add(regMatrix); frame.add(spMatrix);frame.add(changeMatrix);frame.add(backMatrix);
        frame.add(lineCheckBox);frame.add(consoleCheck);frame.add(panelCheck);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        IMatrix matrixAll;
        regMatrix.addActionListener(a -> {
            sp = false;
            if(consoleCheck.isSelected()){
                IDrawer drawer = new ConsoleDraw();
                IMatrix matrix = new RegularMatrix(5,5,drawer);
                try {
                    MatrixInitiator.FillMatrix(matrix, 17,20);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                matrix.draw();
                changeMatrix.addActionListener(b->{
                    new ColChangerDecorator(new RawChangerDecorator(matrix, 0,2), 1,3);
                    System.out.println();
                    matrix.draw();
                });

            }
            if(panelCheck.isSelected()){
                IDrawer drawer1 = new PanelDraw();
                IMatrix matrix1 = new RegularMatrix(5,5,drawer1);
                try {
                    MatrixInitiator.FillMatrix(matrix1, 17,20);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                matrix1.draw();
            }
        });
        spMatrix.addActionListener(a -> {
            sp = true;
            if(consoleCheck.isSelected()){
                IDrawer drawer = new ConsoleDraw();
                IMatrix matrix = new SparseMatrix(5,5,drawer);
                try {
                    MatrixInitiator.FillMatrix(matrix, 17,20);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                matrix.draw();
            }
            if(panelCheck.isSelected()){
                IDrawer drawer1 = new PanelDraw();
                IMatrix matrix1 = new SparseMatrix(5,5,drawer1);
                try {
                    MatrixInitiator.FillMatrix(matrix1, 17,20);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                matrix1.draw();
            }
        });
    }

    public static boolean lineIsSelected(){
        return lineCheckBox.isSelected();
    }

    public static boolean getRegMatrix() {
        return regMatrix.isSelected();
    }

    public  static boolean getSpMatrix() {
        return sp;
    }
    public static void panelMaker(JPanel jPanel){
        jPanel.setBackground(Color.GRAY);
        jPanel.setBounds(10,200,500,500);
        jPanel.setVisible(true);
        frame.add(jPanel);

    }
}


