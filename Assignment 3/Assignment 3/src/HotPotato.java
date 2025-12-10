import java.util.LinkedList;
//David Bulin
//October 24th 2023
//Hot potato game, Assignment 3
public class HotPotato {
    public static void Hot_potato(int M, int N){
        int j = 0;//starting value of the index
        LinkedList HotPotato = new LinkedList();
        LinkedList Removed = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            HotPotato.add(i);
        }

        //while the size of the list is bigger than 1 it will run
        while (HotPotato.size() > 1) {
            //compute which index to remove from, remove said number from index then update what value j is.
            int s = HotPotato.size();
            int p = (M + j) % s;
            //Takes the values as they are removed from the HotPotato Linked list and adds them to Removed where
            //they are printed later
            Removed.add(HotPotato.get(p));
            HotPotato.remove(p);
            j = p;
            N--;
        }
        System.out.println("Players that were removed are, in order : " + Removed);
        System.out.println("Player " + HotPotato.get(0) + " Wins!");
    }
}