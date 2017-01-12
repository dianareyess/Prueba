/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import exceptions.FechaInvalidaException;
import java.time.DayOfWeek;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Calendario {
    private static Calendario instance=null;
    private ArrayList<Fecha> diasInhabiles;
    
    private Calendario(){
        this.diasInhabiles=new ArrayList<>();
    }
    
    public static Calendario getInstance(){
        if(instance==null){
            instance= new Calendario();
        }
        return instance;
    }
    
    public boolean agregarDiaInhabil(Fecha diaInhabil){
        boolean flag=true;
        for (Fecha fecha : diasInhabiles) {
            if (diaInhabil.compareTo(fecha)==0){
                flag=false;
            }
        }
        if (flag){
            diasInhabiles.add(diaInhabil);
        }
        return flag; 
    }
    
    public boolean isDiaInhabil(Fecha fecha){
        if (fecha.getDiaDeLaSemana()==DayOfWeek.SATURDAY || fecha.getDiaDeLaSemana()==DayOfWeek.SUNDAY){
            return true;
        }
        for (Fecha diaInhabil : diasInhabiles) {
            if (diaInhabil.compareTo(fecha)==0){
                return true;
            }
        }
        return false;
    }
    
    public Fecha avanzar(Fecha fecha) throws FechaInvalidaException{
        Fecha f=new Fecha(fecha.getDia(),fecha.getMes(),fecha.getAnio());
        do{
            f.adelantar();
        }while(isDiaInhabil(f));
        return f;
    }
    
    public Fecha avanzar(Fecha fecha,int rep) throws FechaInvalidaException{
        Fecha fResultado=new Fecha(fecha.getDia(),fecha.getMes(),fecha.getAnio());
        for (int i = 0; i < rep; i++) {
            fResultado=avanzar(fResultado);
        }
        return fResultado;
    }
}
