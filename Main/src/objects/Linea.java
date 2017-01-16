/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.awt.Graphics;

/**
 *
 * @author diana
 */
public class Linea implements Dibujable{
    
    private Punto origen;
    private Punto destino;
    
    public Linea(Punto a, Punto b){
        origen = a;
        destino = b;   
    }
    
    public Linea(Integer x1, Integer y1, Integer x2, Integer y2){
        origen = new Punto(x1, y1);
        destino = new Punto (x2, y2);
    }
    
    public void dibujar(Graphics g){
        origen.dibujar(g);
        destino.dibujar(g);
        g.drawLine(origen.getX(), origen.getY(), destino.getX(), destino.getY());
    }
    
    public Sentido comparar(Punto p){
        
        Punto p1 = new Punto(destino.getX()- origen.getX(), destino.getX()- origen.getY());
        Punto p2 = new Punto(p.getX()-origen.getY(), p.getY()-origen.getY());
        return p1.compara(p2);
    }
    
    public boolean onSegment(Linea l, Punto p){
        boolean evX = (Math.min(l.getOrigen().getX(), l.getDestino)
    }
    
    public boolean isIntersecta(Linea l){
        
        Sentido d1 = this.comparar(l.getOrigen());
        Sentido d2 = this.comparar(l.getDestino());
        Sentido d3 = l.comparar(this.getOrigen());
        Sentido d4 = l.comparar(this.getDestino());
         
        if((d1== Sentido.CLOCKWISE) && (d2== Sentido.COUNTERCLOCKWISE))
            || ((d1 == Sentido.COUNTERCLOCKWISE) && (d2 == Sentido.CLOCKWISE)))
            && (((d3 == Sentido.CLOCKWISE) && (d4 == Sentido.COUNTERCLOCKWISE))
            || ((d3 == Sentido.COUNTERCLOCKWISE) && (d4 == Sentido.CLOCKWISE))){
        return true;
    }
        
        if ((d1 == Sentido.CLOCKWISE) && onSegment(this, l.getOrigen())){
            return true;
        } else if 
        
        
        return true;
    }
    
    public Punto 

    public Punto getOrigen() {
        return origen;
    }

    public void setOrigen(Punto origen) {
        this.origen = origen;
    }

    public Punto getDestino() {
        return destino;
    }

    public void setDestino(Punto destino) {
        this.destino = destino;
    }
    
    
}
