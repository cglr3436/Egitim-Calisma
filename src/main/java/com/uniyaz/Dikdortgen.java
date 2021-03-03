package com.uniyaz;

public class Dikdortgen extends Sekil {

    private double eni;
    private double boyu;

    public Dikdortgen(double eni, double boyu) {
        this.setAdi("dikdortgen");
        this.eni = eni;
        this.boyu = boyu;
    }

    @Override
    public String toString() {
        return "Dikdortgen " +
                "eni=" + eni +
                ", boyu=" + boyu +
                ", cevre=" + this.getCevresi() +
                ", alani=" + this.getAlani() +
                "  " ;
    }

    @Override
    public Double alan_hesabi() {
        Double alan=eni*boyu;
        this.setAlani(alan);
        return alan;
    }

    @Override
    public Double cevre_hesabi() {
        Double cevre=(eni+boyu)*2;
        this.setCevresi(cevre);
        return cevre;
    }
}
