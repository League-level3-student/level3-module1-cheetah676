package _04_HangMan;

import java.util.Dictionary;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan extends Utilities {
	Stack<String> allWords = new Stack<String>();
	Stack singleWord = new Stack<String>();
	String underscores="";

	public static void main(String[] args) {
		HangMan HM = new HangMan();
		HM.run();
	}

	void run() {
		JFrame frame=new JFrame();
		JPanel panel=new JPanel();
		JLabel label=new JLabel();
		frame.add(panel);
		panel.add(label);
		frame.setVisible(true);
		String randomWord;
		boolean newWord = true;
		String words = JOptionPane.showInputDialog(null, "How many word do you want, under 266");
		int numberOfWords = Integer.parseInt(words);
		for (int i = 0; i < numberOfWords; i++) {
			randomWord = readRandomLineFromFile("dictionary.txt");
			if (!allWords.contains(randomWord)) {
				allWords.push(randomWord);
				newWord = true;
			} else {
				newWord = false;
			}
			while (newWord == false) {
				randomWord = readRandomLineFromFile("dictionary.txt");
				if (!allWords.contains(randomWord)) {
					allWords.push(randomWord);
					newWord = true;
				} else {
					newWord = false;
				}
			}
		}
		for(int i=0; i<numberOfWords; i++) {
			String pop=allWords.pop();
			for (int j = 0; j < pop.length(); j++) {
				char letter = pop.charAt(j);
				singleWord.push(letter);
			}
		}
		for(int i=0; i<singleWord.size(); i++) {
			underscores+="_";
		}
		label.setText(underscores);
		frame.pack();
	}
}
