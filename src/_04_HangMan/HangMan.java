package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	JFrame frame;
	JPanel panel;
	JLabel label1;
	Stack<String> hangmanwords = new Stack<String>();
	String wordpop = "";
	String underscore = "";
	int lives = 10;
	String blank = "_";

	public static void main(String[] args) {
		HangMan man = new HangMan();
		man.start();
	}

	public void start() {

		frame = new JFrame();
		panel = new JPanel();
		label1 = new JLabel();
		frame.add(panel);
		panel.add(label1);
		frame.pack();
		frame.setVisible(true);
		frame.addKeyListener(this);
		gamestart();
	}
public void gamestart () {
	String howmany = JOptionPane.showInputDialog("Pick how many words you want to do up to 266");
	int howmany2 = Integer.parseInt(howmany);

	for (int i = 0; i < howmany2; i++) {
		String word = Utilities.readRandomLineFromFile("dictionary.txt");
		hangmanwords.push(word);

	}
	wordpop = hangmanwords.pop();
	System.out.println(wordpop);

	for (int i = 0; i < wordpop.length(); i++) {
		underscore += blank;

	}
	label1.setText(underscore);

}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (wordpop.contains(e.getKeyChar() + "")) {
			String temp = "";
			for (int i = 0; i < wordpop.length(); i++) {
				if (wordpop.charAt(i) == e.getKeyChar()) {
					temp += e.getKeyChar();
				} else {
					temp += underscore.charAt(i);

				}
			}
			underscore = temp;
			label1.setText(underscore);
		} else if (hangmanwords.empty() && e.getKeyCode() == KeyEvent.VK_ENTER) {
			JOptionPane.showMessageDialog(null, "Congrats! You won !! :)");
			String answer = JOptionPane.showInputDialog("Would you like to play again? ");
			if (answer.equals("yes")) {
gamestart();
			}
			else {
				System.exit(0);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER && label1.getText().equals(wordpop)) {
			wordpop = hangmanwords.pop();
			System.out.println(wordpop);
			label1.setText(underscore);
			underscore = "";
			for (int i = 0; i < wordpop.length(); i++) {
				underscore += blank;

			}
			label1.setText(underscore);
			System.out.println("test1");
		}

		else {
			lives = lives - 1;
			JOptionPane.showMessageDialog(null, "Wrong! you have " + lives + " lives/ life left");
			if (lives == 0) {
				JOptionPane.showMessageDialog(null, "Game over");
			
			String answer = JOptionPane.showInputDialog("Would you like to play again? ");
			if (answer.equals("yes")) {
gamestart();
			}
			else {
				System.exit(0);
			}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
