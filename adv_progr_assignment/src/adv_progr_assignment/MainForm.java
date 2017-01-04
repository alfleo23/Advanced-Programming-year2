package adv_progr_assignment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MainForm extends JFrame
{
	//test
	EmployeeDAO dao = new EmployeeDAO();
	
	public JLabel namelabel, genderlabel, doblabel, salarylabel, ninlabel, emaillabel, sdatelabel, joblabel, noemployeelabel, imagelabel, malelabel, femalelabel, addresslabel, postcodelabel;
	public JTextField namefield, salaryfield, ninfield, emailfield, jobfield, addressfield, postcodefield;
	public JPanel genderpanel, dobpanel, startdatepanel, backforwardpanel, cleardeletepanel;
	public JButton enterbutton, clearbutton, backbutton, forwardbutton, deletebutton;
	public ButtonGroup group;
	public JRadioButton malecheck, femalecheck;
	public JComboBox dobday, dobmonth, dobyear, stdateday, stdatemonth, stdateyear;
	public JMenuBar menuBar;
	public JMenu fileMenu;
	public JMenuItem insertEmployee, showEmployees, searchEmployee;

	
	int employeeIndex = 0;
	ArrayList<Employee> employeesList = dao.selectAllEmployees();  //selects all the employees in the database, put them in an arraylist and return it with the selectAllEmployees method
	Employee empToShow = employeesList.get(employeeIndex);

	//test 3 panels
	JPanel west,center,east;
	
	public MainForm() throws IOException, SQLException
	{
		super("Employee Record System Assignment");
		Integer[] days = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
		Integer[] months = {1,2,3,4,5,6,7,8,9,10,11,12};
		Integer[] years = new Integer[88];
		
		int yearToAdd = 1930;
		
		for (int i = 0; i < 88; i++)
		{
			years[i] = yearToAdd;
			yearToAdd++;
		}
		
		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		insertEmployee = new JMenuItem("Insert Employee");
		insertEmployee.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				enterbutton.setVisible(true);
				clearbutton.setVisible(true);
				deletebutton.setVisible(false);
				malecheck.setEnabled(true);
				malecheck.setSelected(false);
				femalecheck.setEnabled(true);
				femalecheck.setSelected(false);
				namefield.setEnabled(true);
				namefield.setText("");
				addressfield.setEnabled(true);
				addressfield.setText("");
				postcodefield.setEnabled(true);
				postcodefield.setText("");
				salaryfield.setEnabled(true);
				salaryfield.setText("");
				ninfield.setEnabled(true);
				ninfield.setText("");
				emailfield.setEnabled(true);
				emailfield.setText("");
				jobfield.setEnabled(true);
				jobfield.setText("");
				noemployeelabel.setVisible(false);
				forwardbutton.setVisible(false);
				backbutton.setVisible(false);
				dobday.setEnabled(true);
				dobday.setSelectedItem(null);
				dobmonth.setEnabled(true);
				dobmonth.setSelectedItem(null);
				dobyear.setEnabled(true);
				dobyear.setSelectedItem(null);
				stdateday.setEnabled(true);
				stdateday.setSelectedItem(null);
				stdatemonth.setEnabled(true);
				stdatemonth.setSelectedItem(null);
				stdateyear.setEnabled(true);
				stdateyear.setSelectedItem(null);
				imagelabel.setVisible(false);
				group.clearSelection();

			}
		});

		showEmployees = new JMenuItem("Show Records");
		showEmployees.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					employeesList = dao.selectAllEmployees();
				}
				catch(SQLException ex){ex.printStackTrace();}
				getFirstEmployee();
				enterbutton.setVisible(false);
				clearbutton.setVisible(false);
				deletebutton.setVisible(true);
				malecheck.setEnabled(false);
				femalecheck.setEnabled(false);
				namefield.setEnabled(false);
				addressfield.setEnabled(false);
				postcodefield.setEnabled(false);
				salaryfield.setEnabled(false);
				ninfield.setEnabled(false);
				emailfield.setEnabled(false);
				jobfield.setEnabled(false);
				noemployeelabel.setVisible(true);
				forwardbutton.setVisible(true);
				backbutton.setVisible(true);
				dobday.setEnabled(false);
				dobmonth.setEnabled(false);
				dobyear.setEnabled(false);
				stdateday.setEnabled(false);
				stdatemonth.setEnabled(false);
				stdateyear.setEnabled(false);
				imagelabel.setVisible(true);
			}
		});

		searchEmployee = new JMenuItem("Search Employee by Name");
		searchEmployee.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SearchForm search = new SearchForm(MainForm.this);


			}
		});


		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		fileMenu.add(insertEmployee);
		fileMenu.add(showEmployees);
		fileMenu.add(searchEmployee);

		namelabel = new JLabel("Name:");
		addresslabel = new JLabel("Address:");
		postcodelabel = new JLabel("Postcode:");
		genderlabel = new JLabel("Gender:");
		doblabel = new JLabel("Date Of Birth:");
		salarylabel = new JLabel("Salary:");
		ninlabel = new JLabel("National Insurance Number:");
		emaillabel = new JLabel("Email:");
		sdatelabel = new JLabel("Start Date:");
		joblabel = new JLabel("Job Title:");
		noemployeelabel = new JLabel("No. of Employee: " + empToShow.getId());
		malelabel = new JLabel("Male ");
		femalelabel = new JLabel("Female ");
		
		namefield = new JTextField(empToShow.getName());
		namefield.setEnabled(false);
		addressfield = new JTextField(empToShow.getAddress());
		addressfield.setEnabled(false);
		postcodefield = new JTextField(empToShow.getPostcode());
		postcodefield.setEnabled(false);
		salaryfield = new JTextField(empToShow.getSalary());
		salaryfield.setEnabled(false);
		ninfield = new JTextField(empToShow.getNatInsNo());
		ninfield.setEnabled(false);
		emailfield = new JTextField(empToShow.getEmail());
		emailfield.setEnabled(false);
		jobfield = new JTextField(empToShow.getJobTitle());
		jobfield.setEnabled(false);
		
		genderpanel = new JPanel();
		dobpanel = new JPanel();
		startdatepanel = new JPanel();
		backforwardpanel = new JPanel();
		cleardeletepanel = new JPanel();


		// buttons functions
		enterbutton = new JButton("Enter");
		enterbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = namefield.getText();
				char gender = getGenderBox();
				String dob = getFormDOB();
				String address = addressfield.getText();
				String postcode = postcodefield.getText();
				String salary = salaryfield.getText();
				String nin = ninfield.getText();
				String jobtitle = jobfield.getText();
				String stdate = getFormStartDate();
				String email = emailfield.getText();

				Employee testEmp = new Employee(name, gender, nin, dob, address, postcode, salary, stdate, jobtitle, email);
				EmployeeDAO.insertEmployee(testEmp);
				//employeesList.add(testEmp);

			}
		});
		clearbutton = new JButton("Clear");
		clearbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				namefield.setText("");
				addressfield.setText("");
				postcodefield.setText("");
				salaryfield.setText("");
				ninfield.setText("");
				emailfield.setText("");
				jobfield.setText("");
				dobday.setSelectedItem(null);
				dobmonth.setSelectedItem(null);
				dobyear.setSelectedItem(null);
				stdateday.setSelectedItem(null);
				stdatemonth.setSelectedItem(null);
				stdateyear.setSelectedItem(null);

			}
		});
		backbutton = new JButton("Back");
		backbutton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				getPreviousEmployee();
				
			}
		});
		forwardbutton = new JButton("Forward");
		forwardbutton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				getNextEmployee();
			}
		});
		deletebutton = new JButton("Delete Record");
		deletebutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record ?");
				if (reply == JOptionPane.YES_OPTION)
				{
					dao.deleteEmployeeById(Integer.toString(empToShow.getId()));
					try {
						employeesList = dao.selectAllEmployees();
					}
					catch(SQLException ex){ex.printStackTrace();}
					getFirstEmployee();
					enterbutton.setVisible(false);
					clearbutton.setVisible(false);
					deletebutton.setVisible(true);
					malecheck.setEnabled(false);
					femalecheck.setEnabled(false);
					namefield.setEnabled(false);
					addressfield.setEnabled(false);
					postcodefield.setEnabled(false);
					salaryfield.setEnabled(false);
					ninfield.setEnabled(false);
					emailfield.setEnabled(false);
					jobfield.setEnabled(false);
					noemployeelabel.setVisible(true);
					forwardbutton.setVisible(true);
					backbutton.setVisible(true);
					dobday.setEnabled(false);
					dobmonth.setEnabled(false);
					dobyear.setEnabled(false);
					stdateday.setEnabled(false);
					stdatemonth.setEnabled(false);
					stdateyear.setEnabled(false);
					imagelabel.setVisible(true);

					System.out.println("record deleted");

					//TODO implement a query to reset the autoincrement to last id in the database
				}

			}
		});

		// setting the radioButtons for the first item in the list
		malecheck = new JRadioButton();
		malecheck.setEnabled(false);
		femalecheck = new JRadioButton();
		femalecheck.setEnabled(false);
		group = new ButtonGroup();
		group.add(malecheck);
		group.add(femalecheck);

		setGenderCheckBox(empToShow.getGender());
		
		dobday = new JComboBox(days);
		dobday.setEnabled(false);
		dobmonth = new JComboBox(months);
		dobmonth.setEnabled(false);
		dobyear = new JComboBox(years);
		dobyear.setEnabled(false);
		stdateday = new JComboBox(days);
		stdateday.setEnabled(false);
		stdatemonth = new JComboBox(months);
		stdatemonth.setEnabled(false);
		stdateyear = new JComboBox(years);
		stdateyear.setEnabled(false);
		setComboBoxDates(empToShow.getStartDate(), empToShow.getDob());
		
		
		//test 3 main panels
		west = new JPanel();
		center = new JPanel();
		east = new JPanel();
		
		
		ImageIcon image = empToShow.getEmployeeImage();
		Image img = image.getImage();
		Image newimg = img.getScaledInstance(150, 250, java.awt.Image.SCALE_SMOOTH);
		image = new ImageIcon(newimg);
		
		imagelabel = new JLabel(image);
		
		add(west, BorderLayout.WEST);
		west.setLayout(new GridLayout(0,1));
		add(center, BorderLayout.CENTER);
		center.setLayout(new GridLayout(0,1));
		add(east, BorderLayout.EAST);
		east.setLayout(new GridLayout(0, 1));
		

		west.add(namelabel);
		west.add(addresslabel);
		west.add(postcodelabel);
		west.add(genderlabel);
		west.add(doblabel);
		west.add(salarylabel);
		west.add(ninlabel);
		west.add(emaillabel);
		west.add(sdatelabel);
		west.add(joblabel);
		west.add(enterbutton);
		enterbutton.setVisible(false);
		
		center.add(namefield);
		center.add(addressfield);
		center.add(postcodefield);
		
		center.add(genderpanel);
		genderpanel.add(malecheck);
		genderpanel.add(malelabel);
		genderpanel.add(femalecheck);
		genderpanel.add(femalelabel);
		
		center.add(dobpanel);
		dobpanel.add(dobday);
		dobpanel.add(dobmonth);
		dobpanel.add(dobyear);
		
		center.add(salaryfield);
		center.add(ninfield);
		center.add(emailfield);
		
		center.add(startdatepanel);
		startdatepanel.add(stdateday);
		startdatepanel.add(stdatemonth);
		startdatepanel.add(stdateyear);
		
		center.add(jobfield);
		center.add(cleardeletepanel);
		cleardeletepanel.setLayout(new GridLayout(0, 1));
		cleardeletepanel.add(clearbutton);
		cleardeletepanel.add(deletebutton);
		clearbutton.setVisible(false);
		
		east.add(noemployeelabel);
		east.add(imagelabel);
		east.add(backforwardpanel);
		backforwardpanel.add(backbutton);
		backforwardpanel.add(forwardbutton);
		
	}



	// helper functions
	public void getNextEmployee()
	{
		if (employeeIndex < employeesList.size()-1)
		{
			employeeIndex++;
			empToShow = employeesList.get(employeeIndex);
			
			namefield.setText(empToShow.getName());
			addressfield.setText(empToShow.getAddress());
			postcodefield.setText(empToShow.getPostcode());
			salaryfield.setText(empToShow.getSalary());
			ninfield.setText(empToShow.getNatInsNo());
			emailfield.setText(empToShow.getEmail());
			jobfield.setText(empToShow.getJobTitle());
			noemployeelabel.setText("No. of Employee: " + empToShow.getId());
			setGenderCheckBox(empToShow.getGender());
			setComboBoxDates(empToShow.getStartDate(), empToShow.getDob());

			setImage();
		}
		
	}
	
	public void getPreviousEmployee()
	{
		if (employeeIndex > 0)
		{
			employeeIndex--;
			empToShow = employeesList.get(employeeIndex);
			
			namefield.setText(empToShow.getName());
			addressfield.setText(empToShow.getAddress());
			postcodefield.setText(empToShow.getPostcode());
			salaryfield.setText(empToShow.getSalary());
			ninfield.setText(empToShow.getNatInsNo());
			emailfield.setText(empToShow.getEmail());
			jobfield.setText(empToShow.getJobTitle());
			noemployeelabel.setText("No. of Employee: " + empToShow.getId());
			setGenderCheckBox(empToShow.getGender());
			setComboBoxDates(empToShow.getStartDate(), empToShow.getDob());
			
			setImage();
		}		
		
	}

	public void getFirstEmployee()
	{
		employeeIndex = 0; // set the index to zero so that it won t jump to some weird index
		empToShow = employeesList.get(0); // starts from the first item in the list

		namefield.setText(empToShow.getName());
		addressfield.setText(empToShow.getAddress());
		postcodefield.setText(empToShow.getPostcode());
		salaryfield.setText(empToShow.getSalary());
		ninfield.setText(empToShow.getNatInsNo());
		emailfield.setText(empToShow.getEmail());
		jobfield.setText(empToShow.getJobTitle());
		noemployeelabel.setText("No. of Employee: " + empToShow.getId());
		setGenderCheckBox(empToShow.getGender());
		setComboBoxDates(empToShow.getStartDate(), empToShow.getDob());

		setImage();
	}

	public void setGenderCheckBox(char gender)
	{
		if (gender == 'M' || gender == 'm')
		{
			malecheck.setSelected(true);
			femalecheck.setSelected(false);
		}
		else if (gender == 'F' || gender == 'f')
		{
			femalecheck.setSelected(true);
			malecheck.setSelected(false);
		}
		else
		{
			group.clearSelection();
		}
	}

	public char getGenderBox()
	{
		if(malecheck.isSelected())
		{
			return 'M';
		}
		if(femalecheck.isSelected())
		{
			return 'F';
		}

		//TODO test only..to be modified to give an error message if no gender selected
		return 'M';
	}

	public String getFormDOB()
	{
		String dob = Integer.toString((Integer) dobday.getSelectedItem()) + "/" + Integer.toString((Integer) dobmonth.getSelectedItem()) + "/" + Integer.toString((Integer) dobyear.getSelectedItem());
		return dob;
	}

	public String getFormStartDate()
	{
		String startDate =  Integer.toString((Integer) stdateday.getSelectedItem()) + "/" + Integer.toString((Integer) stdatemonth.getSelectedItem()) + "/" + Integer.toString((Integer) stdateyear.getSelectedItem());
		return startDate;
	}

	public void setImage()
	{
		try {
				imagelabel.setVisible(true);
				ImageIcon image = empToShow.getEmployeeImage();
				Image img = image.getImage();
				Image newimg = img.getScaledInstance(150, 250, java.awt.Image.SCALE_SMOOTH);
				image = new ImageIcon(newimg);
				imagelabel.setIcon(image);
			}
		catch (NullPointerException e)
		{imagelabel.setVisible(false);}
	}

	public void setComboBoxDates(String startDate, String DOB)
	{

		String[] startDateSplit = startDate.split("/");
		String[] DOBSplit = DOB.split("/");

		int startDateDay = Integer.parseInt(startDateSplit[0]);
		int startDateMonth = Integer.parseInt(startDateSplit[1]);
		int startDateYear = Integer.parseInt(startDateSplit[2]);

		int dobDay = Integer.parseInt(DOBSplit[0]);
		int dobMonth = Integer.parseInt(DOBSplit[1]);
		int dobYear = Integer.parseInt(DOBSplit[2]);

		stdateday.setSelectedItem(startDateDay);
		stdatemonth.setSelectedItem(startDateMonth);
		stdateyear.setSelectedItem(startDateYear);

		dobday.setSelectedItem(dobDay);
		dobmonth.setSelectedItem(dobMonth);
		dobyear.setSelectedItem(dobYear);

	}

	public void selectedEmployee(String aName) throws SQLException
	{
		try {
			String selectedEmployee = dao.selectEmployeeByName(aName);
			String[] selectedEmployeeSplit = selectedEmployee.split("-");
			String id = selectedEmployeeSplit[0];
			String name = selectedEmployeeSplit[1];
			String gender = selectedEmployeeSplit[2];
			String dob = selectedEmployeeSplit[3];
			String address = selectedEmployeeSplit[4];
			String postcode = selectedEmployeeSplit[5];
			String nin = selectedEmployeeSplit[6];
			String jobtitle = selectedEmployeeSplit[7];
			String startdate = selectedEmployeeSplit[8];
			String salary = selectedEmployeeSplit[9];
			String email = selectedEmployeeSplit[10];

			namefield.setText(name);
			addressfield.setText(address);
			postcodefield.setText(postcode);
			ninfield.setText(nin);
			jobfield.setText(jobtitle);
			salaryfield.setText(salary);
			emailfield.setText(email);
			setComboBoxDates(startdate, dob);
			setGenderCheckBox(gender.charAt(0));
			noemployeelabel.setText("No. of Employee: " + id);


		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Record not found");
			e.printStackTrace();
		}

	}


	

} // end of main form
