
import models.Hand;
import models.Player;
import pools.CardDeck;
import java.util.Scanner;

/**
 * Main class of this project
 * Game of poker for 2 players only where one player is computer. Game has rules of Five Hand Poker
 * On game start every player gets 20 chips and 5 cards before first round starts.
 *
 * Rules of the game
 * If first round starts both players have to be "blind" bet with a size of 1 chip before seeing their cards.
 * Human player can then see his cards and application asks if player wants to raise his/hers bets. Computer
 * player always has to bet same amount of chips as player.
 * If answer is no or additional bets are added. Then both players show their hands and hands are compared by
 * comparing algorithm. Winner of a round is one with stronger Hand. Winner gets all bets from chips pool and
 * loser doesn't get anything from this round.
 * Second round starts if both players have at least 1 chip left. If player only has one chip left then Game
 * does not ask for additional bets and goes right to showing and comparing cards that decides fate of the player.
 * On every round end game checks players chips and if chip count is 0 by the end of the round, then player who holds
 * all the chips is a winner.
 *
 * If human wants to play again this game he can choose yes or no. On pressing "y" game initializes again and on
 * pressing "n" game exists
 */
class Game {

    private CardDeck cd;

    private Player player1;
    private Player player2;

    private int chipsInPlay = 0;
    private boolean gameOver;
    private boolean roundOver;

    Scanner reader = new Scanner(System.in);

    /**
     * Initializes project
     * @param args arguments
     */
    public static void main(String[] args) {
        Game game = new Game();
    }

    /**
     * Initializes game
     */
    public Game() {
        init();
    }

    /**
     * Initializes players and card deck. Also sets value of gameOver to false.
     * Stars the game after everything else is initialized.
     */
    private void init() {

        gameOver = false;

        cd = new CardDeck();

        player1 = new Player(1);
        player2 = new Player(2);

        //Start game
        start();
    }

    /**
     * Starts game process
     */
    private void start() {

        System.out.println("-------- Game started ---------");
        dealCards();
    }

    /**
     * Ends application process
     */
    private void end() {
        System.out.println("Hope to see you again.");
        System.exit(0);
    }

    /**
     * Ends game and asks player to play again.
     */
    private void endGame() {

        System.out.println("-------- Game ended ---------");
        System.out.println("Would you like to play again? Press \"y\" for yes and \"n\" for no.");
        askForPlayingAgain();
    }

    /**
     * Asks player to play again. User has to enter y or n to continue.
     * On pressing y game initializes again and on pressing n application stops.
     *
     * Checks for valid entry with regex.
     */
    private void askForPlayingAgain() {

        String input = reader.nextLine();

        if (input.matches("(y|n){1}")) {

            if (input.equals("y")) {
                init();
            }
            else {
                end();
            }
        }
        else {
            System.out.println("Please enter valid input!");
            askForPlayingAgain();
        }
    }
    /**
     * Deals cards after initial bets are made and starts new round of the game.
     * Starts by resetting deck and takes "blind" bets from players. If bets are
     * places then adds 5 cards to each player hand. Game continues to showing
     * cards for the first time.
     */
    private void dealCards() {

        System.out.println("-------- Round started ---------");

        //Start new round
        roundOver = false;
        cd.resetDeck();

        System.out.println("Blind bets are added!");
        bet(1);

        player1.setHand(new Hand(cd.getRandomCards(5)));
        player2.setHand(new Hand(cd.getRandomCards(5)));

        //Show cards to player
        openCards();
        askForAdditionalBets();
    }



    /**
     * Checks if players chip count is not 0 and then asks player for another bets
     * in addition to blind bet. If chip count is 0 then skips asking for bets and
     * finishes round by showing and comparing cards.
     */
    private void askForAdditionalBets() {

        if (player1.getChips() != 0 && player2.getChips() != 0) {
            System.out.println("Would you like to raise bet? Enter an integer number for raising bet or enter letter \"n\"");
            askForBet();
        }
        else {
            roundOver = true;

            if (player1.getChips() == 0) {
                System.out.println("You went All In with blind bet.");
            }
            else {
                System.out.println("Your opponent went All In with blind bet.");
            }
            openCards();
        }
    }

