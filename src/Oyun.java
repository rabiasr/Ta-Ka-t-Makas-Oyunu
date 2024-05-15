
import java.util.*;

public class Oyun {

    public static void main(String[] args) {

        Tas t = new Tas();
        Kagit k = new Kagit();
        Makas m = new Makas();
        int secim, i;

        String isim;
        String ID;
        Random random = new Random();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Tas-Kagit-Makas Oyununa Hosgeldiniz");
        System.out.println("Kullanici Seciniz: ");
        while (true) {

            System.out.println("1.Kullanici-Bilgisayar");
            System.out.println("2.Bilgisayar-Bilgisayar");
            System.out.print("Seciminizi Giriniz: ");
            secim = keyboard.nextInt();
            keyboard.nextLine();

            switch (secim) {

                case 1: {
                    Kullanici kullanici = new Kullanici();
                    Bilgisayar bilgisayar = new Bilgisayar();
                    System.out.print("Isim giriniz: ");
                    isim = keyboard.nextLine();
                    System.out.print("ID giriniz: ");//daha sonra random atanacak 
                    ID = keyboard.nextLine();
                    kullanici.setOyuncuAdi(isim);
                    kullanici.setOyuncuID(ID);
                    bilgisayar.setOyuncuAdi("bilgisayar");
                    bilgisayar.setOyuncuID("99999");
                    System.out.print("Kullanici Adi: " + kullanici.oyuncuAdi);
                    System.out.println("   Kullanici ID: " + kullanici.oyuncuID);
                    System.out.println("5 Nesne Seciniz!");
                    System.out.println("Nesneler :");
                    System.out.println("1.Tas");
                    System.out.println("2.Kagit");
                    System.out.println("3.Makas");
                    i = 0;
                    while (true) {
                        System.out.print("Secmek istediginiz nesneyi seciniz: ");
                        secim = keyboard.nextInt();
                        if (secim == 1) {
                            kullanici.nesneListesi[i] = new Tas(20, 0, 2);
                            kullanici.nesnelistesi[i] = secim;
                            i++;
                        } else if (secim == 2) {
                            kullanici.nesneListesi[i] = new Kagit(20, 0, 2);
                            kullanici.nesnelistesi[i] = secim;
                            i++;
                        } else if (secim == 3) {
                            kullanici.nesneListesi[i] = new Makas(20, 0, 2);
                            kullanici.nesnelistesi[i] = secim;
                            i++;
                        } else {
                            System.out.println("Yanlis Secim Lutfen Tekrar Seciniz");

                        }
                        if (i == 5) {
                            break;
                        }

                    }

                    System.out.println(" Bilgisayar nesnelerini seciyor");
                    i = 0;
                    while (true) {
                        secim = random.nextInt(1, 4);

                        System.out.println("secim:  " + secim);
                        if (secim == 1) {
                            bilgisayar.nesneListesi[i] = new Tas(20, 0, 2);
                            bilgisayar.nesnelistesi[i] = secim;
                            i++;

                        } else if (secim == 2) {
                            bilgisayar.nesneListesi[i] = new Kagit(20, 0, 2);
                            bilgisayar.nesnelistesi[i] = secim;
                            i++;
                        } else if (secim == 3) {
                            bilgisayar.nesneListesi[i] = new Makas(20, 0, 2);
                            bilgisayar.nesnelistesi[i] = secim;
                            i++;
                        } else {
                        }
                        if (i == 5) {
                            break;
                        }
                    }
                    System.out.println("-------------------------------------------------------");
                    for (i = 0; i < 10; i++) {
                        int secimk = kullanici.nesneSec() - 1;
                        int secimb = bilgisayar.nesneSec() - 1;
                        System.out.println("secimk: " + kullanici.nesnelistesi[secimk]);
                        System.out.println("secimb: " + bilgisayar.nesnelistesi[secimb]);
                        if (kullanici.nesnelistesi[secimk] == 1 && bilgisayar.nesnelistesi[secimb] == 1) {

                            double ke = t.etkiHesapla(bilgisayar.nesnelistesi[secimb]);
                            double be = t.etkiHesapla(kullanici.nesnelistesi[secimk]);
                            System.out.println("ke: " + ke);
                            System.out.println("be: " + be);
                            kullanici.nesneListesi[secimk].durumGuncelle(kullanici.nesneListesi[secimk], be);
                            bilgisayar.nesneListesi[secimb].durumGuncelle(bilgisayar.nesneListesi[secimb], ke);
                            kullanici.nesneListesi[secimk].durumGuncelle(kullanici.nesneListesi[secimk], bilgisayar.nesneListesi[secimb], 0);
                            kullanici.nesneListesi[secimk].nesnePuaniGoster(kullanici.nesneListesi[secimk].getDayaniklilik(), kullanici.nesneListesi[secimk].getSeviyepuani());
                            bilgisayar.nesneListesi[secimb].nesnePuaniGoster(bilgisayar.nesneListesi[secimb].getDayaniklilik(), bilgisayar.nesneListesi[secimb].getSeviyepuani());

                            if (kullanici.nesneListesi[secimk].getDayaniklilik() == 0) {
                                System.out.println(kullanici.nesneListesi[secimk] + " nesnesi oldu ");
                                bilgisayar.setSkor(1);
                            }

                            if (bilgisayar.nesneListesi[secimb].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar.nesneListesi[secimb] + " nesnesi oldu ");
                                kullanici.setSkor(1);
                            }
                            kullanici.SkorGoster(kullanici);
                            System.out.print("    ");
                            bilgisayar.SkorGoster(bilgisayar);
                            System.out.println();
                            bilgisayar.nesneListesi[secimb].nesnePuaniGoster(bilgisayar.nesneListesi[secimb].getDayaniklilik(), bilgisayar.nesneListesi[secimb].getSeviyepuani());

                            System.out.println();
                            System.out.println("-------------------------------------------------------");

                        } else if (kullanici.nesnelistesi[secimk] == 1 && bilgisayar.nesnelistesi[secimb] == 2) {

                          double ke = t.etkiHesapla(bilgisayar.nesnelistesi[secimb]);
                            double be = k.etkiHesapla(kullanici.nesnelistesi[secimk]);
                            System.out.println("ke: " + ke);
                            System.out.println("be: " + be);
                            kullanici.nesneListesi[secimk].durumGuncelle(kullanici.nesneListesi[secimk], be);
                            bilgisayar.nesneListesi[secimb].durumGuncelle(bilgisayar.nesneListesi[secimb], ke);
                            kullanici.nesneListesi[secimk].durumGuncelle(kullanici.nesneListesi[secimk], bilgisayar.nesneListesi[secimb], 0);
                            kullanici.nesneListesi[secimk].nesnePuaniGoster(kullanici.nesneListesi[secimk].getDayaniklilik(), kullanici.nesneListesi[secimk].getSeviyepuani());
                            bilgisayar.nesneListesi[secimb].nesnePuaniGoster(bilgisayar.nesneListesi[secimb].getDayaniklilik(), bilgisayar.nesneListesi[secimb].getSeviyepuani());

                            if (kullanici.nesneListesi[secimk].getDayaniklilik() == 0) {
                                System.out.println(kullanici.nesneListesi[secimk] + " nesnesi oldu ");
                                bilgisayar.setSkor(1);
                            }

                            if (bilgisayar.nesneListesi[secimb].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar.nesneListesi[secimb] + " nesnesi oldu ");
                                kullanici.setSkor(1);
                            }
                            kullanici.SkorGoster(kullanici);
                            System.out.print("    ");
                            bilgisayar.SkorGoster(bilgisayar);
                            System.out.println();
                            bilgisayar.nesneListesi[secimb].nesnePuaniGoster(bilgisayar.nesneListesi[secimb].getDayaniklilik(), bilgisayar.nesneListesi[secimb].getSeviyepuani());

                            System.out.println();
                            System.out.println("-------------------------------------------------------");

                        } else if (kullanici.nesnelistesi[secimk] == 1 && bilgisayar.nesnelistesi[secimb] == 3) {

                            double ke = t.etkiHesapla(bilgisayar.nesnelistesi[secimb]);
                            double be = m.etkiHesapla(kullanici.nesnelistesi[secimk]);
                            System.out.println("ke: " + ke);
                            System.out.println("be: " + be);
                            kullanici.nesneListesi[secimk].durumGuncelle(kullanici.nesneListesi[secimk], be);
                            bilgisayar.nesneListesi[secimb].durumGuncelle(bilgisayar.nesneListesi[secimb], ke);
                            kullanici.nesneListesi[secimk].durumGuncelle(kullanici.nesneListesi[secimk], bilgisayar.nesneListesi[secimb], 0);
                            kullanici.nesneListesi[secimk].nesnePuaniGoster(kullanici.nesneListesi[secimk].getDayaniklilik(), kullanici.nesneListesi[secimk].getSeviyepuani());
                            bilgisayar.nesneListesi[secimb].nesnePuaniGoster(bilgisayar.nesneListesi[secimb].getDayaniklilik(), bilgisayar.nesneListesi[secimb].getSeviyepuani());

                            if (kullanici.nesneListesi[secimk].getDayaniklilik() == 0) {
                                System.out.println(kullanici.nesneListesi[secimk] + " nesnesi oldu ");
                                bilgisayar.setSkor(1);
                            }
                            if (bilgisayar.nesneListesi[secimb].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar.nesneListesi[secimb] + " nesnesi oldu ");
                                kullanici.setSkor(1);
                            }
                            kullanici.SkorGoster(kullanici);
                            System.out.print("    ");
                            bilgisayar.SkorGoster(bilgisayar);
                            System.out.println();
                            bilgisayar.nesneListesi[secimb].nesnePuaniGoster(bilgisayar.nesneListesi[secimb].getDayaniklilik(), bilgisayar.nesneListesi[secimb].getSeviyepuani());

                            System.out.println();
                            System.out.println("-------------------------------------------------------");

                        } else if (kullanici.nesnelistesi[secimk] == 2 && bilgisayar.nesnelistesi[secimb] == 1) {

                            double ke = k.etkiHesapla(bilgisayar.nesnelistesi[secimb]);
                            double be = t.etkiHesapla(kullanici.nesnelistesi[secimk]);
                            System.out.println("ke: "+ke);
                            System.out.println("be: "+be);
                            kullanici.nesneListesi[secimk].durumGuncelle(kullanici.nesneListesi[secimk], be);
                            bilgisayar.nesneListesi[secimb].durumGuncelle(bilgisayar.nesneListesi[secimb], ke);
                            kullanici.nesneListesi[secimk].durumGuncelle(kullanici.nesneListesi[secimk], bilgisayar.nesneListesi[secimb], 0);
                            kullanici.nesneListesi[secimk].nesnePuaniGoster(kullanici.nesneListesi[secimk].getDayaniklilik(), kullanici.nesneListesi[secimk].getSeviyepuani());
                            bilgisayar.nesneListesi[secimb].nesnePuaniGoster(bilgisayar.nesneListesi[secimb].getDayaniklilik(), bilgisayar.nesneListesi[secimb].getSeviyepuani());

                            if (kullanici.nesneListesi[secimk].getDayaniklilik() == 0) {
                                System.out.println(kullanici.nesneListesi[secimk] + " nesnesi oldu ");
                                bilgisayar.setSkor(1);
                            }

                            if (bilgisayar.nesneListesi[secimb].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar.nesneListesi[secimb] + " nesnesi oldu ");
                                kullanici.setSkor(1);
                            }
                            kullanici.SkorGoster(kullanici);
                            System.out.print("    ");
                            bilgisayar.SkorGoster(bilgisayar);
                            System.out.println();
                            bilgisayar.nesneListesi[secimb].nesnePuaniGoster(bilgisayar.nesneListesi[secimb].getDayaniklilik(), bilgisayar.nesneListesi[secimb].getSeviyepuani());

                            System.out.println();
                            System.out.println("-------------------------------------------------------");

                        } else if (kullanici.nesnelistesi[secimk] == 2 && bilgisayar.nesnelistesi[secimb] == 2) {

                             double ke = k.etkiHesapla(bilgisayar.nesnelistesi[secimb]);
                            double be = k.etkiHesapla(kullanici.nesnelistesi[secimk]);
System.out.println("ke: "+ke);
                            System.out.println("be: "+be);
                            kullanici.nesneListesi[secimk].durumGuncelle(kullanici.nesneListesi[secimk], be);
                            bilgisayar.nesneListesi[secimb].durumGuncelle(bilgisayar.nesneListesi[secimb], ke);
                            kullanici.nesneListesi[secimk].durumGuncelle(kullanici.nesneListesi[secimk], bilgisayar.nesneListesi[secimb], 0);
                            kullanici.nesneListesi[secimk].nesnePuaniGoster(kullanici.nesneListesi[secimk].getDayaniklilik(), kullanici.nesneListesi[secimk].getSeviyepuani());
                            bilgisayar.nesneListesi[secimb].nesnePuaniGoster(bilgisayar.nesneListesi[secimb].getDayaniklilik(), bilgisayar.nesneListesi[secimb].getSeviyepuani());

                            if (kullanici.nesneListesi[secimk].getDayaniklilik() == 0) {
                                System.out.println(kullanici.nesneListesi[secimk] + " nesnesi oldu ");
                                bilgisayar.setSkor(1);
                            }

                            if (bilgisayar.nesneListesi[secimb].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar.nesneListesi[secimb] + " nesnesi oldu ");
                                kullanici.setSkor(1);
                            }
                            kullanici.SkorGoster(kullanici);
                            System.out.print("    ");
                            bilgisayar.SkorGoster(bilgisayar);
                            System.out.println();
                            bilgisayar.nesneListesi[secimb].nesnePuaniGoster(bilgisayar.nesneListesi[secimb].getDayaniklilik(), bilgisayar.nesneListesi[secimb].getSeviyepuani());

                            System.out.println();
                            System.out.println("-------------------------------------------------------");

                        } else if (kullanici.nesnelistesi[secimk] == 2 && bilgisayar.nesnelistesi[secimb] == 3) {

                           double ke = k.etkiHesapla(bilgisayar.nesnelistesi[secimb]);
                            double be = m.etkiHesapla(kullanici.nesnelistesi[secimk]);
System.out.println("ke: "+ke);
                            System.out.println("be: "+be);
                            kullanici.nesneListesi[secimk].durumGuncelle(kullanici.nesneListesi[secimk], be);
                            bilgisayar.nesneListesi[secimb].durumGuncelle(bilgisayar.nesneListesi[secimb], ke);
                            kullanici.nesneListesi[secimk].durumGuncelle(kullanici.nesneListesi[secimk], bilgisayar.nesneListesi[secimb], 0);
                            kullanici.nesneListesi[secimk].nesnePuaniGoster(kullanici.nesneListesi[secimk].getDayaniklilik(), kullanici.nesneListesi[secimk].getSeviyepuani());
                            bilgisayar.nesneListesi[secimb].nesnePuaniGoster(bilgisayar.nesneListesi[secimb].getDayaniklilik(), bilgisayar.nesneListesi[secimb].getSeviyepuani());

                            if (kullanici.nesneListesi[secimk].getDayaniklilik() == 0) {
                                System.out.println(kullanici.nesneListesi[secimk] + " nesnesi oldu ");
                                bilgisayar.setSkor(1);
                            }

                            if (bilgisayar.nesneListesi[secimb].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar.nesneListesi[secimb] + " nesnesi oldu ");
                                kullanici.setSkor(1);
                            }
                            kullanici.SkorGoster(kullanici);
                            System.out.print("    ");
                            bilgisayar.SkorGoster(bilgisayar);
                            System.out.println();
                            bilgisayar.nesneListesi[secimb].nesnePuaniGoster(bilgisayar.nesneListesi[secimb].getDayaniklilik(), bilgisayar.nesneListesi[secimb].getSeviyepuani());

