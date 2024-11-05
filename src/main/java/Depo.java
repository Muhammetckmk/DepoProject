import java.util.HashMap;
import java.util.Map;

public class Depo {

    private Map<Integer, Urun> urunDepo = new HashMap<>();
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
            System.out.printf("%-10d %-10s %-10s %-10.2f %-10s %-10s%n",
                    urun.getId(), urun.getUrunIsmi(), urun.getUretici(),
                    urun.getMiktar(), urun.getBirim(), urun.getRaf());
        }
    }

    // Ürün Girişi
    public void urunGirisi(int id, double miktar) {
        Urun urun = urunDepo.get(id);
        if (urun != null) {
            urun.setMiktar(urun.getMiktar() + miktar);
        } else {
            System.out.println("Girilen Id de bir ürün bulunamadı.");
        }
    }


    // Ürünü rafa koyma
    public void urunuRafaKoy(int id, String raf) {
        Urun urun = urunDepo.get(id);
        if (urun != null) {
            // Diğer ürünleri kontrol ederek aynı rafı kullanan farklı ID'li bir ürün var mı bak
            boolean ayniRafKullanimdaMi = urunDepo.values().stream()
                    .anyMatch(u -> raf.equals(u.getRaf()) && u.getId() != id);

            if (!ayniRafKullanimdaMi) {
                urun.setRaf(raf);  // Ürünün raf bilgisi güncellenir
                System.out.println("Ürün rafa yerleştirildi: " + raf);
            } else {
                System.out.println("Bu raf dolu ve aynı ID'ye sahip olmayan başka bir ürün var.");
            }
        } else {
            System.out.println("Ürün bulunamadı.");
        }
    }



    // Ürün çıkışı
    public void urunCikisi(int id, double miktar) {
        Urun urun = urunDepo.get(id);
        if (urun != null) {
            if (urun.getMiktar() >= miktar) {
                urun.setMiktar(urun.getMiktar() - miktar);
                System.out.println(miktar+ " " + urun.getBirim() + " " +urun.getUrunIsmi()+  " çıkarıldı.");
            } else {
                System.out.println("Stoktaki "+ urun.getUrunIsmi()+" miktarından fazla ürün çıkışı yapılamaz.\n" +
                        "Stoktaki "+ urun.getUrunIsmi() +" miktarı :" + urun.getMiktar()+ " "+ urun.getBirim());
            }
        } else {
            System.out.println("Girilen Id de bir ürün bulunamadı.");
        }
    }
}



