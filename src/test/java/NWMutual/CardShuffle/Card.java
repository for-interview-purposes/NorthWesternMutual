package NWMutual.CardShuffle;

import java.util.*;

public class Card {

    // I create constant
    // that represents the number of cards in a deck = 52
    static final int totalNumOfCardsInADeck = 52;

    // As Rank of cards and Suit of cards are sets of constants and are fixed
    // for all times, we will represent them in enum type
    public enum RankOfACard{ Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King}
    public enum SuitOfACard {Clubs, Diamonds, Hearts, Spades}

    // Instance variable of Card class objects
    private final RankOfACard rankOfACard;
    private final SuitOfACard suitOfACard;

    // We generate a private constructor with two parameters:
    // 1. RankOfACard and
    // 2. SuitOfACard
    // Both are of enum type
    // This constructor creates object of Card class with those specified two parameters
    private Card(RankOfACard rankOfACard, SuitOfACard suitOfACard){
        this.rankOfACard = rankOfACard;
        this.suitOfACard = suitOfACard;
    }

    //  Method returns the String representation of Card object
    public String toString(){
        return rankOfACard + " " + suitOfACard;
    }

    // We declare and initialize an array for the object of Card class
    // We use List interface as this is a good practise - in case in the future a different
    // implementation of the List interface will need to be used
    // i.e. LinkedList or Vector
    static final List<Card> InitialDeck = new ArrayList<>();

    // Static block with for-each loops creates objects of Card class by using Constructor
    // and adds then one by one into a created array of Card-class objects
    static {
        for (SuitOfACard suit : SuitOfACard.values()){
            for (RankOfACard rank : RankOfACard.values()) {
                InitialDeck.add(new Card(rank, suit));
            }
        }
    }

    // Method returns copy of Initial deck for further shuffle and dealing
    public static ArrayList<Card> newDeck(){
        return new ArrayList<Card>(InitialDeck);
    }

    // Method returns array of Card-class objects that were distributed to the player
    // List interface is used as a parameter in case
    // later it will be decided to use i.e. LinkedList or Vector
    public static ArrayList<Card> dealingTheDeck(List<Card> deckForAGame, int numOfPlayers){

        // Number of cards in a deck (must be equal to 52)
        int deckSize = deckForAGame.size();

        // The assignment said "deal *as many* cards as possible to a number of players"
        // Number of cards in deck are divided by the number of players which is a parameter of this method
        // The result must be a whole number
        int cardsPerPlayer = totalNumOfCardsInADeck/numOfPlayers;

        // For dsitributing cards to a Player a sublist method with 2 parameters is used:
        // 1. Initial index for a Card object in the list
        // 2. Last index of a Card object in the list
        // Thus, Card-objects are distributed/dealt starting from the last Card-object in the list
        List<Card> dealingFromDeck = deckForAGame.subList( (deckSize-cardsPerPlayer) , deckSize);

        // We use ArrayList in order to be able to print out the card-objects in the array
        ArrayList<Card> onPlayerHand = new ArrayList<Card>(dealingFromDeck);

        // The ArrayList is cleared for distributing the Card to a next player
        dealingFromDeck.clear();

        // Method "dealingTheDeck" returns the cards distributed to this specific player
        return onPlayerHand;
    }


    public static void main(String[] args) {

        // Printing the initial deck before the game starts, if needed
        System.out.println(InitialDeck);

        // Program User is invited to input the number of players to console
        System.out.println("Please specify the number of players: ");

        // Get a number of players to be specified by the Program's User
        Scanner scan = new Scanner(System.in);
        int numOfPlayers = scan.nextInt();

        // As I don't play cards and don't know about the max number of players,
        // I googled and found out that there are games where max number of 23 players can take part
        // I assumed that we need at min 2 and at max 23 players to play a game
        // If number of players is less than 2 and more than 23
        // the user is asked to specify a correct number of players
        while (numOfPlayers < 2 || numOfPlayers > 23) {

            System.out.println("Number of players must be more than 1 and less than 24. \nPlease specify the number of players: ");
            numOfPlayers = scan.nextInt();
        }

        // We create a deck for a game which is a duplicate of Initial Deck
        List<Card> deckForAGame = newDeck();

        // Deck for a game is shuffled
        Collections.shuffle(deckForAGame);

        // Card objects are distributed as per the number of players specified by a User
        // and cards on hands of a player are printed
        for (int i = 1; i <=numOfPlayers; i++){
            System.out.println("Cards for Player " + i + " are " + dealingTheDeck(deckForAGame, numOfPlayers));
        }

    }



}
