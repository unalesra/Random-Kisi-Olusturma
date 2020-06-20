/**
 ** @Esra Ünal esra.unal3@ogr.sakarya.edu.tr
 * @since 26.04.2020
 * <p>Rastgele telefon numarasının oluşturulduğu sınıftır </p>
 */


package RastgeleKisiUret;

public class Telefon {
    
    //değişken tanımlamaları yapılır.
    private String TelefonNo=" ";
    private int [] telefonNo= new int[9];
    private String IMEINo=" ";
    
    private void TelefonNoUret(){
        for (int i = 0; i < telefonNo.length;) {
            Rastgele rnd= new Rastgele();
            telefonNo[i]= rnd.getRandomSayi(); //telefon numarası için belirlenen dizinin her i. elemanına rastgele bir sayı atanır.
            i++;
            if(telefonNo[0]==3 ||telefonNo[0]==4 || telefonNo[0]==5)  //05'den sonra gelecek olan sayının kontrolü yapılır.
                TelefonNo+= telefonNo[i-1];
            else
                i--;
        }
    
            TelefonNo="05";
        
            for (int i = 0; i < telefonNo.length; i++) {
            TelefonNo+=telefonNo[i];  //dizi string değere atanır.
            }
                     
    }

    //Her telefonun bir imei numarası olacağından imeiNo burada oluşturulmuştur.
    private void ImeiNoGetir(){
       IMEINo imeiNo= new IMEINo();
       IMEINo= imeiNo.getIMEINo();
    }
    
    //imeinumarası ve telefon numarası birleştirilip return değeri olarak verilir.
    public String getTelefonNo(){
        TelefonNoUret();
        ImeiNoGetir();
        return TelefonNo + " ("+ IMEINo+ ")" ;
    }
}
