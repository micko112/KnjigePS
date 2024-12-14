/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class Knjiga {
    private int ID;
    private String naziv;
    private Autor autor;
    private String isbn;
    private int godinaIzdanja;
    private Zanr zanr;

    public Knjiga() {
    }

    public Knjiga(String naziv, Autor autor, String isbn, int godinaIzdanja, Zanr zanr) {
        this.naziv = naziv;
        this.autor = autor;
        this.isbn = isbn;
        this.godinaIzdanja = godinaIzdanja;
        this.zanr = zanr;
    }

    public Knjiga(int ID, String naziv, Autor autor, String isbn, int godinaIzdanja, Zanr zanr) {
        this.ID = ID;
        this.naziv = naziv;
        this.autor = autor;
        this.isbn = isbn;
        this.godinaIzdanja = godinaIzdanja;
        this.zanr = zanr;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
        final Knjiga other = (Knjiga) obj;
        return this.ID == other.ID;
    }

    
    public String getNaziv() {
        return naziv;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getGodinaIzdanja() {
        return godinaIzdanja;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setGodinaIzdanja(int godinaIzdanja) {
        this.godinaIzdanja = godinaIzdanja;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    @Override
    public String toString() {
        return   naziv +  autor + isbn + godinaIzdanja  + zanr ;
    }
    
}
