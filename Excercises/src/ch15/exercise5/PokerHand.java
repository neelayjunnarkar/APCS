package ch15.exercise5;

public class PokerHand extends Deck {

	public PokerHand(Card[] cards) {
		super(5);
		this.cards = cards;
	}
	
	public PokerHand(PokerHand hand) {
		this.cards = hand.cards;
	}
	
	boolean hasFlush() {
		int fsuit = cards[0].suit;
		for (Card card : cards) {
			if (card.suit != fsuit) {
				return false;
			}
			fsuit = card.suit;
		}
		return true;	
	}
	
	boolean hasThreeOfKind() {
		int n = 0;
		for (int frank = 0; frank < Card.ranks.length; frank++) {
			n = 0;
			for (Card c : cards) {
				if (c.rank == frank) {
					n++;
				}
			}
			if (n == 3) {
				return true;
			}
		}
		return false;
	}
	
}
