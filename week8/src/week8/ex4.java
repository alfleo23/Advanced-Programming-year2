package week8;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ex4 extends JFrame{
	
	JComboBox comboBox;
	JLabel label1;
	
	public ex4()
	{
		super("EventHandling Example");
		setLayout(new FlowLayout());
		
		String[] rainbowArray = { "Red", "Orange", "Yellow", "Green",
				"Blue", "Indigo", "Violet" };
		
		comboBox = new JComboBox(rainbowArray);
		label1 = new JLabel("Violet");
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String colourName = (String) comboBox.getSelectedItem();
				label1.setText(colourName);
					
			}
		});
		
		add(comboBox);
		add(label1);
	}

}
