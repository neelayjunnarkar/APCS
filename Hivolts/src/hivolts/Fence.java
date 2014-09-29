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
     */
    public Fence() {
    	
    }


    /**
     * The update method for the fence
     */
    @Override
    public void update(int x, int y) {

    }

    /**
     * The draw method for Fences
     * @param g Graphics g
     * @param x x-coord on board
     * @param y y-coord on board
     */
    @Override
    public void draw(Graphics g, int x, int y) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(fenceColor);
        g2d.fillRect(x * Main.cell_width + Main.cell_sep * x, y * Main.cell_height + Main.cell_sep * y, Main.cell_width, Main.cell_height);
    }


}
