import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class SidePanel extends JPanel implements ActionListener{
	//Reference to car
	public Car car; 

	public ArrayList<MyField> fields;

	public SidePanel(Car car){
		//Set layout
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//Set reference to car
		this.car = car;

		//Add action listeners to all fields
		fields = new ArrayList<>();

		//Add physics fields
		fields.add(new MyField("t"));
		fields.add(new MyField("v"));
		fields.add(new MyField("s"));
		fields.add(new MyField("a"));

		//Add PID fields
		fields.add(new MyField("P"));
		fields.add(new MyField("I"));
		fields.add(new MyField("D"));
	
		addFieldsToPanel();
		addActionListeners();
	}

	@Override
        public void actionPerformed(ActionEvent e) {

		for (int x = 0; x < fields.size(); x++){
			if (e.getSource() == fields.get(x).field){

				//C++ references to integers would be handy here

			}
		}
        }

	//Adds all MyFields to panel
	public void addFieldsToPanel(){
		for (int x = 0; x < fields.size(); x++){
			add(fields.get(x));
		}
	}

	//Adds action listeners to MyField fields
	public void addActionListeners(){
		for (int x = 0; x < fields.size(); x++){
                        fields.get(x).addActionListener(this);
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
