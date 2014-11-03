package ch15.exercise5;

/**
 * @author Neelay Junnarkar
 * A PokerHand class with variable number of cards in the hand. Extends Deck
 */
public class PokerHand extends Deck {

    /**
     *
     * @param cards array of cards that is the hand
     * @param ncards number of cards in the poker hand
     */
	public PokerHand(Card[] cards, int ncards) {
		super(ncards);
		this.cards = cards;
	}

    /**
     *
     * @param hand the other pokerhand
     */
	public PokerHand(PokerHand hand) {
		this.cards = hand.cards;
	}

    /**
     * @return retursn whether the hand has a flush
     */
	boolean hasFlush() {
		int fsuit = cards[0].suit;
		for (Card card : cards) {
			if (card.suit != fsuit) {
				return false;
			}
		}
		return true;	
	}

    /**
     *
     * @return returns whether the hand has a straight flush
     */
	boolean hasStraightFlush() {
		return (allSameSuit() && inSeq()) ? true : false;
	}

    /**
     *
     * @return returns whether the hand has a full house
     */
    boolean hasFullHouse() {
        return (hasThreeOfKind() && hasTwoOfKind()) ? true : false;
    }

    /**
     *
     * @return returns whether the hand is Straight, or is in sequence
     */
    boolean isStraight() {
        return inSeq();
    }

    /**
     *
     * @return returns whether the hand's cards have all same suits
     */
	boolean allSameSuit() {
		int fsuit = cards[0].suit;
		for (Card card : cards) {
			if (card.suit != fsuit)
				return false;
		}
		return true;
	}

    /**
     *
     * @return returns whether, if hand was reordered, it would be in sequence from low to high or high to low
     */
	boolean inSeq() {
        int sum = 0;
        for (Card c : cards) {
            sum += c.rank;
        }
        boolean bool = false;
        for (int s = 0; s < Card.suits.length; s++) {
            Card card = new Card(s, sum/cards.length);
            if (findBisect(card, 0, cards.length-1) != -1) {
                bool = true;
            }
        }
        return bool;
	}

    /**
     *
     * @return returns whether hand has a pair of a certain rank
     */
    private boolean hasTwoOfKind() {
        int n = 0;
        for (int frank = 0; frank < Card.ranks.length; frank++) {
            n = 0;
            for (Card c : cards) {
                if (c.rank == frank) {
                    n++;
                }
            }
            if (n == 2) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return returns whether hand has three cards of a certain rank
     */
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

    /**
     *
     * @return returns whether hand has four cards of a certain rank
     */
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
