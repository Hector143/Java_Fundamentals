package inventory_system;
//============================================================
//REQUIRED IMPORTS
//These are Java libraries we need to build the GUI and handle events.
//javax.swing  = the main Java GUI toolkit (windows, buttons, tables, etc.)
//java.awt     = older graphics library; Swing builds on top of it
//java.awt.event = contains all the listener interfaces (ActionListener, etc.)
//java.util    = general utilities like ArrayList and List
//============================================================
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

//============================================================
//CLASS: AppPanel  (OOP CONCEPT: ABSTRACTION + INHERITANCE BASE)
//
//What is Abstraction?
//Abstraction means hiding the complex details and only showing
//what is necessary. Here, AppPanel is declared "abstract",
//meaning you CANNOT create an AppPanel directly — it is a
//template/blueprint that other classes must follow.
//
//It forces every screen (Login, Dashboard, Inventory, Profile)
//to implement the refresh() method, because every screen needs
//to know how to update itself. AppPanel also stores all shared
//colors and helper methods so we don't repeat the same code
//in every screen class.
//
//What is Inheritance?
//AppPanel extends JPanel — meaning it inherits all the behavior
//of a JPanel (can hold components, can be added to windows, etc.)
//and we ADD our own custom behavior on top of it.
//============================================================
abstract class AppPanel extends JPanel {

// ── Shared color palette ─────────────────────────────────────────────
// All screens that extend AppPanel can use these colors
// without redefining them. This avoids repeating hex values everywhere.
protected Color PRIMARY       = new Color(25,  100, 200);   // Main blue
protected Color PRIMARY_DARK  = new Color(15,  70,  160);   // Darker blue (hover, pressed)
protected Color PRIMARY_LIGHT = new Color(70,  140, 230);   // Lighter blue
protected Color ACCENT        = new Color(0,   163, 255);   // Bright accent blue
protected Color BG_WHITE      = Color.WHITE;                 // Pure white background
protected Color BG_LIGHT      = new Color(240, 246, 255);   // Very light blue tint
protected Color TEXT_DARK     = new Color(10,  10,  10);    // Near-black for readable text
protected Color TEXT_MID      = new Color(85,  85,  95);    // Medium gray for subtitles
protected Color BORDER_COLOR  = new Color(200, 215, 235);   // Light blue-gray for borders

// Constructor: sets the default background color of this panel to white
public AppPanel() {
   setBackground(BG_WHITE);
}

// ── ABSTRACT METHOD: refresh() ───────────────────────────────────────
// The keyword "abstract" means this method has NO body here.
// Every class that extends AppPanel MUST provide its own version.
// This is the core of Abstraction — we define WHAT must happen
// (every panel can refresh itself), but not HOW each one does it.
public abstract void refresh();

// ── HELPER METHOD: makeLabel() ───────────────────────────────────────
// Instead of writing 4 lines every time we need a styled label,
// we call this one method. It creates a JLabel, sets the font
// size and boldness, sets the color to near-black, and returns it.
//
// Parameters:
//   text  = the words to display
//   size  = font size (e.g. 12, 14, 24)
//   bold  = true for bold, false for regular weight
protected JLabel makeLabel(String text, float size, boolean bold) {
   JLabel lbl = new JLabel(text);
   // If bold is true, use Font.BOLD; otherwise use Font.PLAIN
   lbl.setFont(new Font("Segoe UI", bold ? Font.BOLD : Font.PLAIN, (int) size));
   lbl.setForeground(TEXT_DARK); // near-black so it's readable on white
   return lbl;
}

// ── HELPER METHOD: makePrimaryButton() ──────────────────────────────
// Creates a blue filled button with white text and rounded corners.
// We override paintComponent() to draw the button manually using
// Graphics2D — this gives us full control over its appearance
// instead of relying on the default ugly Java button style.
//
// The button changes color when hovered (lighter blue) or clicked (darker blue).
protected JButton makePrimaryButton(String text) {
   JButton btn = new JButton(text) {
       // paintComponent is called by Swing every time the button needs to be drawn.
       // We override it to draw our own rounded rectangle instead of the default style.
       @Override protected void paintComponent(Graphics g) {
           // Graphics2D is the upgraded version of Graphics — supports anti-aliasing
           Graphics2D g2 = (Graphics2D) g.create();
           // Anti-aliasing makes the rounded edges look smooth, not jagged
           g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

           // Change color based on button state
           if (getModel().isPressed())       g2.setColor(PRIMARY_DARK);   // clicked = darker
           else if (getModel().isRollover()) g2.setColor(PRIMARY_LIGHT);  // hovered = lighter
           else                              g2.setColor(PRIMARY);         // normal = main blue

           // Draw the rounded blue background
           g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);

           // Draw the white text centered inside the button
           g2.setColor(Color.WHITE);
           g2.setFont(getFont());
           FontMetrics fm = g2.getFontMetrics(); // measures text width/height
           int x = (getWidth()  - fm.stringWidth(getText())) / 2; // center horizontally
           int y = (getHeight() + fm.getAscent() - fm.getDescent()) / 2; // center vertically
           g2.drawString(getText(), x, y);
           g2.dispose(); // always dispose to free graphics resources
       }
   };
   btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
   btn.setForeground(Color.WHITE);
   btn.setPreferredSize(new Dimension(160, 38));
   btn.setContentAreaFilled(false); // don't let Java draw its own background
   btn.setBorderPainted(false);     // don't draw the default border
   btn.setFocusPainted(false);      // don't draw the dotted focus rectangle
   btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // hand cursor on hover
   return btn;
}

// ── HELPER METHOD: makeSecondaryButton() ────────────────────────────
// Creates a white outlined button (border only, no fill) with blue text.
// Same custom painting approach as above, but draws a border instead
// of a solid fill. Used for Cancel, Edit, Delete, Refresh buttons.
protected JButton makeSecondaryButton(String text) {
   JButton btn = new JButton(text) {
       @Override protected void paintComponent(Graphics g) {
           Graphics2D g2 = (Graphics2D) g.create();
           g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

           // Fill with very light blue on hover, white otherwise
           g2.setColor(getModel().isRollover() ? new Color(235, 243, 255) : BG_WHITE);
           g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);

           // Draw the blue border outline (1.5px thick)
           g2.setColor(PRIMARY);
           g2.setStroke(new BasicStroke(1.5f));
           g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 10, 10);

           // Draw the blue text centered
           g2.setFont(getFont());
           FontMetrics fm = g2.getFontMetrics();
           int x = (getWidth()  - fm.stringWidth(getText())) / 2;
           int y = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
           g2.drawString(getText(), x, y);
           g2.dispose();
       }
   };
   btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
   btn.setForeground(PRIMARY);
   btn.setPreferredSize(new Dimension(130, 38));
   btn.setContentAreaFilled(false);
   btn.setBorderPainted(false);
   btn.setFocusPainted(false);
   btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
   return btn;
}

// ── HELPER METHOD: makeTextField() ──────────────────────────────────
// Creates a styled text input field with a custom placeholder.
// Java's JTextField has no built-in placeholder feature, so we
// override paintComponent() to manually draw the gray italic hint
// text when the field is empty and not focused.
protected JTextField makeTextField(String placeholder) {
   JTextField tf = new JTextField() {
       @Override protected void paintComponent(Graphics g) {
           super.paintComponent(g); // draw the actual text field first
           // Only show placeholder if field is empty AND not currently focused
           if (getText().isEmpty() && !isFocusOwner()) {
               Graphics2D g2 = (Graphics2D) g.create();
               g2.setColor(new Color(160, 175, 200));    // light gray color
               g2.setFont(getFont().deriveFont(Font.ITALIC)); // italic style
               // Draw placeholder text, vertically centered in the field
               g2.drawString(placeholder, 10, getHeight() / 2 + g2.getFontMetrics().getAscent() / 2 - 2);
               g2.dispose();
           }
       }
   };
   tf.setFont(new Font("Segoe UI", Font.PLAIN, 13));
   tf.setForeground(TEXT_DARK);    // near-black for typed text
   tf.setBackground(Color.WHITE);
   // Compound border: outer line border + inner empty border for padding
   tf.setBorder(BorderFactory.createCompoundBorder(
       BorderFactory.createLineBorder(BORDER_COLOR, 1, true),  // outer border
       BorderFactory.createEmptyBorder(6, 10, 6, 10)           // inner padding
   ));
   tf.setPreferredSize(new Dimension(0, 38)); // height 38px; width is flexible
   return tf;
}

// ── HELPER METHOD: makePasswordField() ──────────────────────────────
// Same as makeTextField() but for passwords.
// JPasswordField automatically hides characters with dots/asterisks.
// We check getPassword().length instead of getText().isEmpty()
// because getText() is deprecated on JPasswordField for security reasons.
protected JPasswordField makePasswordField(String placeholder) {
   JPasswordField pf = new JPasswordField() {
       @Override protected void paintComponent(Graphics g) {
           super.paintComponent(g);
           if (getPassword().length == 0 && !isFocusOwner()) {
               Graphics2D g2 = (Graphics2D) g.create();
               g2.setColor(new Color(160, 175, 200));
               g2.setFont(getFont().deriveFont(Font.ITALIC));
               g2.drawString(placeholder, 10, getHeight() / 2 + g2.getFontMetrics().getAscent() / 2 - 2);
               g2.dispose();
           }
       }
   };
   pf.setFont(new Font("Segoe UI", Font.PLAIN, 13));
   pf.setForeground(TEXT_DARK);
   pf.setBackground(Color.WHITE);
   pf.setBorder(BorderFactory.createCompoundBorder(
       BorderFactory.createLineBorder(BORDER_COLOR, 1, true),
       BorderFactory.createEmptyBorder(6, 10, 6, 10)
   ));
   pf.setPreferredSize(new Dimension(0, 38));
   return pf;
}
}

