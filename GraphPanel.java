import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.ArrayList;

public class GraphPanel extends JPanel {
	int xtra;
	public ArrayList<MyPoint> points;

        public GraphPanel(){
        	points = new ArrayList<>();
        	xtra = 20; //Space for text
	}

        @Override
        protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D)g;
		
		//Draw background
		g2d.setColor(Constants.Colors.GREY_MED);
		g2d.fillRect(0, 0, getWidth(), getHeight());

		//Grid and points
                drawGrid(g2d);
                drawPoints(g2d);
                connectPoints(g2d);
        }

        //Connect two points with a line
        public void connectPoints(Graphics2D g2d){
                g2d.setColor(Constants.Colors.POINT);

                for (int x = 0; x < points.size()-1; x++){
                        double x1 = points.get(x).x * Constants.SPACE + xtra;
                        double y1 = getHeight() - points.get(x).y * Constants.SPACE;
                        double x2 = points.get(x+1).x * Constants.SPACE + xtra;
                        double y2 = getHeight() - points.get(x+1).y * Constants.SPACE;
                        g2d.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
                }
        }

        //Draw all points in time.points
        public void drawPoints(Graphics2D g2d){
                g2d.setColor(Constants.Colors.POINT);
                
                for (int x = 0; x < points.size(); x++){
                        MyPoint point = points.get(x);
                        drawPoint(g2d, point.x * Constants.SPACE+xtra, getHeight() - point.y * Constants.SPACE, 4);
		}
        }	

	//Draw point on center
        public void drawPoint(Graphics2D g2d, double x, double y, int r) {
                g2d.fillOval((int)(x - r / 2), (int)(y - r / 2), r, r);
        }

        //Draw initial grid base
        public void drawGrid(Graphics2D g2d){
       		//Time text
		g2d.setColor(Color.BLACK);
            	g2d.drawString("Time", xtra, getHeight()-5);

            	//Motor Output text
            	g2d.rotate(Math.toRadians(270));
            	g2d.drawString("Acceleration", -getHeight()+xtra, xtra-5);
            	g2d.rotate(-Math.toRadians(270));

            	g2d.setColor(Constants.Colors.GREY_LOW);

            	//X-axis (up/down)
            	for (int x = 0; x <= getWidth(); x+=Constants.SPACE){
            	        g2d.drawLine(x+xtra, 0, x+xtra, getHeight()-xtra);
            	}	

		//Y-axis (left/right)
            	for (int x = getHeight()-xtra; x >= 0; x-=Constants.SPACE){
          		g2d.drawLine(0+xtra, x, getWidth() +xtra, x);
		}

            	//Target position
            	int target_line = (int)((((double)getHeight()/Constants.SPACE)-Constants.TARGET)*Constants.SPACE);
            	
		g2d.setColor(Constants.Colors.TARGET);
		g2d.drawLine(0+xtra, target_line-xtra, getWidth() + xtra, target_line-xtra);
        }
}
