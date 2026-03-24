package Student_Record_System.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Student_Record_System.Controller.File_Handling_C;
import Student_Record_System.Model.Student_M;

public class Student_Management_UI_V extends JFrame implements ActionListener{

	public JLabel idLabel, firstNameLabel, lastNameLabel,
	courseCodeLabel, mathLabel, englishLabel, biologyLabel,
	infoTechLabel, chemistryLabel, physicLabel, headerLabel1,
	headerLabel2, totalScoreLabel, averageLabel, rankingLabel;

	public JTextField txtId, txtFirstName, txtLastName, 
	txtMathematic, txtEnglish, txtBiology, txtInfoTech, 
	txtChemistry, txtPhysic, txtTotalScore, txtAverage, txtRanking;

	public JTextArea transcriptArea;
	public JComboBox<String> courseCode;
	// Button
	public RoundedButton addBut, resultBut, transcriptBut, resetBut,deleteBut, printBut, exitBut;
	// Table
	public DefaultTableModel model;
	public JTable table;
	public JScrollPane tableScroll, textAreaScroll;
	// Model
	public ArrayList<Student_M> studentList = new ArrayList<>();
	// Colors
	private static final Color backgroundColor = new Color(174, 222, 235);
	private static final Color lineColor = new Color(103, 167, 171);
	private static final Color buttonColor = new Color(126, 218, 212);
	private static final Color buttonHoverColor = new Color(192, 252, 248);
	private static final Color buttonPressedColor = new Color(62, 128, 123);

	public Student_Management_UI_V() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Student Record Management System");
		setSize(1220,770);
		setLocationRelativeTo(null);

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(backgroundColor);
		JPanel centerPanel = new JPanel(new BorderLayout(10,10));
		centerPanel.setBackground(backgroundColor);
		JPanel centerWestPanel = new JPanel(new BorderLayout());
		centerWestPanel.setBackground(backgroundColor);
		JPanel studentRecordPanel = new JPanel(new BorderLayout());
		studentRecordPanel.setBorder(BorderFactory.createLineBorder(lineColor, 13));
		studentRecordPanel.setBackground(backgroundColor);

		headerLabel1 = new JLabel(" Student Record");
		headerLabel1.setFont(new Font("", Font.BOLD, 25));
		headerLabel1.setHorizontalAlignment(JLabel.LEFT);

		JPanel westInputPanel = new JPanel(new BorderLayout());
		westInputPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
		westInputPanel.setBackground(backgroundColor);
		JPanel studentInput = new JPanel(new GridLayout(8,2,10,15));
		studentInput.setBackground(backgroundColor);
		idLabel = new JLabel("Student_ID:");
		firstNameLabel = new JLabel("First Name:");
		lastNameLabel = new JLabel("Last Name:");
		courseCodeLabel = new JLabel("Course Code:");

		txtId = new JTextField();
		txtFirstName = new JTextField();
		txtLastName = new JTextField();
		courseCode = new JComboBox<String> (new String[] {
				"ART123", "BUS123", "PHY963", "PSY123", "EDU123", "COM123"
		});

		idLabel.setFont(new Font("", Font.BOLD, 24));
		firstNameLabel.setFont(new Font("", Font.BOLD, 24));
		lastNameLabel.setFont(new Font("", Font.BOLD, 24));
		courseCodeLabel.setFont(new Font("", Font.BOLD, 24));
		txtId.setFont(new Font("", Font.BOLD, 21));
		txtFirstName.setFont(new Font("", Font.BOLD, 21));
		txtLastName.setFont(new Font("", Font.BOLD, 21));
		courseCode.setFont(new Font("", Font.BOLD, 21));

		studentInput.add(idLabel);
		studentInput.add(txtId);
		studentInput.add(firstNameLabel);
		studentInput.add(txtFirstName);
		studentInput.add(lastNameLabel);
		studentInput.add(txtLastName);
		studentInput.add(courseCodeLabel);
		studentInput.add(courseCode);

		//		JPanel studentScore = new JPanel(new GridLayout(3,2,10,10));

		totalScoreLabel = new JLabel("Total Score:");
		averageLabel = new JLabel("Average:");
		rankingLabel = new JLabel("Ranking:");

		txtTotalScore = new JTextField();
		txtAverage = new JTextField();
		txtRanking = new JTextField();

		totalScoreLabel.setFont(new Font("", Font.BOLD, 24));
		averageLabel.setFont(new Font("", Font.BOLD, 24));
		rankingLabel.setFont(new Font("", Font.BOLD, 24));
		txtTotalScore.setFont(new Font("", Font.BOLD, 21));
		txtAverage.setFont(new Font("", Font.BOLD, 21));
		txtRanking.setFont(new Font("", Font.BOLD, 21));

