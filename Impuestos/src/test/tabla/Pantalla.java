/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.tabla;

import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @author princessdiana
 */
public class Pantalla extends JFrame {
    private JTable tblAlumnos;
    private Modelo modelo;
    
    public Pantalla () {
        super("tablita");
        super.setSize(600,400);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        modelo = new Modelo();
        tblAlumnos = new JTable(modelo);
        
        super.add(new JScrollPanel(tblAlumnos));
    }
}
