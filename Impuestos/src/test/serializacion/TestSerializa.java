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
    
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        ArrayList<Alumno> alumnos = new ArrayList<>();
        Integer opcion = 0;
        Scanner teclado = new Scanner(System.in);
        
        int registro = 0;
        do{
            System.out.println("1. Agregar");
            System.out.println("2. Modificar");
            System.out.println("3. Eliminar");
            System.out.println("4. Listar");
            System.out.println("5. Guardar");
            System.out.println("6. Cargar");
            System.out.println("7. Salir");
            System.out.println("¿Que quieres hacer?");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Nombre:");
                    String nombre = teclado.next();
                    System.out.print("Edad:");
                    Integer edad = teclado.nextInt();
                    System.out.print("Calificacion:");
                    Float cal = teclado.nextFloat();
                    Alumno alumnito = new Alumno(nombre, edad, cal);
                    alumnos.add(alumnito);
                    break;
                case 2:
                    System.out.println("¿que registro?");
                    registro = teclado.nextInt();
                    Alumno alumnoModificar = alumnos.get(registro);
                    System.out.println("Nombre:");
                    alumnoModificar.setNombre(teclado.next());
                    System.out.print("Edad:");
                    alumnoModificar.setEdad(teclado.nextInt());
                    System.out.print("Calificacion:");
                    alumnoModificar.setCalificacion(teclado.nextFloat());
                    break;
                case 3:
                    System.out.println("¿que registro?");
                    registro = teclado.nextInt();
                    alumnos.remove(registro);
                    break;
                case 4:
                    int i = 0;
                    for (Alumno alumno : alumnos) {
                        System.out.println((i++)+".- "+alumno);
                    }
                    break;
                case 5:
                    escribirCalificaciones(alumnos);
                    break;
                case 6:
                    alumnos = cargarCalificaciones();
                    break;
                case 7:
                    break;
                default:
                    throw new AssertionError();
            }
        }while(opcion != 7);
        
        
    }
    
    
    public static void escribirCalificaciones(ArrayList<Alumno> arreglo) throws FileNotFoundException, IOException{
        File file = new File("calificaciones.dat");
        FileOutputStream output = new FileOutputStream(file);
        ObjectOutputStream writer = new ObjectOutputStream(output);
        
        writer.writeObject(arreglo);
        
        writer.close();
        output.close();
                       
    }
    
    public static ArrayList<Alumno> cargarCalificaciones() throws FileNotFoundException, IOException, ClassNotFoundException{
        
        File file = new File("calificaciones.dat");
        FileInputStream input = new FileInputStream(file);
        ObjectInputStream reader = new ObjectInputStream(input);
        
        ArrayList<Alumno> retorno = (ArrayList<Alumno>)reader.readObject();
     
        return retorno;
    }
    
    
    public static void leerColleccion() throws FileNotFoundException, IOException, ClassNotFoundException {
        
        File file = new File("alumnitosColeccion.dat");
        FileInputStream input = new FileInputStream(file);
        ObjectInputStream reader = new ObjectInputStream(input);
        
        ArrayList<Alumno> loquesea = (ArrayList<Alumno>)reader.readObject();
              
        for (Alumno alumno : loquesea) {
            System.out.println(alumno);
        }
        
        input.close();
        reader.close();
    }
    
    
    
    public static void escribirColeccion() throws FileNotFoundException, IOException {
        
        ArrayList<Alumno> alumnitos = new ArrayList<>();
        Alumno fernando = new Alumno("Fernando", 20, (float)5.95);
        Alumno cesar = new Alumno("Cesar", 20, (float)5.96);
        Alumno omar = new Alumno("Omar", 21, (float)9.5);
        Alumno diana = new Alumno("Diana", 19, (float)9.5);
        Alumno juan = new Alumno("Juan", 22, (float)9.5);
        
        alumnitos.add(fernando);
        alumnitos.add(cesar);
        alumnitos.add(omar);
        alumnitos.add(juan);
        alumnitos.add(diana);
        
        File file = new File("alumnitosColeccion.dat");
        FileOutputStream output = new FileOutputStream(file);
        ObjectOutputStream writer = new ObjectOutputStream(output);
               
        writer.writeObject(alumnitos);
        
        writer.close();
        output.close();
        
        
        
        
    }
    
    
    
    
    public static void leerObjetos() throws FileNotFoundException, IOException, ClassNotFoundException {
        
        File file = new File("pichones.dat");
        FileInputStream input = new FileInputStream(file);
        ObjectInputStream reader = new ObjectInputStream(input);
        
        while (input.available() > 0){
            Alumno obj = (Alumno)reader.readObject();
            System.out.println(obj);            
        }

    }
    
    public static void escribirObjetos() throws FileNotFoundException, IOException {
        Alumno fernando = new Alumno("Fernando", 20, (float)5.95);
        Alumno cesar = new Alumno("Cesar", 20, (float)5.96);
        Alumno omar = new Alumno("Omar", 21, (float)9.5);
        
        File file = new File("pichones.dat");
        FileOutputStream output = new FileOutputStream(file);
        ObjectOutputStream writer = new ObjectOutputStream(output);
        
        writer.writeObject(fernando);
        writer.writeObject(cesar);
        writer.writeObject(omar);
        
        writer.close();
        output.close();
        
    }
    
}
