package models;

/**
 * Player of the game. Player has 20 chips that game uses on initialization.
 * Player has id and hand of cards.
 */
public class Player {

    private int id;
    private int chips;
    private Hand hand;

    /**
     * Initialies player with given id and gives Player 20 chips.
     * @param id Id of this Player
     */
    public Player(int id) {
        this.id = id;
        this.chips = 20;
    }

    /**
     * @return Id of this Player
     */
    public int getId() {
        return id;
    }

    /**
     * @return gets chips count of this Player
     */
    public int getChips() {
        return chips;
    }

    /**
     * @param chips chips count of this player
     */
    public void setChips(int chips) {
        this.chips = chips;
    }

    /**
     * @param hand Hand object that consists of list of cards
     */
    public void setHand(Hand hand) {
        this.hand = hand;
    }

    /**
     * @return gets Hand object of this player that consists of list of cards
     */
    public Hand getHand() {
        return hand;
    }

}
