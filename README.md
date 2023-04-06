HCS ALGORİTMASI 
HCS (Hierarchical Clustering on Subspaces) kümeleme algoritması, veri kümesindeki benzer özelliklere sahip örnekleri gruplandırmak için kullanılır. Bu algoritma, veri kümesindeki örneklerin farklı boyutlarından bir veya daha fazlasında benzerlikleri dikkate alır ve bu benzerliklere dayanarak örnekleri gruplar.

HCS algoritması, her boyuttaki özelliklerin kümeleme işlemini ayrı ayrı gerçekleştirir ve ardından bu kümeleme sonuçlarını birleştirir. Algoritma, başlangıçta her örneği ayrı bir küme olarak ele alır ve ardından örnekler arasındaki benzerlikleri hesaplar. En benzer iki küme birleştirilir ve bu işlem, belirli bir küme sayısına ulaşıncaya kadar tekrarlanır.

HCS algoritmasının çalışma zamanı analizi, örnek sayısına ve boyutuna bağlıdır. Algoritmanın en iyi durumu O(n log n) ve en kötü durumu O(n^3) olabilir. Ortalama durum, n ve özellik sayısı karekökü arasında değişir.


RAİTA ALGORİTMASI
Raita algoritması, veri kümesindeki benzer özelliklere sahip örnekleri gruplandırmak için kullanılır. Bu algoritma, veri kümesindeki örneklerin farklı boyutlarından bir veya daha fazlasında benzerlikleri dikkate alır ve bu benzerliklere dayanarak örnekleri gruplar.

Raita algoritması, başlangıçta her boyutta bir küme oluşturur ve ardından bu küme merkezlerini rastgele seçer. Kümeleme işlemi, küme sayısı hedeflenene kadar devam eder. Algoritma, en yakın iki küme merkezini birleştirir ve bu işlem, hedeflenen küme sayısına ulaşıncaya kadar tekrarlanır.

Raita algoritmasının çalışma zamanı analizi, örnek sayısına, boyutuna ve hedeflenen küme sayısına bağlıdır. Algoritmanın en iyi durumu O(n log n) ve en kötü durumu O(n^3) olabilir. Ortalama durum, n ve özellik sayısı karekökü arasında değişir.
