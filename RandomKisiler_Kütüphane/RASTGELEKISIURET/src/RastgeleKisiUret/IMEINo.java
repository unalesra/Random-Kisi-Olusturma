/**
 ** @Esra Ünal esra.unal3@ogr.sakarya.edu.tr
 * @since 26.04.2020
 * <p>IMEI numarasının üretilidiği ve kontrol edildiği sınıftır. </p>
 */

package RastgeleKisiUret;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class IMEINo {
    
    //gerekli değişkenler tanımlanır.
    private File f= new File("Kisiler.txt");
    private BufferedReader reader;
   
    private String IMEINo="";
    private Rastgele Rastgele;
    private int [] imeiNo= new int[14];

    
    private void IMEINoUret(){
        int onbesinciHane=0;
        int j=0;
        int toplam=0;

       
        for (int i = 0; i < imeiNo.length;) { 
            Rastgele=new Rastgele();
            imeiNo[i]=Rastgele.getRandomSayi(); // imeiNo dizi için her bir i.elemana random bir sayı gönderilir.
            i++;
            if(imeiNo[0]==0){
                i--;
            } 
        }
        
        //imei numarası oluşturma algoritması
        for (int i = 0; i < imeiNo.length; i++) {
            
            //indisleri çift olan sayılar 2 ile çarpılır eğer dokuzdan büyüklerse birler ve onlar basamağı toplanır, 9 ve daha küçük bir sayı ise olduğu gibi yazılır.
            if(i%2!=0){
                int [] ciftIMEI= new int[7];
                ciftIMEI[j]=imeiNo[i]*2;
                
                if(ciftIMEI[j]/10>0){
                    int araDeger1= ciftIMEI[j]/10;
                    int araDeger2= ciftIMEI[j]%10;
                    ciftIMEI[j]=araDeger1+araDeger2;
                    imeiNo[i]= ciftIMEI[j];
                }
                else 
                   imeiNo[i]= ciftIMEI[j];

                
                j++;
            }
        }
        
        //ilk 14 basamağın toplamı bulunur.
        for (int i = 0; i < imeiNo.length; i++) {
            IMEINo+= imeiNo[i];
            toplam+=imeiNo[i];

        }
       
        //ilk 14 basamağın toplamı ile 15.hane bulunur.
        if(toplam%10==0)
            onbesinciHane=0;
        else{
            onbesinciHane=10-(toplam%10);
        }
        
        IMEINo+=onbesinciHane;
        
    }
    
    public String getIMEINo(){
        IMEINoUret();
        return IMEINo;
    }
    
    private void DosyaOku() throws FileNotFoundException, IOException{
        reader= new BufferedReader(new InputStreamReader(new FileInputStream(f)));      
    }
      
    public void IMEINOKontrol() throws IOException{
          DosyaOku();
          
          String[] ayrilmis= new String[5];
          String satir=" ";
          int gecerli=0;
          int gecersiz=0;          
          
          while(satir!=null){
              satir=reader.readLine(); // dosyadan satır okunur
              
              if(satir!= null){
                  ayrilmis=satir.split(" "); //boşluklarına göre ayrılıp bir diziye atanır
             
                  String gelenIMEI= ayrilmis[ayrilmis.length-1]; //son elemanım imei numaramdır
                  
                  if(gelenIMEI.length()-2>15){
                      System.out.println("Dosya içerisinde 15 haneden fazla hane içeren imei numarası bulunmuştur.");
                      System.out.println("IMEI numarası kontrol işlemi ipral edildi.");
                      System.out.println("Lütfen dosyasınızı kontrol edip tekrar deneyiniz.\n");

                      return;
                  }
                  //parantezler de okundğu için okunan numaranın -2 kadar uzunlukta bir dizi oluşturulur.
                  int[] sayiDizisi=new int[gelenIMEI.length()-2];
                  
                  //numara sayılarına ayrılır
                  for (int i = 1; i < sayiDizisi.length+1; i++) {
                      int sayi=Integer.parseInt(gelenIMEI.substring(i, i+1));
                      sayiDizisi[i-1]=sayi;
                  }
                  
               int toplam=0;
               
               //ilk 14 hane ile yapılan işlemler sağlanıp 15.hane kontrolü yapılır.
                for (int i = 0; i < sayiDizisi.length-1; i++) {
                    toplam+=sayiDizisi[i];
                }
                  int onbesinciHane=0;
                  if(toplam%10==0)
                      onbesinciHane=0;
                  else
                      onbesinciHane=10-(toplam%10);
             

                  if(sayiDizisi[14]== onbesinciHane)
                      gecerli++;
                  else
                      gecersiz++;
            }
              
        }
          
          System.out.println(gecerli +" "+ "GEÇERLİ");
          System.out.println(gecersiz +" "+ "GEÇERSİZ\n");

    }
      
      
}
 
