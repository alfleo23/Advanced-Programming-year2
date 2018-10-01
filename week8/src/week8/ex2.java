package week8;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ex2 extends JFrame{
	
	JButton pressMeButton;
	JButton clearButton;
	JTextField textField = new JTextField(20);
	
	
	
	public ex2()
	{
		super("EventHandling Example");
		setLayout(new FlowLayout());
		
		pressMeButton = new JButton("PressMe");
		pressMeButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText("alfonso leone !");
			}
		});
		add(pressMeButton);
		
		
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				textField.setText(" ");
			}
		});		
		add(clearButton);
		
		add(textField);
		
	}
	

}
