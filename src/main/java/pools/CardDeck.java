package pools;

import enums.Rank;
import enums.Suit;
import models.Card;

import java.util.*;

/**
 * This class represents carddeck that consists of classical cards. Generates
 * them initialization and when cards are dealed then removes cards from list
 * so no one can use them again
 */
public class CardDeck {

    private List<Card> cardList = new ArrayList<>();

    /**
     * Initializes card deck by creating cards into this deck.
     */
    public CardDeck() {
        createDeck();
    }

    /**
     * Retreieves list of randomly selected cards for player and removes them
     * from possible card list.
     *
     * Checks if asked number of cards is bigger than all cards in deck. If so
     * then returns null
     *
     * @param cardCount asked number of cards
     * @return list of randomly selected cards with count of cardCount
     */
    public List<Card> getRandomCards(int cardCount) {

        if (cardCount > cardList.size()) {
            return null;
        }

        List<Card> randomCardsList = new ArrayList<>();
        Random randomGenerator = new Random();

        for (int i = 0; i < cardCount; i++) {
            int index = randomGenerator.nextInt(cardList.size());
            randomCardsList.add(cardList.get(index));
            cardList.remove(cardList.get(index));
        }

        return randomCardsList;
    }

    /**
     * Resets deck to initial form
     */
    public void resetDeck() {
        clearDeck();
    }

    /**
     * Creates new deck card by card. Takes all possible suits in Suit Enum
     * and takes all possible ranks and loops them over. Adds cards to list one by one.
     */
    private void createDeck() {
        for (Suit suit: Suit.values()) {
            for (Rank rank : Rank.values()) {
                cardList.add(new Card(suit, rank));
            }
        }
    }

    /**
     * Empties out deck and forms another one
     */
    private void clearDeck() {

        cardList.clear();
        createDeck();
    }


}
