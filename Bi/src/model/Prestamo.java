/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import exceptions.EjemplarNoPrestableException;
import exceptions.FechaInvalidaException;

/**
 *
 * @author Usuario
 */
public class Prestamo implements Comparable{
    private Persona persona;
    private Libro libro;
    private Fecha fechaPrestamo;
    private Fecha fechaEntrega;
    private Fecha fechaSupuesta;
    private boolean activo;
    public static final int DIAS_PRESTAMO=3;

    public Prestamo(Persona persona, Libro libro) throws FechaInvalidaException, EjemplarNoPrestableException {
        if (libro.getEjemplar()==1){
            throw new EjemplarNoPrestableException();
        }
        this.persona = persona;
        this.libro = libro;
        this.libro.setPrestado(true);
        this.fechaPrestamo = new Fecha();
        this.fechaSupuesta=Calendario.getInstance().avanzar(fechaPrestamo, DIAS_PRESTAMO);
        this.persona.setPrestamosActivos(this.persona.getPrestamosActivos()+1);
        this.activo=true;
    }
    
    @Override
    public int compareTo(Object t) {
        if (t instanceof Prestamo){
            Prestamo prestamo=(Prestamo)t;
            if(prestamo.getPersona().compareTo(this.getPersona())==0 && prestamo.getLibro().compareTo(this.getLibro())==0
                    && prestamo.getFechaPrestamo().compareTo(this.getFechaPrestamo())==0)
                return 0;
        }
        return 1;
    }
    
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Fecha getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Fecha getFechaEntrega() {
        return fechaEntrega;
    }

    public Fecha getFechaSupuesta() {
        return fechaSupuesta;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setFechaEntrega(Fecha fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    
}