                            System.out.println();
                            System.out.println("-------------------------------------------------------");

                        } else if (kullanici.nesnelistesi[secimk] == 3 && bilgisayar.nesnelistesi[secimb] == 1) {

                          double ke = m.etkiHesapla(bilgisayar.nesnelistesi[secimb]);
                            double be = t.etkiHesapla(kullanici.nesnelistesi[secimk]);
System.out.println("ke: "+ke);
                            System.out.println("be: "+be);
                            kullanici.nesneListesi[secimk].durumGuncelle(kullanici.nesneListesi[secimk], be);
                            bilgisayar.nesneListesi[secimb].durumGuncelle(bilgisayar.nesneListesi[secimb], ke);
                            kullanici.nesneListesi[secimk].durumGuncelle(kullanici.nesneListesi[secimk], bilgisayar.nesneListesi[secimb], 0);
                            kullanici.nesneListesi[secimk].nesnePuaniGoster(kullanici.nesneListesi[secimk].getDayaniklilik(), kullanici.nesneListesi[secimk].getSeviyepuani());
                            bilgisayar.nesneListesi[secimb].nesnePuaniGoster(bilgisayar.nesneListesi[secimb].getDayaniklilik(), bilgisayar.nesneListesi[secimb].getSeviyepuani());

                            if (kullanici.nesneListesi[secimk].getDayaniklilik() == 0) {
                                System.out.println(kullanici.nesneListesi[secimk] + " nesnesi oldu ");
                                bilgisayar.setSkor(1);
                            }

                            if (bilgisayar.nesneListesi[secimb].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar.nesneListesi[secimb] + " nesnesi oldu ");
                                kullanici.setSkor(1);
                            }
                            kullanici.SkorGoster(kullanici);
                            System.out.print("    ");
                            bilgisayar.SkorGoster(bilgisayar);
                            System.out.println();
                            bilgisayar.nesneListesi[secimb].nesnePuaniGoster(bilgisayar.nesneListesi[secimb].getDayaniklilik(), bilgisayar.nesneListesi[secimb].getSeviyepuani());

                            System.out.println();
                            System.out.println("-------------------------------------------------------");

                        } else if (kullanici.nesnelistesi[secimk] == 3 && bilgisayar.nesnelistesi[secimb] == 2) {

                             double ke = m.etkiHesapla(bilgisayar.nesnelistesi[secimb]);
                            double be = k.etkiHesapla(kullanici.nesnelistesi[secimk]);
System.out.println("ke: "+ke);
                            System.out.println("be: "+be);
                            kullanici.nesneListesi[secimk].durumGuncelle(kullanici.nesneListesi[secimk], be);
                            bilgisayar.nesneListesi[secimb].durumGuncelle(bilgisayar.nesneListesi[secimb], ke);
                            kullanici.nesneListesi[secimk].durumGuncelle(kullanici.nesneListesi[secimk], bilgisayar.nesneListesi[secimb], 0);
                            kullanici.nesneListesi[secimk].nesnePuaniGoster(kullanici.nesneListesi[secimk].getDayaniklilik(), kullanici.nesneListesi[secimk].getSeviyepuani());
                            bilgisayar.nesneListesi[secimb].nesnePuaniGoster(bilgisayar.nesneListesi[secimb].getDayaniklilik(), bilgisayar.nesneListesi[secimb].getSeviyepuani());

                            if (kullanici.nesneListesi[secimk].getDayaniklilik() == 0) {
                                System.out.println(kullanici.nesneListesi[secimk] + " nesnesi oldu ");
                                bilgisayar.setSkor(1);
                            }

                            if (bilgisayar.nesneListesi[secimb].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar.nesneListesi[secimb] + " nesnesi oldu ");
                                kullanici.setSkor(1);
                            }
                            kullanici.SkorGoster(kullanici);
                            System.out.print("    ");
                            bilgisayar.SkorGoster(bilgisayar);
                            System.out.println();
                            bilgisayar.nesneListesi[secimb].nesnePuaniGoster(bilgisayar.nesneListesi[secimb].getDayaniklilik(), bilgisayar.nesneListesi[secimb].getSeviyepuani());

                            System.out.println();
                            System.out.println("-------------------------------------------------------");

                        } else if (kullanici.nesnelistesi[secimk] == 3 && bilgisayar.nesnelistesi[secimb] == 3) {

                             double ke = m.etkiHesapla(bilgisayar.nesnelistesi[secimb]);
                            double be = m.etkiHesapla(kullanici.nesnelistesi[secimk]);
System.out.println("ke: "+ke);
                            System.out.println("be: "+be);
                            kullanici.nesneListesi[secimk].durumGuncelle(kullanici.nesneListesi[secimk], be);
                            bilgisayar.nesneListesi[secimb].durumGuncelle(bilgisayar.nesneListesi[secimb], ke);
                            kullanici.nesneListesi[secimk].durumGuncelle(kullanici.nesneListesi[secimk], bilgisayar.nesneListesi[secimb], 0);
                            kullanici.nesneListesi[secimk].nesnePuaniGoster(kullanici.nesneListesi[secimk].getDayaniklilik(), kullanici.nesneListesi[secimk].getSeviyepuani());
                            bilgisayar.nesneListesi[secimb].nesnePuaniGoster(bilgisayar.nesneListesi[secimb].getDayaniklilik(), bilgisayar.nesneListesi[secimb].getSeviyepuani());

                            if (kullanici.nesneListesi[secimk].getDayaniklilik() == 0) {
                                System.out.println(kullanici.nesneListesi[secimk] + " nesnesi oldu ");
                                bilgisayar.setSkor(1);
                            }

                            if (bilgisayar.nesneListesi[secimb].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar.nesneListesi[secimb] + " nesnesi oldu ");
                                kullanici.setSkor(1);
                            }
                            kullanici.SkorGoster(kullanici);
                            System.out.print("    ");
                            bilgisayar.SkorGoster(bilgisayar);
                            System.out.println();
                            bilgisayar.nesneListesi[secimb].nesnePuaniGoster(bilgisayar.nesneListesi[secimb].getDayaniklilik(), bilgisayar.nesneListesi[secimb].getSeviyepuani());

                            System.out.println();
                            System.out.println("-------------------------------------------------------");

                        }

                    }

                    break;
                }

                case 2: {
                    Bilgisayar bilgisayar = new Bilgisayar();
                    Bilgisayar bilgisayar1 = new Bilgisayar();
                    bilgisayar.setOyuncuAdi("Siyah");
                    bilgisayar.setOyuncuID("123564");//random atanacak daha sonra
                    bilgisayar1.setOyuncuAdi("Beyaz");
                    bilgisayar1.setOyuncuID("456232");//random atanacak daha sonra
                    System.out.println("Siyah Nesnelerini Seciyor...");
                    i = 0;
                    while (true) {

                        secim = random.nextInt(1, 4);
                        System.out.print("   secim:  " + secim);
                        if (secim == 1) {
                            bilgisayar.nesneListesi[i] = new Tas(20, 0, 2);
                            bilgisayar.nesnelistesi[i] = secim;
                            i++;

                        } else if (secim == 2) {
                            bilgisayar.nesneListesi[i] = new Kagit(20, 0, 2);
                            bilgisayar.nesnelistesi[i] = secim;
                            i++;

                        } else if (secim == 3) {
                            bilgisayar.nesneListesi[i] = new Makas(20, 0, 2);
                            bilgisayar.nesnelistesi[i] = secim;
                            i++;
                        } else {
                        }
                        if (i == 5) {
                            break;
                        }

                    }
                    System.out.println();

                    System.out.println("Beyaz Nesnelerini Seciyor...");
                    i = 0;
                    while (true) {

                        secim = random.nextInt(1, 4);
                        System.out.print("  secim:  " + secim);
                        switch (secim) {
                            case 1:
                                bilgisayar1.nesneListesi[i] = new Tas(20, 0, 2);
                                bilgisayar1.nesnelistesi[i] = secim;
                                i++;
                                break;
                            case 2:
                                bilgisayar1.nesneListesi[i] = new Kagit(20, 0, 2);
                                bilgisayar1.nesnelistesi[i] = secim;
                                i++;
                                break;
                            case 3:
                                bilgisayar1.nesneListesi[i] = new Makas(20, 0, 2);
                                bilgisayar1.nesnelistesi[i] = secim;
                                i++;
                                break;
                            default:
                                break;
                        }
                        if (i == 5) {
                            break;
                        }

                    }
                    System.out.println();
                    System.out.println("-------------------------------------------------------");
                    for (i = 0; i < 10; i++) {
                        int secimk = bilgisayar.nesneSec() - 1;
                        int secimb = bilgisayar1.nesneSec() - 1;
                        System.out.println("secimk: " + bilgisayar.nesnelistesi[secimk]);
                        System.out.println("secimb: " + bilgisayar1.nesnelistesi[secimb]);

                        if (bilgisayar.nesnelistesi[secimk] == 1 && bilgisayar1.nesnelistesi[secimb] == 1) {
                            if (bilgisayar.nesneListesi[secimk].dayaniklilik == 0 || bilgisayar1.nesneListesi[secimb].dayaniklilik == 0) {
                                System.out.println("secilen nesne öldü");

                            }

                            double ke = t.etkiHesapla(bilgisayar1.nesnelistesi[secimb]);
                            double be = t.etkiHesapla(bilgisayar.nesnelistesi[secimk]);
System.out.println("ke: "+ke);
                            System.out.println("be: "+be);
                            bilgisayar.nesneListesi[secimk].durumGuncelle(bilgisayar.nesneListesi[secimk], be);
                            bilgisayar1.nesneListesi[secimb].durumGuncelle(bilgisayar1.nesneListesi[secimb], ke);
                            bilgisayar.nesneListesi[secimk].durumGuncelle(bilgisayar.nesneListesi[secimk], bilgisayar1.nesneListesi[secimb], 0);
                            bilgisayar.nesneListesi[secimk].nesnePuaniGoster(bilgisayar.nesneListesi[secimk].getDayaniklilik(), bilgisayar.nesneListesi[secimk].getSeviyepuani());
                            bilgisayar1.nesneListesi[secimb].nesnePuaniGoster(bilgisayar1.nesneListesi[secimb].getDayaniklilik(), bilgisayar1.nesneListesi[secimb].getSeviyepuani());

                            if (bilgisayar.nesneListesi[secimk].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar.nesneListesi[secimk] + " nesnesi oldu  ");
                                bilgisayar1.setSkor(1);
                            }

                            if (bilgisayar1.nesneListesi[secimb].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar1.nesneListesi[secimb] + " nesnesi oldu ");
                                bilgisayar.setSkor(1);
                            }
                            bilgisayar.SkorGoster(bilgisayar);
                            System.out.print("    ");
                            bilgisayar1.SkorGoster(bilgisayar1);
                            System.out.println();
                            bilgisayar1.nesneListesi[secimb].nesnePuaniGoster(bilgisayar1.nesneListesi[secimb].getDayaniklilik(), bilgisayar1.nesneListesi[secimb].getSeviyepuani());

                            System.out.println();
                            System.out.println("-------------------------------------------------------");
                        } else if (bilgisayar.nesnelistesi[secimk] == 1 && bilgisayar1.nesnelistesi[secimb] == 2) {
                            if (bilgisayar.nesneListesi[secimk].dayaniklilik == 0 || bilgisayar1.nesneListesi[secimb].dayaniklilik == 0) {
                                System.out.println("secilen nesne öldü");

                            }
                            double ke = bilgisayar.nesneListesi[secimk].etkiHesapla(bilgisayar1.nesnelistesi[secimb]);
                            double be = bilgisayar1.nesneListesi[secimb].etkiHesapla(bilgisayar.nesnelistesi[secimk]);
System.out.println("ke: "+ke);
System.out.println("ke: "+be);
                            bilgisayar.nesneListesi[secimk].durumGuncelle(bilgisayar.nesneListesi[secimk], be);
                            bilgisayar1.nesneListesi[secimb].durumGuncelle(bilgisayar1.nesneListesi[secimb], ke);
                            bilgisayar.nesneListesi[secimk].durumGuncelle(bilgisayar.nesneListesi[secimk], bilgisayar1.nesneListesi[secimb], 0);
                            bilgisayar.nesneListesi[secimk].nesnePuaniGoster(bilgisayar.nesneListesi[secimk].getDayaniklilik(), bilgisayar.nesneListesi[secimk].getSeviyepuani());
                            bilgisayar1.nesneListesi[secimb].nesnePuaniGoster(bilgisayar1.nesneListesi[secimb].getDayaniklilik(), bilgisayar1.nesneListesi[secimb].getSeviyepuani());

                            if (bilgisayar.nesneListesi[secimk].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar.nesneListesi[secimk] + " nesnesi oldu ");
                                bilgisayar1.setSkor(1);
                            }

                            if (bilgisayar1.nesneListesi[secimb].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar1.nesneListesi[secimb] + " nesnesi oldu ");
                                bilgisayar.setSkor(1);
                            }
                            bilgisayar.SkorGoster(bilgisayar);
                            System.out.print("    ");
                            bilgisayar1.SkorGoster(bilgisayar1);
                            System.out.println();
                            bilgisayar1.nesneListesi[secimb].nesnePuaniGoster(bilgisayar1.nesneListesi[secimb].getDayaniklilik(), bilgisayar1.nesneListesi[secimb].getSeviyepuani());

                            System.out.println();
                            System.out.println("-------------------------------------------------------");
                        } else if (bilgisayar.nesnelistesi[secimk] == 1 && bilgisayar1.nesnelistesi[secimb] == 3) {
                            if (bilgisayar.nesneListesi[secimk].dayaniklilik == 0 || bilgisayar1.nesneListesi[secimb].dayaniklilik == 0) {
                                System.out.println("secilen nesne öldü");

                            }
                            double ke = bilgisayar.nesneListesi[secimk].etkiHesapla(bilgisayar1.nesnelistesi[secimb]);
                            double be = bilgisayar1.nesneListesi[secimb].etkiHesapla(bilgisayar.nesnelistesi[secimk]);
System.out.println("ke: "+ke);
                            System.out.println("be: "+be);
                            bilgisayar.nesneListesi[secimk].durumGuncelle(bilgisayar.nesneListesi[secimk], be);
                            bilgisayar1.nesneListesi[secimb].durumGuncelle(bilgisayar1.nesneListesi[secimb], ke);
                            bilgisayar.nesneListesi[secimk].durumGuncelle(bilgisayar.nesneListesi[secimk], bilgisayar1.nesneListesi[secimb], 0);
                            bilgisayar.nesneListesi[secimk].nesnePuaniGoster(bilgisayar.nesneListesi[secimk].getDayaniklilik(), bilgisayar.nesneListesi[secimk].getSeviyepuani());
                            bilgisayar1.nesneListesi[secimb].nesnePuaniGoster(bilgisayar1.nesneListesi[secimb].getDayaniklilik(), bilgisayar1.nesneListesi[secimb].getSeviyepuani());

                            if (bilgisayar.nesneListesi[secimk].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar.nesneListesi[secimk] + " nesnesi oldu ");
                                bilgisayar1.setSkor(1);
                            }

                            if (bilgisayar1.nesneListesi[secimb].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar1.nesneListesi[secimb] + " nesnesi oldu ");
                                bilgisayar.setSkor(1);
                            }
                            bilgisayar.SkorGoster(bilgisayar);
                            System.out.print("    ");
                            bilgisayar1.SkorGoster(bilgisayar1);
                            System.out.println();
                            bilgisayar1.nesneListesi[secimb].nesnePuaniGoster(bilgisayar1.nesneListesi[secimb].getDayaniklilik(), bilgisayar1.nesneListesi[secimb].getSeviyepuani());

                            System.out.println();
                            System.out.println("-------------------------------------------------------");

                        } else if (bilgisayar.nesnelistesi[secimk] == 2 && bilgisayar1.nesnelistesi[secimb] == 1) {
                            if (bilgisayar.nesneListesi[secimk].dayaniklilik == 0 || bilgisayar1.nesneListesi[secimb].dayaniklilik == 0) {
                                System.out.println("secilen nesne öldü");

                            }
                            double ke = bilgisayar.nesneListesi[secimk].etkiHesapla(bilgisayar1.nesnelistesi[secimb]);
                            double be = bilgisayar1.nesneListesi[secimb].etkiHesapla(bilgisayar.nesnelistesi[secimk]);
System.out.println("ke: "+ke);
                            System.out.println("be: "+be);
                            bilgisayar.nesneListesi[secimk].durumGuncelle(bilgisayar.nesneListesi[secimk], be);
                            bilgisayar1.nesneListesi[secimb].durumGuncelle(bilgisayar1.nesneListesi[secimb], ke);
                            bilgisayar.nesneListesi[secimk].durumGuncelle(bilgisayar.nesneListesi[secimk], bilgisayar1.nesneListesi[secimb], 0);
                            bilgisayar.nesneListesi[secimk].nesnePuaniGoster(bilgisayar.nesneListesi[secimk].getDayaniklilik(), bilgisayar.nesneListesi[secimk].getSeviyepuani());
                            bilgisayar1.nesneListesi[secimb].nesnePuaniGoster(bilgisayar1.nesneListesi[secimb].getDayaniklilik(), bilgisayar1.nesneListesi[secimb].getSeviyepuani());


                            if (bilgisayar.nesneListesi[secimk].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar.nesneListesi[secimk] + " nesnesi oldu ");
                                bilgisayar1.setSkor(1);
                            }

                            if (bilgisayar1.nesneListesi[secimb].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar1.nesneListesi[secimb] + " nesnesi oldu ");
                                bilgisayar.setSkor(1);
                            }
                            bilgisayar.SkorGoster(bilgisayar);
                            System.out.print("    ");
                            bilgisayar1.SkorGoster(bilgisayar1);
                            System.out.println();
                            bilgisayar1.nesneListesi[secimb].nesnePuaniGoster(bilgisayar1.nesneListesi[secimb].getDayaniklilik(), bilgisayar1.nesneListesi[secimb].getSeviyepuani());

                            System.out.println();
                            System.out.println("-------------------------------------------------------");

                        } else if (bilgisayar.nesnelistesi[secimk] == 2 && bilgisayar1.nesnelistesi[secimb] == 2) {
                            if (bilgisayar.nesneListesi[secimk].dayaniklilik == 0 || bilgisayar1.nesneListesi[secimb].dayaniklilik == 0) {
                                System.out.println("secilen nesne öldü");

                            }
                            double ke = bilgisayar.nesneListesi[secimk].etkiHesapla(bilgisayar1.nesnelistesi[secimb]);
                            double be = bilgisayar1.nesneListesi[secimb].etkiHesapla(bilgisayar.nesnelistesi[secimk]);
System.out.println("ke: "+ke);
                            System.out.println("be: "+be);
                           bilgisayar.nesneListesi[secimk].durumGuncelle(bilgisayar.nesneListesi[secimk], be);
                            bilgisayar1.nesneListesi[secimb].durumGuncelle(bilgisayar1.nesneListesi[secimb], ke);
                            bilgisayar.nesneListesi[secimk].durumGuncelle(bilgisayar.nesneListesi[secimk], bilgisayar1.nesneListesi[secimb], 0);
                            bilgisayar.nesneListesi[secimk].nesnePuaniGoster(bilgisayar.nesneListesi[secimk].getDayaniklilik(), bilgisayar.nesneListesi[secimk].getSeviyepuani());
                            bilgisayar1.nesneListesi[secimb].nesnePuaniGoster(bilgisayar1.nesneListesi[secimb].getDayaniklilik(), bilgisayar1.nesneListesi[secimb].getSeviyepuani());


                            if (bilgisayar.nesneListesi[secimk].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar.nesneListesi[secimk] + " nesnesi oldu ");
                                bilgisayar1.setSkor(1);
                            }
                            if (bilgisayar1.nesneListesi[secimb].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar1.nesneListesi[secimb] + " nesnesi oldu ");
                                bilgisayar.setSkor(1);
                            }
                            bilgisayar.SkorGoster(bilgisayar);
                            System.out.print("    ");
                            bilgisayar1.SkorGoster(bilgisayar1);
                            System.out.println();
                            bilgisayar1.nesneListesi[secimb].nesnePuaniGoster(bilgisayar1.nesneListesi[secimb].getDayaniklilik(), bilgisayar1.nesneListesi[secimb].getSeviyepuani());

                            System.out.println();
                            System.out.println("-------------------------------------------------------");

                        } else if (bilgisayar.nesnelistesi[secimk] == 2 && bilgisayar1.nesnelistesi[secimb] == 3) {
                            if (bilgisayar.nesneListesi[secimk].dayaniklilik == 0 || bilgisayar1.nesneListesi[secimb].dayaniklilik == 0) {
                                System.out.println("secilen nesne öldü");

                            }
                            double ke = bilgisayar.nesneListesi[secimk].etkiHesapla(bilgisayar1.nesnelistesi[secimb]);
                            double be = bilgisayar1.nesneListesi[secimb].etkiHesapla(bilgisayar.nesnelistesi[secimk]);
System.out.println("ke: "+ke);
                            System.out.println("be: "+be);
                            bilgisayar.nesneListesi[secimk].durumGuncelle(bilgisayar.nesneListesi[secimk], be);
                            bilgisayar1.nesneListesi[secimb].durumGuncelle(bilgisayar1.nesneListesi[secimb], ke);
                            bilgisayar.nesneListesi[secimk].durumGuncelle(bilgisayar.nesneListesi[secimk], bilgisayar1.nesneListesi[secimb], 0);
                            bilgisayar.nesneListesi[secimk].nesnePuaniGoster(bilgisayar.nesneListesi[secimk].getDayaniklilik(), bilgisayar.nesneListesi[secimk].getSeviyepuani());
                            bilgisayar1.nesneListesi[secimb].nesnePuaniGoster(bilgisayar1.nesneListesi[secimb].getDayaniklilik(), bilgisayar1.nesneListesi[secimb].getSeviyepuani());


                            if (bilgisayar.nesneListesi[secimk].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar.nesneListesi[secimk] + " nesnesi oldu ");
                                bilgisayar1.setSkor(1);
                            }

                            if (bilgisayar1.nesneListesi[secimb].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar1.nesneListesi[secimb] + " nesnesi oldu ");
                                bilgisayar.setSkor(1);
                            }
                            bilgisayar.SkorGoster(bilgisayar);
                            System.out.print("    ");
                            bilgisayar1.SkorGoster(bilgisayar1);
                            System.out.println();
                            bilgisayar1.nesneListesi[secimb].nesnePuaniGoster(bilgisayar1.nesneListesi[secimb].getDayaniklilik(), bilgisayar1.nesneListesi[secimb].getSeviyepuani());

                            System.out.println();
                            System.out.println("-------------------------------------------------------");

                        } else if (bilgisayar.nesnelistesi[secimk] == 3 && bilgisayar1.nesnelistesi[secimb] == 1) {
                            if (bilgisayar.nesneListesi[secimk].dayaniklilik == 0 || bilgisayar1.nesneListesi[secimb].dayaniklilik == 0) {
                                System.out.println("secilen nesne öldü");

                            }
                            double ke = bilgisayar.nesneListesi[secimk].etkiHesapla(bilgisayar1.nesnelistesi[secimb]);
                            double be = bilgisayar1.nesneListesi[secimb].etkiHesapla(bilgisayar.nesnelistesi[secimk]);
System.out.println("ke: "+ke);
                            System.out.println("be: "+be);
                            bilgisayar.nesneListesi[secimk].durumGuncelle(bilgisayar.nesneListesi[secimk], be);
                            bilgisayar1.nesneListesi[secimb].durumGuncelle(bilgisayar1.nesneListesi[secimb], ke);
                            bilgisayar.nesneListesi[secimk].durumGuncelle(bilgisayar.nesneListesi[secimk], bilgisayar1.nesneListesi[secimb], 0);
                            bilgisayar.nesneListesi[secimk].nesnePuaniGoster(bilgisayar.nesneListesi[secimk].getDayaniklilik(), bilgisayar.nesneListesi[secimk].getSeviyepuani());
                            bilgisayar1.nesneListesi[secimb].nesnePuaniGoster(bilgisayar1.nesneListesi[secimb].getDayaniklilik(), bilgisayar1.nesneListesi[secimb].getSeviyepuani());


                            if (bilgisayar.nesneListesi[secimk].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar.nesneListesi[secimk] + " nesnesi oldu ");
                                bilgisayar1.setSkor(1);
                            }

                            if (bilgisayar1.nesneListesi[secimb].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar1.nesneListesi[secimb] + " nesnesi oldu ");
                                bilgisayar.setSkor(1);
                            }
                            bilgisayar.SkorGoster(bilgisayar);
                            System.out.print("    ");
                            bilgisayar1.SkorGoster(bilgisayar1);
                            System.out.println();
                            bilgisayar1.nesneListesi[secimb].nesnePuaniGoster(bilgisayar1.nesneListesi[secimb].getDayaniklilik(), bilgisayar1.nesneListesi[secimb].getSeviyepuani());

                            System.out.println();
                            System.out.println("-------------------------------------------------------");

                        } else if (bilgisayar.nesnelistesi[secimk] == 3 && bilgisayar1.nesnelistesi[secimb] == 2) {
                            if (bilgisayar.nesneListesi[secimk].dayaniklilik == 0 || bilgisayar1.nesneListesi[secimb].dayaniklilik == 0) {
                                System.out.println("secilen nesne öldü");

                            }
                            double ke = bilgisayar.nesneListesi[secimk].etkiHesapla(bilgisayar1.nesnelistesi[secimb]);
                            double be = bilgisayar1.nesneListesi[secimb].etkiHesapla(bilgisayar.nesnelistesi[secimk]);
System.out.println("ke: "+ke);
                            System.out.println("be: "+be);
                           bilgisayar.nesneListesi[secimk].durumGuncelle(bilgisayar.nesneListesi[secimk], be);
                            bilgisayar1.nesneListesi[secimb].durumGuncelle(bilgisayar1.nesneListesi[secimb], ke);
                            bilgisayar.nesneListesi[secimk].durumGuncelle(bilgisayar.nesneListesi[secimk], bilgisayar1.nesneListesi[secimb], 0);
                            bilgisayar.nesneListesi[secimk].nesnePuaniGoster(bilgisayar.nesneListesi[secimk].getDayaniklilik(), bilgisayar.nesneListesi[secimk].getSeviyepuani());
                            bilgisayar1.nesneListesi[secimb].nesnePuaniGoster(bilgisayar1.nesneListesi[secimb].getDayaniklilik(), bilgisayar1.nesneListesi[secimb].getSeviyepuani());

                            if (bilgisayar.nesneListesi[secimk].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar.nesneListesi[secimk] + " nesnesi oldu ");
                                bilgisayar1.setSkor(1);
                            }

                            if (bilgisayar1.nesneListesi[secimb].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar1.nesneListesi[secimb] + " nesnesi oldu ");
                                bilgisayar.setSkor(1);
                            }
                            bilgisayar.SkorGoster(bilgisayar);
                            System.out.print("    ");
                            bilgisayar1.SkorGoster(bilgisayar1);
                            System.out.println();
                            bilgisayar1.nesneListesi[secimb].nesnePuaniGoster(bilgisayar1.nesneListesi[secimb].getDayaniklilik(), bilgisayar1.nesneListesi[secimb].getSeviyepuani());

                            System.out.println();
                            System.out.println("-------------------------------------------------------");

                        } else if (bilgisayar.nesnelistesi[secimk] == 3 && bilgisayar1.nesnelistesi[secimb] == 3) {
                            if (bilgisayar.nesneListesi[secimk].dayaniklilik == 0 || bilgisayar1.nesneListesi[secimb].dayaniklilik == 0) {
                                System.out.println("secilen nesne öldü");

                            }
                            double ke = bilgisayar.nesneListesi[secimk].etkiHesapla(bilgisayar1.nesnelistesi[secimb]);
                            double be = bilgisayar1.nesneListesi[secimb].etkiHesapla(bilgisayar.nesnelistesi[secimk]);
System.out.println("ke: "+ke);
                            System.out.println("be: "+be);
                            bilgisayar.nesneListesi[secimk].durumGuncelle(bilgisayar.nesneListesi[secimk], be);
                            bilgisayar1.nesneListesi[secimb].durumGuncelle(bilgisayar1.nesneListesi[secimb], ke);
                            bilgisayar.nesneListesi[secimk].durumGuncelle(bilgisayar.nesneListesi[secimk], bilgisayar1.nesneListesi[secimb], 0);
                            bilgisayar.nesneListesi[secimk].nesnePuaniGoster(bilgisayar.nesneListesi[secimk].getDayaniklilik(), bilgisayar.nesneListesi[secimk].getSeviyepuani());
                            bilgisayar1.nesneListesi[secimb].nesnePuaniGoster(bilgisayar1.nesneListesi[secimb].getDayaniklilik(), bilgisayar1.nesneListesi[secimb].getSeviyepuani());

                            if (bilgisayar.nesneListesi[secimk].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar.nesneListesi[secimk] + " nesnesi oldu ");
                                bilgisayar1.setSkor(1);
                            }

                            if (bilgisayar1.nesneListesi[secimb].getDayaniklilik() == 0) {
                                System.out.println(bilgisayar1.nesneListesi[secimb] + " nesnesi oldu ");
                                bilgisayar.setSkor(1);
                            }
                            bilgisayar.SkorGoster(bilgisayar);
                            System.out.print("    ");
                            bilgisayar1.SkorGoster(bilgisayar1);
                            System.out.println();
                            bilgisayar1.nesneListesi[secimb].nesnePuaniGoster(bilgisayar1.nesneListesi[secimb].getDayaniklilik(), bilgisayar1.nesneListesi[secimb].getSeviyepuani());

                            System.out.println();
                            System.out.println("-------------------------------------------------------");

                        }
                    }
                    break;
                }

                default: {
                    System.out.println("Lutfen Tekrar Seciniz!");
                    break;
                }

            }
            System.out.println();
            System.out.println();
            System.out.println();

        }

    }
}
