package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo<Integers> implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	String text = "";
	Stack<String> letters = new Stack<String>();
	ArrayList<String> typed = new ArrayList<String>();

	public static void main(String[] args) {
		_02_TextUndoRedo TUR = new _02_TextUndoRedo();
		TUR.run();
	}

	void run() {
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && letters.size() >= 1) {
			letters.pop();
			text=text.substring(0, text.length()-1);
			label.setText(text);
			frame.pack();
		} else if (e.getKeyCode() == KeyEvent.VK_CONTROL) {

		}
		else if( e.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
			System.out.println("You need letters to delete stuff you moron.");
		}
		else {
			char ch = e.getKeyChar();
			String stringChar = "";
			stringChar += ch;
			letters.add(stringChar);
			text += letters.get(letters.size() - 1);
			label.setText(text);
			frame.pack();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
