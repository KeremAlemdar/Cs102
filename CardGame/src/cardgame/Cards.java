package cardgame;

import java.util.ArrayList;
import java.util.Random;

// Cards - Maintains a collection of zero or more playing cards.
//         Provides facilities to create a full pack of 52 cards
//         and to shuffle the cards.
// author: Kerem Alemdar 21702133
// date: 17.10.2019
public class Cards
{
  final int NOOFCARDSINFULLPACK = 52;
  
  // properties
  Card[] cards;
  int    valid;  // number of cards currently in collection
  
  // constructors
  public Cards( boolean fullPack)
  {
    cards = new Card[ NOOFCARDSINFULLPACK ];
    valid = 0;
    
    if ( fullPack)
      createFullPackOfCards();
    
  }
  
  // methods
  public Card getTopCard()
  {
    Card tmp;
    
    if ( valid <= 0)
      return null;
    else
    {
      valid--;
      tmp = cards[valid];
      cards[valid] = null;
      return tmp;
    }
  }
  
  public Card getCard(int place)
  {
    Card tn = cards[place];
    return tn;
  }
  
  public boolean addTopCard( Card c )
  {
    if ( valid < cards.length)
    {
      cards[valid] = c;   // should this be cloned?
      valid++;
      return true;
    }
    return false;
  }
  
  private void createFullPackOfCards()
  {
    for (int i =0; i < NOOFCARDSINFULLPACK; i++) {
      addTopCard( new Card(i) );
    }
  }
  
  
  public void shuffle()
  {
    int nxt;
    Card[] cards2 = new Card[NOOFCARDSINFULLPACK];
    Random ran = new Random();
    ArrayList<Integer> randomnumbers = new ArrayList<Integer>();
    for(int i = NOOFCARDSINFULLPACK-1; i >0; i--) {
      do {
        nxt = ran.nextInt(NOOFCARDSINFULLPACK);
      }while(randomnumbers.contains(nxt));
      randomnumbers.add(nxt);
      cards2[i] = cards[nxt];
    }
    for (int i = NOOFCARDSINFULLPACK-1; i>0; i--) {
      cards[i] = cards2[i];
    }
  }
  
} // end class Cards
