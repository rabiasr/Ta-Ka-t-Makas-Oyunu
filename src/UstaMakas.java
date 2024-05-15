
class UstaMakas extends Makas {

    double direnc;

    public UstaMakas() {
        
    }

    public UstaMakas(double dayaniklilik, double seviyepuani, int keskinlik) {
        super(dayaniklilik, seviyepuani, keskinlik);
       
    }

    public double getDirenc() {
        return direnc;
    }

    public void setDirenc(int direnc) {
        this.direnc = direnc;
    }

    public double getKeskinlik() {
        return keskinlik;
    }

    public void setKeskinlik(int keskinlik) {
        this.keskinlik = keskinlik;
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
    public void durumGuncelle(Nesne n1, Nesne n2, int seviyepuani) {
        super.durumGuncelle(n1, n2, seviyepuani); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
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
            double umakasetkisi = (makas.keskinlik) * (umakas.direnc) / (1 * makas.keskinlik);
            return umakasetkisi;
        } else if (nesne == 2) {
            double umakasetkisi = (makas.keskinlik) * (umakas.direnc) / (a * kagit.nufuz);
            return umakasetkisi;
        } else if (nesne == 1) {
            double umakasetkisi = (makas.keskinlik) * (umakas.direnc) / (1 - a) * (tas.katilik);
            return umakasetkisi;
        } else if (nesne == 5) {
            double umakasetkisi = (makas.keskinlik) * (umakas.direnc) / (a) * (kagit.nufuz) * (okagit.kalinlik);
            return umakasetkisi;
        } else if (nesne == 6) {
            double umakasetkisi = (makas.keskinlik) * (umakas.direnc) / 1 * makas.keskinlik * umakas.direnc;
            return umakasetkisi;
        } else if (nesne == 4) {
            double umakasetkisi = (makas.keskinlik) * (umakas.direnc) / (1 - a) * tas.katilik * atas.sicaklik;
            return umakasetkisi;
        } else {
            return -1;
        }
    }

}
