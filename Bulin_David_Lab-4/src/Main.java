import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
//Using OOP, Write and test a method called interleave that accepts two ArrayLists of Integers, a1 and a2, as parameters
//and inserts the elments of a2 into a1 at alternating indexes.
//print the values before and after
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<Integer>();//creates a1 and a2 populating them with proper data
        ArrayList<Integer> a2 = new ArrayList<Integer>();
        for (int i = 1; i <= 3; i++) {
            a1.add(i * 10);
        }
        for (int i = 3; i < 8; i++) {
            a2.add(i + 1);
        }

        int i;//creates the print statements to print the arraylist in order and proper format.
        System.out.println("Before interleaving:");
        System.out.print("a1: ");
        for (i = 0; i < a1.size(); i++) {
            System.out.print(a1.get(i) + ", ");
        }
        System.out.print("\n");

        System.out.print("a2: ");
        for (i = 0; i < a2.size(); i++) {
            System.out.print(a2.get(i) + ", ");
        }
        System.out.print("\n");
        InterLeave(a1, a2);//calls the function Interleave from

        System.out.println("After interleaving:");
        System.out.print("a1: ");
        for (i = 0; i < a1.size(); i++) {
            System.out.print(a1.get(i) + ", ");
        }
        System.out.print("\n");
    }

    private static void InterLeave(ArrayList<Integer> a1, ArrayList<Integer> a2) {
        int i;
        for (i = 0; i < a1.size(); i++) { //as long as a1 is less than the length of the array in this case its length is 3
            if (2 * i + 1 > a1.size()) {  // the code will run these loops
                break;
            }
            if (i < a2.size()) {//same as above but for a2
                a1.add(2 * i + 1, a2.get(i));//will add the components from a2 to a1s table
            }
        }
        for (i = i; i < a2.size(); i++) {//this loops through everything from a2 that is larger than a1s initial table size
            a1.add(a2.get(i));
        }
    }
}
