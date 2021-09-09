package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JLabel label=new JLabel();
	void setup() {
		
		frame.add(panel);
		panel.add(label);
		frame.setVisible(true);
		frame.addKeyListener(this);
	}

public static void main(String[] args) {
	
	new Hangman().game();
	
	
	
	
	
}
void game() {
	setup();
	String answer =JOptionPane.showInputDialog("Input a number between 1 and 266");
	int rounds=Integer.parseInt(answer);
	Stack<String> words=new Stack<String>();
	for(int i=0; i<rounds; i++) {
	String randWord=Utilities.readRandomLineFromFile("dictionary.txt");
	if(!words.contains(randWord)) {
	words.push(randWord);
	}
	}
	String wordToGuess=words.pop();
	int size=wordToGuess.length();
	for(int i=0; i<size; i++) {
		label.setText(label.getText()+"-");
	}
}

@Override
public void keyPressed(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}


}
