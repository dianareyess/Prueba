/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Usuario
 */
public class MaximoDePrestamosAlcanzadoException extends Exception {

    /**
     * Creates a new instance of
     * <code>MaximoDePrestamosAlcanzadoException</code> without detail message.
     */
    public MaximoDePrestamosAlcanzadoException() {
    }

    /**
     * Constructs an instance of
     * <code>MaximoDePrestamosAlcanzadoException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public MaximoDePrestamosAlcanzadoException(String msg) {
        super(msg);
    }
}
