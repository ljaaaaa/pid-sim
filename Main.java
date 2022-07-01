import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {

    MyPanel panel;
    MyTime time;

    public Main(){
        time = new MyTime();
        panel = new MyPanel();
        setUpFrame();
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