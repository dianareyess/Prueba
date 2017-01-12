/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.Coleccion;
import javax.swing.table.AbstractTableModel;
import model.Alumno;
import model.Persona;

/**
 *
 * @author Usuario
 */
public class UsuarioModel extends AbstractTableModel{
    
    private String[] columnName={"ID","Nombre","Paterno","Materno","Carrera","Prestamos activos"};
    private Coleccion<Persona> data;
    
    public UsuarioModel(Coleccion<Persona> data){
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
        Alumno alumno=null;
        if(this.data.get(i) instanceof Alumno){
            alumno=(Alumno)this.data.get(i);
        }
        switch(j){
            case 0:
                return this.data.get(i).getId();
            case 1:
                return this.data.get(i).getNombre();
            case 2:
                return this.data.get(i).getPaterno();
            case 3:
                return this.data.get(i).getMaterno();
            case 4:
                return this.data.get(i) instanceof Alumno ? alumno.getCarrera().toString() : "";
            case 5:
                return this.data.get(i).getPrestamosActivos();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int i) {
        return columnName[i];
    }
}
