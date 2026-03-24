package Java_GUI_Example2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Hotel_Reservation_Management_System extends JFrame implements ActionListener{

	JLabel reservationNumLabel;
	JLabel guestNameLabel;
	JLabel roomTypeLabel;
	JLabel numOfDaysLabel;

	JTextField inputResNum;
	JTextField inputGuestName;
	JTextField inputNumOfDays;
	JComboBox<String> selectRoomType;

	JButton addBut;
	JButton searchBut;
	JButton updateBut;
	JButton cancelBut;
	JButton viewBut;
	JButton saveToFileBut;

	JTable table;
	DefaultTableModel model;
	JScrollPane scroll;

	ArrayList<Reservation> reserveList = new ArrayList<Reservation>();
	public static final String fileName = "reservations.txt";
	File file = new File(fileName);

	Hotel_Reservation_Management_System() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setTitle("Hotel Reservation Management System");


		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		JPanel titlePanel = new JPanel(new BorderLayout());
		titlePanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		JLabel titleLabel = new JLabel("Hotel Reservation Management System");
		titleLabel.setFont(new Font("serif", Font.BOLD,30));
		titleLabel.setForeground(new Color(0, 102, 204));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titlePanel.add(titleLabel);

		reservationNumLabel = new JLabel("Reservation Number");
		guestNameLabel = new JLabel("Guest Name");
		roomTypeLabel = new JLabel("Room Type");
		numOfDaysLabel = new JLabel("Number of Days");

		inputResNum = new JTextField();
		inputGuestName = new JTextField();
		inputNumOfDays = new JTextField();
		selectRoomType = new JComboBox<String>(new String[] { "Single", "Double", "Suite" });

		JPanel inputPanel = new JPanel(new GridLayout(4,2,10,10));
		inputPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
//		inputPanel.setBorder(BorderFactory.createTitledBorder("Reservation Details"));
		
		inputPanel.add(reservationNumLabel);
		inputPanel.add(inputResNum);
		inputPanel.add(guestNameLabel);
		inputPanel.add(inputGuestName);
		inputPanel.add(roomTypeLabel);
		inputPanel.add(selectRoomType);
		inputPanel.add(numOfDaysLabel);
		inputPanel.add(inputNumOfDays);

		topPanel.add(titlePanel, BorderLayout.NORTH);
		topPanel.add(inputPanel, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5,10));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

		addBut = new JButton("Add Reservation");
		searchBut = new JButton("Search Reservation");
		updateBut = new JButton("Update Room Type");
		cancelBut = new JButton("Cancel Reservation");
		viewBut = new JButton("View All Reservation");
		saveToFileBut = new JButton("Save To File");

		buttonPanel.add(addBut);
		buttonPanel.add(searchBut);
		buttonPanel.add(updateBut);
		buttonPanel.add(cancelBut);
		buttonPanel.add(viewBut);
		buttonPanel.add(saveToFileBut);

		// South
		String[] columnNames = {"Res No", "Guest Name", "Room", "Days", "Total", "Status"};

		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);

		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
		scroll = new JScrollPane(table);

		this.add(topPanel, BorderLayout.NORTH);
		this.add(scroll, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);

		addBut.addActionListener(this);
		searchBut.addActionListener(this);
		updateBut.addActionListener(this);
		cancelBut.addActionListener(this);
		viewBut.addActionListener(this);
		saveToFileBut.addActionListener(this);

		this.pack();
		this.setLocationRelativeTo(null);
		
		loadFromFile();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addBut) {
			addReservation();
		}
		if (e.getSource() == searchBut) {
			searchReservation();
		}
		if (e.getSource() == updateBut) {
			updateRoomType();
		}
		if (e.getSource() == cancelBut) {
			cancelReservation();
		}
		if (e.getSource() == viewBut) {
			refreshTable();
		}
		if (e.getSource() == saveToFileBut) {
			saveToFile();
		}

	}

	private void cancelReservation() {
		String resNum = inputResNum.getText().trim();
		if (resNum.isEmpty()) {
			JOptionPane.showMessageDialog(this, "You must Enter reservation number");
			return;
		}
		
		for (Reservation r : reserveList) {
			if (r.getReservationNumber().equalsIgnoreCase(resNum)) {
				int confirm = JOptionPane.showConfirmDialog(this,
						"Are you sure you want to cancel the Reservation?",
						"Confirm Cancel",
						JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					r.setStatus("Cancelled");
					JOptionPane.showMessageDialog(this, "Reservation cancelled successfully.");
					refreshTable();
				}
				return;
			}
		}
		JOptionPane.showMessageDialog(this, "Reservation not found.", "Not Found", JOptionPane.ERROR_MESSAGE);

	}

	private void updateRoomType() {
		String resNum = inputResNum.getText().trim();
		if (resNum.isEmpty()) {
			JOptionPane.showMessageDialog(this, "You must Enter reservation number");
			return;
		}
		
		for (Reservation r : reserveList) {
			if (r.getReservationNumber().equalsIgnoreCase(resNum)) {
				int confirm = JOptionPane.showConfirmDialog(this,
						"Are you sure you want to update the room type?",
						"Confirm Update",
						JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					String newRoom = selectRoomType.getSelectedItem().toString();
					r.setRoomType(newRoom);
					JOptionPane.showMessageDialog(this, "Room type successfully updated");
					refreshTable();
				}
				return;
			}
		}
		JOptionPane.showMessageDialog(this, "Reservation not found.", "Not Found", JOptionPane.ERROR_MESSAGE);
	}

	private void searchReservation() {
		String resNum = inputResNum.getText().trim();

		if (resNum.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please enter reservation number");
			return;
		}

		for (Reservation r : reserveList) {
			if (r.getReservationNumber().equalsIgnoreCase(resNum)) {
				JOptionPane.showMessageDialog(this, 
						"Reservation No: " + r.getReservationNumber() +
						"\nGuest Name: " + r.getGuestName() +
						"\nRoom Type: " + r.getRoomType() +
						"\nDays: " + r.getNumOfDays() +
						"\nTotal Amount: " + r.getTotalAmount() +
						"\nStatus: " + r.getStatus());
				return;
			}
		}

		JOptionPane.showMessageDialog(this, "Reservation not Found!", "Not Found", JOptionPane.ERROR_MESSAGE);
	}

	private void addReservation() {
		try {
			String resNum = inputResNum.getText().trim();
			String guest = inputGuestName.getText().trim();
			String room = selectRoomType.getSelectedItem().toString();
			String numDays = inputNumOfDays.getText().trim();

			if (resNum.isEmpty() || guest.isEmpty() || numDays.isEmpty()) {
				JOptionPane.showMessageDialog(this, "All fields are required");
				return;
			}

			int days = Integer.parseInt(numDays);

			if (days < 1) {
				JOptionPane.showMessageDialog(this, "Number of days must be at least 1 or above");
				return;
			}

			// check duplication
			for (Reservation r : reserveList) {
				if (r.getReservationNumber().equalsIgnoreCase(resNum)) {
					JOptionPane.showMessageDialog(this, "Reservation number already");
					return;
				}
			}

			Reservation newRes = new Reservation(resNum, guest, room, days, "Confirmed");
			reserveList.add(newRes);

			JOptionPane.showMessageDialog(this, "Reservation added successfully.");
			clearFields();
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Number of days should be a number.");
		}
	}

	public void clearFields() {
		inputResNum.setText("");
		inputGuestName.setText("");
		inputNumOfDays.setText("");
		selectRoomType.setSelectedIndex(0);
	}

	public void refreshTable() {
		model.setRowCount(0);

		for (Reservation r : reserveList) {
			model.addRow(new Object[] {
					r.getReservationNumber(),
					r.getGuestName(),
					r.getRoomType(),
					r.getNumOfDays(),
					r.getTotalAmount(),
					r.getStatus()
			});
		}
	}
	private void initFile() {
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Cannot Create File!","Error Message", JOptionPane.ERROR_MESSAGE);
			return;
		}

	}

	private void saveToFile() {
		try {
			initFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			for (Reservation r : reserveList) {
				bw.write(r.toFileString() + "\n");
			}
			bw.close();

			JOptionPane.showMessageDialog(this,
					"Data successfully saved to file.");

		} catch (IOException e) {
			JOptionPane.showMessageDialog(this,
					"Cannot save to file!",
					"Error Message",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void loadFromFile() {
		initFile();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			
			while ((line = br.readLine()) != null) {
				String[] data = line.split("\\|");
				if (data.length == 6) {
					try {
					    String resNum = data[0].trim();
					    String guest = data[1].trim();
					    String room = data[2].trim();
					    int days = Integer.parseInt(data[3].trim());
					    String status = data[5].trim();

					    Reservation r = new Reservation(resNum, guest, room, days, status);
					    reserveList.add(r);

					} catch (Exception ex) {
					    // If line is corrupted, just skip it
					    JOptionPane.showMessageDialog(null,"Invalid line skipping!","Error Message", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"load from file Error!","Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Hotel_Reservation_Management_System().setVisible(true)); 

	}
}
