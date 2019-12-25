import java.util.ArrayList;
import cs1.SimpleURLReader;

public class Lab02a {
  public static void main (String [] args) {
    SimpleURLReader readed3 = new SimpleURLReader("http://www.cs.bilkent.edu.tr/~adayanik/cs102/docs/housman.htm");
    SimpleURLReader readed = new SimpleURLReader("http://www.cs.bilkent.edu.tr/~adayanik/cs102/docs/housman.txt");
    MySimpleURLReader readed2 = new MySimpleURLReader("http://www.cs.bilkent.edu.tr/~adayanik/cs102/docs/housman.txt");
    HTMLFilteredReader readed4 = new HTMLFilteredReader("http://www.cs.bilkent.edu.tr/~adayanik/cs102/docs/housman.htm");
    HTMLFilteredReader readed42 = new HTMLFilteredReader("https://docs.oracle.com/javase/tutorial/");
    SimpleURLReader readed41 = new SimpleURLReader("https://docs.oracle.com/javase/tutorial/");
    SuperHTMLFilteredReader readed43 = new SuperHTMLFilteredReader("https://docs.oracle.com/javase/tutorial/",false);
    SuperHTMLFilteredReader readed44 = new SuperHTMLFilteredReader("https://docs.oracle.com/javase/tutorial/",false);
    SuperHTMLFilteredReader readed45 = new SuperHTMLFilteredReader("https://docs.oracle.com/javase/tutorial/");
    
    String pagecontent = readed.getPageContents();
    int linecount = readed.getLineCount();
    System.out.println(pagecontent);
    System.out.println(linecount);
    System.out.println(readed2.getURL());
    System.out.println(readed2.getName());
    System.out.println("***************************");
    System.out.println(readed2.getPageContents());
    System.out.println("***************************");
    System.out.println(readed4.getPageContents());
    System.out.println("Project d");
    System.out.println(readed42.getPageContents());
    System.out.println("Project e");
    System.out.println(readed41.getPageContents());
    System.out.println("Project f");
    System.out.println(readed44.getPageContents());
    System.out.println("Project dsadsa");
    ArrayList<String> links = new ArrayList<>();
    links = readed44.getLinks();
    for (int i = 0; i < links.size(); i++) {
      System.out.println(links.get(i));
    }
    System.out.println("*****");
    System.out.println(readed4.getPercentage());
    
    
    
    
    
  }
}