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
	Stack<String> words=new Stack<String>();
	String wordToGuess;
	int lives=6;
	
	JLabel lifeCount=new JLabel();

	void setup() {
		
		frame.add(panel);
		panel.add(label);
		frame.setVisible(true);
		frame.addKeyListener(this);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	lifeCount.setText("Lives: "+lives);
	panel.add(lifeCount);
		frame.pack();
	
	}

public static void main(String[] args) {
	
	new Hangman().game();
	
	
	
	
}
void game() {
	setup();
	String answer =JOptionPane.showInputDialog("Input a number between 1 and 266");
	int rounds=Integer.parseInt(answer);
	
	for(int i=0; i<rounds; i++) {
	String randWord=Utilities.readRandomLineFromFile("dictionary.txt");
	if(!words.contains(randWord)) {
	words.push(randWord);
	}
	}
	restart();
	 
}
void restart() {
	if(!words.isEmpty()) {
	wordToGuess=words.pop();
	 String text="";
	int size=wordToGuess.length();
	for(int i=0; i<size; i++) {
		text+="-";
		
	}
	label.setText(text);
	frame.pack();
}
	else {
		endGame();
		
	}
}

void endGame() {
	if(words.isEmpty()) {
		JOptionPane.showMessageDialog(null, "YOU WONNNNNNN!!! THERE ARE NO MORE WORDS TO GUESSSS!!");
		System.exit(0);
	}
	if(lives==0) {
		JOptionPane.showMessageDialog(null, "Sorry, you lost bruh. No lives left");
		System.exit(0);
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
//hi
@Override
public void keyTyped(KeyEvent event) {
	// TODO Auto-generated method stub
	char typed=event.getKeyChar();
	String newText="";
	String oldText=label.getText();
	if(wordToGuess.contains(String.valueOf(typed))) {
		for(int i=0; i<wordToGuess.length(); i++) {
			
			if(wordToGuess.charAt(i)==typed) {
				newText+=typed;
			}
			else {
				newText+=oldText.charAt(i);
			}
		}
		label.setText(newText);
		
	}
	else {
		lives--;
		lifeCount.setText("Lives: "+lives);
		if(lives==0) {
			
			endGame();
		}
	}
	if(newText.equalsIgnoreCase(wordToGuess)) {
		restart();
	}
}


}
