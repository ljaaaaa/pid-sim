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
        f.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        f.setLayout(null);
        
        f.add(panel);
        panel.setBounds(50, 50, Constants.GRID_WIDTH, Constants.GRID_HEIGHT+1);

        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}