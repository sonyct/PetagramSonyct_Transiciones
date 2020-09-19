package com.soniacruz.mismascotasbd.pojo;

public class Mascota {

    private int id;
    private String nombre;
    private char genero;
    private int foto;
    private int rate;

    public Mascota(){
        this.id = 0;
    }

    public Mascota(int foto, String nombre, char genero, int rate, int id) {
        this.foto = foto;
        this.nombre = nombre;
        this.genero = genero;
        this.rate = rate;
        this.id = id;
    }

    public Mascota(int foto, String nombre, char genero, int id) {
        this.foto = foto;
        this.nombre = nombre;
        this.genero = genero;
        this.id = id;
        this.rate = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
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

    public void addRate(){
        this.rate = this.getRate()+1;
    }
}

