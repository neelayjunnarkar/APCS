package hivolts;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

/**
 * @author Neelay Junnarkar
 * The class Panel extends JPanel and is where all updating and drawing takes place
 */
public class Panel extends JPanel {

    private ArrayList<ArrayList<Cell>> cells = new ArrayList<>(12);
    private ArrayList<ArrayList<Cell>> prev_cells = new ArrayList<>(12);
    
    public ArrayList<ArrayList<Cell>> getCells() { return cells; }
    public ArrayList<ArrayList<Cell>> getPrevCells() { return prev_cells; }

    /**
     * An enum which says which says which state the program is in--Main Menu, Game, or GameOver
     */
    private enum Screen {
        MAIN, GAME, GAMEOVER
    }

    /**
     * An instance of Screen
     */
    Screen screen;

    /**
     * An enum which says whose turn it is--Player's, Enemy's, or None (if not in-game)
     */
    private enum Turn {
        NONE, PLAYER, ENEMY
    }

    /**
     * Instance of Turn
     */
    Turn turn = Turn.PLAYER;

    /**
     * Instance of player allows tracking of player individually
     */
    Player player;

    /**
     * The initial amount of Mhos spawned
     */
    int total_mhos = 12;

    /**
     * Tracks how many Mhos have been updated in an update cycle
     */
    int updated_mhos = 0;

    /**
     * The constructor for Panel
     * Spawns all entities
     */
    public Panel() {
        setPreferredSize(new Dimension(Main.width, Main.height));
        screen = Screen.GAME;

        getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_R, 0), "R");
        getActionMap().put("R", new Restart());

        for (int x = 0; x < 12; x++) {
        	cells.add(new ArrayList<Cell>(12));
            for (int y = 0; y < 12; y++) {
                if (y == 0 || x == 0 || y == 11 || x == 11) {
                	cells.get(x).add(new Cell(x, y, new Fence()));
                } else {
                    cells.get(x).add(new Cell(x, y));
                }
            }
        }
        
        spawnEntities();
    }

    private void spawnEntities() {
    	
    	
        Random rand = new Random();
        int x, y;

        /*Spawns 20 fences randomly*/
        for (int i = 0; i < 20; i++) {
            do {
                x = rand.nextInt(10) + 1;
                y = rand.nextInt(10) + 1;
            } while (isOccupied(x, y));
            cells.get(x).get(y).setEntity(new Fence());
        }

        /*Spawns 12 mhos randomly*/
        for (int i = 0; i < 12; i++) {
            do {
                x = rand.nextInt(10) + 1;
                y = rand.nextInt(10) + 1;
            } while (isOccupied(x, y));
            cells.get(x).get(y).setEntity(new Mho(this));
        }

        /*Spawns the player randomly*/
        do {
            x = rand.nextInt(10) + 1;
            y = rand.nextInt(10) + 1;
        } while (isOccupied(x, y));
        cells.get(x).get(y).setEntity(new Player(this));
       // player = (Player) cells.get(x).get(y).getEntity();

        prev_cells = cells;
    }

    /**
     * Updates and paints all entities when in game, and paints other screens when necessary
     * @param g Graphics
     */
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

    /**
     * When in-game, this is called and updates the game (all entities, turn...)
     * @param g Graphics
     */
    private void updateGame(Graphics g) {
        if (screen != Screen.GAME) {
            turn = Turn.NONE;
        }

        for (int x = 0; x < Main.board_dim_x; x++) {
            for (int y = 0; y < Main.board_dim_y; y++) {
            	/*Updating Mhos and fences*/
//                if (prev_entities.get(x).get(y) instanceof Mho && turn == Turn.ENEMY && !entities.get(x).get(y).isUpdated()) {
//                    entities.get(x).get(y).setUpdated(true);
//                    entities.get(x).get(y).update(x, y);
//                    updated_mhos++;
//                    if (updated_mhos == total_mhos) {
//                        updated_mhos = 0;
//                        turn = Turn.PLAYER;
//                    }
//                }
//                /*Updating Player*/
//                if (turn == Turn.PLAYER && !player.isUpdated()) {
//                    player.setUpdated(true);
//                    player.update(x, y);
//                    if (player.getAction()) {
//                        player.setAction(false);
//                        turn = Turn.ENEMY;
//                    }
//                    if (player.dead) {
//                        System.out.println("player dead");
//                    }
//                }
//
//                /*Death Updating*/
//                if (prev_entities.get(x).get(y) instanceof LivingEntity) {
//                    if (((LivingEntity) entities.get(x).get(y)).isDead()) {
//                        if (entities.get(x).get(y) instanceof Mho) {
//                            total_mhos--;
//                        }
//                        entities.get(x).set(y, new Entity(x, y));
//                    }
//                }
                cells.get(x).get(y).draw(g);
//                prev_entities = entities;
//            }
//        }
//
//        for (int x = 0; x < Main.board_dim_x; x++) {
//            for (int y = 0; y < Main.board_dim_y; y++) {
//                entities.get(x).get(y).setUpdated(false);
            }
        }
    }

    /**
     * Returns whether location on board is an entity which kills the player
     * @param x x-coord
     * @param y y-coord
     * @return returns whether entity kills
     */
    public boolean isMurderer(int x, int y) {
        return (isFence(x, y) || isMho(x, y));
    }

    /**
     * Returns whether location on board is occupied by a fence or a player
     * @param x x-coord
     * @param y y-coord
     * @return returns whether space is fence or player
     */
    public boolean isOccupied(int x, int y) {
        return (isFence(x, y) || isPlayer(x, y) || isMho(x, y));
    }

    /**
     * Returns whether location on board is a fence
     * @param x x-coord
     * @param y y-coord
     * @return returns whether is fence
     */
    public boolean isFence(int x, int y) {
        return (cells.get(x).get(y).getEntity() instanceof Fence);
    }

    /**
     * Returns whether location on board is a Mho
     * @param x x-coord
     * @param y y-coord
     * @return returns whether is mho
     */
    public boolean isMho(int x, int y) {
        return (cells.get(x).get(y).getEntity() instanceof Mho);
    }

    /**
     * Returns whether location on board is the player
     * @param x x-coord
     * @param y y-coord
     * @return whether is player
     */
    private boolean isPlayer(int x, int y) {
        return (cells.get(x).get(y).getEntity() instanceof Player);
    }

    /**
     * Returns the player x-coordinate
     * @return returns player x-coord
     */
//    public int getPlayerX() {
//        return player.getX();
//    }

    /**
     * Returns the player y-coordinate
     * @return returns player y-coord
     */
//    public int getPlayerY() {
//        return player.getY();
//    }

    private class Restart extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("restart");
            for (int x = 1; x < 11; x++) {
                for (int y = 1; y < 11; y++) {
                	cells.get(x).get(y).setEntity(new Entity());
                }
            }
            spawnEntities();
            //player.dead = false;
            updated_mhos = 0;
            total_mhos = 12;
        }
    }

}
