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
public interface Obligacion {
    
    public Float calculoImpuesto();
    public Float calculaRecargos();
    public Float totalPagar();
}
