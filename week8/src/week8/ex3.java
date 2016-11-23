package week8;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ex3 extends JFrame{
	
	JCheckBox checkBox = new JCheckBox("Choice");
	JLabel label1 = new JLabel("Tick check Box");
	
	public ex3()
	{
		super("EventHandling Example");
		setLayout(new FlowLayout());
		
		checkBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkBox.isSelected())
					label1.setText("check box has been ticked");
				else
				{
					label1.setText("tick check box");
				}
				
			}
		});
		
		add(checkBox);
		add(label1);
		
	}

}
