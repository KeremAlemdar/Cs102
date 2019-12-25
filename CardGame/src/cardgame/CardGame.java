package cardgame;

import java.util.ArrayList;

// Cardgame
// author: Kerem Alemdar 21702133
// date: 17.10.2019
public class CardGame
{
  // properties
  Cards             fullPack;
  ArrayList<Player> players;
  ScoreCard         scoreCard;
  Cards[]           cardsOnTable;
  int               roundNo;
  int               turnOfPlayer;
  
  // constructors
  public CardGame( Player p1, Player p2, Player p3, Player p4)
  {
    roundNo = 0;
    turnOfPlayer = 0;
    scoreCard = new ScoreCard(4);
    cardsOnTable = new Cards[14];
    for (int i = 0; i <= 13; i++) {
      cardsOnTable[i] = new Cards(false);
    }
    fullPack = new Cards(true);
    fullPack.shuffle();
    players = new ArrayList<Player>();
    players.add(p1);
    players.add(p2);
    players.add(p3);
    players.add(p4);
    Card c = fullPack.getTopCard();
    while (c != null) {
      for (int i = 0; i < 4; i++) {
        players.get(i).add(c);
        c = fullPack.getTopCard();
      }
    }
  }
  
  // methods
  public boolean playTurn( Player p, Card c)
  {
    if (isGameOver() == false) {
      int highest = 0;
      if (players.indexOf(p) == turnOfPlayer) {
        cardsOnTable[roundNo].addTopCard(c);
        turnOfPlayer++;
        if ( turnOfPlayer == 4) {
          turnOfPlayer = 0;
          for (int i = 0; i < 4; i++) {
            Card thecard = cardsOnTable[roundNo].getCard(i);
            if (thecard.getFaceValue() >= highest) {
              highest = thecard.getFaceValue();
            }
          }
          for (int i = 0; i < 4; i++) {
            if (cardsOnTable[roundNo].getCard(i).getFaceValue() == highest) {
              scoreCard.update(i, 1);
            }
          }
          highest = 0;
          roundNo++;
        }
        return true;
      }
      else
        return true;
      
    }
    else
      System.out.println("********************************** \n" + "********************************** \n"
                           + "********************************** \n" + "********************************** \n"
                           + "The Game is OVER ! There is no \n" + "more cards to play. To end the \n"
                           + "game and see the result press 0 \n********************************** \n"
                           + "********************************** \n" + "********************************** \n"
                           + "**********************************");
    return false;
  }
  
  public boolean isTurnOf( Player p)
  {
    int number = players.indexOf(p);
    if (number == turnOfPlayer)
      return true;
    else
      return false;
  }
  
  public boolean isGameOver()
  {
    if (roundNo == 13)
      return true;
    else
      return false;
  }
  
  public int getScore( int playerNumber)
  {
    int score = scoreCard.getScore(playerNumber);
    return score;
  }
  
  public String getName( int playerNumber)
  {
    String name = players.get(playerNumber-1).getName();
    return name;
  }
  
  public int getRoundNo()
  {
    return roundNo;
  }
  
  public int getTurnOfPlayerNo()
  {
    return turnOfPlayer;
  }
  
  public Player[] getWinners()
  {
    Player[] winners;
    int[] winners1 = scoreCard.getWinners();
    winners = new Player[winners1.length];
    for (int i = 0; i < winners.length; i++) {
      winners[i] = players.get(winners1[i]);
    }
    return winners;
  }
  
  public String showScoreCard()
  {
    return scoreCard.toString();
  }
  
}