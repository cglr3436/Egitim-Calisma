package com.uniyaz;

import static java.lang.Math.PI;

public class Daire extends Sekil{
    private double yaricap;

    public Daire(double yaricap) {
        this.setAdi("daire");
        this.yaricap = yaricap;
    }


    @Override
    public Double alan_hesabi() {
        Double alan=Math.PI * yaricap * yaricap;
        this.setAlani(alan);
        return alan;
    }

    @Override
    public Double cevre_hesabi() {
        Double cevre=Math.PI * 2 * yaricap;
        this.setCevresi(cevre);
        return cevre;
    }

    @Override
    public String toString() {
        return "Daire " +
                "yaricap=" + yaricap +
                ", cevre=" + this.getCevresi() +
                ", alani=" + this.getAlani() +
                " " ;
    }
}
