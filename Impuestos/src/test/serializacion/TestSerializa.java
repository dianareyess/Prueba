/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.serializacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author princessdiana
 */
public class TestSerializa {
    
    public static void main() { 
        
        ArrayList<Alumno> alumno = new ArrayList <>();
        Integer opcion = 0;
        Scanner teclado = new Scanner(System.in);
        File file = new File("Calificaciones.dat");
        
        
        int registro = 0;
        do {
            
            System.out.println("1.Agregar");
            System.out.println("2.Modificar");
            System.out.println("3.Eliminar");
            System.out.println("4.Listar");
            System.out.println("5.Guardar");
            System.out.println("6.Cargar");
            System.out.println("7.Salir");
            System.out.println("8.¿Que desea hacer?");

            opcion = teclado.nextInt();
            switch (opcion){
                case 1:
                    System.out.print("Nombre:");
                    String nombre  = teclado.nextLine();
                    System.out.print("Edad:");
                    Integer edad  = teclado.nextInt();
                    System.out.print("Calificacion:");
                    Float calificacion  = teclado.nextFloat();
                    Alumno alumnito = new Alumno(nombre,edad,calificacion);
                    alumno.add(alumnito);
                    break;
                case 2:
                    System.out.println("Que registro?");
                    Alumno alumnoModificar = alumno.get(registro);
                    System.out.print("Nombre:");
                    alumnoModificar.setNombre(teclado.next());
                    System.out.print("Edad:");
                    alumnoModificar.setEdad(teclado.nextInt());
                    System.out.print("Calificacion:");
                    alumnoModificar.setCalificacion(teclado.nextFloat());
                    break;      
                case 3:
                    System.out.println("Que registro?");
                    registro = teclado.nextInt();
                    alumno.remove(registro);
                    break; 
                case 4:
                    int i = 0;
                    for (Alumno alumnos : alumno) {
                        System.out.println();
                        
                    }
                    break;
                
            }

            
        }while(opcion != 7);
            
                               
     }
    
    
    public static void leerArrayList() throws FileNotFoundException, IOException, ClassNotFoundException { 
        
        File file = new File("alumnitos colection.dat");
        FileInputStream input = new FileInputStream(file);
        ObjectInputStream reader = new ObjectInputStream(input);
        
        ArrayList<Alumno> loquesea = (ArrayList<Alumno>)reader.readObject();
        
        for(Alumno alumno : loquesea) {
            System.out.println(alumno);
        }
        
        input.close();
        reader.close();
                    
     }
    
    public static void escribirArrayList() throws FileNotFoundException, IOException, ClassNotFoundException { 
        
        ArrayList<Alumno> alumnitos = new ArrayList<>();
        Alumno diana = new Alumno("Diana", 19, (float)6);
        Alumno hannia = new Alumno("Hannia", 19, (float)7);
        Alumno carlos = new Alumno("Carlos", 20, (float)8);
        
        alumnitos.add(diana);
        alumnitos.add(hannia);
        alumnitos.add(carlos);
       
        
        File file = new File("alumnitos colection.dat");
        FileOutputStream output = new FileOutputStream(file);
        ObjectOutputStream writer = new ObjectOutputStream(output);
                
        output.close();
        writer.close();
                    
     }
    
    
    
    
    public static void leerObjetos() throws FileNotFoundException, IOException, ClassNotFoundException{
         File file = new File("pichones.dat");
         FileInputStream input = new FileInputStream(file);
         ObjectInputStream reader = new ObjectInputStream(input);
         
         
         while (input.available() > 0){
             Alumno obj = (Alumno)reader.readObject();
         System.out.println(obj);
         }           
     }
    
     public static void escribirObjetos() throws FileNotFoundException, IOException{
         Alumno diana = new Alumno("Diana", 19, (float)6);
         Alumno hannia = new Alumno("Hannia", 19, (float)7);
         Alumno carlos = new Alumno("Carlos", 20, (float)8);
         
         File file = new File("pichones.dat");
         FileOutputStream output = new FileOutputStream(file);
         ObjectOutputStream writer = new ObjectOutputStream(output);
         
         writer.writeObject(diana);
         
         writer.close();
         output.close();

     }
}