//============================================================
//CLASS: User  (OOP CONCEPT: ENCAPSULATION)
//
//What is Encapsulation?
//Encapsulation means bundling data (fields) and behavior (methods)
//together inside a class, AND controlling access to that data.
//
//All fields here are "private" — meaning NOBODY outside this class
//can directly read or change them. For example, you cannot write:
// user.password = "hacked";   // This would cause a compile error!
//
//Instead, you must use the provided getter/setter methods.
//This protects the data — for example, in the future you could
//add validation inside setPassword() to reject weak passwords,
//and all code would automatically benefit without changes.
//============================================================
class User {

// All fields are private — they can only be touched from inside this class
private String username;
private String password;
private String fullName;
private String email;
private String role;       // Either "Admin" or "Staff"
private String joinDate;

// Constructor: the only way to create a User object.
// You must supply all information at creation time.
public User(String username, String password, String fullName,
           String email, String role, String joinDate) {
   this.username = username; // "this.username" = the field; "username" = the parameter
   this.password = password;
   this.fullName = fullName;
   this.email    = email;
   this.role     = role;
   this.joinDate = joinDate;
}

// ── GETTERS: read-only access to private fields ──────────────────────
// Anyone can call these to READ the data, but cannot change it directly.
public String getUsername() { return username; }
public String getPassword() { return password; }
public String getFullName() { return fullName; }
public String getEmail()    { return email;    }
public String getRole()     { return role;     }
public String getJoinDate() { return joinDate; }

// ── SETTERS: controlled write access ────────────────────────────────
// Only password, fullName, and email can be changed after creation.
// Username and role intentionally have NO setter — they should never change.
public void setPassword(String password) { this.password = password; }
public void setFullName(String fullName) { this.fullName = fullName; }
public void setEmail(String email)       { this.email = email;       }
}

//============================================================
//CLASS: Item  (OOP CONCEPT: ENCAPSULATION)
//
//Same encapsulation pattern as User. All inventory item data
//is private and accessed only through getters/setters.
//The ID is auto-generated (auto-increment) using a static counter.
//============================================================
class Item {

// nextId is static — it belongs to the CLASS, not any individual item.
// Every time a new Item is created, it takes the current nextId value
// and then increments it for the next item. This mimics a database auto-increment.
private static int nextId = 1;

// Instance fields — each Item has its own copy of these
private int    id;
private String name;
private String category;
private int    quantity;
private double price;
private String description;

// Constructor: assigns the next available ID automatically
public Item(String name, String category, int quantity,
           double price, String description) {
   this.id          = nextId++;   // assign current id, then increment for next item
   this.name        = name;
   this.category    = category;
   this.quantity    = quantity;
   this.price       = price;
   this.description = description;
}

// ── GETTERS ──────────────────────────────────────────────────────────
public int    getId()          { return id;          }
public String getName()        { return name;        }
public String getCategory()    { return category;    }
public int    getQuantity()    { return quantity;    }
public double getPrice()       { return price;       }
public String getDescription() { return description; }

// ── SETTERS (no setId — the ID must never change after creation) ─────
public void setName(String name)               { this.name = name;               }
public void setCategory(String category)       { this.category = category;       }
public void setQuantity(int quantity)          { this.quantity = quantity;       }
public void setPrice(double price)             { this.price = price;             }
public void setDescription(String description) { this.description = description; }

// ── METHOD: toTableRow() ─────────────────────────────────────────────
// Converts this Item into a String array that can be placed as one
// row in a JTable. The table expects all values as Strings,
// so we convert numbers with String.valueOf() and String.format().
public String[] toTableRow() {
   return new String[]{
       String.valueOf(id),
       name,
       category,
       String.valueOf(quantity),
       String.format("%.2f", price), // format price to 2 decimal places (e.g. 199.00)
       description
   };
}
}

//============================================================
//CLASS: DataStore
//
//This is the in-memory database for our application.
//It holds the master lists of all users and items.
//All methods are static — you never create a DataStore object;
//you call methods directly like DataStore.addItem(...).
//
//The "static { ... }" block at the top is a static initializer.
//It runs exactly once when the class is first loaded, and it
//pre-populates our lists with sample data so the app isn't empty.
//============================================================
class DataStore {

// Static lists that hold all users and items for the whole program lifetime
private static final List<User> users = new ArrayList<>();
private static final List<Item> items = new ArrayList<>();

// Static initializer block — runs once when DataStore is first used
static {
   // Pre-load two user accounts
   users.add(new User("admin",  "admin123",  "System Administrator",
                      "admin@invsys.com",  "Admin", "2024-01-01"));

   // Pre-load six sample inventory items
   items.add(new Item("Mechanical Keyboard", "Electronics", 12, 2499.00, "TKL layout, RGB"));
   items.add(new Item("USB-C Hub",           "Electronics",  8,  899.00, "7-in-1 hub"));
   items.add(new Item("Office Chair",        "Furniture",    5, 5999.00, "Ergonomic, lumbar"));
   items.add(new Item("A4 Bond Paper",       "Supplies",   200,   55.00, "500 sheets/ream"));
   items.add(new Item("Ballpen (Box)",       "Supplies",    40,  120.00, "Black ink, 12 pcs"));
   items.add(new Item("Monitor 24\"",        "Electronics",  6, 8500.00, "IPS, 1080p, 75Hz"));
}

// ── DATA ACCESS METHODS ──────────────────────────────────────────────

// Returns the full list of users (used by admin-level features)
public static List<User> getUsers() { return users; }

// Returns the full list of items (used by inventory table)
public static List<Item> getItems() { return items; }

// Searches for a user by their username.
// Uses Java Streams: "filter" keeps only matching users,
// "findFirst" takes the first match, "orElse(null)" returns null if not found.
public static User findUser(String username) {
   return users.stream()
               .filter(u -> u.getUsername().equals(username))
               .findFirst().orElse(null);
}

// Checks if the username + password combination is valid.
// First finds the user, then compares the stored password.
// Returns true if both match, false otherwise.
public static boolean authenticate(String username, String password) {
   User u = findUser(username);
   return u != null && u.getPassword().equals(password);
}

// Adds a new Item to the list (used by the Add Item dialog)
public static void addItem(Item item) { items.add(item); }

// Removes an item by ID using removeIf — removes any item whose ID matches
public static void removeItem(int id) {
   items.removeIf(i -> i.getId() == id);
}

// Finds and returns an item by its ID (used by the Edit dialog to pre-fill fields)
public static Item findItem(int id) {
   return items.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
}

// ── COMPUTED STATISTICS ──────────────────────────────────────────────
// These are used by the Dashboard to show summary numbers.

// Simply returns how many items are in the list
public static int getTotalItems() { return items.size(); }

// Counts items where quantity is less than 10 (considered "low stock")
public static int getLowStockCount() {
   return (int) items.stream().filter(i -> i.getQuantity() < 10).count();
}

// Calculates total inventory value: sum of (price × quantity) for all items
public static double getTotalValue() {
   return items.stream().mapToDouble(i -> i.getPrice() * i.getQuantity()).sum();
}
}

