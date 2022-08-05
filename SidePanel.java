import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SidePanel extends JPanel implements ActionListener{
	//Reference to car
	public Car car; 
	
	//Fields for car physics values
	public JTextField tField = new JTextField(10);
        public JTextField vField = new JTextField(10);
       	public JTextField sField = new JTextField(10);
        public JTextField aField = new JTextField(10);

	//Field for car PID values
        public JTextField pField = new JTextField(10);
        public JTextField iField = new JTextField(10);
        public JTextField dField = new JTextField(10);

	public SidePanel(Car car){
		//Set layout
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//Set reference to car
		this.car = car;

		//Add fields to sidepanel in order
		
		add(new JLabel("t"));
		add(tField);

		add(new JLabel("v"));
		add(vField);

		add(new JLabel("s"));
		add(sField);

		add(new JLabel("a"));
		add(aField);

		add(new JLabel("p"));
		add(pField);

		add(new JLabel("i"));
		add(iField);

		add(new JLabel("d"));
		add(dField);
	}

	@Override
        public void actionPerformed(ActionEvent e) {

		//switch (e.get

        }
}
