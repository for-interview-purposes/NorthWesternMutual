package NWMutual.CardShuffle;

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





}
