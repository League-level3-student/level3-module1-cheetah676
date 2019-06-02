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
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel lives = new JLabel();
	boolean correctLetter=false;
	public static void main(String[] args) {
		HangMan HM = new HangMan();
		HM.run();
	}

	void run() {
		frame.add(panel);
		panel.add(label);
		panel.add(lives);
		frame.setVisible(true);
		lives.setText("   Lives=" + numberOfLives);
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
		if(numberOfLives==0) {
			int playAgain=JOptionPane.showConfirmDialog(null, "Game Over!  Would you like to play again?");
			if(playAgain==)
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		correctLetter=false;
		// TODO Auto-generated method stub
		char typedIn = e.getKeyChar();
		StringBuilder sb = new StringBuilder(label.getText());
		underscores=label.getText();
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == typedIn) {
				sb.setCharAt(i, typedIn);
					typedInStack.push(typedIn);
					frame.pack();
					correctLetter=true;
			}
		}
		if (word.equals(underscores)) {
			wordComplete = true;
			int totalInStack=typedInStack.size();
			for(int j=0; j<totalInStack; j++) {
				typedInStack.pop();
			}
			System.out.println("yee");
			frame.pack();
		}
		if(correctLetter==false) {
			numberOfLives-=1;
			lives.setText("   Lives=" + numberOfLives);
			}	
		label.setText(sb.toString());
		if (wordComplete == true) {
			if(allWords.size()==0) {
				JOptionPane.showMessageDialog(null, "You win with "+numberOfLives+ " lives left");
			}
			else {
			underscores="";
			label.setText("");
			numberOfLives=10;
			lives.setText("   Lives=" + numberOfLives);
			createNewWord();
			}
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
