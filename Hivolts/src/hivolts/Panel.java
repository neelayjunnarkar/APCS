package hivolts;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

/**
 * @author Neelay Junnarkar
 *         The class Panel extends JPanel and is where all updating and drawing takes place
 */
public class Panel extends JPanel {

    private ArrayList<ArrayList<Cell>> cells = new ArrayList<>(12);

    public ArrayList<ArrayList<Cell>> getCells() {
        return cells;
    }

    public void setGameOver() {
        screen = screen.GAMEOVER;

    }

    /**
     * An enum which says which says which state the program is in--Main Menu, Game, or GameOver
     */
    private enum Screen {
        MAIN, WIN, GAME, GAMEOVER
    }

    /**
     * An instance of Screen
     */
    private Screen screen;

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
    int init_mhos = 12;
    int total_mhos = init_mhos;

    /**
     * Tracks how many Mhos have been updated in an update cycle
     */
    int updated_mhos = 0;

   /*The specific colours fo each use. backgrounds/fonts*/
    Color backgroundColor = new Color(255, 255, 255, 255);
    Color win_backgroundColor = new Color(236, 236, 236, 105);
    Color gameover_backgroundColor = new Color(19, 19, 19, 60);
    Color gameover_fontColor = new Color(0, 0, 0, 255);
    Color win_fontColor = new Color(0, 0, 0, 255);
    Color main_color = new Color(0, 0, 0, 255);

    /*Text for main, gameover, and win screens */
    String win_msg = "You Win :) :) :) :) :) :)";
    String replay_msg = "Hit 'R' to Replay";
    String gameover_msg = "Game Over :( :( :( :( :( :(";
    String restart_msg = "Hit 'R' to Restart";
    String main_msg = "HIVOLTS";
    String author_msg = "by Neelay Junnarkar";
    String start_msg = "Hit \"Enter\" to begin playing!";

    /*Font styles for each specific use on main, gameover, and win screens*/
    Font gameover_font = new Font("Consolas", Font.BOLD, 30);
    Font restart_font = new Font("Consolas", Font.PLAIN, 18);
    Font win_font = new Font("Consolas", Font.BOLD, 30);
    Font main_font = new Font("Consolas", Font.BOLD, 50);
    Font author_font = new Font("Consolas", Font.PLAIN, 20);
    Font start_font = new Font("Consolas", Font.PLAIN, 22);
    Font replay_font = new Font("Consolas", Font.PLAIN, 18);

