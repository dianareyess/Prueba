/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import Excepciones.RFCExcepcion;

/**
 *
 * @author princessdiana
 */
public class RFC {
    
    private String rfc;
    private TipoPersona tipoPersona;
    
    public RFC(String rfc, TipoPersona tipo) throws RFCExcepcion{
        this.tipoPersona = tipo;
        this.rfc = rfc.toUpperCase();
        if (!this.isValido()){
            throw new RFCExcepcion();
        }
    }
    
    public boolean isValido(){
        if (tipoPersona == TipoPersona.FISICA){
            return rfc.matches("^[A-Z]{4}(\\d{6})((\\D|\\d){3})?$");
        }else{
            return rfc.matches("^[A-Z]{3}(\\d{6})((\\D|\\d){3})?$");
        }
    }
    
    public String toString(){
        return rfc;
    }
}
