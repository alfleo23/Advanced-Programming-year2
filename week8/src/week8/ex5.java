package week8;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JDialog;

public class ex5 extends JFrame{

	JButton button1,button2,button3;
	String firstName, lastName;
	
	public ex5()
	{
		super ("JOptionPane Example");
		setLayout(new FlowLayout());
		
		
		//
		
		button1 = new JButton("First Name");
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				firstName = JOptionPane.showInputDialog(null, "enter first name");
				
			}
		});
		add(button1);
		
		button2 = new JButton("Last Name");
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lastName = JOptionPane.showInputDialog(null, "enter last name");
				
			}
		});
		add(button2);
		
		button3 = new JButton("Full Name");
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "full name: " + firstName + " " + lastName, "Title: FullName", JOptionPane.PLAIN_MESSAGE);
				
			}
		});
		add(button3);
		
		

		
	}
	

}
