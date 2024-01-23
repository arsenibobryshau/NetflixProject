
package com.mycompany.netflixmain;


public class Cas {
    private int hodiny;
    private int minuty;

    public Cas(int hodiny, int minuty) {
        this.hodiny = hodiny;
        this.minuty = minuty;
    }

    public int getHodiny() {
        return hodiny;
    }

    public int getMinuty() {
        return minuty;
    }

    @Override
    public String toString() {
        return "Cas{" + hodiny + ":" + minuty + '}';
    }
    
    public int prevedNaMinuty(){
        return (hodiny * 60) + minuty;
    }
}
