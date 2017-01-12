/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.Coleccion;
import javax.swing.table.AbstractTableModel;
import model.Libro;

/**
 *
 * @author Usuario
 */
public class LibroModel extends AbstractTableModel{
    private String[] columnName={"ISBN","Titulo","Autor","Ejemplar","Prestable"};
    private Coleccion<Libro> data;
    
    public LibroModel(Coleccion<Libro> data){
        this.data=data;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public Object getValueAt(int i, int j) {
        switch(j){
            case 0:
                return this.data.get(i).getIsbn();
            case 1:
                return this.data.get(i).getTitulo();
            case 2:
                return this.data.get(i).getAutor();
            case 3:
                return this.data.get(i).getEjemplar();
            case 4:
                return this.data.get(i).isPrestado() ? "No" : "Si";
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int i) {
        return columnName[i];
    }
}
