package com.example.gestiunechirii;

//jsonItems
public class JsonRealEstate {
    private String imagine;
    private String nume;
    private String pret;

    public JsonRealEstate(String imagine, String nume, String pret) {
        this.imagine = imagine;
        this.nume = nume;
        this.pret = pret;
    }

    public String getImagine() {
        return imagine;
    }

    public void setImagine(String imagine) {
        this.imagine = imagine;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPret() {
        return pret;
    }

    public void setPret(String pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "JsonRealEstate{" +
                "imagine='" + imagine + '\'' +
                ", nume='" + nume + '\'' +
                ", pret='" + pret + '\'' +
                '}';
    }
}
