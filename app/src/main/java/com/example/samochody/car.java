package com.example.samochody;

public class car {

    private String marka;
    private String model;
    private String skrzynia;
    private String rodzaj_paliwa;
    private String rok_produkcji;
    private String moc;

    public car() {
    }

    public car(String marka, String model, String skrzynia, String rodzaj_paliwa, String rok_produkcji, String moc) {
        this.marka = marka;
        this.model = model;
        this.skrzynia = skrzynia;
        this.rodzaj_paliwa = rodzaj_paliwa;
        this.rok_produkcji = rok_produkcji;
        this.moc = moc;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSkrzynia() {
        return skrzynia;
    }

    public void setSkrzynia(String skrzynia) {
        this.skrzynia = skrzynia;
    }

    public String getRodzaj_paliwa() {
        return rodzaj_paliwa;
    }

    public void setRodzaj_paliwa(String rodzaj_paliwa) {
        this.rodzaj_paliwa = rodzaj_paliwa;
    }

    public String getRok_produkcji() {
        return rok_produkcji;
    }

    public void setRok_produkcji(String rok_produkcji) {
        this.rok_produkcji = rok_produkcji;
    }

    public String getMoc() {
        return moc;
    }

    public void setMoc(String moc) {
        this.moc = moc;
    }
}
