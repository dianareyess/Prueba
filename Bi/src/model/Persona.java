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
public abstract class Persona implements Comparable{
    private String nombre;
    private String paterno;
    private String materno;
    private String id;
    private Integer prestamosActivos;
    
    public Persona(String nombre, String paterno, String materno,String id){
        this.nombre=nombre;
        this.paterno=paterno;
        this.materno=materno;
        this.id=id;
        this.prestamosActivos=0;
    }

    @Override
    public int compareTo(Object t) {
        if(t instanceof Persona){
            Persona persona=(Persona)t;
            if(persona.getId().compareTo(this.getId())==0){
                return 0;
            }
        }
        return 1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPrestamosActivos() {
        return prestamosActivos;
    }

    public void setPrestamosActivos(Integer prestamosActivos) {
        this.prestamosActivos = prestamosActivos;
    }
    
}
