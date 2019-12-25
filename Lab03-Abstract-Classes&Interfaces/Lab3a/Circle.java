/* Author: Kerem Alemdar
 * date: 31.10.2019
 */
public class Circle extends Shape implements Selectable {
 
 Circle now;
 int radius;
 boolean selected;
 
 public Circle(int radius) {
  super();
  this.radius = radius;
 }
 
/* calculates the area of the circle
 * @return area
 */
 public double getArea() {
  double area = Math.PI * Math.pow(radius, 2);
  return area;
 }

 @Override
 public boolean getSelected() {
  return selected;
 }

 @Override
 public void setSelected(boolean selectable) {
  selected = selectable;
 }

 @Override
 public Shape contains(int x, int y) {
  if ((x <= (getX()+radius)) && (x >= (getX()-radius)) && (y <= (getY()+radius)) && (y >= (getY()-radius))) {
   return this;
  }
  else {
  return null;
  }
 }
 
 /* returns the information about the circle
  * @return String
  */
 public String toString() {
  if ( getSelected() == true) {
   return "This shape in a Circle with radius = " + radius + ". Its area is " + getArea() + ". And it is SELECTED";
  }
  else {
   return "This shape in a Circle with radius = " + radius + ". Its area is " + getArea() + ". And it is not Selected";
  }
 }
}
