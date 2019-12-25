import java.util.ArrayList;
import java.util.Scanner;
import cs1.SimpleURLReader;


public class MenuForReader{
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    ArrayList<String> collection = new ArrayList<>();
    HTMLFilteredReader reader2;
    MySimpleURLReader reader1;
    int selection;
    String url;
    String currenturl;
    String txt = "txt";
    String html = "html";
    int secondselection;
    do {
      System.out.println();
      System.out.println("(1) Enter the url of poem to add to collection");
      System.out.println("(2) List all poems in the collection");
      System.out.println("(3) Quit");
      selection = scan.nextInt();
      if (selection == 1) {
        System.out.println("Enter URL");
        url = scan.next();
        collection.add(url);
      }
      else if (selection == 2) {
        for (int i = 0; i < collection.size(); i++) {
          currenturl = collection.get(i);
          if (currenturl.indexOf(txt) > 0) {
            reader1 = new MySimpleURLReader(currenturl);
            System.out.println(i+1 + " - " + reader1.getName());
          }
          else {
            reader2 = new HTMLFilteredReader(currenturl);
            System.out.println(i+1 + " - " + reader2.getName());
          }
        }
        do {
          secondselection = scan.nextInt();
          if (secondselection != collection.size()+1) {
            currenturl = collection.get(secondselection-1);
            if (currenturl.indexOf(txt) > 0) {
              reader1 = new MySimpleURLReader(currenturl);
              System.out.println(reader1.getPageContents());
              secondselection = collection.size()+1;
            }
            else {
              reader2 = new HTMLFilteredReader(currenturl);
              System.out.println(reader2.getPageContents());
              secondselection = collection.size()+1;
            }
          }
        }while(secondselection != collection.size()+1);
      }
    }while(selection != 3);
    System.out.println("End of the Program");
  }
}
