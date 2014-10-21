package ch15.exercise5;

/*
 * a midterm:
 * appendix of thinkapjava on graphics : readdddd
 * loop invariants
 * NO CUSTOM IDE COLORING 
 * dot-product
 * access modifiers, why, stuff
 * classes, constructors, inheritance
 * KNOW toString method
 * indexing arrays
 * generalize from a collection of data types to a collection of data
 * 
 * 
 * author: Neelay Junnarkar
 * 
 * For 5 cards in a hand:
 * With nreps set to 1000000, 
 * 		%flushes is about 0.196%
 * 		%threes is about 2.22%
 * 
 * The Wikipedia Article has probabilities of:
 * 		%flushes: 0.196%
 * 		%threes: 2.11%
 * 
 * This program has repeatedly outputted numbers such as those stated above with a five card hand, 
 * with the %flushes being very close to the value wikipedia predicts, ranging from around .193% to .202%, and
 * the %threes being about .10% to .15% off 
 * 
 * For a 7 card hand:
 * with nreps set to 1000000:
 * 		%flushes: 0.187%
 * 		%threes: 2.42%
 * 
 */
public class Main {
	
	public static void main(String[] args) {
		Deck deck = new Deck();

		deck.shuffle();
		int nreps = 1000000;
		double nflushes = 0;
		double nthrees = 0;
		for (int i = 0; i < nreps; i++) {
			deck.shuffle();
			PokerHand hand = new PokerHand(deck.deal());
			if (hand.hasFlush()) {
				nflushes++;
			}
			if (hand.hasThreeOfKind()) {
				nthrees++;
			}
		}
		System.out.println("%flushes: "+nflushes/nreps*100);
		System.out.println("%threes: "+nthrees/nreps*100);
	}
	
}
