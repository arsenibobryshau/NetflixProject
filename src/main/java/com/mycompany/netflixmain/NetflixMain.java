

package com.mycompany.netflixmain;


public class NetflixMain {

    public static void main(String[] args) {
        // Vytvoření několika instancí třídy Čas
        Cas cas1 = new Cas(1, 30);
        Cas cas2 = new Cas(2, 15);
        Cas cas3 = new Cas(1, 45);

        // Vytvoření několika instancí třídy VideoPoložka
        VideoPolozka film1 = new VideoPolozka("Film 1", "USA", Druh.FILM, "Akční", cas1);
        VideoPolozka film2 = new VideoPolozka("Film 2", "Česká republika", Druh.FILM, "Komedie", cas2);
        VideoPolozka serial1 = new VideoPolozka("Seriál 1", "Velká Británie", Druh.SERIÁL, "Drama", cas3);

        // Vytvoření instance třídy Obsah a přidání položek
        Obsah obsah = new Obsah(5);
        obsah.pridajPolozku(film1);
        obsah.pridajPolozku(film2);
        obsah.pridajPolozku(serial1);

        // Výpis všech položek
        System.out.println("Výpis všech položek:");
        obsah.vypisPolozky();

        // Výpis položek podle druhu
        System.out.println("\nVýpis filmů:");
        obsah.vypisPolozkyPodleDruhu(Druh.FILM);

        // Výpis položek podle druhu a žánru
        System.out.println("\nVýpis komedií:");
        obsah.vypisPolozkyPodleDruhuPlusZanru(Druh.FILM, "Komedie");

        // Vyhledání nejpodobnější položky k dané položce
        System.out.println("\nVyhledání nejpodobnější položky:");
        obsah.najdiNejpodobnejsiPolozku(film1);

        // Výpočet průměrné délky filmů
        System.out.println("\nPrůměrná délka filmů:");
        obsah.spocitejPrumernouDelku(Druh.FILM);
    }
    }

