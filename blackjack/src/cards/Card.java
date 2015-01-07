package cards;

public class Card {
	private Rank rank;
	private Suit suit;
	private int value;

	public Card(Rank rank, Suit suit) {
		super();
		this.rank = rank;
		this.suit = suit;
		this.setValue(rankValue(rank));
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public char getSymbol() {
		return suitSymbol(suit);
	}

	public char getRankSymbol() {
		return rankSymbol(rank);
	}

	private static char suitSymbol(Suit s) {
		char heart = '\u2665';
		char diamond = '\u2666';
		char spade = '\u2660';
		char club = '\u2663';
		if (s.toString().charAt(0) == 'H') {
			return heart;
		} else if (s.toString().charAt(0) == 'D')
			return diamond;
		else if (s.toString().charAt(0) == 'S')
			return spade;
		else if (s.toString().charAt(0) == 'C')
			return club;
		return 0;
	}

	public static int rankValue(Rank r) {
		switch (r) {
		case ACE:
			return 11;
		case TWO:
			return 2;
		case THREE:
			return 3;
		case FOUR:
			return 4;
		case FIVE:
			return 5;
		case SIX:
			return 6;
		case SEVEN:
			return 7;
		case EIGHT:
			return 8;
		case NINE:
			return 9;
		case TEN:
			return 10;
		case JACK:
			return 10;
		case QUEEN:
			return 10;
		case KING:
			return 10;
		}
		return 0;
	}

	private static char rankSymbol(Rank r) {
		switch (r) {
		case ACE:
			return 'A';
		case TWO:
			return '2';
		case THREE:
			return '3';
		case FOUR:
			return '4';
		case FIVE:
			return '5';
		case SIX:
			return '6';
		case SEVEN:
			return '7';
		case EIGHT:
			return '8';
		case NINE:
			return '9';
		case TEN:
			return 'X';
		case JACK:
			return 'J';
		case QUEEN:
			return 'Q';
		case KING:
			return 'K';
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Card [rank=" + rank + ", suit=" + suit + "]";
	}

	public String toCardLayout() {
		return " ---\n" + "|" + rankSymbol(this.rank) + "  |\n" + "| "
				+ suitSymbol(this.suit) + " |\n" + "|  "
				+ rankSymbol(this.rank) + "|\n" + " ---\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
