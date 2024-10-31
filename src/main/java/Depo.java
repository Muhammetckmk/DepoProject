import java.util.HashMap;
import java.util.Map;

public class Depo {
        private Map<Integer, Urun> urunDepo = new HashMap<>();
        private int idSayaci=1000;  // Her ürüne benzersiz ID verecek sayaç

        // Ürün Tanımlama Metodu
        public void urunTanimlama(String urunIsmi, String uretici, String birim) {

            // Aynı isim ve üreticiye sahip bir ürün var mı kontrol et
            boolean ayniUrunVarMi = urunDepo.values().stream()
                    .anyMatch(t -> t.getUrunIsmi().equalsIgnoreCase(urunIsmi) && t.getUretici().equalsIgnoreCase(uretici));
            //urunDepo= {1=  1  defter  mopak  0  koli  -, .......}

            // Eğer aynı ürün varsa eklemeyi yapma, uyarı ver
            if (ayniUrunVarMi) {
                System.out.println("Bu ürün zaten tanımlanmış: " + urunIsmi + " - " + uretici);
            } else {
                Urun yeniUrun = new Urun(idSayaci++, urunIsmi, uretici, birim);
                urunDepo.put(yeniUrun.getId(), yeniUrun);
                //urunDepo= {1=  1  defter  mopak  0  koli  -, ...}
                System.out.println("Yeni ürün tanımlandı: " + yeniUrun);
            }
        }


        // Ürün Listele Metodu
        // ArrayList içindeki tüm ürünleri formatli bir sekilde yazdirir.
        //Basliklari ve ayirici cizgiyi yazdirir ve urunleri tostring metodunu kullanarak yazdirir.
        public void urunListele() {
            System.out.printf("%10s %10s %10s %10s %10s %10s\n", "ID", "Ismi", "Uretici", "Miktar", "Birim", "Raf");
            System.out.println("---------------------------------------------------------------");
            for (Urun urun : urunDepo.values()) {
                System.out.println(urun);
            }

        }

    // Ürünü rafa koyma
    public void urunuRafaKoy(int id, String raf) {
        Urun urun = urunDepo.get(id);
        if (urun != null) {
            urun.setRaf(raf);
            System.out.println("Ürün rafa yerleştirildi: " + raf);
        } else {
            System.out.println("Ürün bulunamadı.");
        }
    }


    }
