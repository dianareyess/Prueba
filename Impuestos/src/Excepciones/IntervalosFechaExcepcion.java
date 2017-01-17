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
public class IntervalosFechaExcepcion extends Exception {
    
    /**
     * Creates a new instance of <code>IntervalosFechaException</code> without
     * detail message.
     */
    public IntervalosFechaExcepcion() {
    }

    /**
     * Constructs an instance of <code>IntervalosFechaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public IntervalosFechaExcepcion(String msg) {
        super(msg);
    }
    
}
