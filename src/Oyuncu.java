abstract class Oyuncu
{  String oyuncuID;
   String oyuncuAdi;
     int skor;
    public Nesne nesneListesi[]=new Nesne[5];
    public int nesnelistesi[]=new int [5];

    public Oyuncu() {}
    
    public Oyuncu(String oyuncuID, String oyuncuAdi, int skor) {
        this.oyuncuID = oyuncuID;
        this.oyuncuAdi = oyuncuAdi;
        this.skor = skor;
    }
    public void SkorGoster(Oyuncu oyuncu){
    };//oyuncuların skorları 
    public int nesneSec(){
    return 0;
};
    
    
}