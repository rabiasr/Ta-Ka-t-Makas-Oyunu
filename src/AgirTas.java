
class AgirTas extends Tas {

    double sicaklik;

    public AgirTas(double dayaniklilik, double seviyepuani, int katilik) {
        super(dayaniklilik, seviyepuani, katilik);
    }

    public AgirTas() {
    }

    public double getSicaklik() {
        return sicaklik;
    }

    public void setSicaklik(int sicaklik) {
        this.sicaklik = sicaklik;
    }

    public double getKatilik() {
        return katilik;
    }

    public void setKatilik(int katilik) {
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
        Tas tas = new Tas();
        Makas makas = new Makas();
        Kagit kagit = new Kagit();
        UstaMakas umakas = new UstaMakas();
        OzelKagit okagit = new OzelKagit();
        AgirTas atas = new AgirTas();
        super.etkiHesapla(nesne); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        double a = 0.2;

        if (nesne == 3) {
            double atasetkisi = (tas.katilik) * (atas.sicaklik) / (a * makas.keskinlik);
            return atasetkisi;
        } else if (nesne == 2) {
            double atasetkisi = (tas.katilik) * (atas.sicaklik) / (1 - a) * kagit.nufuz;
            return atasetkisi;
        } else if (nesne == 1) {
            double atasetkisi = (tas.katilik) * (atas.sicaklik) / (1 * tas.katilik);
            return atasetkisi;
        } else if (nesne == 5) {
            double atasetkisi = (tas.katilik) * (atas.sicaklik) / (1 - a) * (kagit.nufuz) * (okagit.kalinlik);
            return atasetkisi;
        } else if (nesne == 6) {
            double atasetkisi = (tas.katilik) * (atas.sicaklik) / a * makas.keskinlik * umakas.direnc;
            return atasetkisi;
        } else if (nesne == 4) {
            double atasetkisi = (tas.katilik) * (atas.sicaklik) / 1 * tas.katilik * atas.sicaklik;
            return atasetkisi;
        } else {
            return -1;
        }
    }

}
