package models;

import analyzers.PokerHandAnalyzer;
import enums.PokerHand;
import exceptions.WrongHandException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Hand class model is representing players hand. Hand consists of list of cards.
 * This class can be compared to other Hand objects and it evaluates cards PokerHand
 */
public class Hand {

    PokerHand pokerHand;
    List<Card> cards;
    MatchData md;

    /**
     * Initializes Hand object with list of cards. Automatically checks
     * what card combo is in this hand.
     * @param cards list of Cards.
     */
    public Hand(List<Card> cards) {
        this.cards = cards;
        getPokerHand();
    }

    /**
     * @return gets list of cards in Hand
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Compares this obejct with another Hand object. Returns integer based value.
     * If value is 1 then this hand is stronger than compared hand.
     * If value is -1 then this hand is weaker than compared hand.
     * If this value is 0 this hand is tied with compared hand.
     *
     * @param hand hanb object that consists of list of cards
     * @return result of comparing
     */
    public int compareTo(Hand hand) {

        if (this.getHandValue() > hand.getHandValue()) {
            return 1;
        }
        else if (this.getHandValue() < hand.getHandValue()) {
            return -1;
        }
        else {
            //PokerHand rankings are same. Check cards rankings
            return compareTie(hand);
        }

    }

    /**
     * Compares tied PokerHands by rankings in Ranking list. RankingList
     * is formed by PokerHandAnalzyer.
     *
     * If value is 1 then this hand is stronger than compared hand.
     * If value is -1 then this hand is weaker than compared hand.
     * If this value is 0 this hand is tied with compared hand.
     *
     * This class makes sure that rankingLists are with same count of items
     * in it. If number is not same then it throws WrongHandException that
     * states that something went wrong with ranking process.
     *
     * @see analyzers.PokerHandAnalyzer
     * @param hand Hand object that consists of list of cards
     * @return result of comparing
     */
    private int compareTie(Hand hand){

        //Gets both ranking list
       List<Integer> rankingList1 = this.getMatchData().getRankingList();
       List<Integer> rankingList2 = hand.getMatchData().getRankingList();

        try {

            if (rankingList1.size() != rankingList2.size()) {
                throw new WrongHandException("Something went wrong with cards!");
            }

            for (int i = 0; i < rankingList1.size(); i++) {

                if (rankingList1.get(i) > rankingList2.get(i)) {
                    return 1;
                }
                else if (rankingList1.get(i) < rankingList2.get(i)) {
                    return -1;
                }
            }
        }
        catch (WrongHandException ex) {
            System.out.println(ex.getMessage());
        }

        return 0;
    }

    /**
     * Takes this object and compares every possible pokerHand match in descending order.
     * If result is matches sets pokerHand and gets corresponding matchdata
     */
    private void getPokerHand() {
        for (PokerHand potential : PokerHand.values()) {
            if (potential.matches(this)) {
                pokerHand = potential;
                md = getMatchData();
                break;
            }
        }
    }

    /**
     * Requires pokerHand property to be set first. If pokerHand propery
     * is not set first then returns 0 as value.
     * @return pokerHand's rank
     */
    private int getHandValue() {
        if (pokerHand == null) {
            return 0;
        }
        return pokerHand.getRank();
    }

    /**
     * Checks pokerHand and uses corresponding analyzer with it.
     * Return MatchData object with cards rankingList.
     * Also sets property value of match in MatchList to corresponding PokerHand
     * @return MatchData with a rankingList
     */
    public MatchData getMatchData() {

        if (pokerHand == PokerHand.ROYAL_FLUSH) {
            md = PokerHandAnalyzer.getRoyalFlushMatchData(this);
        }
        else if (pokerHand == PokerHand.STRAIGHT_FLUSH) {
            md = PokerHandAnalyzer.getStraightFlushMatchData(this);
        }
        else if (pokerHand == PokerHand.FOUR_OF_A_KIND) {
            md = PokerHandAnalyzer.getFourOfAKindMatchData(this);
        }
        else if (pokerHand == PokerHand.FULL_HOUSE) {
            md = PokerHandAnalyzer.getFullHouseMatchData(this);
        }
        else if (pokerHand == PokerHand.FLUSH) {
            md = PokerHandAnalyzer.getFlushMatchData(this);
        }
        else if (pokerHand == PokerHand.STRAIGHT) {
            md = PokerHandAnalyzer.getStraightMatchData(this);
        }
        else if (pokerHand == PokerHand.THREE_OF_A_KIND) {
            md = PokerHandAnalyzer.getThreeOfAKindMatchData(this);
        }
        else if (pokerHand == PokerHand.TWO_PAIRS) {
            md = PokerHandAnalyzer.getTwoPairsMatchData(this);
        }
        else if (pokerHand == PokerHand.ONE_PAIR) {
            md = PokerHandAnalyzer.getOnePairMatchData(this);
        }
        else {
            md = PokerHandAnalyzer.getHighCardMatchData(this);
        }

        md.setMatch(pokerHand);
        return md;
    }

    /**
     * Writes cards one by one and seperates them with ", ";
     * @return String of cards in Hand
     */
    @Override
    public String toString() {
        return cards.stream ().map (c -> c.getToken()).collect (Collectors.joining(", "));
    }
}
