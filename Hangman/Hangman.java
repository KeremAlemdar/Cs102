/**
 * Kerem Alemdar
 * 21702133
 * 07.10.2019
 */
import java.util.Random;
public class Hangman
{
  
  private int maxAllowedIncorrectTries;
  private int numberOfIncorrectTries;
  private StringBuffer usedLetters;
  private StringBuffer secretWord;
  private StringBuffer allLetters;
  private StringBuffer knownSoFar;
  
  public Hangman()
  {
    maxAllowedIncorrectTries = 6;
    numberOfIncorrectTries = 0;
    usedLetters = new StringBuffer();
    secretWord = chooseSecretWord();
    allLetters = new StringBuffer("abcdefghijklmnopqrstuwxyz");
    knownSoFar = new StringBuffer(secretWord.length());
    
    for (int i = 0; i < secretWord.length(); i++)
    {
      knownSoFar.append("*");
    }
  }
  
  public boolean isGameOver() {
    return secretWord.toString().equals( getKnownSoFar() ) || hasLost();
  }
  public boolean hasLost() {
    return getNumberOfIncorrectTries() > getMaxAllowedIncorrectTries();
  }
  public String getKnownSoFar() {
    return knownSoFar.toString();
  }
  public String getAllLetters() {
    return allLetters.toString();
  }  
  public String getUsedLetters() {
    return usedLetters.toString();
  }
  public int getNumberOfIncorrectTries() {
    return numberOfIncorrectTries;
  }   
  public int getMaxAllowedIncorrectTries() {
    return maxAllowedIncorrectTries;
  }
  public int tryThis( char letter)
  {
    
    boolean match = false;
    int count = 0;
    boolean added = false;
    
    if ( numberOfIncorrectTries >= maxAllowedIncorrectTries )
    {
      return -3;
    }
    
    if(Character.isLetter(letter))
    {
      if(usedLetters.toString().indexOf(letter) == -1)
      { 
        usedLetters.append(letter);
      }
      else
      { 
        return -2;
      }
      
      for( int i = 0; i < secretWord.length() ; i++)
      {
        if( secretWord.charAt(i) == letter)
        {
          match = true;
          count++;
          
          if (knownSoFar.charAt(i) != letter)
          {
            knownSoFar.setCharAt( i, letter);
            
          } 
        }
      }
      if ( !match )
      {
        numberOfIncorrectTries++;
      }
      return count;
    }
    else
    {
      return -1;
    }
  }
  private static StringBuffer chooseSecretWord (){
    
    String list [] = new String [] {
      
      "elephant", "goat", "papa", "abdul", "cs" , "bilkent", "banana",
        "october", "computer", "building", "mug", "battery", "discrete", "mathematics",
        "tough", "mobile", "hahaahahah", "wallet", "card", "song", "country",
        "chemical" , "biology", "babysitter", "coffee", "carpenter", "keyboard", "tea", "milk",
        "headphones","design","advice","elephant","television","language","mosquito","vacation",
        "artificial","highlight","intersection", "passion", "reliability", "planner", "telephone",
        "picture", "photographer", "waiter", "treasure", "sweater", "laptop" ,"orange", "conservative",
        "airplane", "plumber", "dictionary", "station", "market", "gravity", "electric" ,"mouse",
        "classroom","mobile", "book", "car", "festival", "instructor", "bottle", "comb", "strugle",
        "music", "kangaroo", "course", "mother", "cheese", "smile", "glasses", "sun", "son", "amazing",
        "homework", "english", "tea", "database", "state", "government", "electrcity", "charger",
        "butter", "clothes", "date", "love", "flirt", "night", "mars", "chocolate","age","century"
    };
    
    int random = (int)(Math.random() * list.length);
    StringBuffer selected = new StringBuffer(list[random]);
    return  selected;
  }
  
}