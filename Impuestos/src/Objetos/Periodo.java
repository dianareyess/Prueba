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
    
    @Override
    public String toString(){
        return tipoPeriodo.toString()+" "+ejercicio;
    }
    
    public Periodo next(){
        Integer ej = ejercicio;
        TipoPeriodo tp = tipoPeriodo.next();
        if (tp == null){
            ej++;
            tp = TipoPeriodo.getPeriodo(this.tipoPeriodo.getPeriodicidad(), new Fecha(1,1,ej));
        }
        Periodo resultado = new Periodo(tp, ej);

        
        return resultado;
    }

    public TipoPeriodo getTipoPeriodo() {
        return tipoPeriodo;
    }

    public void setTipoPeriodo(TipoPeriodo tipoPeriodo) {
        this.tipoPeriodo = tipoPeriodo;
    }

    public Integer getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Integer ejercicio) {
        this.ejercicio = ejercicio;
    }

    public Fecha getFechaLimitePago() {
        return fechaLimitePago;
    }

    public void setFechaLimitePago(Fecha fechaLimitePago) {
        this.fechaLimitePago = fechaLimitePago;
    }      
    
}