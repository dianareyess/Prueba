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
public class PersonaNoEncontradaException extends Exception {

    /**
     * Creates a new instance of <code>PersonaNoEncontradaException</code>
     * without detail message.
     */
    public PersonaNoEncontradaException() {
    }

    /**
     * Constructs an instance of <code>PersonaNoEncontradaException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public PersonaNoEncontradaException(String msg) {
        super(msg);
    }
}
