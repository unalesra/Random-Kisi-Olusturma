
package test;

import RastgeleKisiUret.*;
import java.io.IOException;
import java.util.Scanner;


public class TEST {

    public static void main(String[] args) throws IOException {
      
        String cevap;       
        
        do {
            System.out.println("1- Rastgele Kişi Üret");
            System.out.println("2- Üretilmiş Dosya Kontrol Et");            
            System.out.println("3- Çıkış");

            Scanner s= new Scanner(System.in);
            cevap= s.next();
            
            if(cevap.equals("1")){
                System.out.println("Kaç kişi üretilmesini istersiniz?...: ");
                
                 Scanner s2= new Scanner(System.in);
                 int kisiSayisi=s2.nextInt();   
                 RastgeleKisi kisi1=new RastgeleKisi(kisiSayisi);
                 kisi1.DosyaYazma();
            }
            else if(cevap.equals("2")){
                 RastgeleKisi kisi1=new RastgeleKisi();
                 kisi1.IMEIKotnrol();
                 kisi1.TCKimlikKontrol();
            }
            
            
        } while (!(cevap.equals("3")));
  
    }
    
}
