/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia.excepciones;

/**
 * Clase de excepcion en la capa de acceso a datos
 * @author kim, marki, elmer, yorx
 */
public class DAOException extends Exception {
    
    /**
     * Constructor que recibe un mensaje
     * @param message Mensaje de la excepcion
     */
    public DAOException(String message) {
        super(message);
    }
    
    /**
     * Regresa el mensaje de la excepcion
     * @return Mensaje de la excepcion
     */
    @Override
    public String getMessage() {
        return super.getMessage();
    }

}
