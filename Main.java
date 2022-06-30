import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {

    public Main(){
        setUpFrame();
    }

    public void setUpFrame(){
        JFrame f = new JFrame("PID Simulator");
        f.setIconImage(new ImageIcon("images/image.png").getImage());
        f.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        f.setLayout(null);
        
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}