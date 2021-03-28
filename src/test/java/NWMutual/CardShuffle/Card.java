package NWMutual.CardShuffle;

import java.util.ArrayList;
import java.util.List;

public class Card {

    static final int totalNumOfCardsInADeck = 52;

    public enum RankOfACard{ Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King}
    public enum SuitOfACard {Clubs, Diamonds, Hearts, Spades}

    private final RankOfACard rankOfACard;
    private final SuitOfACard suitOfACard;

    private Card(RankOfACard rankOfACard, SuitOfACard suitOfACard){
        this.rankOfACard = rankOfACard;
        this.suitOfACard = suitOfACard;
    }

    public String toString(){
        return rankOfACard + " " + suitOfACard;
    }

    static final List<Card> InitialDeck = new ArrayList<>();

    static {
        for (SuitOfACard suit : SuitOfACard.values()){
            for (RankOfACard rank : RankOfACard.values()) {
                InitialDeck.add(new Card(rank, suit));
            }
        }
    }







}
