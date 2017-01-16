/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Graphics;
import javax.swing.JFrame;
        
/**
 *
 * @author diana
 */
        
public class Pantalla extends JFrame {
    
    public Pantalla(){
        super("Titulo");
        setSize(500,600);
        setDefaultCloseOperation(JFrame,EXIT_ON_CLOSE);
        
        setVisible(true);
        
    }
    
    @Override
    public void paint(Graphics g){
        
        Punto p = new Punto(30, 30);
        p.dibujar(g);
        
        Punto p2 = new Punto();
        p2.dibujar(g);
        
        Punto p3 = new Punto(310, 430);
        p3.dibujar(g);
        
        Linea l = new Linea(50, 50, 400, 400)
        l.dibujar(g);       
        
        Linea l1 = new Linea(150, 250, 230, 270)
        l1.dibujar(g);
        
        Linea l2 = new Linea(250, 300, 330, 70)
        l2.dibujar(g);
        
        System.out.
    }
    
}
