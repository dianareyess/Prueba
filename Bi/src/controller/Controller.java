/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import exceptions.EjemplarNoPrestableException;
import exceptions.ElementoNoEncontradoException;
import exceptions.ElementoRepetidoException;
import exceptions.FechaInvalidaException;
import exceptions.LibroNoEncontradoException;
import exceptions.LibroYaPrestadoException;
import exceptions.MaximoDePrestamosAlcanzadoException;
import exceptions.PersonaNoEncontradaException;
import java.util.ArrayList;
import model.Fecha;
import model.Libro;
import model.Persona;
import model.Prestamo;

/**
 *
 * @author Usuario
 */
public class Controller {
    private Coleccion<Libro> libros;
    private Coleccion<Persona> usuarios;
    private Coleccion<Prestamo> prestamos;
    public static final int MAX_PRESTAMOS=3;
    public Controller(){
        libros=new Coleccion<>();
        usuarios=new Coleccion<>();
        prestamos=new Coleccion<>();
    }
    public boolean altaLibro(Libro e) throws ElementoRepetidoException{
        return libros.agregar(e);
    }
    
    public boolean bajaLibro(Libro e) throws ElementoNoEncontradoException, LibroNoEncontradoException{
        try{
            return libros.delete(e);
        }catch(ElementoNoEncontradoException ex){
            throw new LibroNoEncontradoException();
        }
    }
    
    public Libro buscarLibro(String isbn,Integer ejemplar) throws LibroNoEncontradoException{
        for (Libro libro : libros) {
            if (libro.getIsbn().compareTo(isbn)==0&&
                    libro.getEjemplar().compareTo(ejemplar)==0){
                return libro;
            }
        }
        throw new LibroNoEncontradoException();
    }
    
    public Persona buscarUsuario(String id) throws PersonaNoEncontradaException{
        for (Persona persona : usuarios) {
            if (persona.getId().compareTo(id)==0){
                return persona;
            }
        }
        throw new PersonaNoEncontradaException();
    }
    
    public boolean altaPersona(Persona persona) throws ElementoRepetidoException{
        return usuarios.agregar(persona);
    }
    
    public boolean deletePersona(Persona persona) throws ElementoNoEncontradoException, PersonaNoEncontradaException{
        try{
            return usuarios.delete(persona);
        }catch(ElementoNoEncontradoException ex){
            throw new PersonaNoEncontradaException();
        }
    }
    
    public ArrayList<Prestamo> buscarPrestamo(String id,boolean activo){
        ArrayList<Prestamo> resultado=new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            if ((prestamo.getPersona().getId().compareTo(id)==0)&&(activo ? prestamo.isActivo() : true)){
                resultado.add(prestamo);
            }
        }
        return resultado;
    }
    
    public ArrayList<Prestamo> buscarPrestamo(String isbn,Integer ejemplar,boolean activo){
        ArrayList<Prestamo> resultado=new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            if ((prestamo.getLibro().getIsbn().compareTo(isbn)==0)
                    &&(prestamo.getLibro().getEjemplar().compareTo(ejemplar)==0)
                    &&(activo ? prestamo.isActivo() : true)){
                resultado.add(prestamo);
            }
        }
        return resultado;
    }
    
    public ArrayList<Prestamo> buscarPrestamo(String id, String isbn, boolean activo){
        ArrayList<Prestamo> resultado=new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            if ((prestamo.getLibro().getIsbn().compareTo(isbn)==0)
                    &&(prestamo.getPersona().getId().compareTo(id)==0)
                    &&(activo ? prestamo.isActivo() : true)){
                resultado.add(prestamo);
            }
        }
        return resultado;
    }
    
    public boolean darPrestamo(Persona persona, Libro libro) throws FechaInvalidaException, EjemplarNoPrestableException, ElementoRepetidoException, MaximoDePrestamosAlcanzadoException, LibroYaPrestadoException{
        if (persona.getPrestamosActivos()>MAX_PRESTAMOS){
            throw new MaximoDePrestamosAlcanzadoException();
        }
        if (libro.isPrestado()){
            throw new LibroYaPrestadoException();
        }
        return prestamos.agregar(new Prestamo(persona,libro));
    }
    
    public void devolverLibro(Prestamo prestamo){
        prestamo.setActivo(false);
        prestamo.setFechaEntrega(new Fecha());
        prestamo.getLibro().setPrestado(false);
        prestamo.getPersona().setPrestamosActivos(prestamo.getPersona().getPrestamosActivos()-1);
    }

    public Coleccion<Libro> getLibros() {
        return libros;
    }

    public Coleccion<Persona> getUsuarios() {
        return usuarios;
    }

    public Coleccion<Prestamo> getPrestamos() {
        return prestamos;
    }
    
    
}
