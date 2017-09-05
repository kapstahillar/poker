package enums;

import models.Card;
import models.Hand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Enumumerations of PokerHand. This class provides static enums
 * that can be matched with Hand object to determine current Hand value in Poker.
 */
public enum PokerHand{

    /**
     * Royal Flush enum with rank 10. Can be matches with hand that consists of 5 cards.
     *
     * Matching with this enum checks if hand is Royal Flush.
     *
     * Lists ACE, KING, QUEEN, JACK and TEN and checks if Hand objects cards have all of them in same suit.
     */
    ROYAL_FLUSH("Royal Flush", 10) {
        public boolean matches(Hand hand) {

            List<Rank> rankList = new ArrayList<Rank>(){{
                add(Rank.ACE);
                add(Rank.KING);
                add(Rank.QUEEN);
                add(Rank.JACK);
                add(Rank.TEN);
            }};

            if (PokerHand.STRAIGHT.matches(hand) && PokerHand.FLUSH.matches(hand)) {
                for (Card card: hand.getCards()) {
                    if (!rankList.contains(card.getRank())) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    },
    /**
     * Straight flush enum with rank 9. Can be matches with hand that consists of 5 cards.
     *
     * Matching with this enum checks if hand is Straight flush.
     *
     * Matching checks if hand consists of Flush and Straight together to form a Straight Flush
     */
    STRAIGHT_FLUSH("Straight Flush", 9) {
        public boolean matches(Hand hand) {
            return (PokerHand.STRAIGHT.matches(hand) && PokerHand.FLUSH.matches(hand));
        }
    },
    /**
     * Four of a kind enum with rank 8. Can be matches with hand that consists of 5 cards.
     *
     * Matching with this enum checks if hand is Four of a kind.
     *
     * Matching checks if Hand has 4 same ranks occurring.
     */
    FOUR_OF_A_KIND("Four of a Kind", 8) {
        public boolean matches(Hand hand) {

            Map<Integer, Long> countMap = hand.getCards().stream().collect(Collectors.groupingBy(
                    Card::getRankValue, Collectors.counting()));
            return countMap.containsValue((long)4);
        }
    },
    /**
     * Full house enum with rank 7. Can be matches with hand that consists of 5 cards.
     *
     * Matching with this enum checks if hand is Full house.
     *
     * Matching checks if hand consists of one three of a kind and one pair;
     */
    FULL_HOUSE("Full House", 7) {
        public boolean matches(Hand hand) {

            Map<Integer, Long> countMap = hand.getCards().stream().collect(Collectors.groupingBy(
                    Card::getRankValue, Collectors.counting()));

            return (1 == Collections.frequency(new ArrayList<Long>(countMap.values()), (long) 2) &&
                    1 == Collections.frequency(new ArrayList<Long>(countMap.values()), (long) 3));
        }
    },
    /**
     * Flush enum with rank 6. Can be matches with hand that consists of 5 cards.
     *
     * Matching with this enum checks if hand is Flush.
     *
     * Matching checks if cards in hand are same suit
     */
    FLUSH("Flush", 6) {
        public boolean matches(Hand hand) {

            Suit flushSuit = hand.getCards().get(0).getSuit();

            for (Card card: hand.getCards()) {
                if (!flushSuit.equals(card.getSuit())) {
                    return false;
                }
            }
            return true;
        }
    },
    /**
     * Straight with rank 5. Can be matches with hand that consists of 5 cards.
     *
     * Matching with this enum checks if hand is Straight.
     *
     * Matching checks if cards in hand are sequential.
     */
    STRAIGHT("Straight", 5) {
        public boolean matches(Hand hand) {

            List<Card> cards = hand.getCards();

            cards.sort((r1, r2) ->   r1.getRankValue() - r2.getRankValue());

            for (int i = 1; i < cards.size(); i++) {
                if (cards.get(i).getRankValue() != cards.get(i-1).getRankValue() + 1) {
                    return false;
                }
            }
            return true;
        }
    },
    /**
     * Three of a Kind with rank 4. Can be matches with hand that consists of 5 cards.
     *
     * Matching with this enum checks if hand is Three of a Kind.
     *
     * Matching checks if hand has three cards with same rank.
     */
    THREE_OF_A_KIND("Three of a Kind", 4) {
        public boolean matches(Hand hand) {

            Map<Integer, Long> countMap = hand.getCards().stream().collect(Collectors.groupingBy(
                    Card::getRankValue, Collectors.counting()));

            return countMap.containsValue((long)3);
        }
    },
    /**
     * Two Pairs with rank 3. Can be matches with hand that consists of 5 cards.
     *
     * Matching with this enum checks if hand is Two Pairs.
     *
     * Matching checks if hand has two sets of same cards
     */
    TWO_PAIRS("Two Pairs", 3) {
        public boolean matches(Hand hand) {

            Map<Integer, Long> countMap = hand.getCards().stream().collect(Collectors.groupingBy(
                    Card::getRankValue, Collectors.counting()));

            return (2 == Collections.frequency(new ArrayList<Long>(countMap.values()), (long) 2));
        }
    },
    /**
     * One Pair with rank 2. Can be matches with hand that consists of 5 cards.
     *
     * Matching with this enum checks if hand is One Pair.
     *
     * Matching checks if hand has 2 cards with same rank
     */
    ONE_PAIR("One Pair", 2) {
        public boolean matches(Hand hand) {

            Map<Integer, Long> countMap = hand.getCards().stream().collect(Collectors.groupingBy(
                    Card::getRankValue, Collectors.counting()));

            return (1 == Collections.frequency(new ArrayList<Long>(countMap.values()), (long) 2));
        }
    },
    /**
     * High Card with rank 1. Can be matches with hand that consists of 5 cards.
     *
     * Matching with this enum checks if hand is High Card.
     *
     * Matching checks always returns true
     */
    HIGH_CARD("High Card", 1) {
        public boolean matches(Hand hand) {
            return true;
        }
    };

    private String value;
    private int rank;

    /**
     * Constructor for enum. Instantiates enum with given value.
     * @param value name of the rank
     * @param rank strength of the rank
     */
    PokerHand(String value, int rank) {
        this.value = value;
        this.rank = rank;
    }

    /**
     * @return value of this enum
     */
    public String getValue() {
        return value;
    }

    /**
     * @return rank of this enum
     */
    public int getRank() {
        return rank;
    }

    /**
     * Method that every enum should override.
     * Checks if hand matches with corresponding hand
     * @param hand Hand object with a list of 5 cards
     * @return did this enum match with hand
     */
    public abstract boolean matches(Hand hand);
}
