import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Main {
	public CarPanel carPanel;
        public Car car;

	public GraphPanel stPanel; //Position vs. time
	public GraphPanel vtPanel; //Speed vs. time
	public GraphPanel atPanel; //Acceleration vs. time panel

	public JPanel mainPanel;
	public JPanel sidePanel;

        public Main(){
                car = new Car();
                
		stPanel = new GraphPanel("Time", "Position", car);
		vtPanel = new GraphPanel("Time", "Speed", car);
		atPanel = new GraphPanel("Time", "Acceleration", car);
		carPanel = new CarPanel(car);

		mainPanel = new JPanel();
		sidePanel = new JPanel();

                setUpFrame();
                moveCar();
        }

	public void moveCar(){
		double pDiv = 10; //Number of points in each square
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
                
		//Set backgrounds
		mainPanel.setBackground(Constants.Colors.BLACK);
		sidePanel.setBackground(Constants.Colors.BLACK);
		f.getContentPane().setBackground(Constants.Colors.BLACK);

		//Set layouts
		mainPanel.setLayout(new GridLayout(2, 2, 5, 5));
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		f.setLayout(new BorderLayout());
               
		sidePanel.add(new JButton("Click me!"));
		sidePanel.add(new JButton("Click me!"));
		sidePanel.add(new JButton("Click me!"));
		sidePanel.add(new JButton("Click me!"));
		sidePanel.add(new JButton("Click me!"));
		
		//Add panels
                mainPanel.add(stPanel);
                mainPanel.add(vtPanel);
		mainPanel.add(atPanel);
		mainPanel.add(carPanel);
		f.getContentPane().add(mainPanel, BorderLayout.CENTER);
		f.getContentPane().add(sidePanel, BorderLayout.EAST);

                f.setLocationRelativeTo(null);
                f.setResizable(true);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
        }
}
