package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Dictionary;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan extends Utilities implements KeyListener {
	Stack<String> allWords = new Stack<String>();
	Stack singleWord = new Stack<String>();
	String underscores = "";
	String word = "";
	int numberOfLives=10;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel lives = new JLabel();
	public static void main(String[] args) {
		HangMan HM = new HangMan();
		HM.run();
	}

	void run() {
		frame.add(panel);
		panel.add(label);
		panel.add(lives);
	numberOfLives.to
		lives.setText(stringNumberOfLives);
		String randomWord;
		boolean newWord = true;
		String words = JOptionPane.showInputDialog(null, "How many word do you want, under 266");
		int numberOfWords = Integer.parseInt(words);
		if (numberOfWords <= 266) {
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
			for (int i = 0; i < numberOfWords; i++) {
				String pop = allWords.pop();
				for (int j = 0; j < pop.length(); j++) {
					char letter = pop.charAt(j);
					word += letter;
					underscores += "_";
					frame.addKeyListener(this);
				}
			}
			label.setText(underscores);
			frame.pack();
			frame.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Try again");
			run();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char typedIn = e.getKeyChar();
		StringBuilder sb=new StringBuilder(label.getText());
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i)==typedIn) {
sb.setCharAt(i, typedIn);
			}
			else(){
			numberOfLives-=1;	
			}
		}
		label.setText(sb.toString());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
