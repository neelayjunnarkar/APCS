package ch15.exercise5;

public class PokerHand extends Deck {

	static int ncards = 5; //to change number of cards in a pokerhand, change this value;
	
	public PokerHand(Card[] cards) {
		super(ncards);
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
			//fsuit = card.suit;
		}
		return true;	
	}
	
	boolean hasStraightFlush() {
		return (allSameSuit() && inSeq()) ? true : false;
	}
	
	boolean allSameSuit() {
		int fsuit = cards[0].suit;
		for (Card card : cards) {
			if (card.suit != fsuit)
				return false;
		}
		return true;
	}
	
	boolean inSeq() {
		int frank = cards[0].rank;
		String dir;
		if (cards[1].rank == frank+1) {
			dir = "up";
		} else if (cards[1].rank == frank-1) {
			dir = "down";
		} else {
			return false;
		}

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
	
	boolean hasFourOfKind() {
		int n = 0;
		for (int frank = 0; frank < Card.ranks.length; frank++) {
			n = 0;
			for (Card c : cards) {
				if (c.rank == frank) {
					n++;
				}
			}
			if (n == 4) {
				return true;
			}
		}
		return false;
	}
	
}
