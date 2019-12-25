import java.util.Arrays;
import java.util.Scanner;

public class Menu {
  public static void main (String [] args) {
    
    Intbag collection = new Intbag();
    Scanner scan = new Scanner(System.in);
    int value;
    
    do {
      System.out.println("1. Create a new empty collection");
      System.out.println("2. Read a set of positive values into the collection");
      System.out.println("3. Print the collection of values");
      System.out.println("4. Add a value to the collection of values at a specified location");
      System.out.println("5. Remove the value at a specified location from the collection of values");
      System.out.println("6. Remove all instances of a value within the collection");
      System.out.println("7. Fibonacci");
      System.out.println("8. Quit the program");
      value = scan.nextInt();
      if (value == 1 ) {
         collection.removeAll();
         System.out.println("New collection has been created \n");
      }
      if (value == 2 ) {
         int next = scan.nextInt();
         while (next != 0 ) {
            collection.addValueToEnd(next);
            next = scan.nextInt();
         }
      }
      if (value == 3 ) {
         System.out.println(collection.toString());
      }
      if (value == 4 ) {
         System.out.println("Enter value first then index");
         int valuetoenter = scan.nextInt();
         int indextoput = scan.nextInt();
         indextoput--;
         collection.addValueToIndex(indextoput,valuetoenter);
      }
      if (value == 5) {
         System.out.println("Enter the index to remove");
         int indextoremove = scan.nextInt();
         indextoremove--;
         collection.removeValueFromIndex(indextoremove);
      }
      if (value == 6) {
         System.out.println("Enter the value to remove all");
         int toremove = scan.nextInt();
         collection.removeAllInstances(toremove);
      }
      if (value == 7) {
         collection.addfibo();
      }
         
    }while (value != 8);
  }
}