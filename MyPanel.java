import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class MyPanel extends JPanel {

    MyTime time;

    public MyPanel(MyTime time){
        this.time = time;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        drawGrid(g2d);
        drawPoints(g2d);
    }

    public void drawPoints(Graphics2D g2d){
        int xtra = Constants.EXTRA;
        g2d.setColor(new Color(255, 0, 0));

        for (int x = 0; x < time.points.size(); x++){
            MyPoint point = time.points.get(x);
            drawPoint(g2d, point.x*Constants.SPACE+xtra, point.y*Constants.SPACE, 4);
        }
    }

    //Draw point center
    public void drawPoint(Graphics2D g2d, int x, int y, int r) {
        x = x-(r/2);
        y = y-(r/2);
        g2d.fillOval(x, y, r, r);
      }

    //Draw initial grid base
    public void drawGrid(Graphics2D g2d){
        int xtra = Constants.EXTRA;
        
        //Time
        g2d.drawString("Time", xtra, Constants.GRID_HEIGHT+15);

        //Motor Output
        g2d.rotate(Math.toRadians(270));
        g2d.drawString("Motor Ouput", -Constants.GRID_HEIGHT, xtra-5);
        g2d.rotate(-Math.toRadians(270));

        //Graph
        g2d.setColor(new Color(200, 200, 200));

        //X-axis (up/down)
        for (int x = 0; x < Constants.GRID_WIDTH; x+=Constants.SPACE){
            g2d.drawLine(x+xtra, 0, x+xtra, Constants.GRID_HEIGHT);
        }

        //Y-axis (left/right)
        for (int x = Constants.SPACE; x <= Constants.GRID_HEIGHT; x+=Constants.SPACE){
            g2d.drawLine(0+xtra, x, Constants.GRID_WIDTH+xtra, x);
        }
    }
}