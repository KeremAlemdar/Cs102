import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intbag 
{
   int current = 0;
   private int[] bag;
   
   /** Creates array with the empty array.
     * @param bag.
     */
   public Intbag() 
   {
      bag = new int[4];
   }
   /**
    * returns the value
    * @return current value
    */
   public int[] getBag() 
   {
      return bag;
   }
   
   /**
    *this methot add value to end of the arrray until input equals the 0
    * @param add value to end
    */
   public void addValueToEnd(int value) 
   {
      if (value < 0) //control input is valid
      {
         System.out.println("Please enter valiz input");
      }
      
      List<Integer> list = new ArrayList<>();
      
      //copy the bag to new arraylist
      for(int element : bag)
         list.add(element);
      
      int index = list.indexOf(0);
      
      if (index >= 0) 
      {
         if(current == bag.length -1)
            bag = doubleCapacity(bag);
         
         bag[index] = value;
         current++;
      } 
      
      else 
      {
         list.clear();
         if(current == bag.length)
            bag = doubleCapacity(bag);
         for(int element : bag) 
            list.add(element);
         
         index = list.indexOf(0);
         bag[index] = value;
         current++;
      }
   }
   
    /**
    * add value to index
    * @param add value to index
    */
   public void addValueToIndex(int index, int value) 
   {
      //check input whether it is valid or not
      if (index == bag.length - 1) 
         System.out.println("It means add to end of the array.Please use other method");;
      
      if (index >= bag.length || index < 0) 
      {
         System.out.println("Index is out of bounds");
      }
      
      
      else 
      {
         int[] newArray = new int[bag.length + 1];
         
         for (int i = 0; i < index; i++) 
         {
            newArray[i] = bag[i];
         }
         newArray[index] = value;
         
         for (int i = index; i < bag.length; i++) 
         {
            newArray[i + 1] = bag[i];
         }
         bag = newArray;
         current++;
      }
   }
   

   /**
    *  Remove value from indicated index
    * @param remove value from index
    */
   public void removeValueFromIndex(int index) 
   {
      //check input whether it is valid or not
      if (index > bag.length - 1 || index < 0) 
      {
         System.out.println("Please enter a valid index");
      }
      
      int[] array = new int[bag.length - 1];
      
      for (int i = 0; i < index; i++) 
      {
         array[i] = bag[i];
      }
      
      for (int i = index + 1; i < bag.length; i++) 
      {
         array[i - 1] = bag[i];
      }
      bag = array;
      current--;
   }
   
    /**
    *  Remove 
    * @param remove
    */
   public void removev(int index) {
      
      ArrayList<Integer> list = new ArrayList<> ();
      for(int element : bag)
      {
         list.add(element);
      }
      int a = list.get(current - 2); 
      
      list.remove(index);
      list.add(index,a );
      list.remove(a - 1);
      
      int[] arr = new int[list.size()];
      
      for(int element = 0 ; element < list.size() ; element++)
      {
         arr[element] = list.get(element);
      }
      bag = arr;
      current--;
   }
      
    /**
    *  Removes all instances
    * @param removes all instances
    */
   public void removeAllInstances(int value)
   {
      //copy part the array
      ArrayList<Integer> arrayList = new ArrayList<>();
      
      int a = current-2;
      int counter = 0;
      for (int i : bag) 
      {
         arrayList.add(i);
      }
      
      //check input whether it is valid or not
      if (arrayList.indexOf(value) < 0) 
      {
         System.out.println("There is no such a number.");
      }
      
      //while there is no such that number replace items and delete the values
      while(arrayList.indexOf(value) >= 0)
      {
         int index = arrayList.indexOf(value);
         int addvalue = arrayList.get(a);
         arrayList.add(index + 1, addvalue);
         arrayList.remove(index);
         arrayList.remove(a);
         a--;
         current--;
      }
      
      int[] newArray = new int[arrayList.size()];
      
      for (int i = 0; i < newArray.length ; i++) 
      {
         newArray[i] = arrayList.get(i);
      }
      bag = newArray;
   }
   
   /**
    *  double the array size
    * @param it doubles the array size
    */
   private int[] doubleCapacity(int[] list) 
   {
      int[] array = new int[list.length * 2];
      for (int i = 0; i < list.length; i++) 
      {
         array[i] = list[i];
      }
      return array;
   }
   
   
   /**
    *  default array
    * @param default array
    */
   public void removeAll() 
   {
      int[] array = new int[4];
      bag = array;
      current = 0 ;
   }
   
   /**
    * write fibonacci
    * @param writes fibonacci
    */
   public void addfibo()
   {
      bag = new int[40];
      bag[0] = 0;
      bag[1] = 1;
      System.out.println("Before adding rest of the items");
      System.out.println(toString());
      System.out.println("After aading rest of the items");
      for(int i = 0 ; i < 40; i++ )
      {
         bag[i] = fibonacci(i);
      }
      System.out.println(toString());
   }
   
   /**
    * creates fibo by first 2 
    * @return create fibo by first two
    */
   public int fibonacci(int n)  
   {
      if(n == 0)
         return bag[0];
      else if(n == 1)
         return bag[1];
      else
         return bag[n - 1] + bag[n-2 ];
   }
   
   /**
    * writes the array
    * @return writes the array
    */
   public String toString() 
   {
      String b = "";
      for(int i = 0 ; i < bag.length ; i++)
      {
         if((bag[i] > 0) && (i>0)) {
           b += "," + bag[i]; }
         if ((bag[i] > 0) && (i<=0)) {
            b += bag[i];
      }
      }
      return "[" + b + "]";
      }
   }