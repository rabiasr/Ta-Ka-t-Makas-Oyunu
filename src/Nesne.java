abstract class Nesne {

 
     double dayaniklilik;
    double seviyepuani;
   public Nesne() {

    }

    public Nesne(double dayaniklilik, double seviyepuani) {
        this.dayaniklilik = dayaniklilik;
        this.seviyepuani = seviyepuani;
    }

    public void nesnePuaniGoster(double dayaniklilik, double seviyepuani) {
        this.dayaniklilik = dayaniklilik;
        this.seviyepuani = seviyepuani;
        System.out.print("  dayaniklilik: "+dayaniklilik);
        System.out.println("   seviyepuani: "+seviyepuani);

    }

    public double getDayaniklilik() {
        return dayaniklilik;
    }

    public void setDayaniklilik(double dayaniklilik) {
        this.dayaniklilik = dayaniklilik;
    }

    public double getSeviyepuani() {
        return seviyepuani;
    }

    public void setSeviyepuani(double seviyepuani) {
        this.seviyepuani = seviyepuani;
    }

    public double etkiHesapla(int nesne) {
        return 0;
    }

    ;
    public void durumGuncelle(Nesne nesne, double dayaniklilik) {
        nesne.dayaniklilik = (nesne.dayaniklilik - dayaniklilik);
       
        
    }
    public void durumGuncelle(Nesne n1,Nesne n2,int seviyepuani)
    {
        if(n1.dayaniklilik==0)
        {
            n2.seviyepuani+=seviyepuani+20;
        }
        else if(n2.dayaniklilik==0)
        {
            n1.seviyepuani+=seviyepuani+20;
        }
    }

    
}
