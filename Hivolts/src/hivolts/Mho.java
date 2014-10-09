package hivolts;

import java.awt.*;

/**
 * @author Neelay Junnarkar
 *         The Mho class is the enemy mobile class and extends LivingEntity and implements Enemy
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


    /**
     * The Mho constructor
     *
     * @param panel An instance of Panel
     * @param x     x-coord
     * @param y     y-coord
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
        entityx = x;
        entityy = y;
        int prevx = x, prevy = y;
        System.out.println("updated mho");
        if (x == panel.getPlayerX() && y != panel.getPlayerY()) {
            entityy = (y < panel.getPlayerY()) ? y+1 : y-1;
            System.out.println("this: " + x + ", " + y + "  player: " + panel.getPlayerX() + ", " + panel.getPlayerY());
        } else if (y == panel.getPlayerY() && x != panel.getPlayerX()) {
            entityx = (x < panel.getPlayerX()) ? x+1 : x-1;
        } else if (Math.abs(x-panel.getPlayerX()) == Math.abs(y-panel.getPlayerY())) {
            entityx = (x < panel.getPlayerX()) ? x+1 : x-1;
            entityy = (y < panel.getPlayerY()) ? y+1 : y-1;
        }

        if (entityx == panel.getPlayerX() && entityy == panel.getPlayerY()) panel.setGameOver();
    }

    /**
     * Draws the Mho on the correct location on the window depending on the entityx and y coordinates of the Mho
     *
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
