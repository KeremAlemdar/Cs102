/* Author: Kerem Alemdar
 * date: 31.10.2019
 */
public class Rectangle extends Shape implements Selectable {
 
 int width;
 int height;
 boolean selected;
 
 public Rectangle(int width, int height) {
  super();
  this.width = width;
  this.height = height;
 }
 
 /* calculates the area of the rentangle
  * @return area
  */
 public double getArea() {
  double area = width*height;
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
  if ((x <= (getX()+width)) && (x >= getX()) && (y <= (getY()+height)) && (y >= getY())) {
   return new Rectangle(width,height);
  }
  else {
  return null;
  }
 }
 
 /* it returns the information about rectangle
  * @return String
  */
 public String toString() {
  if ( getSelected() == true) {
   return "This shape in a Rectangle with height = " + height + ". width = " + width + ". Its area is " + getArea() + ". And it is SELECTED";
  }
  else {
   return "This shape in a Rectangle with height = " + height + ". width = " + width +  ". Its area is " + getArea() + ". And it is not Selected";
  }
 }
 
}
