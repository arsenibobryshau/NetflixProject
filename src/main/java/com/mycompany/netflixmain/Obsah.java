package com.mycompany.netflixmain;

public class Obsah {

    private VideoPolozka[] videoPolozky;
    private int pocetPolozek;

    public Obsah(int velikost) {
        this.videoPolozky = new VideoPolozka[velikost];
        this.pocetPolozek = 0;
    }

    public void pridajPolozku(VideoPolozka polozka) {
        if (pocetPolozek < videoPolozky.length) {
            videoPolozky[pocetPolozek] = polozka;
            pocetPolozek++;
        } else {
            System.out.println("Pole je plne, nelze pridat dalsi polozku.");
        }
    }

    public void vypisPolozky() {
        for (int i = 0; i < pocetPolozek; i++) {
            System.out.println(videoPolozky[i]);
        }
    }

    public void vypisPolozkyPodleDruhu(Druh vybranyDruh) {
        for (int i = 0; i < pocetPolozek; i++) {
            VideoPolozka polozka = videoPolozky[i];
            if (polozka.getDruh() == vybranyDruh) {
                System.out.println(polozka);
            }
        }
    }

    public void vypisPolozkyPodleDruhuPlusZanru(Druh vybranyDruh, String zanr) {
    for (int i = 0; i < pocetPolozek; i++) {
        VideoPolozka polozka = videoPolozky[i];
        if (polozka.getDruh() == vybranyDruh && polozka.getZanr().equals(zanr)) {
            System.out.println(polozka);
        }
    }
}

    public void najdiNejpodobnejsiPolozku(VideoPolozka polozka) {
        VideoPolozka nejpodobnejsi = null;
        int nejvyssiSkore = -1;

        for (int i = 0; i < pocetPolozek; i++) {
            VideoPolozka ostatni = videoPolozky[i];
            if (!ostatni.equals(polozka)) {
                int skore = polozka.podobnostS(ostatni);
                if (skore > nejvyssiSkore) {
                    nejvyssiSkore = skore;
                    nejpodobnejsi = ostatni;
                }
            }
        }

        if (nejpodobnejsi != null) {
            System.out.println("Nejpodobnejsi polozka k " + polozka.getNazev() + ": " + nejpodobnejsi);
        } else {
            System.out.println("Zadna podobna polozka nenalezena.");
        }
    }

    public void spocitejPrumernouDelku(Druh vybranyDruh) {
        int celkovaDelka = 0;
        int pocetPolozekDruhu = 0;

        for (int i = 0; i < pocetPolozek; i++) {
            VideoPolozka polozka = videoPolozky[i];
            if (polozka.getDruh() == vybranyDruh) {
                celkovaDelka += polozka.getDelka().prevedNaMinuty();
                pocetPolozekDruhu++;
            }
        }

        if (pocetPolozekDruhu > 0) {
            int prumernaDelka = celkovaDelka / pocetPolozekDruhu;
            Cas prumernyCas = new Cas(prumernaDelka / 60, prumernaDelka % 60);
            System.out.println("Prumerna delka " + vybranyDruh + "u: " + prumernyCas);
        } else {
            System.out.println("Zadne polozky tohoto druhu nenalezeny.");
        }
    }
}
