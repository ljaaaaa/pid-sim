import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
        public Graph graphPanel;
        public Motor motor;

        public Main(){
                motor = new Motor();
                graphPanel = new Graph();
                setUpFrame();
                pid();
        }

        //Simulates PID
        public void pid(){
		int numPoints = (int) (Constants.GRID_WIDTH / (Constants.SPACE / Constants.PASS_TIME));
                for (int x = 0; x < numPoints; x++){
                	double time = Math.round(x * Constants.PASS_TIME * 100.0) / 100.0; //Increase time and round

			motor.updatePosition(motor.getPosition() + motor.getOutput());//Add output to position

			graphPanel.points.add(new MyPoint(time, motor.getPosition())); //Add new time and output to graph
                }
                graphPanel.repaint();
        }

        public void setUpFrame(){
                JFrame f = new JFrame("PID Simulator");
                f.setIconImage(new ImageIcon("images/image.png").getImage());
                f.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
                f.setLayout(null);
                
                f.add(graphPanel);
                graphPanel.setBounds(0, 0, Constants.GRID_WIDTH+25, Constants.GRID_HEIGHT+25);

                f.setLocationRelativeTo(null);
                f.setResizable(false);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
        }
}
