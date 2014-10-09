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
        WIN, GAME, GAMEOVER
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

    Color backgroundColor = new Color(232, 139, 55, 15);
    Color win_backgroundColor = new Color(236, 236, 236, 105);
    Color gameover_backgroundColor = new Color(19, 19, 19, 60);
    Color gameover_fontColor = new Color(0, 0, 0, 255);

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
                    cells.get(x).add(new Cell(this, x, y, new Fence(x, y)));
                } else {
                    cells.get(x).add(new Cell(this, x, y));
                }
            }
        }

        spawnEntities();
    }

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

    private void spawnEntities() {

        Random rand = new Random();
        int x, y;

        /*Spawns 20 fences randomly*/
        for (int i = 0; i < 20; i++) {
            do {
                x = rand.nextInt(10) + 1;
                y = rand.nextInt(10) + 1;
            } while (isOccupied(x, y));
            cells.get(x).get(y).setEntity(new Fence(x, y));
        }

        /*Spawns 12 mhos randomly*/
        for (int i = 0; i < init_mhos; i++) {
            do {
                x = rand.nextInt(10) + 1;
                y = rand.nextInt(10) + 1;
            } while (isOccupied(x, y));
            cells.get(x).get(y).setEntity(new Mho(this, x, y));
        }

        /*Spawns the player randomly*/
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
        g2d.setColor(gameover_fontColor);
        String gameover_msg = "You Win :) :) :) :) :) :)";
        String restart_msg = "Hit 'R' to Restart";
        Font gameover_font = new Font("Consolas", Font.BOLD, 20);
        Font restart_font = new Font("Consolas", Font.PLAIN, 12);
        g2d.setFont(gameover_font);
        g2d.drawString(gameover_msg, (float)(-g2d.getFontMetrics(gameover_font).getStringBounds(gameover_msg, g2d).getWidth()/2.0+Main.width/2.0), (float) 100.0);
        g2d.setFont(restart_font);
        g2d.drawString(restart_msg, (float)(-g2d.getFontMetrics(restart_font).getStringBounds(restart_msg, g2d).getWidth()/2.0+Main.width/2.0), (float)(100+2*g2d.getFontMetrics(restart_font).getStringBounds(restart_msg, g2d).getHeight()));
	}

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
        String gameover_msg = "Game Over :( :( :( :( :( :(";
        String restart_msg = "Hit 'R' to Restart";
        Font gameover_font = new Font("Consolas", Font.BOLD, 20);
        Font restart_font = new Font("Consolas", Font.PLAIN, 12);
        g2d.setFont(gameover_font);
        g2d.drawString(gameover_msg, (float)(-g2d.getFontMetrics(gameover_font).getStringBounds(gameover_msg, g2d).getWidth()/2.0+Main.width/2.0), (float) 100.0);
        g2d.setFont(restart_font);
        g2d.drawString(restart_msg, (float)(-g2d.getFontMetrics(restart_font).getStringBounds(restart_msg, g2d).getWidth()/2.0+Main.width/2.0), (float)(100+2*g2d.getFontMetrics(restart_font).getStringBounds(restart_msg, g2d).getHeight()));
    }

    /**
     * When in-game, this is called and updates the game (all entities, turn...)
     *
     * @param g Graphics
     */
    private void updateGame(Graphics g) {
      	
    }

    private int countMhos() {
		int temp = 0;
		for (ArrayList<Cell> a : cells) {
			for (Cell c : a) {
				if (c.getEntity() instanceof Mho) temp++;
			}
		}
		System.out.println("n mhos: "+temp);
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

    public boolean isEmpty(int x, int y) {
    	return (cells.get(x).get(y).getEntity()) instanceof Entity;
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

    private class Restart extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("restart");
            cleanBoard(cells);
            spawnEntities();
            ((Player)cells.get(getPlayerX()).get(getPlayerY()).getEntity()).setDead(false);
            updated_mhos = 0;
            total_mhos = 12;
            screen = screen.GAME;
            update(getGraphics());
        }
    }


}
