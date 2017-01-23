/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Modelo.Persona;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Diana Reyes Luis
 */
public class BaseDatos {

    private ArrayList<Persona> db;

    public BaseDatos() {
        db = new ArrayList<>();
    }

    public void agregar(Persona p) {
        db.add(p);
    }

    public void guardar() {
        File file = new File("contribuyentes.dat");
        FileOutputStream output;
        try {
            output = new FileOutputStream(file);
            ObjectOutputStream writer = new ObjectOutputStream(output);

            writer.writeObject(db);

            writer.close();
            output.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