//============================================================
//CLASS: LoginPanel  (OOP: INHERITANCE + EVENT LISTENERS)
//
//INHERITANCE: LoginPanel extends AppPanel.
//It inherits all the shared colors and helper methods from AppPanel,
//and adds login-specific fields and behavior on top.
//
//EVENT LISTENER 1 — ActionListener:
//LoginPanel implements ActionListener. This means it MUST provide
//an actionPerformed() method. Java calls this method automatically
//whenever a registered button is clicked. Here, it triggers the
//login logic when the Sign In button is clicked.
//
//EVENT LISTENER 2 — KeyListener:
//LoginPanel also implements KeyListener. This means it MUST provide
//keyPressed(), keyReleased(), and keyTyped() methods. We attach this
//listener to both text fields so pressing ENTER submits the form
//and pressing ESCAPE clears the fields — just like a real app.
//============================================================
class LoginPanel extends AppPanel implements ActionListener, KeyListener {

// Private fields — only accessible within this class (Encapsulation)
private JTextField       usernameField;   // the username input box
private JPasswordField   passwordField;   // the password input box (shows dots)
private JLabel           errorLabel;      // shows error messages in red
private JButton          loginButton;     // the Sign In button
private InventorySystem  parent;          // reference to the main window

// Constructor: takes the main window as a parameter so we can
// call parent.onLoginSuccess() once the user logs in successfully.
public LoginPanel(InventorySystem parent) {
   this.parent = parent;
   setLayout(new BorderLayout()); // use BorderLayout for this panel
   buildUI();                     // build all the visual components
}

// ── METHOD: buildUI() ───────────────────────────────────────────────
// Constructs the entire login screen visually.
// Layout strategy: a full-screen blue gradient background panel,
// with a white card centered on top using GridBagLayout.
// GridBagLayout is used inside the card so every element
// (labels, fields, button) stretches to the same exact width.
private void buildUI() {
   // Full-screen blue gradient background panel.
   // We override paintComponent to draw a gradient instead of a solid color.
   JPanel background = new JPanel() {
       @Override protected void paintComponent(Graphics g) {
           Graphics2D g2 = (Graphics2D) g.create();
           g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
           // GradientPaint draws a smooth transition between two colors
           // from top-left (dark blue) to bottom-right (lighter blue)
           GradientPaint gp = new GradientPaint(0, 0, PRIMARY_DARK, getWidth(), getHeight(), PRIMARY_LIGHT);
           g2.setPaint(gp);
           g2.fillRect(0, 0, getWidth(), getHeight());
           // Decorative translucent circles for visual depth
           g2.setColor(new Color(255, 255, 255, 18)); // white with 7% opacity
           g2.fillOval(-80, -80, 300, 300);
           g2.fillOval(getWidth() - 140, getHeight() - 140, 280, 280);
           g2.dispose();
       }
   };
   // GridBagLayout on background so the card is perfectly centered
   background.setLayout(new GridBagLayout());

   // White centered card with a subtle drop shadow.
   // We override paintComponent to draw the shadow and rounded white rectangle.
   JPanel card = new JPanel() {
       @Override protected void paintComponent(Graphics g) {
           Graphics2D g2 = (Graphics2D) g.create();
           g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
           // Shadow: draw a slightly offset semi-transparent rectangle
           g2.setColor(new Color(0, 0, 0, 30));
           g2.fillRoundRect(4, 6, getWidth() - 4, getHeight() - 4, 20, 20);
           // White card on top of shadow
           g2.setColor(Color.WHITE);
           g2.fillRoundRect(0, 0, getWidth() - 5, getHeight() - 5, 20, 20);
           g2.dispose();
       }
   };
   card.setOpaque(false); // transparent so shadow shows through
   // GridBagLayout inside card guarantees every row is the same width
   card.setLayout(new GridBagLayout());
   card.setPreferredSize(new Dimension(420, 460));

   // GridBagConstraints controls how each element is placed in the grid.
   // gc.fill = HORIZONTAL means each component stretches to fill the column width.
   // gc.weightx = 1.0 means this column takes all available horizontal space.
   // gc.insets controls the padding (top, left, bottom, right) around each item.
   GridBagConstraints gc = new GridBagConstraints();
   gc.gridx   = 0;                             // all items in column 0
   gc.fill    = GridBagConstraints.HORIZONTAL; // stretch horizontally
   gc.weightx = 1.0;
   gc.insets  = new Insets(0, 44, 0, 44);      // default side padding

   // Row 0: "IMS" brand title (centered)
   gc.gridy  = 0;
   gc.insets = new Insets(36, 44, 0, 44); // extra top padding
   JLabel appIcon = new JLabel("Inventory System", SwingConstants.CENTER);
   appIcon.setFont(new Font("Segoe UI", Font.BOLD, 34));
   appIcon.setForeground(PRIMARY);
   card.add(appIcon, gc);

   // Row 1: "Welcome Back" heading
   gc.gridy  = 1;
   gc.insets = new Insets(4, 44, 0, 44);
   JLabel titleLbl = new JLabel("Welcome Back", SwingConstants.CENTER);
   titleLbl.setFont(new Font("Segoe UI", Font.BOLD, 24));
   titleLbl.setForeground(new Color(15, 15, 15));
   card.add(titleLbl, gc);

   // Row 2: subtitle text
   gc.gridy  = 2;
   gc.insets = new Insets(4, 44, 24, 44); // extra bottom gap before fields
   JLabel subtitleLbl = new JLabel("Staff Login.", SwingConstants.CENTER);
   subtitleLbl.setFont(new Font("Segoe UI", Font.PLAIN, 13));
   subtitleLbl.setForeground(new Color(90, 90, 110));
   card.add(subtitleLbl, gc);

   // Row 3: "Username" label
   gc.gridy  = 3;
   gc.insets = new Insets(0, 44, 4, 44);
   JLabel userLbl = new JLabel("Username");
   userLbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
   userLbl.setForeground(new Color(15, 15, 15));
   card.add(userLbl, gc);

   // Row 4: username text field
   // addKeyListener(this) registers this LoginPanel as the KeyListener.
   // Now keyPressed() will fire whenever the user presses a key in this field.
   gc.gridy  = 4;
   gc.insets = new Insets(0, 44, 0, 44);
   usernameField = makeTextField("Enter your username");
   usernameField.addKeyListener(this); // KeyListener attached here
   card.add(usernameField, gc);

   // Row 5: "Password" label
   gc.gridy  = 5;
   gc.insets = new Insets(14, 44, 4, 44);
   JLabel passLbl = new JLabel("Password");
   passLbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
   passLbl.setForeground(new Color(15, 15, 15));
   card.add(passLbl, gc);

   // Row 6: password field
   gc.gridy  = 6;
   gc.insets = new Insets(0, 44, 0, 44);
   passwordField = makePasswordField("Enter your password");
   passwordField.addKeyListener(this); // KeyListener attached here too
   card.add(passwordField, gc);

   // Row 7: error label (empty at first, filled in red when login fails)
   gc.gridy  = 7;
   gc.insets = new Insets(8, 44, 0, 44);
   errorLabel = new JLabel(" "); // single space so it takes up height even when "empty"
   errorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
   errorLabel.setForeground(new Color(200, 40, 40)); // red
   card.add(errorLabel, gc);

   // Row 8: Sign In button
   // addActionListener(this) means: when this button is clicked,
   // call this LoginPanel's actionPerformed() method.
   gc.gridy  = 8;
   gc.insets = new Insets(4, 44, 36, 44);
   loginButton = makePrimaryButton("Sign In");
   loginButton.setPreferredSize(new Dimension(0, 42));
   loginButton.addActionListener(this); // ActionListener attached here
   card.add(loginButton, gc);

   background.add(card);
   add(background, BorderLayout.CENTER); // add the background to fill this panel
}

// ── EVENT LISTENER: ActionListener ──────────────────────────────────
// This method is automatically called by Java when any registered
// ActionListener source fires an event (i.e., a button is clicked).
// We check WHICH button was the source and respond accordingly.
@Override
public void actionPerformed(ActionEvent e) {
   if (e.getSource() == loginButton) {
       // The Sign In button was clicked — try to log in
       attemptLogin();
   }
}

// ── EVENT LISTENER: KeyListener ─────────────────────────────────────
// keyPressed() is called every time the user presses any key
// while the focus is inside either the username or password field.
@Override
public void keyPressed(KeyEvent e) {
   // VK_ENTER = the Enter/Return key
   // If the user presses Enter, submit the login form
   if (e.getKeyCode() == KeyEvent.VK_ENTER) {
       attemptLogin();
   }
   // VK_ESCAPE = the Escape key
   // If the user presses Escape, clear both fields and the error message
   if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
       usernameField.setText("");
       passwordField.setText("");
       errorLabel.setText("");
   }
}

// These two KeyListener methods are required by the interface
// but we don't need any behavior for them, so they stay empty.
@Override public void keyTyped(KeyEvent e)    {}
@Override public void keyReleased(KeyEvent e) {}

// ── METHOD: attemptLogin() ──────────────────────────────────────────
// Contains the actual login logic. Called both when the button
// is clicked (ActionListener) and when Enter is pressed (KeyListener).
// This avoids duplicating the same login code in two places.
private void attemptLogin() {
   // Read and trim whitespace from the username field
   String username = usernameField.getText().trim();
   // getPassword() returns char[] for security; convert to String for comparison
   String password = new String(passwordField.getPassword());

   // Validate: both fields must be filled
   if (username.isEmpty() || password.isEmpty()) {
       errorLabel.setText("Please fill in all fields.");
       return; // stop here, don't proceed
   }

   // Ask DataStore to check if username+password combination exists
   if (DataStore.authenticate(username, password)) {
       errorLabel.setText(""); // clear any previous error
       // Tell the main window login was successful, passing the User object
       parent.onLoginSuccess(DataStore.findUser(username));
   } else {
       // Wrong credentials: show error and clear password for re-entry
       errorLabel.setText("Incorrect username or password.");
       passwordField.setText("");
   }
}

// ── INHERITED METHOD: refresh() ─────────────────────────────────────
// Called when the user logs out and we return to the login screen.
// Clears all fields so the next user starts fresh.
// This is the implementation of the abstract method from AppPanel.
@Override
public void refresh() {
   usernameField.setText("");
   passwordField.setText("");
   errorLabel.setText("");
}
}

//============================================================
//CLASS: NavButton  (OOP: INHERITANCE)
//
//A specialized sidebar navigation button that inherits from JButton.
//It adds an "active" state — when active, it draws a highlighted
//background and accent bar on the left side.
//This is Inheritance: we extend JButton and add our own behavior.
//============================================================
class NavButton extends JButton {

private boolean active = false;
private Color PRIMARY       = new Color(25, 100, 200);
private Color PRIMARY_LIGHT = new Color(70, 140, 230);

// Constructor: sets the base appearance of every nav button
public NavButton(String text) {
   super(text); // call JButton's constructor with the label text
   setFont(new Font("Segoe UI", Font.PLAIN, 13));
   setForeground(new Color(190, 215, 255)); // pale blue text on the blue sidebar
   setHorizontalAlignment(SwingConstants.LEFT); // align text to the left
   setContentAreaFilled(false);
   setBorderPainted(false);
   setFocusPainted(false);
   setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
   setPreferredSize(new Dimension(0, 42));
   setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0)); // left indent
}

// Sets whether this button is the currently selected/active screen.
// Changes font to bold and text to white when active.
// repaint() tells Swing to redraw this button immediately.
public void setActive(boolean active) {
   this.active = active;
   setForeground(active ? Color.WHITE : new Color(190, 215, 255));
   setFont(new Font("Segoe UI", active ? Font.BOLD : Font.PLAIN, 13));
   repaint();
}

// Custom paint: draws an active highlight or hover highlight
@Override
protected void paintComponent(Graphics g) {
   Graphics2D g2 = (Graphics2D) g.create();
   g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

   if (active) {
       // Draw a semi-transparent white rounded background for the active item
       g2.setColor(new Color(255, 255, 255, 30));
       g2.fillRoundRect(8, 4, getWidth() - 16, getHeight() - 8, 8, 8);
       // Draw a small bright blue accent bar on the left edge
       g2.setColor(new Color(100, 180, 255));
       g2.fillRoundRect(8, 4, 4, getHeight() - 8, 4, 4);
   } else if (getModel().isRollover()) {
       // Draw a subtle hover effect
       g2.setColor(new Color(255, 255, 255, 12));
       g2.fillRoundRect(8, 4, getWidth() - 16, getHeight() - 8, 8, 8);
   }
   g2.dispose();
   super.paintComponent(g); // let JButton draw the label text on top
}
}

