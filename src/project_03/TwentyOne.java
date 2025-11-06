package project_03;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class TwentyOne {
	
	private static String shuffledGameDeck = makeShuffledDeck();
	private static String playerHand = "";

	/**
	 * The starting point of our Twenty One game project.
	 * @param args  Program input arguments.
	 */
	public static void main(String[] args) 
	{
		//TODO: Write main method game logic here.

		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String inputChoice = "";
		String dealerHand = "";
		String upHand = "";

		for (int i = 0; i < 2; i++) 
			{
				playerHand = addCardToHand(shuffledGameDeck.split(" ")[0], playerHand);
			}
			for (int i = 0; i < 2; i++) 
			{
				dealerHand = addCardToHand(shuffledGameDeck.split(" ")[0], dealerHand);
			}

			upHand = dealerHand.split(" ")[1] + " *_*";
			int playerScore = evalHand(playerHand);
			int upHandScore = evalHand(upHand);
			int dealerScore = evalHand(dealerHand);
			boolean keepPlaying = (playerScore < 21 && playerScore != 21 && dealerScore < 21 && dealerScore != 21);
			boolean shouldBreak = false;

			System.out.println
				(
					String.format(
						"LET'S PLAY!\n" +
						"============\n" +
						"Player's Total: %d\n" +
						"%s\n" +
						"\n" +
						"%s\n" +
						"Dealer's Upcard: %d\n" +
						"============\n" +
						"1. Hit || 2. Stand || 3. Pick for Me"
						, playerScore, playerHand, upHand, upHandScore)
				);

		while(keepPlaying)
		{
			shouldBreak = false;
			inputChoice = input.nextLine();
			if (inputChoice == "" || inputChoice.toLowerCase() == "n" || inputChoice.toLowerCase() == "no")
			{
				System.out.println("Hava a good day!");
				System.exit(0);
			}else
			{
				try
				{
					switch (Integer.parseInt(inputChoice)) {
						case 1:
							playerHand = addCardToHand(shuffledGameDeck.split(" ")[0], playerHand);
							playerScore = evalHand(playerHand);
							keepPlaying = (playerScore < 21 && playerScore != 21);
							break;
						case 2:
							while (evalHand(dealerHand) < 17)
							{
								dealerHand = addCardToHand(shuffledGameDeck.split(" ")[0], dealerHand);
							}
							keepPlaying = false;
							break;
						case 3:
							if (playerShouldHit(playerHand, dealerHand))
							{
								playerHand = addCardToHand(shuffledGameDeck.split(" ")[0], playerHand);
								playerScore = evalHand(playerHand);
								keepPlaying = (playerScore < 21 && playerScore != 21);
							} 
							else
							{
								while (evalHand(dealerHand) < 17)
							{
								dealerHand = addCardToHand(shuffledGameDeck.split(" ")[0], dealerHand);
							}
							keepPlaying = false;
							}
							break;
					
						default:
							System.out.println("Please choose a valid option.");
							shouldBreak = true;
							break;
					}
				} catch (Exception e)
				{
					System.out.println("Please choose a valid option.");
					shouldBreak = true;
					break;
				}

				if (shouldBreak) continue;
				
				if (keepPlaying)
				{
					playerScore = evalHand(playerHand);
					upHandScore = evalHand(upHand);
					dealerScore = evalHand(dealerHand);

					System.out.println
					(
						String.format(
							"============\n" +
							"Player's Total: %d\n" +
							"%s\n" +
							"\n" +
							"%s\n" +
							"Dealer's Upcard: %d\n" +
							"============\n" +
							"1. Hit || 2. Stand || 3. Pick for Me"
							, playerScore, playerHand, upHand, upHandScore)
					);
				} 
				else
				{
					playerScore = evalHand(playerHand);
					upHandScore = evalHand(upHand);
					dealerScore = evalHand(dealerHand);

					boolean playerWins = (
						dealerScore > 21 ||
						playerScore > dealerScore && playerScore <= 21
					);

					System.out.println
					(
						String.format(
							((playerWins) ? "PLAYER WINS!!!\n" : "DEALER WINS!!!\n") + 
							"============\n" +
							"Player's Total: %d" + ((playerScore > 21) ? " BUSTED!\n" : "\n") +
							"%s\n" +
							"\n" +
							"%s\n" +
							"Dealer's Score: %d" + ((dealerScore > 21) ? " BUSTED!\n" : "\n") +
							"============"
							, playerScore, playerHand, dealerHand, dealerScore)
					);
				}
			}
		}
	}
	
	
	/**
	 * Evaluate the supplied hand of cards and return the best possible numeric value.
	 * Attempts to keep the value at or under 21 if possible.
	 * @param hand  A String list of cards.
	 * @return The best possible value of the cards as an int.
	 */
	private static int evalHand (String hand) 
	{
		int score = 0;
		int hasAce = 0;

		Scanner evaluator = new Scanner (hand);
		evaluator.useDelimiter("_| ");
		
		while(evaluator.hasNext())
		{
			evaluator.next();
			
			String token = evaluator.next();

			switch (token) 
			{
				case "1":
				case "2":
				case "3":
				case "4":
				case "5":
				case "6":
				case "7":
				case "8":
				case "9":
				case "10":
					score += Integer.parseInt(token);
					break;
				case "J":
				case "Q":
				case "K":
					score += 10;
					break;
				case "A":
					hasAce++;
					break;
				default:
					score += 0;
			}
		}
		for ( int i = 0; i < hasAce; i++) {
				score += ((score += 11) > 21) ? 1 : 11;
			}
		evaluator.close();
		return score;
	}

	
	
	/**
	 * Get the top card from a String of cards. This can be the deck, or a player's hand.
	 * @param deck  A String of cards. This can be the deck, or a player's hand.
	 * @return A String containing the first card from the supplied deck.
	 */	
	public static String getTopCard (String deck)
	{
		Scanner card = new Scanner(deck);
		card.useDelimiter(" ");
		// return (card.hasNext()) ? card.next() : "No cards left!!!";
		if (card.hasNext())
		{
			String c = card.next();
			shuffledGameDeck = removeTopCard(deck.substring(c.length()));
			card.close();
			return c;
		} else
		{
			card.close();
			return "No Cards Left!!!";
		}
	}
	
	
	/**
	 * Remove the top card from a String list of cards.
	 * @param deck  A String of cards. This can be the deck, or a player's hand.
	 * @return A new String deck with the top card removed.
	 */
	private static String removeTopCard (String deck) {
		try 
		{
			deck = deck.substring(1);
		}
		catch (Exception e) {deck = deck.substring(0);}

		return deck;
	}
	
	
	/**
	 * Given a card and a hand, add the card to the hand.
	 * @param card  A String representing a card to add to the hand.
	 * @param hand  A String representing the current hand.
	 * @return A new String hand containing all of the cards from the previous hand,
	 *         plus the new card.
	 */
	private static String addCardToHand (String card, String hand)
	{
		hand = String.join(" ", hand, card);
		hand = (hand.charAt(0)==' ') ? hand.substring(1) : hand;
		shuffledGameDeck = removeTopCard(shuffledGameDeck.substring(card.length()));
		return hand;
	}
	
	
	/**
	 * Given hands of a player and opponent, chose whether the player 
	 * should hit (I.E. Draw another card).
	 * <p>
	 * <h3>Strategy:</h3> 
	 * The method follows the charts about Basic Strategy posted by BlackJackApprenticeship.com. 
	 * These charts are supposed to show what the math says for each value total vs. the 
	 * dealer's upcard.
	 * <p>
	 * An example is to stand if <strong>A)</strong> you don't have a Ace, 
	 * <strong>B)</strong> your value is 13, and 
	 * <strong>C)</strong> the dealer's
	 * upcard is 2.
	 * 
	 * @param myHand  The player's hand as a String of cards.
	 * @param opponentHand  The opponent's hand as a String of cards.
	 * @return True if the player should hit, False if the player should stand.
	 */
	//TODO: Write playerShouldHit method.
	private static boolean playerShouldHit (String myHand, String opponentHand)
	{
		boolean shouldHit = true;
		int playerScore = evalHand(myHand);
		String upcard = opponentHand.split(" ")[0];
		int opponentScore = evalHand(upcard);
		boolean softScore = myHand.contains("_A");

		switch (playerScore) {
			case 20:
			case 19:
				shouldHit = false;
				break;
			case 18:
				shouldHit = (softScore && opponentScore > 8);
				break;
			case 17:
				shouldHit = (softScore);
				break;
			case 16:
			case 15:
			case 14:
			case 13:
				shouldHit = (softScore || opponentScore > 6);
				break;
			case 12:
				shouldHit = (softScore || (opponentScore < 4 && opponentScore > 6));
				break;
			default:
				break;
		}		
		return shouldHit;
	}
	
	/**
	 * Given a String of cards, randomly re-order them.
	 * NOTE: You can force the game to pick the same random order by supplying an integer 
	 * input argument to "new Random(int)". This could be useful for debugging.
	 * @param deck  A string of cards.
	 * @return A new String list of cards, with all of the same cards as the input deck, 
	 *         but in random order.
	 */
	public static String shuffleDeck(String deck) 
	{
		Random rand = new Random();
        List<String> cardList = Arrays.asList(deck.split(" "));
        Collections.shuffle(cardList, rand);
        return String.join(" ", cardList);
	}
	
	
	/**
	 * Make a new String of 52 cards representing all of the cards in a standard Poker deck.
	 * @return  A String of 52 cards.
	 */
	public static String makeDeck()
	{
		String deck = "";
		String suits = "hdsc";
		for (int s = 0; s < suits.length(); ++s)
		{
			String suit = suits.charAt(s)+"";
			for (int i = 1; i <= 13; ++i)
			{
				String rank = ""+i;
				switch (i) {
				case 1:
					rank = "A"; break;
				case 11:
					rank = "J"; break;
				case 12:
					rank = "Q"; break;
				case 13:
					rank = "K"; break;
				}
				
				String card = suit + "_" + rank;
				deck += " " + card;
			}
		}
		
		// The substring(1) call removes the leading space.
		return deck.substring(1);
	}
	
	
	/**
	 * Create and return a String of 52 randomly-ordered Poker cards.
	 * @return A String of 52 randomly-ordered Poker cards.
	 */
	public static String makeShuffledDeck()
	{
		return shuffleDeck(makeDeck());
	}
}