package hivolts;

import java.awt.*;

/**
 * @author Neelay Junnarkar
 * The Mho class is the enemy mobile class and extends LivingEntity and implements Enemy
 */
public class Mho extends LivingEntity {

    /**
     * The color of the Mhos
     */
    Color mhoColor = new Color(222, 97, 1);//144, 40, 13);

    /**
     * An instance of panel so the mhos have knowlege of the board
     */
    Panel panel;

    enum Direction {
        NONE, UP, DOWN, LEFT, RIGHT,UP_LEFT, DOWN_LEFT, UP_RIGHT, DOWN_RIGHT
    }
    private Direction dir = Direction.NONE;
    public Direction getDir() { return dir; }
    public void setDir(Direction dir) { this.dir = dir; }

    /**
     * The Mho constructor
     * @param panel An instance of Panel
     * @param x x-coord
     * @param y y-coord
     */
    public Mho(Panel panel, int x, int y) {
    	super(x, y);
        this.panel = panel;
    }

    /**
     * The update method for Mhos
     * Checks if Mho is dead or not
     * Moves Mho based on layout of board and location of player
     */
    public void update(int x, int y) {

    }

    /**
     * Draws the Mho on the correct location on the window depending on the x and y coordinates of the Mho
     * @param g Graphics
     */
    public void draw(Graphics g, int x, int y) {
        super.paintComponent(g);
        if (!dead) {
	        Graphics2D g2d = (Graphics2D) g.create();
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        g2d.setColor(mhoColor);
	        g2d.fillOval((x * Main.cell_width + Main.cell_sep * x), (y * Main.cell_height + Main.cell_sep * y), Main.cell_width, Main.cell_height);
        }
   }
}
