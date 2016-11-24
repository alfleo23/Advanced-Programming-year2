package week9;

import javax.swing.JFrame;



public class Controller {

	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() {
				ex5 f = new ex5();
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(600, 200);
				f.setVisible(true);
				
			}
		});

	}

}
