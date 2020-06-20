/**
 ** @Esra Ünal esra.unal3@ogr.sakarya.edu.tr
 * @since 26.04.2020
 * <p>Kisinin oluşturulduğu sınıftır </p>
 */



package RastgeleKisiUret;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class Kisi {
     private File f= new File("random_isimler.txt");
     private BufferedReader reader;
     
     private String secilenSatir="";
     private String isimSoyisim=" ";
     private String yas="";
     protected KimlikNo TCKimlik;  // nesne referansları kurucuda yapılmıştır.
     protected Telefon TelefonNo;
     
    public Kisi(){
      TCKimlik= new KimlikNo(); 
      TelefonNo= new Telefon();
    }

    private void DosyaOku() throws FileNotFoundException, IOException{
        reader= new BufferedReader(new InputStreamReader(new FileInputStream(f)));      
    }
    
    //dosyadan okunması için rastgele bir satır seçimi yapılır
    private void SatirSec(){
        
       Rastgele rnd=new Rastgele();
       
       while(true){
            for (int i = 0; i < 4; i++) {
              secilenSatir+= rnd.getRandomSayi();
            }

           int satir=Integer.valueOf(secilenSatir);
           if (satir<3000 && satir>1)
             break;
           else
               secilenSatir="";
        }           
    }
    
    protected String KisiSec() throws IOException{
        DosyaOku();
        SatirSec();
        //seçilen satıra gelinince okunan değer değişkene atanır.
        for (int i = 0; i < Integer.parseInt(secilenSatir); i++){
           isimSoyisim= reader.readLine();
        }
    
        return isimSoyisim;
        
    }
    
    protected String YasOlustur(){
        int [] Yas= new int[2];
        for(int i=0; i<2; i++){
            Rastgele rnd= new Rastgele();
            Yas[i]=rnd.getRandomSayi(); //her yas i.indisi için random bir sayı atanır.
            yas+=Yas[i];

        }
        return yas;
    }    
}
