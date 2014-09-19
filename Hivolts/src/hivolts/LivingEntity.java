package hivolts;

/**
 * Created by Neelay on 9/18/2014.
 */
public class LivingEntity extends Entity {

    boolean dead = false;
        public boolean isDead() { return dead; }

    public LivingEntity(int x, int y) {
        super(x, y);
    }
}