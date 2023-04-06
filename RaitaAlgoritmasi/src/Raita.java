import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Raita {
    public static void main(String[] args) {
        String fileName = <Buraya Dosya Yolu Girilecek>;
        String[] searchWords = {"upon", "sigh", "Dormouse", "jury-box", "swim"};
        Set<String> wordSet = new HashSet<>(Arrays.asList(searchWords));
        Map<String, Integer> wordCountMap = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (wordSet.contains(word)) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String word : searchWords) {
            int count = wordCountMap.getOrDefault(word, 0);
            System.out.println("Aranan kelime "+ word + " metinde " + count + " kez geçiyor. ");
        }
    }
}
