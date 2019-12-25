import java.util.Scanner;
import cardgame.*;

// CardGameTest
// author: Kerem Alemdar 21702133
// date: 17.10.2019
public class CardGameTest
{
  public static void main( String[] args)
  {
    Scanner scan = new Scanner( System.in);
    
    System.out.println( "Start of CardGameTest\n");
    
    // CONSTANTS
    
    // VARIABLES
    Card       c;
    Cards      cards;
    ScoreCard  scores;
    Player     p;
    CardGame   game;
    
    // PROGRAM CODE
    
    // test Card class
    c = new Card(0);
    System.out.println( c);
    System.out.println();
    
    // test Cards class
    cards = new Cards( true);
    cards.addTopCard( c);
    cards.shuffle();
    
    // test ScoreCard class
    scores = new ScoreCard( 4);
    scores.update( 3, 1);
    scores.update( 1, 2);
    System.out.println( "\n" + scores );
    int[] trylist = scores.getWinners();
    for (int i = 0; i < trylist.length; i++) {
      System.out.println(trylist[i]);
    }
    // test Player class
    p = new Player("name");
    p.add(c);
    c = p.playCard();
    System.out.println(c);
    
    // test CardGame class too?
    Player player1 = new Player("p1");
    Player player2 = new Player("p2");
    Player player3 = new Player("p3");
    Player player4 = new Player("p4");
    game = new CardGame (player1,player2,player3,player4);
    System.out.println(game.isGameOver());
    System.out.println(game.isTurnOf(player4));
    System.out.println(game.isTurnOf(player1));
    
    System.out.println(game.getScore(2));
    System.out.println(game.getRoundNo());
    System.out.println(game.getTurnOfPlayerNo());
    System.out.println(game.showScoreCard());
    // Once you have all the bits working, complete the MyCardGame program
    // that provides a menu allowing any of the players to play their card,
    // an option to see the score card, and one to quit the game at any time.
    // When the game is over it should print out the winners.
    
    System.out.println( "\nThis is just for test. Please run MyCardGame.java");
    System.out.println( "\nEnd of CardGameTest\n" );
  }
  
} // end of class CardGameTest
