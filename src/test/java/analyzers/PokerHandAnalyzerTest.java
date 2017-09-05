package analyzers;

import enums.PokerHand;
import enums.Rank;
import enums.Suit;
import junit.framework.TestCase;
import models.Card;
import models.Hand;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PokerHandAnalyzerTest extends TestCase {

    @Test
    public void testGetRoyalFlushMatchData() throws Exception {
        List<Card> cards = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.ACE));
                add(new Card(Suit.DIAMONDS, Rank.KING));
                add(new Card(Suit.DIAMONDS, Rank.QUEEN));
                add(new Card(Suit.DIAMONDS, Rank.JACK));
                add(new Card(Suit.DIAMONDS, Rank.TEN));
            }
        };

        Hand hand = new Hand(cards);
        assertTrue(PokerHandAnalyzer.getRoyalFlushMatchData(hand).getMatch() == PokerHand.ROYAL_FLUSH);
    }

    @Test
    public void testGetStraightFlushMatchData() throws Exception {
        List<Card> cards = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.TEN));
                add(new Card(Suit.DIAMONDS, Rank.NINE));
                add(new Card(Suit.DIAMONDS, Rank.EIGHT));
                add(new Card(Suit.DIAMONDS, Rank.SEVEN));
                add(new Card(Suit.DIAMONDS, Rank.SIX));
            }
        };

        Hand hand = new Hand(cards);
        assertTrue(PokerHandAnalyzer.getStraightFlushMatchData(hand).getMatch() == PokerHand.STRAIGHT_FLUSH);
    }

    @Test
    public void testGetFourOfAKindMatchData() throws Exception {
        List<Card> cards = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.ACE));
                add(new Card(Suit.DIAMONDS, Rank.ACE));
                add(new Card(Suit.SPADES, Rank.ACE));
                add(new Card(Suit.CLUBS, Rank.ACE));
                add(new Card(Suit.HEARTS, Rank.TWO));
            }
        };

        Hand hand = new Hand(cards);
        assertTrue(PokerHandAnalyzer.getFourOfAKindMatchData(hand).getMatch() == PokerHand.FOUR_OF_A_KIND);
    }

    @Test
    public void testGetFullHouseMatchData() throws Exception {

        List<Card> cards = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.ACE));
                add(new Card(Suit.DIAMONDS, Rank.ACE));
                add(new Card(Suit.SPADES, Rank.ACE));
                add(new Card(Suit.CLUBS, Rank.KING));
                add(new Card(Suit.HEARTS, Rank.KING));
            }
        };

        Hand hand = new Hand(cards);
        assertTrue(PokerHandAnalyzer.getFullHouseMatchData(hand).getMatch() == PokerHand.FULL_HOUSE);
    }

    @Test
    public void testGetFlushMatchData() throws Exception {

        List<Card> cards = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.TEN));
                add(new Card(Suit.DIAMONDS, Rank.EIGHT));
                add(new Card(Suit.DIAMONDS, Rank.SIX));
                add(new Card(Suit.DIAMONDS, Rank.FOUR));
                add(new Card(Suit.DIAMONDS, Rank.TWO));
            }
        };

        Hand hand = new Hand(cards);
        assertTrue(PokerHandAnalyzer.getFlushMatchData(hand).getMatch() == PokerHand.FLUSH);
    }

    @Test
    public void testGetStraightMatchData() throws Exception {

        List<Card> cards = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.TEN));
                add(new Card(Suit.HEARTS, Rank.NINE));
                add(new Card(Suit.SPADES, Rank.EIGHT));
                add(new Card(Suit.CLUBS, Rank.SEVEN));
                add(new Card(Suit.DIAMONDS, Rank.SIX));
            }
        };

        Hand hand = new Hand(cards);
        assertTrue(PokerHandAnalyzer.getStraightMatchData(hand).getMatch() == PokerHand.STRAIGHT);
    }

    @Test
    public void testGetThreeOfAKindMatchData() throws Exception {

        List<Card> cards = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.THREE));
                add(new Card(Suit.CLUBS, Rank.THREE));
                add(new Card(Suit.SPADES, Rank.THREE));
                add(new Card(Suit.DIAMONDS, Rank.TWO));
                add(new Card(Suit.HEARTS, Rank.FOUR));
            }
        };

        Hand hand = new Hand(cards);

        System.out.println(PokerHandAnalyzer.getThreeOfAKindMatchData(hand).getMatch());
        assertTrue(PokerHandAnalyzer.getThreeOfAKindMatchData(hand).getMatch() == PokerHand.THREE_OF_A_KIND);
    }

    @Test
    public void testGetTwoPairsMatchData() throws Exception {

        List<Card> cards = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.THREE));
                add(new Card(Suit.CLUBS, Rank.THREE));
                add(new Card(Suit.SPADES, Rank.FOUR));
                add(new Card(Suit.DIAMONDS, Rank.TWO));
                add(new Card(Suit.HEARTS, Rank.TWO));
            }
        };

        Hand hand = new Hand(cards);
        assertTrue(PokerHandAnalyzer.getTwoPairsMatchData(hand).getMatch() == PokerHand.TWO_PAIRS);
    }

    @Test
    public void testGetOnePairMatchData() throws Exception {

        List<Card> cards = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.THREE));
                add(new Card(Suit.CLUBS, Rank.THREE));
                add(new Card(Suit.SPADES, Rank.FOUR));
                add(new Card(Suit.DIAMONDS, Rank.TWO));
                add(new Card(Suit.HEARTS, Rank.FIVE));
            }
        };

        Hand hand = new Hand(cards);
        assertTrue(PokerHandAnalyzer.getOnePairMatchData(hand).getMatch() == PokerHand.ONE_PAIR);
    }

    @Test
    public void testGetHighCardMatchData() throws Exception {

        List<Card> cards = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.KING));
                add(new Card(Suit.CLUBS, Rank.TEN));
                add(new Card(Suit.SPADES, Rank.NINE));
                add(new Card(Suit.DIAMONDS, Rank.EIGHT));
                add(new Card(Suit.HEARTS, Rank.SEVEN));
            }
        };

        Hand hand = new Hand(cards);
        assertTrue(PokerHandAnalyzer.getHighCardMatchData(hand).getMatch() == PokerHand.HIGH_CARD);
    }
}