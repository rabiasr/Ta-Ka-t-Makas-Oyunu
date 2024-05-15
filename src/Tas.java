
class Tas extends Nesne {

    double katilik;

    public Tas(double dayaniklilik, double seviyepuani,double katilik) {
        this.dayaniklilik = dayaniklilik;
        this.seviyepuani = seviyepuani;
        this.katilik=katilik;
    }

    public double getKatilik() {
        return katilik;
    }

    public void setKatilik(double katilik) {
        this.katilik = katilik;
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
    

    public Tas() {
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
        Tas tas = new Tas(20,0,2);
        Makas makas = new Makas(20,0,2);
        Kagit kagit = new Kagit(20,0,2);
        UstaMakas umakas = new UstaMakas();
        OzelKagit okagit = new OzelKagit();
        AgirTas atas = new AgirTas();
        //super.etkiHesapla(nesne); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        double a = 0.2;

        switch (nesne) {
           case 1:
            {
                double tasetkisi = 1;
                return tasetkisi;
            }
            case 2:
            {
                double tasetkisi = (tas.katilik) / ((1 - a) * kagit.nufuz);
                return tasetkisi;
            }
           case 3:
            {
                double tasetkisi = (tas.katilik) / (a * makas.keskinlik);
                return tasetkisi;
            }
            case 4:
            {
                double tasetkisi = (tas.katilik) / 1 * tas.katilik * atas.sicaklik;
                return tasetkisi;
            }
            
            case 5:
            {
                double tasetkisi = (tas.katilik) / (1 - a) * (kagit.nufuz) * (okagit.kalinlik);
                return tasetkisi;
            }
            case 6:
            {
                double tasetkisi = (tas.katilik) / a * makas.keskinlik * umakas.direnc;
                return tasetkisi;
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
