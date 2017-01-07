/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impuestos;

import Excepciones.RFCException;
import Objetos.Fecha;
import Objetos.RFC;
import Objetos.TipoPersona;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Diana Reyes Luis
 */
public class Impuestos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RFCException {
        
        RFC rfc = new RFC("RFF810904815", TipoPersona.MORAL);
        System.out.println(rfc);
        
        /**String cadena = "";
        boolean b = cadena.matches();
        System.out.println(b);
        
         /*Fecha.agregarDiaInhabil(new Fecha (1,1,2016));
         Fecha.agregarDiaInhabil(new Fecha (6,1,2016));
         Fecha.agregarDiaInhabil(new Fecha (21,11,2016));
         
         Fecha fecha1 = new Fecha(4,1, 2017);
         fecha1.incrementarDiaHabil(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
         
         System.out.println(fecha1);
   
        /*
        Fecha fecha1 = new Fecha (1,1,2016);
        Fecha fecha2 = new Fecha (4,5,2016);
        System.out.println(fecha1);
        System.out.println(fecha2);
        

        
        //System.out.println(Fecha.estatica);
        
        Fecha diana = new Fecha(28,04,1997);
        Fecha omar = new Fecha(22,04,1997);
        
        System.out.println(diana.compareTo(omar));
        System.out.println(omar.compareTo(diana));

        System.out.println(diana);
        System.out.println(omar);
        
        System.out.println(diana.estatica);
        diana.estatica = 7;
        System.out.println(omar.estatica);

        //System.out.println(f.fechaValidar()); 
        
        ArrayList<Fecha> fechasInhabiles = new ArrayList<Fecha>();
        
        fechasInhabiles.add(new Fecha (1,1,2017));
        fechasInhabiles.add(new Fecha (5,2,2017));
        
        for (Fecha fechasInabile : fechasInhabiles) {
            System.out.println(fechasInhabiles);
        }
        
        HashSet<Fecha> fechas = new HashSet<>();
        
        fechasInhabiles.add(new Fecha (1,1,2017));
        fechasInhabiles.add(new Fecha (5,2,2017));
        
        boolean t = fechas.contains(omar)
        
        for (Fecha fecha : fechas) {
            System.out.println(fecha);
        }
    */
    }
    
}
