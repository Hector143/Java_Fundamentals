package javaGUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class GUI_JComboBox extends JFrame implements ActionListener {
	JComboBox comboBox;
	Object[] arr = {15, "hello world", 'C', "chemicals", 4.5};
	public static void main(String[] args) {
		new GUI_JComboBox();
	}
	
	GUI_JComboBox() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		String[] animals = {"dog","cat","bird"}; // must be Reference and does not work with Primitive types
		
		comboBox = new JComboBox(animals);
		comboBox.addActionListener(this);
		
//		comboBox.setEditable(true);
//		System.out.println(comboBox.getItemCount());
//		comboBox.addItem("horse");
//		comboBox.insertItemAt("pig", 0);
//		comboBox.setSelectedIndex(0); // set default selected to the very top
//		comboBox.removeItem("cat");
//		comboBox.removeItemAt(0);
//		comboBox.removeAllItems();
		
		this.add(comboBox);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == comboBox) {
			System.out.println(comboBox.getSelectedItem()); // returns the element
			System.out.println(comboBox.getSelectedIndex()); // returns the index of the element
		}
		
	}

}
