package NWMutual.CardShuffle;

import java.util.*;

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

    public static ArrayList<Card> newDeck(){
        return new ArrayList<Card>(InitialDeck);
    }

    public static ArrayList<Card> dealingTheDeck(List<Card> deckForAGame, int numOfPlayers){

        int deckSize = deckForAGame.size();

        int cardsPerPlayer = totalNumOfCardsInADeck/numOfPlayers;

        List<Card> dealingFromDeck = deckForAGame.subList( (deckSize-cardsPerPlayer) , deckSize);

        ArrayList<Card> onPlayerHand = new ArrayList<Card>(dealingFromDeck);

        dealingFromDeck.clear();

        return onPlayerHand;
    }


    public static void main(String[] args) {

        System.out.println(InitialDeck);

        System.out.println("Please specify the number of players: ");

        Scanner scan = new Scanner(System.in);

        int numOfPlayers = scan.nextInt();

        while (numOfPlayers < 2 || numOfPlayers > 24) {

            System.out.println("Number of players must be more than 1 and less than/or equal to 23. \nPlease specify the number of players: ");
            numOfPlayers = scan.nextInt();
        }

        List<Card> deckForAGame = newDeck();

        Collections.shuffle(deckForAGame);

        for (int i = 1; i <=numOfPlayers; i++){
            System.out.println("Cards for Player " + i + " are " + dealingTheDeck(deckForAGame, numOfPlayers));
        }

    }



}
