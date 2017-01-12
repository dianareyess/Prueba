/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import controller.Controller;
import exceptions.EjemplarNoPrestableException;
import exceptions.ElementoRepetidoException;
import exceptions.FechaInvalidaException;
import exceptions.LibroYaPrestadoException;
import exceptions.MaximoDePrestamosAlcanzadoException;
import gui.MainFrame;
import model.Alumno;
import model.Carrera;
import model.Editorial;
import model.Libro;

/**
 *
 * @author Usuario
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FechaInvalidaException, ElementoRepetidoException, EjemplarNoPrestableException, MaximoDePrestamosAlcanzadoException, LibroYaPrestadoException{
        // TODO code application logic here
        MainFrame frame=new MainFrame();
        /*Fecha fecha= new Fecha();
        Calendario calendario=Calendario.getInstance();
        System.out.println(calendario.avanzar(fecha,3));
        Alumno alumno=new Alumno("1234","Alumno","1","1",Carrera.AMBIENTAL);
        Alumno alumno2=new Alumno("1234","Alumno","1","2",Carrera.AMBIENTAL);
        Libro libro=new Libro("Libro", "Alguien", Editorial.PORRUA, "0001", 2);
        Controller controller=new Controller();
        controller.altaPersona(alumno);
        controller.altaPersona(alumno2);
        controller.altaLibro(libro);
        controller.darPrestamo(alumno, libro);
        controller.darPrestamo(alumno2, libro);*/
    }
    
}
