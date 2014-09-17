package hivolts;

import java.awt.*;

/**
 * Created by Neelay on 9/13/2014.
 */
public class GameScreen extends Screen {

    @Override
    public void paintComponent(Graphics g) {
        System.out.println("GameScreen paint");
        //super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor( new Color(165, 28, 15));
        g2d.fillRect(0, 0, 100, 100);
    }
}
