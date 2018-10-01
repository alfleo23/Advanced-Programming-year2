package week8;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ex1 extends JFrame
{
	JButton redButton;
	JButton blueButton;
		
	public ex1()
	{
		super("EventHandling Example");
		setLayout(new FlowLayout());
		redButton = new JButton("Red");
		add(redButton);
		blueButton = new JButton("Blue");
		add(blueButton);
		myEventHandler h = new myEventHandler();
		redButton.addActionListener(h);
		blueButton.addActionListener(h);
	}
	
	private class myEventHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource()==redButton)
			getContentPane().setBackground(Color.RED);
			else if(e.getSource()==blueButton)
			getContentPane().setBackground(Color.BLUE);
		}
	}


}


