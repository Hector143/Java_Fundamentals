package Hospital_Reservation_System.View;

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
import Hospital_Reservation_System.Model.Patient_M;

public class mainGUI_V extends JFrame implements ActionListener{

	public JButton createBut, updateBut, deleteBut, exitBut;
	public DefaultTableModel model;
	public JTable table;
	public JScrollPane scroll;
	public ArrayList<Patient_M> patientList;
	public addPatient_V p;

	public mainGUI_V() {
		patientList = new ArrayList<>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setTitle("Add Record");
		setSize(1000,500);
		setLocationRelativeTo(null);
		JPanel westPanel = new JPanel(new GridLayout(4,1,5,5));

		createBut = new JButton("Add Record");
		updateBut = new JButton("Update Record");
		deleteBut = new JButton("Delete Record");
		exitBut = new JButton("Exit");

		createBut.addActionListener(this);
		updateBut.addActionListener(this);
		deleteBut.addActionListener(this);
		exitBut.addActionListener(this);

		createBut.setFocusable(false);
		updateBut.setFocusable(false);
		deleteBut.setFocusable(false);
		exitBut.setFocusable(false);

		westPanel.add(createBut);
		westPanel.add(updateBut);
		westPanel.add(deleteBut);
		westPanel.add(exitBut);

		JPanel centerPanel = new JPanel(new BorderLayout());

		String[] columnNames = {"Patient ID", "Full Name", "Age", "Gender", "Contanct Number", "Admission Date", "Diagnosis"};
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
		add(westPanel, BorderLayout.WEST);
		add(centerPanel, BorderLayout.CENTER);
		setVisible(true);
		CRUDS_C c = new CRUDS_C(patientList);
		c.readFile();
		refreshTable();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == createBut) {
	        p = new addPatient_V(this);
	    }

	    if (e.getSource() == deleteBut) {
	        int row = table.getSelectedRow();
	        if(row == -1){
	            JOptionPane.showMessageDialog(this,"Select a record first");
	            return;
	        }
	        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you are going to delete Patient Record?", "Confirm Delete", JOptionPane.ERROR_MESSAGE);
	        if (confirm != JOptionPane.YES_OPTION) 
	        	return;

	        CRUDS_C c = new CRUDS_C(patientList);
	        c.delete(row);
	        refreshTable();
	    }

	    if (e.getSource() == updateBut) {
	        int row = table.getSelectedRow();
	        if(row == -1){
	            JOptionPane.showMessageDialog(this,"Select a record first");
	            return;
	        }
	        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you are going to update Patient Record?", "Confirm Update", JOptionPane.ERROR_MESSAGE);
	        if (confirm != JOptionPane.YES_OPTION) 
	        	return;
	        
	        p = new addPatient_V(this);

	        Patient_M selected = patientList.get(row);

	        p.txtId.setText(selected.getId());
	        p.txtName.setText(selected.getFullName());
	        p.txtAge.setText(Integer.toString(selected.getAge()));
	        p.selectGender.setSelectedItem(selected.getGender());
	        p.txtContactNo.setText(selected.getContactNum());
	        p.txtDate.setText(selected.getDate());
	        p.txtDiagnosis.setText(selected.getDiagnosis());
	        
	        p.saveBut.setVisible(false);
	    	p.updateBut.setVisible(true);
	        
	    }
	    if (e.getSource() == exitBut) {
	        System.exit(0);
	    }
	}
	
	public void refreshTable(){
	    model.setRowCount(0);
	    for(Patient_M p : patientList){
	        model.addRow(p.getInfo());
	    }
	}

}
