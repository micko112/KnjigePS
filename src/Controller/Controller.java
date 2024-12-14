/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.sql.ResultSet;
import Baza.DBBroker;
import Baza.Konekcija;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Knjiga;
import model.Autor;
import model.Zanr;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author user
 */

 public class Controller {
     DBBroker dbb;
     
    // Privatna statička instanca klase
    private static Controller instance;

    // Privatni konstruktor da se spreči direktno instanciranje
  
    // Javna metoda za dobijanje jedine instance
    public static Controller getInstance() {
        if (instance == null) {     
                
                    instance = new Controller();
                 
        }
        return instance;
    }
     private List<Knjiga> listaKnjiga = new ArrayList<>(); 
    private List<Autor> listaAutora  = new ArrayList<>();
 private Controller() {
           dbb = new DBBroker();
/*Autor autor1 = new Autor ("Ivo", "Andric", 1892, "Biografija autora Ive Andrica bla bla");
Autor autor2 = new Autor ("Danilo", "Kiš", 1935, "Biografija Danila Kisa bla bla bla bla");
Autor autor3 = new Autor ("Mesa", "Selimovic", 1910, "Mesa Selimovic je rodjen u BiH");
Knjiga knjiga1 = new Knjiga ("Na Drini ćuprija", autor1, "1234567890", 1945, Zanr. DETEKTIVSKI);
Knjiga knjiga2 = new Knjiga ("Bašta, pepeo", autor2, "0987654321", 1982, Zanr. ISTORIJSKI);
Knjiga knjiga3 = new Knjiga ("Tvrdava", autor3, "1122334455", 1970, Zanr.NAUCNA_FANTASTIKA);

    listaKnjiga.add(knjiga1);
    listaKnjiga.add(knjiga2);
    listaKnjiga.add(knjiga3);
    listaAutora.add(autor1);
    listaAutora.add(autor2);
    listaAutora.add(autor3);
    */        
    }
    
    
    // Metode kontrolera
   

   

    public List<Knjiga> getListaKnjiga() {
        return listaKnjiga;
    }

    public void setListaKnjiga(List<Knjiga> listaKnjiga) {
        this.listaKnjiga = listaKnjiga;
    }

    public List<Autor> getListaAutora() {
        return listaAutora;
    }

    public void setListaAutora(List<Autor> listaAutora) {
        this.listaAutora = listaAutora;
    }

    public void obrisiKnjigu(int id) {
        dbb.obrisiKnjigu( id);
        //   listaKnjiga.remove(selektovanRed);
    }

    public void dodajKnjigu(Knjiga knjiga) {
        dbb.dodajKnjigu(knjiga);
//        listaKnjiga.add(knjiga);
//        System.out.println(knjiga + "je dodata");
//        System.out.println(listaKnjiga);
    }

    public void izmeniKnjigu(int selektovanRed) {
        
    }
    public List<Knjiga> ucitajKnjigeIzBaze() {
            dbb = new DBBroker();
        return dbb.ucitajKnjigeIzBaze();
        
    }

    public List<Autor> ucitajListuAutoraIzBaze() {
            dbb = new DBBroker();
            return dbb.ucitajListuAutoraIzBaze();
    }

    public void azurirajKnjigu(Knjiga knjigazaIzmenu) {
        dbb.azurirajKnjigu(knjigazaIzmenu);
    }

    public boolean login(String username, String password) {
         return   dbb.login(username, password);
    }

    
 }
    

    
