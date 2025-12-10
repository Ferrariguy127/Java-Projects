public class Main {
    public static void main(String[] args) {
// Sample list of words
        String[] words ={"banana", "bends", "i", "mend", "sandy"};

        // Call the pairCounts method to get the counts of 2-character sequences
        PairCounts Wordles = new PairCounts();
        //this prints out the count of each 2 character chunk.
        System.out.println(PairCounts.pairCounts(words));

    }
}