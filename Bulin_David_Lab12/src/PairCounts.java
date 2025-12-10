import java.util.*;
public class PairCounts {
    public static Map<String, Integer> pairCounts(String[] words) {
        // Create a TreeMap or HashMap to store the counts of the pairs, in this lab Tree matches the results better
        Map<String, Integer> counts = new TreeMap<>();
        //TreeMap<> will make it alphabetical but HashMap does not

        // Iterate through each word in the input list
        for (String word : words) {
            // Iterates through each character in the word, taking 2-character substrings
            for (int i = 0; i < word.length() - 1; i++) {
                // Get the 2-character substring (pair) starting from the current position
                String pair = word.substring(i, i + 2);

                // Increases the count of the pair as it goes through
                // If the pair is not present, put it in the map with a count of 1
                counts.put(pair, counts.getOrDefault(pair, 0) + 1);
            }
        }

        // Return the map containing the counts of the pairs
        return counts;
    }
}