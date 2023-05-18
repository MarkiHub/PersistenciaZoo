/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia.interfaces;

import ObjNegocio.Itinerario;
import java.util.List;
import org.bson.types.ObjectId;
import org.itson.persistencia.excepciones.DAOException;

/**
 * Interfaz de uso a acceso a datos de itinerarios
 *
 * @author kim, marki, elmer, yorx
 */
public interface IItinerariosDAO {

    /**
     * Inserta un itinerario en la base de datos
     *
     * @param iti Itinerario a insertar
     * @return Itinerario insertado
     * @throws org.itson.persistencia.excepciones.DAOException Si no puede insertar
     */
    public Itinerario insertar(Itinerario iti) throws DAOException;

    /**
     * Consulta los itinerarios del guia que tengan el mismo id dado en el
     * parametro
     *
     * @param id id del guia
     * @return Itinerarios del
     */
    public List<Itinerario> consultar(String id);

    /**
     * Consulta la existencia de un itinerario con el mismo nombre que el del
     * parametro
     *
     * @param nombre nombre del itinerario a buscar
     * @return Itinerario encontrado
     */
    public Itinerario consultarNombre(String nombre);

    /**
     * Consulta los itinerarios con un nombre similiar que el del parametro
     *
     * @param nombre Nombre del itinerario a buscar
     * @return Itinerarios encontrado
     */
    public List<Itinerario> consultarNombreSimilar(String nombre);
}
