package CCE_103;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Account_Management {
	// Buttons
	private JButton add;
	private JButton delete;
	private JButton back;
	
	public JFrame frame = new JFrame();
	public DefaultTableModel model;
	
	private Application addWindow = null;
	public UserController controller;
	
	public Account_Management() {
		controller = new UserController(new ArrayList<>());
		controller.initFile();
		controller.readFromFile();
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Account Management");
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		frame.setContentPane(panel);
		String[] columnNames = {"Username","Password"};
		
		model = new DefaultTableModel(columnNames, 0) {
			@Override 
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		refreshTable();
		
		JTable table = new JTable(model);
		table.setFillsViewportHeight(true);
		//		table.setBounds(0,0,400,420);
		//		add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
//		scrollPane.setBounds(0, 0, 400, 420); // Bounds for the ScrollPane if using null layout on parent
		panel.add(scrollPane, BorderLayout.CENTER);
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
		add = new JButton("add");
		add.addActionListener(e -> {
		    showApplication(); // opens your full signup window
		});
		buttonPanel.add(add);
		
		delete = new JButton("delete");
		delete.addActionListener(e -> {

		    int row = model.getRowCount();

		    if (row == -1) {
		        JOptionPane.showMessageDialog(frame, "Select a user first");
		        return;
		    }

		    String username = model.getValueAt(row, 0).toString();

		    controller.readFromFile();

		    ArrayList<User> users = controller.userList;

		    for (int i = 0; i < users.size(); i++) {
		        if (users.get(i).getUsername().equals(username)) {
		            users.remove(i);
		            break;
		        }
		    }

		    controller.saveToFile();
		    refreshTable();
		});
		buttonPanel.add(delete);
		
		back = new JButton("back");
		back.addActionListener(e -> {
			disposeWindow();
		});
		buttonPanel.add(back);
		
		panel.add(buttonPanel, BorderLayout.SOUTH);
		frame.setSize(450,520);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
	
	public void showApplication() {
	    if (addWindow == null) {
	        addWindow = new Application();

	        // refresh reference when window closes
	        addWindow.getFrame().addWindowListener(new java.awt.event.WindowAdapter() {
	            @Override
	            public void windowClosed(java.awt.event.WindowEvent e) {
	                addWindow = null;

	                // refresh table after adding user
	                refreshTable();
	            }
	        });
	    } else {
	        addWindow.getFrame().toFront();
	        addWindow.getFrame().requestFocus();
	    }
	}
	
	public void disposeWindow() {
		frame.dispose();
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void refreshTable() {
	    model.setRowCount(0);

	    ArrayList<User> users = FileHandler.loadUsers();

	    for (User u : users) {
	        model.addRow(new Object[]{
	                u.getUsername(),
	                u.getPassword()
	        });
	    }
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Account_Management());
	}
}