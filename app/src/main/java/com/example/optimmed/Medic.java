package com.example.optimmed;

import java.io.Serializable;
import java.util.Date;

public class Medic implements Serializable {
    private int idMedic;
    private String Utilizator;
    private String Parola;
    private String Nume;
    private String Prenume;
    private int Varsta;
    private String CNP;
    private Date DataNasterii;
    private String Sex;
    private String Adresa;
    private String Telefon;
    private String Email;
    private String Specializare;
    private String Parafa;
    private String Recomandari;
    private String Retete;

    public Medic(String utilizator, String parola, String email) {
        Utilizator = utilizator;
        Parola = parola;
        Email = email;
    }

    public Medic(int idMedic, String utilizator, String parola, String nume, String prenume, int varsta, String CNP, Date dataNasterii, String sex, String adresa, String telefon, String email, String specializare, String parafa, String recomandari, String retete) {
        this.idMedic = idMedic;
        Utilizator = utilizator;
        Parola = parola;
        Nume = nume;
        Prenume = prenume;
        Varsta = varsta;
        this.CNP = CNP;
        DataNasterii = dataNasterii;
        Sex = sex;
        Adresa = adresa;
        Telefon = telefon;
        Email = email;
        Specializare = specializare;
        Parafa = parafa;
        Recomandari = recomandari;
        Retete = retete;
    }

    public Medic(int idMedic, String utilizator, String parola, String nume, String prenume, int varsta, String CNP, String sex, String adresa, String telefon, String email, String specializare, String parafa, String recomandari, String retete) {
        this.idMedic = idMedic;
        Utilizator = utilizator;
        Parola = parola;
        Nume = nume;
        Prenume = prenume;
        Varsta = varsta;
        this.CNP = CNP;
        Sex = sex;
        Adresa = adresa;
        Telefon = telefon;
        Email = email;
        Specializare = specializare;
        Parafa = parafa;
        Recomandari = recomandari;
        Retete = retete;
    }

    public int getIdMedic() {
        return idMedic;
    }

    public void setIdMedic(int idMedic) {
        this.idMedic = idMedic;
    }

    public String getUtilizator() {
        return Utilizator;
    }

    public void setUtilizator(String utilizator) {
        Utilizator = utilizator;
    }

    public String getParola() {
        return Parola;
    }

    public void setParola(String parola) {
        Parola = parola;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public String getPrenume() {
        return Prenume;
    }

    public void setPrenume(String prenume) {
        Prenume = prenume;
    }

    public int getVarsta() {
        return Varsta;
    }

    public void setVarsta(int varsta) {
        Varsta = varsta;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public Date getDataNasterii() {
        return DataNasterii;
    }

    public void setDataNasterii(Date dataNasterii) {
        DataNasterii = dataNasterii;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String adresa) {
        Adresa = adresa;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSpecializare() {
        return Specializare;
    }

    public void setSpecializare(String specializare) {
        Specializare = specializare;
    }

    public String getParafa() {
        return Parafa;
    }

    public void setParafa(String parafa) {
        Parafa = parafa;
    }

    public String getRecomandari() {
        return Recomandari;
    }

    public void setRecomandari(String recomandari) {
        Recomandari = recomandari;
    }

    public String getRetete() {
        return Retete;
    }

    public void setRetete(String retete) {
        Retete = retete;
    }

    @Override
    public String toString() {
        return "Medic{" +
                "idMedic=" + idMedic +
                ", Utilizator='" + Utilizator + '\'' +
                ", Parola='" + Parola + '\'' +
                ", Nume='" + Nume + '\'' +
                ", Prenume='" + Prenume + '\'' +
                ", Varsta=" + Varsta +
                ", CNP='" + CNP + '\'' +
                ", DataNasterii=" + DataNasterii +
                ", Sex='" + Sex + '\'' +
                ", Adresa='" + Adresa + '\'' +
                ", Telefon='" + Telefon + '\'' +
                ", Email='" + Email + '\'' +
                ", Specializare='" + Specializare + '\'' +
                ", Parafa='" + Parafa + '\'' +
                ", Recomandari='" + Recomandari + '\'' +
                ", Retete='" + Retete + '\'' +
                '}';
    }
}
