/* Author: Kerem Alemdar
 * date: 31.10.2019
 */
import java.util.Iterator;

public class IntBagIterator implements Iterator<Object> {
 
 Intbag aBag;
 
 int index;
 
 public IntBagIterator(Intbag bag) {
  aBag = bag;
  index = 0;
 }
 
 @Override
 public boolean hasNext() {
  if (index <= aBag.currentlength()-1)
   return true;
  else
   return false;
 }

 @Override
 public Object next() {
  int[] aBeg = aBag.getBag();
  int toreturn = aBeg[index];
  index++;
  return toreturn;
 }

}
