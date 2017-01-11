/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.HashSet;

/**
 *
 * @author Diana Reyes Luis
 */
public abstract class Persona {
    
    private RFC rfc;
    private HashSet<Direccion> direcciones;
    private String telefono;
    private Fecha fechaInscripcion;
    private Fecha fechaInicioOperaciones;
    private HashConjunto regimenes;
    
    
    public void addDireccion(Direccion direccion) {
        return direcciones.add(direccion);
    }
    
    public boolean isDireccion(TipoDireccion td){
        return false;
    }
    
    public Direccion getDireccion(TipoDireccion td) {
        return null;
    }
    
    public List<Direccion> getDirecciones(){
        return null;
    }
    
    

    public RFC getRfc() {
        return rfc;
    }

    public void setRfc(RFC rfc) {
        this.rfc = rfc;
    }

    public <any> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(<any> direcciones) {
        this.direcciones = direcciones;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Fecha getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Fecha fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Fecha getFechaInicioOperaciones() {
        return fechaInicioOperaciones;
    }

    public void setFechaInicioOperaciones(Fecha fechaInicioOperaciones) {
        this.fechaInicioOperaciones = fechaInicioOperaciones;
    }

    public HashConjunto getRegimenes() {
        return regimenes;
    }

    public void setRegimenes(HashConjunto regimenes) {
        this.regimenes = regimenes;
    }
    
    
}
