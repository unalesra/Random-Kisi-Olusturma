/**
 ** @Esra Ünal esra.unal3@ogr.sakarya.edu.tr
 * @since 26.04.2020
 * <p>Kimlik numarasının üretilidiği ve kontrol edildiği sınıftır. </p>
 */


package RastgeleKisiUret;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class KimlikNo {
    
    //değişkenler tanımlanır.
    private File f= new File("Kisiler.txt");
    private BufferedReader reader;
    
    private String kimlikNo="";
    private Rastgele Rastgele;
    private int [] kimlikNumarasi= new int[9];  
    private String Kisi=" ";

    private int gecerli=0;
    private int gecersiz=0;    


    
    public KimlikNo(){}
    
    private void KimlikNoUret(){
        for(int i=0; i<kimlikNumarasi.length;){
            Rastgele= new Rastgele();
            kimlikNumarasi[i]=Rastgele.getRandomSayi();  //her bir i. indis için random sayı getirilir.
            i++;
            if(kimlikNumarasi[0]==0)
                i--;    
            else
                kimlikNo+= kimlikNumarasi[i-1];

        }
        
        int Ctoplam=0;
        int Ttoplam=0;
        
        //çift indislerdeki sayıların ve tek indislerdekilerin toplamı bulunur
        //kimlik numarası algoritması göz önünde bulundurularak 10. ve 11. haneler hesaplanır.
        for (int i = 0; i < kimlikNumarasi.length; i++) {
            if(i%2==0)
                Ctoplam+=kimlikNumarasi[i];
            else
                Ttoplam+=kimlikNumarasi[i];
        }
        
        int onuncuHane= ((7*Ctoplam)-Ttoplam)%10;
        kimlikNo+=onuncuHane;
        
        int onbirinciHane= (Ctoplam+Ttoplam+onuncuHane)%10;
        kimlikNo+=onbirinciHane;    
    }

    public String getTCKimlikNo(){
        KimlikNoUret();
        return kimlikNo;
    }
    
    private void DosyaOku() throws FileNotFoundException, IOException{
        reader= new BufferedReader(new InputStreamReader(new FileInputStream(f)));      
    }
    
    public void TcKimlikKontrol() throws FileNotFoundException, IOException{
       DosyaOku();
       String [] ayrilmis= new String[6];
       String satir=" ";
       
        while(satir != null){
            satir=reader.readLine(); //dosyadan satır okunur
            if(satir!=null){
            ayrilmis=satir.split(" "); //okuduğum satır boşluklarına göre ayrılır
            
            String gelenKimlik= ayrilmis[0]; // ilk elemanım tc kimlik numaramdır
            
            int [] sayiDizisi= new int[gelenKimlik.length()];
            
            if(sayiDizisi.length>11){
                System.out.println("Dosya içerisinde 11 haneden fazla hane içeren kimlik numarası bulunmuştur.");
                System.out.println("Kimlik numarası kontrol işlemi ipral edildi.");
                System.out.println("Lütfen dosyasınızı kontrol edip tekrar deneyiniz.\n");

                return;               
            }
            for (int i = 0; i < gelenKimlik.length(); i++) {
                int sayi=Integer.parseInt(gelenKimlik.substring(i, i+1)); //imei numarası sayılarına ayrılır
                sayiDizisi[i]=sayi; // bu sayılar bir diziye atanır
            }
                int Ctoplam=0; 
                int Ttoplam=0;  
            //çift indislerdeki sayıların ve tek indislerdekilerin toplamı bulunur
            for(int i=0; i<sayiDizisi.length-2; i++){
                if(i%2==0)
                    Ctoplam+=sayiDizisi[i];
                else
                    Ttoplam+=sayiDizisi[i];            
            }
            
            //algoritmaya uygun kontroller yapılır
            int onuncuHane= ((7*Ctoplam)- Ttoplam)%10;
            int onbirinciHane= (Ctoplam+Ttoplam+onuncuHane)%10;
           
            
            if(sayiDizisi[9]==onuncuHane && sayiDizisi[10]==onbirinciHane)
                gecerli++;
            else
                gecersiz++;
            
            }
            
        }
        System.out.println(gecerli +" " +"GEÇERLİ");
        System.out.println(gecersiz+" " + "GEÇERSİZ\n");
    }
}
