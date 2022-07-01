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
        int spacing = Constants.SCREEN_WIDTH/Constants.GRID_SIZE;

        for (int x = 0; x < Constants.GRID_SIZE; x++){

            //X-axis
            g2d.drawLine((x+1)*spacing, 0, (x+1)*spacing, Constants.SCREEN_HEIGHT);

            //Y-axis
            g2d.drawLine(0, (x+1)*spacing, Constants.SCREEN_WIDTH, (x+1)*spacing);
        }

    }
}