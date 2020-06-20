/**
 ** @Esra Ünal esra.unal3@ogr.sakarya.edu.tr
 * @since 26.04.2020
 * <p>Rastgele kişinin oluşturulduğu dosyadır </p>
 */

package RastgeleKisiUret;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

//Kisi sınıfından kalıtım alınır.
public class RastgeleKisi extends Kisi {
    
    Kisi kisi;
    String RastgeleKisi=" ";
    int kisiSayisi;
    
    public RastgeleKisi(int kisiSayisi){
        this.kisiSayisi=kisiSayisi;
    }
    public RastgeleKisi(){}
    
  
    //Rastgle bir kişi oluşturulur.
    private String KisiOlustur() throws IOException{
        kisi= new Kisi();
        kisi.KisiSec();
        
        String Kisi1=kisi.TCKimlik.getTCKimlikNo()+" "+ kisi.KisiSec()+" " + kisi.YasOlustur()+ " "+ kisi.TelefonNo.getTelefonNo();
        return Kisi1; 
        
    
    }
    
    //oluşturulan kişi dosyaya yazılır.
    public void DosyaYazma() throws FileNotFoundException, IOException{
         File f= new File("Kisiler.txt");
         BufferedWriter writer= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
         
         for (int i = 0; i < kisiSayisi; i++) {
             writer.append(KisiOlustur());
             writer.newLine();
        }
         
         writer.flush();
    }
    
    //Kimlik numarası ve IMEI numarası kontrolleri buradan kullanıcının erişimine sunulmuştur.
    public void TCKimlikKontrol() throws IOException{
        KimlikNo Tc=new KimlikNo();
        Tc.TcKimlikKontrol();
    }
    
    public void IMEIKotnrol() throws IOException{
        IMEINo imei=new IMEINo();
        imei.IMEINOKontrol();
    }
}
