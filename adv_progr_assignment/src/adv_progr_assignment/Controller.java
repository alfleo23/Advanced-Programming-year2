package adv_progr_assignment;

import java.sql.SQLException;


public class Controller {

	public static void main(String[] args) throws SQLException
	{
		//EmployeeDAO newInterface = new EmployeeDAO();
//		EmployeeDAO.selectAllEmployees();
		EmployeeDAO.selectEmployeeByName("andrew pollit");
//		Employee emp1 = new Employee("3", "Jim Smith", 'M', "RS501TR345", "12/04/1982", "2 ossory street", "M127TY", "25000", "25/07/2014", "Technician", "jimsmith@gmail.com");
//		EmployeeDAO.insertEmployee(emp1);
		//EmployeeDAO.selectAllEmployees();
	}

}