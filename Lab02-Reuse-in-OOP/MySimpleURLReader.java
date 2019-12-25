import cs1.SimpleURLReader;

public class MySimpleURLReader extends SimpleURLReader {
  
  String urlname;
  
  /** Constructor
    * @param SimpleURLReader
    */
  public MySimpleURLReader(String s) {
    super(s);
    urlname = s;
  }
  
  /** return the url
    * @return urlname
    */
  public String getURL() {
    return urlname;
  }
  
  /** return name in the url which is after the "/" 
    * @return getName
    */
  public String getName() {
    int lastindex = urlname.lastIndexOf('/');
    return urlname.substring(lastindex +1 ,urlname.length());
  }
  
  /** return contents of the page
    * @return getPageContents
    */
  public String getPageContents() {
    String str = super.getPageContents();
    int index = str.indexOf("null");
    return str.substring(index+4 , str.length());
  }
  
}
