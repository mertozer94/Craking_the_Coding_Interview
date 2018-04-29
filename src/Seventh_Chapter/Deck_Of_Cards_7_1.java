package Seventh_Chapter;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Mert Ozer
 *
 * Design the data structures for a generic deck of cards. Explain how you would
subclass the data structures to implement blackjack.
 */
public class Deck_Of_Cards_7_1 {
    public static void main(String[] args) throws Exception{
     Deck deck = new Deck();
     deck.createDeck();
     deck.shuffleCards();
     Game game = Game.getInstance();
     game.addPlayer("Mert");
     game.addPlayer("Mert1");
     game.addPlayer("Mert2");
     game.addPlayer("Mert3");

     int end = 1;
     // or just get a confirmation from user
     while (end != 5){
         Round newRound = new Round(end);
         // todo set active players ...
         game.startRound(newRound);
         game.distributeInitalCards(deck);
         // todo give extra cards to players
         game.endRound(newRound);
         end++;
     }
    }
    private static class Round {
        private int id;
        private ArrayList<Player> players;
        private ArrayList<Player> winners;
        private ArrayList<Player> losers;
        private Round(int id){
            this.id = id;
            players = new ArrayList<>();
            winners = new ArrayList<>();
            losers = new ArrayList<>();
        }
        private void removeFromSession(Player p) {
            players.remove(p);
            losers.add(p);
        }
    }
    private static class Player {
        static AtomicInteger nextId = new AtomicInteger(0);
        int id;
        String name;
        int point;
        Hand hand;
        private Player(String name){
            this.id = nextId.incrementAndGet();
            this.name = name;
            this.point = 0;
            hand = null;
        }

    }
    public static class Game {
        private static Game _instance = null;
        private Round currentRound;
        private ArrayList<Round> rounds;
        private ArrayList<Player> players;
        private ArrayList<Player> activePlayers;
        private void setActivePlayers(ArrayList<Player> players){
            this.activePlayers = new ArrayList<>();
            activePlayers.addAll(players);
        }
        private void addPlayer(String name){
            Player newPlayer = new Player(name);
            players.add(newPlayer.id -1, newPlayer);
            activePlayers.add(newPlayer.id -1, newPlayer);
        }
        private void removePlayerFromGame(Player p){
            players.remove(p);
            if (activePlayers.contains(p))
                activePlayers.remove(p);
        }
        private Game (){
            players = new ArrayList<>();
            activePlayers = new ArrayList<>();
            rounds = new ArrayList<>();
            currentRound = new Round(0);
            rounds.add(currentRound);
        }
        private static Game getInstance(){
            if (_instance == null)
                _instance = new Game();
            return _instance;
        }
        private void distributeInitalCards(Deck deck) throws Exception {
            deck.shuffleCards();
            for (Player player: this.players){
                Hand hand = new Hand();
                for (int i = 0 ; i < 2; i++){
                    hand.addCard(deck.getFromTop());
                }
                player.hand = hand;
            }
        }
        private void startRound(Round round){
            this.currentRound = round;
        }

        private void endRound(Round round){
            this.rounds.add(round);
            this.currentRound = null;
        }
    }
    public static class Hand {
        private ArrayList<Card> cards;
        private int score;
        private void addCard(Card card){
            cards.add(card);
            score += card.value;
        }
        private Hand(){
            cards = new ArrayList<>();
            score = 0;
        }
    }
    public static class Deck {
        private ArrayList<Card> cards;
        private int numberOfDecks;
        private Deck (int numberOfDecks){
            cards = new ArrayList<>();
            this.numberOfDecks = numberOfDecks;
        }
        private Deck (){
            cards = new ArrayList<>();
            this.numberOfDecks = 1;
        }
        private void createDeck(){
            for(int n = 0; n < numberOfDecks; n++)
            for (CardType type: CardType.values()){
                for (int i = 1; i < 11; i++){
                    Card newCard = CardFactory.createNewCard(type, i, Integer.toString(i));
                    cards.add(newCard);
                }
                for (int i = 11; i < 14; i++){
                    Card newCard = CardFactory.createNewCard(type, 10, Integer.toString(i));
                    cards.add(newCard);
                }
            }
        }
        private void shuffleCards(){
            shuffleCards(1);
        }
        private void shuffleCards(int seed){
            Random random = new Random(seed);
            for (int i = 0; i < 100; i ++){
                int first = random.nextInt(52);
                int second = random.nextInt(52);
                swap(first, second);
            }
        }
        private void swap(int first, int second){
            if (first == second)
                return;

            if (first > second){
                int temp = first;
                first = second;
                second = temp;
            }

            Card firstCard = cards.get(first);
            Card secondCard = cards.get(second);

            cards.remove(second);
            cards.add(second,firstCard);

            cards.remove(first);
            cards.add(first, secondCard);
        }
        private Card getFromTop() throws Exception {
            Card card = cards.get(0);
            if (cards.isEmpty())
                createDeck();
            cards.remove(0);
            return card;
        }

    }
    public enum CardType {SPADES, HEARTS, DIAMONDS, CLUBS};

    private static class Card{
        public CardType type;
        public int value;
        public String face;
        public Card (int value, String face) {
            this.value = value;
            this.face = face;
        }
    }
    private static class Spade extends Card {
        public Spade(int value, String face){
            super(value, face);
            this.type = CardType.SPADES;
        }
    }
    private static class Heart extends Card {
        public Heart(int value, String face){
            super(value, face);
            type = CardType.HEARTS;

        }
    }
    private static class Diamond extends Card {
        public Diamond(int value, String face){
            super(value, face);
            type = CardType.DIAMONDS;
        }
    }
    private static class Club extends Card {
        public Club(int value, String face){
            super(value, face);
            type = CardType.CLUBS;
        }
    }

    private static class CardFactory {
        public static Card createNewCard(CardType type, int value, String face){
            if (type.equals(CardType.SPADES))
                return new Spade(value, face);
            else if (type.equals(CardType.HEARTS))
                return new Heart(value, face);
            else if (type.equals(CardType.DIAMONDS))
                return new Diamond(value, face);
            else if (type.equals(CardType.CLUBS))
                return new Club(value, face);
            else
                throw new IllegalArgumentException();
        }
    }

}