//============================================================
//CLASS: DashboardPanel  (OOP: INHERITANCE)
//
//INHERITANCE: DashboardPanel extends AppPanel.
//It shows a live clock, three summary stat cards, and a
//list of the latest inventory items.
//
//The live clock uses javax.swing.Timer — a Swing-safe timer
//that fires an ActionListener every 1000ms (1 second) on the
//Event Dispatch Thread, so it's safe to update UI labels.
//============================================================
class DashboardPanel extends AppPanel {

// Labels that will be updated by refresh() and updateClock()
private JLabel totalItemsVal, lowStockVal, totalValueVal;
private JLabel clockLabel, dateLabel;
private JPanel activityPanel; // the panel that holds the item list rows

// Constructor: set layout, background, build the UI, start the clock
public DashboardPanel() {
   setLayout(new BorderLayout(0, 0));
   setBackground(BG_LIGHT);
   buildUI();
   startClock(); // start the live clock after UI is built
}

// ── METHOD: startClock() ────────────────────────────────────────────
// Creates a javax.swing.Timer that calls updateClock() every 1 second.
// Unlike java.util.Timer, javax.swing.Timer fires on the EDT (Event
// Dispatch Thread), making it safe to update Swing components directly.
private void startClock() {
   // The lambda "e -> updateClock()" is the ActionListener.
   // It means: every 1000ms, call updateClock().
   javax.swing.Timer timer = new javax.swing.Timer(1000, e -> updateClock());
   timer.start();
   updateClock(); // call once immediately so we don't wait 1 second for first display
}

// ── METHOD: updateClock() ───────────────────────────────────────────
// Gets the current date and time from the system and updates the labels.
// Called once per second by the Timer.
private void updateClock() {
   java.time.LocalDateTime now = java.time.LocalDateTime.now();
   // Format time as HH:MM:SS using %02d (always 2 digits with leading zero)
   clockLabel.setText(String.format("%02d:%02d:%02d",
       now.getHour(), now.getMinute(), now.getSecond()));
   // Format date as "Monday, January 1, 2025"
   dateLabel.setText(now.toLocalDate()
       .format(java.time.format.DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy")));
}

// ── METHOD: buildUI() ───────────────────────────────────────────────
// Constructs the dashboard layout: title, clock card, stat cards, item list.
// Everything is placed in a vertical BoxLayout inside a JScrollPane
// so the user can scroll if the window is too small.
private void buildUI() {
   // Main scrollable container — stacks children top to bottom
   JPanel container = new JPanel();
   container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
   container.setBackground(BG_LIGHT);
   container.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // 30px padding on all sides

   // Page title
   JLabel title = makeLabel("Dashboard Overview", 24, true);
   title.setForeground(PRIMARY_DARK);
   title.setAlignmentX(Component.LEFT_ALIGNMENT);
   container.add(title);

   // Subtitle
   JLabel sub = makeLabel("Inventory overview.", 13, false);
   sub.setForeground(TEXT_MID);
   sub.setAlignmentX(Component.LEFT_ALIGNMENT);
   container.add(sub);
   container.add(Box.createVerticalStrut(18)); // 18px vertical gap

   // ── Live clock card ───────────────────────────────────────────
   // Custom-painted blue rounded card that shows the live time and date.
   JPanel clockCard = new JPanel() {
       @Override protected void paintComponent(Graphics g) {
           Graphics2D g2 = (Graphics2D) g.create();
           g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
           g2.setColor(PRIMARY); // solid blue fill
           g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 12, 12);
           g2.dispose();
       }
   };
   clockCard.setOpaque(false);
   clockCard.setLayout(new BoxLayout(clockCard, BoxLayout.Y_AXIS));
   clockCard.setBorder(BorderFactory.createEmptyBorder(14, 22, 14, 22));
   clockCard.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
   clockCard.setAlignmentX(Component.LEFT_ALIGNMENT);

   // Large time label (e.g. "14:35:22")
   clockLabel = new JLabel("00:00:00");
   clockLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
   clockLabel.setForeground(Color.WHITE);
   clockLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

   // Smaller date label (e.g. "Monday, February 23, 2025")
   dateLabel = new JLabel("Loading...");
   dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
   dateLabel.setForeground(new Color(200, 225, 255)); // pale blue
   dateLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

   clockCard.add(clockLabel);
   clockCard.add(Box.createVerticalStrut(2));
   clockCard.add(dateLabel);
   container.add(clockCard);
   container.add(Box.createVerticalStrut(18));

   // ── Stats row: 3 side-by-side stat cards ──────────────────────
   // GridLayout(1, 3) means 1 row, 3 columns, each equal width, 16px gap between them
   JPanel statsRow = new JPanel(new GridLayout(1, 3, 16, 0));
   statsRow.setBackground(BG_LIGHT);
   statsRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
   statsRow.setAlignmentX(Component.LEFT_ALIGNMENT);

   // These labels are declared as fields so refresh() can update their text
   totalItemsVal = new JLabel("0");
   lowStockVal   = new JLabel("0");
   totalValueVal = new JLabel("0");

   statsRow.add(makeStatCard("Total Products",  totalItemsVal, PRIMARY));
   statsRow.add(makeStatCard("Low Stock Items",  lowStockVal,   new Color(210, 100, 20)));
   statsRow.add(makeStatCard("Inventory Value",  totalValueVal, new Color(20, 150, 100)));
   container.add(statsRow);
   container.add(Box.createVerticalStrut(28));

   // ── Item summary list ─────────────────────────────────────────
   JLabel actTitle = makeLabel("Item Summary", 16, true);
   actTitle.setForeground(PRIMARY_DARK);
   actTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
   container.add(actTitle);
   container.add(Box.createVerticalStrut(10));

   // activityPanel is a field — refresh() will clear and rebuild it each time
   activityPanel = new JPanel();
   activityPanel.setLayout(new BoxLayout(activityPanel, BoxLayout.Y_AXIS));
   activityPanel.setBackground(Color.WHITE);
   activityPanel.setBorder(BorderFactory.createCompoundBorder(
       BorderFactory.createLineBorder(BORDER_COLOR, 1, true),
       BorderFactory.createEmptyBorder(10, 16, 10, 16)
   ));
   activityPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
   container.add(activityPanel);

   // Wrap the container in a JScrollPane so the user can scroll
   JScrollPane scroll = new JScrollPane(container);
   scroll.setBorder(null); // no border on the scroll pane itself
   scroll.getViewport().setBackground(BG_LIGHT);
   add(scroll, BorderLayout.CENTER);
}

// ── METHOD: makeStatCard() ───────────────────────────────────────────
// Creates a white rounded card with a colored accent bar on the left,
// a small label at the top, and a large number below it.
// Parameters:
//   label      = the title text (e.g. "Total Products")
//   valueLabel = the JLabel whose text will be updated by refresh()
//   accent     = the color of the left border bar and the number
private JPanel makeStatCard(String label, JLabel valueLabel, Color accent) {
   // Override paintComponent for custom rounded shape with colored left bar
   JPanel card = new JPanel() {
       @Override protected void paintComponent(Graphics g) {
           Graphics2D g2 = (Graphics2D) g.create();
           g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
           g2.setColor(BG_WHITE);
           g2.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);       // white background
           g2.setColor(accent);
           g2.fillRoundRect(0, 0, 5, getHeight(), 4, 4);                 // left accent bar
           g2.setColor(BORDER_COLOR);
           g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 12, 12); // border
           g2.dispose();
       }
   };
   card.setLayout(new GridBagLayout()); // centers inner content
   card.setOpaque(false);

   JPanel inner = new JPanel();
   inner.setLayout(new BoxLayout(inner, BoxLayout.Y_AXIS));
   inner.setOpaque(false);

   JLabel lbl = new JLabel(label);
   lbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
   lbl.setForeground(new Color(50, 50, 70)); // dark label

   valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 30)); // large number
   valueLabel.setForeground(accent); // number matches the accent color

   inner.add(lbl);
   inner.add(Box.createVerticalStrut(4));
   inner.add(valueLabel);
   card.add(inner);
   return card;
}

// ── INHERITED METHOD: refresh() ─────────────────────────────────────
// Called every time the dashboard becomes visible.
// Updates all stat numbers and rebuilds the item summary list
// with the latest data from DataStore.
// This is POLYMORPHISM in action — the same refresh() call
// on different panel types produces different behavior.
@Override
public void refresh() {
   // Update the three stat card numbers
   totalItemsVal.setText(String.valueOf(DataStore.getTotalItems()));
   lowStockVal.setText(String.valueOf(DataStore.getLowStockCount()));
   totalValueVal.setText(String.format("P %.2f", DataStore.getTotalValue()));

   // Rebuild the item summary list from scratch
   activityPanel.removeAll(); // clear old rows

   List<Item> items = DataStore.getItems();
   if (items.isEmpty()) {
       // Show a message if there are no items at all
       JLabel empty = new JLabel("No items in inventory.");
       empty.setFont(new Font("Segoe UI", Font.ITALIC, 13));
       empty.setForeground(TEXT_MID);
       activityPanel.add(empty);
   } else {
       // Show at most 8 items (so the list doesn't get too long)
       for (int i = 0; i < Math.min(items.size(), 8); i++) {
           Item item = items.get(i);
           JPanel row = new JPanel(new BorderLayout());
           // Alternate white/light rows for readability (zebra striping)
           row.setBackground(i % 2 == 0 ? Color.WHITE : new Color(245, 249, 255));
           row.setBorder(BorderFactory.createEmptyBorder(6, 0, 6, 0));

           // Left side: item name and category
           JLabel nameL = new JLabel(item.getName() + "  [" + item.getCategory() + "]");
           nameL.setFont(new Font("Segoe UI", Font.PLAIN, 13));
           nameL.setForeground(new Color(10, 10, 10));

           // Right side: quantity, colored red if low stock (< 10), green otherwise
           JLabel qtyL = new JLabel("Qty: " + item.getQuantity());
           qtyL.setFont(new Font("Segoe UI", Font.BOLD, 13));
           qtyL.setForeground(item.getQuantity() < 10
               ? new Color(200, 80, 20)   // orange-red = low stock warning
               : new Color(20, 140, 80)); // green = healthy stock

           row.add(nameL, BorderLayout.WEST);
           row.add(qtyL, BorderLayout.EAST);
           activityPanel.add(row);

           // Add a thin separator line between rows
           if (i < items.size() - 1) {
               JSeparator sep = new JSeparator();
               sep.setForeground(BORDER_COLOR);
               activityPanel.add(sep);
           }
       }
   }
   // Tell Swing to recalculate layouts and repaint the activity panel
   activityPanel.revalidate();
   activityPanel.repaint();
}
}

