import java.util.*;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static int Rows = 4;//set value of rows equal to 4 which came from the template
    static int Columns = 4;//set value of columns equal to 4 from the template

    public static void main(String[] args) {
        Matrix MyArray = new Matrix(4, 4);

        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Columns; j++) {
                MyArray.SetPositions(i,j,i*2);
            }
        }
        MyArray.printMatrix();
    }
}