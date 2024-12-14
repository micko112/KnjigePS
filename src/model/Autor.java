/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class Autor {
    private int ID;
    public String ime;
    public String prezime;
    private int godinaRodjenja;
    private String biografija;

    public Autor() {
    }

    public Autor(String ime, String prezime, int godinaRodjenja, String biografija) {
        this.ime = ime;
        this.prezime = prezime;
        this.godinaRodjenja = godinaRodjenja;
        this.biografija = biografija;
    }

    public Autor(int ID, String ime, String prezime, int godinaRodjenja, String biografija) {
        this.ID = ID;
        this.ime = ime;
        this.prezime = prezime;
        this.godinaRodjenja = godinaRodjenja;
        this.biografija = biografija;
    }

    public String getIme() {
        return ime;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Autor other = (Autor) obj;
        return this.ID == other.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getPrezime() {
        return prezime;
    }

    public int getGodinaRodjenja() {
        return godinaRodjenja;
    }

    public String getBiografija() {
        return biografija;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setGodinaRodjenja(int godinaRodjenja) {
        this.godinaRodjenja = godinaRodjenja;
    }

    public void setBiografija(String biografija) {
        this.biografija = biografija;
    }

    @Override
    public String toString() {
        return ime + ' '+ prezime;
    }
    
    
}
