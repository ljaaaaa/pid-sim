import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.ArrayList;

public class CarPanel extends JPanel {
	public Car car;

	//Ground level
	public int groundLevel;

	//Car sizes
	public int carWidth = 150;
	public int carHeight = 100;
	public int wheelDi = 40;

	public CarPanel(Car car){
                this.car = car;
        }

        @Override
        protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D)g;
		groundLevel = getHeight()/2;
		drawGround(g2d);
		drawCar(g2d);
	}

	public void drawGround(Graphics2D g2d){
		g2d.setColor(Constants.Colors.GREY_HIGH);
		g2d.fillRect(0, groundLevel, getWidth(), getHeight()-groundLevel);
	}

	public void drawCar(Graphics2D g2d){
		//Box
		g2d.setColor(Color.RED);
		g2d.fillRect((int)(car.s - carWidth), groundLevel - carHeight, carWidth, carHeight);
	
		//Wheels
		g2d.setColor(Constants.Colors.GREY_MED);
		g2d.fillOval((int)(car.s - carWidth)+(carWidth/10), groundLevel-(wheelDi/2), wheelDi, wheelDi);
		g2d.fillOval((int)(car.s - wheelDi)-(carWidth/10), groundLevel-(wheelDi/2), wheelDi, wheelDi);
	}
}
