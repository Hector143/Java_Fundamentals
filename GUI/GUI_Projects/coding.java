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
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class coding implements ActionListener {

    static final String filepath = "pizza_records.txt";
    static File file = new File(filepath);

    static JButton clearButton;
    static JButton generateButton;

    static JTextField inputOrderID;
    static JTextField inputRate;
    static JTextField inputName;
    static JTextField inputAmount;
    static JTextField inputQuantity;
    static JTextField inputToppingCost;

    static ButtonGroup group;
    static JRadioButton but1;
    static JRadioButton but2;
    static JRadioButton but3;

    static JCheckBox check1;
    static JCheckBox check2;
    static JCheckBox check3;
    static JCheckBox check4;

    public static void main(String[] args) {
        initFile();
        new coding();
    }
    
    coding() {

        JFrame frame = new JFrame();
        frame.setTitle("PIZZA HOUZE");
        frame.setSize(700, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.orange);
        
        JLabel title = new JLabel("🍕PIZZA STORE🍕");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("serif", Font.BOLD, 50));

        JLabel order = new JLabel("Order ID");
        JLabel rate = new JLabel("Rate");
        JLabel customerName = new JLabel("Customer Name");
        JLabel amount = new JLabel("Amount");
        JLabel quantity = new JLabel("Quantity");
        JLabel toppingCost = new JLabel("Topping Cost");
        
        order.setForeground(Color.WHITE);
        order.setFont(new Font("roman", Font.BOLD, 18));
        rate.setForeground(Color.WHITE);
        rate.setFont(new Font("roman", Font.BOLD, 18));
        customerName.setForeground(Color.WHITE);
        customerName.setFont(new Font("roman", Font.BOLD, 18));
        amount.setForeground(Color.WHITE);
        amount.setFont(new Font("roman", Font.BOLD, 18));
        quantity.setForeground(Color.WHITE);
        quantity.setFont(new Font("roman", Font.BOLD, 18));
        toppingCost.setForeground(Color.WHITE);
        toppingCost.setFont(new Font("roman", Font.BOLD, 18));
        

        inputOrderID = new JTextField();
        inputRate = new JTextField();
        inputRate.setEditable(false);

        inputName = new JTextField();
        inputAmount = new JTextField();
        inputAmount.setEditable(false);

        inputQuantity = new JTextField();
        inputToppingCost = new JTextField();
        inputToppingCost.setEditable(false);

        JPanel panel1 = new JPanel(new GridLayout(3, 4, 25, 25));
        panel1.setBackground(Color.RED);
        panel1.setBorder(new EmptyBorder(10, 10, 10, 10)); // add padding to the panel1 
        // row 1
        panel1.add(order);
        panel1.add(inputOrderID);
        panel1.add(rate);
        panel1.add(inputRate);
        // row 2
        panel1.add(customerName);
        panel1.add(inputName);
        panel1.add(amount);
        panel1.add(inputAmount);
        // row 3
        panel1.add(quantity);
        panel1.add(inputQuantity);
        panel1.add(toppingCost);
        panel1.add(inputToppingCost);

        // Panel 2 – Pizza & Toppings
        
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBackground(Color.BLUE);
        
        JLabel pizzaType = new JLabel("Pizza Type");
        JLabel toppings = new JLabel("Toppings");
        
        pizzaType.setFont(new Font("serif", Font.BOLD, 20));
        pizzaType.setHorizontalAlignment(JLabel.CENTER);
        pizzaType.setForeground(Color.WHITE);
        
        toppings.setFont(new Font("serif", Font.BOLD, 20));
        toppings.setHorizontalAlignment(JLabel.CENTER);
        toppings.setForeground(Color.WHITE);
        
        JPanel labelPanel = new JPanel(new GridLayout(1, 2));
        labelPanel.setBackground(Color.BLUE);
        labelPanel.add(pizzaType);
        labelPanel.add(toppings);

        // Panel 3 – Pizza Type
        
        but1 = new JRadioButton();
        but2 = new JRadioButton();
        but3 = new JRadioButton();

        but1.setOpaque(false);
        but2.setOpaque(false);
        but3.setOpaque(false);

        group = new ButtonGroup();
        group.add(but1);
        group.add(but2);
        group.add(but3);

        JLabel type1 = new JLabel("Pan Pizza");
        JLabel type2 = new JLabel("Stuff Crust");
        JLabel type3 = new JLabel("Regular");

        type1.setFont(new Font("serif", Font.BOLD, 20));
        type2.setFont(new Font("serif", Font.BOLD, 20));
        type3.setFont(new Font("serif", Font.BOLD, 20));

        JPanel panel3 = new JPanel(new GridBagLayout());
        panel3.setBackground(Color.CYAN);

        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.HORIZONTAL;

        c1.gridx = 0;
        c1.gridy = 0;
        panel3.add(but1, c1);
        c1.gridx = 1; 
        c1.weightx = 3;
        panel3.add(type1, c1);

        c1.weightx = 1; 
        c1.gridx = 0; 
        c1.gridy = 1;
        panel3.add(but2, c1);
        c1.gridx = 1; 
        c1.weightx = 3;
        panel3.add(type2, c1);

        c1.weightx = 1; 
        c1.gridx = 0; 
        c1.gridy = 2;
        panel3.add(but3, c1);
        c1.gridx = 1; 
        c1.weightx = 3;
        panel3.add(type3, c1);

        //  Panel 4 – Toppings
        check1 = new JCheckBox();
        check2 = new JCheckBox();
        check3 = new JCheckBox();
        check4 = new JCheckBox();

        check1.setOpaque(false);
        check2.setOpaque(false);
        check3.setOpaque(false);
        check4.setOpaque(false);

        JLabel onion = new JLabel("Onion");
        JLabel cheese = new JLabel("Cheese");
        JLabel tomato = new JLabel("Tomato");
        JLabel babyCorn = new JLabel("Baby Corn");
        
        JLabel price1 = new JLabel("20");
        JLabel price2 = new JLabel("40");
        JLabel price3 = new JLabel("30");
        JLabel price4 = new JLabel("40");

        JPanel panel4 = new JPanel(new GridBagLayout());
        panel4.setBackground(new Color(204, 255, 0));

        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.HORIZONTAL;
        // row = 0
        c2.gridx = 0; 
        c2.gridy = 0;
        panel4.add(check1, c2);
        c2.gridx = 1;
        c2.weightx = 2;
        panel4.add(onion, c2);
        c2.gridx = 3; 
        c2.weightx = 1;
        panel4.add(price1, c2);
        // row = 1
        c2.gridx = 0; 
        c2.gridy = 1;
        panel4.add(check2, c2);
        c2.gridx = 1; 
        c2.weightx = 2;
        panel4.add(cheese, c2);
        c2.gridx = 3; 
        c2.weightx = 1;
        panel4.add(price2, c2);
        // row = 2
        c2.gridx = 0; 
        c2.gridy = 2;
        panel4.add(check3, c2);
        c2.gridx = 1; 
        c2.weightx = 2;
        panel4.add(tomato, c2);
        c2.gridx = 3; 
        c2.weightx = 1;
        panel4.add(price3, c2);
        // row = 3
        c2.gridx = 0; 
        c2.gridy = 3;
        panel4.add(check4, c2);
        c2.gridx = 1; 
        c2.weightx = 2;
        panel4.add(babyCorn, c2);
        c2.gridx = 3; 
        c2.weightx = 1;
        panel4.add(price4, c2);
        
        JPanel contentPanel = new JPanel(new GridLayout(1, 2));
        contentPanel.add(panel3);
        contentPanel.add(panel4);
        
        panel2.add(labelPanel, BorderLayout.NORTH);
        panel2.add(contentPanel, BorderLayout.CENTER);
        // Center Panel
        
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(panel1, BorderLayout.NORTH);
        centerPanel.add(panel2, BorderLayout.CENTER);

        // Bottom Panel
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);

        generateButton = new JButton("Generate Bill");
        generateButton.addActionListener(this);

        JPanel leftButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftButtonPanel.setBackground(Color.LIGHT_GRAY);
        leftButtonPanel.add(clearButton);

        JPanel rightButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightButtonPanel.setBackground(Color.DARK_GRAY);
        rightButtonPanel.add(generateButton);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
        bottomPanel.add(leftButtonPanel);
        bottomPanel.add(rightButtonPanel);

        // Frame Panel
        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        frame.add(mainPanel); // add mainPanel
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clearButton) {
            inputOrderID.setText(null);
            inputRate.setText(null);
            inputName.setText(null);
            inputAmount.setText(null);
            inputQuantity.setText(null);
            inputToppingCost.setText(null);
            group.clearSelection();
            check1.setSelected(false);
            check2.setSelected(false);
            check3.setSelected(false);
            check4.setSelected(false);
            return;
        }

        try {
            if (e.getSource() == generateButton) {

                String order = inputOrderID.getText();
                String name = inputName.getText();
                int quantity = Integer.parseInt(inputQuantity.getText());

                StringBuilder buildToppings = new StringBuilder();
                double toppingCostValue = 0;

                double rate = 	(but1.isSelected()) ? 200 :
                        		(but2.isSelected()) ? 250 :
                        		(but3.isSelected()) ? 150 : 0;

                String pizzaType = 	(but1.isSelected()) ? "Pan Pizza" :
                					(but2.isSelected()) ? "Stuff Crust" : 
                					(but3.isSelected()) ? "Regular" : "";

                if (check1.isSelected()) { 
                	buildToppings.append("->Onion\n"); 
                	toppingCostValue += 20; 
                }
                if (check2.isSelected()) {
                	buildToppings.append("->Cheese\n");
                	toppingCostValue += 40;
                }
                if (check3.isSelected()) {
                	buildToppings.append("->Tomato\n");
                	toppingCostValue += 30;
                }
                if (check4.isSelected()) {
                	buildToppings.append("->Baby Corn\n"); 
                	toppingCostValue += 40;
                }
                if (!check1.isSelected() && !check2.isSelected() && !check3.isSelected() && !check4.isSelected()) {
                    buildToppings.append("No Toppings");
                }
                
                double toppingCostAmount = toppingCostValue * quantity;
                double amount = rate * quantity;
                double totalBill = amount + toppingCostAmount;

                inputRate.setText(Double.toString(rate));
                inputAmount.setText(Double.toString(amount));
                inputToppingCost.setText(Double.toString(toppingCostValue));

                JOptionPane.showMessageDialog(null,
                        "Order ID: " + order +
                        "\nCustomer Name: " + name +
                        "\nQuantity: " + quantity +
                        "\nRate: " + rate +
                        "\nAmount: " + amount +
                        "\nTopping Cost per Pizza: " + toppingCostValue +
                        "\nPizza Type: " + pizzaType +
                        "\nToppings:\n" + buildToppings +
                        "\nTotal Bill: " + totalBill,
                        "Pizza House Bills",
                        JOptionPane.INFORMATION_MESSAGE
                );
                
                saveToFile();
                readFile();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void initFile() {
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void saveToFile() {
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(inputOrderID.getText() + "," + inputName.getText() + "\n");
            fw.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void readFile() {
        try {
        	FileReader reader = new FileReader(file);
        	Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}