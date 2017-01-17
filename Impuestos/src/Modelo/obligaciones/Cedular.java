/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.obligaciones;

/**
 *
 * @author princessdiana
 */
public class Cedular extends Impuestos {

    @Override
    public Float calculaRecargos() {
        return (float)2.0;
    }

    @Override
    public Float totalPagar() {
        return (float)1.0;
    }

    @Override
    public Float calculoImpuesto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
