package NWMutual.CardShuffle;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UnitTests {

    @BeforeAll
    public static void before_all_tests_message(){
        System.out.println("This is Unit Test for NorthWestern Mutual interview assignment");
    }

    @Test
    public void check_number_of_cards_in_an_initial_deck(){
        int numberOfCardsInDeck = 52;
        int actual = Card.InitialDeck.size();

        Assert.assertEquals(numberOfCardsInDeck, actual);
    }

    @Test
    public void new_deck_equals_initial_deck(){
        ArrayList<Card> newDeck = Card.newDeck();
        ArrayList<Card> initialDeck = (ArrayList<Card>) Card.InitialDeck;

        Assert.assertEquals(newDeck, initialDeck);

    }

    @Test
    public void dealing_correct_number_of_cards_to_players(){
        int numberOfPlayers2 = 2;
        int numberOfPlayers3 = 3;
        int numberOfPlayers4 = 4;
        int numberOfPlayers5 = 5;
        int numberOfPlayers6 = 6;
        int numberOfPlayers7 = 7;

        int expectedResult2 = 26;
        int expectedResult3 = 17;
        int expectedResult4 = 13;
        int expectedResult5 = 10;
        int expectedResult6 = 8;
        int expectedResult7 = 7;

        int actualResult2 = Card.dealingTheDeck(Card.newDeck(), numberOfPlayers2).size();
        int actualResult3 = Card.dealingTheDeck(Card.newDeck(), numberOfPlayers3).size();
        int actualResult4 = Card.dealingTheDeck(Card.newDeck(), numberOfPlayers4).size();
        int actualResult5 = Card.dealingTheDeck(Card.newDeck(), numberOfPlayers5).size();
        int actualResult6 = Card.dealingTheDeck(Card.newDeck(), numberOfPlayers6).size();
        int actualResult7 = Card.dealingTheDeck(Card.newDeck(), numberOfPlayers7).size();

        Assert.assertEquals(expectedResult2, actualResult2);
        Assert.assertEquals(expectedResult3, actualResult3);
        Assert.assertEquals(expectedResult4, actualResult4);
        Assert.assertEquals(expectedResult5, actualResult5);
        Assert.assertEquals(expectedResult6, actualResult6);
        Assert.assertEquals(expectedResult7, actualResult7);

    }

    @AfterAll
    public static void after_all_tests_message(){
        System.out.println("This is End of Unit Test for NorthWestern Mutual interview assignment");
    }

}
