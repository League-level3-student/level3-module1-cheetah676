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
	JButton addEntry=new JButton();
	JButton searchByID=new JButton();
	JButton viewList=new JButton();
	JButton removeEntry=new JButton();
public static void main(String[]args) {
	LogSearch ls=new LogSearch();
	ls.run();
}
void run(){
	frame.add(panel);
	panel.add(addEntry);
	panel.add(searchByID);
	panel.add(viewList);
	panel.add(removeEntry);
	addEntry.addActionListener(this);
	addEntry.setText("Add Entry");
	searchByID.addActionListener(this);
	searchByID.setText("Search By ID");
	viewList.addActionListener(this);
	viewList.setText("View List");
	removeEntry.addActionListener(this);
	removeEntry.setText("Remove Entry");
	frame.setVisible(true);
	frame.pack();
	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==addEntry) {
		String id=JOptionPane.showInputDialog("Enter an ID number");
		int enteredIDInt=Integer.parseInt(id);
		String enteredName=JOptionPane.showInputDialog("Enter a name");
		hashyMappy.put(enteredIDInt, enteredName);
}
	else if(e.getSource()==searchByID) {
		String id=JOptionPane.showInputDialog("Enter an ID to search for");
		int searchedID=Integer.parseInt(id);
		if(hashyMappy.containsKey(searchedID)) {
			JOptionPane.showMessageDialog(null, hashyMappy.get(searchedID));
		}
		else {
			JOptionPane.showMessageDialog(null, "Entry does not exist");
		}
	}
	else if(e.getSource()==viewList) {
			for(int i:hashyMappy.keySet()) {
				System.out.println("ID:"+i+" Name:"+hashyMappy.get(i));
			}
	}
	else if(e.getSource()==removeEntry) {
		String deletedID=JOptionPane.showInputDialog("What entry do you want to delete");
		int deletedId=Integer.parseInt(deletedID);
		if(hashyMappy.containsKey(deletedId)) {
		hashyMappy.remove(deletedId);
		}
		else {
			JOptionPane.showMessageDialog(null, "This ID does not exist");
		}
	}
}
}
