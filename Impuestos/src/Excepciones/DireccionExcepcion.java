/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author princessdiana
 */
public class DireccionExcepcion extends Exception {

    
    private String mensaje;
    /**
     * Creates a new instance of <code>DireccionException</code> without detail
     * message.
     */
    public DireccionExcepcion() {
    }

    /**
     * Constructs an instance of <code>DireccionException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DireccionExcepcion(String msg) {
        super(msg);
        mensaje = msg;
    }
    
    public String getMensaje(){
        return mensaje;
    }
}
