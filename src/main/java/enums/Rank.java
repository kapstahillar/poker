package enums;

/**
 * Rank enum. Mostly used to show the rank of the card.
 */
public enum Rank {

    /**
     * Rank two with strength of 1
     */
    TWO("2", 1),
    /**
     * Rank three with strength of 2
     */
    THREE("3", 2),
    /**
     * Rank four with strength of 3
     */
    FOUR("4", 3),
    /**
     * Rank five with strength of 4
     */
    FIVE("5", 4),
    /**
     * Rank six with strength of 5
     */
    SIX("6", 5),
    /**
     * Rank seven with strength of 6
     */
    SEVEN("7", 6),
    /**
     * Rank eight with strength of 7
     */
    EIGHT("8", 7),
    /**
     * Rank nine with strength of 8
     */
    NINE("9", 8),
    /**
     * Rank ten with strength of 9
     */
    TEN("10", 9),
    /**
     * Jack with strength of 10
     */
    JACK("Jack", 10),
    /**
     * Queen with strength of 11
     */
    QUEEN("Queen", 11),
    /**
     * King with strength of 12
     */
    KING("King", 12),
    /**
     * Ace with strength of 13
     */
    ACE("Ace", 13);

    private final String name;
    private final Integer value;

    /**
     * Constructor of rank.
     * Takes in name and strength of rank.
     * @param name name of rank
     * @param value strength of rank
     */
    Rank(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    /**
     * @return gets name of rank
     */
    public String getName() {
        return name;
    }

    /**
     * @return gets value of rank
     */
    public Integer getValue() {
        return value;
    }
}
