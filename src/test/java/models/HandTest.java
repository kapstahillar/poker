package models;

import enums.Rank;
import enums.Suit;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HandTest extends TestCase {

    @Test
    public void testCompare() throws Exception {

        List<Card> cards1 = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.TEN));
                add(new Card(Suit.DIAMONDS, Rank.NINE));
                add(new Card(Suit.DIAMONDS, Rank.EIGHT));
                add(new Card(Suit.DIAMONDS, Rank.SEVEN));
                add(new Card(Suit.DIAMONDS, Rank.SIX));
            }
        };

        List<Card> cards2 = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.KING));
                add(new Card(Suit.CLUBS, Rank.TEN));
                add(new Card(Suit.SPADES, Rank.NINE));
                add(new Card(Suit.DIAMONDS, Rank.EIGHT));
                add(new Card(Suit.HEARTS, Rank.SEVEN));
            }
        };

        Hand hand1 = new Hand(cards1);
        Hand hand2 = new Hand(cards2);

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void testRoyalFlushTie() throws Exception {

        List<Card> cards1 = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.ACE));
                add(new Card(Suit.DIAMONDS, Rank.QUEEN));
                add(new Card(Suit.DIAMONDS, Rank.KING));
                add(new Card(Suit.DIAMONDS, Rank.JACK));
                add(new Card(Suit.DIAMONDS, Rank.TEN));
            }
        };

        List<Card> cards2 = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.ACE));
                add(new Card(Suit.HEARTS, Rank.QUEEN));
                add(new Card(Suit.HEARTS, Rank.KING));
                add(new Card(Suit.HEARTS, Rank.JACK));
                add(new Card(Suit.HEARTS, Rank.TEN));
            }
        };

        Hand hand1 = new Hand(cards1);
        Hand hand2 = new Hand(cards2);

        assertEquals(0, hand1.compareTo(hand2));
    }


    @Test
    public void testStraightFlushTie() throws Exception {

        List<Card> cards1 = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.KING));
                add(new Card(Suit.HEARTS, Rank.QUEEN));
                add(new Card(Suit.HEARTS, Rank.JACK));
                add(new Card(Suit.HEARTS, Rank.TEN));
                add(new Card(Suit.HEARTS, Rank.NINE));
            }
        };

        List<Card> cards2 = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.TEN));
                add(new Card(Suit.DIAMONDS, Rank.NINE));
                add(new Card(Suit.DIAMONDS, Rank.EIGHT));
                add(new Card(Suit.DIAMONDS, Rank.SEVEN));
                add(new Card(Suit.DIAMONDS, Rank.SIX));
            }
        };

        Hand hand1 = new Hand(cards1);
        Hand hand2 = new Hand(cards2);

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void testFourOfAKindTie1() throws Exception {

        List<Card> cards1 = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.ACE));
                add(new Card(Suit.DIAMONDS, Rank.ACE));
                add(new Card(Suit.CLUBS, Rank.ACE));
                add(new Card(Suit.SPADES, Rank.ACE));
                add(new Card(Suit.DIAMONDS, Rank.KING));
            }
        };

        List<Card> cards2 = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.KING));
                add(new Card(Suit.DIAMONDS, Rank.KING));
                add(new Card(Suit.CLUBS, Rank.KING));
                add(new Card(Suit.SPADES, Rank.KING));
                add(new Card(Suit.DIAMONDS, Rank.JACK));
            }
        };

        Hand hand1 = new Hand(cards1);
        Hand hand2 = new Hand(cards2);

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void testFourOfAKindTie2() throws Exception {

        List<Card> cards1 = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.THREE));
                add(new Card(Suit.DIAMONDS, Rank.THREE));
                add(new Card(Suit.CLUBS, Rank.THREE));
                add(new Card(Suit.SPADES, Rank.THREE));
                add(new Card(Suit.DIAMONDS, Rank.ACE));
            }
        };

        List<Card> cards2 = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.THREE));
                add(new Card(Suit.DIAMONDS, Rank.THREE));
                add(new Card(Suit.CLUBS, Rank.THREE));
                add(new Card(Suit.SPADES, Rank.THREE));
                add(new Card(Suit.DIAMONDS, Rank.JACK));
            }
        };

        Hand hand1 = new Hand(cards1);
        Hand hand2 = new Hand(cards2);

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void testFullHouseTie1() throws Exception {

        List<Card> cards1 = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.ACE));
                add(new Card(Suit.DIAMONDS, Rank.ACE));
                add(new Card(Suit.CLUBS, Rank.ACE));
                add(new Card(Suit.SPADES, Rank.NINE));
                add(new Card(Suit.HEARTS, Rank.NINE));
            }
        };

        List<Card> cards2 = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.ACE));
                add(new Card(Suit.DIAMONDS, Rank.ACE));
                add(new Card(Suit.CLUBS, Rank.ACE));
                add(new Card(Suit.SPADES, Rank.EIGHT));
                add(new Card(Suit.HEARTS, Rank.EIGHT));
            }
        };

        Hand hand1 = new Hand(cards1);
        Hand hand2 = new Hand(cards2);

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void testFullHouseTie2() throws Exception {

        List<Card> cards1 = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.TEN));
                add(new Card(Suit.DIAMONDS, Rank.TEN));
                add(new Card(Suit.CLUBS, Rank.TEN));
                add(new Card(Suit.SPADES, Rank.ACE));
                add(new Card(Suit.HEARTS, Rank.ACE));
            }
        };

        List<Card> cards2 = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.TEN));
                add(new Card(Suit.DIAMONDS, Rank.TEN));
                add(new Card(Suit.CLUBS, Rank.TEN));
                add(new Card(Suit.SPADES, Rank.KING));
                add(new Card(Suit.HEARTS, Rank.KING));
            }
        };

        Hand hand1 = new Hand(cards1);
        Hand hand2 = new Hand(cards2);

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void testFlushTie() throws Exception {

        List<Card> cards1 = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.ACE));
                add(new Card(Suit.DIAMONDS, Rank.KING));
                add(new Card(Suit.DIAMONDS, Rank.JACK));
                add(new Card(Suit.DIAMONDS, Rank.THREE));
                add(new Card(Suit.DIAMONDS, Rank.SIX));
            }
        };

        List<Card> cards2 = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.ACE));
                add(new Card(Suit.HEARTS, Rank.KING));
                add(new Card(Suit.HEARTS, Rank.EIGHT));
                add(new Card(Suit.HEARTS, Rank.THREE));
                add(new Card(Suit.HEARTS, Rank.SIX));
            }
        };

        Hand hand1 = new Hand(cards1);
        Hand hand2 = new Hand(cards2);

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void testStraight() throws Exception {

        List<Card> cards1 = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.KING));
                add(new Card(Suit.HEARTS, Rank.QUEEN));
                add(new Card(Suit.CLUBS, Rank.JACK));
                add(new Card(Suit.HEARTS, Rank.TEN));
                add(new Card(Suit.SPADES, Rank.NINE));
            }
        };

        List<Card> cards2 = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.TEN));
                add(new Card(Suit.SPADES, Rank.NINE));
                add(new Card(Suit.DIAMONDS, Rank.EIGHT));
                add(new Card(Suit.DIAMONDS, Rank.SEVEN));
                add(new Card(Suit.CLUBS, Rank.SIX));
            }
        };

        Hand hand1 = new Hand(cards1);
        Hand hand2 = new Hand(cards2);

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void testThreeOfAKind1() throws Exception {

        List<Card> cards1 = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.KING));
                add(new Card(Suit.HEARTS, Rank.KING));
                add(new Card(Suit.CLUBS, Rank.KING));
                add(new Card(Suit.HEARTS, Rank.TEN));
                add(new Card(Suit.SPADES, Rank.NINE));
            }
        };

        List<Card> cards2 = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.QUEEN));
                add(new Card(Suit.SPADES, Rank.QUEEN));
                add(new Card(Suit.DIAMONDS, Rank.QUEEN));
                add(new Card(Suit.DIAMONDS, Rank.SEVEN));
                add(new Card(Suit.CLUBS, Rank.SIX));
            }
        };

        Hand hand1 = new Hand(cards1);
        Hand hand2 = new Hand(cards2);

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void testThreeOfAKind2() throws Exception {

        List<Card> cards1 = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.KING));
                add(new Card(Suit.HEARTS, Rank.KING));
                add(new Card(Suit.CLUBS, Rank.KING));
                add(new Card(Suit.HEARTS, Rank.TEN));
                add(new Card(Suit.SPADES, Rank.NINE));
            }
        };

        List<Card> cards2 = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.KING));
                add(new Card(Suit.SPADES, Rank.KING));
                add(new Card(Suit.DIAMONDS, Rank.KING));
                add(new Card(Suit.DIAMONDS, Rank.SEVEN));
                add(new Card(Suit.CLUBS, Rank.SIX));
            }
        };

        Hand hand1 = new Hand(cards1);
        Hand hand2 = new Hand(cards2);

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void testTwoPairs1() throws Exception {

        List<Card> cards1 = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.KING));
                add(new Card(Suit.HEARTS, Rank.KING));
                add(new Card(Suit.CLUBS, Rank.QUEEN));
                add(new Card(Suit.HEARTS, Rank.QUEEN));
                add(new Card(Suit.SPADES, Rank.NINE));
            }
        };

        List<Card> cards2 = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.KING));
                add(new Card(Suit.SPADES, Rank.KING));
                add(new Card(Suit.DIAMONDS, Rank.QUEEN));
                add(new Card(Suit.DIAMONDS, Rank.SEVEN));
                add(new Card(Suit.CLUBS, Rank.SIX));
            }
        };

        Hand hand1 = new Hand(cards1);
        Hand hand2 = new Hand(cards2);

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void testTwoPairs2() throws Exception {

        List<Card> cards1 = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.KING));
                add(new Card(Suit.HEARTS, Rank.KING));
                add(new Card(Suit.CLUBS, Rank.QUEEN));
                add(new Card(Suit.HEARTS, Rank.QUEEN));
                add(new Card(Suit.SPADES, Rank.NINE));
            }
        };

        List<Card> cards2 = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.KING));
                add(new Card(Suit.SPADES, Rank.KING));
                add(new Card(Suit.DIAMONDS, Rank.JACK));
                add(new Card(Suit.DIAMONDS, Rank.JACK));
                add(new Card(Suit.CLUBS, Rank.SIX));
            }
        };

        Hand hand1 = new Hand(cards1);
        Hand hand2 = new Hand(cards2);

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void testOnePair1() throws Exception {

        List<Card> cards1 = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.KING));
                add(new Card(Suit.HEARTS, Rank.KING));
                add(new Card(Suit.CLUBS, Rank.EIGHT));
                add(new Card(Suit.HEARTS, Rank.QUEEN));
                add(new Card(Suit.SPADES, Rank.NINE));
            }
        };

        List<Card> cards2 = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.KING));
                add(new Card(Suit.SPADES, Rank.KING));
                add(new Card(Suit.DIAMONDS, Rank.TEN));
                add(new Card(Suit.DIAMONDS, Rank.JACK));
                add(new Card(Suit.CLUBS, Rank.SIX));
            }
        };

        Hand hand1 = new Hand(cards1);
        Hand hand2 = new Hand(cards2);

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void testHighCardTie1() throws Exception {

        List<Card> cards1 = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.TEN));
                add(new Card(Suit.SPADES, Rank.EIGHT));
                add(new Card(Suit.DIAMONDS, Rank.FIVE));
                add(new Card(Suit.DIAMONDS, Rank.SEVEN));
                add(new Card(Suit.DIAMONDS, Rank.KING));
            }
        };

        List<Card> cards2 = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.QUEEN));
                add(new Card(Suit.CLUBS, Rank.TEN));
                add(new Card(Suit.SPADES, Rank.NINE));
                add(new Card(Suit.DIAMONDS, Rank.EIGHT));
                add(new Card(Suit.HEARTS, Rank.SEVEN));
            }
        };

        Hand hand1 = new Hand(cards1);
        Hand hand2 = new Hand(cards2);

        assertEquals(1, hand1.compareTo(hand2));
    }

    @Test
    public void testHighCardTie2() throws Exception {

        List<Card> cards1 = new ArrayList<Card>() {
            {
                add(new Card(Suit.DIAMONDS, Rank.ACE));
                add(new Card(Suit.SPADES, Rank.JACK));
                add(new Card(Suit.DIAMONDS, Rank.TEN));
                add(new Card(Suit.DIAMONDS, Rank.SEVEN));
                add(new Card(Suit.DIAMONDS, Rank.FOUR));
            }
        };

        List<Card> cards2 = new ArrayList<Card>() {
            {
                add(new Card(Suit.HEARTS, Rank.ACE));
                add(new Card(Suit.CLUBS, Rank.JACK));
                add(new Card(Suit.SPADES, Rank.TEN));
                add(new Card(Suit.DIAMONDS, Rank.SEVEN));
                add(new Card(Suit.HEARTS, Rank.FOUR));
            }
        };

        Hand hand1 = new Hand(cards1);
        Hand hand2 = new Hand(cards2);

        assertEquals(0, hand1.compareTo(hand2));
    }

}