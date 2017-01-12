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
public class Libro implements Comparable{
    private String titulo;
    private String autor;
    private Editorial editorial;
    private String isbn;
    private Integer ejemplar;
    private boolean prestado;

    public Libro(String titulo, String autor, Editorial editorial, String isbn,Integer ejemplar){
        this.titulo=titulo;
        this.autor=autor;
        this.editorial=editorial;
        this.isbn=isbn;
        this.ejemplar=ejemplar;
        this.prestado=false;
    }

    @Override
    public int compareTo(Object t) {
        if(t instanceof Libro){
            Libro libro=(Libro)t;
            if(libro.getIsbn()==this.getIsbn()&&libro.getEjemplar()==this.getEjemplar())
                return 0;
        }
        return 1;
    }
    
    public String toString(){
        return titulo+" - "+autor+" Ejemplar: "+ejemplar;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Integer ejemplar) {
        this.ejemplar = ejemplar;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
    
    
}
