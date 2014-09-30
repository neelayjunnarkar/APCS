package hivolts;

/**
 * @author Neelay Junnarkar
 * Living Entities are entities which have a life boolean value
 */
public class LivingEntity extends Entity {

    /**
     * Whether the LivingEntity is alive or not
     */
    boolean dead = false;

    /**
     * Returns whether is dead or not
     * @return
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * Sets the death value
     * @param dead
     */
    public void setDead(boolean dead) {
    	this.dead = dead;
    }

    /**
     * Constructor for LivingEntity
     * @param x
     * @param y
     */
    public LivingEntity(int x, int y) {
    	super(x, y);
    }
}