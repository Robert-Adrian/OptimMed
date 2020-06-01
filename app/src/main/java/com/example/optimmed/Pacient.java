package com.example.optimmed;

import java.util.Date;

public class Pacient {
    private int idPacient;
    private int idMedic;
    private String utilizator;
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
    private String Profesie;
    private String Diagnostic;
    private String Recomandari;
    private String Retete;
    private String Rapoarte;

    public Pacient(int idMedic, String utilizator, String parola, String email) {
        this.idMedic = idMedic;
        this.utilizator = utilizator;
        Parola = parola;
        Email = email;
    }

    public Pacient(int idPacient, int idMedic, String utilizator, String parola, String nume, String prenume, int varsta, String CNP, Date dataNasterii, String sex, String adresa, String telefon, String email, String profesie, String diagnostic, String recomandari, String retete, String rapoarte) {
        this.idPacient = idPacient;
        this.idMedic = idMedic;
        this.utilizator = utilizator;
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
        Profesie = profesie;
        Diagnostic = diagnostic;
        Recomandari = recomandari;
        Retete = retete;
        Rapoarte = rapoarte;
    }

    public int getIdPacient() {
        return idPacient;
    }

    public void setIdPacient(int idPacient) {
        this.idPacient = idPacient;
    }

    public int getIdMedic() {
        return idMedic;
    }

    public void setIdMedic(int idMedic) {
        this.idMedic = idMedic;
    }

    public String getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(String utilizator) {
        this.utilizator = utilizator;
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

    public String getProfesie() {
        return Profesie;
    }

    public void setProfesie(String profesie) {
        Profesie = profesie;
    }

    public String getDiagnostic() {
        return Diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        Diagnostic = diagnostic;
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

    public String getRapoarte() {
        return Rapoarte;
    }

    public void setRapoarte(String rapoarte) {
        Rapoarte = rapoarte;
    }
}
