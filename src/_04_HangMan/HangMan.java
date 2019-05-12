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
	boolean wordComplete = true;
	Stack<String> allWords = new Stack<String>();
	Stack<Character> typedInStack=new Stack<Character>();
	String underscores = "";
	String word = "";
	int numberOfLives = 10;
	String stringLives = Integer.toString(numberOfLives);
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel lives = new JLabel();
	int totalTyped = 0;

	public static void main(String[] args) {
		HangMan HM = new HangMan();
		HM.run();
	}

	void run() {
		frame.add(panel);
		panel.add(label);
		panel.add(lives);
		frame.setVisible(true);
		lives.setText("   Lives=" + stringLives);
		frame.addKeyListener(this);
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
			if (wordComplete == true) {
				createNewWord();
				wordComplete = false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Try again");
			run();
		}
	}

	void createNewWord() {
		wordComplete = false;
		word = allWords.pop();
		for (int j = 0; j < word.length(); j++) {
			underscores += "_";
		}
		label.setText(underscores);
		frame.pack();
		System.out.println("hi");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char typedIn = e.getKeyChar();
		StringBuilder sb = new StringBuilder(label.getText());
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == typedIn) {
				if(!typedInStack.contains(typedIn)) {
					typedInStack.push(typedIn);
				}
				else {
					sb.setCharAt(i, typedIn);
					totalTyped++;
					System.out.println(totalTyped);
					frame.pack();
				}
			} else {
				numberOfLives -= 1;
			}
			if (totalTyped == word.length()) {
				wordComplete = true;
				System.out.println("yee");
			}
		}
		label.setText(sb.toString());
		if (wordComplete == true) {
			createNewWord();
		}
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
