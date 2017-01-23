/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.tabla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import test.serializacion.Alumno;

/**
 *
 * @author princessdiana
 */
public class Modelo extends AbstractTableModel {

    private ArrayList<Alumno> coleccion;

    public Modelo(ArrayList<Alumno> arreglo) {
        coleccion = arreglo;
    }

    @Override
    public int getRowCount() {
        return coleccion.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Alumno temporal = coleccion.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return temporal.getNombre();
            case 1:
                return temporal.getEdad();
            case 2:
                return temporal.getCalificacion();
            default:
                return "Nose";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nombre";
            case 1:
                return "Edad";
            case 2:
                return "Calificacion";
            default:
                throw new AssertionError();
        }
    }
    
    
    

}
