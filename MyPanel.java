import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MyPanel extends JPanel {

    public MyPanel(){

    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        drawGrid(g2d);
    }

    public void drawGrid(Graphics2D g2d){

         //X-axis
         for (int x = 1; x <= Constants.GRID_LINES_X; x++){
            g2d.drawLine(x*Constants.SPACE, 0, x*Constants.SPACE, Constants.GRID_HEIGHT);
        }

        //Y-axis
        for (int x = 1; x <= Constants.GRID_LINES_Y; x++){
            g2d.drawLine(0, x*Constants.SPACE, Constants.GRID_WIDTH, x*Constants.SPACE);
        }
    }
}