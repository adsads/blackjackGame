package cards;

import java.util.ArrayList;

public class megaDeck extends Deck {
	// default 6 decks
	public megaDeck() {
		drawPile = new ArrayList<Card>();
		usedPile = new ArrayList<Card>();
		add52Cards();
		add52Cards();
		add52Cards();
		add52Cards();
		add52Cards();
		add52Cards();
	}

	public megaDeck(int numberOfDecks) {
		drawPile = new ArrayList<Card>();
		usedPile = new ArrayList<Card>();
		for (int i = 0; i < numberOfDecks; i++)
			add52Cards();
	}

}
