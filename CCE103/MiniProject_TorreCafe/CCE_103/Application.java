package CCE_103;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Application implements ActionListener{
	private JPanel panel;
	private JFrame frame = new JFrame();
	private JButton signup = new JButton("Sign up");
	private JTextField userText;
	private JPasswordField passText;
	private ArrayList<User> userList = new ArrayList<>();
	private ArrayList<Admin> adminList = new ArrayList<>();
	public static final File file = new File(new String("file.txt"));
	UserController controller;

	Application() {
		userList = new ArrayList<>();
		controller = new UserController(userList);
		controller.initFile();
		controller.readFromFile();

		frame.setTitle("Application");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400,280);
		frame.setResizable(false);

		ImageIcon icon = new ImageIcon("subcoffeebeans.jpg"); 
		Image img = icon.getImage().getScaledInstance(400, 280, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(img);

		JLabel background = new JLabel(scaledIcon);
		background.setBounds(0, 0, 400, 280);
		background.setLayout(null); 

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,420,300);
		panel.setOpaque(false);

		JLabel user = new JLabel();
		user.setText("username:");
		user.setBounds(80,80,70,20);
		user.setBackground(Color.white);

		JLabel pass = new JLabel();
		pass.setText("password:");
		pass.setBounds(80,110,70,20);
		pass.setBackground(Color.white);

		userText = new JTextField();
		userText.setBounds(155,80,150,20);

		passText = new JPasswordField();
		passText.setBounds(155,110,150,20);

		signup.setBounds(155,140,150,20);
		signup.setFocusable(false);
		signup.setVerticalAlignment(JButton.CENTER);
		signup.setHorizontalAlignment(JButton.CENTER);
		signup.addActionListener(this);

		panel.add(user);
		panel.add(pass);
		panel.add(userText);
		panel.add(passText);
		panel.add(signup);
		background.add(panel);

		frame.add(background);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public String checkMissing(String text) {
		boolean hasUpper = false;
		boolean hasLower = false;
		boolean hasSpecial = false;
		boolean hasDigits = false;

		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);

			if (Character.isUpperCase(c)) {
				hasUpper = true;
			} else if (Character.isLowerCase(c)) {
				hasLower = true;
			} else if (Character.isDigit(c)) {
				hasDigits = true;
			} else {
				hasSpecial = true;
			}
		}

		String message = "";

		if (!hasUpper) {
			message += "- uppercase letter\n";
		} 
		if (!hasLower) {
			message += "- lowercase letter\n";
		} 
		if (!hasDigits) {
			message += "- number\n";
		} 
		if (!hasSpecial){
			message += "- special character\n";
		}
		return message;

	}
	
	public boolean valid(String text) {
		boolean hasUpper = false;
		boolean hasLower = false;
		boolean hasSpecial = false;
		boolean hasDigits = false;

		if (text.length() < 8) {
			return false;
		}

		for (int i = 0; i < text.length(); i++) {
			if (Character.isUpperCase(text.charAt(i))) {
				hasUpper = true;
			} else if (Character.isLowerCase(text.charAt(i))) {
				hasLower = true;
			} else if (Character.isDigit(text.charAt(i))) {
				hasDigits = true;
			} else {
				hasSpecial = true;
			}
		}

		return hasUpper && hasLower && hasDigits && hasSpecial;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == signup) {
	        String username = userText.getText().trim();
	        String password = new String(passText.getPassword()).trim();

	        // Refresh list from file before checking
	        controller.readFromFile();

	        if (username.isEmpty() || password.isEmpty()) {
	            JOptionPane.showMessageDialog(frame, "Fill all fields");
	            return;
	        }

	        // DUPLICATE CHECK: Checks both existing users and the hardcoded admin
	        if (controller.isDuplicate(username) || username.equalsIgnoreCase("admin")) {
	            // Special Case: If they type "admin" and it's already in our list or hardcoded, block it.
	            // But if your goal is to "accept admin in signup", we allow it only if it doesn't exist yet.
	            if(username.equalsIgnoreCase("admin") && !controller.isDuplicate("admin")) {
	                // Allow proceeding to save admin to file
	            } else {
	                JOptionPane.showMessageDialog(frame, "Username already exists!");
	                return;
	            }
	        }

	        // Format validation
	        if (!valid(username) || !valid(password)) {
	            JOptionPane.showMessageDialog(frame, "Invalid format! Must be 8+ chars with Upper, Lower, Number, and Special.");
	            return;
	        }

	        // SAVE USER (This handles saving to users.txt)
	        User u = new User(username, password);
	        controller.addUser(u);

	        JOptionPane.showMessageDialog(frame, "Signup successful!");
	        frame.dispose();
	        new TorreCafe_Login();
	    }
	}

	public static void initFile() {
		try {
			if(!file.exists()) {
				file.createNewFile();
				JOptionPane.showMessageDialog(null, "File has been Created Successfully", "File", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "File already Exists!", "File",JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "File Cannot be Created", "Error File", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void saveToFileUser() {
		try {
			FileWriter fw = new FileWriter(file,true);
			//			fw.write(user.contain(user.getUsername(), user.getPassword()));
			fw.close();
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public static void saveToFileAdmin() {
		try {
			FileWriter fw = new FileWriter(file,true);
			//			fw.write(admin.contain(admin.getUsername(), admin.getPassword()));
			fw.close();
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	public JFrame getFrame() {
		return frame;
	}

}