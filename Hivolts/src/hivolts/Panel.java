package hivolts;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.plaf.metal.MetalBorders;

public class Panel extends JPanel {

    private ArrayList<ArrayList<Entity>> entities = new ArrayList<ArrayList<Entity>>(12);

    public ArrayList<ArrayList<Entity>> getEntities() {
        return entities;
    }

    private enum Screen {
        MAIN, GAME, GAMEOVER;
    }

    Screen screen;

    private enum Turn {
        NONE, PLAYER, ENEMY;
    }

    Turn turn = Turn.PLAYER;

    static Player player;

    int total_mhos = 12; //init
    int updated_mhos = 0;

    public Panel() {
        setPreferredSize(new Dimension(Main.width, Main.height));
        screen = Screen.GAME;

        for (int x = 0; x < 12; x++) {
            entities.add(new ArrayList<Entity>(12));
            for (int y = 0; y < 12; y++) {
                if (y == 0 || x == 0 || y == 11 || x == 11) {
                    entities.get(x).add(new Fence(x, y));
                } else {
                    entities.get(x).add(new Entity(x, y));
                }
            }
        }

        Random rand = new Random();
        int x, y;
        for (int i = 0; i < 20; i++) {
            do {
                x = rand.nextInt(10) + 1;
                y = rand.nextInt(10) + 1;
            } while (isOccupied(x, y));
            entities.get(x).set(y, new Fence(x, y));
        }

        for (int i = 0; i < 12; i++) {
            do {
                x = rand.nextInt(10) + 1;
                y = rand.nextInt(10) + 1;
            } while (isOccupied(x, y));
            entities.get(x).set(y, new Mho(x, y));
        }

        do {
            x = rand.nextInt(10) + 1;
            y = rand.nextInt(10) + 1;
        } while (isOccupied(x, y));
        entities.get(x).set(y, new Player(this, x, y));
        player = (Player) entities.get(x).get(y);


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        switch (screen) {
            case MAIN:
                break;
            case GAME:
                updateGame(g);
                break;
            case GAMEOVER:
                break;
        }
    }

    private void updateGame(Graphics g) {
        for (int x = 0; x < Main.board_dim_x; x++) {
            for (int y = 0; y < Main.board_dim_y; y++) {

                if (entities.get(x).get(y) instanceof Enemy && turn == Turn.ENEMY) {
                    entities.get(x).get(y).update();
                    //System.out.println("        enemy");
                    updated_mhos++;
                    if (updated_mhos == total_mhos) {
                        updated_mhos = 0;
                        turn = Turn.PLAYER;
                    }
                }
                if (turn == Turn.PLAYER) {
                    player.update();
                    if (player.getAction()) {
                        System.out.println("player action");
                        player.setAction(false);
                        turn = turn.ENEMY;
                    }
                }

                if (entities.get(x).get(y) instanceof LivingEntity) {
                    if (((LivingEntity) entities.get(x).get(y)).isDead()) {
                       entities.get(x).set(y, new Entity(x, y));
                    }
                }
                entities.get(x).get(y).draw(g);
                if (player.getAction()) {
                    System.out.println("player action");
                    player.setAction(false);
                    turn = turn.ENEMY;
                }

            }
        }
    }

    public boolean isMurderer(int x, int y) {
        return (isFence(x, y) || isMho(x, y));
    }

    public boolean isOccupied(int x, int y) {
        return (isFence(x, y) || isPlayer(x, y));
    }

    public boolean isFence(int x, int y) {
        return (entities.get(x).get(y) instanceof Fence);
    }

    private boolean isMho(int x, int y) {
        return (entities.get(x).get(y) instanceof Mho);
    }

    private boolean isPlayer(int x, int y) {
        return (entities.get(x).get(y) instanceof Player);
    }

    public static int getPlayerX() {
        return player.getX();
    }

    public static int getPlayerY() {
        return player.getY();
    }

}
