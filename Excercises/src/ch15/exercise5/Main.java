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

        PokerHand hand = deck.deal(5);
        hand.shuffle();
        hand.print();

        if (hand.isStraight()) System.out.println("straight");
        if (hand.hasStraightFlush()) System.out.println("straight flush");
        if (hand.hasFullHouse()) System.out.println("full house");
        if (hand.hasThreeOfKind()) System.out.println("3 of a kind");
        if (hand.hasFourOfKind()) System.out.println("4 of a kind");
        if (hand.hasFlush()) System.out.println("flush");


		int nreps = 1000000;
		double nflushes = 0;
		double nthrees = 0;
		for (int i = 0; i < nreps; i++) {
			deck.shuffle();
			PokerHand hand1 = new PokerHand(deck.deal(5));
			if (hand1.hasFlush()) {
				nflushes++;
			}
			if (hand1.hasThreeOfKind()) {
				nthrees++;
			}
		}
		System.out.println("%flushes: "+nflushes/nreps*100);
		System.out.println("%threes: "+nthrees/nreps*100);
	}
	
}
