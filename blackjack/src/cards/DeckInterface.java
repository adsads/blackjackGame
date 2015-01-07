package cards;

import java.util.List;

public interface DeckInterface {
	public void shuffleAll();

	public void shuffleRemaining();

	public Card DealCard();

	public List<Card> DealCards(int number);

	public void discardBottomOfDeck(Card c);

	public void outputRemaining();

	public void shuffleInCard(Card card);
}
