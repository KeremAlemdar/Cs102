package cardgame;

// Player - Simple card game player with name and hand of cards
// author: Kerem Alemdar 21702133
// date: 17.10.2019
public class Player
{
  // properties
  String name;
  Cards hand;
  
  // constructors
  public Player( String name)
  {
    this.name = name;
    hand = new Cards(false);
  }
  
  // methods
  public String getName()
  {
    return name;
  }
  
  public void add( Card c)
  {
    hand.addTopCard(c);
  }
  
  public Card playCard()
  {
    Card topcard = hand.getTopCard();
    return topcard;
  }
  public Card topCard()
  {
    Card c = hand.getTopCard();
    hand.addTopCard(c);
    return c;
  }
  
} // end class Player
