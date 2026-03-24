package Second_Lab_Exam_Preparation.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Second_Lab_Exam_Preparation.Controller.*;
import Second_Lab_Exam_Preparation.Model.Asset;

public class mainWindow extends JFrame {

	public JButton createBut;
	public JButton readBut;
	public JButton updateBut;
	public JButton deleteBut;
	public JButton searchBut;

	JLabel assetIDLabel;
	JLabel assetNameLabel;
	JLabel catLabel;
	JLabel dateLabel;
	JLabel costLabel;
	JLabel statusLabel;
	JLabel locLabel;
	JLabel descriptionLabel;

	public JTextField txtId;
	public JTextField txtName;
	public JTextField txtDate;
	public JTextField txtCost;
	public JTextField txtDescription;
	public JComboBox<String> checkLoc = null;
	public JComboBox<String> selectCategory  = null;
	public JCheckBox checkStatus;

	private ArrayList<Asset> assetList = new ArrayList<Asset>();
	public static DefaultTableModel model;
	public JTable table;
	public JScrollPane scroll;
	public Read r;

	public static final String fileName = "assets.txt";

	public mainWindow() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,700);
		setLocationRelativeTo(null);
		setTitle("Asset Management");

		// Top
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.setBackground(new Color(35,65, 100));

		JLabel header = new JLabel("Asset Management System");
		header.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		header.setForeground(Color.white);
		header.setFont(new Font("serif", Font.BOLD, 50));
		header.setHorizontalAlignment(JLabel.CENTER);

		JPanel inputPanel = new JPanel(new GridLayout(8,2,10,10));
		inputPanel.setBackground(new Color(25,100, 180));
		inputPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

		assetIDLabel = new JLabel("Asset ID");
		assetNameLabel = new JLabel("Asset Name");
		catLabel = new JLabel("Category");
		dateLabel = new JLabel("Purchase Date");
		costLabel = new JLabel("Cost");
		statusLabel = new JLabel("Status");
		locLabel = new JLabel("Location");
		descriptionLabel = new JLabel("Description");

		assetIDLabel.setForeground(Color.white);
		assetNameLabel.setForeground(Color.white);
		catLabel.setForeground(Color.white);
		dateLabel.setForeground(Color.white);
		costLabel.setForeground(Color.white);
		statusLabel.setForeground(Color.white);
		locLabel.setForeground(Color.white);
		descriptionLabel.setForeground(Color.white);

		txtId = new JTextField();
		txtName = new JTextField();
		txtDate = new JTextField();
		txtCost = new JTextField();
		txtDescription = new JTextField();
		checkLoc = new JComboBox<String>(new String[] {
				"Branch Office", "Head Office"});
		selectCategory = new JComboBox<String>(new String[] {
				"Desktop", "Laptop", "Macbook", "Mobile"});
		checkStatus = new JCheckBox("In Use");
		checkStatus.setHorizontalAlignment(JCheckBox.CENTER);

		inputPanel.add(assetIDLabel);
		inputPanel.add(txtId);
		inputPanel.add(assetNameLabel);
		inputPanel.add(txtName);
		inputPanel.add(catLabel);
		inputPanel.add(selectCategory);
		inputPanel.add(dateLabel);
		inputPanel.add(txtDate);
		inputPanel.add(costLabel);
		inputPanel.add(txtCost);
		inputPanel.add(statusLabel);
		inputPanel.add(checkStatus);
		inputPanel.add(locLabel);
		inputPanel.add(checkLoc);
		inputPanel.add(descriptionLabel);
		inputPanel.add(txtDescription);

		topPanel.add(header, BorderLayout.NORTH);
		topPanel.add(inputPanel, BorderLayout.CENTER);

		// Center
		JPanel tablePanel = new JPanel(new BorderLayout());

		String[] columnNames = {"Asset ID", "Asset Name", "Category", 
				"Purchase Date", "Cost", "Status", "Location", "Description"};
		model = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// Return false to make ALL cells uneditable
				return false;
			}
		};
		//		model.addRow(new Object[] {
		//				"563575","Dinoy","Desktop","February 8, 2026", "1500.00", "In Use", "Calinan", "Wow :)"
		//		});

		table = new JTable(model);
		table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
		table.getTableHeader().setBackground(Color.ORANGE);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		scroll = new JScrollPane(table);
		tablePanel.add(scroll);

		// Bottom
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,10));

		createBut = new JButton("Add New Asset");
		readBut = new JButton("Display Asset");
		updateBut = new JButton("Modify Asset Details");
		deleteBut = new JButton("Remove Asset");
		searchBut = new JButton("Find Asset");

		buttonPanel.add(createBut);
		buttonPanel.add(readBut);
		buttonPanel.add(updateBut);
		buttonPanel.add(deleteBut);
		buttonPanel.add(searchBut);

		createBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Create c = new Create(mainWindow.this, assetList);
				c.saveToFile();
			}
		});
		readBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Read r = new Read(mainWindow.this, assetList);
				r.loadFromFile();
				r.read();
			}
		});
		updateBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Update u = new Update(mainWindow.this, assetList);
				u.updateAsset();
			}
		});
		deleteBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Delete d = new Delete(mainWindow.this, assetList);
				d.deleteAsset();
			}
		});
		searchBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Search s = new Search(mainWindow.this, assetList);
				s.searchAsset(txtId.getText());
			}
		});

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(tablePanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		add(mainPanel);
		setVisible(true);

		File file = new File(fileName);
		try {
			if(!file.exists()) 
				file.createNewFile();
		} catch (Exception e) {
			System.err.println("Error Creating File!");
		}
		Read r = new Read(this, assetList);
		r.read();
	}

}
