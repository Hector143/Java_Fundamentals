package Sample_Test_1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Hospital_Reservation_System.Controller.CRUDS_C;

public class mainFrame_V extends JFrame implements ActionListener{
	public JButton addBut, updateBut, deleteBut, exitBut;
	public DefaultTableModel model;
	public JTable table;
	public JScrollPane scroll;
	public addRecord_V sub;
	public ArrayList<Patient_M> patientList;

	public mainFrame_V() {
		patientList = new ArrayList<>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hospital Records");
		setLayout(new BorderLayout());
		setSize(1000,500);
		setLocationRelativeTo(null);

		JPanel westPanel = new JPanel(new GridLayout(4,1,10,10));
		addBut = new JButton("Add Records");
		updateBut = new JButton("Update Records");
		deleteBut = new JButton("Delete Records");
		exitBut = new JButton("Exit");

		westPanel.add(addBut);
		westPanel.add(updateBut);
		westPanel.add(deleteBut);
		westPanel.add(exitBut);

		JPanel centerPanel = new JPanel(new BorderLayout());
		String[] columnNames = {"Patient ID", "Full Name", "Age", "Gender", "Contact Number", "Admission Date", "Diagnosis"};
		model = new DefaultTableModel(columnNames, 0) {
			@Override 
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scroll = new JScrollPane(table);
		centerPanel.add(scroll);


		addBut.addActionListener(this);
		updateBut.addActionListener(this);
		deleteBut.addActionListener(this);
		exitBut.addActionListener(this);

		add(westPanel, BorderLayout.WEST);
		add(centerPanel, BorderLayout.CENTER);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==addBut) {
			sub = new addRecord_V(this);
		}
		if (e.getSource()==updateBut) {
			try {
				int selectedRow = table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "You must select a row first");
					return;
				}
				
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you are going to update?", "Confirm Update", JOptionPane.YES_NO_OPTION);
				if (confirm != JOptionPane.YES_OPTION) return;
				
				sub = new addRecord_V(this);
				
				Patient_M selected = patientList.get(selectedRow);
				
				sub.txtId.setText(selected.getId());
				sub.txtName.setText(selected.getFullName());
				sub.txtAge.setText(selected.getAge());
				sub.txtGender.setText(selected.getGender());
				sub.txtContactNo.setText(selected.getContactNo());
				sub.txtAdmissionDate.setText(selected.getAdmissionDate());
				sub.txtDiagnosis.setText(selected.getDiagnosis());
				
				sub.saveBut.setVisible(false);
				sub.updateBut.setVisible(true);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Cannot Update");
			}
		}
		if (e.getSource()==deleteBut) {
			try {
				int selectedRow = table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "You must select a row first");
					return;
				}
				
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you are going to update?", "Confirm Update", JOptionPane.YES_NO_OPTION);
				if (confirm != JOptionPane.YES_OPTION) return;
				
				CRUD_C c = new CRUD_C(patientList);
		        c.deleteRecords(selectedRow);
		        refreshTable();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Cannot Delete");
			}
		}
		if (e.getSource()==exitBut) {
			System.exit(0);
		}
	}

	public void refreshTable() {
		model.setRowCount(0);
		for (Patient_M p : patientList) {
			model.addRow(p.getFileInfo());
		}
	}

}