    /**
     * The constructor for Panel
     * Spawns all entities
     */
    public Panel() {
        setPreferredSize(new Dimension(Main.width, Main.height));
        screen = Screen.MAIN;

        getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_R, 0), "R");
        getActionMap().put("R", new Restart());
        getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
        getActionMap().put("Enter", new Enter());

        /*Init board to a ring of fences around a box of emptyness*/
        for (int x = 0; x < 12; x++) {
            cells.add(new ArrayList<Cell>(12));
            for (int y = 0; y < 12; y++) {
                if (y == 0 || x == 0 || y == 11 || x == 11) {
                    cells.get(x).add(new Cell(this, x, y, new Fence(x, y)));
                } else {
                    cells.get(x).add(new Cell(this, x, y));
                }
            }
        }

        spawnEntities();
    }

    /**
     * Takes a board and wipes it except for ring of fences
     * @param board The 2d array of Cells that is the board to be cleaned
     */
    private void cleanBoard(ArrayList<ArrayList<Cell>> board) {

        for (int x = 0; x < 12; x++) {
            for (int y = 0; y < 12; y++) {
                if (y == 0 || x == 0 || y == 11 || x == 11) {
                    cells.get(x).get(y).setEntity(new Fence(x, y));
                } else {
                    board.get(x).get(y).setEntity(new Entity(x, y));
                }
            }
        }
    }

    /**
     * Spawns all entites on a clean board
     */
    private void spawnEntities() {

        Random rand = new Random();
        int x, y;

        /*Spawns 20 fences randomly*/
        spawnFences(rand);

        /*Spawns 12 mhos randomly*/
        spawnMhos(rand);

        /*Spawns the player randomly*/
        spawnPlayer(rand);

    }

    /**
     * Spawns central fences on board
     * @param rand Random number generator
     */
    private void spawnFences(Random rand) {
        int x, y;
        for (int i = 0; i < 20; i++) {
            do {
                x = rand.nextInt(10) + 1;
                y = rand.nextInt(10) + 1;
            } while (isOccupied(x, y));
            cells.get(x).get(y).setEntity(new Fence(x, y));
        }
    }

    /**
     * Spawns Mhos on board
     * @param rand Random number generator
     */
    private void spawnMhos(Random rand) {
        int x, y;
        for (int i = 0; i < init_mhos; i++) {
            do {
                x = rand.nextInt(10) + 1;
                y = rand.nextInt(10) + 1;
            } while (isOccupied(x, y));
            cells.get(x).get(y).setEntity(new Mho(this, x, y));
        }
    }

    /**
     * Spawns player on board
     * @param rand Random number generator
     */
    private void spawnPlayer(Random rand) {
        int x, y;
        do {
            x = rand.nextInt(10) + 1;
            y = rand.nextInt(10) + 1;
        } while (isOccupied(x, y));
        cells.get(x).get(y).setEntity(new Player(this, x, y));
        player = (Player) cells.get(x).get(y).getEntity();
        System.out.println("player init pos: " + player.getEntityX() + " " + player.getEntityY());
    }

    /**
     * Updates and paints all entities when in game, and paints other screens when necessary
     *
     * @param g Graphics
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        switch (screen) {
            case MAIN:
                displayMain(g);
                break;
            case WIN:
                displayWin(g);
                break;
            case GAME:
                updateGame(g);
                break;
            case GAMEOVER:
                displayGameOver(g);
                break;
        }
    }

    /**
     * The paint method for screen MAIN
     * @param g Graphics
     */
    private void displayMain(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (ArrayList<Cell> a : cells) {
            for (Cell c : a) {
                if (c.getEntity() instanceof Fence) { c.draw(g2d); }
            }
        }

        System.out.println("helllo");
        g2d.setColor(main_color);
        g2d.setFont(main_font);
        g2d.drawString(main_msg, (float) (-g2d.getFontMetrics(main_font).getStringBounds(main_msg, g2d).getWidth() / 2.0 + Main.width / 2.0), (float) 100.0);
        g2d.setFont(author_font);
        g2d.drawString(author_msg, (float) (Main.width/2.0), (float) (100 + 2 * g2d.getFontMetrics(author_font).getStringBounds(author_msg, g2d).getHeight()));
        g2d.setFont(start_font);
        g2d.drawString(start_msg, (float) (-g2d.getFontMetrics(start_font).getStringBounds(start_msg, g2d).getWidth() / 2.0 + Main.width / 2.0), (float) (100 + 4 * g2d.getFontMetrics(start_font).getStringBounds(start_msg, g2d).getHeight()));
    }

    /**
     * The paint method for Screen WIN
     * @param g Graphics
     */
    private void displayWin(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (ArrayList<Cell> a : cells) {
            for (Cell c : a) {
                c.draw(g2d);
            }
        }
        g2d.setColor(win_backgroundColor);
        g2d.fillRect(0, 0, Main.width, Main.height);
        g2d.setColor(win_fontColor);
        g2d.setFont(win_font);
        g2d.drawString(win_msg, (float) (-g2d.getFontMetrics(win_font).getStringBounds(win_msg, g2d).getWidth() / 2.0 + Main.width / 2.0), (float) 100.0);
        g2d.setFont(replay_font);
        g2d.drawString(replay_msg, (float) (-g2d.getFontMetrics(replay_font).getStringBounds(replay_msg, g2d).getWidth() / 2.0 + Main.width / 2.0), (float) (100 + 2 * g2d.getFontMetrics(replay_font).getStringBounds(replay_msg, g2d).getHeight()));
    }

    /**
     * The paint method for Screen GAMEOVER
     * @param g Graphics
     */
    private void displayGameOver(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (ArrayList<Cell> a : cells) {
            for (Cell c : a) {
                c.draw(g2d);
            }
        }
        g2d.setColor(gameover_backgroundColor);
        g2d.fillRect(0, 0, Main.width, Main.height);
        g2d.setColor(gameover_fontColor);
        g2d.setFont(gameover_font);
        g2d.drawString(gameover_msg, (float) (-g2d.getFontMetrics(gameover_font).getStringBounds(gameover_msg, g2d).getWidth() / 2.0 + Main.width / 2.0), (float) 100.0);
        g2d.setFont(restart_font);
        g2d.drawString(restart_msg, (float) (-g2d.getFontMetrics(restart_font).getStringBounds(restart_msg, g2d).getWidth() / 2.0 + Main.width / 2.0), (float) (100 + 2 * g2d.getFontMetrics(restart_font).getStringBounds(restart_msg, g2d).getHeight()));
    }

    /**
     * The paint method for the Game screen. The game part of the program.
     * @param g Graphics
     */
    private void updateGame(Graphics g) {
        total_mhos = countMhos();

        if (player.isDead()) {
            screen = Screen.GAMEOVER;
            return;
        }
        if (total_mhos == 0) {
            screen = Screen.WIN;
            paintComponent(g);
            return;
        }
        if (turn == Turn.PLAYER) {
            int playerx = getPlayerX();
            int playery = getPlayerY();
            cells.get(playerx).get(playery).update();
            if (((Player) cells.get(playerx).get(playery).getEntity()).getAction()) {
                turn = Turn.ENEMY;
                ((Player) cells.get(playerx).get(playery).getEntity()).setAction(false);
            }
        } else if (turn == Turn.ENEMY) {
            int[] mhoxs = getMhoXs();
            int[] mhoys = getMhoYs();
            //System.out.println(total_mhos+" "+mhoxs.length+" "+mhoys.length);

            for (int i = 0; i < total_mhos; i++) {
                //  System.out.println("i: "+i+" total_mhos: "+total_mhos);
                cells.get(mhoxs[i]).get(mhoys[i]).update();
            }
            turn = Turn.PLAYER;
        }

        drawAllEntities(g);

        if (total_mhos == 0) {
            screen = Screen.WIN;
            paintComponent(g);
            return;
        }
    }

    /**
     * Draws all entities
     * @param g Graphics
     */
    private void drawAllEntities(Graphics g) {
        for (ArrayList<Cell> a : cells) {
            for (Cell c : a) {
                c.draw(g);
            }
        }
    }

    /**
     * @return Returns the x coords of all mhos currently in existence on the board in an array
     */
    private int[] getMhoXs() {
        int[] mhoxs = new int[total_mhos];
        int i = 0;
        for (int x = 0; x < Main.board_dim_x; x++) {
            for (int y = 0; y < Main.board_dim_y; y++) {
                if (cells.get(x).get(y).getEntity() instanceof Mho) {
                    mhoxs[i] = x;
                    i++;
                }
            }
        }
        return mhoxs;
    }

    /**
     *
     * @return Returns the y coords of all mhos currently in existence on the board in an array
     */
    private int[] getMhoYs() {
        int[] mhoys = new int[total_mhos];
        int i = 0;
        for (int x = 0; x < Main.board_dim_x; x++) {
            for (int y = 0; y < Main.board_dim_y; y++) {
                if (cells.get(x).get(y).getEntity() instanceof Mho) {
                    mhoys[i] = y;
                    i++;
                }
            }
        }
        return mhoys;
    }

    /**
     * @return Returns the number of mhos currently on the board
     */
    private int countMhos() {
        int temp = 0;
        for (ArrayList<Cell> a : cells) {
            for (Cell c : a) {
                if (c.getEntity() instanceof Mho) temp++;
            }
        }
        //System.out.println("n mhos: "+temp);
        return temp;
    }

    /**
     * Returns whether location on board is an entity which kills the player
     *
     * @param x x-coord
     * @param y y-coord
     * @return returns whether entity kills
     */
    public boolean isMurderer(int x, int y) {
        return (isFence(x, y) || isMho(x, y));
    }

    /**
     * Returns whether location on board is occupied by a fence or a player
     *
     * @param x x-coord
     * @param y y-coord
     * @return returns whether space is fence or player
     */
    public boolean isOccupied(int x, int y) {
        return (isFence(x, y) || isPlayer(x, y) || isMho(x, y));
    }

    /**
     * Returns whether location on board is a fence
     *
     * @param x x-coord
     * @param y y-coord
     * @return returns whether is fence
     */
    public boolean isFence(int x, int y) {
        return (cells.get(x).get(y).getEntity() instanceof Fence);
    }

    /**
     * Returns whether location on board is a Mho
     *
     * @param x x-coord
     * @param y y-coord
     * @return returns whether is mho
     */
    public boolean isMho(int x, int y) {
        return (cells.get(x).get(y).getEntity() instanceof Mho);
    }

    /**
     * Returns whether location on board is the player
     *
     * @param x x-coord
     * @param y y-coord
     * @return whether is player
     */
    private boolean isPlayer(int x, int y) {
        return (cells.get(x).get(y).getEntity() instanceof Player);
    }

    /**
     * Returns the player x-coordinate
     *
     * @return returns player x-coord
     */
    public int getPlayerX() {
        int x = 0;
        boolean breaker = false;
        for (ArrayList<Cell> a : cells) {
            for (Cell c : a) {
                if (c.getEntity() instanceof Player) {
                    x = c.getX();
                    breaker = true;
                    break;
                }
            }
            if (breaker) break;
        }
        return x;
    }

    /**
     * Returns the player y-coordinate
     *
     * @return returns player y-coord
     */
    public int getPlayerY() {
        int y = 0;
        boolean breaker = false;
        for (ArrayList<Cell> a : cells) {
            for (Cell c : a) {
                if (c.getEntity() instanceof Player) {
                    y = c.getY();
                    breaker = true;
                    break;
                }
            }
            if (breaker) break;
        }
        return y;
    }

    /**
     * The KeyBinding Action for Restart
     */
    private class Restart extends AbstractAction {

        /**
         * Restarts the game. Performs all actions necessary to do so
         * @param e ActionEvent
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (screen == Screen.GAMEOVER || screen == Screen.GAME || screen == Screen.WIN) {
                System.out.println("restart");
                cleanBoard(cells);
                spawnEntities();
                ((Player) cells.get(getPlayerX()).get(getPlayerY()).getEntity()).setAction(false);
                ((Player) cells.get(getPlayerX()).get(getPlayerY()).getEntity()).setDead(false);
                updated_mhos = 0;
                total_mhos = 12;
                screen = screen.GAME;
            }
        }
    }

    /**
     * The KeyBinding Action for Enter (begin playing the game)
     */
    private class Enter extends AbstractAction {

        /**
         * Begins playing the game
         * @param e ActionEvent
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (screen == Screen.MAIN) {
                screen = screen.GAME;
            }
        }
    }


}
