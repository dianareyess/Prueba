/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba2;

/**
 *
 * @author Diana Reyes Luis
 */
public class Prueba2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Clasecita.metodoClase();

    }
    
}





class Clasecita {
    public Integer VariableInstancia;
    
    public static Integer variableClase;
    
    public void metodoIntsancia(){
    System.out.println("MetodoInstancia");

    }
    
    public void metodoClase(){
    System.out.println("MetodoClase");

    }
}

interface Interfaz {
    //public static void metodoClase(){}
}

//
//La interfaz no permite implementar sino definir
