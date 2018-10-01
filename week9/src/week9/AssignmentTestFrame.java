package week9;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class AssignmentTestFrame extends JFrame
{
	JLabel namelabel, genderlabel, doblabel, salarylabel, ninlabel, emaillabel, sdatelabel, joblabel, noemployeelabel, imagelabel, malelabel, femalelabel;
	JTextField namefield, salaryfield, ninfield, emailfield, jobfield;
	JPanel genderpanel, dobpanel, startdatepanel, backforwardpanel;
	JButton enterbutton, clearbutton, backbutton, forwardbutton;
	JCheckBox malecheck, femalecheck;
	JComboBox dobday, dobmonth, dobyear, stdateday, stdatemonth, stdayyear; 
	
	//test 3 panels
	JPanel west,center,east;
	
	public AssignmentTestFrame() throws IOException
	{
		super("test frame");
		Integer[] days = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
		Integer[] months = {1,2,3,4,5,6,7,8,9,10,11,12};
		Integer[] years = new Integer[67];
		int yearToAdd = 1950;
		for (int i = 0; i < 67; i++)
		{
			years[i] = yearToAdd;
			yearToAdd++;
		}
		
		
		namelabel = new JLabel("Name:");
		genderlabel = new JLabel("Gender:");
		doblabel = new JLabel("Date Of Birth:");
		salarylabel = new JLabel("Salary:");
		ninlabel = new JLabel("National Insurance Number:");
		emaillabel = new JLabel("Email:");
		sdatelabel = new JLabel("Start Date:");
		joblabel = new JLabel("Job Title:");
		noemployeelabel = new JLabel("No. of Employee:");
		malelabel = new JLabel("Male ");
		femalelabel = new JLabel("Female ");
		
		namefield = new JTextField();
		salaryfield = new JTextField();
		ninfield = new JTextField();
		emailfield = new JTextField();
		jobfield = new JTextField();
		
		genderpanel = new JPanel();
		dobpanel = new JPanel();
		startdatepanel = new JPanel();
		backforwardpanel = new JPanel();
		
		enterbutton = new JButton("Enter");
		clearbutton = new JButton("Clear");
		backbutton = new JButton("Back");
		forwardbutton = new JButton("Forward");
		
		malecheck = new JCheckBox();
		femalecheck = new JCheckBox();
		
		dobday = new JComboBox(days);
		dobmonth = new JComboBox(months);
		dobyear = new JComboBox(years);
		
		
		//test 3 main panels
		west = new JPanel();
		center = new JPanel();
		east = new JPanel();
		
		
		ImageIcon image = new ImageIcon("provetta.jpg");
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
		west.add(genderlabel);
		west.add(doblabel);
		west.add(salarylabel);
		west.add(ninlabel);
		west.add(emaillabel);
		west.add(sdatelabel);
		west.add(joblabel);
		west.add(enterbutton);
		
		center.add(namefield);
		
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
		center.add(jobfield);
		center.add(clearbutton);
		
		east.add(noemployeelabel);
		east.add(imagelabel);
		east.add(backforwardpanel);
		backforwardpanel.add(backbutton);
		backforwardpanel.add(forwardbutton);
		
	}
	

	
	
}