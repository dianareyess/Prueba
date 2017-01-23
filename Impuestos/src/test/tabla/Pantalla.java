/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.tabla;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import test.serializacion.Alumno;

/**
 *
 * @author princessdiana
 */
public class Pantalla extends JFrame{
    
    private JTable tblAlumnos;
    private Modelo modelo;
    private ArrayList<Alumno> alumnitos;
    
    private JButton agregar;
    private JButton seleccionar;
    
    
    public Pantalla(){
        super("Tablita");
        super.setSize(600, 400);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        alumnitos = new ArrayList<>();
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
        
        
        modelo = new Modelo(alumnitos);
        tblAlumnos = new JTable(modelo);
        
        
        
        
        agregar = new JButton("Agregar");
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 alumnitos.add(new Alumno("el mismo", 40, (float)9.7));
                 modelo.fireTableDataChanged();
            }
        });
        
        seleccionar = new JButton("Seleccionar");
        seleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Registro seleccionado "+tblAlumnos.getSelectedRow());
                Alumno a = alumnitos.get(tblAlumnos.getSelectedRow());
                System.out.println(a);
                a.setNombre("Change");
                modelo.fireTableDataChanged();
            }
        });
        
        super.add(agregar, BorderLayout.NORTH);
        super.add(seleccionar, BorderLayout.SOUTH);
        super.add(new JScrollPane(tblAlumnos));
        
        super.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        new Pantalla();
    }
}