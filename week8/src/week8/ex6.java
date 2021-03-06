package week8;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ex6 extends JFrame
{
	JFileChooser fopen = new JFileChooser();
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem newItem, openItem, saveItem, exitItem;
	
	public ex6()
	{
		super("Menu Example");
		
		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		newItem = new JMenuItem("new");
		newItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//new file code
			}
		});
		
		openItem = new JMenuItem("open");
		openItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openFile();
				
			}
		});
		
		exitItem = new JMenuItem("exit");
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		
		saveItem = new JMenuItem("save");
		saveItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//saveFile();
			}
		});
		
		
		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		
		
	} // end of constructor

	
	public void newFile()
	{
		
	}
	
	public void openFile()
	{
		int result = fopen.showOpenDialog(this);
		File myfile = fopen.getSelectedFile();
		
		if(result == JFileChooser.APPROVE_OPTION);
		super.setTitle(myfile.getName());
		
	}
	
	
	
	
	
	
	
	
}
