package com.soniacruz.mismascotasbd.pojo;

public class Foto {
    private int foto;
    private int rate;

    public Foto(int foto, int rate) {
        this.foto = foto;
        this.rate = rate;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}