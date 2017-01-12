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
public class LibroNoEncontradoException extends Exception {

    /**
     * Creates a new instance of <code>LibroNoEncontradoException</code> without
     * detail message.
     */
    public LibroNoEncontradoException() {
    }

    /**
     * Constructs an instance of <code>LibroNoEncontradoException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public LibroNoEncontradoException(String msg) {
        super(msg);
    }
}
