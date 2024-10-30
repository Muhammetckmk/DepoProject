public class Urun {    private int id;
    private String urunIsmi;
    private String uretici;
    private int miktar = 0; // başlangıçta 0
    private String birim;
    private String raf = "-"; // başlangıçta tanımlı değil

    public Urun(int id, String urunIsmi, String uretici, String birim) {
        this.id = id;
        this.urunIsmi = urunIsmi;
        this.uretici = uretici;
        this.birim = birim;
    }

    public String getRaf() {
        return raf;
    }

    public String getBirim() {
        return birim;
    }

    public int getMiktar() {
        return miktar;
    }

    public String getUretici(String üretici) {
        return uretici;
    }

    public String getUrunIsmi() {
        return urunIsmi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrunIsmi(String urunIsmi) {
        this.urunIsmi = urunIsmi;
    }

    public void setUretici(String uretici) {
        this.uretici = uretici;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }

    @Override
    public String toString() {
        return "Urun{" +
                "id=" + id +
                ", urunIsmi='" + urunIsmi + '\'' +
                ", uretici='" + uretici + '\'' +
                ", miktar=" + miktar +
                ", birim='" + birim + '\'' +
                ", raf='" + raf + '\'' +
                '}';
    }


    // Getter ve Setter metotları

    /*1. Pojo Sınıfını Oluşturma (Urun)
Öncelikle, Urun isminde bir sınıf (Pojo sınıfı) oluşturacağız.
Bu sınıf, bir ürünün özelliklerini tanımlayacak.

Alanlar (fields): id, urunIsmi, uretici, miktar, birim, raf
Kapsüller (getter ve setter): Her bir alan için getter ve setter metotları oluşturacağız.
Kurucu (Constructor): Ürünün id, urunIsmi, uretici, ve birim bilgilerini alacak bir
kurucu oluşturacağız. Diğer alanlar varsayılan olarak miktar = 0 ve raf = null ile başlatılacak.
java
*/

    //Senaryo: Lambdayi object'lerle kullanmayi ogrenelim.
    // Class icerisinde pasif ve aktif ozellikler olusturalim.


        /*
        Icinde
        1) private variable'lar (kapsulleme-encapsulation)
        2) parametreli ve parametresiz constructor'lar
        3) getter'lar -Private değişkenlere erişim sağlamak için-
        4) setter'lar -Private değişkenleri değiştirmek için-
        5) toString() methodu -Objenin içeriğini okunabilir bir formatta döndürmek için-
        barindiran classlara POJO class denir

        POJO==>Plain Old Java Object -Düz Eski Java Nesnesi

        Birçok uygulamada, veriyi bir katmandan diğerine taşımak için POJO sınıfları kullanılır. (API)
    */


}
