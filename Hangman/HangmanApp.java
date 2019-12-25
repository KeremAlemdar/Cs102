/**
 * Kerem Alemdar
 * 21702133
 * 07.10.2019
 */
import java.util.Scanner;

public class HangmanApp
{
  public static void main( String [] args )
  {
    Scanner scan = new Scanner(System.in);
    Hangman hangman;
    
    char guess;
    int gameNum;
    int request;
    int tryLetterResult;
    
    gameNum = 1;
    request = 0;
    
    System.out.println( "              Welcome to the HANGMAN GAME!" );
    System.out.println( "Rules: " );
    System.out.println( "1.You need to guess the secret word by choosing letters." );
    System.out.println( "2.After every guess (according to the accuracy of your guess) incomplete state of secret word will be displayed." );
    System.out.println( "3.Maximum incorrect letter guess amount is defaultly 6." );
    System.out.println( "4.If you guess the secret word before the maximum incorrect letters amount you win." );
    System.out.println( "5.If you can't, you lose, man will be hanged and the secret word will be displayed.\n\n" );
    
    while( gameNum == 1 || request== 1 ){
      tryLetterResult = 0;
      request =0;
      guess = ' ';
      
      hangman = new Hangman();
      
      System.out.println( "Your max allowed incorrect guess amount is: " + hangman.getMaxAllowedIncorrectTries() + " ." );
      

      while( !hangman.isGameOver()){
        
        System.out.println( "\n----------------------------------" );
        System.out.println( "Amount of incorrect tries left: " + ( hangman.getMaxAllowedIncorrectTries() - hangman.getNumberOfIncorrectTries() ) );
        System.out.println( "----------------------------------" );
        System.out.println( "The letters have been used before: " + hangman.getUsedLetters() );
        System.out.println( "----------------------------------" );
        

        if( hangman.getMaxAllowedIncorrectTries() == 6 ){
          displayHangman( hangman.getNumberOfIncorrectTries() );
        }
        
        System.out.println( "       " + hangman.getKnownSoFar() + "\n" );
        System.out.println( hangman.getAllLetters() );
        System.out.print( "Please choose and enter the letter you want to guess: " );
        
        do{
          if( tryLetterResult == -1 ){
            System.out.print( "Invalid input. Please enter one of the letters you see above: " );
          }
          if( tryLetterResult == -2 ){
            System.out.print( "You have choosen this letter already. Please enter a letter that you didn't guess before: " );
          }
          guess = scan.next().charAt(0);
          tryLetterResult = hangman.tryThis(guess);
        }while( tryLetterResult != -3 && tryLetterResult < 0 );//End of do-while
        
        if( !( hangman.hasLost() ) ){
          System.out.println( "The letter you choosed " + guess + " is in the word " + tryLetterResult + " times." );
        }
        
      }
      if( !(hangman.hasLost()) && hangman.isGameOver() ){
        System.out.println( "******CONGRUTULATIONS****** You guessed the secret word.\n" );
        System.out.println( "The secret word was: " + hangman.getKnownSoFar() + "\n" );
        System.out.println( "It took " + hangman.getNumberOfIncorrectTries() + " incorrect tries to find the word" );
      }
      
      if( hangman.hasLost() && hangman.isGameOver() ){
        displayHangman(7);
        System.out.println( "Sorry, but you lost!\n" );
        
        System.out.println( "The secret word was: " + findSecretWord(hangman) );
      }
      
      System.out.print( "\nWould you like to play again? (If yes write \"1\" if not write \"0\"): " );
      request = scan.nextInt();
      
      gameNum++;
    }
    
    System.out.println( "\n THANKS FOR PLAYING!! Exitting..." );
  }

  public static void displayHangman( int incorrectTries ){
    if( incorrectTries == 0){
      System.out.println( "\n\n\n\n\n" );
    }
    if( incorrectTries == 1 ){
      System.out.println( "\n\n\n|\n|\n|" );
    }
    if( incorrectTries == 2 ){
      System.out.println( "\n|\n|\n|\n|\n|" );
    }
    if( incorrectTries == 3 ){
      System.out.println( "_____\n|\n|\n|\n|\n|" );
    }
    if( incorrectTries == 4 ){
      System.out.println( "_____\n|   |\n|\n|\n|\n|" );
    }
    if( incorrectTries == 5 ){
      System.out.println( "_____\n|   |\n|   0\n|\n|\n|" );
    }
    if( incorrectTries == 6 ){
      System.out.println( "_____\n|   |\n|   0\n|  /|\\ \n|   |\n|" );
    }
    if( incorrectTries == 7 ){
      System.out.println( "_____\n|   |\n|   0\n|  /|\\ \n|   |\n|  / \\" );
    }
  }
  
  public static String findSecretWord( Hangman secretWord ){
    
    char letter = ' ';
    String word = "";
    
    for( int i=0; i < secretWord.getAllLetters().length(); i++ ){
      letter = (char) (secretWord.getAllLetters().charAt(i) + ' ');
      secretWord.tryThis(letter);
    }
    word = secretWord.getKnownSoFar();
    
    return word;
  }
  
  
  
  
  
  
}








