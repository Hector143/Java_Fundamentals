package RPG;

import javax.swing.*;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import java.util.List;

/**
 * RPGGame.java - "Knight's Last Stand"
 * A 2D top-down RPG demonstrating OOP concepts and Event Listeners.
 *
 * OOP Concepts:
 *  - Abstraction   : abstract class Entity with abstract update() and draw()
 *  - Inheritance   : Player and Enemy both extend Entity
 *  - Encapsulation : private fields with getters/setters in Entity, Player, Enemy
 *  - Polymorphism  : overridden update() and draw() called at runtime
 *
 * Event Listeners:
 *  - ActionListener : Start, Restart, Quit buttons
 *  - KeyListener    : WASD movement, SPACE to swing sword
 *  - WindowListener : confirm-on-close dialog, pause on minimize
 */
public class RPGGame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameFrame());
    }

    // =========================================================
    // ABSTRACTION: abstract base class for all game entities
    // =========================================================
    static abstract class Entity {
        // ENCAPSULATION: private fields
        private float x, y;
        private int maxHp, currentHp;
        private boolean alive;

        public Entity(float x, float y, int maxHp) {
            this.x = x;
            this.y = y;
            this.maxHp = maxHp;
            this.currentHp = maxHp;
            this.alive = true;
        }

        // Getters and Setters (Encapsulation)
        public float getX() { return x; }
        public float getY() { return y; }
        public void setX(float x) { this.x = x; }
        public void setY(float y) { this.y = y; }
        public int getMaxHp() { return maxHp; }
        public int getCurrentHp() { return currentHp; }
        public boolean isAlive() { return alive; }

        public void takeDamage(int amount) {
            currentHp -= amount;
            if (currentHp <= 0) {
                currentHp = 0;
                alive = false;
            }
        }

        public void heal(int amount) {
            currentHp = Math.min(currentHp + amount, maxHp);
        }

        public Rectangle getBounds(int size) {
            return new Rectangle((int) x - size / 2, (int) y - size / 2, size, size);
        }

        // ABSTRACTION: subclasses MUST implement these
        public abstract void update(GameState state);
        public abstract void draw(Graphics2D g2d);
    }

    // =========================================================
    // INHERITANCE + POLYMORPHISM: Player extends Entity
    // =========================================================
    static class Player extends Entity {
        private static final int SIZE = 32;
        private static final float SPEED = 3.0f;
        private static final long SWING_COOLDOWN_MS = 2000;

        // ENCAPSULATION: private fields
        private boolean movingUp, movingDown, movingLeft, movingRight;
        private boolean swinging;
        private long lastSwingTime;
        private float swingAngle;       // current arc angle of sword
        private float swingProgress;    // 0..1
        private int facingAngleDeg;     // direction player faces (degrees)
        private int score;

        public Player(float x, float y) {
            super(x, y, 3);
            facingAngleDeg = 0;
            score = 0;
        }

        // Getters/Setters (Encapsulation)
        public boolean isSwinging() { return swinging; }
        public float getSwingAngle() { return swingAngle; }
        public int getFacingAngle() { return facingAngleDeg; }
        public int getScore() { return score; }
        public void addScore(int s) { score += s; }
        public boolean canSwing() {
            return System.currentTimeMillis() - lastSwingTime >= SWING_COOLDOWN_MS;
        }
        public long getCooldownRemaining() {
            long elapsed = System.currentTimeMillis() - lastSwingTime;
            return Math.max(0, SWING_COOLDOWN_MS - elapsed);
        }

        public void setMovingUp(boolean v) { movingUp = v; }
        public void setMovingDown(boolean v) { movingDown = v; }
        public void setMovingLeft(boolean v) { movingLeft = v; }
        public void setMovingRight(boolean v) { movingRight = v; }

        public void startSwing() {
            if (canSwing()) {
                swinging = true;
                swingProgress = 0f;
                lastSwingTime = System.currentTimeMillis();
            }
        }

        // Returns sword hitbox during swing (null if not swinging or past arc)
        public Rectangle getSwordHitbox() {
            if (!swinging) return null;
            double rad = Math.toRadians(facingAngleDeg);
            float reach = 52;
            float sx = getX() + (float)(Math.cos(rad) * reach);
            float sy = getY() + (float)(Math.sin(rad) * reach);
            return new Rectangle((int) sx - 20, (int) sy - 20, 40, 40);
        }

        @Override
        public void update(GameState state) {
            float nx = getX();
            float ny = getY();
            if (movingUp)    { ny -= SPEED; facingAngleDeg = -90; }
            if (movingDown)  { ny += SPEED; facingAngleDeg = 90;  }
            if (movingLeft)  { nx -= SPEED; facingAngleDeg = 180; }
            if (movingRight) { nx += SPEED; facingAngleDeg = 0;   }

            // clamp to panel
            nx = Math.max(SIZE, Math.min(state.getWidth() - SIZE, nx));
            ny = Math.max(SIZE, Math.min(state.getHeight() - SIZE, ny));
            setX(nx);
            setY(ny);

            // update swing animation
            if (swinging) {
                swingProgress += 0.08f;
                swingAngle = -70 + swingProgress * 140f; // arc from -70 to +70
                if (swingProgress >= 1.0f) {
                    swinging = false;
                    swingProgress = 0;
                }
            }
        }

        @Override
        public void draw(Graphics2D g2d) {
            int x = (int) getX();
            int y = (int) getY();

            // Body
            g2d.setColor(new Color(70, 130, 180));
            g2d.fillRect(x - 12, y - 14, 24, 28);

            // Head
            g2d.setColor(new Color(255, 220, 180));
            g2d.fillOval(x - 9, y - 26, 18, 18);

            // Helmet
            g2d.setColor(new Color(100, 100, 120));
            g2d.fillRect(x - 10, y - 28, 20, 12);
            g2d.fillRect(x - 4, y - 22, 8, 6); // visor gap

            // Legs
            g2d.setColor(new Color(50, 80, 130));
            g2d.fillRect(x - 11, y + 14, 9, 12);
            g2d.fillRect(x + 2, y + 14, 9, 12);

            // Draw sword
            drawSword(g2d, x, y);
        }

        private void drawSword(Graphics2D g2d, int cx, int cy) {
            Graphics2D sg = (Graphics2D) g2d.create();
            sg.translate(cx, cy);
            sg.rotate(Math.toRadians(facingAngleDeg));

            if (swinging) {
                float arc = -70 + swingProgress * 140f;
                sg.rotate(Math.toRadians(arc));
            }

            // Sword handle
            sg.setColor(new Color(139, 90, 43));
            sg.fillRect(12, -3, 8, 6);

            // Sword blade
            sg.setColor(new Color(200, 200, 220));
            sg.fillRect(20, -2, 30, 4);

            // Blade tip
            int[] tipX = {50, 60, 50};
            int[] tipY = {-2, 0, 2};
            sg.fillPolygon(tipX, tipY, 3);

            // Guard
            sg.setColor(new Color(180, 150, 50));
            sg.fillRect(18, -7, 4, 14);

            sg.dispose();
        }
    }

    // =========================================================
    // INHERITANCE + POLYMORPHISM: Enemy extends Entity
    // =========================================================
    static class Enemy extends Entity {
        private static final int SIZE = 28;

        // ENCAPSULATION
        private float speed;
        private int type;       // 0=slime, 1=skeleton
        private float wobble;
        private int wobbleDir;
        private boolean hitFlash;
        private int hitFlashTimer;

        public Enemy(float x, float y, int type) {
            super(x, y, type == 1 ? 3 : 2);
            this.type = type;
            this.speed = type == 1 ? 1.2f : 0.85f;
            this.wobble = 0;
            this.wobbleDir = 1;
        }

        public int getType() { return type; }

        public void triggerHitFlash() {
            hitFlash = true;
            hitFlashTimer = 8;
        }

        @Override
        public void update(GameState state) {
            Player player = state.getPlayer();
            float dx = player.getX() - getX();
            float dy = player.getY() - getY();
            float dist = (float) Math.sqrt(dx * dx + dy * dy);
            if (dist > 1) {
                setX(getX() + (dx / dist) * speed);
                setY(getY() + (dy / dist) * speed);
            }

            wobble += 0.15f * wobbleDir;
            if (Math.abs(wobble) > 4) wobbleDir *= -1;

            if (hitFlash) {
                hitFlashTimer--;
                if (hitFlashTimer <= 0) hitFlash = false;
            }
        }

        @Override
        public void draw(Graphics2D g2d) {
            int x = (int) getX();
            int y = (int) getY();

            if (hitFlash) {
                g2d.setColor(Color.WHITE);
                g2d.fillOval(x - SIZE / 2 - 2, y - SIZE / 2 - 2, SIZE + 4, SIZE + 4);
            }

            if (type == 0) drawSlime(g2d, x, y);
            else drawSkeleton(g2d, x, y);

            // HP bar
            int barW = 28;
            int barH = 4;
            int bx = x - barW / 2;
            int by = y - SIZE / 2 - 10;
            g2d.setColor(Color.DARK_GRAY);
            g2d.fillRect(bx, by, barW, barH);
            float ratio = (float) getCurrentHp() / getMaxHp();
            g2d.setColor(ratio > 0.5f ? Color.GREEN : Color.RED);
            g2d.fillRect(bx, by, (int)(barW * ratio), barH);
        }

        private void drawSlime(Graphics2D g2d, int x, int y) {
            int w = (int) wobble;
            g2d.setColor(new Color(80, 200, 80));
            g2d.fillOval(x - 14 + w, y - 10, 28 - w * 2, 22);
            g2d.setColor(new Color(50, 150, 50));
            g2d.fillOval(x - 14 + w, y + 6, 28 - w * 2, 8);
            // Eyes
            g2d.setColor(Color.WHITE);
            g2d.fillOval(x - 7, y - 6, 6, 6);
            g2d.fillOval(x + 1, y - 6, 6, 6);
            g2d.setColor(Color.BLACK);
            g2d.fillOval(x - 5, y - 4, 3, 3);
            g2d.fillOval(x + 2, y - 4, 3, 3);
        }

        private void drawSkeleton(Graphics2D g2d, int x, int y) {
            int w = (int) wobble;
            // Body
            g2d.setColor(new Color(220, 220, 200));
            g2d.fillRect(x - 8 + w, y - 8, 16, 20);
            // Head
            g2d.fillOval(x - 8, y - 20, 16, 16);
            // Eye sockets
            g2d.setColor(Color.BLACK);
            g2d.fillOval(x - 6, y - 17, 5, 5);
            g2d.fillOval(x + 1, y - 17, 5, 5);
            // Legs
            g2d.setColor(new Color(200, 200, 180));
            g2d.fillRect(x - 8 + w, y + 12, 6, 10);
            g2d.fillRect(x + 2 - w, y + 12, 6, 10);
        }
    }

    // =========================================================
    // GameState: shared data between entities
    // =========================================================
    static class GameState {
        private int width, height;
        private Player player;

        public GameState(int w, int h, Player p) {
            this.width = w;
            this.height = h;
            this.player = p;
        }

        public int getWidth() { return width; }
        public int getHeight() { return height; }
        public Player getPlayer() { return player; }
    }

    // =========================================================
    // GamePanel: main rendering + game loop + KeyListener
    // =========================================================
    static class GamePanel extends JPanel implements KeyListener {
        private static final int W = 800, H = 600;
        private static final int TARGET_FPS = 60;

        private enum State { MENU, PLAYING, PAUSED, GAMEOVER }
        private State gameState = State.MENU;

        private Player player;
        private List<Enemy> enemies;
        private GameState sharedState;
        private Timer gameLoop;
        private Random rng = new Random();

        private int wave = 1;
        private int enemySpawnCounter = 0;
        private int enemySpawnInterval = 120; // frames between spawns
        private long invincibleUntil = 0;

        // Particle effects
        private List<Particle> particles = new ArrayList<>();

        // UI Buttons (ActionListener targets)
        private JButton btnStart, btnRestart, btnQuit, btnResume;

        // Screen shake
        private int shakeFrames = 0;
        private int shakeX = 0, shakeY = 0;

        public GamePanel() {
            setPreferredSize(new Dimension(W, H));
            setBackground(Color.BLACK);
            setFocusable(true);
            addKeyListener(this);
            initButtons();
            showMenu();
        }

        private void initButtons() {
            setLayout(null);

            btnStart = createButton("START GAME", W / 2 - 100, 320, 200, 45);
            btnStart.addActionListener(e -> startGame()); // ActionListener

            btnRestart = createButton("PLAY AGAIN", W / 2 - 100, 350, 200, 45);
            btnRestart.addActionListener(e -> startGame()); // ActionListener

            btnResume = createButton("RESUME", W / 2 - 100, 280, 200, 45);
            btnResume.addActionListener(e -> resumeGame()); // ActionListener

            btnQuit = createButton("QUIT", W / 2 - 100, 420, 200, 45);
            btnQuit.addActionListener(e -> System.exit(0)); // ActionListener

            add(btnStart);
            add(btnRestart);
            add(btnResume);
            add(btnQuit);
        }

        private JButton createButton(String text, int x, int y, int w, int h) {
            JButton btn = new JButton(text);
            btn.setBounds(x, y, w, h);
            btn.setFont(new Font("Arial", Font.BOLD, 16));
            btn.setBackground(new Color(60, 60, 80));
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setBorderPainted(false);
            btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            btn.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) { btn.setBackground(new Color(100, 100, 140)); }
                public void mouseExited(MouseEvent e)  { btn.setBackground(new Color(60, 60, 80)); }
            });
            return btn;
        }

        private void showMenu() {
            gameState = State.MENU;
            btnStart.setVisible(true);
            btnRestart.setVisible(false);
            btnResume.setVisible(false);
            btnQuit.setVisible(true);
            btnQuit.setBounds(W / 2 - 100, 380, 200, 45);
        }

        private void showGameOver() {
            gameState = State.GAMEOVER;
            btnStart.setVisible(false);
            btnRestart.setVisible(true);
            btnResume.setVisible(false);
            btnQuit.setVisible(true);
            btnQuit.setBounds(W / 2 - 100, 420, 200, 45);
            if (gameLoop != null) gameLoop.stop();
        }

        private void showPaused() {
            gameState = State.PAUSED;
            btnStart.setVisible(false);
            btnRestart.setVisible(false);
            btnResume.setVisible(true);
            btnQuit.setVisible(true);
            btnQuit.setBounds(W / 2 - 100, 360, 200, 45);
            if (gameLoop != null) gameLoop.stop();
        }

        private void resumeGame() {
            gameState = State.PLAYING;
            btnResume.setVisible(false);
            btnQuit.setVisible(false);
            startGameLoop();
            requestFocusInWindow();
        }

        public void pauseGame() {
            if (gameState == State.PLAYING) showPaused();
        }

        private void startGame() {
            player = new Player(W / 2f, H / 2f);
            enemies = new ArrayList<>();
            sharedState = new GameState(W, H, player);
            particles.clear();
            wave = 1;
            enemySpawnCounter = 0;
            enemySpawnInterval = 120;
            invincibleUntil = 0;

            gameState = State.PLAYING;
            btnStart.setVisible(false);
            btnRestart.setVisible(false);
            btnResume.setVisible(false);
            btnQuit.setVisible(false);
            startGameLoop();
            requestFocusInWindow();
        }

        private void startGameLoop() {
            if (gameLoop != null) gameLoop.stop();
            gameLoop = new Timer(1000 / TARGET_FPS, e -> {
                update();
                repaint();
            });
            gameLoop.start();
        }

        private void update() {
            if (gameState != State.PLAYING) return;

            player.update(sharedState);

            // Spawn enemies
            enemySpawnCounter++;
            if (enemySpawnCounter >= enemySpawnInterval) {
                spawnEnemy();
                enemySpawnCounter = 0;
                int maxInterval = Math.max(40, enemySpawnInterval - wave * 5);
                enemySpawnInterval = maxInterval;
            }

            // Update enemies + check collisions
            boolean playerDamaged = false;
            Iterator<Enemy> iter = enemies.iterator();
            while (iter.hasNext()) {
                Enemy e = iter.next();
                e.update(sharedState);

                // Sword hit
                if (player.isSwinging()) {
                    Rectangle sword = player.getSwordHitbox();
                    if (sword != null && sword.intersects(e.getBounds(26))) {
                        e.takeDamage(1);
                        e.triggerHitFlash();
                        spawnParticles((int) e.getX(), (int) e.getY(), Color.RED);
                    }
                }

                // Enemy touches player
                if (e.getBounds(26).intersects(player.getBounds(24))) {
                    long now = System.currentTimeMillis();
                    if (now > invincibleUntil) {
                        player.takeDamage(1);
                        invincibleUntil = now + 1200;
                        playerDamaged = true;
                        shakeFrames = 15;
                        spawnParticles((int) player.getX(), (int) player.getY(), new Color(255, 80, 80));
                    }
                }

                if (!e.isAlive()) {
                    player.addScore(e.getType() == 1 ? 20 : 10);
                    spawnParticles((int) e.getX(), (int) e.getY(), Color.YELLOW);
                    iter.remove();
                }
            }

            // Check wave progress
            if (enemies.isEmpty() && enemySpawnCounter > enemySpawnInterval - 5) {
                wave++;
                enemySpawnInterval = Math.max(40, 120 - wave * 8);
            }

            // Update particles
            particles.removeIf(p -> !p.isAlive());
            for (Particle p : particles) p.update();

            // Screen shake
            if (shakeFrames > 0) {
                shakeX = rng.nextInt(8) - 4;
                shakeY = rng.nextInt(8) - 4;
                shakeFrames--;
            } else {
                shakeX = 0;
                shakeY = 0;
            }

            if (!player.isAlive()) showGameOver();
        }

        private void spawnEnemy() {
            float x, y;
            int side = rng.nextInt(4);
            switch (side) {
                case 0: x = rng.nextFloat() * W; y = -20; break;
                case 1: x = rng.nextFloat() * W; y = H + 20; break;
                case 2: x = -20; y = rng.nextFloat() * H; break;
                default: x = W + 20; y = rng.nextFloat() * H; break;
            }
            int type = (wave > 2 && rng.nextBoolean()) ? 1 : 0;
            enemies.add(new Enemy(x, y, type));
        }

        private void spawnParticles(int x, int y, Color c) {
            for (int i = 0; i < 8; i++) {
                particles.add(new Particle(x, y, c));
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2d.translate(shakeX, shakeY);

            switch (gameState) {
                case MENU:     drawMenu(g2d); break;
                case PLAYING:  drawGame(g2d); break;
                case PAUSED:   drawGame(g2d); drawPause(g2d); break;
                case GAMEOVER: drawGame(g2d); drawGameOver(g2d); break;
            }
            g2d.dispose();
        }

        private void drawGame(Graphics2D g2d) {
            // Ground tiles
            drawGround(g2d);

            // Entities — POLYMORPHISM: draw() called on Entity references
            for (Enemy e : enemies) e.draw(g2d);

            // Player (invincibility flash)
            long now = System.currentTimeMillis();
            if (now < invincibleUntil && (now / 100) % 2 == 0) {
                // skip draw for blink effect
            } else {
                player.draw(g2d);
            }

            // Particles
            for (Particle p : particles) p.draw(g2d);

            drawHUD(g2d);
        }

        private void drawGround(Graphics2D g2d) {
            int tileSize = 64;
            for (int tx = 0; tx < W / tileSize + 1; tx++) {
                for (int ty = 0; ty < H / tileSize + 1; ty++) {
                    int shade = ((tx + ty) % 2 == 0) ? 45 : 55;
                    g2d.setColor(new Color(shade, shade + 10, shade));
                    g2d.fillRect(tx * tileSize, ty * tileSize, tileSize, tileSize);
                }
            }
            // Grid lines
            g2d.setColor(new Color(0, 0, 0, 30));
            for (int tx = 0; tx <= W / tileSize + 1; tx++)
                g2d.drawLine(tx * tileSize, 0, tx * tileSize, H);
            for (int ty = 0; ty <= H / tileSize + 1; ty++)
                g2d.drawLine(0, ty * tileSize, W, ty * tileSize);
        }

        private void drawHUD(Graphics2D g2d) {
            // Hearts
            for (int i = 0; i < player.getMaxHp(); i++) {
                int hx = 20 + i * 38;
                int hy = 14;
                if (i < player.getCurrentHp()) drawHeart(g2d, hx, hy, Color.RED);
                else drawHeart(g2d, hx, hy, new Color(80, 80, 80));
            }

            // Score
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Arial", Font.BOLD, 18));
            g2d.drawString("Score: " + player.getScore(), W - 160, 34);

            // Wave
            g2d.setFont(new Font("Arial", Font.BOLD, 16));
            g2d.drawString("Wave: " + wave, W / 2 - 30, 34);

            // Sword cooldown bar
            long cooldown = player.getCooldownRemaining();
            if (cooldown > 0) {
                int barW = 160;
                int barH = 14;
                int bx = W / 2 - barW / 2;
                int by = H - 36;
                g2d.setColor(new Color(0, 0, 0, 150));
                g2d.fillRoundRect(bx - 2, by - 2, barW + 4, barH + 4, 6, 6);
                g2d.setColor(new Color(255, 165, 0));
                int filledW = (int)(barW * (1.0 - (double)cooldown / 2000));
                g2d.fillRoundRect(bx, by, filledW, barH, 4, 4);
                g2d.setColor(Color.WHITE);
                g2d.setFont(new Font("Arial", Font.PLAIN, 11));
                g2d.drawString("SWORD READY", bx + 35, by + 11);
            } else {
                g2d.setColor(new Color(0, 0, 0, 150));
                int bx = W / 2 - 80;
                int by = H - 36;
                g2d.fillRoundRect(bx - 2, by - 2, 164, 18, 6, 6);
                g2d.setColor(new Color(0, 220, 0));
                g2d.fillRoundRect(bx, by, 160, 14, 4, 4);
                g2d.setColor(Color.BLACK);
                g2d.setFont(new Font("Arial", Font.BOLD, 11));
                g2d.drawString("SWING READY [SPACE]", bx + 22, by + 11);
            }

            // Controls hint
            g2d.setColor(new Color(255, 255, 255, 120));
            g2d.setFont(new Font("Arial", Font.PLAIN, 11));
            g2d.drawString("WASD: Move  |  SPACE: Swing  |  ESC: Pause", 16, H - 8);
        }

        private void drawHeart(Graphics2D g2d, int x, int y, Color c) {
            g2d.setColor(c);
            // Simple heart using two circles + triangle
            g2d.fillOval(x, y, 14, 14);
            g2d.fillOval(x + 10, y, 14, 14);
            int[] hx = {x, x + 24, x + 12};
            int[] hy = {y + 10, y + 10, y + 26};
            g2d.fillPolygon(hx, hy, 3);
        }

        private void drawMenu(Graphics2D g2d) {
            // Background
            g2d.setColor(new Color(20, 20, 35));
            g2d.fillRect(0, 0, W, H);

            // Stars
            g2d.setColor(new Color(255, 255, 255, 100));
            Random r = new Random(42);
            for (int i = 0; i < 80; i++) {
                int sx = r.nextInt(W);
                int sy = r.nextInt(H);
                int ss = r.nextInt(3) + 1;
                g2d.fillOval(sx, sy, ss, ss);
            }

            // Title
            g2d.setFont(new Font("Arial", Font.BOLD, 54));
            String title = "Knight's Last Stand";
            FontMetrics fm = g2d.getFontMetrics();
            int tw = fm.stringWidth(title);
            g2d.setColor(new Color(255, 200, 50));
            g2d.drawString(title, W / 2 - tw / 2, 160);

            g2d.setFont(new Font("Arial", Font.ITALIC, 20));
            g2d.setColor(new Color(200, 200, 255));
            String sub = "Survive the endless horde!";
            g2d.drawString(sub, W / 2 - g2d.getFontMetrics().stringWidth(sub) / 2, 210);

            // Controls
            g2d.setFont(new Font("Arial", Font.PLAIN, 15));
            g2d.setColor(new Color(180, 180, 180));
            String[] controls = {"WASD - Move", "SPACE - Swing Sword (2s cooldown)", "ESC - Pause"};
            for (int i = 0; i < controls.length; i++) {
                int cw = g2d.getFontMetrics().stringWidth(controls[i]);
                g2d.drawString(controls[i], W / 2 - cw / 2, 260 + i * 22);
            }
        }

        private void drawPause(Graphics2D g2d) {
            g2d.setColor(new Color(0, 0, 0, 160));
            g2d.fillRect(0, 0, W, H);
            g2d.setFont(new Font("Arial", Font.BOLD, 48));
            g2d.setColor(Color.WHITE);
            String txt = "PAUSED";
            g2d.drawString(txt, W / 2 - g2d.getFontMetrics().stringWidth(txt) / 2, 220);
        }

        private void drawGameOver(Graphics2D g2d) {
            g2d.setColor(new Color(0, 0, 0, 180));
            g2d.fillRect(0, 0, W, H);

            g2d.setFont(new Font("Arial", Font.BOLD, 56));
            g2d.setColor(new Color(220, 50, 50));
            String txt = "GAME OVER";
            g2d.drawString(txt, W / 2 - g2d.getFontMetrics().stringWidth(txt) / 2, 200);

            g2d.setFont(new Font("Arial", Font.BOLD, 24));
            g2d.setColor(Color.WHITE);
            String score = "Final Score: " + player.getScore();
            g2d.drawString(score, W / 2 - g2d.getFontMetrics().stringWidth(score) / 2, 270);

            String wv = "Reached Wave: " + wave;
            g2d.setFont(new Font("Arial", Font.PLAIN, 18));
            g2d.setColor(new Color(200, 200, 200));
            g2d.drawString(wv, W / 2 - g2d.getFontMetrics().stringWidth(wv) / 2, 306);
        }

        // =================== KeyListener ===================
        @Override
        public void keyPressed(KeyEvent e) {
            if (gameState == State.PLAYING) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W: case KeyEvent.VK_UP:    player.setMovingUp(true); break;
                    case KeyEvent.VK_S: case KeyEvent.VK_DOWN:  player.setMovingDown(true); break;
                    case KeyEvent.VK_A: case KeyEvent.VK_LEFT:  player.setMovingLeft(true); break;
                    case KeyEvent.VK_D: case KeyEvent.VK_RIGHT: player.setMovingRight(true); break;
                    case KeyEvent.VK_SPACE: player.startSwing(); break;
                    case KeyEvent.VK_ESCAPE: pauseGame(); break;
                }
            } else if (gameState == State.PAUSED) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) resumeGame();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (player == null) return;
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W: case KeyEvent.VK_UP:    player.setMovingUp(false); break;
                case KeyEvent.VK_S: case KeyEvent.VK_DOWN:  player.setMovingDown(false); break;
                case KeyEvent.VK_A: case KeyEvent.VK_LEFT:  player.setMovingLeft(false); break;
                case KeyEvent.VK_D: case KeyEvent.VK_RIGHT: player.setMovingRight(false); break;
            }
        }

        @Override public void keyTyped(KeyEvent e) {}
    }

    // =========================================================
    // Particle effect helper
    // =========================================================
    static class Particle {
        private float x, y, vx, vy;
        private int life, maxLife;
        private Color color;
        private Random rng = new Random();

        public Particle(float x, float y, Color c) {
            this.x = x;
            this.y = y;
            this.vx = (rng.nextFloat() - 0.5f) * 6;
            this.vy = (rng.nextFloat() - 0.5f) * 6;
            this.maxLife = 25 + rng.nextInt(15);
            this.life = maxLife;
            this.color = c;
        }

        public boolean isAlive() { return life > 0; }

        public void update() {
            x += vx;
            y += vy;
            vx *= 0.9f;
            vy *= 0.9f;
            life--;
        }

        public void draw(Graphics2D g2d) {
            float alpha = (float) life / maxLife;
            int size = (int)(alpha * 8) + 2;
            g2d.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), (int)(alpha * 200)));
            g2d.fillOval((int) x - size / 2, (int) y - size / 2, size, size);
        }
    }

    // =========================================================
    // GameFrame: JFrame + WindowListener
    // =========================================================
    static class GameFrame extends JFrame implements WindowListener {
        private GamePanel gamePanel;

        public GameFrame() {
            setTitle("Knight's Last Stand");
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // handled by WindowListener
            setResizable(false);

            gamePanel = new GamePanel();
            add(gamePanel);
            pack();

            addWindowListener(this); // WindowListener

            setLocationRelativeTo(null);
            setVisible(true);
            gamePanel.requestFocusInWindow();
        }

        // =================== WindowListener ===================

        /** Confirm before closing */
        @Override
        public void windowClosing(WindowEvent e) {
            int result = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to quit?",
                    "Quit Game",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (result == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }

        /** Pause game when window is minimized */
        @Override
        public void windowIconified(WindowEvent e) {
            gamePanel.pauseGame();
        }

        /** Resume focus when window is restored */
        @Override
        public void windowDeiconified(WindowEvent e) {
            gamePanel.requestFocusInWindow();
        }

        @Override public void windowOpened(WindowEvent e) {}
        @Override public void windowClosed(WindowEvent e) {}
        @Override public void windowActivated(WindowEvent e) { gamePanel.requestFocusInWindow(); }
        @Override public void windowDeactivated(WindowEvent e) {}
    }
}
