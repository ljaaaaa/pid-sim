import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {

    MyPanel panel = new MyPanel();

    public Main(){
        setUpFrame();
    }

    public void setUpFrame(){
        JFrame f = new JFrame("PID Simulator");
        f.setIconImage(new ImageIcon("images/image.png").getImage());
        f.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        f.setLayout(null);
        
        f.add(panel);
        panel.setBounds(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}