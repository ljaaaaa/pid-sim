import javax.swing.JPanel;
import javax.swing.JTextField;
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
		add(tField);
		add(vField);
		add(sField);
		add(aField);

		add(pField);
		add(iField);
		add(dField);
	}

	@Override
        public void actionPerformed(ActionEvent e) {

		//switch (e.get

        }
}
