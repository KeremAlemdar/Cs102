/* Author: Kerem Alemdar
 * date: 14.11.2019
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Convert extends JFrame {
  GridLayout layout;
  JPanel panel;
  JLabel decimal;
  JLabel hex;
  JLabel binary;
  JTextField decimalspace;
  JTextField hexspace;
  JTextField binaryspace;
  
  /* Constructor
   * new layout,decimal,hex,binary,decimalspace,hexspace,binaryspace
   */
  public Convert() {
    super("Convert Numbers");
    layout = new GridLayout(0,2);
    decimal = new JLabel("Decimal");
    hex = new JLabel("Hex");
    binary = new JLabel("Binary");
    decimalspace = new JTextField(25);
    hexspace = new JTextField(25);
    binaryspace = new JTextField(25);
    decimalspace.setHorizontalAlignment(SwingConstants.RIGHT);
    hexspace.setHorizontalAlignment(SwingConstants.RIGHT);
    binaryspace.setHorizontalAlignment(SwingConstants.RIGHT);
    
    decimalspace.addActionListener (new fromdecimal(decimalspace));
    hexspace.addActionListener (new fromhex(hexspace));
    binaryspace.addActionListener (new frombinary(binaryspace));
    panel = new JPanel(layout);
    panel.add(decimal);
    panel.add(decimalspace);
    panel.add(hex);
    panel.add(hexspace);
    panel.add(binary);
    panel.add(binaryspace);
    add(panel);
    setVisible(true);
    setSize(400,250);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public class fromdecimal implements ActionListener {
    JTextField current1;
    String current;
    fromdecimal(JTextField space) {
      current1 = space;
    }
    public void actionPerformed (ActionEvent event) {
      current = current1.getText();
      hexspace.setText(decimaltohex(current));
      binaryspace.setText(decimaltobinary(current));
    }
  }
  
  public class fromhex implements ActionListener {
    JTextField current1;
    String current;
    fromhex(JTextField space) {
      current1 = space;
    }
    public void actionPerformed (ActionEvent event) {
      current = current1.getText();
      decimalspace.setText(hextodecimal(current));
      binaryspace.setText(decimaltobinary(hextodecimal(current)));
    }
  }
  
  public class frombinary implements ActionListener {
    JTextField current1;
    String current;
    frombinary(JTextField space) {
      current1 = space;
    }
    public void actionPerformed (ActionEvent event) {
      current = current1.getText();
      decimalspace.setText(binarytodecimal(current));
      hexspace.setText(decimaltohex(binarytodecimal(current)));
    }
  }
  
  public String decimaltobinary(String i) {
    int value = Integer.parseInt(i);
    String result = "";
    ArrayList<Integer> binaries = new ArrayList<>();
    while ( value > 0) {
      binaries.add(value%2);
      value = value/2;
    }
    for (int k = binaries.size()-1; k >= 0; k--) {
      result = result + binaries.get(k);
    }
    return result;
  }
  
  public String decimaltohex(String i) {
    int value = Integer.parseInt(i);
    String result = "";
    ArrayList<Integer> hexes = new ArrayList<>();
    char[] meaningofhexes = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'}; 
    while ( value > 0) {
      hexes.add(value%16);
      value = value/16;
    }
    for (int k = hexes.size()-1; k >= 0; k--) {
      result = result + meaningofhexes[hexes.get(k)];
    }
    return result;
  }
  
  
  public String hextodecimal(String i) {
    int last = 0;
    String result = "";
    char[] meaningofhexes = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    for (int k = i.length()-1; k >= 0; k--) {
      for (int m = 15; m >= 0; m--) {
        if ( meaningofhexes[m] == i.charAt(k)) {
          last =  last + m * ((int)Math.pow(16,(i.length())-1-k));
        }
      }
    }
    result = Integer.toString(last);
    return result;
  }
  
  public String binarytodecimal(String i) {
    int last = 0;
    String result = "";
    for (int k = 0; k < i.length(); k++) {
      int current = Integer.parseInt(String.valueOf(i.charAt(k)));  
      System.out.println(last + "-----" + i.charAt(k) + "--------" + (int)Math.pow(2,i.length()-1-k));
      if(current == 1)
      last = last + (int)Math.pow(2,(i.length()-1-k));
    }
    result = Integer.toString(last);
    return result;
  }
  
  public static void main (String [] args) {
    new Convert();
  }
}
