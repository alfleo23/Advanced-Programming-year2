package week9;

import java.awt.*;

import javax.swing.*;

public class ex3 extends JFrame
{
		
	JButton b1, b2, b3, b4, b5, b6;
			
	public ex3()
	{
		super("Grid layout manager");
		setLayout(new GridLayout(0, 2));
		b1 = new JButton("Button1");
		b2 = new JButton("Button2");
		b3 = new JButton("Button3");
		b4 = new JButton("Button4");
		b5 = new JButton("Button5");
		b6 = new JButton("Button6");
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		//add(b6);
	}
	

}
