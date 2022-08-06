import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.util.ArrayList;

public class SidePanel extends JPanel implements ActionListener{
	//Reference to car and main
	public Main main;
	public Car car; 

	//List of all fields
	public ArrayList<MyField> fields;

	public SidePanel(Main main, Car car){
		//Set layout
		setLayout(new GridLayout(11, 1));
		
		//Set reference to car
		this.main = main;
		this.car = car;

		//Add action listeners to all fields
		fields = new ArrayList<>();

		//Add physics fields
		fields.add(new MyField("t", car.t));
		fields.add(new MyField("v", car.v));

		//Add PID fields
		fields.add(new MyField("kP", car.kP));
		fields.add(new MyField("kI", car.kI));
		fields.add(new MyField("kD", car.kD));
	
		//Add target
		fields.add(new MyField("target", car.target));

		addFieldsToPanel();
		addActionListeners();
	}

	@Override
        public void actionPerformed(ActionEvent e) {
		try {
			//Update all physics values
			car.t = fields.get(0).getVal();
			car.v = fields.get(1).getVal();

			//Update all PID values
			car.kP = fields.get(2).getVal();
			car.kI = fields.get(3).getVal();
			car.kD = fields.get(4).getVal();

			//Update target
			car.target = fields.get(5).getVal();

			main.moveCar();
		} catch (NumberFormatException ex){

		}
	}

	//Adds all MyFields to panel
	public void addFieldsToPanel(){
		//Physics values
		add(new JLabel(" Physics Values"));
		add(fields.get(0));
		add(fields.get(1));
		add(new JLabel(" s: " + car.s));
		add(new JLabel(" a: " + car.a));

		//PID values
		add(new JLabel(" PID Values"));
		add(fields.get(2));
		add(fields.get(3));
		add(fields.get(4));

		//Target
		add(new JLabel(" Target"));
		add(fields.get(5));
	}

	//Adds action listeners to MyField fields
	public void addActionListeners(){
		for (int x = 0; x < fields.size(); x++){
                        fields.get(x).field.addActionListener(this);
                }
	}

	//MyField class, has field and label for each variable
	public class MyField extends JPanel{
		public JTextField field;
		public JLabel label;
		public String text;

		//Constructor
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