    /**
     * Prompts to ask bets. Reads user input and if input is "n" then finishes round by
     * comparing and showing cards to each other. If input is an integer then bets chips
     * by integer size and then proceeds with opening players cards.
     * If input is not "n" or an integer then asks for input again.
     */
    private void askForBet() {

        String input = reader.nextLine();

        if (input.equals("n")) {
            roundOver = true;
            openCards();
        }
        else if (input.matches("[0-9]+")) {

            int inputI = Integer.parseInt(input);

            if (player1.getChips() < inputI || player2.getChips() < inputI) {
                if (player1.getChips() < inputI) {
                    System.out.println("You only have " + player1.getChips() + " chips. Please try again!");
                }
                else if (player2.getChips() < inputI) {
                    System.out.println("Your opponent only has " + player2.getChips() + " chips. Please try again!");
                }
                askForBet();
            }
            else {
                roundOver = true;
                bet(inputI);
                openCards();
            }
        }
        else {
            System.out.println("Please enter an integer number or letter \"n\"!");
            askForBet();
        }
    }

    /**
     *  Places bet with given input size to the chip pool in game. Removes amount of
     *  chips from each player.
     * @param betSize chip count for betting.
     */
    private void bet(int betSize) {

        player1.setChips(player1.getChips() - betSize);
        player2.setChips(player2.getChips() - betSize);

        chipsInPlay += betSize * 2;

        System.out.println("Both of you bet " + betSize + " chips");
        System.out.println("New pool size: " + chipsInPlay);

        System.out.println("You now have: " + player1.getChips());
        System.out.println("Your opponent now has: " + player2.getChips());
    }

    /**
     * After player wins round then chips are added to players chip collection.
     * Also removes all chips from game chip pool.
     * @param player player to receive chips in game's chip pool
     */
    private void collectBet(Player player) {

        System.out.println("Player " + player.getId() + " received " + chipsInPlay + " chips.");
        player.setChips(player.getChips() + chipsInPlay);
        chipsInPlay = 0;
    }

    /**
     * This method is accessed in rare chance that both players are tied. It takes
     * chips from game's chip pool and adds half of the pool to both player chips collection.
     * Removes chips from chip pool.
     */
    private void splitBet() {

        int splitedChips = chipsInPlay / 2;

        System.out.println("Both players have received " + splitedChips + " chips.");
        player1.setChips(player1.getChips() + splitedChips);
        player2.setChips(player2.getChips() + splitedChips);

        chipsInPlay = 0;
    }

    /**
     * Opens cards and compares them.
     * Checks if round is over. If round is not over then game shows opponent cards
     * as asterixes. Your cards are always shown with corresponding ranks and suits.
     * After cards are displayed, comparation of cards starts.
     */
    private void openCards() {

        if (!roundOver) {
            System.out.println("Opponent's cards: * * * * *");
        }
        else {
            System.out.println("Opponent's cards: " + player2.getHand().toString());
        }

        System.out.println("Your cards: " + player1.getHand().toString());

        if (roundOver) {
            compareCards();
        }
    }

    /**
     * Compares Hands of each player and checks who won this round. Prompts message afterwards
     * If comparing is done then bets are either collected or splitter by corresponding players.
     * After bets are collected game continues to check chip counts of the players.
     */
    private void compareCards() {

        if (player1.getHand().compareTo(player2.getHand()) == 1) {
            System.out.println("Winning hand: " + player1.getHand().getMatchData().getMatch().getValue());
            System.out.println("You won this hand! Hooraay!!");
            collectBet(player1);
        }
        else if (player1.getHand().compareTo(player2.getHand()) == -1) {
            System.out.println("Winning hand: " + player2.getHand().getMatchData().getMatch().getValue());
            System.out.println("Opponent won this hand! Better luck next time.");
            collectBet(player2);
        }
        else {
            System.out.println("Hands are tied!");
            splitBet();
        }

        checkChips();
    }

    /**
     * Checks chip counts of players. If any of the players have 0 chips remaining
     * game ends. If more than 0 chips are left then new round begins.
     */
    private void checkChips() {

        if (player1.getChips() == 0) {
            System.out.println("You have run out of chips! Your opponent has won!");
            gameOver = true;
        }
        else if (player2.getChips() == 0) {
            System.out.println("Your opponent has run out of chips! You won! Congratulations!");
            gameOver = true;
        }
        else {
            dealCards();
        }

        if (gameOver) { endGame(); }
    }
}