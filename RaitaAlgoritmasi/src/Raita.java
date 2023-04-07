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
        // Dosya adı belirtilir.
        String fileName = <Buraya Dosya Yolu Girilecek>;
        
        // Aranacak kelimeler bir dizi olarak belirtilir.
        String[] searchWords = {"upon", "sigh", "Dormouse", "jury-box", "swim"};
        
        // Aranacak kelimeler bir küme halinde saklanır.
        Set<String> wordSet = new HashSet<>(Arrays.asList(searchWords));
        
        // Kelimelerin sayılarının saklanacağı sözlük oluşturulur.
        Map<String, Integer> wordCountMap = new HashMap<>();
        
        try {
            // Dosya okuyucu oluşturulur.
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            // Dosya satır satır okunur.
            while ((line = reader.readLine()) != null) {
                // Satırdaki kelimeler boşluklara göre ayrılır.
                String[] words = line.split("\\s+");
                // Her kelime için kontrol yapılır.
                for (String word : words) {
                    // Eğer kelime aranacak kelimeler kümesinde yer alıyorsa
                    if (wordSet.contains(word)) {
                        // Kelime sayısı bir artırılır veya 1 olarak ayarlanır.
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
            // Dosya okuyucu kapatılır.
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Aranacak kelimelerin her biri için
        for (String word : searchWords) {
            // Kelime sayısı alınır veya kelime sözlükte yoksa 0 olarak ayarlanır.
            int count = wordCountMap.getOrDefault(word, 0);
            // Sonuç ekrana yazdırılır.
            System.out.println("Aranan kelime " + word + " metinde " + count + " kez geçiyor. ");
        }
    }
}
