import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Servis {

    Map<Integer, Urun> yeniUrun= new TreeMap<>();
    int ıd=1000;

    public void urunTanımlama(String ürünİsmi, String üretici, String birim){
        Urun ürün= new Urun( ıd++, "ürünİsmi", "üretici","birim");
        ürün.setUrunIsmi(ürünİsmi);
        ürün.getUretici(üretici);
        ürün.setBirim(birim);
        ürün.setId(ıd);

        this.yeniUrun.put(ürün.getId(),ürün);
        System.out.println("ürün : "+ ürün);

    }

    public static void ürünListeleme(){

    }




}
