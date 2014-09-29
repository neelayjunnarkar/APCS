package hivolts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * @author Neelay Junnarkar
 * Class Player is the player, the user, and extends LivingEntity
 */
public class Player extends LivingEntity {

    /**
     * The color of the player
     */
    Color playerColor = new Color(5, 98, 150);

    /**
     * An instance of Panel so that the player class can have knowledge of the panel
     */
    Panel panel;

    /**
     * Whether the user has made an action yet
     */
    private boolean action = false;

    /**
     * Returns action
     * @return
     */
    public boolean getAction() {
        return action;
    }

    /**
     * Sets action
     * @param action
     */
    public void setAction(boolean action) {
        this.action = action;
    }

    /**
     * An enum to facilitate keyBindings by containing data about keycodes and strings
     */
    enum Key {

        Q(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), "Q"),
        W(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "W"),
        E(KeyStroke.getKeyStroke(KeyEvent.VK_E, 0), "E"),
        A(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "A"),
        S(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "S"),
        D(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "D"),
        Z(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 0), "Z"),
        X(KeyStroke.getKeyStroke(KeyEvent.VK_X, 0), "X"),
        C(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "C"),
        J(KeyStroke.getKeyStroke(KeyEvent.VK_J, 0), "J");

        /**
         * Keystroke
         */
        private KeyStroke keyStroke;

        /**
         * returns keystroke
         * @return
         */
        public KeyStroke getKeyStroke() {
            return keyStroke;
        }

        /**
         *String
         */
        private String str;

        /**
         * Returns string
         * @return
         */
        public String getString() {
            return str;
        }

        /**
         * Constructor of enum Key
         * @param keyStroke
         * @param str
         */
        Key(KeyStroke keyStroke, String str) {
            this.keyStroke = keyStroke;
            this.str = str;
        }

    }

    /**
     * Constructor of Player class
     * Binds actions to keys
     * @param panel
     * @param x
     * @param y
     */
    public Player(Panel panel, int x, int y) {
        super(x, y);
        requestFocusInWindow();
        this.panel = panel;

        for (Key key : Key.values()) {
            panel.getInputMap().put(key.getKeyStroke(), key.getString());
            panel.getActionMap().put(key.getString(), new KeyAction(key));
        }
    }

    /**
     * Update method of player
     */
    @Override
    public void update(int x, int y) {
		if (panel.isMurderer(x, y)) {
			dead = true;
		}
    }

    /**
     * Draws player at location on map depending on x and y coordinates
     * @param g
     */
    @Override
    public void draw(Graphics g, int x, int y) {
        super.paintComponent(g);
        if (!dead) {
	        Graphics2D g2d = (Graphics2D) g.create();
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        g2d.setColor(playerColor);
	        g2d.fillOval((x * Main.cell_width + Main.cell_sep * x), (y * Main.cell_height + Main.cell_sep * y), Main.cell_width, Main.cell_height);
        }
    }


    /**
     * Controls actions as a result of keyinput by user
     */
    private class KeyAction extends AbstractAction {

        /**
         * Key
         */
        private Key key;

        /**
         * Constructor for KeyAction
         * @param key
         */
        public KeyAction(Key key) {
            this.key = key;
        }

        /**
         * Where action as a result of keyinput is resolved
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            action = true;
            switch (key) {
                case Q:
                    //System.out.println("Q");
                    y--;
                    x--;
                    if (panel.isMurderer(x, y)) {
                        dead = true;
                    }
                    break;
                case W:
                    y--;
                    if (panel.isMurderer(x, y)) {
                        dead = true;
                    }
                    break;
                case E:
                   // System.out.println("E");
                    y--;
                    x++;
                    if (panel.isMurderer(x, y)) {
                        dead = true;
                    }
                    break;
                case A:
                    x--;
                    if (panel.isMurderer(x, y)) {
                        dead = true;
                    }
                    break;
                case S:
                   // System.out.println("s");
                    if (panel.isMurderer(x, y)) {
                        dead = true;
                    }
                    break;
                case D:
                    x++;
                    if (panel.isMurderer(x, y)) {
                        dead = true;
                    }
                   // System.out.println("D");
                    break;
                case Z:
                    y++;
                    x--;
                    if (panel.isMurderer(x, y)) {
                        dead = true;
                    }
                    break;
                case X:
                    y++;
                    if (panel.isMurderer(x, y)) {
                        dead = true;
                    }
                    break;
                case C:
                    y++;
                    x++;
                    if (panel.isMurderer(x, y)) {
                        dead = true;
                    }
                    break;
                case J:
                   // System.out.println("J");
                    Random rand = new Random();
                    int newx, newy;
                    do {
                        newx = rand.nextInt(10) + 1;
                        newy = rand.nextInt(10) + 1;
                    } while (panel.isFence(newx, newy));
                    x = newx;
                    y = newy;
                    if (panel.isMurderer(x, y)) {
                        dead = true;
                    }
                    break;
                default:
                    System.out.println("weirdness just happened (somehow through keybindings a \"default\" key was pressed. Player)");
                    break;
            }

        }

    }

}
