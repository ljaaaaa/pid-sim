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
		fields.add(new MyField("t", car.t));
		fields.add(new MyField("v", car.v));
		fields.add(new MyField("s", car.s));
		fields.add(new MyField("a", car.a));

		//Add PID fields
		fields.add(new MyField("P", car.kP));
		fields.add(new MyField("I", car.kI));
		fields.add(new MyField("D", car.kD));
	
		addFieldsToPanel();
		addActionListeners();
	}

	@Override
        public void actionPerformed(ActionEvent e) {
		//Update all physics values
		car.t = fields.get(0).getVal();
		car.v = fields.get(1).getVal();
		car.s = fields.get(2).getVal();
		car.a = fields.get(3).getVal();

		//Update all PID values
		car.kP = fields.get(4).getVal();
		car.kI = fields.get(5).getVal();
		car.kD = fields.get(6).getVal();

		
	}

	//Adds all MyFields to panel
	public void addFieldsToPanel(){
		add(new JLabel("Physics Values:"));

		for (int x = 0; x < fields.size(); x++){
			add(fields.get(x));

			if (fields.get(x).text.equals("a")){
				add(new JLabel("PID Values:"));
			}
		}
	}

	//Adds action listeners to MyField fields
	public void addActionListeners(){
		for (int x = 0; x < fields.size(); x++){
                        fields.get(x).field.addActionListener(this);
                }
	}

	public class MyField extends JPanel{
		public JTextField field;
		public JLabel label;
		public String text;

		public MyField(String text, double val){
			this.text = text;
			label = new JLabel(" " + text + ": ");
			field = new JTextField(String.valueOf(val), 10);

			setLayout(new BorderLayout());
			add(label, BorderLayout.WEST);
			add(field, BorderLayout.CENTER);
		}

		//Return val from field
		public double getVal(){
			return Double.parseDouble(field.getText());
		}
	}
}
