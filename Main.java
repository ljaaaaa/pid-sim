import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
    public MyPanel panel;
    public MyTime time;
    public Motor motor;

    public Main(){
        motor = new Motor();
        time = new MyTime(motor);
        panel = new MyPanel(time);
        setUpFrame();
        pid();
    }

    //Simulates PID
    public void pid(){
        for (int x = 0; x < Constants.TIME; x++){
            time.passTime(Constants.PASS_TIME);
            System.out.println(motor.getPosition());
        }
        panel.repaint();
    }

    public void setUpFrame(){
        JFrame f = new JFrame("PID Simulator");
        f.setIconImage(new ImageIcon("images/image.png").getImage());
        f.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        f.setLayout(null);
        
        f.add(panel);
        panel.setBounds(Constants.EXTRA, 0, Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);

        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
