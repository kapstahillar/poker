package models;

import enums.PokerHand;

import java.util.List;

/**
 * Model of Matched Data of PokerHandAnalzyer that has info of matches
 * PokerHand rank and list of ranks in descending order.
 * @see analyzers.PokerHandAnalyzer
 */
public class MatchData {

    private List<Integer> rankingList;
    private PokerHand match;

    /**
     * @return rankingList of integers in descending order.
     */
    public List<Integer> getRankingList() {
        return rankingList;
    }

    /**
     * Sets rankingList of this model
     * @param rankingList list of card ranks hopefully in descending order.
     */
    public void setRankingList(List<Integer> rankingList) {
        this.rankingList = rankingList;
    }

    /**
     * @return gets matched PokerHand
     */
    public PokerHand getMatch() {
        return match;
    }

    /**
     * @param match sets matching PokerHand
     */
    public void setMatch(PokerHand match) {
        this.match = match;
    }
}
