package Sample_Test_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class addRecord_V extends JFrame implements ActionListener {
	
	public JLabel idLabel, nameLabel, ageLabel, genderLabel, contactLabel, dateLabel, diagnosisLabel;
	public JTextField txtId, txtName, txtAge, txtGender, txtContactNo, txtAdmissionDate, txtDiagnosis;
	public JButton saveBut, updateBut;
	public mainFrame_V mainUI;
	addRecord_V(mainFrame_V mainUI) {
		this.mainUI = mainUI;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Add Records");
		setLayout(new BorderLayout());
		setSize(500,500);
		setLocationRelativeTo(null);
		
		
		JPanel mainPanel = new JPanel(new GridLayout(8,2,10,10));
		mainPanel.setBackground(Color.cyan);
		idLabel = new JLabel("Patient ID");
		nameLabel = new JLabel("Patient Name");
		ageLabel = new JLabel("Age");
		genderLabel = new JLabel("Gender");
		contactLabel = new JLabel("Contact Number");
		dateLabel = new JLabel("Admission Date");
		diagnosisLabel = new JLabel("Diagnosis");
		
		txtId = new JTextField();
		txtName = new JTextField();
		txtAge = new JTextField();
		txtGender = new JTextField();
		txtContactNo = new JTextField();
		txtAdmissionDate = new JTextField();
		txtDiagnosis = new JTextField();
		
		saveBut = new JButton("Save");
		updateBut = new JButton("Update");
		
		mainPanel.add(idLabel); mainPanel.add(txtId);
		mainPanel.add(nameLabel); mainPanel.add(txtName);
		mainPanel.add(ageLabel); mainPanel.add(txtAge);
		mainPanel.add(genderLabel); mainPanel.add(txtGender);
		mainPanel.add(contactLabel); mainPanel.add(txtContactNo);
		mainPanel.add(dateLabel); mainPanel.add(txtAdmissionDate);
		mainPanel.add(diagnosisLabel); mainPanel.add(txtDiagnosis);
		mainPanel.add(saveBut); mainPanel.add(updateBut);
		add(mainPanel);
		
		updateBut.setVisible(false);
		saveBut.addActionListener(this);
		updateBut.addActionListener(this);
		dispose();
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==saveBut) {
			try {
				CRUD_C c = new CRUD_C(mainUI.patientList);
				String id = txtId.getText().trim();
				String name = txtName.getText().trim();
				String age = txtAge.getText().trim();
				String gender = txtGender.getText().trim();
				String contact = txtContactNo.getText().trim();
				String date = txtAdmissionDate.getText().trim();
				String diag = txtDiagnosis.getText().trim();
				
				if (c.isDuplicate(id)) {
					JOptionPane.showMessageDialog(this, "Duplicate ID!");
					return;
				}
				
				Patient_M p = new Patient_M(id,name,age,gender,contact,date,diag);
				c.addRecords(p);
				mainUI.refreshTable();
				JOptionPane.showMessageDialog(this,"Record Added!");
				dispose();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Cannot Save!");
			}
		}
		
		if (e.getSource() == updateBut) {
			try {
				CRUD_C c = new CRUD_C(mainUI.patientList);
				String id = txtId.getText().trim();
				String name = txtName.getText().trim();
				String age = txtAge.getText().trim();
				String gender = txtGender.getText().trim();
				String contact = txtContactNo.getText().trim();
				String date = txtAdmissionDate.getText().trim();
				String diag = txtDiagnosis.getText().trim();
				
				Patient_M p = new Patient_M(id,name,age,gender,contact,date,diag);
				int row = mainUI.table.getSelectedRow();
				c.updateRecords(row, p);
				mainUI.refreshTable();
				JOptionPane.showMessageDialog(this,"Update Successfully!");
				dispose();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Cannot Update!");
			}
		}
	}

}
