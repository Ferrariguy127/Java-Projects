import java.util.ArrayList;

public class marklengthfour {
    public static void marklength4(ArrayList<String>list){
    int Finish = list.size();//the variable to hold how large the list is.
    int index = 0; //index acts as a counter that will hold each position as it moves through the arraylist
    for(int i=0; i<Finish;i++){
    //the code that will add the **** ahead of a character of 4.
    String Swapper = list.get(index);
        if (Swapper.length()==4){
        list.add(index,"****");
        index++;
    }
        index++;//progresses the index to the next word. without this it just prints all the **** for each word.
}

    }

}
