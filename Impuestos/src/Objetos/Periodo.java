/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.time.DayOfWeek;

/**
 *
 * @author princessdiana
 */
public class Periodo {
    
    private TipoPeriodo tipoPeriodo;
    private Fecha fechaLimitePago;
    private ejercicio;

    public Periodo(TipoPeriodo tp) {
        tipoPeriodo = tp;
        this.ejercicio = ejercicio;

    }
    
    public Fecha fechaCero() {
        tipoPeriodo.getMesFinal();
        Fecha f = new Fecha (17,tipoPeriodo.getMesFinal() + 1, 2017);
        f.incrementarDiaHabil(DayOfWeek.SATURDAY, DayOfWeek)

    }
    
    private void setFechaLimite() {
        //Calcular fecha limite y asignar a la fecha limite de pago
    }
    
    
}
