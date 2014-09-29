package hivolts;

import java.awt.*;
import java.util.Random;

/**
 * @author Neelay Junnarkar
 * The Fence class is the sessile Entity class, and kills Players
 */
public class Fence extends Entity {

    /**
     * The color of the Fence
     */
    Color fenceColor = new Color(201, 14, 0);//165, 28, 15);

    /**
     * The fence constructor
     * @param x
     * @param y
     */
    public Fence(int x, int y) {
        super(x, y);
    }

    /**
     * Draws the fence to the correct location on the window based on the x an y coordinates
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(fenceColor);
        g2d.fillRect(x * Main.cell_width + Main.cell_sep * x, y * Main.cell_height + Main.cell_sep * y, Main.cell_width, Main.cell_height);
    }

    /**
     * The update method for the fence
     */
    @Override
    public void update(int x, int y) {

    }

    /**
     * The draw method for Fences
     * @param g
     */
    @Override
    public void draw(Graphics g, int x, int y) {
        paintComponent(g);
    }


}
