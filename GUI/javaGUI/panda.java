package javaGUI;

import javax.swing.*;
import java.awt.*;

public class panda extends JFrame {

    public panda() {
        setTitle("Personal Expenses Tracker");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BackgroundPanel panel = new BackgroundPanel(400, 500);
        setContentPane(panel);
        
        GridBagConstraints constrains = new GridBagConstraints();
        constrains.insets = new Insets(5, 5, 5, 5);
        constrains.fill = GridBagConstraints.HORIZONTAL;

        constrains.gridx = 0; constrains.gridy = 0;
        panel.addToBackground(new JLabel("Username"), constrains);

        constrains.gridx = 1;
        JTextField uname = new JTextField(20);
        panel.addToBackground(uname, constrains);

        constrains.gridx = 0; constrains.gridy = 1;
        panel.addToBackground(new JLabel("Email"), constrains);

        constrains.gridx = 1;
        JTextField email = new JTextField(20);
        panel.addToBackground(email, constrains);

        constrains.gridx = 0; constrains.gridy = 2;
        panel.addToBackground(new JLabel("Address"), constrains);

        constrains.gridx = 1;
        JTextArea address = new JTextArea(6, 20);
        panel.addToBackground(new JScrollPane(address), constrains);

        constrains.gridx = 0; constrains.gridy = 3;
        panel.addToBackground(new JLabel("Gender"), constrains);

        JPanel genderpanel = new JPanel();
        genderpanel.setOpaque(false);

        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        JRadioButton other = new JRadioButton("Others");

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        group.add(other);

        genderpanel.add(male);
        genderpanel.add(female);
        genderpanel.add(other);

        constrains.gridx = 1;
        panel.addToBackground(genderpanel, constrains);

        constrains.gridx = 0; constrains.gridy = 4;
        panel.addToBackground(new JLabel("Nationality"), constrains);

        constrains.gridx = 1;
        JComboBox<String> nationality =
                new JComboBox<>(new String[]{"Select", "Filipino", "Chinese", "Japanese"});
        panel.addToBackground(nationality, constrains);

        constrains.gridx = 0; constrains.gridy = 5;
        panel.addToBackground(new JLabel("Language"), constrains);

        constrains.gridx = 1;
        JComboBox<String> language =
                new JComboBox<>(new String[]{"Select", "English", "Mandarin", "Bisaya"});
        panel.addToBackground(language, constrains);

        constrains.gridx = 0; constrains.gridy = 6; constrains.gridwidth = 2;
        JButton login = new JButton("Login");
        panel.addToBackground(login, constrains);
        
        login.addActionListener(e -> {
        	String selected = (male.isSelected()) ? selected = male.getText() : (female.isSelected()) ? selected = female.getText() : (other.isSelected()) ? selected = other.getText() : ""; 
        	JOptionPane.showMessageDialog(null, "Username: " + uname.getText() +
        										"\nEmail: " + email.getText() +
        										"\nAddress: " + address.getText() +
        										"\nGender: " + selected +
        										"\nNationality: " + (String) nationality.getSelectedItem() +
        										"\nLanguage: " + (String) language.getSelectedItem(), "Profile Info", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    public static void main(String[] args) {
    	// original
//    	SwingUtilities.invokeLater(new Runnable() {
//    	    @Override
//    	    public void run() {
//    	        new panda().setVisible(true);
//    	    }
//    	});
    	// lambda expression - better and more efficient
        SwingUtilities.invokeLater(() -> new panda().setVisible(true));
    }

    class BackgroundPanel extends JPanel {

        private JLabel background;

        public BackgroundPanel(int width, int height) {
            setLayout(new BorderLayout());

            ImageIcon icon = new ImageIcon("back.jpg");
            Image scaledImage = icon.getImage()
                    .getScaledInstance(width, height, Image.SCALE_SMOOTH);

            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            background = new JLabel(scaledIcon);
            background.setLayout(new GridBagLayout());

            add(background, BorderLayout.CENTER);
        }

        public void addToBackground(Component c, Object constraints) {
            background.add(c, constraints);
        }
    }

}
