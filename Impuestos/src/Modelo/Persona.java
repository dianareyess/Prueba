/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Excepciones.IntervalosFechaExcepcion;
import Excepciones.RegimenIncompatibleExcepcion;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import objetos.Fecha;
import objetos.HashConjunto;
import objetos.RFC;
import objetos.Regimen;
import objetos.TipoDireccion;

/**
 *
 * @author princessdiana
 */
public abstract class Persona {
    
    private RFC rfc;
    private HashSet<Direccion> direcciones;
    private String telefono;
    private Fecha fechaInscripcion;
    private Fecha fechaInicioOperaciones;
    private HashConjunto regimenes;

    public Persona(RFC rfc, String telefono, Fecha fechaInscripcion, Fecha fechaInicioOperaciones) throws IntervalosFechaExcepcion {
        this.rfc = rfc;
        this.telefono = telefono;
        this.fechaInscripcion = fechaInscripcion;
        this.fechaInicioOperaciones = fechaInicioOperaciones;
        if (!isValido()){
            throw new IntervalosFechaExcepcion();
        }
    }
        
    public boolean isValido(){
        return fechaInscripcion.compareTo(fechaInicioOperaciones) <= 0;
    }
    
    public boolean addDireccion(Direccion direccion){
        return direcciones.add(direccion);
    }
    
    public boolean isDireccion(TipoDireccion td){
        return direcciones.stream().filter(obj -> obj.getTipo() == td).count() > 0;
    }
    
    public Direccion getDireccion(TipoDireccion td){
        Direccion direccionRetorno = null;
        for (Direccion direccioncita : direcciones) {
             if (direccioncita.getTipo() == td ){
                 direccionRetorno = direccioncita;
             }
        }
        return direccionRetorno;
    }
    
    public List<Direccion> getDirecciones(){
        return new ArrayList<>(direcciones);
    }
    
    public void addRegimen(Regimen rgm) throws RegimenIncompatibleExcepcion{
        if (!regimenes.add(rgm)){
            throw new RegimenIncompatibleExcepcion();
        }
    }
    
    public List<Regimen> getRegimenes(){
        return new ArrayList<>(regimenes);
    }
    
    
    public RFC getRfc() {
        return rfc;
    }

    public void setRfc(RFC rfc) {
        this.rfc = rfc;
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

    public void setFechaInscripcion(Fecha fechaInscripcion) throws IntervalosFechaExcepcion {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Fecha getFechaInicioOperaciones() {
        return fechaInicioOperaciones;
    }

    public void setFechaInicioOperaciones(Fecha fechaInicioOperaciones) {
        this.fechaInicioOperaciones = fechaInicioOperaciones;
    }
    
    
}
