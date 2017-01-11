/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Diana Reyes Luis
 */

public class Fecha {
	
	private Integer anio;
	private Integer mes;
	private Integer dia;
        
        public Integer DiferenciaAnios() {
            Fecha fechaActual = new Fecha();
            int anios = fechaActual.getAnio() - this.getAnio();
            if (this.getMes() > fechaActual.getMes()){
                anios--;
            } else if ((fechaActual.getMes() == this.getMes())&&(fechaActual.getDia() > this.getDia())) {
                anios--;
            }
            return anios;
        }
        
        
	
	public Fecha (Integer dia, Integer mes, Integer ano) {
		this.dia = dia;
		this.mes = mes;
		this.anio = ano;
	}
	
	public Fecha () {
		
		Calendar calendar = Calendar.getInstance();
		anio = calendar.get(Calendar.YEAR);
		mes = calendar.get(Calendar.MONTH);
		dia = calendar.get(Calendar.DAY_OF_MONTH);
		
	}
	
	public void toString(Fecha f) {
		
		System.out.println(f.getDia()+"/"+f.getMes()+"/"+f.getAnio());
	}
	
	public boolean fechaValida () {
		if (anio >= 1910 && anio <= 2100) {
			if (mes >= 1 && mes <= 12) {
				switch (mes) {
				case 1: case 3: case 5: case 7: case 9: case 11:
					if (dia >= 1 && dia <= 30) {
						return true;
					}
				case 2:  
					if (dia >= 1 && dia <= 28) {
						return true;
					}
					if (dia >= 1 && dia <= 29 && anio%4 == 0) {
						return true;
					}
					
				case 4: case 6: case 8: case 10: case 12:
					if (dia >= 1 && dia <= 31) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public Fecha sumarDias(Fecha f) {
		
		f.dia++;
		
		return f;
	}
	public Fecha restarDias(Fecha f) {
		
		f.dia--;
		
		return f;
	}
	public Fecha sumarDias(Fecha f, Integer n) {
		
		f.dia = f.dia + n;
		
		return f;
	}
	public Fecha restarDias(Fecha f, Integer n) {
		
		f.dia = f.dia - n;
		
		return f;
	}
	
	public void agregarDiaInhabil () {
		
		
		
	}
	
	public String diaSemana(Fecha f) {
		//d = ((A-1)%7 + ((A-1)/4-3*((A-1)/100+1)/4)%7 + M + D%7)%7 
		int A = f.anio;
		int M = f.mes;
		int D = f.dia;
		if (A%4 != 0) {
			switch (M) {
			case 1: 
				M = 0;
				break;
			case 2:
				M = 3;
				break;
			case 3:
				M = 3;
				break;
			case 4:
				M = 6;
				break;
			case 5:
				M = 1;
				break;
			case 6:
				M = 4;
				break;
			case 7:
				M = 6;
				break;
			case 8:
				M = 2;
				break;
			case 9:
				M = 5;
				break;
			case 10:
				M = 0;
				break;
			case 11:
				M = 3;
				break;
			case 12:
				M = 5;
				break;
			}
		}
		else {
			switch (M) {
			case 1: 
				M = 0;
				break;
			case 2:
				M = 3;
				break;
			case 3:
				M = 4;
				break;
			case 4:
				M = 0;
				break;
			case 5:
				M = 2;
				break;
			case 6:
				M = 5;
				break;
			case 7:
				M = 0;
				break;
			case 8:
				M = 3;
				break;
			case 9:
				M = 6;
				break;
			case 10:
				M = 1;
				break;
			case 11:
				M = 4;
				break;
			case 12:
				M = 6;
				break;
			}
		}
		int d = ((A-1)%7 + ((A-1)/4-3*((A-1)/100+1)/4)%7 + M + D%7)%7;
		switch (d) {
		case 0:
			return "Domingo";
		case 1:
			return "Lunes";
		case 2:
			return "Martes";
		case 3:
			return "Miercoles";
		case 4:
			return "Jueves";
		case 5:
			return "Viernes";
		case 6:
			return "Sabado";
		}
		return " ";
	}
	
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Integer getDia() {
		return dia;
	}
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	
}
