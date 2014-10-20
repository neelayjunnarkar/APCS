package ch15.exercise5;

public class Main {
	public static void main(String[] args) {
		Deck deck = new Deck();

		deck.shuffle();
//		PokerHand pokerhand = new PokerHand(deck.deal());
//		pokerhand.print();
//
//		if (pokerhand.hasFlush()) {
//			System.out.println("flushed");
//		}
//		if (pokerhand.hasThreeOfKind()) {
//			System.out.println("three of kind");
//		}
		int nreps = 2000;
		int nflushes = 0;
		int nthrees = 0;
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
	}
}