//============================================================
//CLASS: InventoryPanel  (OOP: INHERITANCE + POLYMORPHISM)
//
//INHERITANCE: InventoryPanel extends AppPanel.
//
//POLYMORPHISM: The actionPerformed() method is a single method
//that handles FOUR different buttons (Add, Edit, Delete, Refresh).
//Depending on which button was the source, it calls a different
//private method. This is polymorphic dispatch — same method
//name, different behavior based on the source.
//
//Also, refresh() here does something completely different
//from DashboardPanel's refresh() — both override the same
//abstract method but produce different behavior. That is
//Polymorphism through method overriding.
//
//EVENT LISTENERS here:
//- ActionListener: handles all 4 CRUD buttons
//- KeyListener: live search — filter table as user types
//============================================================
class InventoryPanel extends AppPanel implements ActionListener, KeyListener {

private JTable             table;        // the visual table component
private DefaultTableModel  tableModel;   // the data model behind the table
private JTextField         searchField;  // the search input box
private JButton            addBtn, editBtn, deleteBtn, refreshBtn;
private User               currentUser;  // the logged-in user

// Column headers for the JTable — exactly 6 columns
private static final String[] COLUMNS = {
   "ID", "Name", "Category", "Quantity", "Price (PHP)", "Description"
};

// Constructor: stores the logged-in user and builds the UI
public InventoryPanel(User user) {
   this.currentUser = user;
   setLayout(new BorderLayout());
   setBackground(BG_LIGHT);
   buildUI();
}

// ── METHOD: buildUI() ────────────────────────────────────────────────
// Builds the three-zone layout:
//   NORTH  = top bar (title, search, buttons)
//   CENTER = the scrollable table
//   SOUTH  = a small hint tip at the bottom
private void buildUI() {
   // Top bar panel: Inventory title on the left, controls on the right
   JPanel topBar = new JPanel(new BorderLayout(12, 0));
   topBar.setBackground(BG_WHITE);
   topBar.setBorder(BorderFactory.createCompoundBorder(
       BorderFactory.createMatteBorder(0, 0, 1, 0, BORDER_COLOR), // bottom border line
       BorderFactory.createEmptyBorder(14, 24, 14, 24)            // inner padding
   ));

   JLabel title = makeLabel("Inventory", 20, true);
   title.setForeground(PRIMARY_DARK);

   // Search field — KeyListener is attached so filterTable() fires on each keystroke
   searchField = makeTextField("Search items...");
   searchField.setPreferredSize(new Dimension(240, 36));
   searchField.addKeyListener(this); // KeyListener registered here

   // Right side of top bar: search + action buttons
   JPanel topRight = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
   topRight.setBackground(BG_WHITE);

   addBtn     = makePrimaryButton("+ Add Item");
   editBtn    = makeSecondaryButton("Edit");
   deleteBtn  = makeSecondaryButton("Delete");
   refreshBtn = makeSecondaryButton("Refresh");

   addBtn.setPreferredSize(new Dimension(110, 36));
   editBtn.setPreferredSize(new Dimension(80, 36));
   deleteBtn.setPreferredSize(new Dimension(80, 36));
   refreshBtn.setPreferredSize(new Dimension(90, 36));

   // Register this InventoryPanel as the ActionListener for all 4 buttons.
   // When any of these buttons is clicked, actionPerformed() will be called.
   addBtn.addActionListener(this);     // ActionListener registered here
   editBtn.addActionListener(this);
   deleteBtn.addActionListener(this);
   refreshBtn.addActionListener(this);

   topRight.add(searchField);
   topRight.add(addBtn);
   topRight.add(editBtn);
   topRight.add(deleteBtn);
   topRight.add(refreshBtn);

   topBar.add(title,    BorderLayout.WEST);
   topBar.add(topRight, BorderLayout.EAST);

   // Table model with our column headers.
   // We override isCellEditable to return false — users cannot type directly
   // into the table cells; all editing happens through the Edit dialog.
   tableModel = new DefaultTableModel(COLUMNS, 0) {
       @Override public boolean isCellEditable(int row, int col) { return false; }
   };
   table = new JTable(tableModel);
   styleTable(); // apply colors, fonts, custom renderers

   JScrollPane scrollPane = new JScrollPane(table);
   scrollPane.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, BORDER_COLOR));
   scrollPane.getViewport().setBackground(BG_WHITE);

   // Footer hint
   JPanel footer = new JPanel(new BorderLayout());
   footer.setBackground(BG_LIGHT);
   footer.setBorder(BorderFactory.createEmptyBorder(8, 24, 8, 24));
   JLabel footerNote = makeLabel("Tip: Select a row, then click Edit or Delete.", 11, false);
   footerNote.setForeground(new Color(80, 80, 95));
   footer.add(footerNote, BorderLayout.WEST);

   add(topBar,     BorderLayout.NORTH);
   add(scrollPane, BorderLayout.CENTER);
   add(footer,     BorderLayout.SOUTH);
}

// ── METHOD: styleTable() ────────────────────────────────────────────
// Applies all visual styling to the JTable: fonts, row height, colors,
// custom header renderer (blue), and custom row renderer (alternating rows).
private void styleTable() {
   table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
   table.setRowHeight(36);                           // 36px tall rows
   table.setShowGrid(false);                         // no grid lines
   table.setIntercellSpacing(new Dimension(0, 0));   // no cell spacing
   table.setBackground(BG_WHITE);
   table.setForeground(new Color(10, 10, 10));
   table.setSelectionBackground(new Color(210, 230, 255)); // light blue selected row
   table.setSelectionForeground(new Color(10, 10, 10));
   table.setFillsViewportHeight(true); // table fills the full height of the scroll pane

   JTableHeader header = table.getTableHeader();
   header.setFont(new Font("Segoe UI", Font.BOLD, 12));
   header.setReorderingAllowed(false); // user cannot drag columns around
   header.setPreferredSize(new Dimension(0, 38));

   // Custom header renderer: forces blue background + white text.
   // Without this, the system Look & Feel overrides header colors.
   header.setDefaultRenderer(new DefaultTableCellRenderer() {
       @Override
       public Component getTableCellRendererComponent(JTable t, Object value,
               boolean selected, boolean focused, int row, int col) {
           JLabel lbl = (JLabel) super.getTableCellRendererComponent(
                   t, value, selected, focused, row, col);
           lbl.setBackground(PRIMARY);                         // blue header
           lbl.setForeground(Color.WHITE);                     // white text
           lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
           lbl.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
           lbl.setOpaque(true); // must be opaque or background won't show
           return lbl;
       }
   });

   // Custom row renderer: alternating row colors + always-black text.
   // Without this, the system LAF might make text hard to read.
   table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
       @Override
       public Component getTableCellRendererComponent(JTable t, Object value,
               boolean selected, boolean focused, int row, int col) {
           Component c = super.getTableCellRendererComponent(t, value, selected, focused, row, col);
           if (selected) {
               c.setBackground(new Color(210, 230, 255)); // light blue highlight
               c.setForeground(new Color(10, 10, 10));
           } else {
               // Zebra striping: even rows white, odd rows very light blue
               c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(245, 249, 255));
               c.setForeground(new Color(10, 10, 10));
           }
           setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10)); // cell padding
           return c;
       }
   });

   // Set preferred widths for each column
   int[] widths = {45, 200, 120, 80, 110, 240};
   for (int i = 0; i < widths.length; i++)
       table.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);
}

// ── EVENT LISTENER: ActionListener (POLYMORPHISM) ───────────────────
// This single method handles ALL four button clicks.
// It checks the source of the event and dispatches to the right method.
// This is an example of Polymorphism — the same interface method
// produces different behaviors at runtime based on what triggered it.
@Override
public void actionPerformed(ActionEvent e) {
   Object src = e.getSource();
   if      (src == addBtn)     showItemDialog(null);     // null = we're adding, not editing
   else if (src == editBtn)    editSelectedItem();
   else if (src == deleteBtn)  deleteSelectedItem();
   else if (src == refreshBtn) refresh();
}

// ── EVENT LISTENER: KeyListener (live search) ───────────────────────
// keyReleased() fires AFTER a key is pressed AND released.
// We use keyReleased (not keyPressed) because by the time keyReleased
// fires, the text field already contains the new character.
// We read the search field's current text and filter the table.
@Override
public void keyReleased(KeyEvent e) {
   if (e.getSource() == searchField) {
       filterTable(searchField.getText().trim()); // filter on every keystroke
   }
}

// These two are required by KeyListener interface but not needed here
@Override public void keyPressed(KeyEvent e)  {}
@Override public void keyTyped(KeyEvent e)    {}

// ── METHOD: filterTable() ────────────────────────────────────────────
// Clears the table and re-populates it with only items that match the query.
// If the query is empty, all items are shown.
// Matching is case-insensitive on both Name and Category fields.
private void filterTable(String query) {
   tableModel.setRowCount(0); // remove all rows from the table display
   for (Item item : DataStore.getItems()) {
       if (query.isEmpty()
           || item.getName().toLowerCase().contains(query.toLowerCase())
           || item.getCategory().toLowerCase().contains(query.toLowerCase())) {
           tableModel.addRow(item.toTableRow()); // add matching row
       }
   }
}

// ── METHOD: editSelectedItem() ───────────────────────────────────────
// Gets the ID of the selected row in the table, finds the corresponding
// Item object from DataStore, and opens the dialog pre-filled with its data.
private void editSelectedItem() {
   int row = table.getSelectedRow(); // returns -1 if no row is selected
   if (row < 0) {
       JOptionPane.showMessageDialog(this,
           "Please select an item to edit.", "No Selection", JOptionPane.WARNING_MESSAGE);
       return;
   }
   // Column 0 of the table contains the item ID as a String
   int id = Integer.parseInt((String) tableModel.getValueAt(row, 0));
   showItemDialog(DataStore.findItem(id)); // pass the Item object to pre-fill the form
}

