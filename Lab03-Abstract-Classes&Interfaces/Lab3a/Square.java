/* Author: Kerem Alemdar
 * date: 31.10.2019
 */
public class Square extends Rectangle {
 int side;
 
 public Square(int side) {
  super(side,side);
  this.side = side;
  height = side;
  width = side;
 }
 
 /* return information about square
  * @return
  */
 public String toString() {
  if ( getSelected() == true) {
   return "This shape in a Square with side = " + side + ". Its area is " + getArea() + ". And it is SELECTED";
  }
  return "This shape in a Square with side = " + side + ". Its area is " + getArea() + ". And it is not Selected";
 }
 
}
