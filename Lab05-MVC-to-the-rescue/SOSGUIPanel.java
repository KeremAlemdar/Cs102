import java.awt.*;
import cs101.sosgame.SOS;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class SOSGUIPanel extends JPanel {
   
   SOS game1;
   SOS game2;
   String player1;
   String player2;
   String player3;
   String player4;
   SOSCanvas visual1;
   SOSCanvas visual2;
   int startx;
   int starty;
   int blocksize = 80;
   int blocksize1;
   int blocksize2;
   JPanel panel;
   JPanel panel2;
   JRadioButton button1;
   JRadioButton button2;
   JRadioButton button3;
   JRadioButton button4;
   JLabel label1;
   JLabel label2;
   JLabel label3;
   JLabel label4;
   JPanel paneltoad1;
   JPanel paneltoad2;
   String string1;
   String string2;
   String string3;
   String string4;
   ButtonGroup group1;
   ButtonGroup group2;
   
   MouseListener listener = new MouseClicker();
   public SOSGUIPanel(SOS a, SOS b, String p1, String p2 ,String p3, String p4) {
      setLayout(new GridLayout(1,2));
      button1 = new JRadioButton("S");
      button2 = new JRadioButton("O");
      button3 = new JRadioButton("S");
      button4 = new JRadioButton("O");
      game1 = a;
      game2 = b;
      player1 = p1;
      player2 = p2;
      player3 = p3;
      player4 = p4;
      label1 = new JLabel(p1 + " : " + game1.getPlayerScore1());
      label2 = new JLabel(p2 + " : " + game1.getPlayerScore2());
      label3 = new JLabel(p3 + " : " + game2.getPlayerScore1());
      label4 = new JLabel(p4 + " : " + game2.getPlayerScore2());
      starty = 50;
      panel = new JPanel();
      panel2 = new JPanel();
      panel.add(label1);
      panel.add(button1);
      panel.add(button2);
      panel.add(label2);
      panel2.add(label3);
      panel2.add(button3);
      panel2.add(button4);
      panel2.add(label4);
      panel.setSize(450,80);
      panel2.setSize(450,80);
      blocksize1 = 300 / game1.getDimension();
      blocksize2 = 300 / game2.getDimension();
      visual1 = new SOSCanvas(game1,50,starty);
      startx = ((game1.getDimension()*80) + 100);
      visual2 = new SOSCanvas(game2,50,starty);
      addMouseListener(new MouseClicker());
      paneltoad1 = new JPanel();
      paneltoad2 = new JPanel();
      paneltoad1.setLayout(new BorderLayout());
      paneltoad1.add(visual1,BorderLayout.CENTER);
      paneltoad1.add(panel,BorderLayout.SOUTH);
      paneltoad2.setLayout(new BorderLayout());
      paneltoad2.add(visual2,BorderLayout.CENTER);
      paneltoad2.add(panel2,BorderLayout.SOUTH);
      add(paneltoad1,BorderLayout.WEST);
      add(paneltoad2,BorderLayout.CENTER);
      group1 = new ButtonGroup();
      group2 = new ButtonGroup();
      group1.add(button1);
      group1.add(button2);
      group2.add(button3);
      group2.add(button4);
      label1.setForeground(Color.RED);
      label2.setForeground(Color.BLACK);
      label3.setForeground(Color.RED);
      label4.setForeground(Color.BLACK);
   }
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
   }
   
   class MouseClicker implements MouseListener {
      
      @Override
      public void mouseClicked (MouseEvent e) {
         int x = e.getX();
         int y = e.getY();
         int row;
         int col;
         if ( x < 300 + 100 ) {
            if(game1.isGameOver()) {
               if(game1.getPlayerScore1() > game1.getPlayerScore2())
                  JOptionPane.showMessageDialog(panel,player1 + " is the winner!");
               else if (game1.getPlayerScore1() < game1.getPlayerScore2())
                  JOptionPane.showMessageDialog(panel,player2 + " is the winner!");
               else 
                  JOptionPane.showMessageDialog(panel,"It's a draw!");
            }
            else {
               if(button1.isSelected()) {
                  row = (y-50)/blocksize1;
                  col = (x-50)/blocksize1;
                  game1.play('s',row+1,col+1);
                  game1.printBoard();
               }
               else if (button2.isSelected()) {
                  row = (y-50)/blocksize1;
                  col = (x-50)/blocksize1;
                  game1.play('o',row+1,col+1);
                  game1.printBoard();
               }
               else {
                  System.out.println("Please select S or O ");
               }
            }
         }
         else if (x > 300 + 100) {
            if(game2.isGameOver()) {
               if(game2.getPlayerScore1() > game1.getPlayerScore2())
                  JOptionPane.showMessageDialog(panel,player3 + " is the winner!");
               else if (game2.getPlayerScore1() < game1.getPlayerScore2())
                  JOptionPane.showMessageDialog(panel,player4 + " is the winner!");
               else 
                  JOptionPane.showMessageDialog(panel,"It's a draw!");
            }
            else {
               if(button3.isSelected()) {
                  row = (y-50)/blocksize2;
                  col = (x-440)/blocksize2;
                  game2.play('s',row+1,col+1);
                  game2.printBoard();
               }
               else if (button4.isSelected()) {
                  row = (y-50)/blocksize2;
                  col = (x-440)/blocksize2;
                  game2.play('o',row+1,col+1);
                  game2.printBoard();
               }
               else {
                  System.out.println("Please select S or O ");
               }
            }
         }
         label1.setText(player1 + " : " + game1.getPlayerScore1());
         label2.setText(player2 + " : " + game1.getPlayerScore2());
         label3.setText(player3 + " : " + game2.getPlayerScore1());
         label4.setText(player4 + " : " + game2.getPlayerScore2());
         
         if(game1.getTurn() == 1) {
            label1.setForeground(Color.RED);
            label2.setForeground(Color.BLACK);
         }
         if(game1.getTurn() == 2) {
            label1.setForeground(Color.BLACK);
            label2.setForeground(Color.RED);
         }
         if(game2.getTurn() == 1) {
            label3.setForeground(Color.RED);
            label4.setForeground(Color.BLACK);
         }
         if(game2.getTurn() == 2) {
            label3.setForeground(Color.BLACK);
            label4.setForeground(Color.RED);
         }
         visual1.repaint();
         visual2.repaint();
         
      }
      @Override
      public void mousePressed(MouseEvent e) {
      }
      @Override
      public void mouseReleased(MouseEvent e) {
      }
      @Override
      public void mouseEntered(MouseEvent e) {
      }
      @Override
      public void mouseExited(MouseEvent e) {
      }
   }
}
