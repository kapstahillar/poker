package models;

import enums.Rank;
import enums.Suit;

/**
 * Class that represents classic card with rank and suit
 */
public class Card {

    private Suit suit;
    private Rank rank;

    /**
     * Initializes Card with corresponding suit and rank.
     * @param suit suit of a card
     * @param rank rank of a card
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * @return string token with suit name and rank. Example "2 of DIAMONDS"
     */
    public String getToken(){
        return rank.getName() + " of " + suit;
    }

    /**
     * @return gets card's rank value
     */
    public int getRankValue() {
        return rank.getValue();
    }

    /**
     * @return gets rank of a card
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * @return gets name of a card
     */
    public String getName() {
        return rank.getName();
    }

    /**
     * @return gets suit of a card
     */
    public Suit getSuit() {
        return suit;
    }
}
