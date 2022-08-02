import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.ArrayList;

public class MyPanel extends JPanel {
	int xtra = Constants.EXTRA;
        MyTime time;

        public MyPanel(MyTime time){
                this.time = time;
        }

        @Override
        protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D)g;

		g2d.setColor(Constants.GREY2);
		g2d.fillRect(0, 0, getWidth(), getHeight());

                drawGrid(g2d);
                drawPoints(g2d);
                connectPoints(g2d);
        }

        //Connect two points with a line
        public void connectPoints(Graphics2D g2d){
                g2d.setColor(Constants.POINT_COLOR);
                ArrayList<MyPoint> points = time.points;

                for (int x = 0; x < points.size()-1; x++){
                        double x1 = points.get(x).x*Constants.SPACE+xtra;
                        double y1 = Constants.GRID_HEIGHT-points.get(x).y*Constants.SPACE;
                        double x2 = points.get(x+1).x*Constants.SPACE+xtra;
                        double y2 = Constants.GRID_HEIGHT-points.get(x+1).y*Constants.SPACE;
                        g2d.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
                }
        }

        //Draw all points in time.points
        public void drawPoints(Graphics2D g2d){
                g2d.setColor(Constants.POINT_COLOR);
                ArrayList<MyPoint> points = time.points;

                for (int x = 0; x < points.size(); x++){
                        MyPoint point = points.get(x);
                        drawPoint(g2d, point.x*Constants.SPACE+xtra, Constants.GRID_HEIGHT-point.y*Constants.SPACE, 4);
		}
        }	

	//Draw point on center
        public void drawPoint(Graphics2D g2d, double x, double y, int r) {
                x = x-(r/2);
                y = y-(r/2);
                g2d.fillOval((int)x, (int)y, r, r);
        }

        //Draw initial grid base
        public void drawGrid(Graphics2D g2d){
       		//Time text
		g2d.setColor(Color.BLACK);
            	g2d.drawString("Time", xtra, Constants.GRID_HEIGHT+15);

            	//Motor Output text
            	g2d.rotate(Math.toRadians(270));
            	g2d.drawString("Motor Output", -Constants.GRID_HEIGHT, xtra-5);
            	g2d.rotate(-Math.toRadians(270));

            	g2d.setColor(Constants.GREY);

            	//X-axis (up/down)
            	for (int x = 0; x <= Constants.GRID_WIDTH; x+=Constants.SPACE){
            	        g2d.drawLine(x+xtra, 0, x+xtra, Constants.GRID_HEIGHT);
            	}	

		//Y-axis (left/right)
            	for (int x = Constants.GRID_HEIGHT; x >= 0; x-=Constants.SPACE){
          		g2d.drawLine(0+xtra, x, Constants.GRID_WIDTH+xtra, x);
		}

            	//Target position
            	g2d.setColor(Constants.TARGET_COLOR);
            	int target_line = (int)((((double)Constants.GRID_HEIGHT/Constants.SPACE)-Constants.TARGET)*Constants.SPACE);
            	g2d.drawLine(0+xtra, target_line, Constants.GRID_WIDTH+xtra, target_line);
        }
}
