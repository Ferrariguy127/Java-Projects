// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
//
public class Main {
    public static void main(String[] args) {
        int rows = 6; // This will create the 6 lines of vertical pyramid
        int cols = 5; // This will create the horizontal lines extending up to 5 places
        int counter = 1; // This is how many it will start with.
        int[][] array = new int[rows][cols]; // Creates the array with the values for rows and columns


        // This for loop will take the number of rows and columns.
        // and gradually fill the pyramid with the values from 1-15
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                array[i][j] = counter;
                System.out.print(array[i][j] + ", "); // This statement will take the array value and add a comma behind it.
                counter++;
            }
            System.out.println(); //This adds a new line behind each row extending up.
        }
    }
}
