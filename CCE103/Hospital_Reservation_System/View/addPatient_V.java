package Hospital_Reservation_System.View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Hospital_Reservation_System.View.mainGUI_V;
import Hospital_Reservation_System.Controller.CRUDS_C;
import Hospital_Reservation_System.Model.Patient_M;

public class addPatient_V extends JFrame implements ActionListener{

	public JLabel idLabel, nameLabel, ageLabel, genderLabel, contactNoLabel, dateLabel, diagnosisLabel, emptyLabel;
	public JTextField txtId, txtName, txtAge, txtContactNo, txtDate, txtDiagnosis;
	public JComboBox<String> selectGender;
	public JButton saveBut, updateBut;
	public mainGUI_V mainGUI_V;

	public addPatient_V(mainGUI_V g) {
		this.mainGUI_V = g;
		setLayout(new GridLayout(8,2,5,5));
		setTitle("Add Record");
		setSize(500,500);
		setLocationRelativeTo(null);

		idLabel = new JLabel("Patient ID:");
		nameLabel = new JLabel("Patient Name:");
		ageLabel = new JLabel("Age:");
		genderLabel = new JLabel("Gender:");
		contactNoLabel = new JLabel("Contact Number:");
		dateLabel = new JLabel("Admission Date: (YYYY-MM-DD)");
		diagnosisLabel = new JLabel("Diagnosis:");
		emptyLabel = new JLabel("");

		txtId = new JTextField();
		txtName = new JTextField();
		txtAge = new JTextField();
		txtContactNo = new JTextField();
		txtDate = new JTextField();
		txtDiagnosis = new JTextField();
		selectGender = new JComboBox<String>(new String[] {
				"Male", "Female", "Others"
		});
		saveBut = new JButton("Save");
		updateBut = new JButton("Update");

		add(idLabel);add(txtId);
		add(nameLabel);add(txtName);
		add(ageLabel);add(txtAge);
		add(genderLabel);add(selectGender);
		add(contactNoLabel);add(txtContactNo);
		add(dateLabel);add(txtDate);
		add(diagnosisLabel);add(txtDiagnosis);
		add(saveBut); add(updateBut);
		
		updateBut.setVisible(false);
		saveBut.addActionListener(this);
		updateBut.addActionListener(this);
		setVisible(true);
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==saveBut){
			try{
				CRUDS_C c = new CRUDS_C(mainGUI_V.patientList);
				String id = txtId.getText().trim();
				String name = txtName.getText().trim();
				int age = Integer.parseInt(txtAge.getText().trim());
				String gender = selectGender.getSelectedItem().toString();
				String contact = txtContactNo.getText().trim();
				String date = txtDate.getText().trim();
				String diag = txtDiagnosis.getText().trim();
				
				if(c.isDuplicate(id)){
					JOptionPane.showMessageDialog(this,"Patient ID already exists!");
					return;
				}
				
				Patient_M p = new Patient_M(id,name,age,gender,contact,date,diag);
				c.add(p); // controller stores model
				mainGUI_V.refreshTable(); // update table
				JOptionPane.showMessageDialog(this,"Record Added!");
				dispose();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(this,"Invalid Input!");
			}
		}
		if(e.getSource()==updateBut){
			try{
				CRUDS_C c = new CRUDS_C(mainGUI_V.patientList);
				String id = txtId.getText().trim();
				String name = txtName.getText().trim();
				int age = Integer.parseInt(txtAge.getText().trim());
				String gender = selectGender.getSelectedItem().toString();
				String contact = txtContactNo.getText().trim();
				String date = txtDate.getText().trim();
				String diag = txtDiagnosis.getText().trim();
				
				Patient_M p = new Patient_M(id,name,age,gender,contact,date,diag);
				int row = mainGUI_V.table.getSelectedRow();
				c.update(row, p);
				mainGUI_V.refreshTable();
				JOptionPane.showMessageDialog(this,"Record Updated!");
				dispose();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(this,"Invalid Input!");
			}
		}
		
	}
	
}
