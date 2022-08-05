import javax.swing.JPanel;
import javax.swing.JTextFiel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SidePanel extends JPanel implements ActionListener{

	public JTextField tField;
	public JTextField vField;
	public JTextField sField;
	public JTextField aField;

	public SidePanel(){
		tField = new JTextField(10);
		vField = new JTextField(10);
		sField = new JTextField(10);
		aField = new JTextField(10);
	}

	@Override
        public void actionPerformed(ActionEvent e) {

		switch (e.get

        }
}
