import java.util.HashMap;
import java.util.Map;

public class Depo {

    private Map<Integer, Urun> urunDepo = new HashMap<>();
    private Map<String, Integer> rafDurumu = new HashMap<>();// Raf durumu kontrolü için
    private int idSayaci = 1000; // Başlangıç ID değeri (1000'den başlayabilir)


    // Ürün Tanımlama Metodu
    public void urunTanimlama(String urunIsmi, String uretici, String birim) {

        boolean ayniUrunVarMi = urunDepo.values().stream()
                .anyMatch(t -> t.getUrunIsmi().equalsIgnoreCase(urunIsmi) && t.getUretici().equalsIgnoreCase(uretici));

        if (ayniUrunVarMi) {
            System.out.println("Bu ürün zaten tanımlanmış: " + urunIsmi + " - " + uretici);
        } else {
            Urun yeniUrun = new Urun(idSayaci++, urunIsmi, uretici, birim);
            urunDepo.put(yeniUrun.getId(), yeniUrun);

            System.out.println("Yeni ürün tanımlandı: " + yeniUrun);
        }
    }

    // Ürün listeleme
    public void urunListele() {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s%n", "ID", "İsim", "Üretici", "Miktar", "Birim", "Raf");
        System.out.println("----------------------------------------------------------");
        for (Urun urun : urunDepo.values()) {
            System.out.printf("%-10d %-10s %-10s %-10d %-10s %-10s%n",
                    urun.getId(), urun.getUrunIsmi(), urun.getUretici(),
                    urun.getMiktar(), urun.getBirim(), urun.getRaf());
        }
    }

    // Ürün Girişi
    public void urunGirisi(int id, int miktar) {
        Urun urun = urunDepo.get(id);
        if (urun != null) {
            urun.setMiktar(urun.getMiktar() + miktar);
        } else {
            System.out.println("Ürün bulunamadı.");
        }
    }


    // Ürünü rafa koyma
    public void urunuRafaKoy(int id, String raf) {
        Urun urun = urunDepo.get(id);

        if (urun != null) {

            if (!rafDurumu.containsKey(raf) || rafDurumu.get(raf) == id) {

                urun.setRaf(raf);
                rafDurumu.put(raf, id);
                System.out.println("Ürün rafa yerleştirildi: " + raf);
            } else {
                System.out.println("Bu raf dolu ve aynı ID'ye sahip olmayan başka bir ürün var.");
            }
        } else {
            System.out.println("Ürün bulunamadı.");
        }
    }



    // Ürün çıkışı
    public void urunCikisi(int id, int miktar) {
        Urun urun = urunDepo.get(id);
        if (urun != null) {
            if (urun.getMiktar() >= miktar) {
                urun.setMiktar(urun.getMiktar() - miktar);
                System.out.println("Ürün çıkışı yapıldı: " + miktar + " çıkarıldı.");
            } else {
                System.out.println("Yetersiz miktar. Mevcut miktar: " + urun.getMiktar());
            }
        } else {
            System.out.println("Ürün bulunamadı.");
        }
    }
}