// ── METHOD: deleteSelectedItem() ────────────────────────────────────
// Gets the selected row's name (for the confirmation message) and ID (to delete).
// Shows a Yes/No confirmation dialog before deleting.
private void deleteSelectedItem() {
   int row = table.getSelectedRow();
   if (row < 0) {
       JOptionPane.showMessageDialog(this,
           "Please select an item to delete.", "No Selection", JOptionPane.WARNING_MESSAGE);
       return;
   }
   String name = (String) tableModel.getValueAt(row, 1); // column 1 = Name
   int confirm = JOptionPane.showConfirmDialog(this,
       "Are you sure you want to delete \"" + name + "\"?",
       "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

   if (confirm == JOptionPane.YES_OPTION) {
       int id = Integer.parseInt((String) tableModel.getValueAt(row, 0));
       DataStore.removeItem(id); // remove from data store
       refresh();                // refresh the table to reflect the deletion
   }
}

// ── METHOD: showItemDialog() ─────────────────────────────────────────
// This one method handles BOTH Add and Edit dialogs.
// If "existing" is null   → we are ADDING a new item (fields start empty).
// If "existing" is an Item → we are EDITING (fields are pre-filled).
// Uses dialog.pack() to auto-size the dialog to exactly fit its content,
// ensuring the buttons are never cut off.
private void showItemDialog(Item existing) {
   boolean isEdit = existing != null;

   // Create a modal dialog (blocks the parent window while open)
   JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this),
                                isEdit ? "Edit Item" : "Add New Item", true);
   dialog.setResizable(false);
   dialog.setLocationRelativeTo(this);

   // Outer panel: white background with padding
   JPanel outer = new JPanel(new BorderLayout());
   outer.setBackground(Color.WHITE);
   outer.setBorder(BorderFactory.createEmptyBorder(28, 32, 24, 32));

   // Dialog title
   JLabel dlgTitle = new JLabel(isEdit ? "Edit Item Details" : "Add New Item");
   dlgTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
   dlgTitle.setForeground(PRIMARY_DARK);
   dlgTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
   outer.add(dlgTitle, BorderLayout.NORTH);

   // Form area: GridBagLayout ensures all labels and fields are same width
   JPanel form = new JPanel(new GridBagLayout());
   form.setBackground(Color.WHITE);

   // Field names for display
   String[] labels = {"Name", "Category", "Quantity", "Price (PHP)", "Description"};

   // Pre-fill values: if editing, use existing item's data; otherwise empty strings
   String[] prefillEdit = isEdit ? new String[]{
       existing.getName(),
       existing.getCategory(),
       String.valueOf(existing.getQuantity()),
       String.format("%.2f", existing.getPrice()),
       existing.getDescription()
   } : new String[]{"", "", "", "", ""};

   JTextField[] inputs = new JTextField[labels.length]; // array to hold all 5 fields

   GridBagConstraints gc = new GridBagConstraints();
   gc.fill    = GridBagConstraints.HORIZONTAL;
   gc.weightx = 1.0;
   gc.gridx   = 0;

   // Build each label + field pair using a loop
   for (int i = 0; i < labels.length; i++) {
       // Label row (even grid row: 0, 2, 4, 6, 8)
       gc.gridy  = i * 2;
       gc.insets = new Insets(i == 0 ? 0 : 12, 0, 4, 0); // extra top gap between fields
       JLabel lbl = new JLabel(labels[i]);
       lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
       lbl.setForeground(new Color(15, 15, 15));
       form.add(lbl, gc);

       // Field row (odd grid row: 1, 3, 5, 7, 9)
       gc.gridy  = i * 2 + 1;
       gc.insets = new Insets(0, 0, 0, 0);
       inputs[i] = makeTextField(labels[i]);
       inputs[i].setText(prefillEdit[i]); // pre-fill if editing
       inputs[i].setPreferredSize(new Dimension(0, 38));
       form.add(inputs[i], gc);
   }

   // Error label below the fields (shows validation messages)
   gc.gridy  = labels.length * 2; // row after all fields
   gc.insets = new Insets(10, 0, 0, 0);
   JLabel errLbl = new JLabel(" "); // single space keeps height even when "empty"
   errLbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
   errLbl.setForeground(new Color(180, 30, 30));
   form.add(errLbl, gc);

   outer.add(form, BorderLayout.CENTER);

   // Button row pinned to SOUTH — always visible at the bottom
   JPanel btnRow = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
   btnRow.setBackground(Color.WHITE);
   btnRow.setBorder(BorderFactory.createEmptyBorder(18, 0, 0, 0));
   JButton cancelBtn = makeSecondaryButton("Cancel");
   JButton saveBtn   = makePrimaryButton(isEdit ? "Save Changes" : "Add Item");
   cancelBtn.setPreferredSize(new Dimension(100, 38));
   saveBtn.setPreferredSize(new Dimension(130, 38));
   btnRow.add(cancelBtn);
   btnRow.add(saveBtn);
   outer.add(btnRow, BorderLayout.SOUTH);

   // Cancel button: just close the dialog without saving
   cancelBtn.addActionListener(ev -> dialog.dispose());

   // Save button: validate input, then save or update the item
   saveBtn.addActionListener(ev -> {
       String name    = inputs[0].getText().trim();
       String cat     = inputs[1].getText().trim();
       String qtyTx   = inputs[2].getText().trim();
       String priceTx = inputs[3].getText().trim();
       String desc    = inputs[4].getText().trim();

       // Validation 1: name and category must not be blank
       if (name.isEmpty() || cat.isEmpty()) {
           errLbl.setText("Name and Category are required.");
           return; // stop — do not close dialog
       }

       // Validation 2: quantity must be a valid integer
       int qty;
       try {
           qty = Integer.parseInt(qtyTx);
       } catch (NumberFormatException ex) {
           errLbl.setText("Quantity must be a whole number (e.g. 10).");
           return;
       }

       // Validation 3: price must be a valid decimal number
       double price;
       try {
           price = Double.parseDouble(priceTx);
       } catch (NumberFormatException ex) {
           errLbl.setText("Price must be a number (e.g. 199.99).");
           return;
       }

       // All validations passed — either update existing or create new item
       if (isEdit) {
           // Update the existing Item object's fields using setters (Encapsulation)
           existing.setName(name);
           existing.setCategory(cat);
           existing.setQuantity(qty);
           existing.setPrice(price);
           existing.setDescription(desc);
       } else {
           // Create a brand new Item and add it to DataStore
           DataStore.addItem(new Item(name, cat, qty, price, desc));
       }
       refresh();          // reload the table with the new/updated data
       dialog.dispose();   // close the dialog
   });

   dialog.setContentPane(outer);
   dialog.pack();                       // auto-size dialog to fit all content
   dialog.setMinimumSize(new Dimension(420, 0));
   dialog.setLocationRelativeTo(this);  // re-center after pack
   dialog.setVisible(true);
}

// ── INHERITED METHOD: refresh() ─────────────────────────────────────
// Reloads the table from DataStore, applying the current search filter
// if one is active. This is POLYMORPHISM — same method name as other
// panels, but this version specifically reloads the inventory table.
@Override
public void refresh() {
   filterTable(searchField != null ? searchField.getText().trim() : "");
}
}

