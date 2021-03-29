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


    @AfterAll
    public static void after_all_tests_message(){
        System.out.println("This is End of Unit Test for NorthWestern Mutual interview assignment");
    }

}
