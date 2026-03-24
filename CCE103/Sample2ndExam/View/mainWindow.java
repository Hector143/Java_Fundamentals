package Sample2ndExam.View;

import Sample2ndExam.Controller.Create;
import Sample2ndExam.Model.Book;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class mainWindow extends JFrame implements ActionListener{

	JLabel idLabel;
	JLabel titleLabel;
	JLabel authorLabel;
	JLabel categoryLabel;
	JLabel publicationDateLabel;
	JLabel isbnLabel;
	JLabel statusLabel;
	JLabel shelfLocationLabel;
	JLabel descriptionLabel;

	public JTextField txtId;
	public JTextField txtTitle;
	public JTextField txtAuthor;
	public JTextField txtDate;
	public JTextField txtIsbn;
	public JTextField txtShelfLoc;
	public JTextField txtDescript;

	public JButton createBut;
	public JButton readBut;
	public JButton updateBut;
	public JButton deleteBut;
	public JButton searchBut;

	public JComboBox<String> category;
	public JComboBox<String> status;

	public JTable table;
	public DefaultTableModel model;
	public JScrollPane scroll;

	public static ArrayList<Book> bookList;

	public mainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setTitle("Book Inventory System");
		setSize(800,700);
		setLocationRelativeTo(null);

		JPanel topPanel = new JPanel(new BorderLayout());

		topPanel.setBackground(new Color(25,65,110));

		JLabel headerLabel = new JLabel("Library Book Inventory Management System");
		headerLabel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		headerLabel.setForeground(Color.white);
		headerLabel.setFont(new Font("SansSerif", Font.BOLD, 35));
		headerLabel.setHorizontalAlignment(JLabel.CENTER);

		JPanel inputPanel = new JPanel(new GridLayout(9,2,10,10));
		inputPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		inputPanel.setBackground(new Color(35,85,180));

		idLabel = new JLabel("Book ID");
		titleLabel = new JLabel("Title");
		authorLabel = new JLabel("Author");
		categoryLabel = new JLabel("Category");
		publicationDateLabel = new JLabel("Publication Date");
		isbnLabel = new JLabel("ISBN");
		statusLabel = new JLabel("Status");
		shelfLocationLabel = new JLabel("Shelf Location");
		descriptionLabel = new JLabel("Description");

		idLabel.setForeground(Color.white);
		titleLabel.setForeground(Color.white);
		authorLabel.setForeground(Color.white);
		categoryLabel.setForeground(Color.white);
		publicationDateLabel.setForeground(Color.white);
		isbnLabel.setForeground(Color.white);
		statusLabel.setForeground(Color.white);
		shelfLocationLabel.setForeground(Color.white);
		descriptionLabel.setForeground(Color.white);

		txtId = new JTextField();
		txtTitle = new JTextField();
		txtAuthor = new JTextField();
		txtDate = new JTextField();
		txtIsbn = new JTextField();
		txtShelfLoc = new JTextField();
		txtDescript = new JTextField();

		category = new JComboBox<String>(new String[] {
				"IT", "Computer Science", "Computer Engineering"
		}); 

		status = new JComboBox<String>(new String[] {
				"Available", "Borrowed", "Not Available"
		});

		inputPanel.add(idLabel);
		inputPanel.add(txtId);
		inputPanel.add(titleLabel);
		inputPanel.add(txtTitle);
		inputPanel.add(authorLabel);
		inputPanel.add(txtAuthor);
		inputPanel.add(categoryLabel);
		inputPanel.add(category);
		inputPanel.add(publicationDateLabel);
		inputPanel.add(txtDate);
		inputPanel.add(isbnLabel);
		inputPanel.add(txtIsbn);
		inputPanel.add(statusLabel);
		inputPanel.add(status);
		inputPanel.add(shelfLocationLabel);
		inputPanel.add(txtShelfLoc);
		inputPanel.add(descriptionLabel);
		inputPanel.add(txtDescript);

		topPanel.add(headerLabel, BorderLayout.NORTH);
		topPanel.add(inputPanel, BorderLayout.CENTER);

		// Middle Panel
		JPanel centerPanel = new JPanel(new BorderLayout());
		String[] columnNames = {"Book ID", "Title", "Author",
				"Category", "Pub Date", "ISBN", "Status",
				"Shelf", "Description"};
		model = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getTableHeader().setFont(new Font("",Font.BOLD,14));;

		scroll = new JScrollPane(table);
		centerPanel.add(scroll);

		// Bottom Panel
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,10));

		createBut = new JButton("Add Book");
		readBut = new JButton("Display Books");
		updateBut = new JButton("Modify Book");
		deleteBut = new JButton("Remove Book");
		searchBut = new JButton("Find Book");

		createBut.addActionListener(this);
		readBut.addActionListener(this);
		updateBut.addActionListener(this);
		deleteBut.addActionListener(this);
		searchBut.addActionListener(this);

		buttonPanel.add(createBut);
		buttonPanel.add(readBut);
		buttonPanel.add(updateBut);
		buttonPanel.add(deleteBut);
		buttonPanel.add(searchBut);

		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==createBut) {
			Create c = new Create(mainWindow.this, bookList);
			c.saveToFile();
		}
		if (e.getSource()==readBut) {
			Create c = new Create(mainWindow.this, bookList);
			c.saveToFile();
			
		}
		if (e.getSource()==updateBut) {
			Create c = new Create(mainWindow.this, bookList);
			c.saveToFile();
		}
		if (e.getSource()==deleteBut) {
			Create c = new Create(mainWindow.this, bookList);
			c.saveToFile();
		}
		if (e.getSource()==searchBut) {
			Create c = new Create(mainWindow.this, bookList);
			c.saveToFile();
		}
	}
}
