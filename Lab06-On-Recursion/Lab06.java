/* Kerem Alemdar
 * 21702133
 * Lab06
 */
import java.util.ArrayList;


public class Lab06 {
   static boolean resultc =  false;
   static int count = 0;
   
   public static void main (String [] args) {
      
      // Variables A
      String a = "recursive";
      int a1 = 0;
      
      // Variables B
      int b = 1249;
      
      // Variables C
      ArrayList<String> c1 = new ArrayList<>();
      c1.add("abkerem");
      c1.add("ackerem");
      c1.add("akkerem");
      
      // Variables D
      int d = 4;
      int start = (int)Math.pow(10,d-1);
      
      
      // Prints all methods
      System.out.println(methoda(a,a1));
      System.out.println(methodb(b));
      System.out.println(methodc(c1));
      System.out.println(methodd(d,start,""));
   }
   
   /* this removes all 'r' in the string
    * @param print removed from 'r' string
    */
   public static String methoda(String a, int place) {
      if( place < a.length()) {
         if (a.charAt(place) == 'r') {
            a = a.replace("r","");
            methoda(a,place);
         }
         else {
            methoda(a,place+1);
         }
      }
      return a;
   }
   
   /* this method transforms decimal into hexidecimals
    * @param hexidecimal integer
    */
   public static String methodb(int b) {
      String[] hexadecimals = new String[]{"1","2","3","4","5","6","7","8","9","A","B","C","D","E"};
      if ( (b/16) < 1 ) {
         return hexadecimals[(b%16)-1];
      }
      else {
         int m = b%16;
         return methodb(b/16) + hexadecimals[m-1];
      }
   }
   
   /* this checks whether the String arraylist is in the alphabetic order or not
    * @param return true if String ArrayList is alphabetic
    */
   public static boolean methodc(ArrayList<String> c) {
      if ( count < c.size()-1) {
         if(c.get(0).compareTo(c.get(1)) < 0) {
            c.remove(0);
            resultc = true;
            return methodc(c);
         }
      }
      else {
         return resultc;
      }
      return false;
   }
   
   /* this method prints d digit even integers which is in increasing order
    * @param prints increasing order d digit integers
    */
   public static String methodd(int d,int start,String result) {
      if ( start > (int)Math.pow(10,d)) {
      }
      else {
         if(criteria(start)) {
            result = result + start + " ";
            return methodd(d,start+2,result);
         }
         else {
            return methodd(d,start+2,result);
         }
      }
      return result;
   }
   
   /*this check whether the integer is in increasing order
    *@return boolean if integer is increasing
    */
   public static boolean criteria(int m) {
      String number = String.valueOf(m);
      boolean result = true;
      for (int i = 0; i < number.length()-1; i++) {
         if(Integer.valueOf(number.charAt(i)) >= Integer.valueOf(number.charAt(i+1))) {
            result = false;
         }
      }
      return result;
   }
}
