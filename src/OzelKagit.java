
class OzelKagit extends Kagit {

    double kalinlik;

    public OzelKagit() {
    }

    public OzelKagit(double dayaniklilik, double seviyepuani, int nufuz) {
        super(dayaniklilik, seviyepuani, nufuz);

    }

    public double getKalinlik() {
        return kalinlik;
    }

    public void setKalinlik(int kalinlik) {
        this.kalinlik = kalinlik;
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
    public void nesnePuaniGoster(double dayaniklilik, double seviyepuani) {
        super.nesnePuaniGoster(dayaniklilik, seviyepuani); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void durumGuncelle(Nesne nesne, double etki) {
        super.durumGuncelle(nesne, etki); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public double etkiHesapla(int nesne) {
        super.etkiHesapla(nesne); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        Tas tas = new Tas();
        Makas makas = new Makas();
        Kagit kagit = new Kagit();
        UstaMakas umakas = new UstaMakas();
        OzelKagit okagit = new OzelKagit();
        AgirTas atas = new AgirTas();
        double a = 0.2;

        if (nesne == 3) {
            double okagitetkisi = (kagit.nufuz) * (okagit.kalinlik) / (1 - a) * (makas.keskinlik);
            return okagitetkisi;
        } else if (nesne == 2) {
            double okagitetkisi = (kagit.nufuz) * (okagit.kalinlik) / (1 * kagit.nufuz);
            return okagitetkisi;
        } else if (nesne == 1) {
            double okagitetkisi = (kagit.nufuz) * (okagit.kalinlik) / (a * tas.katilik);
            return okagitetkisi;
        } else if (nesne == 5) {
            double okagitetkisi = (kagit.nufuz) * (okagit.kalinlik) / (1) * (kagit.nufuz) * (okagit.kalinlik);
            return okagitetkisi;
        } else if (nesne == 6) {
            double okagitetkisi = (kagit.nufuz) * (okagit.kalinlik) / (1 - a) * makas.keskinlik * umakas.direnc;
            return okagitetkisi;
        } else if (nesne == 4) {
            double okagitetkisi = (kagit.nufuz) * (okagit.kalinlik) / a * tas.katilik * atas.sicaklik;
            return okagitetkisi;
        } else {
            return -1;
        }
    }

}
