package pools;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class CardDeckTest extends TestCase{

    private CardDeck cd;

    @Before
    public void setUp() throws Exception {
        cd = new CardDeck();
    }

    @Test
    public void testGetRandomCards() throws Exception {
        assertEquals(5, cd.getRandomCards(5).size());
    }

}