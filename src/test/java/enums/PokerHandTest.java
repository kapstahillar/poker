package enums;

import junit.framework.TestCase;
import models.Card;
import models.Hand;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PokerHandTest extends TestCase {

    @Test
    public void testGetValue() throws Exception {
        assertEquals(10, PokerHand.ROYAL_FLUSH.getRank());
    }

    @Test
    public void testGetRank() throws Exception {
        assertEquals("Royal Flush", PokerHand.ROYAL_FLUSH.getValue());
    }

    @Test
    public void testRoyalFlushMatches() throws Exception {

        List<Card> hand = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.ACE));
                add(new Card(Suit.DIAMONDS, Rank.KING));
                add(new Card(Suit.DIAMONDS, Rank.QUEEN));
                add(new Card(Suit.DIAMONDS, Rank.JACK));
                add(new Card(Suit.DIAMONDS, Rank.TEN));
            }
        };

        assertTrue(PokerHand.ROYAL_FLUSH.matches(new Hand(hand)));
    }

    @Test
    public void testStraightFlushMatches() throws Exception {

        List<Card> hand = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.TEN));
                add(new Card(Suit.DIAMONDS, Rank.NINE));
                add(new Card(Suit.DIAMONDS, Rank.EIGHT));
                add(new Card(Suit.DIAMONDS, Rank.SEVEN));
                add(new Card(Suit.DIAMONDS, Rank.SIX));
            }
        };

        assertTrue(PokerHand.STRAIGHT_FLUSH.matches(new Hand(hand)));
    }

    @Test
    public void testFourOfAKindMatches() throws Exception {

        List<Card> hand = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.ACE));
                add(new Card(Suit.DIAMONDS, Rank.ACE));
                add(new Card(Suit.SPADES, Rank.ACE));
                add(new Card(Suit.CLUBS, Rank.ACE));
                add(new Card(Suit.HEARTS, Rank.TWO));
            }
        };

        assertTrue(PokerHand.FOUR_OF_A_KIND.matches(new Hand(hand)));
    }

    @Test
    public void testFullHouse() throws Exception {

        List<Card> hand = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.ACE));
                add(new Card(Suit.DIAMONDS, Rank.ACE));
                add(new Card(Suit.SPADES, Rank.ACE));
                add(new Card(Suit.CLUBS, Rank.KING));
                add(new Card(Suit.HEARTS, Rank.KING));
            }
        };

        assertTrue(PokerHand.FULL_HOUSE.matches(new Hand(hand)));
    }

    @Test
    public void testFlush() throws Exception {

        List<Card> hand = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.TEN));
                add(new Card(Suit.DIAMONDS, Rank.EIGHT));
                add(new Card(Suit.DIAMONDS, Rank.SIX));
                add(new Card(Suit.DIAMONDS, Rank.FOUR));
                add(new Card(Suit.DIAMONDS, Rank.TWO));
            }
        };

        assertTrue(PokerHand.FLUSH.matches(new Hand(hand)));
    }

    @Test
    public void testStraight() throws Exception {

        List<Card> hand = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.TEN));
                add(new Card(Suit.HEARTS, Rank.NINE));
                add(new Card(Suit.SPADES, Rank.EIGHT));
                add(new Card(Suit.CLUBS, Rank.SEVEN));
                add(new Card(Suit.DIAMONDS, Rank.SIX));
            }
        };

        assertTrue(PokerHand.STRAIGHT.matches(new Hand(hand)));
    }

    @Test
    public void testThreeOfAKind() throws Exception {

        List<Card> hand = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.THREE));
                add(new Card(Suit.CLUBS, Rank.THREE));
                add(new Card(Suit.SPADES, Rank.THREE));
                add(new Card(Suit.DIAMONDS, Rank.TWO));
                add(new Card(Suit.HEARTS, Rank.FOUR));
            }
        };

        assertTrue(PokerHand.THREE_OF_A_KIND.matches(new Hand(hand)));
    }

    @Test
    public void testTwoPairs() throws Exception {

        List<Card> hand = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.THREE));
                add(new Card(Suit.CLUBS, Rank.THREE));
                add(new Card(Suit.SPADES, Rank.FOUR));
                add(new Card(Suit.DIAMONDS, Rank.TWO));
                add(new Card(Suit.HEARTS, Rank.TWO));
            }
        };

        assertTrue(PokerHand.TWO_PAIRS.matches(new Hand(hand)));
    }

    @Test
    public void testOnePair() throws Exception {

        List<Card> hand = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.THREE));
                add(new Card(Suit.CLUBS, Rank.THREE));
                add(new Card(Suit.SPADES, Rank.FOUR));
                add(new Card(Suit.DIAMONDS, Rank.TWO));
                add(new Card(Suit.HEARTS, Rank.FIVE));
            }
        };

        assertTrue(PokerHand.ONE_PAIR.matches(new Hand(hand)));
    }

    @Test
    public void testHighCard() throws Exception {

        List<Card> hand = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.KING));
                add(new Card(Suit.CLUBS, Rank.TEN));
                add(new Card(Suit.SPADES, Rank.NINE));
                add(new Card(Suit.DIAMONDS, Rank.EIGHT));
                add(new Card(Suit.HEARTS, Rank.SEVEN));
            }
        };

        assertTrue(PokerHand.HIGH_CARD.matches(new Hand(hand)));
    }
    
}