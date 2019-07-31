package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton("Add Entry");
	JButton button2 = new JButton("Search");
	JButton button3 = new JButton("View List");
	JButton button4 = new JButton("Remove Entry");
	HashMap<Integer, String> IDname = new HashMap<Integer, String>();

	public static void main(String[] args) {
		_02_LogSearch cname = new _02_LogSearch();
		cname.run();
	}

	public void run() {
		frame.add(panel);
		panel.add(button);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		frame.setVisible(true);
		frame.pack();
		button.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);

	}
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 *
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button) {
			
String ID = JOptionPane.showInputDialog("Enter your ID number please");
int IDnumber=Integer.parseInt(ID);
String name = JOptionPane.showInputDialog("Enter your name please");
IDname.put(IDnumber, name);

		}
		else if (e.getSource()== button2) {
			String IDs=JOptionPane.showInputDialog("What is your ID number?");
			int IDsearch =Integer.parseInt(IDs);
			if(IDname.containsKey(IDsearch)) {
				JOptionPane.showMessageDialog(null, IDname.get(IDsearch));
			}
			else {
				JOptionPane.showMessageDialog(null, "This entry doesn't exist");
			}
		}
		else if (e.getSource()== button3) {
		for(Integer i : IDname.keySet()) {
			JOptionPane.showMessageDialog(null,"Id number: " + i + " Name: " + IDname.get(i));
		}
		}
		else {
			String IDr=JOptionPane.showInputDialog("What is your ID number?");
			int IDremove =Integer.parseInt(IDr);
			if(IDname.containsKey(IDremove)) {
			IDname.remove(IDremove, IDname.get(IDremove));
			
			}
			else {
				JOptionPane.showMessageDialog(null, "This entry doesn't exist");
			}
		}
	}

}
