package GUI_Projects;

import javax.swing.*;

class POSFrame extends JFrame {
    public POSFrame() {
        setTitle("TorreCafe POS");
        setSize(900,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new POSPanel()); // your POSPanel class must be fixed
        setVisible(true);
    }
}
