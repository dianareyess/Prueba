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
public class Punto {
    private Integer x;
    private Integer y;
    
    public Punto(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString(){
        return "["+x+","+y+"]";
    }
    
    public void getX(){
        this.x = x;
    }
    
    public Integer setX(Integer x){
        return x;
    }
    
    public void getY(){
        this.y = y;
    }
    
    public Integer setY(Integer y){
        return y;
    }

    void dibujar(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Sentido compara(Punto p2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