		studentInput.add(new JLabel(""));
		studentInput.add(new JLabel(""));
		studentInput.add(totalScoreLabel);
		studentInput.add(txtTotalScore);
		studentInput.add(averageLabel);
		studentInput.add(txtAverage);
		studentInput.add(rankingLabel);
		studentInput.add(txtRanking);

		txtTotalScore.setEditable(false);
		txtAverage.setEditable(false);
		txtRanking.setEditable(false);

		westInputPanel.add(studentInput);

		JPanel eastInputPanel = new JPanel(new GridLayout(6,2,10,35));
		eastInputPanel.setOpaque(false);

		mathLabel = new JLabel("Mathematic:");
		englishLabel = new JLabel("English:");
		biologyLabel = new JLabel("Biology:");
		infoTechLabel = new JLabel("Info Tech:");
		chemistryLabel = new JLabel("Chemistry:");
		physicLabel = new JLabel("Physic:");

		txtMathematic = new JTextField();
		txtEnglish = new JTextField();
		txtBiology = new JTextField();
		txtInfoTech = new JTextField();
		txtChemistry = new JTextField();
		txtPhysic = new JTextField();

		mathLabel.setFont(new Font("", Font.BOLD, 24));
		englishLabel.setFont(new Font("", Font.BOLD, 24));
		biologyLabel.setFont(new Font("", Font.BOLD, 24));
		infoTechLabel.setFont(new Font("", Font.BOLD, 24));
		chemistryLabel.setFont(new Font("", Font.BOLD, 24));
		physicLabel.setFont(new Font("", Font.BOLD, 24));

		txtMathematic.setFont(new Font("", Font.BOLD, 21));
		txtEnglish.setFont(new Font("", Font.BOLD, 21));
		txtBiology.setFont(new Font("", Font.BOLD, 21));
		txtInfoTech.setFont(new Font("", Font.BOLD, 21));
		txtChemistry.setFont(new Font("", Font.BOLD, 21));
		txtPhysic.setFont(new Font("", Font.BOLD, 21));

		eastInputPanel.add(mathLabel); eastInputPanel.add(txtMathematic);
		eastInputPanel.add(englishLabel); eastInputPanel.add(txtEnglish);
		eastInputPanel.add(biologyLabel); eastInputPanel.add(txtBiology);
		eastInputPanel.add(infoTechLabel); eastInputPanel.add(txtInfoTech);
		eastInputPanel.add(chemistryLabel); eastInputPanel.add(txtChemistry);
		eastInputPanel.add(physicLabel); eastInputPanel.add(txtPhysic);

		westInputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		eastInputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		studentRecordPanel.add(westInputPanel, BorderLayout.WEST);
		studentRecordPanel.add(eastInputPanel, BorderLayout.EAST);

		centerWestPanel.add(headerLabel1,BorderLayout.NORTH);
		centerWestPanel.add(studentRecordPanel,BorderLayout.CENTER);

		JPanel centerEastPanel = new JPanel(new BorderLayout());
		centerEastPanel.setOpaque(false);
		centerEastPanel.setBackground(backgroundColor);

		headerLabel2 = new JLabel(" Transcript");
		headerLabel2.setFont(new Font("", Font.BOLD, 25));
		headerLabel2.setHorizontalAlignment(JLabel.LEFT);

		transcriptArea = new JTextArea();
		transcriptArea.setFont(new Font("", Font.BOLD, 21));
		transcriptArea.setText(
				"Student Result Recording System\n\n" +
						"Full Name: " + txtFirstName.getText() + " " + txtLastName.getText() +
						"     ID: " + txtId.getText() + "\n" +
						"=====================================\n" +
						"Mathematic: " + txtMathematic.getText() + "\n" +
						"English: " + txtEnglish.getText() + "\n" +
						"Biology: " + txtBiology.getText() + "\n" +
						"Info Tech: " + txtInfoTech.getText() + "\n" +
						"Chemistry: " + txtChemistry.getText() + "\n" +
						"Physic: " + txtPhysic.getText() + "\n" +
						"=====================================\n" +
						"Total Score: " + txtTotalScore.getText() + "\n" +
						"Average: " + txtAverage.getText() + "\n" +
						"Ranking: " + txtRanking.getText()
				);
		transcriptArea.setBorder(BorderFactory.createLineBorder(backgroundColor, 10));
		transcriptArea.setEditable(false);
		textAreaScroll = new JScrollPane(transcriptArea);

