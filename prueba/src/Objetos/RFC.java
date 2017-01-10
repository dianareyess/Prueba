/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import excepciones.RFCException;


/**
 *
 * @author Diana Reyes Luis
 */
public class RFC {
    
    private String rfc;
    private TipoPersona tipoPersona;
    
    public RFC(String rfc, TipoPersona tipo) throws RFCException{
        this.tipoPersona = tipo;
        this.rfc = rfc.toUpperCase();
        if (!this.isValido()){
            throw new RFCException();
        }
    }
    
    public boolean isValido(){
        if (tipoPersona == TipoPersona.FISICA){
            return rfc.matches("^[A-Z]{4}(\\d{6})((\\D|\\d){3})?$");
        }else{
            return rfc.matches("^[A-Z]{3}(\\d{6})((\\D| \\d){3})?$");
        }
    }

    
    @Override
    public String toString(){
        return rfc;
    }
}

//INSTANCIA: Proceso de colocar el objeto en memoria, dandole un espacio, la sentencia da ese espacio New
//REFERENCIA: Direccion de ese espacio de memoria
//final c