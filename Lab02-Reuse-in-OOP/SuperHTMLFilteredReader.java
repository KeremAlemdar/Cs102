import java.util.ArrayList;

public class SuperHTMLFilteredReader extends HTMLFilteredReader{
  
   /** Constructor
     * @return HTMLFilteredReader
     */
  public SuperHTMLFilteredReader(String s) {
    super(s);
  }
  
  /** Constructor
    * @return SimpleURLReader
    */
  public SuperHTMLFilteredReader(String s,boolean m) {
    super(s,m);
  }
  
  /** return every single link in the text, after href="
    * @return links
    */
  public ArrayList<String> getLinks() {
    String str = super.getPageContents();
    ArrayList <String> links = new ArrayList<>();
    String start = "href=";
    char end = '>';
    String toadd;
    boolean quit = true;
    int added = 0;
    int current;
    for (int i =0; i <str.length()-10; i++) {
      String substart = str.substring(i, i+5);
      String remaining = str.substring(i+6, str.length());
      if (substart.equals(start)) {
        int index = remaining.indexOf(end);
        toadd = remaining.substring(0, index-1);
        if (links.contains(toadd)) {
        }
        else {
          char b = '"';
          int theindex = toadd.indexOf(b);
          toadd = toadd.substring(theindex+1, toadd.length());
          theindex = toadd.indexOf(b);
          if (theindex > 0)
            toadd = toadd.substring(0, theindex);
          links.add(toadd);
        }
      }
    }
    return links;
  }
}