package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
			//	Song song=new Song("demo.mp3");
			//	song.play();
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
	}
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JButton shuffle=new JButton();
	ArrayList<String>songs=new ArrayList();
	public static void main(String[] args) {
		_06_IPodShuffle ips=new _06_IPodShuffle();
		ips.run();
	}
	void run() {
		frame.add(panel);
		panel.add(shuffle);
		frame.setVisible(true);
		frame.pack();
		shuffle.setText("Surprise Me");
		shuffle.addActionListener(this);
		songs.add("demo.mp3");
		songs.add("GoodSound.wav");
		songs.add("UnpleasantSound.wav");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==shuffle) {
		
	}
}
}