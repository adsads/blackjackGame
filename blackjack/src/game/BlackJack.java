package game;

import java.util.Random;
import java.util.Scanner;

import cards.Deck;
import cards.megaDeck;

public class BlackJack {

	public static void main(String[] args) {
		Deck deck = new megaDeck();
		boolean playing = true;

		Hand dealer = new Hand("Dealer");
		Hand player = new Hand("Player");
		Hand player2 = new Hand("Split Hand");
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		deck.shuffleAll(rand);
		deck.shuffleAll(rand);
		deck.shuffleAll(rand);
		deck.shuffleAll(rand);
		deck.shuffleAll(rand);
		deck.shuffleAll(rand);
		// 1 player game
		try {
			// while (playing) {
			System.out.println("Starting New Game");
			dealer.addCard(deck.DealCard());
			player.addCard(deck.DealCard());
			dealer.addCard(deck.DealCard());
			player.addCard(deck.DealCard());

			// start game loop
			String line = "";
			while (playing) {
				dealer.printDealerHand();
				player.printPlayerHand();
				if (line.equals("double")) {
					playing = false;
					break;
				}
				if (player.scoreHand() == 21) {
					playing = false;
					break;
				}
				if (player.scoreHand() > 21) {
					playing = false;
					break;
				}

				System.out.println("Type 'hit' or 'stand' or 'double'");
				line = scan.nextLine();
				switch (line) {
				case "double":
				case "hit":
					player.addCard(deck.DealCard());
					break;
				case "split":
					if (player.getSize() == 2
							&& player.getCard(0).getValue() == (player
									.getCard(1).getValue())) {
						player2.addCard(player.removeCard(1));
						player.addCard(deck.DealCard());
						player2.addCard(deck.DealCard());
						System.out.println("split!");
					} else
						System.out.println("Invalid option");
					break;
				default:
				case "stand":
					playing = false;
					break;
				}

			}

			if (player2.getSize() == 2) {
				System.out.println("------------");
				playing = true;
				while (playing) {
					dealer.printDealerHand();
					player2.printPlayerHand();
					if (line.equals("double"))
						break;
					if (player2.scoreHand() == 21) {
						playing = false;
						break;
					}
					if (player2.scoreHand() > 21) {
						playing = false;
						break;
					}

					System.out.println("Type 'hit' or 'stand' or 'double'");
					line = scan.nextLine();
					switch (line) {
					case "double":
					case "hit":
						player2.addCard(deck.DealCard());
						break;
					default:
					case "stand":
						playing = false;
						break;
					}

				}

			}

			System.out.println("------------");
			while (dealer.scoreHand() < 17 && player.scoreHand() < 22) {

				if (player.scoreHand() == 21 && player.getSize() == 2)
					break;
				dealer.addCard(deck.DealCard());
				Thread.sleep(250);

			}

			declareWinner(player, dealer);

			if (player2.getSize() > 0) {
				System.out.println("------------");
				declareWinner(player2, dealer);
			}
			scan.close();
			// }
		} catch (Exception e) {
			// Auto-generated catch block
			e.printStackTrace();
			scan.close();
		}
	}

	private static void declareWinner(Hand player, Hand dealer) {
		dealer.printPlayerHand();
		player.printPlayerHand();
		if (player.scoreHand() == 21 && dealer.scoreHand() != 21) {
			System.out.println(player.name + " is the winner(Player 21)");
		} else if (player.scoreHand() > 21 && dealer.scoreHand() < 22) {
			System.out.println(dealer.name + " is the winner(Player Bust)");
		} else if (player.scoreHand() <= 21 && dealer.scoreHand() > 21) {
			System.out.println(player.name + " is the winner(Dealer Bust)");
		} else if (player.scoreHand() > dealer.scoreHand()) {
			System.out.println(player.name + " is the winner(Higher Score)");
		} else if (dealer.scoreHand() > player.scoreHand()) {
			System.out.println(dealer.name
					+ " is the winner(Dealer higher score)");
		} else if (dealer.scoreHand() == player.scoreHand())
			System.out.println("Push");

	}

}
