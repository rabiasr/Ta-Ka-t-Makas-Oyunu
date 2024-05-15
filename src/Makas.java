
class Makas extends Nesne {

    double keskinlik;

    public Makas() {
    }

   public Makas(double dayaniklilik, double seviyepuani,double keskinlik) {
        this.dayaniklilik = dayaniklilik;
        this.seviyepuani = seviyepuani;
        this.keskinlik=keskinlik;
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
                double makasetkisi = (makas.keskinlik) / ((1 - a) * tas.katilik);
                return makasetkisi;
            }
            case 2:
            {
                double makasetkisi = (makas.keskinlik) / (a * kagit.nufuz);
                return makasetkisi;
            }
            case 3:
            {
                double makasetkisi =1;
                return makasetkisi;
            }
            case 4:
            {
                double makasetkisi = (makas.keskinlik) / (1 - a) * tas.katilik * atas.sicaklik;
                return makasetkisi;
            }
            case 5:
            {
                double makasetkisi = (makas.keskinlik) / (a) * (kagit.nufuz) * (okagit.kalinlik);
                return makasetkisi;
            }
            case 6:
            {
                double makasetkisi = (makas.keskinlik) / 1 * makas.keskinlik * umakas.direnc;
                return makasetkisi;
            }
            
            default:
                return -1;
        }
    }

    @Override
    public void durumGuncelle(Nesne nesne, double etki) {
        super.durumGuncelle(nesne, etki); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void nesnePuaniGoster(double dayaniklilik, double seviyepuani) {
        super.nesnePuaniGoster(dayaniklilik, seviyepuani); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
