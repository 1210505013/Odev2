import java.util.Arrays;
import java.util.Random;

public class HarmonySearch {

    private int HMS; // Harmoni Bellek Boyutu
    private double HMCR; // Harmoni Belleği Dikkate Alma Oranı
    private double PAR; // Pitch Ayarlama Oranı
    private int maxIter; // Maksimum İterasyon Sayısı
    private double[] upperBound; // Karar Değişkenlerinin Üst Sınırları
    private double[] lowerBound; // Karar Değişkenlerinin Alt Sınırları olarak adlandırılır.
    private Random random; // rasgele sayı üreteci
    private double[] bestSolution; // Şimdiye kadar bulunan en iyi çözüm

    public HarmonySearch(int hms, double hmcr, double par, int maxIter, double[] upperBound, double[] lowerBound) {
        this.HMS = hms;
        this.HMCR = hmcr;
        this.PAR = par;
        this.maxIter = maxIter;
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        this.random = new Random();
        this.bestSolution = new double[upperBound.length];
        Arrays.fill(bestSolution, Double.NaN);
    }

    private double evaluate(double[] x) {
        // Burada amaç fonksiyonunu değerlendirmektir. Bu fonksiyon gerçek hedef fonksiyonuyla değiştirilmelidir.
        // Bu fonksiyon, gerçek amaç fonksiyonuyla değiştirilmelidir.
        double result = 0.0;
        for (int i = 0; i < x.length; i++) {
            result += x[i] * x[i];
        }
        return result;
    }

    public double[] solve() {
        double[][] harmonyMemory = new double[HMS][upperBound.length];
        for (int i = 0; i < HMS; i++) {
            for (int j = 0; j < upperBound.length; j++) {
                harmonyMemory[i][j] = lowerBound[j] + random.nextDouble() * (upperBound[j] - lowerBound[j]);
            }
        }
        double[] fitness = new double[HMS];
        for (int i = 0; i < HMS; i++) {
            fitness[i] = evaluate(harmonyMemory[i]);
        }
        int iteration = 0;
        while (iteration < maxIter) {
            double[] newHarmony = new double[upperBound.length];
            for (int i = 0; i < upperBound.length; i++) {
                if (random.nextDouble() < HMCR) {
                    // Harmony belleğinden bir değer seçin.
                    int index = random.nextInt(HMS);
                    newHarmony[i] = harmonyMemory[index][i];
                    //  Pitch ayarlaması
                    if (random.nextDouble() < PAR) {
                        newHarmony[i] += random.nextDouble() * (upperBound[i] - lowerBound[i]);
                    }
                } else {
                    // Rastgele bir değer seçin
                    newHarmony[i] = lowerBound[i] + random.nextDouble() * (upperBound[i] - lowerBound[i]);
                }
                // Yeni uyumu sınırlar içinde tutun
                newHarmony[i] = Math.max(newHarmony[i], lowerBound[i]);
                newHarmony[i] = Math.min(newHarmony[i], upperBound[i]);
            }
            double newFitness = evaluate(newHarmony);
            // Yeni çözüm daha iyi ise, uyum belleğini güncelle
            if (newFitness < fitness[HMS - 1]) {
                harmonyMemory
                        [HMS - 1] = newHarmony;
                fitness[HMS - 1] = newFitness;
// Harmoni belleğini uygunluk fonksiyonuna göre artan sırayla sırala
                for (int i = HMS - 1; i > 0; i--) {
                    if (fitness[i] < fitness[i - 1]) {
                        double[] tempHarmony = harmonyMemory[i];
                        harmonyMemory[i] = harmonyMemory[i - 1];
                        harmonyMemory[i - 1] = tempHarmony;
                        double tempFitness = fitness[i];
                        fitness[i] = fitness[i - 1];
                        fitness[i - 1] = tempFitness;
                    } else {
                        break;
                    }
                }
// En iyi bulunan çözümü güncelle
                if (Double.isNaN(bestSolution[0]) || newFitness < evaluate(bestSolution)) {
                    bestSolution = Arrays.copyOf(newHarmony, newHarmony.length);
                }
            }
            iteration++;
        }
        return bestSolution;
    }
}
