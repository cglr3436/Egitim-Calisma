package com.uniyaz;

import java.io.Serializable;

public  class Sekil implements Serializable {

    private String adi;
    private Double alani=0.0;
    private Double cevresi=0.0;
    public  Double alan_hesabi(){
        return null;
    }
    public  Double cevre_hesabi(){
        return null;
    }
    public String getAdi() {
        return adi;
    }

    @Override
    public String toString() {
        return "Sekil{" +
                "adi='" + adi + '\'' +
                ", alani=" + alani +
                ", cevresi=" + cevresi +
                '}';
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public Double getAlani() {
        return alani;
    }

    public void setAlani(Double alani) {
        this.alani = alani;
    }

    public Double getCevresi() {
        return cevresi;
    }

    public void setCevresi(Double cevresi) {
        this.cevresi = cevresi;
    }



}
