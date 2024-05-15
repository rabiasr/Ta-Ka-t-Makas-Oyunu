
class Kagit extends Nesne {

    double nufuz ;

    public Kagit() {
    }

    public  Kagit(double dayaniklilik, double seviyepuani,double nufuz) {
        this.dayaniklilik = dayaniklilik;
        this.seviyepuani = seviyepuani;
        this.nufuz=nufuz;
    }

    public double getNufuz() {
        return nufuz;
    }

    public void setNufuz(int nufuz) {
        this.nufuz = nufuz;
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

    @Override
    public void durumGuncelle(Nesne nesne, double etki) {
        super.durumGuncelle(nesne, etki); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void durumGuncelle(Nesne n1, Nesne n2, int seviyepuani) {
        super.durumGuncelle(n1, n2, seviyepuani); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public double etkiHesapla(int nesne) {
        super.etkiHesapla(nesne); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        Tas tas = new Tas(20,0,2);
        Makas makas = new Makas(20,0,2);
        Kagit kagit = new Kagit(20,0,2);
        UstaMakas umakas = new UstaMakas();
        OzelKagit okagit = new OzelKagit();
        AgirTas atas = new AgirTas();
        double a = 0.2;

        switch (nesne) {
           case 1:
            {
                double kagitetkisi = (kagit.nufuz) / (a * tas.katilik);
                return kagitetkisi;
            }
            
            case 2:
            {
                double kagitetkisi = 1;
                return kagitetkisi;
            }case 3:
            {
                double kagitetkisi = (kagit.nufuz) / ((1 - a) * makas.keskinlik);
                return kagitetkisi;
            }
           case 4:
            {
                double kagitetkisi = (kagit.nufuz) / a * tas.katilik * atas.sicaklik;
                return kagitetkisi;
            }
            
            case 5:
            {
                double kagitetkisi = (kagit.nufuz) / (1) * (kagit.nufuz) * (okagit.kalinlik);
                return kagitetkisi;
            }
            case 6:
            {
                double kagitetkisi = (kagit.nufuz) / (1 - a) * makas.keskinlik * umakas.direnc;
                return kagitetkisi;
            }
            
            default:
                return -1;
        }
    }

    @Override
    public void nesnePuaniGoster(double dayaniklilik, double seviyepuani) {
        super.nesnePuaniGoster(dayaniklilik, seviyepuani); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
