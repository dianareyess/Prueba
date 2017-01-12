/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import exceptions.FechaInvalidaException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
/**
 *
 * @author Usuario
 */
public class Fecha implements Comparable{
    private Integer dia;
    private Integer mes;
    private Integer anio;
    private DayOfWeek diaDeLaSemana;
    public Fecha(Integer d, Integer m, Integer a) throws FechaInvalidaException{
        if(!validarFecha(d,m,a)){
            throw new FechaInvalidaException();
        }
        dia=d;
        mes=m;
        anio=a;
        diaDeLaSemana=LocalDate.of(anio, mes, dia).getDayOfWeek();
    }
    
    public Fecha(){
        this.dia=LocalDate.now().getDayOfMonth();
        this.mes=LocalDate.now().getMonthValue();
        this.anio=LocalDate.now().getYear();
        this.diaDeLaSemana=LocalDate.now().getDayOfWeek();
    }
    public void setDia(Integer d){
        dia=d;
    }
    public void setMes(Integer m){
        mes=m;
    }
    public void setAnio(Integer a){
        anio=a;
    }
    public Integer getDia(){
        return dia;
    }
    public Integer getMes(){
        return mes;
    }
    public Integer getAnio(){
        return anio;
    }
    public static boolean validarFecha(Integer d, Integer m, Integer a){
        if(((m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12) && d<=31) && d>=1){
            return true;
        }
        if(((m==4 || m==6 || m==9 || m==11) && d<=30) && d>=1){
            return true;
        }
        if(a%4==0){
            if(m==2 && d<=29 && d>=1){
                return true;
            }
        }
        else{
            if(m==2 && d<=28 && d>=1){
                return true;
            }
        }
        return false;
    }
    public void adelantar(){
        dia++;
        if((mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12) && dia>31){
            mes++;
            dia=1;
        }
        if((mes==4 || mes==6 || mes==9 || mes==11) && dia>30){
            mes++;
            dia=1;
        }
        if(anio%4==0){
            if(mes==2 && dia>29){
                mes++;
                dia=1;
            }
        }
        else{
            if(mes==2 && dia>28){
                mes++;
                dia=1;
            }
        }
        if(mes==13){
            anio++;
            mes=1;
        }
        this.diaDeLaSemana=LocalDate.of(anio, mes, dia).getDayOfWeek();
    }
    public void retrasar(){
        dia--;
        if(dia==0){
        if(mes==1 || mes==2 || mes==4 || mes==6 || mes==8 || mes==9 || mes==11){
            mes--;
            dia=31;
        }
        if(mes==5 || mes==7 || mes==10 || mes==12){
            mes--;
            dia=30;
        }
        if(anio%4==0){
            if(mes==3){
                mes--;
                dia=29;
            }
        }
        else{
            if(mes==3){
                mes--;
                dia=28;
            }
        }
        if(mes==0){
            anio--;
            mes=12;
        }
        }
    }
    @Override
    public int compareTo(Object t){
        int acum1=0,acum2=0;
        int[] dds={0,31,28,31,30,31,30,31,31,30,31,30,31};
        Fecha f=(Fecha)t;
        for(int i=1;i<mes;i++){
            if(i==2 && anio%4==0)
                acum1+=dds[i]+1;
            else
                acum1+=dds[i];
        }
        for(int i=1;i<f.getMes();i++){
            if(i==2 && f.getAnio()%4==0)
                acum2+=dds[i]+1;
            else
                acum2+=dds[i];
        }
        return (anio*365+acum1+dia)-(f.getAnio()*365+acum2+f.getDia());
    }
    public Fecha diferencia(Fecha f){
        int[] dds={0,31,28,31,30,31,30,31,31,30,31,30,31};
        if(this.compareTo(f)>=0){
            if(dia<f.getDia()){
                dia+=dds[mes];
                mes--;
            }
            if(mes<f.getMes()){
                mes+=12;
                anio--;
            }
            dia-=f.getDia();
            mes-=f.getMes();
            anio-=f.getAnio();
        }
        else{
            if(f.getDia()<dia){
                f.setDia(f.getDia()+dds[mes]);
                f.setMes(f.getMes()-1);
            }
            if(f.getMes()<mes){
                f.setMes(f.getMes()+12);
                f.setAnio(f.getAnio()-1);
            }
            dia=f.getDia()-dia;
            mes=f.getMes()-mes;
            anio=f.getAnio()-anio;
        }
        return this;
    }

    public DayOfWeek getDiaDeLaSemana() {
        return diaDeLaSemana;
    }

    public void setDiaDeLaSemana(DayOfWeek diaDeLaSemana) {
        this.diaDeLaSemana = diaDeLaSemana;
    }
    
    public String toString(){
        return dia+"/"+mes+"/"+anio;
    }
}
