import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
        public GraphPanel graphPanel;
	public CarPanel carPanel;
        public Car car;

        public Main(){
                car = new Car();
                graphPanel = new GraphPanel();
		carPanel = new CarPanel(car);
                setUpFrame();
                moveCar();
        }

	public void moveCar(){
	
	} 

        public void setUpFrame(){
                JFrame f = new JFrame("PID Simulator");
                f.setIconImage(new ImageIcon("images/image.png").getImage());
                f.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
                f.setLayout(null);
                
                f.add(graphPanel);
                graphPanel.setBounds(0, 0, Constants.GRID_WIDTH+25, Constants.GRID_HEIGHT+25);

		f.add(carPanel);
		carPanel.setBounds(0, Constants.GRID_HEIGHT+25, Constants.CAR_WIDTH+25, Constants.CAR_HEIGHT+25);

                f.setLocationRelativeTo(null);
                f.setResizable(false);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
        }
}
