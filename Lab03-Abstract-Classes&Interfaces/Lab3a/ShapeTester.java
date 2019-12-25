/* Author: Kerem Alemdar
 * date: 31.10.2019
 */
import java.util.Scanner;

public class ShapeTester {

 public static void main(String[] args) {
  
  ShapeContainer container = new ShapeContainer();
  Scanner scan = new Scanner(System.in);
  Shape olustur;
  int selection;
  int radius;
  int height;
  int width;
  int side;
  
  do {
    System.out.println("1-Create a new container");
    System.out.println("2-To add circle");
    System.out.println("3-To add rectangle");
    System.out.println("4-To Sum all");
    System.out.println("5-To locate a shape");
    System.out.println("6-To select in order to x,y");
    System.out.println("7-To Delete selected");
    System.out.println("8-QUIT");

   selection = scan.nextInt();
   if ( selection == 1) {
      container = new ShapeContainer();
   }
   else if ( selection == 2) {
    System.out.println("\nEnter radius");
    radius = scan.nextInt();
    olustur = new Circle(radius);
    container.add(olustur);
   }
   else if (selection == 3) {
    System.out.println("\nEnter width,height");
    width = scan.nextInt();
    height = scan.nextInt();
    if (width == height) {
     side = width;
     olustur = new Square(side);
     container.add(olustur);
    }
    else {
     olustur = new Rectangle(width,height);
     container.add(olustur);
    }
   }
   else if (selection == 4) {
    System.out.println();
    String s = container.toString();
    System.out.println(s);
   }
   else if (selection == 5) {
    System.out.println(container.toString());
    System.out.println("\nChoose the index of the shape you want to Locate");
    int b = scan.nextInt();
    System.out.println("\nEnter x,y");
    double x = scan.nextDouble();
    double y = scan.nextDouble();
    container.get(b).setLocation(x, y);

   }
   else if (selection == 6) {
    System.out.println("\nFor Shape contains enter x,y");
    int x = scan.nextInt();
    int y = scan.nextInt();
    Shape first = container.Firstselect(x, y);
    System.out.println(first.toString());
   }
   else if (selection == 7) {
    container.delete();
   }
   System.out.println();
  }while (selection != 8);

 }

}
