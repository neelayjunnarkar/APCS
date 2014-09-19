package hivolts;

import java.awt.*;

/**
 * Created by Neelay on 9/18/2014.
 */
public class Mho extends LivingEntity {

    Color mhoColor = new Color(144, 40, 13);
    public Mho(int x, int y) {
        super(x, y);
    }

    public void update() {

    }

    public void draw(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(mhoColor);
        g2d.fillOval((x*Main.cell_width + Main.cell_sep*x), (y*Main.cell_height + Main.cell_sep*y), Main.cell_width, Main.cell_height);
    }
}
