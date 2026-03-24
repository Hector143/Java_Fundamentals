package Java_GUI_Example2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class CCE107_GUI_CRUD extends JFrame{
    private static final String FILE_NAME = "student.txt";
    private static final String DELIMITER = "#";
    private static File file = new File(FILE_NAME);

    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollPane;

    private JButton btnRegister;

    private JTextField txtfullname, txtemail, txtadd, txtcont;
    private JComboBox<String> comgen;
    private ArrayList<String> lines;

    CCE107_GUI_CRUD() {


        JLabel lblHeader = new JLabel("ENROLLMENT SYSTEM");
        lblHeader.setFont(new Font("Gilroy-Bold", Font.PLAIN, 24));
        lblHeader.setForeground(Color.red);
        lblHeader.setBounds(62, 81, 354, 70);
        add(lblHeader);

        JLabel lblfullname = new JLabel("Fullname");
        lblfullname.setFont(new Font("Gilroy-Regular", Font.PLAIN, 14));
        lblfullname.setBounds(62, 147, 66, 14);
        add(lblfullname);

        txtfullname = new JTextField(5);
        txtfullname.setBounds(62, 162, 244, 27);
        add(txtfullname);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Gilroy-Regular", Font.PLAIN, 14));
        lblEmail.setBounds(62, 200, 66, 14);
        add(lblEmail);

        txtemail = new JTextField();
        txtemail.setBounds(62, 215, 244, 27);
        add(txtemail);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setFont(new Font("Gilroy-Regular", Font.PLAIN, 14));
        lblAddress.setBounds(62, 253, 66, 14);
        add(lblAddress);

        txtadd = new JTextField();
        txtadd.setBounds(62, 268, 244, 27);
        add(txtadd);

        JLabel lblContactNumber = new JLabel("Contact Number");
        lblContactNumber.setFont(new Font("Gilroy-Regular", Font.PLAIN, 14));
        lblContactNumber.setBounds(62, 306, 115, 14);
        add(lblContactNumber);

        txtcont = new JTextField();
        txtcont.setBounds(62, 321, 244, 27);
        add(txtcont);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setFont(new Font("Gilroy-Regular", Font.PLAIN, 14));
        lblGender.setBounds(62, 359, 66, 14);
        add(lblGender);

        comgen = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        comgen.setFont(new Font("Gilroy-Regular", Font.PLAIN, 14));
        comgen.setBounds(62, 374, 244, 27);
        add(comgen);

        btnRegister = new JButton("Register");
        btnRegister.setBackground(new Color(0x14C600));
        btnRegister.setForeground(Color.WHITE);
        btnRegister.setFont(new Font("Gilroy-Regular", Font.PLAIN, 11));
        btnRegister.setBounds(230, 559, 80, 28);
        add(btnRegister);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBackground(new Color(0xFFE856));
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setFont(new Font("Gilroy-Regular", Font.PLAIN, 11));
        btnUpdate.setBounds(140, 559, 80, 28);
        add(btnUpdate);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBackground(new Color(255, 0, 0));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setFont(new Font("Gilroy-Regular", Font.PLAIN, 11));
        btnDelete.setBounds(50, 559, 80, 28);
        add(btnDelete);


        String[] columns = {"Name", "Email", "Address", "Contact", "Gender"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(350, 150, 600, 400);
        add(scrollPane);

//        table.setBackground(new Color(138, 255, 217));
//        table.setGridColor(new Color(255, 255, 255, 0));

        refreshTable();

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });


        btnRegister.addActionListener(e -> {
            registerStudent();
        });


        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    txtfullname.setText(model.getValueAt(row, 0).toString());
                    txtemail.setText(model.getValueAt(row, 1).toString());
                    txtadd.setText(model.getValueAt(row, 2).toString());
                    txtcont.setText(model.getValueAt(row, 3).toString());
                    comgen.setSelectedItem(model.getValueAt(row, 4).toString());
                }
            }
        });

//        JLabel lblNewLabel_2 = new JLabel("New label");
//        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Jude\\Pictures\\Picture1.png"));
//        lblNewLabel_2.setBounds(0, 0, 1013, 653);
//        getContentPane().add(lblNewLabel_2);


        setTitle("Enrollment System");
        setSize(1029, 692);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }


    //Methods


    private void registerStudent() {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            String fullname = txtfullname.getText();
            String email = txtemail.getText();
            String address = txtadd.getText();
            String contact = txtcont.getText();
            String gender = (String) comgen.getSelectedItem();

            bw.write(fullname + DELIMITER + email + DELIMITER + address
                    + DELIMITER + contact + DELIMITER + gender);

            bw.newLine();

            JOptionPane.showMessageDialog(this, "Enrolled");


            clearFields();

        } catch (IOException x) {
            JOptionPane.showMessageDialog(this, "Error saving: " + x.getMessage());
        }

        refreshTable();
    }


    //update
    private void updateStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a record to update.");
            return;
        }

        lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int rowIndex = 0;
            while ((line = br.readLine()) != null) {
                if (rowIndex == selectedRow) {
                    String updatedRecord =
                            txtfullname.getText() + DELIMITER +
                                    txtemail.getText() + DELIMITER +
                                    txtadd.getText() + DELIMITER +
                                    txtcont.getText() + DELIMITER +
                                    comgen.getSelectedItem().toString();

                    lines.add(updatedRecord);
                } else {
                    lines.add(line);
                }
                rowIndex++;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage());
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String record : lines) {
                bw.write(record);
                bw.newLine();
            }
            JOptionPane.showMessageDialog(this, "Updated Successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error updating file: " + e.getMessage());
        }

        clearFields();
        refreshTable();
    }


    //delete
    private void deleteStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a record to delete.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        //System.out.println(confirm);
        if (confirm != JOptionPane.YES_OPTION) return;

        lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int rowIndex = 0;
            while ((line = br.readLine()) != null) {
                if (rowIndex != selectedRow) lines.add(line);
                rowIndex++;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage());
            return;
        }


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String record : lines) bw.write(record + "\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage());
        }

        JOptionPane.showMessageDialog(this, "Record Deleted!");
        clearFields();
        refreshTable();
    }

    //show table
    private void refreshTable() {
        model.setRowCount(0);
        initFile();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(DELIMITER);
                model.addRow(row);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void initFile() {
    	try {
    		if (!file.exists()) {
    			file.createNewFile();
    		}
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(this,"Cannot Create File!","Error Message", JOptionPane.ERROR_MESSAGE);
    		return;
    	}
    }


    //Methods
    public void clearFields() {
        txtfullname.setText(null);
        txtemail.setText("");
        txtadd.setText("");
        txtcont.setText("");
        comgen.setSelectedIndex(0);
    }


    public static void main(String[] args) {
        new CCE107_GUI_CRUD();
    }

}