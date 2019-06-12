package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	String currentChar = "";
	JFrame frame;
	JPanel panel;
	JLabel label;
	Stack<Character> textundo = new Stack <Character>();
	public static void main(String[] args) {
		_02_TextUndoRedo text = new _02_TextUndoRedo();
		text.start();
	}
	
	 public void start() {
		 label = new JLabel();
		
		 frame=new JFrame();
		 panel=new JPanel();
		 frame.add(panel);
		 panel.add(label);
		 
frame.setVisible(true);

frame.addKeyListener(this);
	 }
	
	

		
		
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	
		
		if(e.getKeyCode()== KeyEvent.VK_BACK_SPACE) {
			System.out.println("printed");
			textundo.push(currentChar.charAt( currentChar.length() - 1));
			currentChar = currentChar.substring(0, currentChar.length()-1);
			label.setText(currentChar);
		}
		else if (e.getKeyCode ()== KeyEvent.VK_F1) {
			currentChar = currentChar + textundo.pop();
			
			label.setText(currentChar);
		}
		else {
			 currentChar =currentChar + e.getKeyChar();
			 label.setText( currentChar);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
