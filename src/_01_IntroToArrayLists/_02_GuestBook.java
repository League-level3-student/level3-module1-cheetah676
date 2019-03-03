package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JButton button1=new JButton();
	JButton button2=new JButton();
	String guestBook="";
	int guestNumber=1;
	ArrayList <String> list=new ArrayList<String>();
	public static void main(String[]args) {
		_02_GuestBook GB=new _02_GuestBook();
		GB.run();
	}
	void run() {
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button1.setText("AddName");
		button2.setText("View Names");
		frame.setVisible(true);
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button1) {
			String newName=JOptionPane.showInputDialog("Add a new name");
			list.add(newName);
		}
		if(e.getSource()==button2) {
			for(int i=0; i<list.size(); i++) {
				String guestBookEntry="Guest #" + guestNumber + ": " + list.get(i) + "\n";
			guestBook+=guestBookEntry;
			guestNumber++;
			}
			JOptionPane.showMessageDialog(null, guestBook);
			}
		}
	}
	
