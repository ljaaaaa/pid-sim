import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class Main {
	public CarPanel carPanel;
        public Car car;

	public GraphPanel stPanel; //Position vs. time
	public GraphPanel vtPanel; //Speed vs. time
	public GraphPanel atPanel; //Acceleration vs. time panel

        public Main(){
                car = new Car();
                stPanel = new GraphPanel("Time", "Position", car);
		vtPanel = new GraphPanel("Time", "Speed", car);
		atPanel = new GraphPanel("Time", "Acceleration", car);
		carPanel = new CarPanel(car);
                setUpFrame();
                moveCar();
        }

	public void moveCar(){
		double pDiv = 10; //Number of points in each square
		System.out.println((pDiv/Constants.SPACE)*stPanel.getWidth());
		for (int x = 0; x < (pDiv/Constants.SPACE)*stPanel.getWidth(); x++){
			car.passTime();
			stPanel.points.add(new MyPoint(x/pDiv, car.s));
			vtPanel.points.add(new MyPoint(x/pDiv, car.v));
			atPanel.points.add(new MyPoint(x/pDiv, car.a));
		}

		paintPanels();
	}

	public void paintPanels(){
		stPanel.repaint();
		vtPanel.repaint();
		atPanel.repaint();
		carPanel.repaint();
	}

        public void setUpFrame(){
                JFrame f = new JFrame("PID Simulator");
                f.setIconImage(new ImageIcon("images/image.png").getImage());
                f.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
                f.getContentPane().setBackground(Constants.Colors.BLACK);
		f.setLayout(new GridLayout(2, 2, 5, 5));
                
                f.add(stPanel);
                f.add(vtPanel);
		f.add(atPanel);
		f.add(carPanel);

                f.setLocationRelativeTo(null);
                f.setResizable(true);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
        }
}
