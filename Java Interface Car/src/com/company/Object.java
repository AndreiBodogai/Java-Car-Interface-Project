package com.company;

public class Object {
    private String numeMasina;
    private String numarSerie;
    private String caiPutere;
    private CarType combustibil;

    public Object() {

    }

    public Object(String numeMasina, String numarSerie, String caiPutere, CarType combustibil) {
        this.numeMasina = numeMasina;
        this.numarSerie = numarSerie;
        this.caiPutere = caiPutere;
        this.combustibil = combustibil;
    }

    public String getNumeMasina() {
        return numeMasina;
    }

    public void setNumeMasina(String numeMasina) {
        this.numeMasina = numeMasina;
    }

    public String getNumarSerie() {
        return numarSerie;
    }

    public void setNumarSerie(String numarSerie) {
        this.numarSerie = numarSerie;
    }

    public String getCaiPutere() {
        return caiPutere;
    }

    public void setCaiPutere(String caiPutere) {
        this.caiPutere = caiPutere;
    }

    public CarType getCombustibil() {
        return combustibil;
    }

    public void setCombustibil(CarType combustibil) {
        this.combustibil = combustibil;
    }

    @Override
    public String toString() {
        return "Object{" +
                "numeMasina='" + numeMasina + '\'' +
                ", numarSerie='" + numarSerie + '\'' +
                ", caiPutere='" + caiPutere + '\'' +
                ", combustibil=" + combustibil +
                '}';
    }
}
