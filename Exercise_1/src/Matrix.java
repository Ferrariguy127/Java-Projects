import java.util.*;
    final public class Matrix {
        //System.out.println("Please enter the number of rows in the matrix.");
        int Rows;
        int Columns;
        int[][] array;

        //The Code below will help create a matrix
        public Matrix(int Rows, int Columns) {
            this.Rows = Rows;
            this.Columns = Columns;
            array = new int[Rows][Columns];
        }
        //this will return the total number of rows
        public int getRowCount() {
            return this.Rows;
        }
        //will return the total number of columns
        public int getColumnsCount() {
            return this.Columns;
        }

        //this code is used to update the value at a position by a set x value
        public void SetPositions(int i, int j, int x) {

            array[i][j] = x;
        }

        public void printMatrix() { //this prints the matrix in a nice format
            for (int i = 0; i < Rows; i++) {
                for (int j = 0; j < Columns; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
