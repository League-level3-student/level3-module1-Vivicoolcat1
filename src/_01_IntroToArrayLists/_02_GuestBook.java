package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.MissingFormatArgumentException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other
	// button reads "View Names".
	// When the add name button is clicked, display an input dialog that asks the
	// user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a
	// message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	JFrame frame = new JFrame("Guest List");
	JPanel panel = new JPanel();
	JButton button = new JButton("Add Name");
	JButton button2 = new JButton("View Names");
	ArrayList<String> names;

	public static void main(String[] args) {

		_02_GuestBook guestbook = new _02_GuestBook();
		guestbook.run();

	}

	public void run() {
		names = new ArrayList<String>();
		frame.add(panel);
		panel.add(button);
		panel.add(button2);
		frame.setVisible(true);
		frame.setSize(700, 800);
		button.addActionListener(this);
		button2.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (button == e.getSource()) {
			String guestAdded = JOptionPane.showInputDialog(null, "Add a guest");
			names.add(guestAdded);
		}
		if (button2 == e.getSource()) {

			for (int i = 0; i < names.size(); i++) {

				JOptionPane.showMessageDialog(null, " Guest # " + i  + ": " + names.get(i));
			}
		}

	}

}
