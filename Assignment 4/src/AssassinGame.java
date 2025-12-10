//David Bulin
//CS245 Assignment 4
//The assassingame section is the core of this, using sections from all other files it should run all further functions

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//This is the heart of the program, it stores the values for the killRing and the Graveyard
public class AssassinGame {
    //The killRing is the players actively in the game
    private CircularLinkedList killRing = new CircularLinkedList();
    //Graveyard stores the values of the players after they've been eliminated
    public LinkedList<String> Graveyard = new LinkedList<>();

    //loadPlayersFromFile will take and adds them to the playerNames file, which is then used to
    public void loadPlayersFromFile() throws FileNotFoundException {
        File file = new File("player_names.txt");
        Scanner scanner = new Scanner(file);
        LinkedList<String> playerNames = new LinkedList<>();
        while (scanner.hasNextLine()) {
            playerNames.add(scanner.nextLine());
        }
        scanner.close();

        // Shuffle the player list so they're in random values
        Random random = new Random();
        for (int i = playerNames.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            String temp = playerNames.get(i);
            playerNames.set(i, playerNames.get(j));
            playerNames.set(j, temp);
        }

        for (String name : playerNames) {
            killRing.addPlayer(name);
        }
    }

    public void playGame() {
        if (killRing.head == null) {
            System.out.println("This game cannot be played alone, try again with others. ");
            return;
        }
        while (killRing.head.getNext() != killRing.head) {
            System.out.println("\nCurrent Kill Ring:");
            killRing.printKillRing();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the name of a player to be killed: ");
            String playerKilled = scanner.nextLine();
            Graveyard.add(playerKilled);
            killRing.removePlayer(playerKilled);
        }
        System.out.println("\nWinner is: " + killRing.head.getName());
        System.out.println("\nGraveyard:" + Graveyard);
    }
}
