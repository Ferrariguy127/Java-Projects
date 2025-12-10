//David Bulin
//CS245 Assignment 4
//This creates the linked list that is used for the game
public class CircularLinkedList {
    Player head;
    private Player tail;
    private Player previous;

    public void addPlayer(String name) {
        Player newPlayer = new Player(name);
        if (head == null) {
            head = newPlayer;
            tail = newPlayer;
            newPlayer.setNext(head);
            newPlayer.setPrevious(head);

        } else {
            tail.setNext(newPlayer);
            newPlayer.setNext(head);
            newPlayer.setPrevious(tail);
            tail = newPlayer;
            head.setPrevious(newPlayer);
        }
    }

    // When it removes a player it sets the head value to the previous tail value.
    public void removePlayer(String name) {
        if (head == null) {
            return;
        }
        Player currentPlayer = head;

        do {
            if (currentPlayer.getName().equals(name)) {
                if (currentPlayer == head && currentPlayer.getNext() == head) {
                    head = null;
                } else if (currentPlayer == head) {
                    head.getNext().setPrevious(tail);
                    tail.setNext(head.getNext());
                    head = head.getNext();

                } else {
                    //The flaw lies within these lines for the current bug.
                    //When a player is eliminated at the head position it is running into a problem of it re-adds
                    //the eliminated player to the killring:

                    //This should update the previous players next to be the person after currentplayer
                    //effectively removing them from the list
                    currentPlayer.getPrevious().setNext(currentPlayer.getNext());

                    //Gets the value of the next person then updates the previous value to be that
                    //Of the player after current player
                    currentPlayer.getNext().setPrevious(currentPlayer.getPrevious());
                    System.out.println(head);
                }
                System.out.println(name + " has been eliminated.");
                return;
            }
            currentPlayer = currentPlayer.getNext();
        }
        while (currentPlayer != head);

    }
//For each round it will print the ring or if the is empty
    public void printKillRing() {
        if (head == null) {
            System.out.println("The kill ring is empty.");
            return;
        }
        Player currentPlayer = head;
        System.out.println("Kill Ring:");
        do {
            System.out.println(currentPlayer.getName());
            currentPlayer = currentPlayer.getNext();
        } while (currentPlayer != head);
    }
}
