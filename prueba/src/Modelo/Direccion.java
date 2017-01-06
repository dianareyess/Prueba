/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Objetos.TipoDireccion;

/**
 *
 * @author Diana Reyes Luis
 */
public class Direccion {
    private TipoDireccion tipo;
    private String calle;
    private String noExterior;
    private String noInterior;
    private String colonia;
    private String cp;
    private String municipio;

    public Direccion(TipoDireccion tipo, String calle, String noExterior, String noInterior, String colonia, String cp, String municipio) {
        this.tipo = tipo;
        this.calle = calle;
        this.noExterior = noExterior;
        this.noInterior = noInterior;
        this.colonia = colonia;
        this.cp = cp;
        this.municipio = municipio;
        validar();
    }
    
    
    
   /* public void validar() {
        boolean resultado = true;
        resultado = resultado && cp.matches("^[0-9]{5}$");   
        resultado = resultado && calle.matches("^[A-Z.]*$");
        return resultado;
    }*/
    
    public void validar() {
         
    }
    
    public TipoDireccion getTipo() {
        return tipo;
    }

    public void setTipo(TipoDireccion tipo) {
        this.tipo = tipo;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNoExterior() {
        return noExterior;
    }

    public void setNoExterior(String noExterior) {
        this.noExterior = noExterior;
    }

    public String getNoInterior() {
        return noInterior;
    }

    public void setNoInterior(String noInterior) {
        this.noInterior = noInterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    
    
    
    
}
