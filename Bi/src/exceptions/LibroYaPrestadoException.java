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
public class LibroYaPrestadoException extends Exception {

    /**
     * Creates a new instance of <code>LibroYaPrestadoException</code> without
     * detail message.
     */
    public LibroYaPrestadoException() {
    }

    /**
     * Constructs an instance of <code>LibroYaPrestadoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public LibroYaPrestadoException(String msg) {
        super(msg);
    }
}
