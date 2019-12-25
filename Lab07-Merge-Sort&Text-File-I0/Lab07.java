/* 19.12.2019
 * 21702133
 * Kerem Alemdar
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Lab07 {
   /* this method return sorted String array of given 2 merged String array
    * @return mergeArray[]
    */
   public static String[] mergeSorted(String[] mergeArray,String[] a, String[] b) {
      int size1 = a.length;
      int size2 = b.length;
      int current = 0;
      int current1 = 0;
      int current2 = 0;

      while(current1<size1 && current2<size2) {
         if( a[current1].compareTo(b[current2]) < 0) {
            mergeArray[current] = a[current1];
            current1++;
            current++;
         }
         else {
            mergeArray[current] = b[current2];
            current2++;
            current++;
         }
      }
      
      while(current1 < size1) {
         mergeArray[current] = a[current1];
         current1++;
         current++;
      }
      
      while(current2 < size2) {
         mergeArray[current] = b[current2];
         current2++;
         current++;
      }
      return mergeArray;
   }
   /* this method merge String[] array into 2 array and sort them by using mergeSorted method
    * @param sorted array
    */
   public static void merge(String[] c) {
      int size = c.length;
      if(size < 2) {
         return;
      }
      String array[] = new String[size/2];
      String array1[] = new String[size-size/2];
      int current1 = 0;
      int current2 = 0;
      while (current1 < size/2) {
         array[current1] = c[current1];
         current1++;
      }
      while(current2 < size-size/2) {
         array1[current2] = c[current1+current2];
         current2++;
      }
      merge(array);
      merge(array1);
      mergeSorted(c,array,array1);
   }
   
   public static void main (String [] args) {
      //Variables
      Scanner scan;
      scan = null;
      int counter = 0;
      String scanned = "";
      String[] array;
      // files first to take the information another to print the result
      File file = new File("C:\\Users\\kerem.alemdar-ug\\Desktop\\Lab07\\houseman.txt");
      File file1 = new File("C:\\Users\\kerem.alemdar-ug\\Desktop\\Lab07\\houseman2.txt");
      // scan the file by only scannin A-Z a-z and 0-9
      try {
         scan = new Scanner(file);
         scan.useDelimiter("[^A-Za-z0-9]+");
      }
      catch(FileNotFoundException e) {
         e.printStackTrace();
      }
      // put the scanned file into array word by word
      while(scan.hasNext()) {
         scanned = scanned + scan.next() + "\n";
      }
      
      array = scanned.split("\n");
      
      merge(array);
      //Prints the result into the second file
      PrintWriter pwriter = null;
      try {
         pwriter = new PrintWriter(file1);
         for (int i = 0; i < array.length; i++) {
            if(i < array.length-1) {
               if(array[i].equals(array[i+1])) {}
               else{
                  pwriter.println(array[i]);
               }
            }
            else{
               pwriter.println(array[i]);
            }
         }
      }
      catch (FileNotFoundException e) {
         e.printStackTrace();
      }
      finally {
         if(pwriter != null) {
            pwriter.close();
         }
      }
      
   }
}