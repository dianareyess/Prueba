/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Excepciones.IntervalosFechaExcepcion;
import Excepciones.RegimenIncompatibleExcepcion;
import Modelo.obligaciones.Cedular;
import Modelo.obligaciones.Hospedaje;
import Modelo.obligaciones.Ieps;
import Modelo.obligaciones.Impuestos;
import Modelo.obligaciones.Incorporacion;
import Modelo.obligaciones.Intermedio;
import Modelo.obligaciones.Obligacion;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import objetos.Fecha;
import objetos.HashConjunto;
import objetos.Periodo;
import objetos.RFC;
import objetos.Regimen;
import objetos.TipoDireccion;
import objetos.TipoPeriodo;

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
    private ArrayList<Obligacion> obligaciones;

    public Persona(RFC rfc, String telefono, Fecha fechaInscripcion, Fecha fechaInicioOperaciones) throws IntervalosFechaExcepcion {
        this.rfc = rfc;
        this.telefono = telefono;
        this.fechaInscripcion = fechaInscripcion;
        this.fechaInicioOperaciones = fechaInicioOperaciones;
        direcciones = new HashSet<>();
        regimenes = new HashConjunto();
        obligaciones = new ArrayList<>();
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
    
    
    public void actualizarObligaciones(){         
        Integer anio = fechaInicioOperaciones.getAnio();
        for (Regimen regimen : regimenes) {
            TipoPeriodo tp = TipoPeriodo.getPeriodo(regimen.getPeriodicidad(), fechaInicioOperaciones);
            Periodo periodo = new Periodo(tp, anio);  
            Integer anioActual = (new Fecha()).getAnio();
            do{
            Obligacion obligacion = null;
            switch (regimen) {
                case INCORPORACION:
                    obligacion = new Incorporacion(periodo);
                    break;
                case INTERMEDIO:
                    obligacion = new Intermedio(periodo);
                    break;
                case CEDULAR:
                    obligacion = new Cedular(periodo);
                    break;                
                case IEPS:
                    obligacion = new Ieps(periodo);
                    break;                
                case HOSPEDAJE:
                    obligacion = new Hospedaje(periodo);
                    break;                
                default:
                    throw new AssertionError();
            }
            obligaciones.add(obligacion);
            periodo = periodo.next();
            }while(periodo.getEjercicio() <= anioActual);
        }
    }
     
    public Obligacion getObligacion(Regimen regimen){
        for (Obligacion obligacion : obligaciones) {
            Impuestos impuesto = (Impuestos)obligacion;
            if (impuesto.getRegimen() == regimen){
                if (!impuesto.getObligacionCumplida()){
                    return impuesto;
                }
            }
        }
        return null;
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