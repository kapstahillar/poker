package analyzers;

import enums.PokerHand;
import models.Card;
import models.Hand;
import models.MatchData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * PokerHandAnalyzer consists of static methods that retrieves MatchData.
 */
public class PokerHandAnalyzer {

    /**
     *  Returns a MatchData object that holds info of matched elements with their
     *  corresponding rankings.
     *
     *  Uses getDefaultMatchData that retrieves MatchData with list of all ranks in hand.
     *
     *  Returns null if hand does not exist or card count in hand is not 5
     *
     * @param hand hand that consists of 5 cards in a list
     * @return matchData with list of Royal flush matched ranks
     */
    public static  MatchData getRoyalFlushMatchData(Hand hand) {

        if (hand == null  || hand.getCards().size() != 5) {
            return null;
        }

        MatchData md = getDefaultMatchData(hand);
        md.setMatch(PokerHand.ROYAL_FLUSH);

        return md;
    }

    /**
     *  Returns a MatchData object that holds info of matched elements with their
     *  corresponding rankings.
     *
     *  Uses getDefaultMatchData that retrieves MatchData with list of all ranks in hand.
     *
     *  Returns null if hand does not exist or card count in hand is not 5
     *
     * @param hand hand that consists of 5 cards in a list
     * @return matchData with list of Straight flush matched ranks
     */
    public static  MatchData getStraightFlushMatchData(Hand hand) {

        if (hand == null  || hand.getCards().size() != 5) {
            return null;
        }

        MatchData md = getDefaultMatchData(hand);
        md.setMatch(PokerHand.STRAIGHT_FLUSH);

        return md;
    }

    /**
     *  Returns a MatchData object that holds info of matched elements with their
     *  corresponding rankings.
     *
     *  Gets rank count from Hand cards and then get rank where it occurred 4 times. Four of a kind rank
     *  is added to the rankingList. If this rank is added to rankingList then adds others ranks
     *  of cards to rankingList in descending order.
     *
     *  Returns null if hand does not exist or card count in hand is not 5
     *
     * @param hand hand that consists of 5 cards in a list
     * @return matchData with list of Four of a kind matched ranks
     */
    public static  MatchData getFourOfAKindMatchData(Hand hand) {

        if (hand == null  || hand.getCards().size() != 5) {
            return null;
        }

        MatchData md = new MatchData();

        List<Integer> rankingList = new ArrayList<>();

        Map<Integer, Long> countMap = hand.getCards().stream().collect(Collectors.groupingBy(
                Card::getRankValue, Collectors.counting()));

        Integer fourOfAKindRank =  countMap.entrySet().stream()
                .filter(e -> e.getValue() == 4)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        List<Integer> otherRanks = countMap.entrySet().stream()
                .filter(e -> e.getValue() != 4)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        otherRanks.sort((r1, r2) -> r2 - r1);

        rankingList.add(fourOfAKindRank);
        rankingList.addAll(otherRanks);
        md.setRankingList(rankingList);
        md.setMatch(PokerHand.FOUR_OF_A_KIND);

        return md;
    }

    /**
     *  Returns a MatchData object that holds info of matched elements with their
     *  corresponding rankings.
     *
     *  Gets rank count of house's roof and house's body. First adds house's three of a kind to rankingList
     *  and then adds a pair to rankingList.
     *
     *  Returns null if hand does not exist or card count in hand is not 5
     *
     * @param hand hand that consists of 5 cards in a list
     * @return matchData with list of Full house matched ranks
     */
    public static MatchData getFullHouseMatchData(Hand hand) {

        if (hand == null  || hand.getCards().size() != 5) {
            return null;
        }

        MatchData md = new MatchData();
        List<Integer> rankingList = new ArrayList<>();

        Map<Integer, Long> countMap = hand.getCards().stream().collect(Collectors.groupingBy(
                Card::getRankValue, Collectors.counting()));

        Integer threeOfAKindRank =  countMap.entrySet().stream()
                .filter(e -> e.getValue() == 3)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        Integer pairRank =  countMap.entrySet().stream()
                .filter(e -> e.getValue() == 2)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        rankingList.add(threeOfAKindRank);
        rankingList.add(pairRank);
        md.setRankingList(rankingList);
        md.setMatch(PokerHand.FULL_HOUSE);

        return md;
    }

    /**
     *  Returns a MatchData object that holds info of matched elements with their
     *  corresponding rankings.
     *
     *  Uses getDefaultMatchData that retrieves MatchData with list of all ranks in hand.
     *
     *  Returns null if hand does not exist or card count in hand is not 5
     *
     * @param hand hand that consists of 5 cards in a list
     * @return matchData with list of Flush matched ranks
     */
    public static  MatchData getFlushMatchData(Hand hand) {

        if (hand == null  || hand.getCards().size() != 5) {
            return null;
        }

        MatchData md = getDefaultMatchData(hand);
        md.setMatch(PokerHand.FLUSH);

        return md;
    }

    /**
     *  Returns a MatchData object that holds info of matched elements with their
     *  corresponding rankings.
     *
     *  Uses getDefaultMatchData that retrieves MatchData with list of all ranks in hand.
     *
     *  Returns null if hand does not exist or card count in hand is not 5
     *
     * @param hand hand that consists of 5 cards in a list
     * @return matchData with list of Straight matched ranks
     */
    public static  MatchData getStraightMatchData(Hand hand) {

        if (hand == null  || hand.getCards().size() != 5) {
            return null;
        }
        MatchData md = getDefaultMatchData(hand);
        md.setMatch(PokerHand.STRAIGHT);

        return md;
    }

