package week17;

import java.util.Comparator;

/**
 * Created by NEELAY on 1/12/2015.
 */
public class DefaultComparator<T extends Comparable<T>> implements Comparator<T>{

    public boolean isReversed() {
        return reversed;
    }

    public void setReversed(boolean reversed) {
        this.reversed = reversed;
    }

    private boolean reversed = false;

    @Override
    public int compare(T o1, T o2) {
        if (!reversed) {
            return ((Comparable)o1).compareTo(o2);
        } else {
            return -((Comparable)o1).compareTo(o2);
        }
    }

    public void reverse() {
        reversed = !reversed;
    }
}