		JPanel outputPanel = new JPanel(new BorderLayout());
		outputPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));	
		outputPanel.setBorder(BorderFactory.createLineBorder(lineColor, 13));
		outputPanel.setOpaque(false);
		outputPanel.add(textAreaScroll);
		centerEastPanel.add(headerLabel2, BorderLayout.NORTH);
		centerEastPanel.add(outputPanel, BorderLayout.CENTER);

		centerPanel.add(centerWestPanel, BorderLayout.WEST);
		centerPanel.add(centerEastPanel, BorderLayout.CENTER);
		// model
		String[] columnNames = new String[] {"Student ID", "First Name", "Last Name",
				"Course Code", "Math", "English", "Biology", "Info Tech", "Chemistry",
				"Physic", "Total Score", "Average", "Ranking"
		};

		model = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		tableScroll = new JScrollPane(table);
		tableScroll.setPreferredSize(new Dimension(1220, 200));
		JPanel scrollPanel = new JPanel(new BorderLayout());
		scrollPanel.add(tableScroll);

		JPanel bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.setBackground(backgroundColor);

		JPanel buttonsPanel = new JPanel(new GridLayout(1,7,15,10));
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20, 5, 5, 5));
		buttonsPanel.setOpaque(false);

		addBut = new RoundedButton("Add Data");
		addBut.setFont(new Font("", Font.BOLD, 21));
		addBut.setBackground(buttonColor);
		addBut.addMouseListener(new MouseAdapter() {
			@Override 
			public void mouseEntered(MouseEvent e) {
				addBut.setBackground(buttonHoverColor);	
			}

			@Override 
			public void mouseExited(MouseEvent e) {
				addBut.setBackground(buttonColor);	
			}

			@Override 
			public void mousePressed(MouseEvent e) {
				addBut.setBackground(buttonPressedColor);	
			}

			@Override 
			public void mouseReleased(MouseEvent e) {
				addBut.setBackground(buttonColor);	
			}
		});

		resultBut = new RoundedButton("Result");
		resultBut.setFont(new Font("", Font.BOLD, 21));
		resultBut.setBackground(buttonColor);
		resultBut.addMouseListener(new MouseAdapter() {
			@Override 
			public void mouseEntered(MouseEvent e) {
				resultBut.setBackground(buttonHoverColor);	
			}

			@Override 
			public void mouseExited(MouseEvent e) {
				resultBut.setBackground(buttonColor);	
			}

			@Override 
			public void mousePressed(MouseEvent e) {
				resultBut.setBackground(buttonPressedColor);	
			}

			@Override 
			public void mouseReleased(MouseEvent e) {
				resultBut.setBackground(buttonColor);	
			}
		});

		transcriptBut = new RoundedButton("Transcript");
		transcriptBut.setFont(new Font("", Font.BOLD, 21));
		transcriptBut.setBackground(buttonColor);
		transcriptBut.addMouseListener(new MouseAdapter() {
			@Override 
			public void mouseEntered(MouseEvent e) {
				transcriptBut.setBackground(buttonHoverColor);	
			}

			@Override 
			public void mouseExited(MouseEvent e) {
				transcriptBut.setBackground(buttonColor);	
			}

			@Override 
			public void mousePressed(MouseEvent e) {
				transcriptBut.setBackground(buttonPressedColor);	
			}

			@Override 
			public void mouseReleased(MouseEvent e) {
				transcriptBut.setBackground(buttonColor);	
			}
		});

		resetBut = new RoundedButton("Reset");
		resetBut.setFont(new Font("", Font.BOLD, 21));
		resetBut.setBackground(buttonColor);
		resetBut.addMouseListener(new MouseAdapter() {
			@Override 
			public void mouseEntered(MouseEvent e) {
				resetBut.setBackground(buttonHoverColor);	
			}

			@Override 
			public void mouseExited(MouseEvent e) {
				resetBut.setBackground(buttonColor);	
			}

			@Override 
			public void mousePressed(MouseEvent e) {
				resetBut.setBackground(buttonPressedColor);	
			}

			@Override 
			public void mouseReleased(MouseEvent e) {
				resetBut.setBackground(buttonColor);	
			}
		});

		deleteBut = new RoundedButton("Delete");
		deleteBut.setFont(new Font("", Font.BOLD, 21));
		deleteBut.setBackground(buttonColor);
		deleteBut.addMouseListener(new MouseAdapter() {
			@Override 
			public void mouseEntered(MouseEvent e) {
				deleteBut.setBackground(buttonHoverColor);	
			}

			@Override 
			public void mouseExited(MouseEvent e) {
				deleteBut.setBackground(buttonColor);	
			}

			@Override 
			public void mousePressed(MouseEvent e) {
				deleteBut.setBackground(buttonPressedColor);	
			}

			@Override 
			public void mouseReleased(MouseEvent e) {
				deleteBut.setBackground(buttonColor);	
			}
		});

		printBut = new RoundedButton("Print");
		printBut.setFont(new Font("", Font.BOLD, 21));
		printBut.setBackground(buttonColor);
		printBut.addMouseListener(new MouseAdapter() {
			@Override 
			public void mouseEntered(MouseEvent e) {
				printBut.setBackground(buttonHoverColor);	
			}

			@Override 
			public void mouseExited(MouseEvent e) {
				printBut.setBackground(buttonColor);	
			}

			@Override 
			public void mousePressed(MouseEvent e) {
				printBut.setBackground(buttonPressedColor);	
			}

			@Override 
			public void mouseReleased(MouseEvent e) {
				printBut.setBackground(buttonColor);	
			}
		});

		exitBut = new RoundedButton("Exit");
		exitBut.setFont(new Font("", Font.BOLD, 21));
		exitBut.setBackground(buttonColor);
		exitBut.addMouseListener(new MouseAdapter() {
			@Override 
			public void mouseEntered(MouseEvent e) {
				exitBut.setBackground(buttonHoverColor);	
			}

			@Override 
			public void mouseExited(MouseEvent e) {
				exitBut.setBackground(buttonColor);	
			}

			@Override 
			public void mousePressed(MouseEvent e) {
				exitBut.setBackground(buttonPressedColor);	
			}

			@Override 
			public void mouseReleased(MouseEvent e) {
				exitBut.setBackground(buttonColor);	
			}
		});

		buttonsPanel.add(addBut);
		buttonsPanel.add(resultBut);
		buttonsPanel.add(transcriptBut);
		buttonsPanel.add(resetBut);
		buttonsPanel.add(deleteBut);
		buttonsPanel.add(printBut);
		buttonsPanel.add(exitBut);
		bottomPanel.add(scrollPanel, BorderLayout.CENTER);
		bottomPanel.add(buttonsPanel, BorderLayout.SOUTH);

		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		add(mainPanel);
		setVisible(true);
		
		addBut.addActionListener(this);
		resultBut.addActionListener(this);
		transcriptBut.addActionListener(this);
		resetBut.addActionListener(this);
		deleteBut.addActionListener(this);
		printBut.addActionListener(this);
		exitBut.addActionListener(this);
		File_Handling_C c = new File_Handling_C(studentList);
		c.readFromFile();
		refreshTable();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		File_Handling_C c = new File_Handling_C(studentList);
		c.initFile();
		if (e.getSource()== addBut) {
			try {
				String id = txtId.getText().trim();
				String fname = txtFirstName.getText().trim();
				String lname = txtLastName.getText().trim();
				String course = courseCode.getSelectedItem().toString();
				String math = txtMathematic.getText().trim();
				String eng = txtEnglish.getText().trim();
				String bio = txtBiology.getText().trim();
				String tec = txtInfoTech.getText().trim();
				String chem = txtChemistry.getText().trim();
				String phys = txtPhysic.getText().trim();
				String total = txtTotalScore.getText().trim();
				String avg = txtAverage.getText().trim();
				String ranking = txtRanking.getText().trim();

				if (id.isEmpty() || fname.isEmpty() ||
						lname.isEmpty() || course.isEmpty() ||
						math.isEmpty() || eng.isEmpty() ||
						bio.isEmpty() || tec.isEmpty() ||
						chem.isEmpty() || phys.isEmpty() ||
						total.isEmpty() || avg.isEmpty() ||
						ranking.isEmpty()) {
					JOptionPane.showMessageDialog(this, "You must fill the fields first.");
					return;
				}
				
				if (c.isDuplicate(id)) {
					JOptionPane.showMessageDialog(this, "Duplicate Student ID");
					return;
				}
				
				Student_M s = new Student_M(id,fname,lname,course,
						Integer.parseInt(math),
						Integer.parseInt(eng),
						Integer.parseInt(bio),
						Integer.parseInt(tec),
						Integer.parseInt(chem),
						Integer.parseInt(phys),
						Integer.parseInt(total),
						Integer.parseInt(avg),
						ranking);
				c.add(s);
				refreshTable();
				JOptionPane.showMessageDialog(this, "Student added successfully!");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Cannot Add!", "Error Message", JOptionPane.ERROR_MESSAGE);
				return;
			}
			return;
		}

		if (e.getSource()==resultBut) {
			try {
				String id = txtId.getText().trim();
				String fname = txtFirstName.getText().trim();
				String lname = txtLastName.getText().trim();
				String course = courseCode.getSelectedItem().toString();
				String math = txtMathematic.getText().trim();
				String eng = txtEnglish.getText().trim();
				String bio = txtBiology.getText().trim();
				String tec = txtInfoTech.getText().trim();
				String chem = txtChemistry.getText().trim();
				String phys = txtPhysic.getText().trim();
				
				if (id.isEmpty() || fname.isEmpty() ||
						lname.isEmpty() || course.isEmpty() ||
						math.isEmpty() || eng.isEmpty() ||
						bio.isEmpty() || tec.isEmpty() ||
						chem.isEmpty() || phys.isEmpty()) {
					JOptionPane.showMessageDialog(this, "You must fill the fields first.");
					return;
				}
				
				int math1 = Integer.parseInt(txtMathematic.getText().trim());
				int eng1 = Integer.parseInt(txtEnglish.getText().trim());
				int bio1 = Integer.parseInt(txtBiology.getText().trim());
				int tec1 = Integer.parseInt(txtInfoTech.getText().trim());
				int chem1 = Integer.parseInt(txtChemistry.getText().trim());
				int phys1 = Integer.parseInt(txtPhysic.getText().trim());

				int total1 = math1 + eng1 + bio1 + tec1 + chem1 + phys1;
				int average = total1 / 6;
				String ranking1 = "";

				if (average >= 90 && average <= 100) {
					ranking1 = "1st";
				} else if (average >= 80 && average <= 89) {
					ranking1 = "2nd";
				} else if (average >= 75 && average <= 79) {
					ranking1 = "3rd";
				} else if (average >= 0 && average <= 74) {
					ranking1 = "eliminated";
				} else {
					ranking1 = "Invalid!";
				}

				txtTotalScore.setText(Integer.toString(total1));
				txtAverage.setText(Integer.toString(average));
				txtRanking.setText(ranking1);
				JOptionPane.showMessageDialog(null, "Result has been Calculated!");
				return;
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Result Invalid!", "Error Message", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if (e.getSource()==transcriptBut) {
			try {
				Student_M student = new Student_M(
						txtId.getText(),
						txtFirstName.getText(),
						txtLastName.getText(),
						courseCode.getSelectedItem().toString(),
						Integer.parseInt(txtMathematic.getText()),
						Integer.parseInt(txtEnglish.getText()),
						Integer.parseInt(txtBiology.getText()),
						Integer.parseInt(txtInfoTech.getText()),
						Integer.parseInt(txtChemistry.getText()),
						Integer.parseInt(txtPhysic.getText()),
						Integer.parseInt(txtTotalScore.getText()),
						Integer.parseInt(txtAverage.getText()),
						txtRanking.getText()
						);

				transcriptArea.setText(student.getTranscript());
				return;
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Transcript Error!", "Error Message", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if (e.getSource()==resetBut) {
			txtId.setText("");
			txtFirstName.setText("");
			txtLastName.setText("");
			courseCode.setSelectedIndex(0);
			txtMathematic.setText("");
			txtEnglish.setText("");
			txtBiology.setText("");
			txtInfoTech.setText("");
			txtChemistry.setText("");
			txtPhysic.setText("");
			txtTotalScore.setText("");
			txtAverage.setText("");
			txtRanking.setText("");
		}
		if (e.getSource()==deleteBut) {
			try {
				int selectedRow = table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(this, "You must select a row to delete.");
					return;
				}

				int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you are going to delete this row?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
				if (confirm != JOptionPane.YES_OPTION) return;

				c.delete(selectedRow);
				refreshTable();
				JOptionPane.showMessageDialog(this, "Student Deleted Successfully!");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Result Invalid!", "Error Message", JOptionPane.ERROR_MESSAGE);
				return;
			}
			return;
		}
		if (e.getSource()==printBut) {
			try { 
				boolean complete = transcriptArea.print();
				if (complete) { 
					JOptionPane.showMessageDialog(this, "Printing Complete"); 
				} else { 
					JOptionPane.showMessageDialog(this, "Printing Cancelled"); 
				} 
			} catch (Exception ex) { 
				JOptionPane.showMessageDialog(this, "Cannot Print the Records", "Error Message", JOptionPane.ERROR_MESSAGE); 
				return;
			}
			return;
		}
		if (e.getSource()==exitBut) {
			System.exit(0);
		}
	}

	private void refreshTable() {
		model.setRowCount(0);
		for (Student_M s : studentList) {
			model.addRow(s.getFileInfo());
		}
	}

}
