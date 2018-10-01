package adv_progr_assignment;
// Alfonso Leone 15002679

/**
 * This is the controller class in which a new instance of MainForm is built and run
 * within the main method
 *
 * @author Alfonso Leone
 * @version 1.0
 *
 */

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;


public class Controller {
	/**
	 * main method
	 * @param args
	 * @throws SQLException
	 */

	public static void main(String[] args) throws SQLException
	{

		javax.swing.SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() {
				MainForm f = null;
				try {
					f = new MainForm();
				} catch (IOException e) {
					
					e.printStackTrace();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(700, 700);
				f.setVisible(true);
				//f.setResizable(false);
				
			}
		});
	}

}