//============================================================
//CLASS: ProfilePanel  (OOP: INHERITANCE)
//
//INHERITANCE: ProfilePanel extends AppPanel.
//Shows the logged-in user's information and allows them to:
//1. View their current profile details
//2. Edit their full name and email
//3. Change their password (requires entering current password first)
//
//ActionListener is used for the "Save Info" and "Change Password" buttons.
//============================================================
class ProfilePanel extends AppPanel implements ActionListener {

private User           currentUser;                         // the logged-in user
private JLabel         fullNameLbl, usernameLbl, emailLbl, roleLbl, joinLbl; // display labels
private JTextField     editName, editEmail;                 // editable fields
private JPasswordField editOldPass, editNewPass;            // password change fields
private JLabel         statusLbl;                           // success/error message
private JButton        saveInfoBtn, changePassBtn;          // action buttons

// Constructor: stores the user reference and builds the UI
public ProfilePanel(User user) {
   this.currentUser = user;
   setLayout(new BorderLayout());
   setBackground(BG_LIGHT);
   buildUI();
}

// ── METHOD: buildUI() ────────────────────────────────────────────────
// Builds three stacked white cards:
//   Card 1: Avatar + account details (read-only view)
//   Card 2: Edit name and email form
//   Card 3: Change password form
private void buildUI() {
   // Main scrollable outer container
   JPanel outer = new JPanel();
   outer.setLayout(new BoxLayout(outer, BoxLayout.Y_AXIS));
   outer.setBackground(BG_LIGHT);
   outer.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

   // Page heading
   JLabel title = makeLabel("My Profile", 24, true);
   title.setForeground(PRIMARY_DARK);
   title.setAlignmentX(Component.LEFT_ALIGNMENT);
   outer.add(title);
   outer.add(Box.createVerticalStrut(4));
   JLabel sub = makeLabel("View and update your account information.", 13, false);
   sub.setForeground(TEXT_MID);
   sub.setAlignmentX(Component.LEFT_ALIGNMENT);
   outer.add(sub);
   outer.add(Box.createVerticalStrut(24));

   // ── Card 1: Avatar + Info (read-only) ─────────────────────────
   JPanel infoCard = makeCard();
   infoCard.setLayout(new BorderLayout(24, 0));

   // Blue circle avatar with the user's first initial drawn in white text
   JPanel avatarWrap = new JPanel(new GridBagLayout());
   avatarWrap.setOpaque(false);
   JPanel avatar = new JPanel() {
       @Override protected void paintComponent(Graphics g) {
           Graphics2D g2 = (Graphics2D) g.create();
           g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
           g2.setColor(PRIMARY); // blue circle
           g2.fillOval(0, 0, getWidth(), getHeight());
           // Draw the first letter of the user's name in the center
           String init = currentUser.getFullName().substring(0, 1).toUpperCase();
           g2.setColor(Color.WHITE);
           g2.setFont(new Font("Segoe UI", Font.BOLD, 40));
           FontMetrics fm = g2.getFontMetrics();
           g2.drawString(init,
               (getWidth()  - fm.stringWidth(init)) / 2,
               (getHeight() + fm.getAscent() - fm.getDescent()) / 2);
           g2.dispose();
       }
   };
   avatar.setPreferredSize(new Dimension(90, 90));
   avatar.setOpaque(false);
   avatarWrap.add(avatar);
   infoCard.add(avatarWrap, BorderLayout.WEST);

   // GridLayout(5, 2) places 5 rows of key-value pairs side by side
   JPanel details = new JPanel(new GridLayout(5, 2, 8, 4));
   details.setOpaque(false);
   details.setBorder(BorderFactory.createEmptyBorder(4, 0, 4, 0));

   // These labels are fields so refresh() can update them
   fullNameLbl = makeLabel("", 13, false);
   usernameLbl = makeLabel("", 13, false);
   emailLbl    = makeLabel("", 13, false);
   roleLbl     = makeLabel("", 13, false);
   joinLbl     = makeLabel("", 13, false);

   details.add(makeLabel("Full Name:",    12, true)); details.add(fullNameLbl);
   details.add(makeLabel("Username:",     12, true)); details.add(usernameLbl);
   details.add(makeLabel("Email:",        12, true)); details.add(emailLbl);
   details.add(makeLabel("Role:",         12, true)); details.add(roleLbl);
   details.add(makeLabel("Member Since:", 12, true)); details.add(joinLbl);

   infoCard.add(details, BorderLayout.CENTER);
   outer.add(infoCard);
   outer.add(Box.createVerticalStrut(20));

   // ── Card 2: Edit Name + Email ──────────────────────────────────
   JPanel editCard = makeCard();
   editCard.setLayout(new BoxLayout(editCard, BoxLayout.Y_AXIS));

   JLabel editTitle = makeLabel("Edit Information", 15, true);
   editTitle.setForeground(PRIMARY_DARK);
   editTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
   editCard.add(editTitle);
   editCard.add(Box.createVerticalStrut(14));

   // Two fields side by side in a 1-row, 2-column grid
   JPanel editGrid = new JPanel(new GridLayout(2, 2, 12, 10));
   editGrid.setOpaque(false);
   editGrid.setAlignmentX(Component.LEFT_ALIGNMENT);
   editName  = makeTextField("Full Name");
   editEmail = makeTextField("Email");
   editGrid.add(makeLabeledField("Full Name", editName));
   editGrid.add(makeLabeledField("Email", editEmail));
   editCard.add(editGrid);
   editCard.add(Box.createVerticalStrut(14));

   // Save Info button
   saveInfoBtn = makePrimaryButton("Save Info");
   saveInfoBtn.setPreferredSize(new Dimension(120, 36));
   saveInfoBtn.setMaximumSize(new Dimension(120, 36));
   saveInfoBtn.setAlignmentX(Component.LEFT_ALIGNMENT);
   saveInfoBtn.addActionListener(this); // ActionListener registered here
   editCard.add(saveInfoBtn);

   outer.add(editCard);
   outer.add(Box.createVerticalStrut(20));

   // ── Card 3: Change Password ────────────────────────────────────
   JPanel passCard = makeCard();
   passCard.setLayout(new BoxLayout(passCard, BoxLayout.Y_AXIS));

   JLabel passTitle = makeLabel("Change Password", 15, true);
   passTitle.setForeground(PRIMARY_DARK);
   passTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
   passCard.add(passTitle);
   passCard.add(Box.createVerticalStrut(14));

   JPanel passGrid = new JPanel(new GridLayout(1, 2, 12, 0));
   passGrid.setOpaque(false);
   passGrid.setAlignmentX(Component.LEFT_ALIGNMENT);
   editOldPass = makePasswordField("Current Password");
   editNewPass = makePasswordField("New Password");
   passGrid.add(makeLabeledFieldPass("Current Password", editOldPass));
   passGrid.add(makeLabeledFieldPass("New Password",     editNewPass));
   passCard.add(passGrid);
   passCard.add(Box.createVerticalStrut(14));

   // Change Password button
   changePassBtn = makePrimaryButton("Change Password");
   changePassBtn.setPreferredSize(new Dimension(150, 36));
   changePassBtn.setMaximumSize(new Dimension(150, 36));
   changePassBtn.setAlignmentX(Component.LEFT_ALIGNMENT);
   changePassBtn.addActionListener(this); // ActionListener registered here
   passCard.add(changePassBtn);

   outer.add(passCard);
   outer.add(Box.createVerticalStrut(12));

   // Status label: shows green success or red error messages
   statusLbl = makeLabel("", 13, false);
   statusLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
   outer.add(statusLbl);

   // Wrap in scroll pane so it's usable on small screens
   JScrollPane scroll = new JScrollPane(outer);
   scroll.setBorder(null);
   scroll.getViewport().setBackground(BG_LIGHT);
   add(scroll, BorderLayout.CENTER);
}

// ── HELPER METHOD: makeCard() ────────────────────────────────────────
// Creates a white rounded card panel with a light border.
// Used for each of the three sections on the profile page.
private JPanel makeCard() {
   JPanel card = new JPanel() {
       @Override protected void paintComponent(Graphics g) {
           Graphics2D g2 = (Graphics2D) g.create();
           g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
           g2.setColor(BG_WHITE);
           g2.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);   // white fill
           g2.setColor(BORDER_COLOR);
           g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 12, 12); // border
           g2.dispose();
       }
   };
   card.setOpaque(false);
   card.setBorder(BorderFactory.createEmptyBorder(20, 24, 20, 24));
   card.setAlignmentX(Component.LEFT_ALIGNMENT);
   card.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
   return card;
}

// ── HELPER: makeLabeledField() ───────────────────────────────────────
// Creates a small label above a text field, stacked vertically.
// Returns them wrapped in a panel so they move together as a unit.
private JPanel makeLabeledField(String label, JTextField field) {
   JPanel p = new JPanel();
   p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
   p.setOpaque(false);
   JLabel lbl = makeLabel(label, 11, true);
   lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
   field.setAlignmentX(Component.LEFT_ALIGNMENT);
   field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
   p.add(lbl);
   p.add(Box.createVerticalStrut(4));
   p.add(field);
   return p;
}

// Same as makeLabeledField but for password fields
private JPanel makeLabeledFieldPass(String label, JPasswordField field) {
   JPanel p = new JPanel();
   p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
   p.setOpaque(false);
   JLabel lbl = makeLabel(label, 11, true);
   lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
   field.setAlignmentX(Component.LEFT_ALIGNMENT);
   field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
   p.add(lbl);
   p.add(Box.createVerticalStrut(4));
   p.add(field);
   return p;
}

// ── EVENT LISTENER: ActionListener ───────────────────────────────────
// Handles both the "Save Info" and "Change Password" button clicks.
// Checks which button was clicked and runs the appropriate logic.
@Override
public void actionPerformed(ActionEvent e) {
   if (e.getSource() == saveInfoBtn) {
       // ── Save profile info ──────────────────────────────────────
       String name  = editName.getText().trim();
       String email = editEmail.getText().trim();

       if (name.isEmpty() || email.isEmpty()) {
           showStatus("Name and email cannot be empty.", false);
           return;
       }
       // Update the User object using its setters (Encapsulation)
       currentUser.setFullName(name);
       currentUser.setEmail(email);
       showStatus("Profile updated successfully.", true);
       refresh(); // re-read the updated values back into the display labels

   } else if (e.getSource() == changePassBtn) {
       // ── Change password ────────────────────────────────────────
       String oldPass = new String(editOldPass.getPassword());
       String newPass = new String(editNewPass.getPassword());

       // Security: verify the user knows their current password first
       if (!currentUser.getPassword().equals(oldPass)) {
           showStatus("Current password is incorrect.", false);
           return;
       }
       // Enforce minimum password length
       if (newPass.length() < 6) {
           showStatus("New password must be at least 6 characters.", false);
           return;
       }
       currentUser.setPassword(newPass); // update via setter (Encapsulation)
       editOldPass.setText("");
       editNewPass.setText("");
       showStatus("Password changed successfully.", true);
   }
}

// ── HELPER: showStatus() ────────────────────────────────────────────
// Shows a message in the status label at the bottom of the page.
// Green for success, red for error.
private void showStatus(String msg, boolean success) {
   statusLbl.setForeground(success ? new Color(20, 140, 80) : new Color(200, 40, 40));
   statusLbl.setText(msg);
}

// ── INHERITED METHOD: refresh() ─────────────────────────────────────
// Re-reads all values from the User object and displays them.
// Called after saving so the view reflects the changes immediately.
@Override
public void refresh() {
   fullNameLbl.setText(currentUser.getFullName());
   usernameLbl.setText(currentUser.getUsername());
   emailLbl.setText(currentUser.getEmail());
   roleLbl.setText(currentUser.getRole());
   joinLbl.setText(currentUser.getJoinDate());
   // Also pre-fill the edit fields with current values
   editName.setText(currentUser.getFullName());
   editEmail.setText(currentUser.getEmail());
}
}

