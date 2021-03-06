/* Author: Kerem Alemdar
 * date: 31.10.2019
 */
import java.util.ArrayList;

public class ShapeContainer {
 
 ArrayList<Shape> container;
 ArrayList<Shape> selected;
 public ShapeContainer() {
  container = new ArrayList<Shape>();
  selected = new ArrayList<Shape>();
 }
 
 /* add shape to the shape container
  * @param add
  */
 public void add(Shape s) {
  container.add(s);
  System.out.println("Shape added");
 }
 
 /* calculate sum of the shapes in the container
  * @param area
  */
 public double getArea() {
  double area = 0;
  for (int i = 0; i < container.size(); i++) {
   area = area + container.get(i).getArea();
  }
  return area;
 }
 
 /* it gives the index of the shape in the container
  * @return index
  */
 public Shape get(int index) {
  return container.get(index);
 }
 
 /* it make the first shape which is in x.y selected and return the shape itself
  * @return selected.get(0);
  */
 public Shape Firstselect(int x, int y) {
  for (int i = 0 ; i < container.size(); i++) {
   if (container.get(i).contains(x, y) != null)
      selected.add(container.get(i));
  }
  if (selected.get(0).getSelected() == true) {
     selected.get(0).setSelected(false);
  }
  else if (selected.get(0).getSelected() == false) {
     selected.get(0).setSelected(true);
  }
  return selected.get(0);
 }
 
 /* it removes the selected shapes in the container
  * @param container.remove(i)
  */
 public void delete() {
  for (int i = 0; i < container.size(); i++) {
   if(container.get(i).getSelected() == true)
    container.remove(i);
  }
 }
 
 /* it prints to total sum of the shapes in the container and informations of them
  * @return print
  */
 public String toString() {
  String print = "";
  for (int i =0; i < container.size(); i++)  {
   Shape current = container.get(i);
   print += current.toString() +"\n";
  }
  print += "Current sum = " + getArea();
  return print;
 }
}