    /**
     *  Returns a MatchData object that holds info of matched elements with their
     *  corresponding rankings.
     *
     *  Gets count of ranks occurring hand adds three of kind to rankingList. If three of a kind is
     *  added to rankingList then other ranks are added to list in descending order.
     *
     *  Returns null if hand does not exist or card count in hand is not 5
     *
     * @param hand hand that consists of 5 cards in a list
     * @return matchData with list of Three of a kind matched ranks
     */
    public static  MatchData getThreeOfAKindMatchData(Hand hand) {

        if (hand == null || hand.getCards().size() != 5) {
            return null;
        }

        MatchData md = new MatchData();
        List<Integer> rankingList = new ArrayList<>();

        Map<Integer, Long> countMap = hand.getCards().stream().collect(Collectors.groupingBy(
                Card::getRankValue, Collectors.counting()));

        Integer threeOfAKindRank = countMap.entrySet().stream()
                .filter(e -> e.getValue() == 3)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        List<Integer> otherRanks = countMap.entrySet().stream()
                .filter(e -> e.getValue() != 4)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        otherRanks.sort((r1, r2) -> r2 - r1);

        rankingList.add(threeOfAKindRank);
        rankingList.addAll(otherRanks);
        md.setRankingList(rankingList);
        md.setMatch(PokerHand.THREE_OF_A_KIND);

        return md;
    }

    /**
     *  Returns a MatchData object that holds info of matched elements with their
     *  corresponding rankings.
     *
     *  Gets count of ranks occurring in hand. Gets ranks that occur 2 times and adds them rankingList.
     *  If ranks are added to rankingList, then adds remaining rank to rankingList.
     *
     *  Returns null if hand does not exist or card count in hand is not 5
     *
     * @param hand hand that consists of 5 cards in a list
     * @return matchData with list of two pairs matched ranks
     */
    public static  MatchData getTwoPairsMatchData(Hand hand) {

        if (hand == null  || hand.getCards().size() != 5) {
            return null;
        }

        MatchData md = new MatchData();
        List<Integer> rankingList = new ArrayList<>();

        Map<Integer, Long> countMap = hand.getCards().stream().collect(Collectors.groupingBy(
                Card::getRankValue, Collectors.counting()));

        List<Integer> pairRanks = countMap.entrySet().stream()
                .filter(e -> e.getValue() == 2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Integer> otherRanks = countMap.entrySet().stream()
                .filter(e -> e.getValue() != 2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        pairRanks.sort((r1, r2) -> r2 - r1);
        otherRanks.sort((r1, r2) -> r2 - r1);

        rankingList.addAll(pairRanks);
        rankingList.addAll(otherRanks);

        md.setRankingList(rankingList);
        md.setMatch(PokerHand.TWO_PAIRS);

        return md;
    }

    /**
     *  Returns a MatchData object that holds info of matched elements with their
     *  corresponding rankings.
     *
     *  Gets count of ranks occurring in hand. Gets rank that occurs 1 time and adds it to rankingList.
     *  If rank is added to rankingList, then adds remaining ranks to rankingList in descending order.
     *
     *  Returns null if hand does not exist or card count in hand is not 5
     *
     * @param hand hand that consists of 5 cards in a list
     * @return matchData with one pair matched ranks
     */
    public static  MatchData getOnePairMatchData(Hand hand) {

        if (hand == null  || hand.getCards().size() != 5) {
            return null;
        }

        MatchData md = new MatchData();
        List<Integer> rankingList = new ArrayList<>();

        Map<Integer, Long> countMap = hand.getCards().stream().collect(Collectors.groupingBy(
                Card::getRankValue, Collectors.counting()));

        Integer pairRank = countMap.entrySet().stream()
                .filter(e -> e.getValue() == 2)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        List<Integer> otherRanks = countMap.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        otherRanks.sort((r1, r2) -> r2 - r1);

        rankingList.add(pairRank);
        rankingList.addAll(otherRanks);

        md.setRankingList(rankingList);
        md.setMatch(PokerHand.ONE_PAIR);

        return md;
    }

    /**
     *  Returns a MatchData object that holds info of matched elements with their
     *  corresponding rankings.
     *
     *  Uses default method to add items to rankingList. Adds all ranks to rankingList in descending order.
     *
     *  Returns null if hand does not exist or card count in hand is not 5
     *
     * @param hand hand that consists of 5 cards in a list
     * @return matchData high card ranks
     */
    public static  MatchData getHighCardMatchData(Hand hand) {

        if (hand == null  || hand.getCards().size() != 5) {
            return null;
        }

        MatchData md = getDefaultMatchData(hand);
        md.setMatch(PokerHand.HIGH_CARD);

        return md;
    }

    /**
     *  Default getter for matchData in PokerHandAnalzyer class
     *
     *  Returns a MatchData object that holds info of matched elements with their
     *  corresponding rankings.
     *
     *  Adds all ranks to rankingList in descending order.
     *
     *  Returns null if hand does not exist or card count in hand is not 5
     *
     * @param hand hand that consists of 5 cards in a list
     * @return matchData with all card rankings in descending order
     */
    private static  MatchData getDefaultMatchData(Hand hand) {

        if (hand == null  || hand.getCards().size() != 5) {
            return null;
        }

        MatchData md = new MatchData();

        List<Integer> rankingList = hand.getCards().stream()
                .map(Card::getRankValue)
                .collect(Collectors.toList());

        rankingList.sort((r1, r2) -> r2 - r1);
        md.setRankingList(rankingList);

        return md;
    }
}
