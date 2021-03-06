import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import cs101.sosgame.SOS;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JRadioButton;


public class SOSCanvas extends JPanel{
  
  SOS game;
  int startx;
  int starty;
  int blocksize;
  char[][] place;
  int size;
  public SOSCanvas(SOS a, int s, int m) {
    size = 300;
    game = a;
    startx = s;
    starty = m;
    place = new char[game.getDimension()][game.getDimension()];
    blocksize = size/game.getDimension();
  }
  
  public int getstartx() {
    return startx;
  }
  public int getstarty() {
    return starty;
  }
  public int getblocksize() {
     return blocksize;
  }
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    // this add CellContents into array
    for (int m = 0; m < game.getDimension(); m++) {
      for (int j = 0; j < game.getDimension(); j++) {
        place[m][j] = game.getCellContents(m,j);
        g.drawRect(startx + m*blocksize, starty + j*blocksize, blocksize,blocksize);
        g.drawString(String.valueOf(game.getCellContents(m,j)),starty + j*blocksize+blocksize/2,startx + (m+1)*blocksize-blocksize/2);
      }
    }
  }
  

}
