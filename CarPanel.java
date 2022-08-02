import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.ArrayList;

public class CarPanel extends JPanel {
	public Car car;

	public CarPanel(Car car){
                this.car = car;
        }

        @Override
        protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D)g;

                //Draw background
                g2d.setColor(Constants.POINT_COLOR);
                g2d.fillRect(0, 0, getWidth(), getHeight());
       }

	public void drawCar(Graphics2D g2d){
		
	}
}
