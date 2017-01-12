/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Usuario
 */
public class Alumno extends Persona{
    private Carrera carrera;
    
    public Alumno(String nombre, String paterno, String materno, String id,Carrera carrera) {
        super(nombre, paterno, materno, id);
        this.carrera=carrera;
    }

    public Carrera getCarrera() {
        return carrera;
    }
    
}
