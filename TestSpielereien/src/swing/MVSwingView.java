package swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MVSwingView extends JFrame {

	private static final long serialVersionUID = 5077587341241722620L;
	
	JButton button = null;
	JButton anotherButton = null;
	
	public MVSwingView() {
		this.setBounds(20,  20,  200,  200);
		this.setLayout(new FlowLayout());
		this.button = new JButton("TEST");
		this.add(this.button);
		this.anotherButton = new MVTestButton("MEINER");
		this.add(this.anotherButton);
	}
}
