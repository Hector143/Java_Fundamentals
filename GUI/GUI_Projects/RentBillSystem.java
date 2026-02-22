package GUI_Projects;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import javax.swing.SwingUtilities;

public class RentBillSystem extends JFrame implements ActionListener{

	JLabel tenantNameLabel;
	JLabel apartmentTypeLabel;
	JLabel categoryLabel;
	JLabel monthsRentedLabel;
	JLabel monthlyRentLabel;
	JLabel monthlyRentAmountLabel;
	JLabel cashTenderedLabel;

	JTextField inputTenantName;
	JTextField inputMonthsRented;
	JTextField inputCashTendered;
	
	JComboBox<String> selectTypes;
	JComboBox<String> selectCategories;
	
	JCheckBox electricityCheck;
	JCheckBox waterCheck;
	JCheckBox internetCheck;

	JTextArea billingSummaryArea;
	JTextArea receiptArea;

	JScrollPane billingSummaryScroll;
	JScrollPane receiptScroll;

	JButton computeRentBut;
	JButton generateReceiptBut;
	JButton clearBut;
	JButton exitBut;

	RentBillSystem() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());
		this.setTitle("Apartment Rent Billing System");
		
		// ========== Tenant Information ==========
		
		tenantNameLabel = new JLabel("Tenant Name:");
		apartmentTypeLabel = new JLabel("Apartment Type:");
		categoryLabel = new JLabel("Tenant Category:");
		monthsRentedLabel = new JLabel("Months Rented:");
		monthlyRentLabel = new JLabel("Monthly Rent:");
		monthlyRentAmountLabel = new JLabel("");
		
		inputTenantName = new JTextField();
		inputMonthsRented = new JTextField();
		
		String[] types = {"Studio", "1 Bedroom", "2 Bedroom", "Suite"};
		String[] categories = {"Regular", "Commercial", "Temporary", "Sub-tenant", "VIP"};
		
		selectTypes = new JComboBox<String>(types);
		selectCategories = new JComboBox<String>(categories);
		
		
		JPanel informationPanel = new JPanel(new GridBagLayout()); 
		GridBagConstraints c1 = new GridBagConstraints();
		c1.fill = GridBagConstraints.HORIZONTAL;
		c1.gridx = 0;
		c1.gridy = 0;
		
		
		// ========== Utilities ==========
		JPanel utilitiesPanel = new JPanel(new BorderLayout());
		GridBagConstraints c2 = new GridBagConstraints();
		electricityCheck = new JCheckBox("Electricity(₱1,000/mo)");
		waterCheck = new JCheckBox("Water(₱100/mo)");
		internetCheck = new JCheckBox("Internet(₱1,500/mo)");
		
		electricityCheck.setForeground(Color.green);
		electricityCheck.setFont(new Font("", Font.BOLD, 13));
		waterCheck.setForeground(Color.green);
		waterCheck.setFont(new Font("", Font.BOLD, 13));
		internetCheck.setForeground(Color.green);
		internetCheck.setFont(new Font("", Font.BOLD, 13));
		
		JPanel utilitiesChecks = new JPanel(new GridLayout(3,1,10,10));
		
		// Tenant Information
		JPanel tenantInfo2Panel = new JPanel(new BorderLayout());
		cashTenderedLabel = new JLabel("Cash Tendered");
		inputCashTendered = new JTextField();
		
		// Billing Summary
	
		this.setSize(720,600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new RentBillSystem());

	}

}
