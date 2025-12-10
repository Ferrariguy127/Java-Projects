/**
   A program that demonstrates the LinkedList class
   and also used the Iterator utility
*/
import java.util.*;

public class ListDemo {
   public static void main(String[] args) {
      LinkedList list = new LinkedList();
      ListIterator iterator = list.listIterator();

      // Use the iterator so that list has (in order) these elements
      // Tom->Romeo->Harry->Diana->Juliet->Nina->Jim
      iterator.add("Tom");
      iterator.add("Romeo");
      iterator.add("Harry");
      iterator.add("Diana");
      iterator.add("Juliet");
      iterator.add("Nina");
      iterator.add("Jim");

      // Task 1
      // Print all the elements of original list using the iterator
      // As long as the iterator has something following it will continue.
      iterator = list.listIterator();//resets the iterator position to the beginning.
      while (iterator.hasNext()) {
         System.out.println(iterator.next());
      }
      //resets the iterator to the beginning
      iterator = list.listIterator();
      System.out.println();
      System.out.println("This is the list with the removeLast method used");
      // Task 2
      // Call removeLast() to delete the last element of the list
      iterator.next();
      iterator.removeLast();


      // Task 3
      // Print all the elements of modified list using the iterator
      //as long as the values are not null it will print.
      iterator = list.listIterator();
      while (iterator.hasNext()) {
         System.out.println(iterator.next());
      }
   }
}
