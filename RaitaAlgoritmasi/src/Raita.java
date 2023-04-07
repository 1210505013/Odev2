import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Raita {

    public static void main(String[] args) {

        String fileName = "C:\\Users\\muhar\\OneDrive\\Masaüstü\\alice_in_wonderland.txt";

        // Aranacak kelimeleri belirleyin
        HashMap<String, Integer> wordCounts = searchForWords(fileName, "upon", "sigh", "Dormouse", "jury-box", "swim");

        // Her kelimenin sayısını yazdırın
        for (String word : wordCounts.keySet()) {
            int count = wordCounts.get(word);
            System.out.println("'" + word + "' kelimesi " + count + " kez geçiyor.");
        }

    }

    public static HashMap<String, Integer> searchForWords(String fileName, String... words) {

        // Aranacak kelimeleri ve sayımlarını tutan bir HashMap oluşturun
        HashMap<String, Integer> wordCounts = new HashMap<String, Integer>();

        for (String word : words) {
            wordCounts.put(word, 0); // Her kelime için başlangıç sayısı sıfır
        }

        try {
            // Dosyayı okumak için bir BufferedReader oluşturun
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            // Dosyanın sonuna kadar satır satır okuyun
            while ((line = br.readLine()) != null) {
                // Her kelimeyi kontrol edin
                for (String word : words) {
                    if (raita(line, word)) { // Eşleşme bulunduysa
                        int count = wordCounts.get(word); // Kelimenin mevcut sayısını alın
                        wordCounts.put(word, count + 1); // Sayacı bir artırın
                    }
                }
            }

            br.close(); // Dosyayı kapatın

        } catch (IOException e) {
            System.out.println("Dosya okunurken hata oluştu: " + fileName);
            e.printStackTrace();
        }

        // Tüm kelime sayımlarını içeren HashMap'i döndürün
        return wordCounts;
    }

    // Raita algoritması ile metinde bir kelime arayın
    public static boolean raita(String line, String word) {
        int m = word.length(); // Aranan kelimenin uzunluğunu alın
        int n = line.length(); // Satırın uzunluğunu alın

        for (int i = 0; i <= n - m; i++) { // Satırın her karakteri için
            int j;

            for (j = 0; j < m; j++) { // Kelimenin her karakteri için
                if (line.charAt(i + j) != word.charAt(j)) { // Eşleşme bulunamadıysa
                    break; // Döngüden çıkın
                }
            }

            if (j == m) { // Eşleşme bulunduysa
                return true; // true döndürün
            }
        }

        return false; // Eşleşme bulunamadıysa false döndürün
    }
}
