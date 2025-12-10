//David Bulin
//CS245 Assignment 4
//Assassin, takes a list of names and puts them into a kill ring to go against each other.

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        AssassinGame game = new AssassinGame();
        game.loadPlayersFromFile();
        game.playGame();
    }

}