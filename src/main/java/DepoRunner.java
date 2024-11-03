import java.util.Scanner;

public class DepoRunner {

    public static void main(String[] args) {
        Depo depo = new Depo();


        start(depo);

    }

    private static void start(Depo depo) {
        Scanner scanner = new Scanner(System.in);
        int secim;


        do {
            System.out.println("1- Ürün Tanımlama\n2- Ürün Listeleme\n3- Ürün Girişi\n4- Ürünü Rafa Koy\n5- Ürün Çıkışı\n0- Çıkış");
            System.out.print("Seçiminizi yapın: ");
            secim = scanner.nextInt();

            switch (secim) {
                case 1:
                       scanner.nextLine();
                    String urunIsmi;
                    String uretici;
                    String birim;
                        do {
                           System.out.print("Ürün İsmi: ");
                           urunIsmi = scanner.nextLine();
                           if (urunIsmi.isBlank()||urunIsmi.isEmpty()){
                               System.out.println("Geçerli bir ürün ismi giriniz");
                           }
                       }while (urunIsmi.isBlank()||urunIsmi.isEmpty());

                        do {
                            System.out.print("Üretici: ");
                            uretici = scanner.nextLine();
                            if (uretici.isEmpty() || uretici.isBlank()) {
                                System.out.println("Geçerli bir üretici ismi giriniz");
                            }
                        }while (uretici.isEmpty() || uretici.isBlank());
                        do {
                            System.out.print("Birim: ");
                           birim = scanner.nextLine();
                            if (birim.isBlank() || birim.isEmpty()) {
                                System.out.println("Geçerli bir birim giriniz");
                            }
                        }while (birim.isBlank() || birim.isEmpty());
                        depo.urunTanimlama(urunIsmi, uretici, birim);
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
                    scanner.nextLine();
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