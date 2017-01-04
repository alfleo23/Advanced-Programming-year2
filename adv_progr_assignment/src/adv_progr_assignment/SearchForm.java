package adv_progr_assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by alfonsoleone on 22/12/16.
 */

// could have been done with an input dialogue but choose to to it with multiple forms communicating
public class SearchForm extends JFrame
{
	public JLabel namelabel;
	public JTextField namefield;
	public JButton searchbutton;
	MainForm mainform;

	public SearchForm(MainForm m)
	{
		super("Search Employee");
		mainform = m;
		setLayout(new FlowLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(450, 100);
		setVisible(true);

		namelabel = new JLabel("Name to search for: ");
		namefield = new JTextField("", 15);
		searchbutton = new JButton("Search");
		searchbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					mainform.selectedEmployee(namefield.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		add(namelabel);
		add(namefield);
		add(searchbutton);
		//
	}



}
