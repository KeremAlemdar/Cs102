/* Author: Kerem Alemdar
 * date: 14.11.2019
 */
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class BombGame extends JFrame {
  JLabel label;
  JPanel panel;
  JPanel secondpanel;
  ArrayList<JButton> buttons = new ArrayList<>();
  int bomb1;
  int bomb2;
  int price;
  int count;
  Random rand = new Random();
  
  /*Constructor
   * new price bomb1 bomb2, new panel,label,secondpanel
   */
  public BombGame() {
    price = rand.nextInt(25);
    bomb1 = rand.nextInt(25);
    bomb2 = rand.nextInt(25);
    while (bomb1 == price) {
      bomb1 = rand.nextInt(25);
    }
    while (bomb2 == price || bomb2 == bomb1) {
      bomb2 = rand.nextInt(25);
    }
    count = 0;
    
    label = new JLabel("You have played " + count + " moves!");
    panel = new JPanel();
    secondpanel = new JPanel();
    secondpanel.add(label);
    panel.setLayout(new GridLayout(5,5));
    for (int i = 0; i <25; i++) {

        buttons.add(new JButton());
    }
    
    for (int i = 0; i < buttons.size(); i++) {
      panel.add(buttons.get(i));
      if (i == price)
        buttons.get(i).addActionListener (new Price());
      else if (i == bomb1 || i == bomb2)
        buttons.get(i).addActionListener (new Bomb());
      else
        buttons.get(i).addActionListener (new DoListener(i));
    }
    add(secondpanel, BorderLayout.NORTH);
    add(panel, BorderLayout.CENTER);
    setVisible(true);
    setSize(800,800);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public class DoListener implements ActionListener {
    int i;
    public DoListener(int i) {
      this.i = i;
    }
    public void actionPerformed (ActionEvent event) {
      count++;
      label.setText("You have played " + count + " moves!");
      buttons.get(i).setEnabled(false);
    }
  }
  public class Price implements ActionListener {
    public void actionPerformed (ActionEvent event) {
      count++;
      for (int i = 0; i < buttons.size(); i++) {
        buttons.get(i).setEnabled(false);
      }
      label.setText("You got it in " + count + " attempts");
    }
  }
  public class Bomb implements ActionListener {
    public void actionPerformed (ActionEvent event) {
      count++;
      for (int i = 0; i < buttons.size(); i++) {
        buttons.get(i).setEnabled(false);
      }
      label.setText("Sorry! You are blown up at attempt " + count + "!");
    }
  }
  
  public static void main(String [] args) {
    new BombGame();
  }
}