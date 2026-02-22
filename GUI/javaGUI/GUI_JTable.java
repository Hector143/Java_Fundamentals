package javaGUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;

public class GUI_JTable extends JFrame{

	public static void main(String[] args) {
		new GUI_JTable();

	}
	
	GUI_JTable() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,600);
		this.setTitle("Java GUI Demo");
		this.setLocationRelativeTo(null);
//		this.setLayout(null);
		
		String[] columnNames = {"First Name", "Last Name", "Job", "Experience", "Intern"};
		Object[][] data = { 
			    { "Paul", "McMills", "Project Manager", 5, false }, 
			    { "Kyle", "Jones", "IT Manager", 8, false }, 
			    { "Doe", "Peter", "Developer", 1, true },
			    { "John", "Evans", "QA Manager", 4, false}
			};
		
		JTable table = new JTable(data,columnNames);
//		table.getTableHeader().setBounds(50,0,700,50);
//		table.setBounds(50,50,700,200);
		
		table.setCellSelectionEnabled(true);
		ListSelectionModel select = table.getSelectionModel();
		select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		select.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				String data = null;
				int[] row = table.getSelectedRows();
				int[] column = table.getSelectedColumns();
				
				for (int i = 0; i < row.length; i++) {
					for (int j = 0; j < column.length; j++) {
						data = (String)table.getValueAt(row[i], column[j]);
					}
				}
				System.out.println("The data you selected is : " + data);
			}
			
		});
		
		JScrollPane scp = new JScrollPane(table);
//		scp.setBounds(50,50,700,70);
		table.setFillsViewportHeight(true);
		
		TableColumn column = null;
		for (int i = 0; i < 5; i++) {
			column = table.getColumnModel().getColumn(i);
			if (i == 0) {
				column.setPreferredWidth(200);
			} else {
				column.setPreferredWidth(50);
			}
		}
		this.add(scp);
		
//		this.add(table.getTableHeader());
//		this.add(table);
//		this.add(table.getTableHeader(),BorderLayout.PAGE_START);
//		this.add(table,BorderLayout.CENTER);
		this.setVisible(true);
	}

}
