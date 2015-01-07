package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck implements DeckInterface {
	protected ArrayList<Card> drawPile;
	protected ArrayList<Card> usedPile;

	public Deck() {
		this.drawPile = new ArrayList<Card>();
		this.usedPile = new ArrayList<Card>();
		add52Cards();
	}

	public Deck(ArrayList<Card> drawPile) {
		this.drawPile = drawPile;
		if (this.drawPile.isEmpty())
			add52Cards();
	}

	protected void add52Cards() {
		for (Suit s : Suit.values())
			for (Rank r : Rank.values())
				drawPile.add(new Card(r, s));
	}

	public ArrayList<Card> getDeck() {
		return drawPile;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.drawPile = deck;
	}

	public int getDeckSize() {
		return drawPile.size() + usedPile.size();
	}

	public void shuffleAll() {
		for (Card c : this.usedPile) {
			if (!drawPile.contains(c))
				this.drawPile.add(c);
		}
		this.usedPile.clear();

		Collections.shuffle(this.drawPile);
		System.out.println("*shuffling noise*");
	}

	public void shuffleAll(Random rand) {
		for (Card c : this.usedPile) {
			if (!drawPile.contains(c))
				this.drawPile.add(c);
		}
		this.usedPile.clear();
		Collections.shuffle(this.drawPile, rand);
		System.out.println("*shuffling noise*");
	}

	public void shuffleRemaining() {
		Collections.shuffle(this.drawPile);
		System.out.println("*shuffling noise*");
	}

	public void shuffleRemaining(Random rand) {
		Collections.shuffle(this.drawPile);
		System.out.println("*shuffling noise*");
	}

	public Card DealCard() {
		Card returnCard = this.drawPile.get(0);
		this.drawPile.remove(0);
		this.usedPile.add(returnCard);
		return returnCard;
	}

	public List<Card> DealCards(int number) {
		ArrayList<Card> returnList = new ArrayList<Card>();
		if (number > this.drawPile.size())
			putUsedCardsIn();
		if (number > this.drawPile.size()) {
			for (int i = 0; i < 52; i++) {
				returnList.add(this.drawPile.get(i));
				usedPile.add(this.drawPile.get(i));
				// this.drawPile.remove(i);
			}
		} else {
			for (int i = 0; i < number; i++) {

				returnList.add(this.drawPile.get(i));
				usedPile.add(this.drawPile.get(i));
				// this.drawPile.remove(i);
			}
		}
		for (Card c : usedPile)
			drawPile.remove(c);
		return returnList;
	}

	public void putUsedCardsIn() {
		if (!usedPile.isEmpty()) {
			for (Card c : usedPile) {
				if (!drawPile.contains(c)) {
					drawPile.add(c);
				}
			}
			usedPile.clear();
		}
	}

	public void discardBottomOfDeck(Card card) {
		if (!drawPile.contains(card)) {
			drawPile.add(card);
		}
	}

	public void shuffleInCard(Card card) {
		discardBottomOfDeck(card);
		shuffleRemaining();
	}

	public void outputRemaining() {
		for (Card c : drawPile) {
			System.out.println(c);
		}
	}

}
