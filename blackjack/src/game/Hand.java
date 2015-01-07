package game;

import java.util.ArrayList;
import java.util.Iterator;

import cards.Card;
import cards.Rank;
import exceptions.HandSizeException;

public class Hand {
	private ArrayList<Card> hand;
	String name;
	boolean done;

	public Hand() {
		hand = new ArrayList<Card>();
		name = "";
		done = false;
	}

	public Hand(String name) {
		hand = new ArrayList<Card>();
		this.name = name;
		done = false;
	}

	public void addCard(Card c) {
		hand.add(c);
	}

	public Card getCard(int pos) {
		return hand.get(pos);
	}

	public Card removeCard(int pos) {
		Card temp = hand.get(pos);
		hand.remove(pos);
		return temp;
	}

	public void emptyHand() {
		hand.clear();
	}

	public int getSize() {
		return hand.size();
	}

	public int scoreHand() {
		int score = 0;
		for (Card c : hand)
			score += c.getValue();
		if (score > 21) {
			int aceScore = 0;
			for (Card c : hand) {
				if (c.getRank() == Rank.ACE)
					aceScore += 1;
				else
					aceScore += c.getValue();
			}
			score = aceScore;
		}
		return score;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Hand [hand=" + hand + ", name=" + name + ", done=" + done + "]";
	}

	public void printDealerHand() throws Exception {
		if (hand.size() != 2)
			throw new HandSizeException(hand.size(), "Dealer's hand is not 2");
		System.out.println("Dealer  " + hand.get(1).getValue());
		System.out.println("+-+-+");
		System.out.println("| |" + hand.get(1).getRankSymbol() + "|");
		System.out.println("| |" + hand.get(1).getSymbol() + "|");
		System.out.println("+-+-+");
	}

	public void printPlayerHand() {
		// always do
		StringBuilder top = new StringBuilder();
		StringBuilder rankSymbols = new StringBuilder();
		StringBuilder symbols = new StringBuilder();
		StringBuilder bot = new StringBuilder();

		top.append("+-+-+");
		rankSymbols.append("|" + hand.get(0).getRankSymbol() + "|"
				+ hand.get(1).getRankSymbol() + "|");
		symbols.append("|" + hand.get(0).getSymbol() + "|"
				+ hand.get(1).getSymbol() + "|");
		bot.append("+-+-+");

		if (hand.size() > 2) {
			Iterator<Card> iter = hand.iterator();
			iter.next();
			iter.next();

			while (iter.hasNext()) {
				Card temp = iter.next();
				top.append("-+");
				rankSymbols.append(temp.getRankSymbol() + "|");
				symbols.append(temp.getSymbol() + "|");
				bot.append("-+");
			}
		}

		System.out.println(name + "  " + scoreHand());
		System.out.println(top.toString());
		System.out.println(rankSymbols.toString());
		System.out.println(symbols.toString());
		System.out.println(bot.toString());
	}

}
