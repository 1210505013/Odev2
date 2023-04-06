import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordSearch {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\muhar\\OneDrive\\Masaüstü\\alice_in_wonderland.txt";
        String[] keywords = {"upon", "sigh", "Dormouse", "jury-box", "swim"};
        Map<String, Integer> keywordCount = new HashMap<>();
        for (String keyword : keywords) {
            keywordCount.put(keyword.toLowerCase(), 0);
        }
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.toLowerCase();
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (keywordCount.containsKey(word)) {
                        keywordCount.put(word, keywordCount.get(word) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String keyword : keywords) {
            System.out.println("Aranan Kelime \"" + keyword + "\" Metinde " + keywordCount.get(keyword.toLowerCase()) + " kez geçiyor.");
        }
    }
}
