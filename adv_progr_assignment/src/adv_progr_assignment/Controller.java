package adv_progr_assignment;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;


public class Controller {

	public static void main(String[] args) throws SQLException
	{
		//EmployeeDAO newInterface = new EmployeeDAO();
//		EmployeeDAO.selectAllEmployees();
	//	EmployeeDAO.selectEmployeeByName("andrew pollit");
//		Employee emp1 = new Employee("3", "Jim Smith", 'M', "RS501TR345", "12/04/1982", "2 ossory street", "M127TY", "25000", "25/07/2014", "Technician", "jimsmith@gmail.com");
//		EmployeeDAO.insertEmployee(emp1);
		//EmployeeDAO.selectAllEmployees();
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() {
				MainForm f = null;
				try {
					f = new MainForm();
				} catch (IOException e) {
					
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(700, 700);
				f.setVisible(true);
				
			}
		});
	}

}