/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.Date;

/**
 *
 * @author Diana Reyes Luis
 */
public class Fecha {
    private Integer dia;
    private Integer mes;
    private Integer anio;
    
    public Fecha (Integer dia, Integer mes, Integer anio){
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    
    public Fecha() {
        Date date = new Date();
        dia = date.getDay() + 1;
        mes = date.getMonth() + 1;
        anio = date.getYear() + 1900;
    }
    
    
    @Override
    public String toString() {
        return String.format("%d/%d/%d", dia, mes, anio);
    }
    
    public boolean fechaValidar() {
        int diaAuxiliar = 0;
        if ((getAnio()>=1900) && (getAnio()<=2100)){
            if ((getMes()>=1) && (getMes()<=12)){
                switch (getMes()){
                    case 1:
                    case 3:
                    case 7:
                    case 8:
                    case 10:
                    case 12: diaAuxiliar = 31;
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11: diaAuxiliar = 30;
                        break;
                    case 2: diaAuxiliar = anio % 4 == 0 ? 29:28;
                        break;
                }
                if ((getDia()>=1) && (getDia()<=diaAuxiliar)){
                    return true;
                }
            }
        } 
        return false;
    }
    
    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }
    
    
}


