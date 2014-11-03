Exercise Ch. 15
===============

The exercises are split between the packages, for convenience

Exercise 1:
	Creates an object method version of merge, a method given in a download.
	Modifies another method (also given) to use the new merge method
	
Exercise 2:
	Transforms a given class method into an object method
	
Exercise 3:
	Transforms a given object method into a class method
	
Exercise 4:
	Creates a Rational class with the methods of:
		negate         Switches the sign of the rational
		invert         Switches the numerator and denominator of the rational
		toDouble       Converts the rational to a double
		gcd            Finds the gcd of 2 numbers
		reduce         Reduces the rational
		add            Adds 2 rationals
		printRational  Prints the rational
		
Exercise 5:
	Creates a PokerHand class which extends Deck, a given class
	
	PokerHand:
		Is a hand of variable number of cards to accommodate for the different styles of playing with either 5 or 7 cards
		Implements the methods:
			hasFlush          Checks whether the hand has a flush
			hasStraightFlush  Checks whether the hand has a straight flush. Uses allSameSuit() and inSeq()
			hasFullHouse      Checks whether the hand has a full house. Uses hasThreeOfKind() and hasTwoOfKind()
			isStraight        Checks whether the hand is straight, or is ordered sequentially. Uses inSeq()
			allSameSuit       Checks whether all cards in hand are of the same suit
			inSeq             Checks whether all cards in hand are ordered sequentially
			hasTwoOfKind      Checks whether there are 2 cards of same rank in hand
			hasThreeOfKind    Checks whether there are 3 cards of same rank in hand
			hasFourOfKind     Checks whether there are 4 cards of same rank in hand
			