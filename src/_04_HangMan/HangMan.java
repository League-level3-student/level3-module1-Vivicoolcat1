package _04_HangMan;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan{
	JFrame frame;
	 JPanel panel;
	 JLabel label1;
	 Stack <String> hangmanwords = new Stack <String>();
	public static void main(String[] args) {
		HangMan man = new HangMan ();
		man.start();
	}
	public void start () {
		String blank = "_";
	frame= new JFrame();
	panel = new JPanel();
	label1= new JLabel();
	frame.add(panel);
	panel.add(label1);
	frame.setVisible(true);
	
	String howmany =JOptionPane.showInputDialog("Pick how many words you want to do up to 266");
	int howmany2 =Integer.parseInt(howmany);
String word =	Utilities.readRandomLineFromFile("dictionary.txt");

	for (int i = 0; i < howmany2; i++) {
		hangmanwords.push(word);
		System.out.println("hi");
		
	}
	String wordpop =hangmanwords.pop();
	for (int i = 0; i < wordpop.length(); i++) {
		blank = blank + blank;
	}

	label1.setText(blank);

	}
	
	
}
