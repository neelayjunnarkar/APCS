package ch15.exercise5;

public class CardSoln3 {

	/*
	 * Checks that the deck is sorted.
	 */
	public static void checkSorted(Deck deck) {
		for (int i = 0; i < 51; i++) {
			int flag = deck.cards[i].compareTo(deck.cards[i + 1]);
			if (flag != -1) {
				System.out.println("Not sorted!");
			}
		}
	}
}
