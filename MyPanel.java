import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

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

        //X-axis (up/down)
        for (int x = 0; x < Constants.GRID_LINES_X; x++){
            g2d.drawLine(x*Constants.SPACE+100, 0, x*Constants.SPACE+100, Constants.GRID_HEIGHT);
        }

        //Y-axis (left/right)
        for (int x = 1; x <= Constants.GRID_LINES_Y; x++){
            g2d.drawLine(0+100, x*Constants.SPACE, Constants.GRID_WIDTH+100, x*Constants.SPACE);
        }

        //Time & Motor Output
        g2d.drawString("Time", 0, Constants.GRID_HEIGHT+15);

        g2d.rotate(Math.toRadians(90));
        g2d.drawString("Motor Ouput",0,0);
        g2d.rotate(-Math.toRadians(90));
    }
}