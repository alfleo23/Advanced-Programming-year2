package week9;

import java.awt.*;

import javax.swing.*;

public class ex5 extends JFrame
{
	JTextField textfield;
	JTextArea textarea;
	JButton b1;
	
	public ex5()
	{
		super("Grid bag layout");
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		textarea = new JTextArea(14,20);
		textarea.setText("dunno");
		c.gridx= 0;
		c.gridy= 0;
		c.gridwidth=GridBagConstraints.REMAINDER;
		c.gridheight=1;
		c.weightx=1.0;
		c.weighty=1.0;
		c.fill= GridBagConstraints.BOTH;
		c.insets= new Insets(4,4,4,4);
		add(textarea, c);
		
		b1 = new JButton("b1");
		c.gridx= 0;
		c.gridy= 1;
		c.gridwidth=1;
		c.gridheight=1;
		c.weightx=0.0;
		c.weighty=0.0;
		c.fill= GridBagConstraints.VERTICAL;
		c.insets= new Insets(4,4,4,4);
		add(b1, c);
		
		
		textfield = new JTextField("blblbl");
		c.gridx= 1;
		c.gridy= 1;
		c.gridwidth=GridBagConstraints.REMAINDER;
		c.gridheight=1;
		c.weightx=1.0;
		c.weighty=0.0;
		c.fill= GridBagConstraints.BOTH;
		c.insets= new Insets(4,4,4,4);
		add(textfield, c);
		
	}

}
