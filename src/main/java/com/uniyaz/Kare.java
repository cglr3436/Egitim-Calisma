package com.uniyaz;

public class Kare extends Sekil {

    private double eni;
    private double boyu;

    public Kare(double eni, double boyu) {
        this.setAdi("kare");
        this.eni = eni;
        this.boyu = boyu;

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

    @Override
    public String toString() {
        return "Kare " +
                "eni=" + eni +
                ", boyu=" + boyu +
                ", cevre=" + this.getCevresi() +
                ", alani=" + this.getAlani() +
                "  " ;
    }
}
