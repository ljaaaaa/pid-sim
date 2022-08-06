import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Main {
	public Car car;

	public GraphPanel stPanel; //Position vs. time
	public GraphPanel vtPanel; //Speed vs. time
	public GraphPanel atPanel; //Acceleration vs. time panel
	public CarPanel carPanel; //Car animation panel

	public JPanel mainPanel; //Main panel with graphs
	public SidePanel sidePanel; //Side panel

        public Main(){
                car = new Car();
                
		stPanel = new GraphPanel("Time", "Position", car);
		vtPanel = new GraphPanel("Time", "Speed", car);
		atPanel = new GraphPanel("Time", "Acceleration", car);
		carPanel = new CarPanel(car);

		mainPanel = new JPanel();
		sidePanel = new SidePanel(this, car);

                setUpFrame();
        }

	public void moveCar(){
		double pDiv = 10; //Number of points in each square
		
		//Reset points
		resetAllPoints();
		car.reset();

		for (int x = 0; x < (pDiv/Constants.SPACE)*stPanel.getWidth(); x++){
			car.passTime();
			stPanel.points.add(new MyPoint(x/pDiv, car.s));
			vtPanel.points.add(new MyPoint(x/pDiv, car.v));
			atPanel.points.add(new MyPoint(x/pDiv, car.a));
		}
		paintPanels();
	}

        public void setUpFrame(){
                JFrame f = new JFrame("PID Simulator");
                f.setIconImage(new ImageIcon("images/image.png").getImage());
                f.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
                
		//Set backgrounds
		mainPanel.setBackground(Constants.BLACK);
		f.getContentPane().setBackground(Constants.BLACK);

		//Set layouts
		mainPanel.setLayout(new GridLayout(2, 2, 5, 5));
		f.setLayout(new BorderLayout());
               
		//Add panels
                mainPanel.add(stPanel);
                mainPanel.add(vtPanel);
		mainPanel.add(atPanel);
		mainPanel.add(sidePanel);
		f.getContentPane().add(mainPanel, BorderLayout.CENTER);
		//f.getContentPane().add(sidePanel, BorderLayout.EAST);

                f.setLocationRelativeTo(null);
                f.setResizable(true);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);

		//Add window resize listener
		f.addComponentListener(new ComponentAdapter() {
    			public void componentResized(ComponentEvent componentEvent) {
				moveCar();
    			}
		});
        }

	//Paint all panels
        public void paintPanels(){
                stPanel.repaint();
                vtPanel.repaint();
                atPanel.repaint();
                carPanel.repaint();
        }

        //Reset points graphs
        public void resetAllPoints(){
                stPanel.resetPoints();
                vtPanel.resetPoints();
                atPanel.resetPoints();
        }
}
