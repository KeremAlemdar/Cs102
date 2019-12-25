import javax.swing.JFrame;
import cs101.sosgame.SOS;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SosGame extends JFrame {
  SOS game = new SOS(5);
  SOS game1 = new SOS(3);
  SOSGUIPanel panel = new SOSGUIPanel(game,game1,"Kerem","Eylül","Mustafa","Ýsmet");
  SOSCanvas panel1 = new SOSCanvas(game,50,50);
  JRadioButton anan = new JRadioButton("S");
  JPanel panel2 = new JPanel();
  public SosGame() {
    getContentPane().add(panel,BorderLayout.CENTER);
    setVisible(true);
    setSize(800,500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public static void main (String [] args) {
    new SosGame();
  }
  
  
}
