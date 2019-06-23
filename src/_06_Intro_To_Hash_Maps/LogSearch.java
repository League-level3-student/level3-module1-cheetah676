package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LogSearch implements ActionListener {
	HashMap<Integer, String> hashyMappy=new HashMap<Integer, String>();
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JButton button1=new JButton();
	JButton button2=new JButton();
	JButton button3=new JButton();
public static void main(String[]args) {
	LogSearch ls=new LogSearch();
	ls.run();

}
void run(){
	frame.add(panel);
	panel.add(button1);
	panel.add(button2);
	panel.add(button3);
	button1.addActionListener(this);
	button1.setText("Add Entry");
	button2.addActionListener(this);
	button2.setText("Search By ID");
	button3.addActionListener(this);
	button3.setText("View List");
	frame.setVisible(true);
	frame.pack();
	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==button1) {
		String enteredIDString=JOptionPane.showInputDialog("Enter an ID number");
		int enteredIDInt=Integer.parseInt(enteredIDString);
		String enteredName=JOptionPane.showInputDialog("Enter a name");
		hashyMappy.put(enteredIDInt, enteredName);
}
	else if(e.getSource()==button2) {
		
	}
}
}
