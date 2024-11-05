import java.util.Scanner;

public class Kontrol {


   public static String isEmptyIsBlank(Scanner scanner, String mesaj) {
        String girdi;
       do {
            girdi=scanner.nextLine();
               if (girdi.isBlank() || girdi.isEmpty()) {
                   System.out.print("Bu alan boş bırakılamaz. lütfen geçrli bir değer giriniz\n"+mesaj);
               } else {
                   break;
               }

       }while (true) ;
       return girdi;
   }

   public static Double miktarSifirdanKucukOlamaz(Scanner scanner, int id, double miktar){

             int secenek;

           do {
               System.out.println("Girilecek  miktar 0 dan küçük olamaz.");
               System.out.println("İşlemi tekrarlamak için : "+1 +" (bir)\nAnamenüye dönmek için    : "+9+" (dokuz) a basınız");
                secenek=scanner.nextInt();
               if (secenek==1){
                   System.out.print("Ürün ID: ");
                   id=scanner.nextInt();
                   System.out.print("Miktar: ");
                   miktar = scanner.nextDouble();
                   return miktar ;
               } else if (secenek==9) {
                   return miktar=0;
               }

           }while (miktar<=0);
        return miktar ;

   }


}