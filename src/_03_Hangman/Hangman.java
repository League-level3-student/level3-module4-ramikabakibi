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
	
	//I've coded getting a random number for users, and that amount of times i call the readrandomlinefromfile, and so that gets 
	//a random word, which i push to the stack, and then i pop that word off from thr stack, and then add a "-" for every character in that word
	//using a jlablel. I added the keylistener to the frame and thats why there are methods down there, so just need to code the rest saying if
	//they guess the right letter replace the - with the letter, and if they guess incorrectly, reduce a life(need to show that on the frame)
	//also right now the main method starts the program at the game method, which calls the setup methods but ill need methods for restarting and stuff
	
	
	
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
