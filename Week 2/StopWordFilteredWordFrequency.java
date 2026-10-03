import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StopWordFilteredWordFrequency {

    static void printFilteredWordFrequency(String feedback) {

        // Stop words
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        // Normalize text
        String cleanedText = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "");

        // Split into words
        String[] words = cleanedText.split("\\s+");

        // Store word frequencies
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            boolean isStopWord = false;

            // Check whether the word is a stop word
            for (String stopWord : stopWords) {
                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            // Skip stop words
            if (isStopWord) {
                continue;
            }

            // Count frequency
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        // Sort words by frequency in descending order
        Set<Map.Entry<String, Integer>> entries = frequency.entrySet();

        java.util.ArrayList<Map.Entry<String, Integer>> list =
                new java.util.ArrayList<>(entries);

        list.sort((a, b) -> b.getValue() - a.getValue());

        // Print result
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        String feedback =
                "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}
