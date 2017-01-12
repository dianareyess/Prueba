/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.Coleccion;
import javax.swing.table.AbstractTableModel;
import model.Prestamo;

/**
 *
 * @author Usuario
 */
public class PrestamoModel extends AbstractTableModel{

    private String[] columnName={"ID","Nombre","Paterno","Materno","ISBN","Titulo","Ejemplar","Fecha de prestamo","Fecha limite"};
    private Coleccion<Prestamo> data;
    
    public PrestamoModel(Coleccion<Prestamo> data){
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
                return this.data.get(i).getPersona().getId();
            case 1:
                return this.data.get(i).getPersona().getNombre();
            case 2:
                return this.data.get(i).getPersona().getPaterno();
            case 3:
                return this.data.get(i).getPersona().getMaterno();
            case 4:
                return this.data.get(i).getLibro().getIsbn();
            case 5:
                return this.data.get(i).getLibro().getTitulo();
            case 6:
                return this.data.get(i).getLibro().getEjemplar();
            case 7:
                return this.data.get(i).getFechaPrestamo();
            case 8:
                return this.data.get(i).getFechaSupuesta();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int i) {
        return columnName[i];
    }
    
    
}
