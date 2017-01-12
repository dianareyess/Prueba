/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import exceptions.ElementoNoEncontradoException;
import exceptions.ElementoRepetidoException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Coleccion<T> extends ArrayList<T>{

    public boolean agregar(Comparable e) throws ElementoRepetidoException{
        for (T obj : this) {
            Comparable t=(Comparable)obj;
            if(t.compareTo(e)==0){
                throw new ElementoRepetidoException();
            }
        }
        return super.add((T)e);
    }
    
    public boolean delete(Comparable e) throws ElementoNoEncontradoException{
        for (T obj : this) {
            Comparable t=(Comparable)obj;
            if(t.compareTo(e)==0){
                this.remove((T)e);
            }
        }
        throw new ElementoNoEncontradoException();
    }
    
    
}
