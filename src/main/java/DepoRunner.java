import java.util.Scanner;

public class DepoRunner {

    public static void main(String[] args) {
        Depo depo = new Depo();
        Scanner scanner = new Scanner(System.in);
        int secim;

        do {
            System.out.println("1- Ürün Tanımlama\n2- Ürün Listeleme\n3- Ürün Girişi\n4- Ürünü Rafa Koy\n5- Ürün Çıkışı\n0- Çıkış");
            System.out.print("Seçiminizi yapın: ");
            secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    scanner.nextLine(); // Satır sonu karakterini tüket
                    System.out.print("Ürün İsmi: ");
                    String urunIsmi = scanner.nextLine();
                    System.out.print("Üretici: ");
                    String uretici = scanner.nextLine();
                    System.out.print("Birim: ");
                    String birim = scanner.nextLine();
                    depo.urunTanimlama(urunIsmi, uretici, birim); // ID otomatik atanacak
                    break;
                case 2:
                    depo.urunListele();
                    break;
                case 3:
                    System.out.print("Ürün ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Miktar: ");
                    int miktar = scanner.nextInt();
                    depo.urunGirisi(id, miktar);
                    break;
                case 4:
                    System.out.print("Ürün ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Satır sonu karakterini tüket
                    System.out.print("Raf: ");
                    String raf = scanner.nextLine();
                    depo.urunuRafaKoy(id, raf);
                    break;
                case 5:
                    System.out.print("Ürün ID: ");
                    id = scanner.nextInt();
                    System.out.print("Miktar: ");
                    miktar = scanner.nextInt();
                    depo.urunCikisi(id, miktar);
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        } while (secim != 0);

        scanner.close();
    }
}