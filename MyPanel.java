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
        int xtra = Constants.EXTRA;

        //X-axis (up/down)
        for (int x = 0; x < Constants.GRID_LINES_X; x++){
            g2d.drawLine(x*Constants.SPACE+xtra, 0, x*Constants.SPACE+xtra, Constants.GRID_HEIGHT);
        }

        //Y-axis (left/right)
        for (int x = 1; x <= Constants.GRID_LINES_Y; x++){
            g2d.drawLine(0+xtra, x*Constants.SPACE, Constants.GRID_WIDTH+xtra, x*Constants.SPACE);
        }

        //Time
        g2d.drawString("Time", xtra, Constants.GRID_HEIGHT+15);

        //Motor Output
        g2d.rotate(Math.toRadians(270));
        g2d.drawString("Motor Ouput", -Constants.GRID_HEIGHT, xtra-5);
        g2d.rotate(-Math.toRadians(270));
    }
}