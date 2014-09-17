package hivolts;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    MainScreen mainScreen = new MainScreen();
    GameScreen gameScreen = new GameScreen();
    Screen screen;

    public Panel() {
        screen = mainScreen;
        add(screen);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        screen.paint(g);
    }

    public void setGame() {
        screen = gameScreen;
        repaint();
    }

    public void setMain() {
        screen = mainScreen;
        repaint();
    }
}
