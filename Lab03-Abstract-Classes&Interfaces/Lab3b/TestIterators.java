/* Author: Kerem Alemdar
 * date: 31.10.2019
 */
import java.util.Iterator;

public class TestIterators {
 public static void main (String [] args) {
 
 Intbag bag = new Intbag();
 int a = 1;
 int b = 2;
 int c = 3;
 bag.addValueToEnd(a);
 bag.addValueToEnd(b);
 bag.addValueToEnd(c);

 Iterator i, j;
 i = new IntBagIterator( bag );
 while ( i.hasNext() )
 {
 System.out.println( i.next() );
 j = new IntBagIterator( bag );
 //j = bag.iterator();
 while ( j.hasNext() )
 {
 System.out.println( "--" + j.next() );
 }
 }
}
}
