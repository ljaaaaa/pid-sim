import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SidePanel extends JPanel implements ActionListener{
	//Reference to car
	public Car car; 

	public MyField tField = new MyField("t");
	public MyField vField = new MyField("v");
	public MyField sField = new MyField("s");
	public MyField aField = new MyField("a");

	public MyField pField = new MyField("P");
	public MyField iField = new MyField(" I");
	public MyField dField = new MyField("D");

	public SidePanel(Car car){
		//Set layout
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//Set reference to car
		this.car = car;

		tField.field.addActionListener(this);

		//Add fields to sidepanel in order	
		add(new JLabel("Physics Values:"));
		add(tField);
		add(vField);
		add(sField);
		add(aField);

		add(new JLabel("PID Values: "));
		add(pField);
		add(iField);
		add(dField);
	}

	@Override
        public void actionPerformed(ActionEvent e) {

		if (e.getSource() == tField.field){

			System.out.println(tField);
		}

        }

	public class MyField extends JPanel{
		public JTextField field;
		public JLabel label;

		public MyField(String text){
			label = new JLabel(" " + text + ": ");
			field = new JTextField(10);

			setLayout(new BorderLayout());
			add(label, BorderLayout.WEST);
			add(field, BorderLayout.CENTER);

		}



		
	}
}
