/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.serializacion;

import java.io.Serializable;

/**
 *
 * @author princessdiana
 */
public class Alumno implements Serializable{
    
    private String nombre;
    private Integer edad;
    private Float calificacion;

    public Alumno(String nombre, Integer edad, Float calificacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.calificacion = calificacion;
    }

    @Override
    public String toString(){
        return nombre+" "+edad+" "+calificacion;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Float calificacion) {
        this.calificacion = calificacion;
    }
    
    
    
}