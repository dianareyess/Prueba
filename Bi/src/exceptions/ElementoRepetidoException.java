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
public class ElementoRepetidoException extends Exception {

    /**
     * Creates a new instance of <code>ElementoRepetidoException</code> without
     * detail message.
     */
    public ElementoRepetidoException() {
    }

    /**
     * Constructs an instance of <code>ElementoRepetidoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ElementoRepetidoException(String msg) {
        super(msg);
    }
}
