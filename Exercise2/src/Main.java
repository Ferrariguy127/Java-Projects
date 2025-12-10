//David Bulin
//Exercise 2
//Word swapping
//10/17/2023

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<String> Temp = new ArrayList<>();

        //adds all the example words from the Word document.
        Temp.add("this");
        Temp.add("is");
        Temp.add("lots");
        Temp.add("of");
        Temp.add("fun");
        Temp.add("for");
        Temp.add("java");
        Temp.add("coders");

        System.out.println("This is the list before marklengthfour applies: " + Temp.toString());
        new marklengthfour().marklength4(Temp);
        //for each word in the array it will check if it is 4 characters and if it is it will add an indexed position
        //just before it and fill it with the **** we are trying for.
        System.out.println("The new list will be: " + Temp);

        }
        }