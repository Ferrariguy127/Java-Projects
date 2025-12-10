import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



public class Main {
    public static void main(String[] args) {

        // Create ArrayLists to hold the contents of the text files
        ArrayList<String> speechWords = new ArrayList<>();
        ArrayList<String> stopWords = new ArrayList<>();

        // Read Quit_India_Speech_Gandhi.txt file and add words to speechWords ArrayList
        try {
            File speechFile = new File("black_lives_matter_espy_speech.txt");
            Scanner speechReader = new Scanner(speechFile);
            while (speechReader.hasNext()) {
                speechWords.add(speechReader.next());
            }
            speechReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Speech file not found.");
        }

        // Read Common_Stop_Words.txt file and add words to stopWords ArrayList
        try {
            File stopFile = new File("common_stop_words.txt");
            Scanner stopReader = new Scanner(stopFile);
            while (stopReader.hasNext()) {
                stopWords.add(stopReader.next());
            }
            stopReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Stop words file not found.");
        }

        // Display total number of words in the speech file
        System.out.println("Total number of words in the speech: " + speechWords.size());

        // Create a HashSet to hold unique words in the speech file
        HashSet<String> uniqueSpeechWords = new HashSet<>(speechWords);

        // Display total number of unique words in the speech file
        System.out.println("Total number of unique words in the speech: " + uniqueSpeechWords.size());

        // Convert all words in the speech file to lowercase
        for (int i = 0; i < speechWords.size(); i++) {
            speechWords.set(i, speechWords.get(i).toLowerCase());
        }

        // Remove all stop words from the speech file
        for (String stopWord : stopWords) {
            speechWords.removeAll(Collections.singleton(stopWord.toLowerCase()));
        }

        // Display total number of words in the modified speech file
        System.out.println("Total number of words in the modified speech: " + speechWords.size());

        // Create a HashSet to hold unique words in the modified speech file
        HashSet<String> uniqueModifiedWords = new HashSet<>(speechWords);

        // Display total number of unique words in the modified speech file
        System.out.println("Total number of unique words in the modified speech: " + uniqueModifiedWords.size());

        // Create a HashMap to hold the frequency of each unique word in the modified speech file
        HashMap<String, Integer> wordFrequency = new HashMap<>();
        for (String word : speechWords) {
            if (wordFrequency.containsKey(word)) {
                wordFrequency.put(word, wordFrequency.get(word) + 1);
            } else {
                wordFrequency.put(word, 1);
            }
        }

        // Create a List to hold the entries of the HashMap
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>();
        /*String BLM;
        ArrayList<String> BlackLivesMatter = new ArrayList<String>();
        ArrayList<String> StopWords = new ArrayList<String>();
        Scanner scan = new Scanner("black_lives_matter_espy_speech.txt");
        while (scan.hasNext()) ;
        {

            BLM = String.valueOf(scan.hasNext());
            System.out.println(BlackLivesMatter);
            System.out.println("1");
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
        }
        System.out.println(BLM);
*/
    }
}