package CCE_103;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class TorreCafe_Login extends JFrame implements ActionListener{
	// when the admin is not yet signed-up.

	private JLabel login;
	private JLabel username;
	private JLabel password;
	private JLabel confirm;
	private JButton enter;
	private JTextField inputUser;
	private JPasswordField inputPass;
	
	// Admin Panel
	private JLabel welcomepanel;
	private JButton accountManagement;
	private JButton inventoryManagement;
	private JButton returnToLogin;
	private Account_Management accountManagementWindow = null;
	private Inventory_Management inventoryManagementWindow = null;
	private static ArrayList<User> userList = new ArrayList<>();
	private static ArrayList<Admin> adminList = new ArrayList<>();
	private static Admin admin = new Admin("admin", "admin");

	public TorreCafe_Login() {
//		ImageIcon iconCup = new ImageIcon("cup.png");
		Image img2 = new ImageIcon("cup.png").getImage().getScaledInstance(115, 115, Image.SCALE_SMOOTH);
		ImageIcon scaledicon2 = new ImageIcon(img2);
		Image img3 = new ImageIcon("cup.png").getImage().getScaledInstance(55, 60, Image.SCALE_SMOOTH);
		ImageIcon scaledicon3 = new ImageIcon(img3);

		ImageIcon icon1 = new ImageIcon("coffebeans.jpg");
		Image img = icon1.getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH);
		ImageIcon scaledicon = new ImageIcon(img);

		// Left Side
		JLabel leftTitle = new JLabel();
		leftTitle.setText("TorreCafe");
		leftTitle.setBounds(110,355,550,135);
		leftTitle.setFont(new Font("",Font.BOLD,110));
		leftTitle.setForeground(Color.white);

		JLabel leftCup = new JLabel(scaledicon2);
		leftCup.setBounds(300,220,115,115);
		leftCup.setLayout(null);

		JLabel leftBackground = new JLabel(scaledicon);
		leftBackground.setBounds(0,0,700,800);
		leftBackground.setLayout(null);

		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(null);
		leftPanel.setBounds(0,0,700,800);
		leftPanel.setOpaque(false);

		// Right Side
		login = new JLabel();
		login.setText("Log-in");
		login.setBounds(300,220,100,35);
		login.setFont(new Font("",Font.BOLD,20));

		username = new JLabel();
		username.setText("Username:");
		username.setBounds(175,270,140,30);
		username.setFont(new Font("",Font.BOLD,20));

		password = new JLabel();
		password.setText("Password:");
		password.setBounds(175,320,140,30);
		password.setFont(new Font("",Font.BOLD,20));

		inputUser = new JTextField();
//		inputUser.setText("admin");
		inputUser.setBounds(330,270,200,30);
		inputUser.setFont(new Font("roman", Font.PLAIN,16));

		inputPass = new JPasswordField();
//		inputPass.setText("admin");
		inputPass.setBounds(330,320,200,30);
		inputPass.setFont(new Font("roman", Font.PLAIN,16));

		enter = new JButton("Enter");
		enter.setFocusPainted(false);
		enter.setContentAreaFilled(true);
		enter.setOpaque(true);
		enter.setBackground(Color.white);
		enter.setForeground(Color.black);
		enter.setFont(new Font("Segoe UI", Font.BOLD, 16));
		enter.setBorder(BorderFactory.createLineBorder(Color.gray, 8, true));
		enter.setBounds(430,390,110,45);

		confirm = new JLabel();
		confirm.setText("Confirm");
		confirm.setBounds(460,450,100,20);
		confirm.setFont(new Font("", Font.BOLD, 15));
		
		// Admin Panel
		
		welcomepanel = new JLabel();
		welcomepanel.setText("Welcome Admin!");
		welcomepanel.setBounds(260,210,250,50);
		welcomepanel.setFont(new Font("",Font.BOLD,22));
		welcomepanel.setVisible(false);
		
		accountManagement = new JButton();
		accountManagement.setText("Account Management");
		accountManagement.setFont(new Font("",Font.BOLD,22));
		accountManagement.setBounds(215,280,260,50);
		accountManagement.setFocusable(false);
		accountManagement.setVisible(false);
		
		inventoryManagement = new JButton();
		inventoryManagement.setText("Inventory Management");
		inventoryManagement.setFont(new Font("",Font.BOLD,22));
		inventoryManagement.setBounds(195,345,300,50);
		inventoryManagement.setFocusable(false);
		inventoryManagement.setVisible(false);
		
		returnToLogin = new JButton();
		returnToLogin.setText("Return To Log-in");
		returnToLogin.setFont(new Font("",Font.BOLD,22));
		returnToLogin.setBounds(230,410,230,50);
		returnToLogin.setFocusable(false);
		returnToLogin.setVisible(false);
		
		JLabel rightTitle = new JLabel();
		rightTitle.setIcon(scaledicon3);
		rightTitle.setText("TorreCafe");
		rightTitle.setBounds(0, 60, 700, 150);
		rightTitle.setFont(new Font("calibri",Font.BOLD,50));
		rightTitle.setForeground(Color.black);
		rightTitle.setHorizontalAlignment(JLabel.CENTER);
		rightTitle.setVerticalAlignment(JLabel.CENTER);
		rightTitle.setHorizontalTextPosition(JLabel.RIGHT);   // text to the right of icon
		rightTitle.setVerticalTextPosition(JLabel.CENTER);
		rightTitle.setIconTextGap(10);
		rightTitle.setOpaque(false);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(null);
		rightPanel.setBounds(700,0,700,800);
		rightPanel.setBackground(new Color(0xF9E0BB));
		rightPanel.add(rightTitle);
		rightPanel.add(login);
		rightPanel.add(username);
		rightPanel.add(password);
		rightPanel.add(inputUser);
		rightPanel.add(inputPass);
		rightPanel.add(enter);
		rightPanel.add(confirm);
		rightPanel.add(welcomepanel);
		rightPanel.add(accountManagement);
		rightPanel.add(inventoryManagement);
		rightPanel.add(returnToLogin);
		
		leftPanel.add(leftCup);
		leftPanel.add(leftTitle);
		leftBackground.add(leftPanel);
		
		enter.addActionListener(e -> {

			String username = inputUser.getText().trim();
		    String password = new String(inputPass.getPassword()).trim();

		    if (username.isEmpty() || password.isEmpty()) {
		        JOptionPane.showMessageDialog(this, "Please enter username and password");
		        return;
		    }

		    // 1. Check for Admin first (Hardcoded or from list)
		    if (username.equals("admin") && password.equals("admin")) {
		        showAdminPanel();
		        return;
		    }

		    // 2. Check users from file
		    // Note: I'm using your UserController logic here for consistency
		    ArrayList<User> userList = new ArrayList<>();
		    UserController loginController = new UserController(userList);
		    loginController.readFromFile(); 

		    boolean found = false;
		    for (User u : loginController.userList) {
		        if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
		            found = true;
		            break;
		        }
		    }

		    if (found) {
		        new TorreCafe_System();
		        dispose();
		    } else {
		        JOptionPane.showMessageDialog(this, "Invalid username or password");
		    }
		});
		
		accountManagement.addActionListener(e -> {
			showAccountManagement();
		});
		inventoryManagement.addActionListener(e -> {
			showInventoryManagement();
		});
		returnToLogin.addActionListener(e -> {
			showLogin();
		});

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("TorreCafe POS System Login");
		setLayout(null);
		setResizable(false);
		setSize(1400,800);
		add(leftBackground);
		add(rightPanel);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        int choice = JOptionPane.showConfirmDialog(
		                null,
		                "Are you sure you want to exit?",
		                "Confirm Exit",
		                JOptionPane.YES_NO_CANCEL_OPTION
		        );
		        if (choice == JOptionPane.YES_OPTION) {
		            dispose(); // closes ONLY this frame
		        }
		        // NO or CANCEL → do nothing (frame stays open)
		    }
		});
		setVisible(true);
	}
	
	private void showLogin() {
	    login.setVisible(true);
	    username.setVisible(true);
	    password.setVisible(true);
	    inputUser.setVisible(true);
	    inputPass.setVisible(true);
	    enter.setVisible(true);
	    confirm.setVisible(true);

	    welcomepanel.setVisible(false);
	    accountManagement.setVisible(false);
	    inventoryManagement.setVisible(false);
	    returnToLogin.setVisible(false);

	    inputUser.setText("");
	    inputPass.setText(""); 
	}
	
	private void showAdminPanel() {
	    login.setVisible(false);
	    username.setVisible(false);
	    password.setVisible(false);
	    inputUser.setVisible(false);
	    inputPass.setVisible(false);
	    enter.setVisible(false);
	    confirm.setVisible(false);

	    welcomepanel.setVisible(true);
	    accountManagement.setVisible(true);
	    inventoryManagement.setVisible(true);
	    returnToLogin.setVisible(true);
	}
	
	private void showAccountManagement() {
		if (accountManagementWindow == null) {
	        accountManagementWindow = new Account_Management();

	        accountManagementWindow.getFrame().addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosed(WindowEvent e) {
	                accountManagementWindow = null; // reset when closed
	            }
	        });
	    }
	}
	
	private void showInventoryManagement() {
		if (inventoryManagementWindow == null) {
			inventoryManagementWindow = new Inventory_Management();

			inventoryManagementWindow.getFrame().addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosed(WindowEvent e) {
	            	inventoryManagementWindow = null; // reset when closed
	            }
	        });
	    }
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
    
