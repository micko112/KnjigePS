/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Baza;

import Controller.Controller;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Autor;
import model.Knjiga;
import model.User;
import model.Zanr;

/**
 *
 * @author user
 */
public class DBBroker {
public List<Knjiga> ucitajKnjigeIzBaze() {
         List<Knjiga> lista = new ArrayList<>(); 
        try {
            
             
             String upit = "SELECT *\n" +
"FROM knjiga k JOIN autor a ON k.autorID = a.id";
             Statement st = Konekcija.getInstance().getConnection().createStatement();
             
            ResultSet rs =st.executeQuery(upit);
            while(rs.next()){
                int id = rs.getInt("k.id");
                String naslov = rs.getString("k.naslov");
                String isbn = rs.getString("k.isbn");
                int godina = rs.getInt("k.godinaIzdanja");
                String zanr = rs.getString("k.zanr");
                Zanr z = Zanr.valueOf(zanr);
                String ime =rs.getString("a.ime");
                String prezime = rs.getString("a.prezime");
                 String biografija = rs.getString("a.biografija");
                 int godRodjenja = rs.getInt("a.godinaRodjenja");
                 int IDautora = rs.getInt("a.ID");
                 Autor autor = new Autor(IDautora, ime, prezime, godRodjenja, biografija);
                Knjiga knjiga = new Knjiga(id, naslov, autor, isbn, godina, z);
                lista.add(knjiga);
            }
         } catch (SQLException ex) {
             Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
         }
         return lista;
    }
    public DBBroker() {
    }

    public List<Autor> ucitajListuAutoraIzBaze() {
        List<Autor> lista = new ArrayList<>(); 
        try {
            
             
             String upit = "SELECT *\n" +
"FROM autor a";
             Statement st = Konekcija.getInstance().getConnection().createStatement();
             
            ResultSet rs =st.executeQuery(upit);
            while(rs.next()){
              
                String ime =rs.getString("a.ime");
                String prezime = rs.getString("a.prezime");
                 String biografija = rs.getString("a.biografija");
                 int godRodjenja = rs.getInt("a.godinaRodjenja");
                 int IDautora = rs.getInt("a.ID");
                 Autor autor = new Autor(IDautora, ime, prezime, godRodjenja, biografija);
              
                lista.add(autor);
            }
         } catch (SQLException ex) {
             Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
         }
         return lista;
    }

   public boolean login(String username, String password){
    try {
        String upit = "select * from user where username = ? and password =?";
        PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
        ps.setString(1,username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();
  
        if(rs.next()){
        
        return true;
        }else return false;
            
    } catch (SQLException ex) {
        Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        return false;
        
        
        
        
    }
    public void obrisiKnjigu(int id) {
    try {
        String upit = "Delete from knjiga where id =?";
        PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
        ps.setInt(1, id);
        ps.executeUpdate();
        Konekcija.getInstance().getConnection().commit();
    } catch (SQLException ex) {
        Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    public void dodajKnjigu(Knjiga knjiga) {
    try {
        String upit = "insert into knjiga (id, naslov, autorid,ISBN, godinaIzdanja, Zanr)"
                + "values(?,?,?,?,?,?)";
        PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
        ps.setInt(1, knjiga.getID());
        ps.setString(2, knjiga.getNaziv());
        ps.setInt(3, knjiga.getAutor().getID());
             ps.setString(4, knjiga.getIsbn());
        ps.setInt(5, knjiga.getGodinaIzdanja());
        ps.setString(6, String.valueOf(knjiga.getZanr()));
        
        ps.executeUpdate();
           System.out.println("Dodata je knjiga: "+knjiga);
         Konekcija.getInstance().getConnection().commit();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }

    public void azurirajKnjigu(Knjiga knjigazaIzmenu) {
           try {
        String upit = "Update knjiga set naslov = ?, autorid= ?, godinaizdanja= ?, zanr = ? "
                + "where id=>";
        PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            //   ps.setInt(1, knjigazaIzmenu.getID());
               ps.setString(1, knjigazaIzmenu.getNaziv());
               ps.setInt(2, knjigazaIzmenu.getAutor().getID());
             //  ps.setString(, knjigazaIzmenu.getIsbn());
               ps.setInt(3, knjigazaIzmenu.getGodinaIzdanja());
               ps.setString(4, String.valueOf(knjigazaIzmenu.getZanr()));

               ps.executeUpdate();
           System.out.println("Dodata je knjiga: "+knjigazaIzmenu);
         Konekcija.getInstance().getConnection().commit();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    

  
    
    
}
