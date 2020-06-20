/**
 ** @Esra Ünal esra.unal3@ogr.sakarya.edu.tr
 * @since 26.04.2020
 * <p>Rastgele sayının oluşturulduğu sınıftır </p>
 */



package RastgeleKisiUret;


public class Rastgele {
    private final int baslangicDegeri;
    private double x;
    private double y;
    private int randomSayi;
    private static int degiskenSayi=1;
    
    public Rastgele(){
        baslangicDegeri= (int) System.currentTimeMillis(); //current time bir başlangıç değerine atanır.
        x=0;
        y=0;
        randomSayi=0;
    }
    
    //sözde randomluk sağlayabilmek için current time belirli bir formülde sokulur ve burada değişken bir sayı ile çarpılır.
    //sayı sürekli olarak arttığı için aynı sayının üretilmesinin önüne geçilmiş olunur.
    private int RandomSayi(){
        x=(degiskenSayi*(baslangicDegeri%1000) + 8) % 1000;
        degiskenSayi++;
        randomSayi= (int)((x*x)+ (x/68)+ 3)%10;  
        return randomSayi;
    }

    public int getRandomSayi() {
        return RandomSayi();
    }
    
}
