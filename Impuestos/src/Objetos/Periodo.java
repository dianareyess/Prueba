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
    private Integer ejercicio;
    private Fecha fechaLimitePago;
    
    public Periodo(TipoPeriodo tp, Integer ejercicio){
        tipoPeriodo = tp;
        this.ejercicio = ejercicio;
    }
    
    private Fecha fechaCero(){
        tipoPeriodo.getMesFinal();
        Fecha f = new Fecha(17,tipoPeriodo.getMesFinal() + 1, ejercicio);
        f.incrementarDiaHabil(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
        return f;
    }
    
    public Fecha fechaLimite(Integer diasAdicionales){
        Fecha cero = fechaCero();
        for (int i = 0; i < diasAdicionales; i++) {
            cero.incrementarDiaHabil(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
        }
        return cero;
    }
    
    private void setFechaLimite(){
        
    }
    
}
