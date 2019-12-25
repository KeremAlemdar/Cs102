public class HTMLFilteredReader extends MySimpleURLReader{
  
  boolean doo;
  
  /** Constructor
    * @param MySimpleURLReader
    */
  public HTMLFilteredReader(String s) {
    super(s);
    doo = true;
  }
  
  /** Constructor
   * @param MySimpleURLReader
   */
  public HTMLFilteredReader(String s, boolean m) {
    super(s);
    doo = m;
  }
  
  /** this returns page contents
   * @return print , str
   */
  public String getPageContents() {
    String str = super.getPageContents();
    if (doo == true) {
      String print = "";
      int currentstart = 0;
      int currentend = 0;
      char start = '>';
      char end = '<';
      for (int i = 0; i <=str.length()-1; i++) {
        char current = str.charAt(i);
        if (current == start) {
          currentstart = i;
        }
        if (current == end) {
          currentend = i;
        }
        if (currentend > currentstart) {
          String toadd = str.substring(currentstart+1, currentend);
          int exist = print.indexOf(toadd);
          if (exist == -1) {
            print = print + toadd;
          }
        }
      }
      print = print.replaceAll("&quot;", " ");
      print = print.replaceAll("&nbsp;", " ");
      return print;
    }
    else {
      return str;
    }
  }
  
  public double getPercentage() {
     String str1 = super.getPageContents();
     String str2 = getPageContents();
     int k = str1.length();;
     int m = str2.length();
     double l = k % m;
     return l;
}
}