//============================================================
//CLASS: InventorySystem  (MAIN WINDOW + WINDOW LISTENER)
//
//This is the main JFrame — the outermost window of the application.
//It manages the overall navigation between Login and the main app,
//and contains the sidebar navigation.
//
//EVENT LISTENER 3 — WindowListener:
//InventorySystem implements WindowListener, which provides 7 methods
//for responding to window state changes: open, close, minimize,
//restore, activate, deactivate, and closed.
//We use windowClosing() to intercept the X button and show a
//"Are you sure you want to exit?" confirmation before closing.
//Without this, JFrame.DO_NOTHING_ON_CLOSE means the X button
//does nothing on its own — the WindowListener handles it instead.
//============================================================
public class InventorySystem extends JFrame implements WindowListener {

private CardLayout cardLayout; // switches between Login and Main views
private JPanel     cardPanel;  // the container that CardLayout manages
private User       loggedInUser;

// Named constants for the CardLayout card names
private static final String CARD_LOGIN = "LOGIN";
private static final String CARD_MAIN  = "MAIN";

// Screen panels
private LoginPanel     loginPanel;
private JPanel         mainView;
private DashboardPanel dashboardPanel;
private InventoryPanel inventoryPanel;
private ProfilePanel   profilePanel;

// Sidebar navigation buttons
private NavButton navDashboard, navInventory, navProfile, navLogout;

// ── Constructor ──────────────────────────────────────────────────────
// Sets up the main window properties and shows the login screen first.
public InventorySystem() {
   setTitle("Inventory Management System");
   setSize(1200, 750);
   setMinimumSize(new Dimension(900, 600));
   // DO_NOTHING_ON_CLOSE means clicking X does nothing by default.
   // Our WindowListener (windowClosing) takes over and shows a dialog.
   setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
   setLocationRelativeTo(null); // center the window on screen

   addWindowListener(this); // WindowListener registered here

   // CardLayout allows us to stack multiple panels and show one at a time
   cardLayout = new CardLayout();
   cardPanel  = new JPanel(cardLayout);

   // The login panel needs a reference to this window (to call onLoginSuccess)
   loginPanel = new LoginPanel(this);
   cardPanel.add(loginPanel, CARD_LOGIN);

   // The main view is just a placeholder; it gets built after a successful login
   mainView = new JPanel(new BorderLayout());
   cardPanel.add(mainView, CARD_MAIN);

   setContentPane(cardPanel);
   cardLayout.show(cardPanel, CARD_LOGIN); // show login first
   setVisible(true);
}

// ── METHOD: onLoginSuccess() ─────────────────────────────────────────
// Called by LoginPanel after credentials are verified.
// Receives the logged-in User object, builds the main app view,
// switches the card to MAIN, and shows the dashboard.
public void onLoginSuccess(User user) {
   this.loggedInUser = user;
   buildMainView();                          // construct sidebar + content panels
   cardLayout.show(cardPanel, CARD_MAIN);    // switch from login to main view
   showView("dashboard");                    // default to dashboard on login
}

// ── METHOD: buildMainView() ──────────────────────────────────────────
// Constructs the post-login UI: a sidebar on the left and a content
// area on the right using another CardLayout to switch between screens.
private void buildMainView() {
   mainView.removeAll(); // clear any previous content (for re-login support)

   JPanel sidebar     = buildSidebar(); // blue left navigation panel
   JPanel contentArea = new JPanel(new CardLayout());
   contentArea.setBackground(new Color(240, 246, 255));

   // Create all three main screen panels
   dashboardPanel = new DashboardPanel();
   inventoryPanel = new InventoryPanel(loggedInUser);
   profilePanel   = new ProfilePanel(loggedInUser);

   // Add each panel to the content CardLayout with a string key
   contentArea.add(dashboardPanel, "dashboard");
   contentArea.add(inventoryPanel, "inventory");
   contentArea.add(profilePanel,   "profile");
   contentArea.setName("content");

   mainView.add(sidebar,     BorderLayout.WEST);   // sidebar takes left side
   mainView.add(contentArea, BorderLayout.CENTER); // content takes rest of space
   mainView.revalidate();
   mainView.repaint();
}

// ── METHOD: buildSidebar() ──────────────────────────────────────────
// Creates the blue left sidebar with the app logo, user info chip,
// and navigation buttons (Dashboard, Inventory, Profile, Sign Out).
private JPanel buildSidebar() {
   // Custom-painted panel with vertical blue gradient
   JPanel sidebar = new JPanel() {
       @Override protected void paintComponent(Graphics g) {
           Graphics2D g2 = (Graphics2D) g.create();
           GradientPaint gp = new GradientPaint(0, 0, new Color(15, 70, 160),
                                                0, getHeight(), new Color(25, 100, 200));
           g2.setPaint(gp);
           g2.fillRect(0, 0, getWidth(), getHeight());
           g2.dispose();
       }
   };
   sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS)); // stack children vertically
   sidebar.setPreferredSize(new Dimension(200, 0)); // 200px wide; height fills parent

   // ── App brand section ─────────────────────────────────────────
   JPanel brand = new JPanel();
   brand.setOpaque(false);
   brand.setLayout(new BoxLayout(brand, BoxLayout.Y_AXIS));
   brand.setBorder(BorderFactory.createEmptyBorder(24, 20, 16, 20));
   brand.setAlignmentX(Component.CENTER_ALIGNMENT);

   JLabel logo = new JLabel("IMS");
   logo.setFont(new Font("Segoe UI", Font.BOLD, 28));
   logo.setForeground(Color.WHITE);
   logo.setAlignmentX(Component.CENTER_ALIGNMENT);

   JLabel logoSub = new JLabel("Inventory System");
   logoSub.setFont(new Font("Segoe UI", Font.PLAIN, 11));
   logoSub.setForeground(new Color(180, 210, 255));
   logoSub.setAlignmentX(Component.CENTER_ALIGNMENT);

   brand.add(logo);
   brand.add(Box.createVerticalStrut(2));
   brand.add(logoSub);
   sidebar.add(brand);

   // ── User info chip (shows logged-in user's name and role) ──────
   JPanel userChip = new JPanel();
   userChip.setOpaque(false);
   userChip.setLayout(new BoxLayout(userChip, BoxLayout.Y_AXIS));
   userChip.setBorder(BorderFactory.createCompoundBorder(
       BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(255, 255, 255, 40)), // faint dividers
       BorderFactory.createEmptyBorder(10, 20, 10, 20)
   ));
   userChip.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
   userChip.setAlignmentX(Component.LEFT_ALIGNMENT);

   JLabel uName = new JLabel(loggedInUser.getFullName());
   uName.setFont(new Font("Segoe UI", Font.BOLD, 12));
   uName.setForeground(Color.WHITE);

   JLabel uRole = new JLabel(loggedInUser.getRole());
   uRole.setFont(new Font("Segoe UI", Font.PLAIN, 11));
   uRole.setForeground(new Color(180, 210, 255));

   userChip.add(uName);
   userChip.add(uRole);
   sidebar.add(userChip);
   sidebar.add(Box.createVerticalStrut(12));

   // ── Navigation buttons ────────────────────────────────────────
   navDashboard = new NavButton("  Dashboard");
   navInventory = new NavButton("  Inventory");
   navProfile   = new NavButton("  My Profile");
   navLogout    = new NavButton("  Sign Out");

   navDashboard.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));
   navInventory.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));
   navProfile.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));
   navLogout.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));

   // Lambda ActionListeners: each button calls showView() or logout()
   navDashboard.addActionListener(e -> showView("dashboard"));
   navInventory.addActionListener(e -> showView("inventory"));
   navProfile.addActionListener(e -> showView("profile"));
   navLogout.addActionListener(e -> logout());

   sidebar.add(navDashboard);
   sidebar.add(navInventory);
   sidebar.add(navProfile);
   sidebar.add(Box.createVerticalGlue()); // pushes Sign Out to the bottom
   sidebar.add(navLogout);
   sidebar.add(Box.createVerticalStrut(16));

   return sidebar;
}

// ── METHOD: showView() ────────────────────────────────────────────────
// Switches the content area to the specified screen and updates
// which nav button appears highlighted/active.
//
// POLYMORPHISM: refresh() is called on whichever panel is being shown.
// Each panel has its own version of refresh() that does something different,
// but the call here is always the same: panel.refresh().
// Java decides at runtime which version to actually execute.
private void showView(String view) {
   // Mark the correct nav button as active (highlighted)
   navDashboard.setActive(view.equals("dashboard"));
   navInventory.setActive(view.equals("inventory"));
   navProfile.setActive(view.equals("profile"));

   // Get the content area (second component added to mainView)
   JPanel contentArea = (JPanel) mainView.getComponent(1);
   ((CardLayout) contentArea.getLayout()).show(contentArea, view); // flip to the right card

   // Call refresh() on the correct panel — same method name, different behavior
   // This is POLYMORPHISM: the method called depends on the actual type of the object
   switch (view) {
       case "dashboard": dashboardPanel.refresh(); break; // updates stats + item list
       case "inventory": inventoryPanel.refresh(); break; // reloads the table
       case "profile":   profilePanel.refresh();   break; // reloads user info
   }
}

// ── METHOD: logout() ────────────────────────────────────────────────
// Confirms, clears the logged-in user, resets login panel fields,
// and switches the card back to the login screen.
private void logout() {
   int choice = JOptionPane.showConfirmDialog(this,
       "Are you sure you want to sign out?",
       "Sign Out", JOptionPane.YES_NO_OPTION);
   if (choice == JOptionPane.YES_OPTION) {
       loggedInUser = null;
       loginPanel.refresh(); // clear username/password fields
       cardLayout.show(cardPanel, CARD_LOGIN); // go back to login screen
   }
}

// ============================================================
//  EVENT LISTENER 3: WindowListener
//  This interface has 7 methods for various window state events.
//  We implement them all because the interface requires it, but
//  only windowClosing() needs actual behavior for our app.
// ============================================================

// ── windowClosing() ─────────────────────────────────────────────────
// Called when the user clicks the red X button (or Alt+F4).
// Because we set DO_NOTHING_ON_CLOSE, the window won't close
// automatically — this method takes control instead.
// It shows a confirmation dialog and only exits if the user says Yes.
@Override
public void windowClosing(WindowEvent e) {
   int choice = JOptionPane.showConfirmDialog(this,
       "Are you sure you want to exit the application?",
       "Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
   if (choice == JOptionPane.YES_OPTION) {
       System.out.println("[WindowListener] Application closed by user.");
       dispose();       // release all window resources
       System.exit(0);  // terminate the JVM
   }
}

// Called when the window is first made visible on screen
@Override
public void windowOpened(WindowEvent e) {
   System.out.println("[WindowListener] Window opened.");
}

// Called when the user clicks the minimize (taskbar) button
@Override
public void windowIconified(WindowEvent e) {
   System.out.println("[WindowListener] Window minimized.");
}

// Called when the user restores a minimized window
@Override
public void windowDeiconified(WindowEvent e) {
   System.out.println("[WindowListener] Window restored.");
}

// These three are required by the WindowListener interface but need no action here
@Override public void windowActivated(WindowEvent e)   {}
@Override public void windowDeactivated(WindowEvent e) {}
@Override public void windowClosed(WindowEvent e)      {}

// ============================================================
//  ENTRY POINT: main()
//
//  This is where the Java program starts.
//  SwingUtilities.invokeLater() ensures the GUI is created on
//  the Event Dispatch Thread (EDT) — the dedicated thread that
//  handles all Swing UI updates. Creating Swing components
//  outside the EDT is unsafe and can cause visual glitches.
// ============================================================
public static void main(String[] args) {
   SwingUtilities.invokeLater(() -> {
       try {
           // Match the operating system's native look and feel
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       } catch (Exception ignored) {}
       new InventorySystem(); // create and show the main window
   });
}
}
