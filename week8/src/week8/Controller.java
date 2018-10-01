package week8;
import javax.swing.JFrame;


public class Controller {

	public static void main(String[] args) 
	{
		// Manage swing in its own thread using the Runnable interface
		javax.swing.SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() {
				ex6 f = new ex6();
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(600, 400);
				f.setVisible(true);
				
			}
		});
	}
}


