/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author princessdiana
 */
public class Periodo {
    
    private TipoPeriodo tipoPeriodo;
    private Periodicidad periodicidad;
    private Fecha fechaLimitePago;

    public Periodo(TipoPeriodo tp, Periodicidad p) {
        tipoPeriodo = tp;
        periodicidad = p;

    }
    
    private void setFechaLimite() {
        //Calcular fecha limite y asignar a la fecha limite de pago
    }
    
    
}
