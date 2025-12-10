import java.util.LinkedList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        //add an arraylist to store the values
        list.add(10);
        list.add(31);
        list.add(42);
        list.add(23);
        list.add(44);
        list.add(75);
        list.add(86);
        list.printlist();
        System.out.println();
        list.shift();
        list.printlist();
    }
}
