package week9;

import java.awt.*;
import javax.swing.*;

public class ex2 extends JFrame
{
		
	JButton b1, b2, b3, b4, b5;
			
	public ex2()
	{
		super("Border layout manager");
		
		b1 = new JButton("Button1");
		b2 = new JButton("Button2");
		b3 = new JButton("Button3");
		b4 = new JButton("Button4");
		b5 = new JButton("Button5");
		
		add(b1, BorderLayout.NORTH);
		add(b2, BorderLayout.EAST);
		add(b3, BorderLayout.SOUTH);
		add(b4, BorderLayout.WEST);
		add(b5, BorderLayout.CENTER);
		
	}
	

}