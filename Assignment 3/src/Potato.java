import java.util.*;



public class Potato {



    public static void playWithDoublyLinkedList(int numPlayers, int passNum) {

        if (numPlayers <= 1) {

            System.out.println("Not enough players!");

            return;

        }

        // Create the circle of players

        DoublyLinkedList<Integer> playerCircle = new DoublyLinkedList<Integer>();

        for (int i = 1; i <= numPlayers; i++) {

            playerCircle.add(i);

        }

        // Create the iterator

        DoublyLinkedListIterator<Integer> iterator = playerCircle.iterator();

        // While there is more than one player in the circle...

        while (playerCircle.size() > 1) {

            // Go around the circle M-1 times

            for (int i = 0; i < passNum - 1; i++) {

                iterator.next();

            }

            // Remove the player at the current position

            iterator.remove();

            // Move to the next player

            iterator.next();

        }

        // Print the winner

        System.out.println("Player " + playerCircle.get(0) + " wins!");

    }



    public static void playWithLinkedList(int numPlayers, int passNum) {

        if (numPlayers <= 1) {

            System.out.println("Not enough players!");

            return;

        }

        // Create the circle of players

        LinkedList<Integer> playerCircle = new LinkedList<Integer>();

        for (int i = 1; i <= numPlayers; i++) {

            playerCircle.add(i);

        }

        // Create the iterator

        ListIterator<Integer> iterator = playerCircle.listIterator();

        // While there is more than one player in the circle...

        while (playerCircle.size() > 1) {

            // Go around the circle M-1 times

            for (int i = 0; i < passNum - 1; i++) {

                iterator.next();

            }

            // Remove the player at the current position

            iterator.remove();

            // Move to the next player

            if (iterator.hasNext()) {

                iterator.next();

            } else {

                iterator = playerCircle.listIterator();

            }

        }

        // Print the winner

        System.out.println("Player " + playerCircle.get(0) + " wins!");

    }



    public static void main(String[] args) {

        playWithDoublyLinkedList(5, 1);

        playWithLinkedList(5, 1);

    }

}
