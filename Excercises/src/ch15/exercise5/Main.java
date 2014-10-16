package ch15.exercise5;

public class Main {
	public static void main(String[] args) {
		Card card = new Card(1, 1);
		card.print();
		String s = card.toString();
		System.out.println(s);
		System.out.println(card);

		Card card2 = new Card(1, 1);
		System.out.println(card.equals(card2));

		Deck deck = new Deck();

		// check sortDeck
		deck.shuffle();
		deck.sort();
		CardSoln3.checkSorted(deck);

		// check that findBisect finds each card
		int index;
		for (int i = 0; i < 52; i++) {
			index = deck.findBisect(deck.cards[i], 0, deck.cards.length - 1);
			if (index != i) {
				System.out.println("Not found!");
			}
		}

		// make a subdeck
		Deck hand = deck.subdeck(8, 12);
		hand.print();

		// check that findBisect doesn't find a card that's not there
		Card badCard = new Card(1, 1);
		index = hand.findBisect(badCard, 0, hand.cards.length - 1);
		if (index != -1) {
			System.out.println("Found?");
		}

		// check mergeSort
		deck.shuffle();
		deck = deck.mergeSort();
		CardSoln3.checkSorted(deck);
	}
}
