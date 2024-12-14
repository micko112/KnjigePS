/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import model.Autor;
import model.Knjiga;
import model.Zanr;
import GUI.FormaMain;
/**
 *
 * @author user
 */
public class TableModel extends AbstractTableModel {

   
private List<Knjiga> listaKnjiga;
private final String[] kolone= {"id","naziv", "autor", "isbn", "godinaIzdanja", "zanr"};
 
public TableModel(List<Knjiga> listaKnjiga){
    this.listaKnjiga=listaKnjiga;
}
    @Override
    public int getRowCount() {
        return listaKnjiga.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Knjiga knjiga = listaKnjiga.get(rowIndex);
        switch (columnIndex) {
            case 0: 
                return knjiga.getID();
            case 1:
                return knjiga.getNaziv();
             case 2:
                return knjiga.getAutor();   
                  case 3:
                return knjiga.getIsbn();
                  case 4:
                return knjiga.getGodinaIzdanja();
                  case 5:
                return knjiga.getZanr();
            default: return "N/A";
                
        }
    }

    public List<Knjiga> getListaKnjiga() {
        return listaKnjiga;
    }

    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    void osveziPodatke() {
       fireTableDataChanged();
    }
    
    
}
