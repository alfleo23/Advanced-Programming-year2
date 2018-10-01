package week9;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class ex4 extends JFrame 
{
	JPanel panel;
	JButton b1, b2, b3, b4, b5, b6;
	JLabel label;
	
	public ex4()
	{
		super("Mouse events example");
		
		panel = new JPanel();
		label = new JLabel(" ");
		panel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				label.setText("mouse released");
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				label.setText("mouse pressed");
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				label.setText("mouse exited");
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				label.setText("mouse entered");
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				label.setText("mouse clicked");
				
			}
		});;
		
		
		panel.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				label.setText("you are moving the mouse you genius");
				
			}
			
			@Override
			public void mouseDragged(MouseEvent arg0) {
				label.setText("you are dragging ing ing ing");
				
			}
		});
		
		
		add(panel, BorderLayout.CENTER);
		add(label, BorderLayout.SOUTH);
		b1 = new JButton("Button1");
		b2 = new JButton("Button2");
		b3 = new JButton("Button3");
		b4 = new JButton("Button4");
		b5 = new JButton("Button5");
		b6 = new JButton("Button6");
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
	}

}
