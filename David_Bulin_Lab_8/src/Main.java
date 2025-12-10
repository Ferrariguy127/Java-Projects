import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//David Bulin
//Palindrome checker lab 8
//Oct 27 2023

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Queue<Integer> Sequence1 = new LinkedList<>();
        Queue<Integer> Sequence2 = new LinkedList<>();
        Queue<Integer> Sequence3 = new LinkedList<>();
        Queue<Integer> Sequence4 = new LinkedList<>();
        Sequence1.add(3);
        Sequence1.add(8);
        Sequence1.add(17);
        Sequence1.add(9);
        Sequence1.add(17);
        Sequence1.add(8);
        Sequence1.add(3);

        Sequence2.add(3);
        Sequence2.add(17);
        Sequence2.add(9);
        Sequence2.add(4);
        Sequence2.add(17);
        Sequence2.add(3);

        //Sequence 3 is a blank test case so no values will be added

        Sequence4.add(1);
        Sequence4.add(2);
        Sequence4.add(3);
        Sequence4.add(4);
        Sequence4.add(5);



        Palindrome.stackmaster(Sequence1);
        System.out.println("Sequence 1 is " + Sequence1);
        if (Palindrome.stackmaster(Sequence1)) {
            System.out.println("This is a palindrome");

        }
        else {
            System.out.println("This is not a palindrome");
        }

        Palindrome.stackmaster(Sequence2);
        System.out.println("Sequence 2 is " + Sequence2);
        if (Palindrome.stackmaster(Sequence2)) {
            System.out.println("This is a palindrome");

        }
            else{
                System.out.println("This is not a palindrome");
            }

        Palindrome.stackmaster(Sequence3);
        System.out.println("Sequence 3 is " + Sequence3);
        if (Palindrome.stackmaster(Sequence3)) {
            System.out.println("This is a palindrome");

        }
        else{
            System.out.println("This is not a palindrome");
        }

        Palindrome.stackmaster(Sequence4);
        System.out.println("Sequence 4 is " + Sequence4);
        if (Palindrome.stackmaster(Sequence4)) {
            System.out.println("This is a palindrome");

        }
        else{
            System.out.println("This is not a palindrome");
        }
        }
        }
