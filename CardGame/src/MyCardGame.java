import java.util.Scanner;
import cardgame.*;

// MyCardGame - provides a menu allowing any of the players to play their card,
//              an option to see the score card, and one to quit the game at any time.
//              When the game is over it dislays the winners.
// author: Kerem Alemdar 21702133
// date: 17.10.2019
public class MyCardGame
{
  public static void main( String[] args)
  {
    Scanner scan = new Scanner( System.in);
    
    System.out.println( "Start of MyCardGame\n");
    
    // CONSTANTS
    final int MENU_EXIT    = 0;
    final int MENU_PLAY_P1 = 1;
    final int MENU_PLAY_P2 = 2;
    final int MENU_PLAY_P3 = 3;
    final int MENU_PLAY_P4 = 4;
    final int MENU_SCORES  = 5;
    
    // It is hard to come to and end in the game, this will be the quick way to play 13 round
    final int MENU_PLAY_QUICK =6;
    
    // VARIABLES
    Player     p1, p2, p3, p4;
    CardGame   game;
    int        selection;
    
    // PROGRAM CODE
    
    // create players...
    p1 = new Player( "p1");
    p2 = new Player( "p2");
    p3 = new Player( "p3");
    p4 = new Player( "p4");
    
    // create game with the 4 players...
    game = new CardGame( p1, p2, p3, p4);
    
    boolean quit;
    // display menu, get and process selection, until exit
    do 
    {
      // display menu
      System.out.println();
      System.out.println( "MyCardGame   Round: " + game.getRoundNo()
                           + "\t TurnOfPlayer: " + game.getTurnOfPlayerNo() );
      System.out.println();
      System.out.println( MENU_PLAY_P1 + " - Player " + MENU_PLAY_P1 + " plays" );
      System.out.println( MENU_PLAY_P2 + " - Player " + MENU_PLAY_P2 + " plays" );
      System.out.println( MENU_PLAY_P3 + " - Player " + MENU_PLAY_P3 + " plays" );
      System.out.println( MENU_PLAY_P4 + " - Player " + MENU_PLAY_P4 + " plays" );
      System.out.println( MENU_SCORES  + " - Show scores" );
      System.out.println( MENU_PLAY_QUICK + " - No matter which round you are now in, " + 
                         "press 6 to play all of the remaining rounds at" + 
                         " once and see the results immediately; \n" +
                         " after pressing 6 you should enter 0 to quit game or 5 to show the score board");
      
      // ask for and get selection
      System.out.println();
      System.out.println( "Selection (" + MENU_EXIT + " to exit): ");
      selection = scan.nextInt();
      
      // process selection
      if ( selection == MENU_PLAY_P1 )
        play(p1,game);
      
      else if ( selection == MENU_PLAY_P2 )
        play(p2,game);
      
      else if ( selection == MENU_PLAY_P3 )
        play(p3,game);
      
      else if ( selection == MENU_PLAY_P4 )
        play(p4,game);
      
      else if ( selection == MENU_SCORES ) {
        System.out.println(game.showScoreCard());
      }
      else if ( selection == MENU_PLAY_QUICK) {
        for (int i = 0; i < 13; i++) {
          playquick(p1,game);
          playquick(p2,game);
          playquick(p3,game);
          playquick(p4,game);
        }
      }
      else if ( selection != MENU_EXIT)
        System.out.println( "Invalid selection! \n" );
      
    } while (selection != MENU_EXIT);
    // display winners...
    // ToDo ~ game.isGameOver(); ? game.getWinners(); 
    boolean finish = game.isGameOver();
    if (finish)
      System.out.println("Game is ENDED !");
    else
      System.out.println("\nGame is not ended yet.Not all cards has been played. However, currently;");
    
    Player[] winners = game.getWinners();
    System.out.print("THE Winners are");
    for (int i = 0; i < winners.length; i++)
      System.out.print(" " + winners[i].getName());
    
    
    System.out.println( "\n \nEnd of MyCardGame\n" );   
  }
  
  // ToDo...
  // get the card, c, that player p wants to play
  // pass c to the game, see if it accepted c from p
  // if game didn't accept the card, give c back to the player! 
  // return accepted.
  private static boolean play( Player p, CardGame game)
  {
    Scanner scan = new Scanner(System.in);
    Card       c;
    boolean    accepted;        
    accepted = false;  // ToDo...
    String answer;
    c = p.topCard();
    boolean finish = game.isGameOver();
    if (finish == false) {
      if ( game.isTurnOf(p) ) {
        System.out.println("Enter Yes to accept playing the Card " + c);
        answer = scan.next();
        if ( answer.equals("Yes")) {
          game.playTurn(p, p.playCard());
          accepted = true;
          System.out.println("The Card has been played");
        }
        else if ( answer.equals("yes")) {
          game.playTurn(p, p.playCard());
          accepted = true;
          System.out.println("The Card has been played");
        }
        else {
          System.out.println("The card has been given back to the Player " + p.getName());
        }
      }
      else {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \nPlayer " + 
                           p.getName() + " cannot play because it" + 
                           " is the turn of Player " + game.getName(game.getTurnOfPlayerNo()+1));
      }
    }
    else {
      game.playTurn(p, p.playCard());
    }
    
    return accepted;
  }
  
  // this is for the quick play option // option 6 - MENU_PLAY_QUICK
  private static boolean playquick( Player p, CardGame game) {
    Card       c;
    boolean    accepted;        
    accepted = false;  // ToDo...
    String answer;
    c = p.topCard();
    boolean finish = game.isGameOver();
    if (finish == false) {
      if ( game.isTurnOf(p) ) {
        game.playTurn(p, p.playCard());
        accepted = true;
        System.out.println("The Card has been played");
      }
      else {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX \nPlayer " + 
                           p.getName() + " cannot play because it" + 
                           " is the turn of Player " + game.getName(game.getTurnOfPlayerNo()+1));
      }
    }
    else {
      game.playTurn(p, p.playCard());
    }
    return true;
  }
} // end class MyCardGame
