package week9;

import java.io.IOException;

import javax.swing.JFrame;



public class Controller {

	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() {
				AssignmentTestFrame f = null;
				try {
					f = new AssignmentTestFrame();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//ex4 f = new ex4();
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(700, 700);
				f.setVisible(true);
				
			}
		});

	}

}
