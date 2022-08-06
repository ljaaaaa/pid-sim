import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class Main {
	//Car with variables
	public Car car;

	//Position vs. time graph
	public GraphPanel stPanel;
	
	//Speed vs. time graph
	public GraphPanel vtPanel;

	//Acceleration vs. time graph
	public GraphPanel atPanel;

	//Side panel with options
        public SidePanel sidePanel;

	//Main panel with all graphs and side panel
	public JPanel mainPanel;

	public Main(){
		//Set var
		car = new Car();
                
		//Set panels
		stPanel = new GraphPanel("Time", "Position", car);
		vtPanel = new GraphPanel("Time", "Speed", car);
		atPanel = new GraphPanel("Time", "Acceleration", car);
		mainPanel = new JPanel();
		sidePanel = new SidePanel(this, car);

		//Set up GUI frame
                setUpFrame();
        }

	public void moveCar(){
		//Number of points in each square
		double pDiv = 10;
		
		//Reset points
		resetAllPoints();
		car.reset();

		//Set graph points
		for (int x = 0; x < (pDiv/Constants.SPACE)*stPanel.getWidth(); x++){
			car.passTime();
			stPanel.points.add(new MyPoint(x/pDiv, car.s));
			vtPanel.points.add(new MyPoint(x/pDiv, car.v));
			atPanel.points.add(new MyPoint(x/pDiv, car.a));
		}

		//Paint results
		paintPanels();
	}

        public void setUpFrame(){
                JFrame f = new JFrame("PID Simulator");
                f.setIconImage(new ImageIcon("images/icon_image.png").getImage());
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

                f.setLocationRelativeTo(null);
		f.setMinimumSize(new Dimension(600, 400));
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
        }

        //Reset points graphs
        public void resetAllPoints(){
                stPanel.resetPoints();
                vtPanel.resetPoints();
                atPanel.resetPoints();
        }
}
